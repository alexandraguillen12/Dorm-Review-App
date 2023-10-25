public class Room {
    private Enum House;
    private int Floor;
    private Enum RoomType;
    private boolean Availability;

    public Room(Enum house, int floor, Enum roomType, boolean availability){
        this.House = house;
        this.Floor = floor;
        this.RoomType = roomType;
        this.Availability = availability;
    };
    public Enum getHouse(){
        return this.House;
    };

    public int getFloor(){
        return this.Floor;
    };

    public Enum getRoomType(){
        return this.RoomType;
    };

    public boolean getAvailability(){
        return this.Availability;
    };

    public String toString(){
        return String.format("Room (%s, %d, %s, %s)", this.House, this.Floor, this.RoomType, this.Availability);
    };

}
