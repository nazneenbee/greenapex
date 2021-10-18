package com.greenapex.controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenapex.config.WebSocketConfig;
import com.greenapex.entity.StoreOtp;
import com.greenapex.entity.StudentEntity;
import com.greenapex.entity.TempOtp;
import com.greenapex.service.IStudentService;
import com.mysql.cj.Session;

@Controller
@RequestMapping("api")
public class StudentController {
	@Autowired
	IStudentService studentService;
	
	@Autowired
    private SimpMessagingTemplate webSocket;
	
	 private final String  TOPIC_DESTINATION = "/lesson/sms";
	 
	@GetMapping("otpsend")
	public String sendOtpFom()
	{
		return "otpsend";
	}
	
	@PostMapping("savestudent")
	public TempOtp saveStudent(@ModelAttribute TempOtp student)
	{
		System.out.println("Saving Student"+student.getRollNo());
		return studentService.saveStudent(student);
	}
	
	 @PostMapping("/mobileNo")
	    public String smsSubmit(@ModelAttribute StudentEntity sms,Model model, HttpSession session) {
	        try{
	        	session.setAttribute("name", sms.getName());
	        	session.setAttribute("email", sms.getEmail());
	        	session.setAttribute("course", sms.getCourse());
	        	session.setAttribute("contact", sms.getContact());
	        	session.setAttribute("branch", sms.getBranch());
	        	
	        	model.addAttribute("data",session);
	        	
	        	System.out.println(sms);
	        	   
	               studentService.send(sms.getContact());
	            System.out.println("hello");
	        }
	        catch(Exception e){

	        	 //return new ResponseEntity<String>("Some Problem",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: "+sms.getContact());
	       // return new ResponseEntity<String>("Otp send successfully",HttpStatus.OK);
	        return "otpverify";
	    }
	 
	 private String getTimeStamp() {
	       return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
	    }
	    
	 
	 @PostMapping("/otp")	
	 public String verifyOtp(@ModelAttribute TempOtp sms,Model model)
	 {
		TempOtp s=new TempOtp();
		s.setName(sms.getName());
		s.setContact(sms.getContact());
		s.setCourse(sms.getCourse());
		s.setEmail(sms.getEmail());
		s.setBranch(sms.getBranch());
	 	if(sms.getOtp()==StoreOtp.getOtp())
	 	{
	 		studentService.saveStudent(s);
	 	System.out.println("data save successfully");
	 	return "abc";
	 	}
	 	else
	 		{System.out.println("data not save");}
		return "xyz";
	 }

    
}
