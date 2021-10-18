package com.greenapex.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.greenapex.entity.SMSPojo;
import com.greenapex.entity.StoreOtp;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Component
public class SmsService {
     private final String ACCOUNT_SID ="AC1790197ca89bd0705ffee81e5c4ae228";

    private final String AUTH_TOKEN = "aa21c03dcd562c7f0050bef03d0a577d";

    private final String FROM_NUMBER = "+17272631594";

    public void send(SMSPojo sms) throws ParseException {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
    	
        int min = 100000;  
         int max = 999999; 
        int number=(int)(Math.random()*(max-min+1)+min);
      
        
        String msg ="Your OTP - "+number+ " please verify this OTP in your Application by Er Prince kumar Technoidentity.com";
       
        
        Message message = Message.creator(new PhoneNumber(sms.getPhoneNo()), new PhoneNumber(FROM_NUMBER), msg)
                .create();
       
      /*  Date myDate=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf. parse(myDate.toString()); 
        long millis = date. getTime(); 
        System.out.println(millis);
       OTPpojo.setOtp(number);
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction
*/
        StoreOtp.setOtp(number);
    }
    public void receive(MultiValueMap<String, String> smscallback) {
    	   
    }

  
}