package com.greenapex;

class Calculator
{
	int a,b;
	public void setData(int a, int b) throws InputNotProperException
	{
		this.a=a;
		if(b==0)
		{
		  throw new InputNotProperException("enter valid value of b");
		}
		this.b=b;
	}
	public int divide()
	{
		return a/b;
	}
}

public class ExceptionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c=new Calculator();
		try
		{
		c.setData(10, 0);
		}
		catch (InputNotProperException e) {
			System.out.println(e);
		}
		/*try
		{
		System.out.println(c.divide());
		}
		catch(ArithmeticException e)
		{
			System.out.println("Enter valid Input");
		} */
		finally {
			System.out.println("Program Completed");
		}		
	}
}
