/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

/**
 *
 * @author dell
 */
import com.sendgrid.Attachments;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
 
 
public class Sendmailwithattachment {
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 Email from = new Email("projectebank@gmail.com");
 	    String subject = "Sending with SendGrid is Fun";
 	    Email to = new Email("ayoub10hamaoui@gmail.com");
 	    Content content = new Content("text/plain", "hi mr Ayoub");
 	    Mail mail = new Mail(from, subject, to, content);
 	   File file = new File("C:\\Users\\dell\\Desktop\\Projects\\School\\ebank\\9_JANUARY_2019_nafar_bill.pdf");
 	   byte[] filedata=org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(file));
 	  Base64 x = new Base64();
 	 String imageDataString = x.encodeAsString(filedata);
 	 Attachments attachments3 = new Attachments();
       attachments3.setContent(imageDataString);
       attachments3.setType("application/pdf");//"application/pdf"
       attachments3.setFilename("9_JANUARY_2019_nafar_bill.pdf");
       attachments3.setDisposition("attachment");
       attachments3.setContentId("Banner");
       mail.addAttachments(attachments3);
     SendGrid sg = new SendGrid("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");
 	 System.out.println(sg);
 	    Request request = new Request();
 	    System.out.println(request);
 	    try {
 	      request.setMethod(Method.POST);
 	      request.setEndpoint("mail/send");
 	      request.setBody(mail.build());
 	      Response response = sg.api(request);
 	      System.out.println(response);
 	      System.out.println(response.getStatusCode());
 	      System.out.println(response.getBody());
 	      System.out.println(response.getHeaders());
 	    } catch (IOException ex) {
 	      throw ex;
 	    }
 
	}
 
}