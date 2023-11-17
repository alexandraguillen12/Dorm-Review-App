package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;

import java.util.ArrayList;

public class HouseFilterTest extends TestCase {

    public void testFilter() {
        ArrayList<Room> roomArrayList = new ArrayList<>();

        roomArrayList.add(new Room(House.MAIN,1,RoomType.SINGLE,true));
        Room jewettRoom = new Room(House.JEWETT,2,RoomType.SINGLE,true);
        roomArrayList.add(jewettRoom);
        Room cushingRoom = new Room(House.CUSHING,3,RoomType.SINGLE,true);
        roomArrayList.add(cushingRoom);

        HouseFilter hf = new HouseFilter(House.JEWETT);
        ArrayList<Room> results = hf.filter(roomArrayList);
        ArrayList<Room> jewettRoomList = new ArrayList<Room>();
        jewettRoomList.add(jewettRoom);
        assertEquals(jewettRoomList, results);

        hf.name = House.CUSHING;
        results = hf.filter(roomArrayList);
        ArrayList<Room> cushingRoomList = new ArrayList<Room>();
        cushingRoomList.add(cushingRoom);
        assertEquals(cushingRoomList, results);
        assertEquals(House.CUSHING, results.get(0).getHouse());
    }
}