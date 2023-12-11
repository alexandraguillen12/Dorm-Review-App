import java.util.Set;

public interface User {

    public default void display(Set<Room> roomList){
        System.out.println(roomList);
    }
}


