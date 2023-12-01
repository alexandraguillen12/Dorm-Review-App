package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;

import java.util.ArrayList;

public class HouseFilterTest extends TestCase {

    public void testFilter() {
        ArrayList<Room> roomArrayList = new ArrayList<>();

        roomArrayList.add(new Room("Main",1,"Single",true,101));
        Room jewettRoom = new Room("Jewett",2,"Single",true,202);
        roomArrayList.add(jewettRoom);
        Room cushingRoom = new Room("Cushing",3,"Single",true,303);
        roomArrayList.add(cushingRoom);

        HouseFilter hf = new HouseFilter("Jewett");
        ArrayList<Room> results = hf.filter(roomArrayList);
        ArrayList<Room> jewettRoomList = new ArrayList<Room>();
        jewettRoomList.add(jewettRoom);
        assertEquals(jewettRoomList, results);

        hf.name = "Cushing";
        results = hf.filter(roomArrayList);
        ArrayList<Room> cushingRoomList = new ArrayList<Room>();
        cushingRoomList.add(cushingRoom);
        assertEquals(cushingRoomList, results);
        assertEquals("Cushing", results.get(0).getHouse());
    }
}