package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Created by ravenalb on 24-5-2017.
 */

public class Game {

    private Data data = new Data();
    private String currentRoom = "r2";

    private String rawAction = "start";
    private String[] actionArray = {};


    public static void main(String[] args){
        //createRooms();
        //new Game().createCharacter();
        //loadRoomJson("r2");
        //new Game().roomExits();
    }

    public void initializeGameData(){
        createRooms();
        System.out.println("rooms saved");
        createCharacter();

    }

    private void createRooms(){
        Room r1 = new Room(1, "test name", "Test description about the room.", "r2", "x", "r3", "x");
        Room r2 = new Room(2, "test 2 name", "test 2 description", "x", "r1", "x", "x");
        Room r3 = new Room(3, "test 3 name", "test 3 description", "x", "x", "x", "r1");
        data.saveRoomJson(r1, "r1");
        data.saveRoomJson(r2, "r2");
        data.saveRoomJson(r3, "r3");
    }

    private void createCharacter(){
        Character pc = new Character("name", "r1", 10);
        data.saveCharacterJson(pc, "pc");
    }

    public void getPlayerAction(String takeAction){
        rawAction = takeAction.toLowerCase();
        System.out.println("getPlayerAction: " + rawAction);
        stringToArray();
    }

    private void stringToArray(){
        actionArray = rawAction.split(" ");
    }

    public void performAction(){

        if(actionArray[0].equals("go")){
            if(returnRoomExits().contains(actionArray[1])){
                setCurrentRoom(returnExit(actionArray[1]));
            }
        }

        else {
            System.out.println("Unknown command");
        }
    }

    private void setCurrentRoom(String room){
        currentRoom = room;
    }

    public String returnRoomName(){
        return data.loadRoomJson(currentRoom).returnRoomName();
    }

    public String returnRoomDescription(){
        return data.loadRoomJson(currentRoom).returnRoomDescription();
    }

    private List gatherRoomExits(){
        HashMap exits = data.loadRoomJson(currentRoom).returnExits();
        List<String> exitKeys = new ArrayList<String>();
        for(Object o : exits.keySet()){
            if(!exits.get(o).toString().equals("x")){
                exitKeys.add(o.toString());
            }
        }
        return exitKeys;

    }

    public String returnRoomExits(){
        String allExits = "";
        for(Object s : gatherRoomExits()){
            allExits += s + "\n";
        }
        return allExits.replaceAll("\"", "");
    }

    private String returnExit(String exit){
        HashMap exits = data.loadRoomJson(currentRoom).returnExits();
        Object test = exits.get(exit);
        if(test.equals("x")){
            return "no exit";
        }else{
            return test.toString();}
    }

}
