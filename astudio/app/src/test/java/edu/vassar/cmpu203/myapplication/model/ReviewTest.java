package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;
import org.junit.Test;               // for the @Test annotation
import org.junit.Assert;             // for the assert* methods
public class ReviewTest extends TestCase {

    @Test
    public void testGetRatingNum() {
        Review r = new Review(0.0f,"","");
        Assert.assertEquals(0.0f, r.getRatingNum(), 0.0);

        r.ratingNum += 5f;
        Assert.assertEquals(5f, r.getRatingNum(), 0.0);
    }

    @Test
    public void testGetHeadline() {
        Review r = new Review(0.0f,"","");
        Assert.assertEquals("", r.getHeadline());

        r.headline += "headline";
        Assert.assertEquals("headline", r.getHeadline());
    }

    @Test
    public void testGetReviewStr() {
        Review r = new Review(0.0f,"","");
        Assert.assertEquals("", r.getReviewStr());

        r.reviewStr += "review";
        Assert.assertEquals("review", r.getReviewStr());
    }
}