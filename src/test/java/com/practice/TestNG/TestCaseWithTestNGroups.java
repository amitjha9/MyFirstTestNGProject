package com.practice.TestNG;

import org.testng.annotations.Test;

public class TestCaseWithTestNGroups {
	
	@Test(groups= {"G1","G3"})
	public void Darbhanga()
	{
		System.out.println("Darbhanga");
	}
	
	@Test(groups= {"G1","G2","G4"})
	public void Patna()
	{
		System.out.println("Patna");
	}
	
	@Test(groups= {"G2","G4"})
	public void Delhi()
	{
		System.out.println("Delhi");
	}
	
	@Test(groups= {"G2"})
	public void Bangalore()
	{
		System.out.println("Bangalore");
	}
	
	@Test(groups= {"G3","G4"})
	public void Punjab()
	{
		System.out.println("Punjab");
	}
	
	@Test(groups= {"G1","G3"})
	public void Hydrabad()
	{
		System.out.println("Hydrabad");
	}
	
	@Test(groups= {"G1","G2"})
	public void Pune()
	{
		System.out.println("Pune");
	}
}
