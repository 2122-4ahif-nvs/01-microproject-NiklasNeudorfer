package at.htl.boundary;

import at.htl.control.OwnerRepository;
import at.htl.Entity.Owner;

import javax.inject.Inject;
import javax.validation.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/owner")
public class OwnerResource {

    @Inject
    Validator validator;

    @Inject
    OwnerRepository ownerRepository;

    @Path("/manual-validation")
    @POST
    public Result tryMeManualValidation(Owner owner){
        Set<ConstraintViolation<Owner>> violations = validator.validate(owner);
        if (violations.isEmpty()){
            return new Result("Owner is valid! It was validated by manual validation.");
        } else {
            return new Result(violations);
        }
    }

    @Path("/end-point-method-validation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result tryMeEndPointMethodValidation(@Valid Owner owner){
        return new Result("Owner is valid! It was validated by end point method validation.");
    }

    @Path("/service-method-validation")
    @POST
    public Result tryMeServiceMethodValidation(Owner owner){
        try{
            ownerRepository.validateOwner(owner);
            return new Result("Owner is valid! It was validated by service method validation.");
        }catch(ConstraintViolationException e){
            return new Result(e.getConstraintViolations());
        }
    }



    public static class Result {

        Result(String message) {
            this.success = true;
            this.message = message;
        }

        Result(Set<? extends ConstraintViolation<?>> violations) {
            this.success = false;
            this.message = violations.stream()
                    .map(cv -> cv.getMessage())
                    .collect(Collectors.joining(", "));
        }

        private String message;
        private boolean success;

        public String getMessage() {
            return message;
        }

        public boolean isSuccess() {
            return success;
        }

    }
}
