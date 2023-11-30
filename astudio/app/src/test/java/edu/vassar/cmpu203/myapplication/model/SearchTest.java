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
        s1.addFilters("All Houses", 0, "All Room Types", false);
        Assert.assertEquals(s1.getFilterCount(), 0);

        Search s2 = new Search();
        s2.addFilters("Cushing", 3, "Single", true);
        Assert.assertEquals(s2.getFilterCount(), 4);

        Search s3 = new Search();
        s3.addFilters("Strong",0, "Single",false);
        Assert.assertEquals(s3.getFilterCount(), 2);

    }
    @Test
    public void testFilter() {
        Search s = new Search();

        ArrayList<Room> roomList = new ArrayList<Room>();
        roomList.add(new Room("Main",1,"Single",true,101));
        Room jewettRoom = new Room("Jewett",2,"Single",true,202);
        roomList.add(jewettRoom);
        roomList.add(new Room("Cushing",3,"Single",true,303));

        Set<Filter> filterSet = new HashSet<>();
        filterSet.add(new RoomTypeFilter("Single"));

        ArrayList<Room> results = s.filter(roomList,filterSet);
        Assert.assertEquals(roomList, results);

        filterSet.add(new HouseFilter("Jewett"));
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