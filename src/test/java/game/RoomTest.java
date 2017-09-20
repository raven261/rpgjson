package game;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
 * Created by ravenalb on 30-8-2017.
 */
public class RoomTest {

    private List<String> containers = new ArrayList<String>();
    private List<String> ground = new ArrayList<String>();

    private Room testRoom = new Room("testId", "TestName", "r2", "s1", "r3", "x", ground, containers, "Test description");


    @Test
    public void testRoomName(){
        assertEquals("Room name is returned","TestName", testRoom.returnRoomName());
    }

    @Test
    public void testRoomId(){
        assertEquals("Room id is returned","testId", testRoom.returnRoomId());
    }

    @Test
    public void testRoomExits(){
        HashMap<String, String> exits = new HashMap<String, String>();
        exits.put("north", "r2");
        exits.put("east", "r3");
        exits.put("west", "x");
        exits.put("south", "s1");

        assertEquals("Room exits is returned",exits , testRoom.returnRoomExits());
    }

    @Test
    public void testRoomDescription(){
        assertEquals("Room description is returned","Test description", testRoom.returnRoomDescription());
    }

    @Test
    public void testRoomWithOneContainer(){
        containers.add("testRoomContainer");
        List<String> controlContainers = new ArrayList<String>();
        controlContainers.add("testRoomContainer");

        assertEquals("Room container is returned",controlContainers, testRoom.returnRoomContainers());
    }

    @Test
    public void testRoomWithNoContainers(){
        List<String> controlContainers = new ArrayList<String>();

        assertEquals("Room container is returned", controlContainers, testRoom.returnRoomContainers());
    }
}
