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


    private static final String ACCOUNT_SID = "api1";
    private static final String AUTH_TOKEN = "api2"; 

    private static final String TWILIO_PHONE_NUMBER = "Your twillio number"; //

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

