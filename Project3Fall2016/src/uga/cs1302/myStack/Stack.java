package uga.cs1302.myStack;
/**
 * @author Stone Daniel
 * Date: 10/25/2016
 * This is the class which implements my Stack interface and defines the methods from it. It is a generic, so that it can take
 * any variable type. 
 */
//import java.util.*;
import java.lang.*;
import java.util.Arrays;
public class Stack<T> implements StackADT<T>
{
	private final int DEFAULT_CAPACITY = 100;
	private int maxSize = DEFAULT_CAPACITY;
	private int top = 0;
	T[] arr;
	public Stack(int n)
	{
		maxSize = n;
		arr = (T[]) new Object[maxSize];
		
	}
	public Stack()
	{
		arr = (T[]) new Object[maxSize];
		
	}
	public boolean isEmpty()
	{
		if(top == 0)
			return true;
		else
			return false;
	}

	public T pop() throws EmptyStackException
	{
		if(!this.isEmpty())
		{
		T temp = this.peek();
		top--;
		return  temp;
		}
		else 
			throw new EmptyStackException();
	}
	public T peek() throws EmptyStackException //throws EmptyStackException
	{
		if(top > 0)
			return arr[top - 1];
		else 
			throw new EmptyStackException();
		
	}
	@Override
	public boolean isFull() {
		if(top == maxSize)
			return true;
		else
			return false;
	}
	@Override
	public int size() 
	{
		return top;
	}
	/** This method, maxSize() returns the capacity assigned to the stack.*/
	public int maxSize()
	{
		return maxSize;
	}
	/** This method, setSize() allows the programmer to change the capacity assigned to the stack.*/
	public void setSize(int i)
	{
		maxSize = i;
	}
	public void push(T element) throws FullStackException
	{	
		if(top<maxSize)
		{
		arr[top] = element;
		top++;
		}
		else
			throw new FullStackException();
			
	}
	public String toString()
	{
		String output = "";
		for(int i = top-1;i>=0;i--)
		{
			output += arr[i];
		}
		return output;
	}
	
}
