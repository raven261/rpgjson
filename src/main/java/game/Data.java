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
    private static final String CONTAINER_FILE_LOCATION = "C:\\Users\\ravenalb\\IdeaProjects\\jsonTest\\src\\main\\java\\containers\\";


    void saveItem(Object item, String id){
            String file = ITEM_FILE_LOCATION + id + ".json";
            writeFile(file, item);
    }

    void savePC(Object pc, String id){
        String file = PC_FILE_LOCATION + id + ".json";
        writeFile(file, pc);
    }

    void saveRoom(Object room, String id){
        String file = ROOM_FILE_LOCATION + id + ".json";
        writeFile(file, room);
    }

    void saveContainers(Object container, String id){
        String file = CONTAINER_FILE_LOCATION + id + ".json";
        writeFile(file, container);
    }

    private void writeFile(String file, Object gameObject){
        try{
            FileWriter writer = new FileWriter(file);
            Gson gson = new Gson();
            String object = gson.toJson(gameObject);
            writer.write(object);
            writer.close();
            System.out.println(file + " saved");
        }catch(IOException e){
            e.getMessage();
        }
    }

    Room loadRoom(String id){
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

    Shop loadShop(String id){
        Gson gson = new Gson();
        String file = ROOM_FILE_LOCATION + id + ".json";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            return gson.fromJson(br, Shop.class);
        }catch(FileNotFoundException e){
            e.getMessage();
        }
        return null;
    }


    Character loadPC(String id){
        Gson gson = new Gson();
        String file = PC_FILE_LOCATION + id + ".json";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
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

    Container loadContainer(String id){
        Gson gson = new Gson();
        String file = CONTAINER_FILE_LOCATION + id + ".json";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            return gson.fromJson(br, Container.class);
        }catch(FileNotFoundException e){
            e.getMessage();
        }
        return null;
    }

}
