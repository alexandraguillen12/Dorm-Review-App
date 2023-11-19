package edu.vassar.cmpu203.myapplication.model;

import junit.framework.TestCase;
import org.junit.Test;               // for the @Test annotation
import org.junit.Assert;             // for the assert* methods
public class ReviewTest extends TestCase {

    @Test
    public void testGetHeadline() {
        Review r = new Review("","");
        Assert.assertEquals("", r.getHeadline());

        r.headline += "headline";
        Assert.assertEquals("headline", r.getHeadline());
    }

    @Test
    public void testGetReviewStr() {
        Review r = new Review("","");
        Assert.assertEquals("", r.getReviewStr());

        r.reviewStr += "review";
        Assert.assertEquals("review", r.getReviewStr());
    }
}