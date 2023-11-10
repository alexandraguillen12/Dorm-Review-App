import java.util.ArrayList;
import java.util.Set;

public class RoomLibrary {
    public ArrayList<Room> rooms = new ArrayList<>();

    public int size = 5;
    //just for this example

    public RoomLibrary(ArrayList<Room> rooms){
        this.rooms = rooms;
    }

    public void addRoom(Room room){

        this.size ++;
    }


    public String toString(){
        int i = 1;
        String rl = "";
        for (Room r : this.rooms){
            rl += i + ": " + r + "\n";
            i ++;
        }
        return rl;
    }

    public Set<Room> Search(Set<Room> roomList, Set<Filter> filters){
        for (Filter f : filters) roomList = f.filter(roomList);
        return roomList;
    }

}
