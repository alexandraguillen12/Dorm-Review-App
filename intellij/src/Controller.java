import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static void main(String[] args){

        Room r1 = new Room(House.JEWETT, 6, RoomType.SINGLE, false);
        Room r2 = new Room(House.CUSHING, 4, RoomType.SINGLE, false);
        Room r3 = new Room(House.DAVISON, 5, RoomType.TRIPLE, true);
        Room r4 = new Room(House.JEWETT, 1, RoomType.DOUBLE, true);
        Room r5 = new Room(House.NOYES, 3, RoomType.DOUBLE, true);

        ArrayList<Room> exRooms = new ArrayList<Room>();
        exRooms.add(r1);
        exRooms.add(r2);
        exRooms.add(r3);
        exRooms.add(r4);
        exRooms.add(r5);

        RoomLibrary exRoomLib = new RoomLibrary(exRooms);

        House name;

        //public void search_by_HouseName(House name){ };

        HouseFilter houseFilter = new HouseFilter();

        System.out.println(exRoomLib.toString());
    }
}
