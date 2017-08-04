package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/*
 * Created by ravenalb on 24-5-2017.
 *
 *  all changes will be saved directly, no general save is possible in this version
 *  when loading a game it means that the current progress will be overwritten
 *
 *  Planned:
 *  - add containers
 *  - add monsters
 *  - add combat (weapons, armour, hp, xp)
 *  - add potions
 *
 *
 */


public class Game {

    private Data data = new Data();
    private String currentLocation;
    private Room currentRoom;


    private List<String> currentRoomGroundItems = new ArrayList<String>();
    private List<String> pcInventory = new ArrayList<String>();
    private int[] pcCoinPurse = new int[1];
    private String rawAction = "start";
    private String[] actionArray = {};


    private Character pc = new Character();
    private GameSetup gameSetup = new GameSetup();

    public static void main(String[] args){
        new Game().initializeGameData();
    }

    public void initializeGameData(){
        gameSetup.createItems();
        gameSetup.createCharacter();
        gameSetup.createContainers();
        gameSetup.createRooms();
        setStartLocation();
        setPcInventory();
        setPcCoinPurse();
    }

    private void saveCurrentRoom(){
        data.saveRoom(this.currentRoom, this.currentRoom.returnId());
    }

    private void savePc(){
        setPCLocation();
        data.savePC(pc, "pc");
    }

    private void setPCLocation(){
        pc.updateLocation(currentRoom.returnId());
    }

    private void setStartLocation(){
        currentLocation = "r1";
        this.currentRoom = data.loadRoom(currentLocation);
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
            }
        }
        else if(action.equals("inspect")){
            if(returnRoomItems().contains(subject)){
                //TODO: how to implement inspect?
                System.out.println("TODO");
            }
        }
        else if(action.equals("take")){
            if(returnRoomItems().contains(subject)){
                if(data.loadItem(subject).returnItemTakable()) {
                    if(subject.equals("gold")){
                        removeItemFromRoom(subject);
                        addItemToPcCoinPurse();
                        saveCurrentRoom();
                        savePc();
                    }
                    else {
                        removeItemFromRoom(subject);
                        addItemToPcInventory(subject);
                        saveCurrentRoom();
                        savePc();
                    }
                }
            }
        }
        else if(action.equals("drop")){
            if(pc.returnInventory().contains(subject)){
                removeItemFromPcInventory(subject);
                addItemToRoom(subject);
                savePc();
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

    public String returnPcInventory(){
        List items = data.loadPC("pc").returnInventory();
        String allItems = "";
        for(Object o : items){
            String itemName = data.loadItem(o.toString()).returnItemName();
            allItems += itemName + "\n";
        }
        return allItems.replaceAll("\"", "");
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

    public String returnCoinPurse(){
        return data.loadPC("pc").returnCoinPurseValue().toString();
    }

    private void setCurrentRoomGroundItems(){
        this.currentRoomGroundItems = currentRoom.returnItems();
    }

    private void removeItemFromRoom(String item){
        this.currentRoomGroundItems.remove(item);
        updateRoomItems();
    }

    private void addItemToRoom(String item){
        this.currentRoomGroundItems.add(item);
        updateRoomItems();
    }

    private void setPcInventory(){
        this.pcInventory = pc.returnInventory();
    }

    private void setPcCoinPurse(){
        this.pcCoinPurse[0] = data.loadPC("pc").returnCoinPurseValue();
    }

    private void updatePcInventory(){
        pc.updateInventory(pcInventory);
    }

    private void removeItemFromPcInventory(String item){
        this.pcInventory.remove(item);
        updatePcInventory();
    }

    private void addItemToPcInventory(String item){
        this.pcInventory.add(item);
        updatePcInventory();
    }

    private void addItemToPcCoinPurse(){
        Integer oldCoin = data.loadPC("pc").returnCoinPurseValue();
        Integer newCoin = oldCoin + 1;
        pc.updateCoinPurse(newCoin);
    }

    private void updateRoomItems(){
        currentRoom.updateItems(currentRoomGroundItems);
    }
}
