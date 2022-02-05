package at.htl.boundary;

import at.htl.control.RoomRepository;
import at.htl.Entity.Room;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/room")
public class RoomResource {

    @Inject
    RoomRepository roomRepository;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance roomSimple(String name);
        public static native TemplateInstance room(Room room);
    }

    @Path("/simpleQute")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance getTxt(@QueryParam("name") String name){
        return Templates.roomSimple(name);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("id")int nr){
        return Templates.room(roomRepository.findByRoomNr(nr));
    }


    @RolesAllowed("user")
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> findAll(){
        return roomRepository.findAll();
    }

}
