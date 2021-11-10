package at.htl.Entity;

public class Integration {
    private Device device;
    private Room room;


    //region constructor
    public Integration(Device device, Room room) {
        this.device = device;
        this.room = room;
    }

    public Integration() {
    }
    //endregion

    // region properties
    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    //endregion
}
