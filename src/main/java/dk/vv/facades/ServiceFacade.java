package dk.vv.facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dk.vv.api.CxfClientRestResource;
import dk.vv.api.GenderService;
import dk.vv.api.LocationService;
import dk.vv.pojos.CountryInformation;
import dk.vv.pojos.GenderInformation;
import dk.vv.pojos.ParticipantInformation;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

public class ServiceFacade {

    private final LocationService locationService;
    private final GenderService genderService;

    private final CxfClientRestResource cxfClientRestResource;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();



    public ServiceFacade(@RestClient LocationService locationService, @RestClient GenderService genderService,CxfClientRestResource cxfClientRestResource) {
        this.locationService = locationService;
        this.genderService = genderService;
        this.cxfClientRestResource = cxfClientRestResource;
    }

    public List<ParticipantInformation> collectInformation(List<ParticipantInformation> participantInformationList) {


        for (ParticipantInformation participantInformation : participantInformationList) {
            String ip = participantInformation.getIpAddress();
             participantInformation.setCountryInformation(GSON.fromJson(
                     locationService.getCountry(ip).readEntity(String.class), CountryInformation.class)
             );
             participantInformation.setGender(
                        GSON.fromJson(genderService.getGender(participantInformation.getName(), participantInformation.getCountryInformation().getCountryCode())
                                .readEntity(String.class), GenderInformation.class).getGender()
             );
        }

        for (ParticipantInformation participantInformation : participantInformationList) {
            participantInformation.setFlagUrl(cxfClientRestResource.getFlag(participantInformation.getCountryInformation().getCountryCode()));
        }

        return participantInformationList;
    }





}
