package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
 * Created by ravenalb on 30-8-2017.
 */

public class ItemTest {

    private Item testItem = new Item("testId", "itemName", "itemType", "Test description", 0, "common", false, true);

    @Test
    public void testItemId(){
        assertEquals("Item id is returned","testId", testItem.returnItemId());
    }

    @Test
    public void testItemName(){
        assertEquals("Item name is returned","itemName", testItem.returnItemName());
    }

    @Test
    public void testItemType(){
        assertEquals("Item type is returned","itemType", testItem.returnItemType());
    }

    @Test
    public void testItemDescription(){
        assertEquals("Item description is returned","Test description", testItem.returnItemDescription());
    }

    @Test
    public void testItemValueZero(){
        Integer testValue = 0;
        assertEquals("Item value is zero",testValue , testItem.returnItemValue());
    }

    @Test
    public void testItemAvailability(){
        String expected = "common";
        assertEquals("Item availablity is returned",expected, testItem.returnItemAvailability());
    }

    @Test
    public void testItemEatable(){
        Boolean expected = false;
        assertEquals("Item eatable is returned",expected, testItem.returnItemEatable());
    }

    @Test
    public void testItemTakable(){
        Boolean expected = true;
        assertEquals("Item takable is returned",expected, testItem.returnItemTakable());
    }

}
