package com.greenapex.Exception;

public class URLNotProperException extends Exception {
	String msg;
	public URLNotProperException(String msg)
	{
		this.msg=msg;
	}
	public String toString() {
	      return ("Own Exception Occurred : " + msg);
	   }
}
