import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class HouseFilter {

    House name;


    /*
    public void add
    */

    Set<Room> filter(Set<Room> roomList, House name){
        Set<Room> filteredList = null;
        for (Room r : roomList) {
            if (name == r.getHouse()) {
                filteredList.add(r);
            }
        }
        return filteredList;
    }
}
