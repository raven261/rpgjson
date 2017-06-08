package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Created by ravenalb on 24-5-2017.
 */


public class Room {

    private Integer id;
    private String name;
    private String description;
    private List<String> ground = new ArrayList<String>();
    private HashMap<String, String> exits = new HashMap<String, String>();

    Room(Integer id, String name, String desc, String n, String s, String e, String w){
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

    private void setId(Integer id){
        this.id = id;
    }

    private void setName(String name){
        this.name = name;
    }

    private void setDescription(String desc){
        this.description = desc;
    }

    private void setItemOnGround(){
        this.ground.add(0, "item1");
        this.ground.add(1,"item2");
    }

    private void setExit(String direction, String room){
        this.exits.put(direction, room);
    }

    HashMap returnExits(){
        return this.exits;
    }

    String returnRoomName(){
        return this.name;
    }

    String returnRoomDescription(){
        return this.description;
    }

    public void printRoom(){
        System.out.println(id);
        System.out.println(name);
        System.out.println(description);
        System.out.println(ground);
    }


}
