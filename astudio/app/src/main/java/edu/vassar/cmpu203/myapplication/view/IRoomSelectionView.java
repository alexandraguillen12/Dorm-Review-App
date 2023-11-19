package edu.vassar.cmpu203.myapplication.view;

/**
 * IRoomSelectionView represents the room selection and check if the listener is done with
 * the search or not. If not it displays the new search.
 */
public interface IRoomSelectionView {

    interface Listener{

        void onSelectionDone(int position);

        void onNewSearch();
    }

}
