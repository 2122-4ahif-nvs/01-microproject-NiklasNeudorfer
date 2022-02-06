package at.htl.boundary;

import at.htl.control.OwnerRepository;
import at.htl.entity.Owner;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import org.jboss.logging.annotations.Pos;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("owner")
public class OwnerQute {

    @Inject
    OwnerRepository repository;

    @CheckedTemplate
    public static class Templates{
        public static native TemplateInstance addOwner();
        public static native TemplateInstance ownerAll(List<Owner> ownerList);
    }

    @Path("/all")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getAllOwnersPage(){
        return Templates.ownerAll(repository.findAll());
    }


    @Path("/new")
    @POST
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getAddOwnerPage(){
        return Templates.addOwner();
    }



}
