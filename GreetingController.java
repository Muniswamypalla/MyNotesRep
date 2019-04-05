package com.scb.jitloan.controller;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

@Controller
public class GreetingController {

    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACa24d925ccd329474373f87569c8ef686";
    public static final String AUTH_TOKEN = "c71611d73e1839520e384bcc22321f39";
    public static final String TWILIO_NUMBER = "+12056357853";
	
	
	@RequestMapping("/sendsms")
    public String greeting() {
        sendSMS();
        return "greeting";
    }
	
	
	public void sendSMS() {
    try {
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        // Build a filter for the MessageList
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("Body", "Hi Kukka How are doing? - Muni"));
        params.add(new BasicNameValuePair("To", "+919493439974")); //Add real number here
        params.add(new BasicNameValuePair("From", TWILIO_NUMBER));

        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message = messageFactory.create(params);
        System.out.println(message.getSid());
        System.out.println("SMS sent successfully ");
    } 
    catch (TwilioRestException e) {
        System.out.println(e.getErrorMessage());
    }
}
}