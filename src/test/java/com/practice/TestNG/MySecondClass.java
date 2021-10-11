package com.practice.TestNG;

import org.testng.annotations.Test;

public class MySecondClass {
	
	@Test
	public void getAddOutput()
	{
		int a = 10;
		int b = 10;
		int result = a+b;
		System.out.println("The result of addition is:" +result);
	}
	
	@Test
	public void getSubOutput()
	{
		int a = 50;
		int b = 25;
		int result = a-b;
		System.out.println("The result of substraction is:" +result);
	}
	
	@Test
	public void getMultOutput()
	{
		int a = 5;
		int b = 6;
		int result = a*b;
		System.out.println("The result of multiplication is:" +result);
	}
	
	@Test
	public void getModulOutput()
	{
		int a = 10;
		int b = 2;
		int result = a%b;
		System.out.println("The result of module is:" +result);
	}
}
