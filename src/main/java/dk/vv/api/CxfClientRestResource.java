package dk.vv.api;

import io.quarkiverse.cxf.annotation.CXFClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.oorsprong.websamples_countryinfo.CountryInfoServiceSoapType;


@Path("/cxf/country-client")
public class CxfClientRestResource {


    private final org.oorsprong.websamples_countryinfo.CountryInfoServiceSoapType countryInfoService;

    public CxfClientRestResource(@CXFClient("countryInfoService") CountryInfoServiceSoapType countryInfoService) {
        this.countryInfoService = countryInfoService;
    }

    @GET
    @Path("/CountryFlag")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFlag(@QueryParam("sCountryISOCode") String countryCode) {
        return this.countryInfoService.countryFlag(countryCode.toUpperCase());
    }

}