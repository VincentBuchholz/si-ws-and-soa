package dk.vv;

import dk.vv.api.CxfClientRestResource;
import dk.vv.api.GenderService;
import dk.vv.api.LocationService;
import dk.vv.facades.MailFacade;
import dk.vv.facades.ServiceFacade;
import dk.vv.facades.TemplateFacade;
import io.quarkiverse.cxf.annotation.CXFClient;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.ApplicationPath;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class Producers {

    @Produces
    ServiceFacade getServiceFacade(@RestClient LocationService locationService, @RestClient GenderService genderService,CxfClientRestResource cxfClientRestResource){
        return new ServiceFacade(locationService,genderService,cxfClientRestResource);
    }
    @Inject
    Mailer mailer;

    @Produces
    MailFacade getMailFacade(){
        return new MailFacade(mailer);
    }

    @Produces
    TemplateFacade getTemplateFacade(){
        return new TemplateFacade();
    }

}
