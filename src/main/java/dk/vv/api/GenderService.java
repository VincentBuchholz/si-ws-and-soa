package dk.vv.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "gender-api")
public interface GenderService {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    Response getGender(@QueryParam("name") String name, @QueryParam("country_id") String countryCode);
}
