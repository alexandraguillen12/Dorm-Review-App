package edu.vassar.cmpu203.myapplication.view;

import edu.vassar.cmpu203.myapplication.model.House;
import edu.vassar.cmpu203.myapplication.model.RoomType;

/**
 * INoResultsView implements if there is no results for teh search and displays
 * it to INoResultsView to do a new search.
 */
public interface INoResultsView {
    interface Listener {

        void onNewSearch();

    }
}
