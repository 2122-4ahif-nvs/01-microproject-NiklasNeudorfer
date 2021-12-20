package at.htl.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;



@NamedQueries({
@NamedQuery(
        name = "Room.findAll",
        query = "select r from Room r"
),
@NamedQuery(
        name = "Room.findByRoomNr",
        query = "select r from Room r where r.roomNr = :NR"
),
@NamedQuery(
        name = "Room.removeByNr",
        query = "DELETE from Room r where r.roomNr = :NR"
),
@NamedQuery(
        name = "Room.findRoomByFloor",
        query = "select r from Room r where r.floor = :FLOOR"
)
})

@Entity
@Table(name = "BM_ROOM")
public class Room {
    @Id
    @Column(name = "R_ROOMNR")
    private int roomNr;

    @Column(name = "R_FLOOR")
    private int floor;

    @Column(name = "R_NAME")
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
