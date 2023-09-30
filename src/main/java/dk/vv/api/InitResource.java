package dk.vv.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dk.vv.facades.MailFacade;
import dk.vv.facades.ServiceFacade;
import dk.vv.facades.TemplateFacade;
import dk.vv.pojos.ParticipantInformation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Produces("application/json")
@Path("/api")
@ApplicationScoped
public class InitResource {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final ServiceFacade serviceFacade;

    private final MailFacade mailFacade;

    private final TemplateFacade templateFacade;

    @Inject
    public InitResource(ServiceFacade serviceFacade, MailFacade mailFacade, TemplateFacade templateFacade) {
        this.serviceFacade= serviceFacade;
        this.mailFacade = mailFacade;
        this.templateFacade = templateFacade;
    }

    @Path("/init")
    @Consumes("application/json")
    @POST()
    public Response init(String content) {

        List<ParticipantInformation> participantInformationList = GSON.fromJson(content, new TypeToken<List<ParticipantInformation>>(){}.getType());

        participantInformationList = serviceFacade.collectInformation(participantInformationList);

        for(ParticipantInformation participantInformation : participantInformationList){
            String template = templateFacade.getTemplate(participantInformation);
            mailFacade.sendMail(template,participantInformation.getEmail());
        }

        return Response.ok().build();
    }
}
