package at.htl.boundary;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello Building Manager User!";
    }

    /*
    @GET
    @Path("jsonp")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject jsonP(){
        JsonObject susi = Json.createObjectBuilder()
                .add("name","Susi")
                .add("city", "leonding")
                .build();
        return susi;
    }*/

    @GET
    @Path("jsonp")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject deviceJsonP(){
        return  Json.createObjectBuilder()
                .add("Name","susi")
                .build();
    }

    @GET
    @Path("jsonpXML")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public JsonObject deviceJsonPXMl(){
        return  Json.createObjectBuilder()
                .add("Name","susi")
                .build();
    }
}