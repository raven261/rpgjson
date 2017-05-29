import java.util.ArrayList;
import java.util.List;

/*
 * Created by ravenalb on 24-5-2017.
 */


public class Room {

    private String id;
    private String name;
    private String description;
    private List<String> ground = new ArrayList<String>();

    public Room(String id, String name, String desc){
        setId(id);
        setName(name);
        setDescription(desc);
        setItemOnGround();
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
        this.ground.add(0, "item1");
        this.ground.add(1,"item2");
    }

    private void createJsonObject(){

    }

    private void printRoom(){
        System.out.println(id);
        System.out.println(name);
        System.out.println(description);
        System.out.println(ground);
    }


    public static void main(String[] args){
        Room room1 = new Room("1", "test name", "Test description about the room.");
        room1.printRoom();
    }



}
