/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

/**
 *
 * @author dell
 */
public class SendSMS {

    public static final String ACCOUNT_SID = "ACe35a2f9e04495eb7eb54a0d60532ab5f";
    public static final String AUTH_TOKEN = "f7480c5d8b7c7f0f5741d9bc85a5a215";

    private String ToNumber;
    private static String FromNumber = "+1 470 460 7179";
    private String Body;

    public SendSMS(String ToNumber, String Body) {
        this.ToNumber = ToNumber;
        this.Body = Body;

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(ToNumber.toString()),
                new com.twilio.type.PhoneNumber(FromNumber.toString()),
                Body.toString())
                .create();

        System.out.println(message.getSid());
    }

}
