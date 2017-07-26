package game;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by ravenalb on 29-5-2017.
 */
class Character {



    private String name = "PC Name";
    private List<String> inventory = new ArrayList<String>();
    private String location;
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

    private void setLocation(String loc){
        this.location = loc;
    }

    String returnName(){
        return this.name;
    }

    List<String> returnInventory(){
        return this.inventory;
    }

    Integer returnCoinPurseValue(){
        Integer coins = coinPurse[0];
        System.out.println("tempCoinPurse: " + coins);
        return coins;
    }

    String returnLocation(){
        return this.location;
    }

    void addToPcInventory(String item){
        this.inventory.add(item);
    }

    void updateLocation(String location){
        this.location = location;
    }

    void updateCoinPurse(Integer value){
        //this.coinPurse.add(0, value);
        this.coinPurse[0] = value;
    }

    void updateInventory(List<String> inventory){
        this.inventory = inventory;
    }

}
