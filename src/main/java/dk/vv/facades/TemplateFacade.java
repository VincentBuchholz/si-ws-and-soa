package dk.vv.facades;

import dk.vv.pojos.ParticipantInformation;

public class TemplateFacade {




    public String getTemplate(ParticipantInformation participantInformation) {

        StringBuilder sb = new StringBuilder();

        sb.append("<p>Dear ")
                .append(getTitle(participantInformation.getGender()))
                .append(" ")
                .append(participantInformation.getName())
                .append("</p>")
                .append("</br>")
                .append("<p>We hereby invite you to our event</p>")
                .append("</br>")
                .append("<p>Best regards</p>")
                .append("<p>V&V</p>")
                .append("</br>")
                .append("<sub><i>now with the flag of your country from a SOAP service</i></sub></br>")
                .append("<p><img src=\"")
                .append(participantInformation.getFlagUrl())
                .append("\"/></p>");

        return sb.toString();
    }


    private String getTitle(String gender){
        if (gender.equalsIgnoreCase("male")){
            return "Mr.";
        } else if (gender.equalsIgnoreCase("female")){
            return "Mrs.";
        } else {
            return "";
        }
    }
}
