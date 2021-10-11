package com.practice.TestNG;

import org.testng.annotations.Test;

public class TestCaseWithPriorityAndNonPriority {
	
	@Test(priority=4)
	public void TestMethod1()
	{
		System.out.println("This is method one");
	}
	
	@Test
	public void TestMethod2()
	{
		System.out.println("This is method two");
	}
	
	@Test(priority=0)
	public void TestMethod3()
	{
		System.out.println("This is method three");
	}
	
	@Test
	public void TestMethod4()
	{
		System.out.println("This is method four");
	}

	@Test(priority=1)
	public void TestMethod5()
	{
		System.out.println("This is method five");
	}
	
	@Test
	public void TestMethod6()
	{
		System.out.println("This is method six");
	}
}
