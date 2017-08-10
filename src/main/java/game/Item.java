package game;

/*
 * Created by ravenalb on 8-6-2017.
 */


public class Item {

    private String id;
    private String name;
    private String type;
    private String description;
    private Integer value;
    private String availability;
    private boolean eatable;
    private boolean takable;


    //Item(){}

    Item(String id, String name, String type, String description, Integer value, String availability, boolean eatable, boolean takable){
        setId(id);
        setName(name);
        setType(type);
        setDescription(description);
        setValue(value);
        setAvailability(availability);
        setEatable(eatable);
        setTakable(takable);
    }

    public static void main(String[] args){

    }

    private void setId(String id){
        this.id = id;
    }

    private void setName(String name){
        this.name = name;
    }

    private void setType(String type){
        this.type = type;
    }

    private void setDescription(String description){
        this.description = description;
    }

    private void setValue(Integer value){
        this.value = value;
    }

    private void setEatable(boolean eatable){
        this.eatable = eatable;
    }

    private void setTakable(boolean takable){
        this.takable = takable;
    }

    private void setAvailability(String availability){
        this.availability = availability;
    }

    String returnItemName(){
        return this.name;
    }

    String returnItemId(){
        return this.id;
    }

    String returnItemDescription(){
        return this.description;
    }

    String returnItemType(){
        return this.type;
    }

    Integer returnItemValue(){
        return this.value;
    }

    String returnItemAvailability(){return this.availability;}

    boolean returnItemEatable(){
        return this.eatable;
    }

    boolean returnItemTakable(){
        return this.takable;
    }

}
