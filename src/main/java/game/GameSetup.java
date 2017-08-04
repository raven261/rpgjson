package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Created by ravenalb on 4-8-2017.
 */
class GameSetup {

    private List<Room> allRooms = new ArrayList<Room>();
    private List<Item> allItems = new ArrayList<Item>();
    private List<Container> allContainers = new ArrayList<Container>();

    private Data data = new Data();

    void createItems(){
        Item stone = new Item("stone", "stone", "thing", "A stone", 0, "common", false, true);
        Item bread = new Item("bread", "bread", "food", "a piece of relatively fresh bread", 1, "common", true, true);
        Item gold = new Item("gold", "gold", "wealth", "a gold coin", 1, "common", false, true);
        Item potionH = new Item("potionH", "healing potion", "potion", "A bottle with some redish liquid that heals", 10, "uncommon", true, true);
        Item shadow = new Item("shadow", "shadow", "environment", "your shadow on the ground", 0, "na", false, false);
        Item lockpick1 = new Item("lockpick1", "lockpick", "thief", "a set of small rods for picking locks", 1, "uncommon", false, true);

        allItems.add(stone);
        allItems.add(bread);
        allItems.add(gold);
        allItems.add(potionH);
        allItems.add(shadow);
        allItems.add(lockpick1);

        for(Item i : allItems){
            data.saveItem(i, i.returnItemId());
        }
    }

    void createContainers(){
        Container barrel1 = new Container("barrel1", "barrel", "an old barrel", false, false, "none");
        Container chest1 = new Container("chest1", "chest", "an old battered chest", true, true, "easy");

        allContainers.add(barrel1);
        allContainers.add(chest1);

        for(Container c : allContainers){
            data.saveContainers(c, c.returnContainerId());
        }

        // to put containers in the items section, they can be used for inspection

    }

    private void setupGroundItems(){
        //TODO: implement random items in containers and rooms?
        // per container there should be a random amount of common items
        Random maxNumberOfItems = new Random(6);

    }

    void createRooms(){
        //TODO: add containers to rooms
        Room r1 = new Room("r1", "test name", "This is from a development point of view the start room of the game.\n Here will be most of the test situations taking place so that navitating will not be necessary.", "r2", "x", "r3", "x");
        Room r2 = new Room("r2", "test 2 name", "test 2 description", "x", "r1", "x", "x");
        Room r3 = new Room("r3", "test 3 name", "test 3 description", "x", "x", "x", "r1");

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
