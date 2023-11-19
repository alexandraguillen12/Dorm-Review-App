package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;
import org.junit.Test;               // for the @Test annotation
import org.junit.Assert;             // for the assert* methods

import java.util.ArrayList;

public class RoomTest extends TestCase {

    @Test
    public void testGetHouse() {
        Room r = new Room(House.MAIN, 1, RoomType.SINGLE,true);
        assertEquals(House.MAIN, r.getHouse());
    }

    @Test
    public void testGetFloor() {
        Room r = new Room(House.MAIN, 1, RoomType.SINGLE,true);
        assertEquals(1, r.getFloor());
    }

    @Test
    public void testGetRoomType() {
        Room r = new Room(House.MAIN, 1, RoomType.SINGLE,true);
        assertEquals(RoomType.SINGLE, r.getRoomType());
    }

    @Test
    public void testGetAvailability() {
        Room r = new Room(House.MAIN, 1, RoomType.SINGLE,true);
        assertTrue(r.getAvailability());
    }

    @Test
    public void testAddReviews() {
        Room r = new Room(House.MAIN, 1, RoomType.SINGLE,true);
        Review emptyReview = new Review("","");
        Review exampleReview = new Review("headline", "review");
        r.addReviews(emptyReview);
        r.addReviews(exampleReview);

        ArrayList<Review> reviews = new ArrayList<Review>();
        reviews.add(emptyReview);
        reviews.add(exampleReview);

        assertEquals(reviews, r.getReviews());
    }

    @Test
    public void testTestToString() {
        Room r = new Room(House.MAIN, 1, RoomType.SINGLE,true);
        assertEquals("Main House, Floor 1, Single, available", r.toString());
    }
}