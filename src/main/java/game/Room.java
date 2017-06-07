package game;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by ravenalb on 24-5-2017.
 */


public class Room {

    private Integer id;
    private String name;
    private String description;
    private List<String> ground = new ArrayList<String>();

    Room(Integer id, String name, String desc){
        setId(id);
        setName(name);
        setDescription(desc);
        setItemOnGround();
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

    String returnRoomName(){
        System.out.println("roomname: " + this.name);
        return this.name;
    }

    String returnRoomDescription(){
        System.out.println("roomdesc: " + this.description);
        return this.description;
    }

    public void printRoom(){
        System.out.println(id);
        System.out.println(name);
        System.out.println(description);
        System.out.println(ground);
    }


}
