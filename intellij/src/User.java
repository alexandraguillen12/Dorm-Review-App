import java.util.Set;

public interface User {

    public default void display(Set<Room> roomList){
        System.out.println(roomList);
    }
}

/*
public Search_criteria(){
    MyValue = 0;
}
public static void main(String[] args) {
        // Creating objects using constructors
        MyClass obj1 = new MyClass();      // Calls the default constructor
        MyClass obj2 = new MyClass(5);    // Calls the parameterized constructor

        System.out.println("obj1 myValue: " + obj1.getMyValue());  // Output: obj1 myValue: 0
        System.out.println("obj2 myValue: " + obj2.getMyValue());  // Output: obj2 myValue: 5
    }
*/
