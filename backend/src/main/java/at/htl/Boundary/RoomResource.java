package at.htl.Boundary;

import at.htl.Control.RoomRepository;
import at.htl.Entity.Device;
import at.htl.Entity.Room;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

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

    @Path("htmlQute/{id}")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getHtml(@PathParam("id")int nr){
        return Templates.room(roomRepository.findByRoomNr(nr));
    }


    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> findAll(){
        return roomRepository.findAll();
    }

}
