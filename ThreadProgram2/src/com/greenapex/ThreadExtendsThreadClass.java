package com.greenapex;

class Thread1 extends Thread
{
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<=10; i++)
		{
			System.out.println(i);
			System.out.println(Thread.currentThread().getName());
		}
		
	}
	public void display()
	{
		for(int i=11; i<=50; i++)
		{
			System.out.println(i+"thread");
		}
		
	}
}
public class ThreadExtendsThreadClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 t=new Thread1();
		t.start();
		for(int j=101; j<=200; j++)
		{ 
			System.out.println(j);
		}
		t.display();

	}

}
