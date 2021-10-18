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
		System.out.println("display1 method");
	}
	
}
public class Upcasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class1 c1 = new Class2(); 
		c1.Show();
		c1.display1();
	
	}

}
