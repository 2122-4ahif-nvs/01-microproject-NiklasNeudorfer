package at.htl.Boundary;

import at.htl.Control.DeviceRepository;
import at.htl.Entity.Device;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/device")
public class DeviceResource {

    @Inject
    DeviceRepository deviceRepository;

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveDevice(Device device){
        deviceRepository.save(device);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> getDevices(){
        return deviceRepository.findAll();
    }

    @GET
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getDevicePerJsonb(
            @QueryParam("n") @DefaultValue("") String device_name
    ){
        return Response.ok(new Device(device_name)).build();
    }

}
