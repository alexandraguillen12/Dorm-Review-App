package edu.vassar.cmpu203.myapplication.view;

import java.util.ArrayList;

import edu.vassar.cmpu203.myapplication.model.Review;

/**
 * Interface that defines the methods for a view that allows a user to see a room's profile.
 */
public interface IRoomProfileView {
    /**
     * Interface that classes interested in being notified of events happening
     * to the view should implement.
     */
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
