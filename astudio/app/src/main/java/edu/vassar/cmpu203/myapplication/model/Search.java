package edu.vassar.cmpu203.myapplication.model;
import java.util.*;
public class Search {

    House name;
    int floor;
    RoomType type;
    boolean availability;
    HouseFilter houseFilter = new HouseFilter(name);
    FloorFilter floorFilter = new FloorFilter(floor);
    RoomTypeFilter roomTypeFilterFilter = new RoomTypeFilter(type);
    AvailabilityFilter availabilityFilter = new AvailabilityFilter(availability);

    Set<Room> roomSet = new HashSet<>();

    //Set<Room> f1 = houseFilter.filter(roomSet);

    Set<Filter> filterSet = new HashSet<>();
    //filterSet.add(houseFilter);

    //Set<Room> roomList = exRoomLib.Search(roomSet, filterSet);
}
