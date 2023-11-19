package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;
import org.junit.Test;               // for the @Test annotation
import org.junit.Assert;             // for the assert* methods

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.transform.Result;

public class SearchTest extends TestCase {

    @Test
    public void addFilters() {
        Search s1 = new Search();
        s1.addFilters(House.ALL_HOUSES, 0, RoomType.ALL_ROOM_TYPES, false);
        Assert.assertEquals(s1.getFilterCount(), 0);

        Search s2 = new Search();
        s2.addFilters(House.CUSHING, 3, RoomType.SINGLE, true);
        Assert.assertEquals(s2.getFilterCount(), 4);

        Search s3 = new Search();
        s3.addFilters(House.STRONG,0, RoomType.SINGLE,false);
        Assert.assertEquals(s3.getFilterCount(), 2);

    }
    @Test
    public void testFilter() {
        Search s = new Search();

        ArrayList<Room> roomList = new ArrayList<Room>();
        roomList.add(new Room(House.MAIN,1,RoomType.SINGLE,true));
        Room jewettRoom = new Room(House.JEWETT,2,RoomType.SINGLE,true);
        roomList.add(jewettRoom);
        roomList.add(new Room(House.CUSHING,3,RoomType.SINGLE,true));

        Set<Filter> filterSet = new HashSet<>();
        filterSet.add(new RoomTypeFilter(RoomType.SINGLE));

        ArrayList<Room> results = s.filter(roomList,filterSet);
        Assert.assertEquals(roomList, results);

        filterSet.add(new HouseFilter(House.JEWETT));
        results = s.filter(roomList,filterSet);
        ArrayList<Room> jewettRoomList = new ArrayList<Room>();
        jewettRoomList.add(jewettRoom);
        Assert.assertEquals(jewettRoomList, results);
    }

    /*
    @Test
    public void testGetResults() {
        Result r = new Result();
        ArrayList<Room> filterSet();

        Search s = new Search();

    }

     */

}