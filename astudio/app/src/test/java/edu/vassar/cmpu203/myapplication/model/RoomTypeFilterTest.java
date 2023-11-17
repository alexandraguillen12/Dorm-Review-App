package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;

import java.util.ArrayList;

public class RoomTypeFilterTest extends TestCase {

    public void testFilter() {
        ArrayList<Room> roomArrayList = new ArrayList<>();

        roomArrayList.add(new Room(House.MAIN,1,RoomType.TRIPLE,true));
        Room singleRoom = new Room(House.JEWETT,2,RoomType.SINGLE,true);
        roomArrayList.add(singleRoom);
        Room doubleRoom = new Room(House.CUSHING,3,RoomType.DOUBLE,true);
        roomArrayList.add(doubleRoom);

        RoomTypeFilter rtf = new RoomTypeFilter(RoomType.SINGLE);
        ArrayList<Room> results = rtf.filter(roomArrayList);
        ArrayList<Room> singleRoomList = new ArrayList<Room>();
        singleRoomList.add(singleRoom);
        assertEquals(singleRoomList, results);

        rtf.type = RoomType.DOUBLE;
        results = rtf.filter(roomArrayList);
        ArrayList<Room> doubleRoomList = new ArrayList<Room>();
        doubleRoomList.add(doubleRoom);
        assertEquals(doubleRoomList, results);
        assertEquals(RoomType.DOUBLE, results.get(0).getRoomType());
    }
}