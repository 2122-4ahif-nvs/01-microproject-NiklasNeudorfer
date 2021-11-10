package at.htl.Entity;

public class Room {
    private int roomNr;
    private int floor;
    private String name;

    //region constructor
    public Room(int roomNr, int floor, String name) {
        this.roomNr = roomNr;
        this.floor = floor;
        this.name = name;
    }

    public Room() {
    }
    //endregion

    //region properties
    public int getRoomNr() {
        return roomNr;
    }

    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
}
