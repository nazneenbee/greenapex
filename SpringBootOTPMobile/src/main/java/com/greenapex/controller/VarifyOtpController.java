package com.greenapex.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenapex.entity.StoreOtp;
import com.greenapex.entity.TempOtp;

@RestController
public class VarifyOtpController {
@PostMapping("/otp")	
public String verifyOtp(@ModelAttribute TempOtp sms)
{
	if(sms.getOtp()==StoreOtp.getOtp())
	return "correct otp";
	else
		return "not correct";
}
}
