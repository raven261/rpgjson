package game;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by ravenalb on 29-5-2017.
 */
class Character {



    String name = "Test Name";
    private List<String> inventory = new ArrayList<String>();
    public String location;
    private int[] coinPurse = new int[1];


    Character(){

    }
    Character(String name, String loc, int gold){
        setName(name);
        setLocation(loc);
        setCoinPurse(gold);
        //addItemToInventory("gold");
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

    List<String> returnInventory(){
        return this.inventory;
    }

    String returnLocation(){
        return this.location;
    }

    void addToPcInventory(String item){
        this.inventory.add(item);
    }

    void updateInventory(List<String> inventory){
        this.inventory = inventory;
    }

}
