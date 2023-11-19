package edu.vassar.cmpu203.myapplication.model;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

/**
 * The AvailabilityFilter represents a filter for filtering a list of rooms based on activity status.
 */
public class AvailabilityFilter implements Filter {
    boolean availability;

    /**
     * Constructs a new AvailabilityFilter with the specified Availability status.
     * @param availability the availability status to be used for filtering.
     */
    public AvailabilityFilter(boolean availability){
        this.availability = availability;
    }

    /**
     * Filters the availability rooms based on the status.
     * @param roomList the list of the rooms to be filtered.
     * @return Containing only the specified availability status.
     */

    public ArrayList<Room> filter(ArrayList<Room> roomList){
        ArrayList<Room> filteredList = new ArrayList<Room>();
        for (Room r : roomList) {
            if (this.availability == r.getAvailability()) {
                filteredList.add(r);
            }
        }
        return filteredList;
    }
}
