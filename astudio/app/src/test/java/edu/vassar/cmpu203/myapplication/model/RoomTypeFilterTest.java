package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 *  The RoomTypeFilterTest class is a JUmit test case for the RoomTypeFilter class, specifically
 *  testngi the behavior of the filter method.
 */

public class RoomTypeFilterTest extends TestCase {

    /**
     * Tests the behavior of the filter in the RoomTypeFilter class
     */
    public void testFilter() {
        // Create a list of rooms for testing
        ArrayList<Room> roomArrayList = new ArrayList<>();

        // Rooms with different rooms types.
        roomArrayList.add(new Room("Main",1,"Triple",true,101));
        Room singleRoom = new Room("Jewett",2,"Single",true,202);
        roomArrayList.add(singleRoom);
        Room doubleRoom = new Room("Cushing",3,"Double",true,303);
        roomArrayList.add(doubleRoom);

        RoomTypeFilter rtf = new RoomTypeFilter("Single");
        ArrayList<Room> results = rtf.filter(roomArrayList);
        ArrayList<Room> singleRoomList = new ArrayList<Room>();
        singleRoomList.add(singleRoom);
        assertEquals(singleRoomList, results);

        rtf.type = "Double";
        results = rtf.filter(roomArrayList);
        ArrayList<Room> doubleRoomList = new ArrayList<Room>();
        doubleRoomList.add(doubleRoom);
        assertEquals(doubleRoomList, results);
        assertEquals("Double", results.get(0).getRoomType());
    }
}