package at.htl.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "BM_ROOM")
public class Room {
      @Column(name = "R_ROOMNR")
    private int roomNr;

    @Column(name = "R_FLOOR")
    private int floor;

    @Column(name = "R_NAME")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "R_ID")
    private Long id;

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

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
    //endregion
}
