package game;

import com.google.gson.Gson;

import java.io.*;

/*
 * Created by ravenalb on 24-5-2017.
 */

public class Game {

    private Data data = new Data();
    private String currentRoom;

    private int[][] world = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}
    };

    public void main(String[] args){
        //createRooms();
        createCharacter();
        //loadRoomJson("r2");
    }

    public void initializeGameData(){
        createRooms();
        createCharacter();

    }

    private void createRooms(){
        Room r1 = new Room(1, "test name", "Test description about the room.");
        Room r2 = new Room(2, "test 2 name", "test 2 description");
        Room r3 = new Room(3, "test 3 name", "test 3 description");
        data.saveRoomJson(r1, "r1");
        data.saveRoomJson(r2, "r2");
        data.saveRoomJson(r3, "r3");
    }

    private void createCharacter(){
        Character pc = new Character("name", 0, 0, 10);
        data.saveCharacterJson(pc, "pc");
    }


}
