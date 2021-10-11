package com.practice.TestNG;

import org.testng.annotations.Test;

public class TestCaseWithSkip {
	
	@Test(enabled=true)
	public void test1()
	{
		System.out.println("I am in test1 method");
	}
	
	@Test(enabled=false)
	public void test2()
	{
		System.out.println("I am in test2 method");
	}
	
	@Test
	public void test3()
	{
		System.out.println("I am in test3 method");
	}
	
	@Test(enabled=false)
	public void test4()
	{
		System.out.println("I am in test4 method");
	}
	
	@Test
	public void test5()
	{
		System.out.println("i am in test5 method");
	}
}
