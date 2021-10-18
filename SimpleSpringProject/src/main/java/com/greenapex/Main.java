package com.greenapex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.greenapex.comp.MyBean;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    ApplicationContext ac = new ClassPathXmlApplicationContext("cfg.xml");
    MyBean mb=(MyBean) ac.getBean("mb");
    System.out.println(mb.getMsg());
	}

}
