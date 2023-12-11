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

        System.out.println("Dorm Review app: Search for a room\n");
        System.out.println("Although, ultimately, we will have four filters, one for each: house, floor, room type, and availability, for now, we will just be using the house filter.\n");
        System.out.println(" List of the houses are: Main, Strong, Raymond, Davison, Lathrop, Jewett, Josselyn, Cushing, Noyes\n" +
                "-If you want to search all the rooms, enter ALL.\n-If you want to stop searching, enter EXIT.\n");

        while(true) {
            System.out.println("Enter house: ");
            String input = scanner.nextLine();
            input = input.toUpperCase();

            if (input.equals("EXIT")) {
                break;
            }

            if (input.equals("ALL")) {
                System.out.println(exRoomLib.toString());
                continue;
            }

            try {
                name = House.valueOf(input);
            } catch(IllegalArgumentException e) {
                System.out.println("Invalid input. Only listed ones supported.");
                continue;
            }
            //public void search_by_HouseName(House name){
            HouseFilter houseFilter = new HouseFilter(name);
            //};

            Set<Room> roomSet = new HashSet<>(exRooms);

            Set<Room> f1 = houseFilter.filter(roomSet);

            Set<Filter> filterSet = new HashSet<>();
            filterSet.add(houseFilter);
            Set<Room> roomList = exRoomLib.Search(roomSet, filterSet);


            System.out.println(roomList.toString());
        }
    }
}
