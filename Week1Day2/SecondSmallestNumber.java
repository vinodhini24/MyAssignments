package week1.day2.assignments;

import java.util.Arrays;

public class SecondSmallestNumber 
{
	public static int getSecondNumber(int[] a,int total)
	{
		Arrays.sort(a);
		return a[1];
	}
	
	public static void main(String[] args) 
	{
		int a[]= {23,45,67,32,89,22};
		System.out.println("Second Smallest Number is :"+getSecondNumber(a,6));
		
	}
	
	{
		
		
	}

}
