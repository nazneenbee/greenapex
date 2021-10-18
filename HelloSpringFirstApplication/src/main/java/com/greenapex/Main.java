package com.greenapex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.greenapex.comp.MyBean;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appCntx = new ClassPathXmlApplicationContext("cfg.xml");
		MyBean m = (MyBean)appCntx.getBean("mb");
		System.out.println(m.getMsg());

	}

}
