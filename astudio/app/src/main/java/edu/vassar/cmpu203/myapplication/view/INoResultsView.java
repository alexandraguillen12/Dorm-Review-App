package edu.vassar.cmpu203.myapplication.view;

/**
 * INoResultsView implements if there is no results for teh search and displays
 * it to INoResultsView to do a new search.
 */
public interface INoResultsView {
    interface Listener {

        void onNewSearch();

    }
}
