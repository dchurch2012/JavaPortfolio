import java.util.ArrayList;
import java.io.*;

import java.util.Scanner;

public class Calculator {

	private double num1 = 0;
	private double num2 = 0;

	public Calculator() {
		//Do nothing for now.....
	}

	public Calculator(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public double add() {
		return num1 + num2;
	}

	public double subtract() {
		return num1 + num2;
	}
	
	public double multiply() {
		return num1 + num2;
	}
	
	public double divide() {
		return num1 + num2;
	}

	
	public double add(double num1, double num2) {
		return num1 + num2;
	}
   
	double subtract( double num1, double num2) {
		return num1 - num2;
	}   
 
	double multiply(double num1, double num2) {
		return num1 * num2;
	}	   
			   
	double divide(double num1,double num2) {
		return num1 / num2;
	}
	
	public  ArrayList<String> getData()
	{
		String inData = "|";
		ArrayList<String> dataList = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		
		while(inData.length() > 0)
		{
			System.out.print("Please enter a string : ");	
			inData = scan.nextLine();
		
			if(inData.length() > 0)
			{
				dataList.add(inData);		
			}
		}
		scan.close();
		return dataList;
	}

	public double computeAverage(ArrayList<Double> numList) {
		double sum = 0;
		
		for(Double number : numList) {
			sum += number;
		}
		
		return sum /numList.size();
	}

	public  ArrayList<Double> getNumericData()
	{
		String inData = "|";
		ArrayList<Double> dataList = new ArrayList<Double>();
		ValidateData validate = new ValidateData();
		Scanner scan = new Scanner(System.in);
		
		while(inData.length() > 0)
		{
			System.out.print("Please enter a Double : ");	
			inData = scan.nextLine();
		
			if(inData.length() > 0)
			{
				if(validate.validateDecimal(inData))
				{
					dataList.add(Double.parseDouble(inData));		
				}
				else
				{
					System.out.println("Data entry error : please enter a valid floating point number");
				}
			}
		}
		scan.close();
		return dataList;
	}
	
	
	public  ArrayList<Double> getNumericData02()
	{
		String inData = "|";
		ArrayList<Double> dataList = new ArrayList<Double>();
		ValidateData validate = new ValidateData();
		
	    InputStreamReader r=new InputStreamReader(System.in);    
	    BufferedReader br=new BufferedReader(r);            
		
		while(inData.length() > 0)
		{
			System.out.print("Please enter a Value : ");	
			
			
			try {
				inData = br.readLine();    
			}
			catch(Exception except) {
				System.out.println(except.getMessage());
			}
				
			if(inData.length() > 0)
			{
				if(validate.validateDecimal(inData))
				{
					dataList.add(Double.parseDouble(inData));		
				}
				else
				{
					System.out.println("Data entry error : please enter a valid floating point number");
				}
			}
		}

		return dataList;
	}
	
	
	public  boolean isPrime(int number) {
		boolean isPrime = true;

		if(number == 2) {
			return false;
		}
		
		for(int index = 2; index < number; index++) {
			int remainder = number  % index;
		
			if(remainder == 0) {
				isPrime = false;
				return isPrime;
			}
		}
		return isPrime;
	}

	public ArrayList<Integer> GeneratePrimes(int intMax)
	{
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		
		for(int index = 2; index <= intMax; index++)
		{
			if(isPrime(index))
			{
				primeList.add(index);
			}
		}
		return primeList;
	}
	
	
	public int sum(int max) {
		int sum = 0;
		
		for(int index = 0; index <= max; index++) {
			sum += index;
		}
		return sum;
	}

	public int sum(int min, int max) {
		int sum = 0;
		
		for(int index = min; index <= max; index++) {
			sum += index;
		}
		return sum;
	}
} // end class
