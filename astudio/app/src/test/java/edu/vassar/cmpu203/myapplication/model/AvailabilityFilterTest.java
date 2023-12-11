package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * The AvailabilityFilterTest class is a JUnit test case for the AvailabilityFilter class,
 * specifically testing the behavior of the filter method.
 */

public class AvailabilityFilterTest extends TestCase {

    /**
     * Tests the behavior of the filter method in the AvailabilityFilter class.
     */

    public void testFilter() {
        ArrayList<Room> roomArrayList = new ArrayList<>();

        // Available rooms
        Room availRoom1 = new Room("Cushing",3,"Double",true,303);
        roomArrayList.add(availRoom1);
        Room availRoom2 = new Room("Davison",1,"Single",true,101);
        roomArrayList.add(availRoom2);
        // Room not available
        Room notAvailRoom= new Room("Noyes",2,"Triple",false,202);
        roomArrayList.add(notAvailRoom);

        AvailabilityFilter af = new AvailabilityFilter(true);
        ArrayList<Room> results = af.filter(roomArrayList);
        ArrayList<Room> availList = new ArrayList<Room>();
        availList.add(availRoom1);
        availList.add(availRoom2);
        assertEquals(availList, results);
        // Test filtering unavailable rooms
        af.availability = false;
        results = af.filter(roomArrayList);
        ArrayList<Room> notAvailList = new ArrayList<Room>();
        notAvailList.add(notAvailRoom);
        assertEquals(notAvailList, results);
        assertFalse(results.get(0).getAvailability());
    }
}