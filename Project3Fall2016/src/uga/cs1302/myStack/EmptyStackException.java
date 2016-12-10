package uga.cs1302.myStack;
/**
 * @author Stone Daniel
 * Date: 11/2/2016
 * Purpose: This is my "EmptyStackException" exception class, which will be thrown to notify of an empty stack, and 
 * caught to prevent a crash.
 *
 */
public class EmptyStackException extends Exception {
	public EmptyStackException()
	{
		super();
	}
}
