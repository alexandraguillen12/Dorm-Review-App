package edu.vassar.cmpu203.myapplication.view;

/**
 * IRoomSelectionView represents the room selection and check if the listener is done with
 * the search or not. If not it displays the new search.
 */
public interface IRoomSelectionView {

    /**
     * Interface that classes interested in being notified of events happening
     * to the view should implement.
     */
    interface Listener{

        /**
         * Called when the user has selected a room.
         */
        void onSelectionDone(int position);

        /**
         * Called when the user indicates the desire to make a new search.
         */
        void onNewSearch();
    }

}
