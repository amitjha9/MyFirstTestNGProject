package com.practice.TestNG;

import org.testng.annotations.Test;

public class TestCaseWithSamePriority {
	
	@Test(priority=1)
	public void methodOne()
	{
		System.out.println("I am under method one");
	}
	
	@Test(priority=0)
	public void methodTwo()
	{
		System.out.println("I am under method two");
	}
	
	@Test(priority=3)
	public void methodThree()
	{
		System.out.println("I am under mmethod three");
	}
	
	@Test(priority=0)
	public void methodFour()
	{
		System.out.println("I am under method four");
	}
	
	@Test(priority=4)
	public void methodFive()
	{
		System.out.println("I am under method five");
	}
}
