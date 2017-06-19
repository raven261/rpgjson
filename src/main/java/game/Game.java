package game;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Created by ravenalb on 24-5-2017.
 */

public class Game {

    //TODO: how to save the location in the character file?

    private Data data = new Data();
    private String currentLocation;
    private Room currentRoom;


    private List<String> currentRoomGroundItems = new ArrayList<String>();
    private String rawAction = "start";
    private String[] actionArray = {};
    private List<Room> allRooms = new ArrayList<Room>();
    private List<Item> allItems = new ArrayList<Item>();

    private Character pc = new Character();

    public static void main(String[] args){
        //new Game().saveCurrentRoom();
        //new Game().returnItemId("item1");
        new Game().createRooms();
        //new Game().createCharacter();
        //loadRoomJson("r2");
        //new Game().roomExits();
    }

    public void initializeGameData(){
        createItems();
        System.out.println("items saved");
        createRooms();
        System.out.println("rooms saved");
        createCharacter();
        setStartLocation();
    }

    void saveCurrentRoom(){
        data.saveRoom(this.currentRoom, this.currentRoom.returnId());
    }

    private void setPCLocation(){
        pc.location = currentRoom.returnId();
    }

    private void setStartLocation(){
        currentLocation = "r1";
        this.currentRoom = data.loadRoom(currentLocation);
    }

    private void createItems(){
        Item i1 = new Item("i1", "item1", "thing", "item1 description, ", 1, false, true);
        Item i2 = new Item("i2", "item2", "food", "item2 description", 5, true, true);
        Item gold = new Item("gold", "gold", "wealth", "a gold coin", 1, false, true);
        Item p1 = new Item("p1", "healing-potion", "potion", "Healing potion", 10, true, true);

        allItems.add(i1);
        allItems.add(i2);
        allItems.add(gold);
        allItems.add(p1);

        for(Item i : allItems){
            data.saveItem(i, i.returnItemId());
        }
    }

    private void createRooms(){
        Room r1 = new Room("r1", "test name", "Test description of the room.", "r2", "x", "r3", "x");
        Room r2 = new Room("r2", "test 2 name", "test 2 description", "x", "r1", "x", "x");
        Room r3 = new Room("r3", "test 3 name", "test 3 description", "x", "x", "x", "r1");

        allRooms.add(r1);
        allRooms.add(r2);
        allRooms.add(r3);

        for(Room r : allRooms){
            data.saveRoom(r, r.returnId());
        }
    }

    private void createCharacter(){
        Character pc = new Character("name", "r1", 10);

        data.savePC(pc, "pc");
    }

    public void getPlayerAction(String takeAction){
        rawAction = takeAction.toLowerCase();
        stringToActionArray();
    }

    private void stringToActionArray(){
        actionArray = rawAction.split(" ");
    }

    public void performAction(){
        String action = actionArray[0];
        String subject = actionArray[1];

        if(action.equals("go")){
            if(returnRoomExits().contains(subject)){
                setCurrentRoom(data.loadRoom(returnExit(subject)));
                setPCLocation();
                //setCurrentRoom(returnExit());
            }
        }
        else if(action.equals("inspect")){
            if(returnRoomItems().contains(subject)){

            }
        }
        else if(action.equals("take")){
            if(returnRoomItems().contains(subject)){
                //data.loadRoom(currentRoom.returnId()).removeItemFromGround(subject);
                removeItemFromRoom(subject);
                saveCurrentRoom();
            }
        }
        else if(action.equals("save")){
            if(returnRoomItems().equals("now")){
                System.out.println("action: " + this.currentRoom);
                saveCurrentRoom();
            }else{
                System.out.println("action: " + this.currentRoom);
                saveCurrentRoom();
            }
        }

        else {
            System.out.println("Unknown command");
        }
    }

    private void setCurrentRoom(Room room){
        currentRoom = room;
    }

    public String returnRoomName(){
        return data.loadRoom(currentRoom.returnId()).returnRoomName();
    }

    public String returnRoomDescription(){
        return data.loadRoom(currentRoom.returnId()).returnRoomDescription();
    }

    private List gatherRoomExits(){
        HashMap exits = data.loadRoom(currentRoom.returnId()).returnExits();
        List<String> exitKeys = new ArrayList<String>();
        for(Object o : exits.keySet()){
            if(!exits.get(o).toString().equals("x")){
                exitKeys.add(o.toString());
            }
        }
        return exitKeys;
    }

    public String returnRoomItems(){
        setCurrentRoomGroundItems();
        List items = data.loadRoom(currentRoom.returnId()).returnItems();
        String allItems = "";
        for(Object o : items){
            String itemName = data.loadItem(o.toString()).returnItemName();
            allItems += itemName + "\n";
        }
        return allItems.replaceAll("\"", "");
    }

    public String returnRoomExits(){
        String allExits = "";
        for(Object s : gatherRoomExits()){
            allExits += s + "\n";
        }
        return allExits.replaceAll("\"", "");
    }

    private String returnExit(String exit){
        HashMap exits = data.loadRoom(currentRoom.returnId()).returnExits();
        Object key = exits.get(exit);
        if(key.equals("x")){
            return "no exit";
        }else{
            return key.toString();}
    }

    private void setCurrentRoomGroundItems(){
        this.currentRoomGroundItems = currentRoom.returnItems();
    }

    private void removeItemFromRoom(String item){
        this.currentRoomGroundItems.remove(item);
        updateRoomItems();
    }

    private void updateRoomItems(){
        currentRoom.updateItems(currentRoomGroundItems);
    }
}
