package be.ehb.matheodexelle.mygameslistv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private String id;
    private String name;
    private String type;
    private String short_desc;
    private String description;
    private String about;
    private boolean is_free;
    private String dev;
    //private String[] genres;


    public Game(String id, String name, String type, String short_desc, String description, String about, boolean is_free, String dev) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.short_desc = short_desc;
        this.description = description;
        this.about = about;
        this.is_free = is_free;
        this.dev = dev;
    }
    //Construct for test app class
    public Game(String id, String name, String description, boolean is_free, String dev) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.is_free = is_free;
        this.dev = dev;
    }
    //Getters & Setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_free() {
        return is_free;
    }

    public void setIs_free(boolean is_free) {
        this.is_free = is_free;
    }

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", short_desc='" + short_desc + '\'' +
                ", description='" + description + '\'' +
                ", about='" + about + '\'' +
                ", is_free=" + is_free +
                ", dev='" + dev + '\'' +
                '}';
    }

}
        /*
        unicode = new ArrayList<String>(){
            {
                add("\\u00e0");add("\\u00e2");add("\\u00e4");add("\\u00e7");add("\\u00e8");add("\\u00e9");add("\\u00ea");add("\\u00eb");add("\\u00ee");add("\\u00ef");add("\\u00f4");add("\\u00f6");add("\\u00f9");add("\\u00fb");add("\\u00fc");
            }
        };
        specChars = new ArrayList<String>(){
            {
                add("à");add("â");add("ä");add("ç");add("è");add("é");add("ê");add("ë");add("î");add("ï");add("ô");add("ö");add("ù");add("û");add("ü");
            }
        };
    private String formatDescription(String description){

        for(int i = 0; i < specChars.size(); i++){
            try{
                while(description.indexOf(unicode.get(i)) ){
                    description.indexOf(unicode.get(i))
                }
            }
            catch (IndexOutOfBoundsException e){

            }
        }

        return "";
    }
*/
