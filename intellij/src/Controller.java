import java.util.*;

public class Controller {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

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

        System.out.println("Dorm Review app: Search for a room");
        System.out.println(" _Use case is specified using only House case.");
        System.out.println(" List of the houses are: Main, Strong, Raymond, Davidson, Lathrop, Jewett, Josselyn, Cushing, Noyes," +
                "If you want to search all the rooms write ALL, if you want to stop searching press EXIT," +
                "If there's no matching for the house print NO RESULTS, ")

        System.out.println("Enter house: ");
        String input = scanner.nextLine();
        name = House.valueOf(input.toUpperCase());

        //public void search_by_HouseName(House name){
            HouseFilter houseFilter = new HouseFilter(name);
        //};

        Set<Room> roomSet = new HashSet<>(exRooms);

        Set<Room> f1 = houseFilter.filter(roomSet);

        Set<Filter> filterSet = new HashSet<>();
        filterSet.add(houseFilter);
        Set<Room> roomList = exRoomLib.Search(roomSet, filterSet);


        System.out.println(roomList.toString());
        //System.out.println(exRoomLib.toString());
    }
}
