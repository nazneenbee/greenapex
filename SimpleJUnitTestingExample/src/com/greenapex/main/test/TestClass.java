package com.greenapex.main.test;

import static org.junit.Assert.assertEquals;  
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.greenapex.main.java.SimpleClass;

public class TestClass {
	
	@BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }  
    @Before  
    public void setUp() throws Exception {  
        System.out.println("before");  
    }  
  
    @Test 
    public void display1(){  
        System.out.println("display one called");  
        assertEquals("display1 method",SimpleClass.display1());   
    }  
    @Test  
    public void display2(){  
    	  System.out.println("display two called");  
          assertEquals("display2 method",SimpleClass.display2()); 
    }  
    @Test  
    public void display3(){  
    	  System.out.println("display three called");  
          assertEquals("display3 method",SimpleClass.display3()); 
    }  
    @After  
    public void tearDown() throws Exception {  
        System.out.println("after");  
    }  
  
    @AfterClass  
    public static void tearDownAfterClass() throws Exception {  
        System.out.println("after class");  
    }  

}
