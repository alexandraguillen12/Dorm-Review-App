package edu.vassar.cmpu203.myapplication.model;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Search represents a search functionality for filtering a collection of the rooms
 * based on various criteria. It includes methods for adding filters and retrieving results
 */
public class Search {

    private List<Room> results;
    Set<Filter> filterSet = new HashSet<>();
    RoomLibrary roomLib = new RoomLibrary();


    /**
     * Empty constructor.
     */
    public Search(){
        this.results = new ArrayList<>();
    };

    /**
     * Adds filters to filterSet only if a specific house, floor, room type,
     * or availability is selected.
     *
     * @param name the name of the house selected
     * @param floor the floor number selected
     * @param type the room type selected
     * @param availability the availability selected
     */
    public void addFilters(String name, int floor, String type, boolean availability){
        HouseFilter houseFilter = new HouseFilter(name);
        FloorFilter floorFilter = new FloorFilter(floor);
        RoomTypeFilter roomTypeFilter = new RoomTypeFilter(type);
        AvailabilityFilter availabilityFilter = new AvailabilityFilter(availability);
        if (!name.equals("All Houses")) {this.filterSet.add(houseFilter);}
        if (floor != 0) {this.filterSet.add(floorFilter);}
        if (!type.equals("All Room Types")) {this.filterSet.add(roomTypeFilter);}
        if (availability) {this.filterSet.add(availabilityFilter);}
    }

    /**
     * Retrieves the count of active filters in the filter set.
     * @return The count of active retrieves.
     */
    public int getFilterCount(){ return this.filterSet.size();}


    /**
     * Applies each filter in the filters set to the roomList.
     * @param roomList the list of rooms
     * @param filters the set of filters
     * @return the filtered list of rooms
     */
    public ArrayList<Room> filter(ArrayList<Room> roomList, Set<Filter> filters) {
        if (!filters.isEmpty()){
            for (Filter f : filters) roomList = f.filter(roomList);}
        return roomList;
    }

    /**
     * Retrieves the Room Library so that we can apply the filters to it.
     */
    ArrayList<Room> roomArrayList = roomLib.getRoomLibrary();

    /**
     * Receives the search results by applying the active search to the Room Library list.
     * @return the results of the filter
     */
    public List<Room> getResults(){
        this.results = (List<Room>) filter(roomArrayList, filterSet);
        return this.results; }
}
