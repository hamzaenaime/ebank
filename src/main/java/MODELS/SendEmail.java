/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendEmail {
    
    
    public LinkedHashMap<String,String> Ct ;
        
    
    private String body; 
    private int subject;
    static int code;
    
    
    final public String username = "ebank.ensat@gmail.com";
    final public String password = "ebank2019";
    
    // Recipient's email ID needs to be mentioned.
    public String to;
    // Sender's email ID needs to be mentioned        
    final public String from="ebank.ensat@gmail.com";
    
    //send email with specifique body
    public SendEmail(String to,String title,String Nom,String Prenom,int subject){
        this.subject = subject;
        Ct=new LinkedHashMap<>();
        /* Populate */
        Ct.put( "Réclamation,","Nous avons bien reçu votre réclamation du"+new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())+" relatif à une erreur dans notre application.\n" +
                " Nous sommes désolés de cet incident et nous vous prions de bien vouloir nous en excuser. \n" +
                " Nous tenons à vous remercier de votre confiance et à vous assurer que nous prenons des mesures auprès de notre société pour nous assurer que ce problème ne se reproduise plus.\n" +
                " Nous vous prions de croire, Madame, Monsieur, à l’assurance de nos sentiments les meilleurs.");
        Ct.put("Merci d'avoir rejoint EBank","Ebank est aussi un service de <em>transfert</em> international simple, associant qualité et fiabilité pour envoyer ou recevoir de l'<em>argent</em> partout dans le Monde");
        Ct.put("Confirmez votre adresse email,","Merci pour votre inscription à Ebank. Nous sommes heureux que vous soyez là!\n"
                + " Entrez le code suivant dans la fenêtre où vous avez commencé à créer votre nouvel espace de travail Ebank:\n");
        Ct.put("Opérations,", "Veuillez trouver ci-joint la liste des opérations.");
        Ct.put("changement de mot de passe avec succès", "votre demande de changement de mot de passe a été approuvée avec succès");
        Ct.put("Creation d'un compte", "votre demande de Creer un compte e été envoyer avec succès nous allons vous contacter le plutot possible.");
        
        this.to=to;
        body=GenererBody(title,Nom,Prenom,subject);
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                }
          });

        try {

             Message message = new MimeMessage(session);
             // Set From: header field of the header.
             message.setFrom(new InternetAddress(this.from));
             // Set To: header field of the header.
             message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
             // Set Subject: header field
             message.setSubject((new ArrayList<>(Ct.keySet())).get(subject));
             // Create the message part
             BodyPart messageBodyPart = new MimeBodyPart();
             // Now set the actual message
             messageBodyPart.setContent(this.body,"text/html");
             // Create a multipar message
             Multipart multipart = new MimeMultipart();
             // Set text message part
             multipart.addBodyPart(messageBodyPart);
             String filename="./img/Ebank.png";
             if(subject==3){
                filename = "./21_JANUARY_2019_nafar_bill.pdf";
             }
             // Part two is attachment
             messageBodyPart = new MimeBodyPart();
             
             DataSource source = new FileDataSource(filename);
             messageBodyPart.setDataHandler(new DataHandler(source));
             messageBodyPart.setFileName(filename);
             multipart.addBodyPart(messageBodyPart);
             // Send the complete message parts
             message.setContent(multipart);
             // Send message
             Transport.send(message);
             System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
                throw new RuntimeException(e);
        }
    }
    
    
    //eType here for define the subject of email
    public String GenererBody(String title,String Nom,String Prenom,int subPos){
        //get Subject and Content from HashMap
        String Content    = (new ArrayList<>(Ct.values())).get(subPos);
        String  eType = (new ArrayList<>(Ct.keySet())).get(subPos);
        
        if(subPos==2){
            code = (int)((Math.random() * 900000)+100000); 
            //System.out.print(code);
        }
        
        
        String Body;
        Body = "<!doctype html>\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "	<head>\n" +
                "		<!--[if gte mso 15]>\n" +
                "		<xml>\n" +
                "			<o:OfficeDocumentSettings>\n" +
                "			<o:AllowPNG/>\n" +
                "			<o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "			</o:OfficeDocumentSettings>\n" +
                "		</xml>\n" +
                "		<![endif]-->\n" +
                "		<meta charset=\"UTF-8\">\n" +
                "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "		<title>*|MC:SUBJECT|*</title>\n" +
                "        \n" +
                "    <style type=\"text/css\">\n" +
                "		p{\n" +
                "			margin:10px 0;\n" +
                "			padding:0;\n" +
                "		}\n" +
                "		table{\n" +
                "			border-collapse:collapse;\n" +
                "		}\n" +
                "		h1,h2,h3,h4,h5,h6{\n" +
                "			display:block;\n" +
                "			margin:0;\n" +
                "			padding:0;\n" +
                "		}\n" +
                "		img,a img{\n" +
                "			border:0;\n" +
                "			height:auto;\n" +
                "			outline:none;\n" +
                "			text-decoration:none;\n" +
                "		}\n" +
                "		body,#bodyTable,#bodyCell{\n" +
                "			height:100%;\n" +
                "			margin:0;\n" +
                "			padding:0;\n" +
                "			width:100%;\n" +
                "		}\n" +
                "		.mcnPreviewText{\n" +
                "			display:none !important;\n" +
                "		}\n" +
                "		#outlook a{\n" +
                "			padding:0;\n" +
                "		}\n" +
                "		img{\n" +
                "			-ms-interpolation-mode:bicubic;\n" +
                "		}\n" +
                "		table{\n" +
                "			mso-table-lspace:0pt;\n" +
                "			mso-table-rspace:0pt;\n" +
                "		}\n" +
                "		.ReadMsgBody{\n" +
                "			width:100%;\n" +
                "		}\n" +
                "		.ExternalClass{\n" +
                "			width:100%;\n" +
                "		}\n" +
                "		p,a,li,td,blockquote{\n" +
                "			mso-line-height-rule:exactly;\n" +
                "		}\n" +
                "		a[href^=tel],a[href^=sms]{\n" +
                "			color:inherit;\n" +
                "			cursor:default;\n" +
                "			text-decoration:none;\n" +
                "		}\n" +
                "		p,a,li,td,body,table,blockquote{\n" +
                "			-ms-text-size-adjust:100%;\n" +
                "			-webkit-text-size-adjust:100%;\n" +
                "		}\n" +
                "		.ExternalClass,.ExternalClass p,.ExternalClass td,.ExternalClass div,.ExternalClass span,.ExternalClass font{\n" +
                "			line-height:100%;\n" +
                "		}\n" +
                "		a[x-apple-data-detectors]{\n" +
                "			color:inherit !important;\n" +
                "			text-decoration:none !important;\n" +
                "			font-size:inherit !important;\n" +
                "			font-family:inherit !important;\n" +
                "			font-weight:inherit !important;\n" +
                "			line-height:inherit !important;\n" +
                "		}\n" +
                "		#bodyCell{\n" +
                "			padding:10px;\n" +
                "		}\n" +
                "		.templateContainer{\n" +
                "			max-width:600px !important;\n" +
                "		}\n" +
                "		a.mcnButton{\n" +
                "			display:block;\n" +
                "		}\n" +
                "		.mcnImage,.mcnRetinaImage{\n" +
                "			vertical-align:bottom;\n" +
                "		}\n" +
                "		.mcnTextContent{\n" +
                "			word-break:break-word;\n" +
                "		}\n" +
                "		.mcnTextContent img{\n" +
                "			height:auto !important;\n" +
                "		}\n" +
                "		.mcnDividerBlock{\n" +
                "			table-layout:fixed !important;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Page\n" +
                "	@section Background Style\n" +
                "	@tip Set the background color and top border for your email. You may want to choose colors that match your company's branding.\n" +
                "	*/\n" +
                "		body,#bodyTable{\n" +
                "			/*@editable*/background-color:#FFFFFF;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Page\n" +
                "	@section Background Style\n" +
                "	@tip Set the background color and top border for your email. You may want to choose colors that match your company's branding.\n" +
                "	*/\n" +
                "		#bodyCell{\n" +
                "			/*@editable*/border-top:0;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Page\n" +
                "	@section Email Border\n" +
                "	@tip Set the border for your email.\n" +
                "	*/\n" +
                "		.templateContainer{\n" +
                "			/*@editable*/border:0;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Page\n" +
                "	@section Heading 1\n" +
                "	@tip Set the styling for all first-level headings in your emails. These should be the largest of your headings.\n" +
                "	@style heading 1\n" +
                "	*/\n" +
                "		h1{\n" +
                "			/*@editable*/color:#FFFFFF;\n" +
                "			/*@editable*/font-family:Georgia;\n" +
                "			/*@editable*/font-size:28px;\n" +
                "			/*@editable*/font-style:italic;\n" +
                "			/*@editable*/font-weight:bold;\n" +
                "			/*@editable*/line-height:125%;\n" +
                "			/*@editable*/letter-spacing:normal;\n" +
                "			/*@editable*/text-align:center;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Page\n" +
                "	@section Heading 2\n" +
                "	@tip Set the styling for all second-level headings in your emails.\n" +
                "	@style heading 2\n" +
                "	*/\n" +
                "		h2{\n" +
                "			/*@editable*/color:#FFFFFF;\n" +
                "			/*@editable*/font-family:Helvetica;\n" +
                "			/*@editable*/font-size:22px;\n" +
                "			/*@editable*/font-style:normal;\n" +
                "			/*@editable*/font-weight:bold;\n" +
                "			/*@editable*/line-height:125%;\n" +
                "			/*@editable*/letter-spacing:normal;\n" +
                "			/*@editable*/text-align:center;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Page\n" +
                "	@section Heading 3\n" +
                "	@tip Set the styling for all third-level headings in your emails.\n" +
                "	@style heading 3\n" +
                "	*/\n" +
                "		h3{\n" +
                "			/*@editable*/color:#FFFFFF;\n" +
                "			/*@editable*/font-family:Helvetica;\n" +
                "			/*@editable*/font-size:20px;\n" +
                "			/*@editable*/font-style:normal;\n" +
                "			/*@editable*/font-weight:bold;\n" +
                "			/*@editable*/line-height:125%;\n" +
                "			/*@editable*/letter-spacing:normal;\n" +
                "			/*@editable*/text-align:center;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Page\n" +
                "	@section Heading 4\n" +
                "	@tip Set the styling for all fourth-level headings in your emails. These should be the smallest of your headings.\n" +
                "	@style heading 4\n" +
                "	*/\n" +
                "		h4{\n" +
                "			/*@editable*/color:#FFFFFF;\n" +
                "			/*@editable*/font-family:Courier New;\n" +
                "			/*@editable*/font-size:18px;\n" +
                "			/*@editable*/font-style:normal;\n" +
                "			/*@editable*/font-weight:normal;\n" +
                "			/*@editable*/line-height:125%;\n" +
                "			/*@editable*/letter-spacing:normal;\n" +
                "			/*@editable*/text-align:center;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Preheader\n" +
                "	@section Preheader Style\n" +
                "	@tip Set the background color and borders for your email's preheader area.\n" +
                "	*/\n" +
                "		#templatePreheader{\n" +
                "			/*@editable*/background-color:#FFFFFF;\n" +
                "			/*@editable*/border-top:0;\n" +
                "			/*@editable*/border-bottom:0;\n" +
                "			/*@editable*/padding-top:9px;\n" +
                "			/*@editable*/padding-bottom:9px;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Preheader\n" +
                "	@section Preheader Text\n" +
                "	@tip Set the styling for your email's preheader text. Choose a size and color that is easy to read.\n" +
                "	*/\n" +
                "		#templatePreheader .mcnTextContent,#templatePreheader .mcnTextContent p{\n" +
                "			/*@editable*/color:#656565;\n" +
                "			/*@editable*/font-family:Helvetica;\n" +
                "			/*@editable*/font-size:12px;\n" +
                "			/*@editable*/line-height:150%;\n" +
                "			/*@editable*/text-align:center;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Preheader\n" +
                "	@section Preheader Link\n" +
                "	@tip Set the styling for your email's preheader links. Choose a color that helps them stand out from your text.\n" +
                "	*/\n" +
                "		#templatePreheader .mcnTextContent a,#templatePreheader .mcnTextContent p a{\n" +
                "			/*@editable*/color:#656565;\n" +
                "			/*@editable*/font-weight:normal;\n" +
                "			/*@editable*/text-decoration:underline;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Header\n" +
                "	@section Header Style\n" +
                "	@tip Set the background color and borders for your email's header area.\n" +
                "	*/\n" +
                "		#templateHeader{\n" +
                "			/*@editable*/background-color:#FFFFFF;\n" +
                "			/*@editable*/border-top:0;\n" +
                "			/*@editable*/border-bottom:0;\n" +
                "			/*@editable*/padding-top:0;\n" +
                "			/*@editable*/padding-bottom:9px;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Header\n" +
                "	@section Header Text\n" +
                "	@tip Set the styling for your email's header text. Choose a size and color that is easy to read.\n" +
                "	*/\n" +
                "		#templateHeader .mcnTextContent,#templateHeader .mcnTextContent p{\n" +
                "			/*@editable*/color:#202020;\n" +
                "			/*@editable*/font-family:Helvetica;\n" +
                "			/*@editable*/font-size:16px;\n" +
                "			/*@editable*/line-height:150%;\n" +
                "			/*@editable*/text-align:left;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Header\n" +
                "	@section Header Link\n" +
                "	@tip Set the styling for your email's header links. Choose a color that helps them stand out from your text.\n" +
                "	*/\n" +
                "		#templateHeader .mcnTextContent a,#templateHeader .mcnTextContent p a{\n" +
                "			/*@editable*/color:#2BAADF;\n" +
                "			/*@editable*/font-weight:normal;\n" +
                "			/*@editable*/text-decoration:underline;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Body\n" +
                "	@section Body Style\n" +
                "	@tip Set the background color and borders for your email's body area.\n" +
                "	*/\n" +
                "		#templateBody{\n" +
                "			/*@editable*/background-color:#7746b6;\n" +
                "			/*@editable*/border-top:0;\n" +
                "			/*@editable*/border-bottom:0;\n" +
                "			/*@editable*/padding-top:0;\n" +
                "			/*@editable*/padding-bottom:36px;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Body\n" +
                "	@section Body Text\n" +
                "	@tip Set the styling for your email's body text. Choose a size and color that is easy to read.\n" +
                "	*/\n" +
                "		#templateBody .mcnTextContent,#templateBody .mcnTextContent p{\n" +
                "			/*@editable*/color:#FFFFFF;\n" +
                "			/*@editable*/font-family:Helvetica;\n" +
                "			/*@editable*/font-size:16px;\n" +
                "			/*@editable*/line-height:150%;\n" +
                "			/*@editable*/text-align:left;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Body\n" +
                "	@section Body Link\n" +
                "	@tip Set the styling for your email's body links. Choose a color that helps them stand out from your text.\n" +
                "	*/\n" +
                "		#templateBody .mcnTextContent a,#templateBody .mcnTextContent p a{\n" +
                "			/*@editable*/color:#FFFFFF;\n" +
                "			/*@editable*/font-weight:normal;\n" +
                "			/*@editable*/text-decoration:underline;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Footer\n" +
                "	@section Footer Style\n" +
                "	@tip Set the background color and borders for your email's footer area.\n" +
                "	*/\n" +
                "		#templateFooter{\n" +
                "			/*@editable*/background-color:#FFFFFF;\n" +
                "			/*@editable*/border-top:0;\n" +
                "			/*@editable*/border-bottom:0;\n" +
                "			/*@editable*/padding-top:9px;\n" +
                "			/*@editable*/padding-bottom:9px;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Footer\n" +
                "	@section Footer Text\n" +
                "	@tip Set the styling for your email's footer text. Choose a size and color that is easy to read.\n" +
                "	*/\n" +
                "		#templateFooter .mcnTextContent,#templateFooter .mcnTextContent p{\n" +
                "			/*@editable*/color:#656565;\n" +
                "			/*@editable*/font-family:Helvetica;\n" +
                "			/*@editable*/font-size:12px;\n" +
                "			/*@editable*/line-height:150%;\n" +
                "			/*@editable*/text-align:center;\n" +
                "		}\n" +
                "	/*\n" +
                "	@tab Footer\n" +
                "	@section Footer Link\n" +
                "	@tip Set the styling for your email's footer links. Choose a color that helps them stand out from your text.\n" +
                "	*/\n" +
                "		#templateFooter .mcnTextContent a,#templateFooter .mcnTextContent p a{\n" +
                "			/*@editable*/color:#656565;\n" +
                "			/*@editable*/font-weight:normal;\n" +
                "			/*@editable*/text-decoration:underline;\n" +
                "		}\n" +
                "	@media only screen and (min-width:768px){\n" +
                "		.templateContainer{\n" +
                "			width:600px !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		body,table,td,p,a,li,blockquote{\n" +
                "			-webkit-text-size-adjust:none !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		body{\n" +
                "			width:100% !important;\n" +
                "			min-width:100% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		#bodyCell{\n" +
                "			padding-top:10px !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcnRetinaImage{\n" +
                "			max-width:100% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcnImage{\n" +
                "			width:100% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcnCartContainer,.mcnCaptionTopContent,.mcnRecContentContainer,.mcnCaptionBottomContent,.mcnTextContentContainer,.mcnBoxedTextContentContainer,.mcnImageGroupContentContainer,.mcnCaptionLeftTextContentContainer,.mcnCaptionRightTextContentContainer,.mcnCaptionLeftImageContentContainer,.mcnCaptionRightImageContentContainer,.mcnImageCardLeftTextContentContainer,.mcnImageCardRightTextContentContainer,.mcnImageCardLeftImageContentContainer,.mcnImageCardRightImageContentContainer{\n" +
                "			max-width:100% !important;\n" +
                "			width:100% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcnBoxedTextContentContainer{\n" +
                "			min-width:100% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcnImageGroupContent{\n" +
                "			padding:9px !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcnCaptionLeftContentOuter .mcnTextContent,.mcnCaptionRightContentOuter .mcnTextContent{\n" +
                "			padding-top:9px !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcnImageCardTopImageContent,.mcnCaptionBottomContent:last-child .mcnCaptionBottomImageContent,.mcnCaptionBlockInner .mcnCaptionTopContent:last-child .mcnTextContent{\n" +
                "			padding-top:18px !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcnImageCardBottomImageContent{\n" +
                "			padding-bottom:9px !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcnImageGroupBlockInner{\n" +
                "			padding-top:0 !important;\n" +
                "			padding-bottom:0 !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcnImageGroupBlockOuter{\n" +
                "			padding-top:9px !important;\n" +
                "			padding-bottom:9px !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcnTextContent,.mcnBoxedTextContentColumn{\n" +
                "			padding-right:18px !important;\n" +
                "			padding-left:18px !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcnImageCardLeftImageContent,.mcnImageCardRightImageContent{\n" +
                "			padding-right:18px !important;\n" +
                "			padding-bottom:0 !important;\n" +
                "			padding-left:18px !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "		.mcpreview-image-uploader{\n" +
                "			display:none !important;\n" +
                "			width:100% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "	/*\n" +
                "	@tab Mobile Styles\n" +
                "	@section Heading 1\n" +
                "	@tip Make the first-level headings larger in size for better readability on small screens.\n" +
                "	*/\n" +
                "		h1{\n" +
                "			/*@editable*/font-size:22px !important;\n" +
                "			/*@editable*/line-height:125% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "	/*\n" +
                "	@tab Mobile Styles\n" +
                "	@section Heading 2\n" +
                "	@tip Make the second-level headings larger in size for better readability on small screens.\n" +
                "	*/\n" +
                "		h2{\n" +
                "			/*@editable*/font-size:20px !important;\n" +
                "			/*@editable*/line-height:125% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "	/*\n" +
                "	@tab Mobile Styles\n" +
                "	@section Heading 3\n" +
                "	@tip Make the third-level headings larger in size for better readability on small screens.\n" +
                "	*/\n" +
                "		h3{\n" +
                "			/*@editable*/font-size:18px !important;\n" +
                "			/*@editable*/line-height:125% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "	/*\n" +
                "	@tab Mobile Styles\n" +
                "	@section Heading 4\n" +
                "	@tip Make the fourth-level headings larger in size for better readability on small screens.\n" +
                "	*/\n" +
                "		h4{\n" +
                "			/*@editable*/font-size:16px !important;\n" +
                "			/*@editable*/line-height:150% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "	/*\n" +
                "	@tab Mobile Styles\n" +
                "	@section Boxed Text\n" +
                "	@tip Make the boxed text larger in size for better readability on small screens. We recommend a font size of at least 16px.\n" +
                "	*/\n" +
                "		.mcnBoxedTextContentContainer .mcnTextContent,.mcnBoxedTextContentContainer .mcnTextContent p{\n" +
                "			/*@editable*/font-size:14px !important;\n" +
                "			/*@editable*/line-height:150% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "	/*\n" +
                "	@tab Mobile Styles\n" +
                "	@section Preheader Visibility\n" +
                "	@tip Set the visibility of the email's preheader on small screens. You can hide it to save space.\n" +
                "	*/\n" +
                "		#templatePreheader{\n" +
                "			/*@editable*/display:block !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "	/*\n" +
                "	@tab Mobile Styles\n" +
                "	@section Preheader Text\n" +
                "	@tip Make the preheader text larger in size for better readability on small screens.\n" +
                "	*/\n" +
                "		#templatePreheader .mcnTextContent,#templatePreheader .mcnTextContent p{\n" +
                "			/*@editable*/font-size:14px !important;\n" +
                "			/*@editable*/line-height:150% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "	/*\n" +
                "	@tab Mobile Styles\n" +
                "	@section Header Text\n" +
                "	@tip Make the header text larger in size for better readability on small screens.\n" +
                "	*/\n" +
                "		#templateHeader .mcnTextContent,#templateHeader .mcnTextContent p{\n" +
                "			/*@editable*/font-size:16px !important;\n" +
                "			/*@editable*/line-height:150% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "	/*\n" +
                "	@tab Mobile Styles\n" +
                "	@section Body Text\n" +
                "	@tip Make the body text larger in size for better readability on small screens. We recommend a font size of at least 16px.\n" +
                "	*/\n" +
                "		#templateBody .mcnTextContent,#templateBody .mcnTextContent p{\n" +
                "			/*@editable*/font-size:16px !important;\n" +
                "			/*@editable*/line-height:150% !important;\n" +
                "		}\n" +
                "\n" +
                "}	@media only screen and (max-width: 480px){\n" +
                "	/*\n" +
                "	@tab Mobile Styles\n" +
                "	@section Footer Text\n" +
                "	@tip Make the footer content text larger in size for better readability on small screens.\n" +
                "	*/\n" +
                "		#templateFooter .mcnTextContent,#templateFooter .mcnTextContent p{\n" +
                "			/*@editable*/font-size:14px !important;\n" +
                "			/*@editable*/line-height:150% !important;\n" +
                "		}\n" +
                "\n" +
                "}</style></head>\n" +
                "    <body>\n" +
                "        <!--*|IF:MC_PREVIEW_TEXT|*-->\n" +
                "        <!--[if !gte mso 9]><!----><span class=\"mcnPreviewText\" style=\"display:none; font-size:0px; line-height:0px; max-height:0px; max-width:0px; opacity:0; overflow:hidden; visibility:hidden; mso-hide:all;\">*|MC_PREVIEW_TEXT|*</span><!--<![endif]-->\n" +
                "        <!--*|END:IF|*-->\n" +
                "        <center>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" id=\"bodyTable\">\n" +
                "                <tr>\n" +
                "                    <td align=\"center\" valign=\"top\" id=\"bodyCell\">\n" +
                "                        <!-- BEGIN TEMPLATE // -->\n" +
                "						<!--[if gte mso 9]>\n" +
                "						<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">\n" +
                "						<tr>\n" +
                "						<td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">\n" +
                "						<![endif]-->\n" +
                "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\">\n" +
                "                            <tr>\n" +
                "                                <td valign=\"top\" id=\"templatePreheader\"><table class=\"mcnImageBlock\" style=\"min-width:100%;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
                "    <tbody class=\"mcnImageBlockOuter\">\n" +
                "            <tr>\n" +
                "                <td style=\"padding:9px\" class=\"mcnImageBlockInner\" valign=\"top\">\n" +
                "                    <table class=\"mcnImageContentContainer\" style=\"min-width:100%;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"left\">\n" +
                "                        <tbody><tr>\n" +
                "                            <td class=\"mcnImageContent\" style=\"padding-right: 9px; padding-left: 9px; padding-top: 0; padding-bottom: 0; text-align:center;\" valign=\"top\">\n" +
                "                                \n" +
                "                                    \n" +
                "                                        <img alt=\"\" src=\"https://gallery.mailchimp.com/0df4fe047767936dfb557990b/images/20d8ec5b-9ba1-4383-99f8-6fa50bd439f6.png\" style=\"max-width:2362px; padding-bottom: 0; display: inline !important; vertical-align: bottom;\" class=\"mcnImage\" width=\"564\" align=\"middle\">\n" +
                "                                    \n" +
                "                                \n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                    </tbody></table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "    </tbody>\n" +
                "</table></td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td valign=\"top\" id=\"templateHeader\"><table class=\"mcnImageBlock\" style=\"min-width:100%;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
                "    <tbody class=\"mcnImageBlockOuter\">\n" +
                "            <tr>\n" +
                "                <td style=\"padding:0px\" class=\"mcnImageBlockInner\" valign=\"top\">\n" +
                "                    <table class=\"mcnImageContentContainer\" style=\"min-width:100%;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"left\">\n" +
                "                        <tbody><tr>\n" +
                "                            <td class=\"mcnImageContent\" style=\"padding-right: 0px; padding-left: 0px; padding-top: 0; padding-bottom: 0; text-align:center;\" valign=\"top\">\n" +
                "                                \n" +
                "                                    \n" +
                "                                        <img alt=\"\" src=\"https://gallery.mailchimp.com/0df4fe047767936dfb557990b/images/2a0adb1d-2079-455f-ad98-b70304d1c4e1.png\" style=\"max-width:1920px; padding-bottom: 0; display: inline !important; vertical-align: bottom;\" class=\"mcnImage\" width=\"600\" align=\"middle\">\n" +
                "                                    \n" +
                "                                \n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                    </tbody></table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "    </tbody>\n" +
                "</table></td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td valign=\"top\" id=\"templateBody\"><table class=\"mcnTextBlock\" style=\"min-width:100%;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
                "    <tbody class=\"mcnTextBlockOuter\">\n" +
                "        <tr>\n" +
                "            <td class=\"mcnTextBlockInner\" style=\"padding-top:9px;\" valign=\"top\">\n" +
                "              	<!--[if mso]>\n" +
                "				<table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"width:100%;\">\n" +
                "				<tr>\n" +
                "				<![endif]-->\n" +
                "			    \n" +
                "				<!--[if mso]>\n" +
                "				<td valign=\"top\" width=\"600\" style=\"width:600px;\">\n" +
                "				<![endif]-->\n" +
                "                <table style=\"max-width:100%; min-width:100%;\" class=\"mcnTextContentContainer\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"left\">\n" +
                "                    <tbody><tr>\n" +
                "                        \n" +
                "                        <td class=\"mcnTextContent\" style=\"padding: 0px 18px 9px;color: #FFFFFF;font-family: &quot;Lato&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif;\" valign=\"top\">\n" +
                "                        \n" +
                "                            &nbsp;\n" +
                "<h1>Bonjour "+title+" "+ Nom +" "+ Prenom + ",</h1>\n" +
                "\n" +
                "<div style=\"text-align: center;\"><strong>"+eType+"</strong></div>\n" +
                "\n" +
                "<div style=\"text-align: left;\">EBank et la premiere solution première solution de transférer vous argents très rapidement.<br>\n" +
                "<span class=\"st\">"+Content+"</span><br/>"+"<center><h1>"+ SendEmail.code +"</h1></center></div>\n" +
                "\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </tbody></table>\n" +
                "				<!--[if mso]>\n" +
                "				</td>\n" +
                "				<![endif]-->\n" +
                "                \n" +
                "				<!--[if mso]>\n" +
                "				</tr>\n" +
                "				</table>\n" +
                "				<![endif]-->\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table></td>\n" +
                "                            </tr>\n" +
                "							<tr>\n" +
                "								<td align=\"center\" valign=\"top\">\n" +
                "									<img src=\"https://cdn-images.mailchimp.com/template_images/gallery/8a7030a1-3d71-45ca-aa5d-e244b31efdf5.png\" width=\"100%\" height=\"auto\" style=\"display:block; margin:0; padding:0;\">\n" +
                "								</td>\n" +
                "							</tr>\n" +
                "                            <tr>\n" +
                "                                <td valign=\"top\" id=\"templateFooter\"><table class=\"mcnFollowBlock\" style=\"min-width:100%;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
                "    <tbody class=\"mcnFollowBlockOuter\">\n" +
                "        <tr>\n" +
                "            <td style=\"padding:9px\" class=\"mcnFollowBlockInner\" valign=\"top\" align=\"center\">\n" +
                "                <table class=\"mcnFollowContentContainer\" style=\"min-width:100%;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "        <td style=\"padding-left:9px;padding-right:9px;\" align=\"center\">\n" +
                "            <table style=\"min-width:100%;\" class=\"mcnFollowContent\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
                "                <tbody><tr>\n" +
                "                    <td style=\"padding-top:9px; padding-right:9px; padding-left:9px;\" valign=\"top\" align=\"center\">\n" +
                "                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\">\n" +
                "                            <tbody><tr>\n" +
                "                                <td valign=\"top\" align=\"center\">\n" +
                "                                    <!--[if mso]>\n" +
                "                                    <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                    <tr>\n" +
                "                                    <![endif]-->\n" +
                "                                    \n" +
                "                                        <!--[if mso]>\n" +
                "                                        <td align=\"center\" valign=\"top\">\n" +
                "                                        <![endif]-->\n" +
                "                                        \n" +
                "                                        \n" +
                "                                            <table style=\"display:inline;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"left\">\n" +
                "                                                <tbody><tr>\n" +
                "                                                    <td style=\"padding-right:10px; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\" valign=\"top\">\n" +
                "                                                        <table class=\"mcnFollowContentItem\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
                "                                                            <tbody><tr>\n" +
                "                                                                <td style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\" valign=\"middle\" align=\"left\">\n" +
                "                                                                    <table width=\"\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"left\">\n" +
                "                                                                        <tbody><tr>\n" +
                "                                                                            \n" +
                "                                                                                <td class=\"mcnFollowIconContent\" width=\"24\" valign=\"middle\" align=\"center\">\n" +
                "                                                                                    <a href=\"http://www.twitter.com/\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/light-twitter-48.png\" style=\"display:block;\" class=\"\" width=\"24\" height=\"24\"></a>\n" +
                "                                                                                </td>\n" +
                "                                                                            \n" +
                "                                                                            \n" +
                "                                                                        </tr>\n" +
                "                                                                    </tbody></table>\n" +
                "                                                                </td>\n" +
                "                                                            </tr>\n" +
                "                                                        </tbody></table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody></table>\n" +
                "                                        \n" +
                "                                        <!--[if mso]>\n" +
                "                                        </td>\n" +
                "                                        <![endif]-->\n" +
                "                                    \n" +
                "                                        <!--[if mso]>\n" +
                "                                        <td align=\"center\" valign=\"top\">\n" +
                "                                        <![endif]-->\n" +
                "                                        \n" +
                "                                        \n" +
                "                                            <table style=\"display:inline;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"left\">\n" +
                "                                                <tbody><tr>\n" +
                "                                                    <td style=\"padding-right:10px; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\" valign=\"top\">\n" +
                "                                                        <table class=\"mcnFollowContentItem\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
                "                                                            <tbody><tr>\n" +
                "                                                                <td style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\" valign=\"middle\" align=\"left\">\n" +
                "                                                                    <table width=\"\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"left\">\n" +
                "                                                                        <tbody><tr>\n" +
                "                                                                            \n" +
                "                                                                                <td class=\"mcnFollowIconContent\" width=\"24\" valign=\"middle\" align=\"center\">\n" +
                "                                                                                    <a href=\"http://www.facebook.com\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/light-facebook-48.png\" style=\"display:block;\" class=\"\" width=\"24\" height=\"24\"></a>\n" +
                "                                                                                </td>\n" +
                "                                                                            \n" +
                "                                                                            \n" +
                "                                                                        </tr>\n" +
                "                                                                    </tbody></table>\n" +
                "                                                                </td>\n" +
                "                                                            </tr>\n" +
                "                                                        </tbody></table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody></table>\n" +
                "                                        \n" +
                "                                        <!--[if mso]>\n" +
                "                                        </td>\n" +
                "                                        <![endif]-->\n" +
                "                                    \n" +
                "                                        <!--[if mso]>\n" +
                "                                        <td align=\"center\" valign=\"top\">\n" +
                "                                        <![endif]-->\n" +
                "                                        \n" +
                "                                        \n" +
                "                                            <table style=\"display:inline;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"left\">\n" +
                "                                                <tbody><tr>\n" +
                "                                                    <td style=\"padding-right:0; padding-bottom:9px;\" class=\"mcnFollowContentItemContainer\" valign=\"top\">\n" +
                "                                                        <table class=\"mcnFollowContentItem\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
                "                                                            <tbody><tr>\n" +
                "                                                                <td style=\"padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;\" valign=\"middle\" align=\"left\">\n" +
                "                                                                    <table width=\"\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"left\">\n" +
                "                                                                        <tbody><tr>\n" +
                "                                                                            \n" +
                "                                                                                <td class=\"mcnFollowIconContent\" width=\"24\" valign=\"middle\" align=\"center\">\n" +
                "                                                                                    <a href=\"http://mailchimp.com\" target=\"_blank\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/light-link-48.png\" style=\"display:block;\" class=\"\" width=\"24\" height=\"24\"></a>\n" +
                "                                                                                </td>\n" +
                "                                                                            \n" +
                "                                                                            \n" +
                "                                                                        </tr>\n" +
                "                                                                    </tbody></table>\n" +
                "                                                                </td>\n" +
                "                                                            </tr>\n" +
                "                                                        </tbody></table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody></table>\n" +
                "                                        \n" +
                "                                        <!--[if mso]>\n" +
                "                                        </td>\n" +
                "                                        <![endif]-->\n" +
                "                                    \n" +
                "                                    <!--[if mso]>\n" +
                "                                    </tr>\n" +
                "                                    </table>\n" +
                "                                    <![endif]-->\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </tbody></table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody></table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</tbody></table>\n" +
                "\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table></td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "						<!--[if gte mso 9]>\n" +
                "						</td>\n" +
                "						</tr>\n" +
                "						</table>\n" +
                "						<![endif]-->\n" +
                "                        <!-- // END TEMPLATE -->\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </center>\n" +
                "    </body>\n" +
                "</html>";
        
        
        return Body;
    }

}