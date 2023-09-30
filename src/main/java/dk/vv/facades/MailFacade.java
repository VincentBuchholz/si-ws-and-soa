package dk.vv.facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dk.vv.api.GenderService;
import dk.vv.api.LocationService;
import dk.vv.pojos.CountryInformation;
import dk.vv.pojos.GenderInformation;
import dk.vv.pojos.ParticipantInformation;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.Map;

public class MailFacade {

    Mailer mailer;
    public MailFacade(Mailer mailer) {
        this.mailer = mailer;
    }

    public void sendMail(String template,String email){

        Mail mail = new Mail();

        mail.setSubject("Event invite");

        mail.setHtml(template);

        mail.addTo(email);



        mailer.send(mail);
    }
}
