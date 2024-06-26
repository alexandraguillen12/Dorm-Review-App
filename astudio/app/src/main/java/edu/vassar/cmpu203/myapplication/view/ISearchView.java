package edu.vassar.cmpu203.myapplication.view;

/**
 * Interface that defines the methods for a view that allows a user search for a room.
 */
public interface ISearchView {

    /**
     * Interface that classes interested in being notified of events happening
     * to the view should implement.
     */
    interface Listener {

        /**
         * Called when the user is done choosing from the dropdowns.
         */
        void onAddedFilters(String name, int floor, String rt, boolean availability, ISearchView view);

        /**
         * Called when the user is done adding filters.
         */
        void onSearchDone(ISearchView view);

    }

}
