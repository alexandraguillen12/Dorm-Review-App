package edu.vassar.cmpu203.myapplication.view;

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

}
