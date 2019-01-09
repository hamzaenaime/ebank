/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import com.sendgrid.*;
import java.io.IOException;

/**
 *
 * @author hamza
 */
public class SendEmail {

    private String api_key = "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";

    public SendEmail(String email, String subject, String body) {
        Email from = new Email("projectebank@ensat.ac.ma");
        Email to = new Email(email);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(api_key);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        new SendEmail("ayoub10hamaoui@gmail.com", "email verification", "code verification d'email est : 151515");
    }
}
