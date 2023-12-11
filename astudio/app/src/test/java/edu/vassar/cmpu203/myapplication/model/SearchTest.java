package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;
import org.junit.Test;               // for the @Test annotation
import org.junit.Assert;             // for the assert* methods

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.transform.Result;

/**
 *  The SearchTest class is a JUnit case for the Search class, specifically testing the behavior
 *  of its addFilters and filter methods.
 */

public class SearchTest extends TestCase {

    /**
     * Test's the behavior of Search's addFilter's() method.
     * Since addLineItem() is a void method this has to be done by checking the size of the filterSet
     */
    @Test
    public void testAddFilters() {
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

    /**
     * Tests the behavior of the filter in the Search class.
     */
    @Test
    public void testFilter() {

        // Create a Search instance and a list of rooms for testing
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

        filterSet.add(new AvailabilityFilter(false));
        results = s.filter(roomList,filterSet);
        ArrayList<Room> emptyList = new ArrayList<Room>();
        Assert.assertEquals(emptyList, results);
    }

}