package com.greenapex.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import com.greenapex.entity.StudentEntity;
import com.greenapex.entity.TempOtp;

public interface IStudentService {
	public TempOtp saveStudent(TempOtp student);
	public void send(String sms) throws ParseException;
}
