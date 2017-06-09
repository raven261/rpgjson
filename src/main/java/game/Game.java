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
        //new Game().createItems();
        //new Game().returnItemId("item1");
        //createRooms();
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

    }

    private void createItems(){
        Item i1 = new Item("i1", "item1", "thing", "item1 description, ", 1, false, true);
        Item i2 = new Item("i2", "item2", "food", "item2 description", 5, true, true);

        data.saveItems(i1, "i1");
        data.saveItems(i2, "i2");
    }

    private void createRooms(){
        Room r1 = new Room(1, "test name", "Test description of the room.", "r2", "x", "r3", "x");
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
        stringToArray();
    }

    private void stringToArray(){
        actionArray = rawAction.split(" ");
    }

    public void performAction(){
        String action = actionArray[0];
        String subject = actionArray[1];

        if(action.equals("go")){
            if(returnRoomExits().contains(subject)){
                setCurrentRoom(returnExit(subject));
            }
        }
        else if(action.equals("inspect")){
            if(returnRoomItems().contains(subject)){

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
//TODO: change how items are being handled.
//    private HashMap gatherRoomItems(){
//        List items = data.loadRoomJson(currentRoom).returnItems();
//        HashMap<String, String> itemList = new HashMap<String, String>();
//        System.out.println(items);
//        for (Object o : items){
//            String item = o.toString();
//            String name = data.loadItem(item).returnItemName();
//            String id = data.loadItem(item).returnItemId();
//            itemList.put(id, name);
//        }
//        System.out.println(itemList);
//        return itemList;
//    }

//    private String returnItemId(String name){
//        //TODO: doesnt work!
//        HashMap items = gatherRoomItems();
//        Object key = items.get(name);
//        System.out.println(key);
//        return key.toString();
//    }

    public String returnRoomItems(){
        List items = data.loadRoomJson(currentRoom).returnItems();
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
        HashMap exits = data.loadRoomJson(currentRoom).returnExits();
        Object key = exits.get(exit);
        if(key.equals("x")){
            return "no exit";
        }else{
            return key.toString();}
    }

}
