package com.greenapex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import com.greenapex.component.Welcome;

public class Main {
	public static void main(String args[])
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("cfg.xml");
		Welcome w=(Welcome) ac.getBean("message");
		System.out.println(w);
	    System.out.println(w.getMessage());
	}
}
