package studentgradebook;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * @author David Church
 * @version 1.0.0 Build 1 April 13, 2016. */
 
 /**
 *  <h1>Class Assignment Description</h1></br>
 *
 */
public class Assignment {
	protected String assignmentType;
	protected String assignmentName;
	protected String assignmentDescription;
	protected double grade;

	public Assignment()
	{
	}
	
	public Assignment(String type, String name, String Desc, double grade)
	{
		this.assignmentType = type;
		this.assignmentDescription = Desc;
		this.assignmentName = name;
		this.grade = grade;
	}
	
	public String AssignType()
	{
		return assignmentType;
	}
	
	public String AssignName()
	{
		return assignmentName;
	}

	public String AssignDesc()
	{
		return assignmentDescription;
	}
	
	public double AssignGrade()
	{
		return grade;
	}
	
	public boolean EnterGrade()
	{
		Scanner scan = new Scanner(System.in);
	
		System.out.print("Enter " + assignmentType + " Name : ");
		assignmentName = scan.nextLine();
		
		if(assignmentName.length() == 0)
		{
			scan.close();
			return true;
		}

		System.out.print("Enter " + assignmentType + " Description : ");
		assignmentDescription = scan.nextLine();

		System.out.print("Enter " + assignmentType + " Grade : ");
		grade = scan.nextDouble();
		
		scan.close();
		
		return false;

	}
	
	public void PrintGrade()
	{
		System.out.println("Assignment Name : " + assignmentName);
		System.out.println("Assignment Type : " + assignmentType);
		System.out.println("Assignment Desc : " + assignmentDescription);
		System.out.println("Assignment Grade: " + grade);
	}
	
}