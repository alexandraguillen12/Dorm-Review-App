package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;

import java.util.ArrayList;

public class AvailabilityFilterTest extends TestCase {

    public void testFilter() {
        ArrayList<Room> roomArrayList = new ArrayList<>();

        Room availRoom1 = new Room("Cushing",3,"Double",true,303);
        roomArrayList.add(availRoom1);
        Room availRoom2 = new Room("Davison",1,"Single",true,101);
        roomArrayList.add(availRoom2);
        Room notAvailRoom= new Room("Noyes",2,"Triple",false,202);
        roomArrayList.add(notAvailRoom);

        AvailabilityFilter af = new AvailabilityFilter(true);
        ArrayList<Room> results = af.filter(roomArrayList);
        ArrayList<Room> availList = new ArrayList<Room>();
        availList.add(availRoom1);
        availList.add(availRoom2);
        assertEquals(availList, results);

        af.availability = false;
        results = af.filter(roomArrayList);
        ArrayList<Room> notAvailList = new ArrayList<Room>();
        notAvailList.add(notAvailRoom);
        assertEquals(notAvailList, results);
        assertEquals(false, results.get(0).getAvailability());
    }
}