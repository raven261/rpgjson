package game;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by ravenalb on 29-5-2017.
 */
class Character {

    String name = "Test Name";
    private List<String> inventory = new ArrayList<String>();
    private String location;
    private int[] coinPurse = new int[1];


    Character(String name, String loc, int gold){
        setName(name);
        setLocation(loc);
        setCoinPurse(gold);
        addItemToInventory("item1");
    }

    private void setName(String name){
        this.name = name;
    }

    private void setCoinPurse(int amount){
        this.coinPurse[0] = amount;
    }

    private void addItemToInventory(String item){
        this.inventory.add(item);
    }

    private void setLocation(String loc){
        this.location = loc;
    }

    String returnName(){
        return this.name;
    }

    List returnInventory(){
        return this.inventory;
    }

    String returnLocation(){
        return this.location;
    }



}
