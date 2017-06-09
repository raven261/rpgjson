package game;

import com.google.gson.Gson;

import java.io.*;

/*
 * Created by ravenalb on 7-6-2017.
 */
class Data {

    private static final String ROOM_FILE_LOCATION = "C:\\Users\\ravenalb\\IdeaProjects\\jsonTest\\src\\main\\java\\rooms\\";
    private static final String PC_FILE_LOCATION = "C:\\Users\\ravenalb\\IdeaProjects\\jsonTest\\src\\main\\java\\";
    private static final String ITEM_FILE_LOCATION = "C:\\Users\\ravenalb\\IdeaProjects\\jsonTest\\src\\main\\java\\items\\";



    void saveRoomJson(Object room, String id){
        try{
            String file = ROOM_FILE_LOCATION + id + ".json";
            FileWriter writer = new FileWriter(file);
            Gson gson = new Gson();
            String object = gson.toJson(room);
            writer.write(object);
            writer.close();
        }catch(IOException e){
            e.getMessage();
        }
    }

    void saveCharacterJson(Object o, String id){
        try{
            String file = PC_FILE_LOCATION + id + ".json";
            FileWriter writer = new FileWriter(file);
            Gson gson = new Gson();
            String object = gson.toJson(o);
            writer.write(object);
            writer.close();
            System.out.println("character saved");
        }catch(IOException e){
            e.getMessage();
        }
    }

    void saveItems(Object o, String id){
        try{
            String file = ITEM_FILE_LOCATION + id + ".json";
            FileWriter writer = new FileWriter(file);
            Gson gson = new Gson();
            String object = gson.toJson(o);
            writer.write(object);
            writer.close();
            //System.out.println("item saved");
        }catch(IOException e){
            e.getMessage();
        }
    }

    Room loadRoomJson(String id){
        Gson gson = new Gson();
        String file = ROOM_FILE_LOCATION + id + ".json";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            return gson.fromJson(br, Room.class);
        }catch(FileNotFoundException e){
            e.getMessage();
        }
        return null;
    }


    Character loadPCJson(String id){
        Gson gson = new Gson();
        String file = PC_FILE_LOCATION + id + ".json";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //Room currentRoom = gson.fromJson(br, Room.class);
            //currentRoom.returnRoomName();
            return gson.fromJson(br, Character.class);
        }catch(FileNotFoundException e){
            e.getMessage();
        }
        return null;
    }

    Item loadItem(String id){
        Gson gson = new Gson();
        String file = ITEM_FILE_LOCATION + id + ".json";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            return gson.fromJson(br, Item.class);
        }catch(FileNotFoundException e){
            e.getMessage();
        }
        return null;
    }

}
