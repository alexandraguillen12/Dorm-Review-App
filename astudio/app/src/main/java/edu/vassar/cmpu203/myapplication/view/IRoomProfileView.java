package edu.vassar.cmpu203.myapplication.view;

import java.util.ArrayList;

import edu.vassar.cmpu203.myapplication.model.Review;

public interface IRoomProfileView {
    interface Listener{
        /**
         * Called when the user indicates the desire to make a new selection.
         */
        void onNewSelection();

        /**
         * Called when the user indicates the desire to write a review.
         */
        void onWriteReview();

    }

    /**
     * Method to be called whenever the review list display needs to be updated.
     * @param reviews the review list to be displayed
     */
    void updateReviewsDisplay(ArrayList<Review> reviews);


}
