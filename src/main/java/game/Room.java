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
    private List<String> containers = new ArrayList<String>();
    private HashMap<String, String> exits = new HashMap<String, String>();

    Room(){}

    Room(String id, String name, String n, String s, String e, String w, List<String> ground, List<String> containers, String desc){
        setId(id);
        setName(name);
        setDescription(desc);
        setItemOnGround(ground);
        setContainersInRoom(containers);
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

    private void setItemOnGround(List<String> ground){
        this.ground = ground;
    }

    private void setContainersInRoom(List<String> container){this.containers = container;}

    private void setExit(String direction, String room){
        this.exits.put(direction, room);
    }

    HashMap returnRoomExits(){
        return this.exits;
    }

    String returnRoomId(){
        return this.id;
    }

    String returnRoomName(){
        return this.name;
    }

    List<String> returnItems(){
        return this.ground;
    }

    List<String> returnRoomContainers(){return this.containers;}

    String returnRoomDescription(){
        return this.description;
    }

    void updateItems(List<String> items){
        this.ground = items;
    }

    private void selectItemsForGround(){

    }


}
