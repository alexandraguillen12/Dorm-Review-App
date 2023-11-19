package edu.vassar.cmpu203.myapplication.model;

public class Review {

    String headline;
    String reviewStr;
    public Review(String headline, String reviewStr){
        this.headline = headline;
        this.reviewStr = reviewStr;
    }

    public String getHeadline() {
        return headline;
    }

    public String getReviewStr() {
        return reviewStr;
    }

}
