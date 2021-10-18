package com.greenapex;

class Class1
{
	public void Show() {
		System.out.println("class1 method");
	}
	public void display1() {
		System.out.println("display1 method");
	}
}
class Class2 extends Class1
{
	public void Show() {
		System.out.println("class2 method");
	}
	public void display2() {
		System.out.println("display2 method");
	}
	
}

public class Downcasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class1 c1 = new Class2(); 
	
		Class2 c2=(Class2)c1;
		c2.Show();
		c2.display1();
		c2.display2();
	}

}
