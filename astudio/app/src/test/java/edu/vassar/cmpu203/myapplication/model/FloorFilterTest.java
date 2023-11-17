package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;

import java.util.ArrayList;

public class FloorFilterTest extends TestCase {
    public void testFilter() {
        ArrayList<Room> roomArrayList = new ArrayList<>();

        roomArrayList.add(new Room(House.CUSHING,3,RoomType.DOUBLE,true));
        Room floor1Room = new Room(House.DAVISON,1,RoomType.SINGLE,true);
        roomArrayList.add(floor1Room);
        Room floor2Room= new Room(House.NOYES,2,RoomType.TRIPLE,true);
        roomArrayList.add(floor2Room);

        FloorFilter ff = new FloorFilter(1);
        ArrayList<Room> results = ff.filter(roomArrayList);
        ArrayList<Room> floor1RoomList = new ArrayList<Room>();
        floor1RoomList.add(floor1Room);
        assertEquals(floor1RoomList, results);
        
        ff.floor = 2;
        results = ff.filter(roomArrayList);
        ArrayList<Room> floor2RoomList = new ArrayList<Room>();
        floor2RoomList.add(floor2Room);
        assertEquals(floor2RoomList, results);
        assertEquals(2, results.get(0).getFloor());
    }
}