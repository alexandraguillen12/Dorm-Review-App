import java.util.Set;

public interface Filter {


    Set<Room> filter(Set<Room> roomList);

    /*public Set<Room> filter(Set<Room> roomList, Set<Filter> filters); {
        for (Filter f : filters) roomList = f.filter(roomList);
        return roomList;
    }*/
}

