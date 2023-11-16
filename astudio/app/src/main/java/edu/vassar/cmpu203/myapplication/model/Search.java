package edu.vassar.cmpu203.myapplication.model;
import java.util.*;

import java.util.ArrayList;
import java.util.List;


public class Search {

    private List<Room> results;
    Set<Filter> filterSet = new HashSet<>();
    RoomLibrary roomLib = new RoomLibrary();



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



    public ArrayList<Room> filter(ArrayList<Room> roomList, Set<Filter> filters) {
        for (Filter f : filters) roomList = f.filter(roomList);
        return roomList;
    }



    ArrayList<Room> roomArrayList = roomLib.getRoomLibrary();

    public List<Room> getResults(){
        //this.results = new ArrayList<>(filter(roomSet,filterSet));
        this.results = (List<Room>) filter(roomArrayList, filterSet);
        return this.results; }
}
