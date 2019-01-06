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
        Email from = new Email("projectebank@gmail.com");
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
        new SendEmail("hamzaenaime1997@gmail.com", "email verification", "code verification d'email est : 151515");
    }
}
