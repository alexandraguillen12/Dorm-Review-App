package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;
import org.junit.Test;               // for the @Test annotation
import org.junit.Assert;             // for the assert* methods

/**
 * The ReviewRest class is a JUnir test class for the review class, specifically testing the
 * getter methods: getRatingNum, getHeadline, and getReviewStr.
 */
public class ReviewTest extends TestCase {


    /**
     * Testing the getRatingNum method of the Review class.
     */
    @Test
    public void testGetRatingNum() {
        Review r = new Review(0.0f,"","");
        Assert.assertEquals(0.0f, r.getRatingNum(), 0.0);

        r.ratingNum += 5f;
        Assert.assertEquals(5f, r.getRatingNum(), 0.0);
    }

    /**
     * Testing the getHeadline method of the Review class.
     */
    @Test
    public void testGetHeadline() {
        Review r = new Review(0.0f,"","");
        Assert.assertEquals("", r.getHeadline());

        r.headline += "headline";
        Assert.assertEquals("headline", r.getHeadline());
    }

    /**
     * Testing the getReviewStr method of the Review class.
     */
    @Test
    public void testGetReviewStr() {
        Review r = new Review(0.0f,"","");
        Assert.assertEquals("", r.getReviewStr());

        r.reviewStr += "review";
        Assert.assertEquals("review", r.getReviewStr());
    }
}