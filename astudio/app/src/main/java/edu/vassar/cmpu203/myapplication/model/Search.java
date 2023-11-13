package edu.vassar.cmpu203.myapplication.model;
import java.util.*;
import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


public class Search {

    private List<Room> results;
    Set<Filter> filterSet = new HashSet<>();



    public Search(){
        this.results = new ArrayList<>();
    };

    public void addFilters(House name, int floor, RoomType type, boolean availability){
        HouseFilter houseFilter = new HouseFilter(name);
        FloorFilter floorFilter = new FloorFilter(floor);
        RoomTypeFilter roomTypeFilter = new RoomTypeFilter(type);
        AvailabilityFilter availabilityFilter = new AvailabilityFilter(availability);
        this.filterSet.add(houseFilter);
        this.filterSet.add(floorFilter);
        this.filterSet.add(roomTypeFilter);
        this.filterSet.add(availabilityFilter);
    }



    Set<Room> roomSet = new HashSet<>();

    public Set<Room> filter(Set<Room> roomList, Set<Filter> filters) {
        for (Filter f : filters) roomList = f.filter(roomList);
        return roomList;
    }


    //this.filterSet.add(houseFilter);



    //results = roomLib.filter(roomSet, filterSet);
    public List<Room> getResults(){ return this.results; }
}
