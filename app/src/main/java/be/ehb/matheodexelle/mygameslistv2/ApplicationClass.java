package be.ehb.matheodexelle.mygameslistv2;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<Game> games;


    @Override
    public void onCreate() {
        super.onCreate();
        String longString = "This is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a descriptionThis is a description";
        games = new ArrayList<Game>();
        games.add(new Game("1","Counter-Strike:Global Offensive","This is a description", false, "Volvo"));
        games.add(new Game("2","Half-life 2",longString, false, "Volvo"));
        games.add(new Game("3","Portal 2","This is a description", false, "Volvo"));
        games.add(new Game("4","Overwatch","This is a description", false, "Volvo"));
        //games.add(new Game(5,"Undertale","This is a description", false, "Volvo"));
        //games.add(new Game(1,"Counter-Strike:Global Offensive","This is a description", false, "Volvo"));
        //games.add(new Game(2,"Half-life 2","This is a description", false, "Volvo"));
        //games.add(new Game(3,"Portal 2","This is a description", false, "Volvo"));
        //games.add(new Game(4,"Overwatch","This is a description", false, "Volvo"));
        //games.add(new Game(5,"Undertale","This is a description", false, "Volvo"));
        //games.add(new Game(1,"Counter-Strike:Global Offensive","This is a description", false, "Volvo"));
        //games.add(new Game(2,"Half-life 2","This is a description", false, "Volvo"));
        //games.add(new Game(3,"Portal 2","This is a description", false, "Volvo"));
        //games.add(new Game(4,"Overwatch","This is a description", false, "Volvo"));
        //games.add(new Game(5,"Undertale","This is a description", false, "Volvo"));


        //(id, name, description, isFree, dev)
    }
}


