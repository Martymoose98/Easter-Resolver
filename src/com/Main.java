package com;

import java.util.Scanner;

/**
 * 
 * @author Martin Mizzi
 * @date February 24th, 2018
 *
 */

/*
 * Convince Date structure I made no encapsulation cause it's not needed
 * this "class" behaves more like a c style struct in the sense that it
 * does not have getters nor setters and no private, or protected
 * data; only public. This structure just acts as a nice data holder for a
 * otherwise unfavorable multiple return type.
 */
class Date
{
	public int year;
	public int month; 
	public int day;
	
	/**
	 * Constructor with invalid checks
	 * 
	 * @param _in_ year - the year
	 * @param _in_ month - the month
	 * @param _in_ day - the day
	 */
	public Date(int year, int month, int day)
	{
		this.year = year;
		
		if (month <= 12)
			this.month = month;
		
		if (day <= 31)
			this.day = day;
	}
}

public class Main
{
	/**
	 * Resolves the date of easter on a given year
	 * 
	 * @param _in_ year - the year to resolve
	 * @return a new Date structure
	 */
	public static Date resolve(int year)
	{
		int a = year / 100;
		int b = year % 100;	
		int aa = (3 * (a + 25));
		int c = aa / 4;
		int d = aa % 4;		
		int q = (8 * (a + 11)) / 25;
		int f = (5 * a + b) % 19;
		int g = (19 * f + c - q) % 30;
		int h = (f + 11 * g) / 319;
		int db = 60 * (5 - d) + b;
		int j = db / 4;
		int k = db % 4;
		int n = (2 * j - k - g + h) % 7;
		int ghn = (g - h + n + 114);
		int month = ghn / 31;
		int p = ghn % 31;
		int day = (p + 1) / 1;
		
		return new Date(year, month, day);
	}
	
	/**
	 * Main Function (Entry Point)
	 * @param _in_ args - command line arguments if their is any (there should be none in our case, if they are present they are ignored!)
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int iYear = -1;
		
		do {
			System.out.println("What year do you want to know when easter occured or will occur?");
			iYear = in.nextInt();
		} while (iYear == -1);
		
		Date easterDay = resolve(iYear);
		
		System.out.printf("Easter in %d was on %d/%d/%d!\n", easterDay.year, easterDay.month, easterDay.day, easterDay.year);
		in.close();
	}
}
