package be.ehb.matheodexelle.mygameslistv2;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class GamesFetchClass extends AsyncTask<String, String,String> {
    private static final String TAG = "GamesFetchClass";
    String strUrl = "http://api.steampowered.com/ISteamApps/GetAppList/v0002/?key=STEAMKEY&format=json";
    String strUrl2 = "https://store.steampowered.com/api/appdetails?appids=";
    String devJSON;
    String result;
    String result2;
    HttpURLConnection conSingleGame;
    HttpURLConnection conFullGame;
    ArrayList<Game> games;
    int appId;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        conSingleGame.disconnect();
        conFullGame.disconnect();
        super.onPostExecute(s);

    }

    @Override
    protected String doInBackground(String... strings) {

        try{
            URL url = new URL(strUrl);
            conSingleGame = (HttpURLConnection) url.openConnection();
            conSingleGame.setRequestMethod("GET");
            conSingleGame.connect();
            BufferedReader bf = new BufferedReader(new InputStreamReader(conSingleGame.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bf.readLine()) != null) {
                sb.append(line + "\n");
            }
            result = sb.toString();//bf.readLine();
            JSONObject jObject = new JSONObject(result);
            JSONArray jsonArray = jObject.getJSONObject("applist").getJSONArray("apps");
            games = new ArrayList<>();
            int i = 0;
            while(games.size() < 5){
                JSONObject element = (JSONObject) jsonArray.get(i);
                URL url2 = new URL(strUrl2 + element.getInt("appid"));
                conFullGame = (HttpURLConnection) url2.openConnection();
                HttpURLConnection.setFollowRedirects(true);
                conFullGame.setRequestMethod("GET");
                conFullGame.connect();
                BufferedReader bf2 = new BufferedReader(new InputStreamReader(conFullGame.getInputStream()));
                StringBuilder sb2 = new StringBuilder();
                String line2 = null;
                while ((line2 = bf2.readLine()) != null) {
                    sb2.append(line2 + "\n");
                }
                result2 = sb2.toString();
                //System.out.println(result2);
                JSONObject jObject2 = new JSONObject(result2);
                //get appid from GetAppList
                JSONObject jObject3 = jObject2.getJSONObject(element.getString("appid"));
                //create vars to check if success is true AND if it's a game
                String isGame;
                Boolean isSuccess = jObject3.getBoolean("success");
                if(!(jObject3.optJSONObject("data") == null)){
                    isGame = (jObject3.optJSONObject("data").optString("type"));
                }else{
                    isGame = "null";
                }
                /////WORK NEEDED
                System.out.println("is a "  + isGame);
                if(isSuccess) {
                        //This line of code clears the html contained in the string inside it
                        //String desc = android.text.Html.fromHtml(jObject3.getJSONObject("data").getString("type").toString()).toString();

                    StringBuilder sb3 = new StringBuilder();

                    if(jObject3.has("developers")){
                        System.out.println("JAAACKPOOOOOOT");
                        JSONArray devsArr = jObject3.getJSONArray("developers");
                        for(int j = 0; j < devsArr.length(); j++){
                            sb3.append(" " + devsArr.get(j).toString());

                        }
                        devJSON = sb3.toString();
                    }
                    else{
                        devJSON = null;
                    }
                    System.out.println(isGame);
                    if(isGame.equals("game")){
                        JSONObject jObject4 = jObject3.getJSONObject("data");
                        System.out.println("You got in here ! this is good !");
                        Game tempGame = new Game(element.getString("appid"),
                                jObject4.getString("name"),
                                jObject4.getString("type"),
                                jObject4.getString("short_description"),
                                jObject4.getString("detailed_description"),
                                jObject4.getString("about_the_game"),
                                jObject4.getBoolean("is_free"),
                                devJSON);
                        games.add(tempGame);
                        System.out.println(games.toString());
                    }

                }
                i++;
            }
            System.out.println(i);
            System.out.println(games.size());
            return null;
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
}
