package game;

import java.util.HashMap;
import java.util.List;

/*
 * Created by ravenalb on 14-8-2017.
 */
public class Shop extends Room {

    private HashMap<String, Integer> shop = new java.util.HashMap<String, Integer>();

    Shop(String id, String name, String n, String s, String e, String w, List<String> ground, List<String> containers, String desc, HashMap<String, Integer> shop){
        super(id, name, n, s, e, w, ground,containers, desc);
        setShop(shop);
    }

    private void setShop(HashMap shop){
        this.shop=shop;
    }

    HashMap returnShop(){
        return this.shop;
    }

}
