package uga.cs1302.myStack;
import static org.junit.Assert.*;
import org.junit.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void testDefaultConstructor()
	{
		Stack<String> stackDefault = new Stack<>();
		assertEquals(stackDefault.maxSize(),100);
	}
	@Test
	public void testConstructor2()
	{
		Stack<String> stackConstructor2 = new Stack<>(65);
		assertEquals(stackConstructor2.maxSize(),65);
	}
	@Test
	public void testIsEmpty() 
	{
		Stack<String> stackEmpty = new Stack<>();
		assertEquals(stackEmpty.isEmpty(),true);
	}

	@Test
	public void testPop() 
	{
		Stack<String> stackPop = new Stack<>(0);
		try {
			stackPop.push("Hello");
			fail();
		} catch (FullStackException  e) {
			return;
		}
		
	}
	@Test
	public void testPop2() 
	{
		Stack<String> stackPop2 = new Stack<>();
		try 
		{
			stackPop2.push("Hello");
			stackPop2.push("Sup");
			stackPop2.push("Hi");
			assertEquals(stackPop2.pop(),"Hi");
		} 
		catch (FullStackException | EmptyStackException e) {
			fail();
		}
		
	}

	@Test
	public void testPeek() 
	{
		Stack<String> stack1 = new Stack<>();
		try {
			stack1.push("Hi");
			stack1.push("Hello");			
			assertEquals(stack1.peek(),"Hello");
		} catch (FullStackException | EmptyStackException e) 
		{
			fail();
		}
	}

	@Test
	public void testIsFull() 
	{
		Stack<String> stackFull = new Stack<>(5);
		try {
			stackFull.push("Hello");
			assertEquals(stackFull.isFull(), false);
		} catch (FullStackException e ) 
		{
			fail();
		}
	}

	@Test
	public void testSize() 
	{
		Stack<String> stackSize = new Stack<>();
		try {
			stackSize.push("Hello");
			assertEquals(stackSize.size(),1);
		} catch (FullStackException e) {
			fail();
		}
		
	}

	@Test
	public void testPush() 
	{
		Stack<String> stackPush = new Stack<>();
		try {
			stackPush.push("Hello");
			assertEquals(stackPush.peek(),"Hello");
		} catch (FullStackException | EmptyStackException e1) {
			fail();
		} 
		
	}
	@Test
	public void testPush2()
	{
		Stack<String> stackPush2 = new Stack<>();
		try {
			stackPush2.push("Hey");
			stackPush2.push("Hello");
			assertEquals(stackPush2.peek(),"Hello");
		} catch (FullStackException | EmptyStackException e) {
			fail();
		}
	}
	@Test
	public void testToString()
	{
		Stack<String> stackToString = new Stack<>(1);
		try
		{
		stackToString.push("Hello");
		assertEquals(stackToString.toString(),"Hello");
		}
		catch(FullStackException e)
		{
			fail();
		}
	}

}
