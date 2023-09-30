package dk.vv.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@RegisterRestClient(configKey = "location-api")
public interface LocationService {

    @GET
    @Path("/{ip}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getCountry(@PathParam("ip") String ip);
}
