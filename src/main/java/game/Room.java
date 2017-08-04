package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Created by ravenalb on 24-5-2017.
 */


public class Room {

    private String id;
    private String name;
    private String description;
    private List<String> ground = new ArrayList<String>();
    private HashMap<String, String> exits = new HashMap<String, String>();

    Room(String id, String name, String desc, String n, String s, String e, String w){
        setId(id);
        setName(name);
        setDescription(desc);
        setItemOnGround();
        setExit("north", n);
        setExit("south", s);
        setExit("east", e);
        setExit("west", w);

    }

    public static void main(String[] args){
    }

    private void setId(String id){
        this.id = id;
    }

    private void setName(String name){
        this.name = name;
    }

    private void setDescription(String desc){
        this.description = desc;
    }

    private void setItemOnGround(){
        this.ground.add("gold");
        this.ground.add("bread");
        this.ground.add("shadow");
        this.ground.add("stone");
        this.ground.add("potionH");
        this.ground.add("lockpick1");
        //this.ground.add("barrel1");

    }

    private void setExit(String direction, String room){
        this.exits.put(direction, room);
    }

    HashMap returnExits(){
        return this.exits;
    }

    String returnId(){
        return this.id;
    }

    String returnRoomName(){
        return this.name;
    }

    List<String> returnItems(){
        return this.ground;
    }

    String returnRoomDescription(){
        return this.description;
    }

    void updateItems(List<String> items){
        this.ground = items;
    }

    private void selectItemsForGround(){

    }


}
