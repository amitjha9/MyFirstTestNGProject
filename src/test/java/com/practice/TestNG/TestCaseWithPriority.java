package com.practice.TestNG;

import org.testng.annotations.Test;

public class TestCaseWithPriority {
	
	@Test(priority=4)
	public void getAddition()
	{
		int a = 10;
		int b = 20;
		int result = a+b;
		System.out.println("Addition output is:" +result);
	}
	
	@Test(priority=0)
	public void getMultiplication()
	{
		int a = 9;
		int b = 10;
		int result = a*b;
		System.out.println("Multiplication is:" +result);
	}
	
	@Test(priority=3)
	public void getSubstraction()
	{
		int a = 100;
		int b = 40;
		int result = a-b;
		System.out.println("Substraction is:" +result);
	}
	
	@Test(priority=2)
	public void getDivison()
	{
		int a = 10;
		int b = 2;
		int result = a/b;
		System.out.println("Divison is:" +result);
	}
	
	@Test(priority=1)
	public void getModule()
	{
		int a = 20;
		int b = 4;
		int result = a%b;
		System.out.println("Module is:" +result);
	}
}
