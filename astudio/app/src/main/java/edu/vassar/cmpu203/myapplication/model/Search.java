package edu.vassar.cmpu203.myapplication.model;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Search represents a search functionality for filtering a collection of the rooms
 * based on various criteria. It includes methode for adding filters. retrieval
 */
public class Search {

    private List<Room> results;
    Set<Filter> filterSet = new HashSet<>();
    RoomLibrary roomLib = new RoomLibrary();



    public Search(){
        this.results = new ArrayList<>();
    };

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


    public ArrayList<Room> filter(ArrayList<Room> roomList, Set<Filter> filters) {
        if (!filters.isEmpty()){
            for (Filter f : filters) roomList = f.filter(roomList);}
        return roomList;
    }
    ArrayList<Room> roomArrayList = roomLib.getRoomLibrary();
    /**
     * Receiving the search results by applying the active search to the room list.
     */

    /**
     *
     * @return the results of the filter
     */
    public List<Room> getResults(){
        //this.results = new ArrayList<>(filter(roomSet,filterSet));
        this.results = (List<Room>) filter(roomArrayList, filterSet);
        return this.results; }
}
