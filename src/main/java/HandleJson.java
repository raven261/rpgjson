import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Created by ravenalb on 24-5-2017.
 */

public class HandleJson {

    private static final String ROOM_FILE_LOCATION = "C:\\Users\\ravenalb\\IdeaProjects\\jsonTest\\src\\main\\java\\rooms\\";
    private static final String PC_FILE_LOCATION = "C:\\Users\\ravenalb\\IdeaProjects\\jsonTest\\src\\main\\java\\";


    private int[][] world = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}
    };

    public static void main(String[] args){
        //createRooms();
        createCharacter();
        //loadRoomJson("r2");
    }

    private static void createRooms(){
        Room r1 = new Room(1, "test name", "Test description about the room.");
        Room r2 = new Room(2, "test 2 name", "test 2 description");
        Room r3 = new Room(3, "test 3 name", "test 3 description");
        saveRoomJson(r1, "r1");
        saveRoomJson(r2, "r2");
        saveRoomJson(r3, "r3");
    }

    private static void createCharacter(){
        Character pc = new Character("name", 0, 0, 10);
        saveCharacterJson(pc, "pc");
    }

    private static void saveRoomJson(Object room, String id){
        try{
            String file = ROOM_FILE_LOCATION + id + ".json";
            FileWriter writer = new FileWriter(file);
            Gson gson = new Gson();
            String object = gson.toJson(room);
            writer.write(object);
            writer.close();
            System.out.println("file saved");
        }catch(IOException e){
            e.getMessage();
        }
    }

    private static void saveCharacterJson(Object o, String id){
        try{
            String file = PC_FILE_LOCATION + id + ".json";
            FileWriter writer = new FileWriter(file);
            Gson gson = new Gson();
            String object = gson.toJson(o);
            writer.write(object);
            writer.close();
            System.out.println("file saved");
        }catch(IOException e){
            e.getMessage();
        }
    }

    private static void loadRoomJson(String id){
        Gson gson = new Gson();
        String file = ROOM_FILE_LOCATION + id + ".json";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Room currentRoom = gson.fromJson(br, Room.class);
            currentRoom.returnRoomName();
        }catch(FileNotFoundException e){
            e.getMessage();
        }
    }


}
