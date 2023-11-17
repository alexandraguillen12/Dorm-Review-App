package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;

import java.util.ArrayList;

public class AvailabilityFilterTest extends TestCase {

    public void testFilter() {
        ArrayList<Room> roomArrayList = new ArrayList<>();

        Room availRoom1 = new Room(House.CUSHING,3,RoomType.DOUBLE,true);
        roomArrayList.add(availRoom1);
        Room availRoom2 = new Room(House.DAVISON,1,RoomType.SINGLE,true);
        roomArrayList.add(availRoom2);
        Room notAvailRoom= new Room(House.NOYES,2,RoomType.TRIPLE,false);
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