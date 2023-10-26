import java.util.*;

public class HouseFilter implements Filter{

    House name;


    public HouseFilter(House name){
        this.name = name;
    }
    /*
    public void add
    */

    public Set<Room> filter(Set<Room> roomList){
        Set<Room> filteredList = new HashSet<Room>();
        for (Room r : roomList) {
            if (this.name == r.getHouse()) {
                filteredList.add(r);
            }
        }
        return filteredList;
    }
}
