import java.util.*;

public class HouseFilter {

    House name;


    /*
    public void add
    */

    Set<Room> filter(Set<Room> roomList, House name){
        Set<Room> filteredList = new HashSet<Room>();
        for (Room r : roomList) {
            if (name == r.getHouse()) {
                filteredList.add(r);
            }
        }
        return filteredList;
    }
}
