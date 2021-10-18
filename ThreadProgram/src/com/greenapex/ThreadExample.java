package com.greenapex;

class Thread1 implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<=10; i++)
		{
			System.out.println(i);
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


public class ThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 t1=new Thread1();
		Thread t=new Thread(t1);
		t.start();
		t1.display();
		
		}

}
