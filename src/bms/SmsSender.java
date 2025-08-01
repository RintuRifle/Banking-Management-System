/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASimulatorSystem;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {


    private static final String ACCOUNT_SID = "AC194d3280e62fa05f2a74efc74ec4d3dd";
    private static final String AUTH_TOKEN = "dce20ab3768da59bec5be7f283c0426d"; 

    private static final String TWILIO_PHONE_NUMBER = "+15073966776"; //

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public static void sendSms(String toPhoneNumber, String messageBody) {
        try {
            Message message = Message.creator(
                    new PhoneNumber(toPhoneNumber),  // Recipient's phone number
                    new PhoneNumber(TWILIO_PHONE_NUMBER), // Sender's Twilio phone number
                    messageBody
            ).create();

            System.out.println("SMS sent successfully to " + toPhoneNumber);
            System.out.println("Message SID: " + message.getSid());
        } catch (ApiException e) {
            e.printStackTrace();
            System.out.println("Error sending SMS: " + e.getMessage());
        }
    }
}
