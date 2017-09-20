package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Created by ravenalb on 24-5-2017.
 *
 *  all changes will be saved directly, no general save is possible in this version
 *  when loading a game it means that the current progress will be overwritten
 *
 */


public class Game {
    //TODO: unlocking locked containers
    //TODO: setup combat system
    //TODO: create shopping system
    //TODO: create quest system?
    //TODO: NPC's met dialoog?
    //TODO: create books?

    private Data data = new Data();
    private String currentLocation;
    private Room currentRoom;


    private List<String> currentRoomGroundItems = new ArrayList<String>();
    private List<String> currentRoomContainers = new ArrayList<String>();
    private List<String> pcInventory = new ArrayList<String>();
    private int[] pcCoinPurse = new int[1];
    private String rawAction = "start";
    private String[] actionArray = {};
    private String actionFeedback;
    private HashMap<String, Integer> currentShop = new HashMap<String, Integer>();


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
        data.saveRoom(this.currentRoom, this.currentRoom.returnRoomId());
    }

    private void savePc(){
        setPCLocation();
        data.savePC(pc, "pc");
    }

    private void setPCLocation(){
        pc.updateLocation(currentRoom.returnRoomId());
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
        try {
        String action = actionArray[0];
        String subject = actionArray[1];



            if (action.equals("go")) {
                if (returnRoomExits().contains(subject)) {
                    setCurrentRoom(data.loadRoom(returnExit(subject)));
                    setPCLocation();
                    updateActionFeedback("You went " + subject);
                }
            } else if (action.equals("inspect")) {
                // show description of specified item
                if (returnRoomItems().contains(subject)) {
                    //TODO: now items are retrieved with item name, should be actual id (for now id will be same as the name)
                    updateActionFeedback(data.loadItem(subject).returnItemDescription());
                } else if (returnRoomContainers().contains(subject)) {
                    updateActionFeedback(data.loadContainer(subject).returnContainerDescription());
                } else if (returnPcInventory().contains(subject)){
                    updateActionFeedback(data.loadItem(subject).returnItemDescription());
                }

            } else if (action.equals("take")) {
                // put specified item in inventory and remove from location
                if (returnRoomItems().contains(subject)) {
                    if (data.loadItem(subject).returnItemTakable()) {
                        if (subject.equals("gold")) {
                            removeItemFromRoom(subject);
                            addItemToPcCoinPurse();
                            saveCurrentRoom();
                            savePc();
                            updateActionFeedback("You took a gold coin");
                        } else {
                            removeItemFromRoom(subject);
                            addItemToPcInventory(subject);
                            saveCurrentRoom();
                            savePc();
                            updateActionFeedback("You took a " + subject);
                        }
                    }
                } else if (returnRoomContainers().contains(subject)) {
                    updateActionFeedback("You cannot pick up " + subject);
                }else {
                    updateActionFeedback("These is no such item here.");
                }
            } else if (action.equals("drop")) {
                //take specified item from inventory and put on ground of location
                if (pc.returnInventory().contains(subject)) {
                    removeItemFromPcInventory(subject);
                    addItemToRoom(subject);
                    savePc();
                    saveCurrentRoom();
                    updateActionFeedback(subject + " dropped");
                } else {
                    updateActionFeedback("You do not have that item in your inventory");
                }
            } else if (action.equals("look")) {
                updateActionFeedback("Looking for what?");
            } else if(action.equals("open")){
                if(returnRoomContainers().contains(subject)){
                    Container container = data.loadContainer(subject);
                    if(container.returnContainerIsClosed()){
                        if(container.returnContainerIsLocked()){
                            updateActionFeedback(subject + " is locked.");
                        }
                        //TODO: open container
                    }else{
                        updateActionFeedback(subject + " is already open.");
                    }
                }else{
                    updateActionFeedback("NO SUCH ITEM");
                }
            } else if(action.equals("search")){
                if(returnRoomContainers().contains(subject)){
                    Container container = data.loadContainer(subject);
                    if(container.returnContainerIsClosed()){
                        updateActionFeedback(subject + " is closed, you need to open it first.");
                    }else{
                        //TODO: search containers
                        // list item from specified container
                        updateActionFeedback("search action needs to be implemented still");
                    }
                }else{
                    updateActionFeedback("Unclear command");
                }

            }else if(action.equals("unlock")){
                if(returnRoomContainers().contains(subject)){
                    Container container = data.loadContainer(subject);
                    if(container.returnContainerIsLocked()){
                        if(pc.returnInventory().contains("lockpick")){
                            //TODO: implement unlock action
                        }else{
                            updateActionFeedback("You have no lockpicks to unlock " + subject);
                        }
                    }else{
                        updateActionFeedback(subject + " is not locked.");
                    }
                }else{
                    updateActionFeedback("unknown command");
                }
            }
        }catch(IndexOutOfBoundsException e){
            updateActionFeedback("Unknown command!");
            e.getMessage();}
    }

    private void updateActionFeedback(String action){
        actionFeedback = action;
    }

    public String returnActionFeedback(){
        return this.actionFeedback;
    }

    private void setCurrentRoom(Room room){
        currentRoom = room;
    }

    public String returnRoomName(){
        return data.loadRoom(currentRoom.returnRoomId()).returnRoomName();
    }

    public String returnRoomDescription(){
        return data.loadRoom(currentRoom.returnRoomId()).returnRoomDescription();
    }

    private List gatherRoomExits(){
        HashMap exits = data.loadRoom(currentRoom.returnRoomId()).returnRoomExits();
        List<String> exitKeys = new ArrayList<String>();
        for(Object o : exits.keySet()){
            if(!exits.get(o).toString().equals("x")){
                exitKeys.add(o.toString());
            }
        }
        return exitKeys;
    }

    private List gatherShopItems(){
            HashMap shopItems = data.loadShop(currentRoom.returnRoomId()).returnShop();
            List<String> items = new ArrayList<String>();
        try {
            for (Object o : shopItems.keySet()) {
                items.add(o.toString());
            }
            return items;
        }catch(NullPointerException e){
            e.getMessage();
        }
        return items;
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
        try {
        setCurrentRoomGroundItems();
        List items = data.loadRoom(currentRoom.returnRoomId()).returnItems();
        String allItems = "";

            for (Object o : items) {
                String itemName = data.loadItem(o.toString()).returnItemName();
                allItems += itemName + "\n";
            }
            return allItems.replaceAll("\"", "");
        }catch(NullPointerException e){
            e.getMessage();
        }
        return "Nothing"; // when there are no items, or one item cannot be found
        //TODO: when at least one item cannot be found, none of the items will be shown
    }

    public String returnRoomContainers(){
        setCurrentRoomContainers();
        List containers = data.loadRoom(currentRoom.returnRoomId()).returnRoomContainers();
        String allContainers = "";
        try {
            for (Object o : containers) {
                String containerName = data.loadContainer(o.toString()).returnContainerName();
                allContainers += containerName + "\n";
            }
            return allContainers.replaceAll("\"", "");
        }catch(NullPointerException e){
            e.getMessage();
        }
        return allContainers;
    }

    public String returnShopItems(){
        String shopItems = "";
        for(Object s : gatherShopItems()){
            shopItems += s + "\n";
        }
        return shopItems.replaceAll("\"", "");
    }

    public String returnRoomExits(){
        String allExits = "";
        for(Object s : gatherRoomExits()){
            allExits += s + "\n";
        }
        return allExits.replaceAll("\"", "");
    }

    private String returnExit(String exit){
        HashMap exits = data.loadRoom(currentRoom.returnRoomId()).returnRoomExits();
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

    private void setCurrentRoomContainers(){this.currentRoomContainers = currentRoom.returnRoomContainers();}

//    private void setCurrentRoomShop(){this.currentShop = currentRoom.returnShop();}

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
