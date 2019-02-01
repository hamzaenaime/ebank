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

    public static final String ACCOUNT_SID = "AC41205ef605c974170e6786aff62ef7f5";
    public static final String AUTH_TOKEN = "5a4210a6eb454b5d7c732f233ffc78d4";

    private String ToNumber;
    private static String FromNumber = "+12563776488";
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
    }
}
