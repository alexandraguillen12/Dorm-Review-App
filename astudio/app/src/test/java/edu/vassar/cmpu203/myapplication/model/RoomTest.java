package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;
import org.junit.Test;               // for the @Test annotation
import org.junit.Assert;             // for the assert* methods

import java.util.ArrayList;

public class RoomTest extends TestCase {

    @Test
    public void testGetHouse() {
        Room r = new Room("Main", 1, "Single",true,101);
        assertEquals("Main", r.getHouse());
    }

    @Test
    public void testGetFloor() {
        Room r = new Room("Main", 1, "Single",true,101);
        assertEquals(1, r.getFloor());
    }

    @Test
    public void testGetRoomType() {
        Room r = new Room("Main", 1, "Single",true,101);
        assertEquals("Single", r.getRoomType());
    }

    @Test
    public void testGetAvailability() {
        Room r = new Room("Main", 1, "Single",true,101);
        assertTrue(r.getAvailability());
    }

    @Test
    public void testAddReviews() {
        Room r = new Room("Main", 1, "Single",true,101);
        Review emptyReview = new Review(0.0f,"","");
        Review exampleReview = new Review(5f,"headline", "review");
        r.addReviews(emptyReview);
        r.addReviews(exampleReview);

        ArrayList<Review> reviews = new ArrayList<Review>();
        reviews.add(emptyReview);
        reviews.add(exampleReview);

        assertEquals(reviews, r.getReviews());
    }

    @Test
    public void testTestToString() {
        Room r = new Room("Main", 1, "Single",true,101);
        assertEquals("Main House | Floor 1 | Single | Available", r.toString());
    }
}