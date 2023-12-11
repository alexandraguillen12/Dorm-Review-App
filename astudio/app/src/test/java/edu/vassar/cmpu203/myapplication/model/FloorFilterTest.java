package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * The FloorFilterTest class is a JUint test case for the FloorFilter class.
 * filtering testing the behavior of the filter method.
 */

public class FloorFilterTest extends TestCase {
    /**
     * Tests the behavior of the filter method in teh FloorFilter class.
     */
    public void testFilter() {
        ArrayList<Room> roomArrayList = new ArrayList<>();
        // Create a list of rooms for testing
        roomArrayList.add(new Room("Cushing",3,"Double",true,303));
        Room floor1Room = new Room("Davison",1,"Single",true,101);
        roomArrayList.add(floor1Room);
        Room floor2Room= new Room("Noyes",2,"Triple",true,202);
        roomArrayList.add(floor2Room);

        // Test filtering rooms on the first floor
        FloorFilter ff = new FloorFilter(1);
        ArrayList<Room> results = ff.filter(roomArrayList);
        ArrayList<Room> floor1RoomList = new ArrayList<Room>();
        floor1RoomList.add(floor1Room);
        assertEquals(floor1RoomList, results);

        // Test filtering rooms on the second floor.
        ff.floor = 2;
        results = ff.filter(roomArrayList);
        ArrayList<Room> floor2RoomList = new ArrayList<Room>();
        floor2RoomList.add(floor2Room);
        assertEquals(floor2RoomList, results);
        assertEquals(2, results.get(0).getFloor());
    }
}