package com.greenapex.service.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.greenapex.entity.StoreOtp;
import com.greenapex.entity.StudentEntity;
import com.greenapex.entity.TempOtp;
import com.greenapex.repository.IStudentRepository;
import com.greenapex.service.IStudentService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class StudentServiceImpl implements IStudentService{
	
   @Autowired
   IStudentRepository studentRepository;
   
   private final String ACCOUNT_SID ="AC1790197ca89bd0705ffee81e5c4ae228";

   private final String AUTH_TOKEN = "aa21c03dcd562c7f0050bef03d0a577d";

   private final String FROM_NUMBER = "+17272631594";

   public void send(String sms) throws ParseException {
   	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
     
   	
       int min = 100000;  
        int max = 999999; 
       int number=(int)(Math.random()*(max-min+1)+min);
     
       
       String msg ="Your OTP - "+number+ " please verify this OTP in your Application by Er Prince kumar Technoidentity.com";
      
       
       Message message = Message.creator(new PhoneNumber(sms), new PhoneNumber(FROM_NUMBER), msg)
               .create();
      
       StoreOtp.setOtp(number);
   }
   public void receive(MultiValueMap<String, String> smscallback) {
   	   
   }
@Override
public TempOtp saveStudent(TempOtp student) {
	// TODO Auto-generated method stub
	return studentRepository.save(student);
}


}
