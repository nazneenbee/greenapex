package com.greenapex;

public class InputNotProperException extends Exception {
	String msg;
	InputNotProperException(String msg)
	{
		this.msg=msg;
	}
	public String toString() {
	      return ("Own Exception Occurred : " + msg);
	   }
}
