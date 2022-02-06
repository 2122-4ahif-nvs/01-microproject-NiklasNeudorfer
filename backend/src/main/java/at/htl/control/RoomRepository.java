package at.htl.control;

import at.htl.entity.Room;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RoomRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Room save(Room room) {
        return em.merge(room);
    }

    public List<Room> findAll() {
        return em.createNamedQuery("Room.findAll",Room.class).getResultList();
    }

    public Room findByRoomNr(int roomNr){
        TypedQuery<Room> query = em
                .createNamedQuery("Room.findByRoomNr",Room.class)
                .setParameter("NR",roomNr);
        return query.getSingleResult();
    }

    @Transactional
    public void removeRoom(int roomNr){
        Query query = em
                .createNamedQuery("Room.removeByNr")
                .setParameter("NR",roomNr);
        query.executeUpdate();
    }

    public List<Room> findRoomsByFloor(int floor) {
        TypedQuery<Room> query = em
                .createNamedQuery("Room.findRoomByFloor",Room.class)
                .setParameter("FLOOR",floor);
        return query.getResultList();
    }
}
