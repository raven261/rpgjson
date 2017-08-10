package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Created by ravenalb on 4-8-2017.
 */


class GameSetup {

    //TODO: create monsters
    //TODO: add monsters to rooms

    private List<Room> allRooms = new ArrayList<Room>();
    private List<Item> allItems = new ArrayList<Item>();
    private List<Container> allContainers = new ArrayList<Container>();

    private Data data = new Data();

    public static void main(String [] args){
        new GameSetup().createItems();
        new GameSetup().setupGroundItems();
    }

    void createItems(){
        //TODO: create potions
        //TODO: create weapons
        Item stone = new Item("stone", "stone", "thing", "A small stone", 0, "common", false, true);
        Item bread = new Item("bread", "bread", "food", "a piece of relatively fresh bread", 1, "common", true, true);
        Item gold = new Item("gold", "gold", "wealth", "a gold coin", 1, "common", false, true);
        Item potionH = new Item("potionH", "healing potion", "potion", "A bottle with some redish liquid that heals", 10, "uncommon", true, true);
        Item shadow = new Item("shadow", "shadow", "environment", "your shadow on the ground", 0, "na", false, false);
        Item lockpick = new Item("lockpick", "lockpick", "thief", "a set of small rods for picking locks", 1, "uncommon", false, true);

        allItems.add(stone);
        allItems.add(bread);
        allItems.add(gold);
        allItems.add(potionH);
        allItems.add(shadow);
        allItems.add(lockpick);

        for(Item i : allItems){
            data.saveItem(i, i.returnItemId());
        }
    }

    void createContainers(){
        Container barrel = new Container("barrel", "barrel", "an old barrel", false, false, "none");
        Container chest = new Container("chest", "chest", "an old battered chest", true, true, "easy");

        allContainers.add(barrel);
        allContainers.add(chest);

        for(Container c : allContainers){
            data.saveContainers(c, c.returnContainerId());
        }

        // to put containers in the items section, they can be used for inspection

    }

    private void setupGroundItems(){
        //TODO: implement random items in containers and rooms?
        // per container there should be a random amount of common items
        List<Item> test = allItems;
        Random maxNumberOfItems = new Random(6);
        System.out.println("setupGroundItems");
        System.out.println(allItems);

        for(Item i : test){
            System.out.println("for loop");
            if(i.returnItemAvailability().equals("common")){
                System.out.println("if statement");
                System.out.println("common: " + i);
            }else{
                System.out.println("no common items");
            }
        }

    }

    private List<String> fillGroundItems(Integer room){

        List<String> ground = new ArrayList<String>();

        if(room.equals(1)){
            ground.add("stone");
            ground.add("bread");
            return ground;
        }
        else if(room.equals(2)){
            ground.add("shadow");
            return ground;
        }
        return ground;

    }

    private List<String> addContainerToRoom(Integer room){
        List<String> containers = new ArrayList<String>();

        if(room.equals(1)){
            containers.add("barrel");
            return containers;
        }
        else if(room.equals(2)){
            containers.add("chest");
            return containers;
        }
        return containers;

    }


    void createRooms(){

        Room r1 = new Room("r1", "Town square", "r2", "x", "r3", "x", fillGroundItems(1), addContainerToRoom(1), "This is from a development point of view the start room of the game.\n Here will be most of the test situations taking place so that navigating will not be necessary.");
        Room r2 = new Room("r2", "North Street", "x", "r1", "x", "x", fillGroundItems(2), addContainerToRoom(2), "test 2 description");
        Room r3 = new Room("r3", "East street", "x", "x", "x", "r1", fillGroundItems(3), addContainerToRoom(3), "test 3 description");

        allRooms.add(r1);
        allRooms.add(r2);
        allRooms.add(r3);

        for(Room r : allRooms){
            data.saveRoom(r, r.returnId());
        }
    }


    void createCharacter(){
        Character pc = new Character("name", "r1", 2);

        data.savePC(pc, "pc");
    }


}
