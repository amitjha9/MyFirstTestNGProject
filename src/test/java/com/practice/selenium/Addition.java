package com.practice.selenium;

public class Addition {
	
	public void add(double a, double b)
	{
		double c =a+b;
		System.out.println("Result:" +c);
	}

	public static void main(String[] args) {

		Addition ad = new Addition();
        ad.add(49.7, 50.8);
	}

}
