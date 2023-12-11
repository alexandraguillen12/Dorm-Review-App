package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;
import org.junit.Test;               // for the @Test annotation
import org.junit.Assert;             // for the assert* methods

import java.util.ArrayList;

/**
 * The RoomTest class is a JUnit test case fort he Room class, specifically testing various getter
 * methods and functionality.
 */

public class RoomTest extends TestCase {

    /**
     * Tests the getHouse method of the Room class.
     */
    @Test
    public void testGetHouse() {
        Room r = new Room("Main", 1, "Single",true,101);
        assertEquals("Main", r.getHouse());
    }

    /**
     * Tests the getFloor method of the Room class
     */
    @Test
    public void testGetFloor() {
        Room r = new Room("Main", 1, "Single",true,101);
        assertEquals(1, r.getFloor());
    }

    /**
     * Tests the getRoomType method of the Room class.
     */
    @Test
    public void testGetRoomType() {
        Room r = new Room("Main", 1, "Single",true,101);
        assertEquals("Single", r.getRoomType());
    }

    /**
     *  Tests the getAvailability method of the Room class.
     */
    @Test
    public void testGetAvailability() {
        Room r = new Room("Main", 1, "Single",true,101);
        assertTrue(r.getAvailability());
    }

    /**
     * Tests the addReviews method to the Room class
     */
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

    /**
     *  Tests the toString method of the Room class.
     */
    @Test
    public void testTestToString() {
        Room r = new Room("Main", 1, "Single",true,101);
        assertEquals("Main House | Floor 1 | Single | Available", r.toString());
    }
}