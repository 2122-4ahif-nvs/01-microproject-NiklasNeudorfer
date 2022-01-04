package at.htl.Boundary;

import at.htl.Control.RoomRepository;
import at.htl.Entity.Room;
import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class RoomResourceGraphQL {
    @Inject
    RoomRepository roomRepository;

    @Query("allRooms")
    @Description("Get all Rooms")
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    @Query
    @Description("Get a Room by RoomNr")
    public Room getRoom(@Name("roomNr") int id){
        return roomRepository.findByRoomNr(id);
    }

    @Query("getByFloor")
    @Description("Get a Room by the Floor it is on")
    public List<Room> getRoomByFloor(@Name("floor") int floor){
        return roomRepository.findRoomsByFloor(floor);
    }

    @Mutation
    public Room createRoom(Room room){
        return roomRepository.save(room);
    }

    @Mutation
    public Room deleteRoom(int roomNr){
        Room r = roomRepository.findByRoomNr(roomNr);
        roomRepository.removeRoom(roomNr);
        return r;
    }

}
