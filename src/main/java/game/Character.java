package game;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by ravenalb on 29-5-2017.
 */
public class Character {

    String name = "Test Name";
    private List<String> inventory = new ArrayList<String>();
    //private List<Integer> coinPurse = new ArrayList<Integer>();
    private static int[] location = new int[2];
    private int[] coinPurse = new int[1];


    Character(String name, int x, int y, int gold){
        setName(name);
        setLocationX(x);
        setLocationY(y);
        setCoinPurse(gold);
        addItemToInventory("item1");
    }

    private void setName(String name){
        this.name = name;
    }

    static void setLocationX(int value){
        location[0] = value;
    }

    static void setLocationY(int value){
        location[1] = value;
    }

    private void setCoinPurse(int amount){
        this.coinPurse[0] = amount;
    }

    private void addItemToInventory(String item){
        this.inventory.add(item);
    }

    static int returnPcLocationX(){
        return location[0];
    }

    static int returnPcLocationY(){
        return location[0];
    }

}
