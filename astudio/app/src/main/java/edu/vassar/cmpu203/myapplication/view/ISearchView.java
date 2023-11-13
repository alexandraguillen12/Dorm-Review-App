package edu.vassar.cmpu203.myapplication.view;

import android.view.View;

import edu.vassar.cmpu203.myapplication.model.House;
import edu.vassar.cmpu203.myapplication.model.RoomType;

public interface ISearchView {

    //public View getRootView();

    /**
     * Interface that classes interested in being notified of events happening
     * to the view should implement.
     */
    interface Listener {
        /*
        look at class example for help
        this should collect the house, floor, room type, and availability selected
        in SearchFragment to pass through the filters
        then what to do after search criteria is chosen
         */
        void onAddedFilters(House name, int floor, RoomType rt, boolean availability, ISearchView view);

        /**
         * Called when the user is done adding filters.
         */
        void onSearchDone();

    }

}
