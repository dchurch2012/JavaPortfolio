package studentgradebook;

import java.util.*;
import java.io.*;
import java.lang.Object;

public class Student
{
	protected ArrayList<Assignment>[] assignList;

	protected String studentFirstName = "";
	protected String studentLastName = "";
	
	protected static final int HOMEWORK = 0;
	protected static final int LAB = 1;
	protected static final int QUIZ = 2;
	protected static final int PARTICIPATION = 3;
	protected static final int EXAM = 4;
	
	protected double homeworkAverage = 0;
	protected double labAverage = 0;
	protected double quizAverage = 0;
	protected double examAverage = 0;
	protected double partAverage = 0;
	protected double courseAverage = 0;
	
	protected char letterGrade;
	
	public Student()
	{
		assignList = new ArrayList[5];
		
		//Homework
		assignList[HOMEWORK] = new ArrayList<Assignment>();
		
		//Lab
		assignList[LAB] = new ArrayList<Assignment>();
		
		//Quiz
		assignList[QUIZ] = new ArrayList<Assignment>();
		
		//Participation
		assignList[PARTICIPATION] = new ArrayList<Assignment>();
		
		//Exams
		assignList[EXAM] = new ArrayList<Assignment>();
	}

	protected double computeLabAverage()
	{
		int count = assignList[LAB].size();
		double sum = 0;
		Assignment lab = null;
		
		for(int index = 0; index < count; index++)
		{
			lab = assignList[LAB].get(index);
			sum += lab.AssignGrade();
		}
		
		return(sum / count);
	}
	
	protected double computeHomeworkAverage()
	{
		int count = assignList[HOMEWORK].size();
		double sum = 0;
		Assignment homework = null;
		
		for(int index = 0; index < count; index++)
		{
			homework = assignList[HOMEWORK].get(index);
			sum += homework.AssignGrade();
		}
		
		return(sum / count);
	}
	
	protected double computeExamAverage()
	{
		int count = assignList[EXAM].size();
		double sum = 0;
		Assignment exam = null;
		
		for(int index = 0; index < count; index++)
		{
			exam= assignList[EXAM].get(index);
			sum += exam.AssignGrade();
		}
		
		return(sum / count);
	}
	
	protected double computePartAverage()
	{
		int count = assignList[PARTICIPATION].size();
		double sum = 0;
		Assignment part= null;
		
		for(int index = 0; index < count; index++)
		{
			part = assignList[PARTICIPATION].get(index);
			sum += part.AssignGrade();
		}
		
		return(sum / count);
	}
	
	protected double computeQuizAverage()
	{
		int count = assignList[QUIZ].size();
		double sum = 0;
		Assignment quiz = null;
		
		for(int index = 0; index < count; index++)
		{
			quiz = assignList[QUIZ].get(index);
			sum += quiz.AssignGrade();
		}
		
		return(sum / count);
	}
	
	public int computeGradeAverages()
	{
		examAverage = computeExamAverage();
		quizAverage = computeQuizAverage();
		labAverage = computeLabAverage();
		partAverage = computePartAverage();
		homeworkAverage = computeHomeworkAverage();
		
		courseAverage = computeGradeAverage();
		
		letterGrade = getLetterGrade();
		
		return 0;
	}

	protected char getLetterGrade()
	{
		if(courseAverage > 90)
		{
			letterGrade = 'A';
		}
		else
		if(courseAverage >= 80 && courseAverage < 90)
		{
			letterGrade = 'B';
		}
		else
		if(courseAverage >= 70 && courseAverage < 80)
		{
			letterGrade = 'C';
		}
		else
		if(courseAverage >= 60 && courseAverage < 70)
		{
			letterGrade = 'D';
		}
		else
		if(courseAverage < 60)
		{
			letterGrade = 'F';
		}
		return letterGrade;
	}
	
	protected boolean EnterHomworkGrades()
	{
		boolean done = false;
	
		while(!done)
		{
			Homework homework = new Homework();
		
			done = homework.EnterGrade();
			
			if(!done)
			{
				assignList[HOMEWORK].add(homework);
			}
		}
		
		return true;
	}
	
	protected boolean EnterLabGrades()
	{
		boolean done = false;
	
		while(!done)
		{
			Lab lab = new Lab();
			done = lab.EnterGrade();
	
			if(!done)
			{
				assignList[LAB].add(lab);
			}
		}
		return true;
	}

	protected boolean EnterQuizGrades()
	{
		boolean done = false;
	
		while(!done)
		{
			Quiz quiz = new Quiz();
			done = quiz.EnterGrade();
			
			if(!done)
			{
				assignList[QUIZ].add(quiz);
			}
		}
		return true;
	}

	protected boolean EnterParticipationGrades()
	{
		boolean done = false;

		while(!done)
		{
			Participation part = new Participation();
			done = part.EnterGrade();
				
			if(!done)
			{
				assignList[PARTICIPATION].add(part);
			}
		}
		return true;
	}

	protected boolean EnterExamGrades()
	{
		boolean done = false;
	
		while(!done)
		{
			Exam exam = new Exam();
			done = exam.EnterGrade();
				
			if(!done)
			{
				assignList[EXAM].add(exam);
			}
		}
		return true;
	}
	
	public int EnterGrades(String filename)
	{
		FileReader fr = null;
		BufferedReader br = null;
		String input = "";
		Assignment assign = null;
		int lineNo = 0;		
		
				
		try 
		{
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			 
			while ((input = br.readLine()) != null)
			{
				String[] columns = input.split(",");
			
				try
				{
					if(lineNo == 0) {
						//Enter First name
						studentFirstName =  columns[0];

						//Enter Last name
						studentLastName =  columns[1];
						
						lineNo++;
					}

					assign = new Assignment();
				
					assign.assignmentType = columns[0];
					assign.assignmentName = columns[1];
					assign.assignmentDescription = columns[2];
					assign.grade = Double.parseDouble(columns[3]);
				}
				catch(Exception except)
				{
					System.out.println(except.getMessage());
				}
				
				
				if(assign.assignmentType.equals("Homework"))
				{
					assignList[HOMEWORK].add(assign);
				}
				else
				if(assign.assignmentType.equals("Lab"))
				{
					assignList[LAB].add(assign);
				}
				else
				if(assign.assignmentType.equals("Quiz"))
				{
					assignList[QUIZ].add(assign);
				}
				else
				if(assign.assignmentType.equals("Exam"))
				{
					assignList[EXAM].add(assign);
				}
				else
				if(assign.assignmentType.equals("Participation"))
				{
					assignList[PARTICIPATION].add(assign);
				}
			}
		}
		catch(IOException except)
		{
			System.out.println(except.getMessage());
		}
		finally 
		{
			try
			{
				if (fr != null) 
				{
				  fr.close();
				}
			}
			catch(IOException except)
			{
				System.out.println(except.getMessage());
			}
		}
		
		return 0;
	}
	

	public int EnterGrades()
	{
		Scanner scan = new Scanner(System.in);

		//Enter First name
		System.out.print("Enter Student First Name : ");
		studentFirstName = scan.nextLine();
		
		//Enter Last name
		System.out.print("Enter Student Last Name : ");
		studentLastName = scan.nextLine();
	
		EnterExamGrades();
		EnterHomworkGrades();
		EnterLabGrades();
		EnterParticipationGrades();
		EnterQuizGrades();
		
		return 0;
	}
	
	public int PrintGrades(String filename)
	{
		FileWriter fw = null;
		BufferedWriter bw = null;

		try 
		{
			fw = new FileWriter(filename);

			if(fw != null)
			{
				bw = new BufferedWriter(fw);
			}
				
			int count = assignList[HOMEWORK].size();

			//Write HOMEWORK Grades to File
			for (Assignment item : assignList[HOMEWORK]) 
			{
				bw.write(item.assignmentType);
				bw.write(",");
		
				bw.write(item.assignmentName);
				bw.write(",");
		
				bw.write(item.assignmentDescription);
				bw.write(",");
				
				bw.write(Double.toString(item.grade));
				
				bw.newLine();
			}

			bw.write("Homework Average : " + homeworkAverage);
			bw.newLine();
			
			count = assignList[LAB].size();
		
			//Write LAB Grades to File
			for (Assignment item : assignList[LAB]) 
			{
				bw.write(item.assignmentType);
				bw.write(",");

				bw.write(item.assignmentName);
				bw.write(",");
		
				bw.write(item.assignmentDescription);
				bw.write(",");
				
				bw.write(Double.toString(item.grade));
				
				bw.newLine();
			}
		
			bw.write("Lab Average : " + labAverage);
			bw.newLine();

			count = assignList[EXAM].size();
		
			//Write EXAM Grades to File
			for (Assignment item : assignList[EXAM]) 
			{
				bw.write(item.assignmentType);
				bw.write(",");

				bw.write(item.assignmentName);
				bw.write(",");
		
				bw.write(item.assignmentDescription);
				bw.write(",");
				
				bw.write(Double.toString(item.grade));
				
				bw.newLine();
			}
		
			bw.write("Exam Average : " + examAverage);
			bw.newLine();

			count = assignList[QUIZ].size();
		
			//Write QUIZ Grades to File
			for (Assignment item : assignList[QUIZ]) 
			{
				bw.write(item.assignmentType);
				bw.write(",");

				bw.write(item.assignmentName);
				bw.write(",");
		
				bw.write(item.assignmentDescription);
				bw.write(",");
				
				bw.write(Double.toString(item.grade));
				
				bw.newLine();
			}
		
			bw.write("Quiz Average : " + quizAverage);
			bw.newLine();
			
			count = assignList[PARTICIPATION].size();

			//Write PARTICIPATION Grades to File
			for (Assignment item : assignList[PARTICIPATION]) 
			{
				bw.write(item.assignmentType);
				bw.write(",");

				bw.write(item.assignmentName);
				bw.write(",");
		
				bw.write(item.assignmentDescription);
				bw.write(",");
				
				bw.write(Double.toString(item.grade));
				
				bw.newLine();
			}
			
			
			bw.write("Participation Average : " + partAverage);
			bw.newLine();
		
			//Grade Summary (final grade)
			bw.write("Grade Summary");
			bw.write(",");
			bw.write("Final Grade");
			bw.write(",");
			bw.write(Double.toString(courseAverage));
			bw.write(",");
			bw.write(letterGrade);

			bw.newLine();
		}
		catch(Exception except)
		{
			System.out.println(except.getMessage());
		}
		finally 
		{
			try
			{
				if(bw != null)
				{
					bw.close();
				}
				
				if (fw != null) 
				{
					fw.close();
				}
			}
			catch(Exception except)
			{
				System.out.println(except.getMessage());
			}
		}

		return 0;
	}

	public int PrintGrades()
	{
		int count = assignList[HOMEWORK].size();
		
		System.out.println("PRINTING GRADES");
		
		System.out.print("For Student : ");
		System.out.print(studentFirstName);
		System.out.print(" ");
		System.out.print(studentLastName);
		System.out.println();
		
		System.out.print("Homeowrk Count : ");
		System.out.println(count);
		
		for (Assignment item : assignList[HOMEWORK]) 
		{
			System.out.print(item.assignmentName);
			System.out.print(" ");
	
			System.out.print(item.assignmentDescription);
			System.out.print(" ");
			
			System.out.print(item.grade);
			System.out.print(" ");
			
			System.out.println();
		}
		
		System.out.println("Homework Average : " + homeworkAverage);
		System.out.println();
		
		count = assignList[LAB].size();
		
		for (Assignment item : assignList[LAB]) 
		{
			System.out.print(item.assignmentName);
			System.out.print(" ");

			System.out.print(item.assignmentDescription);
			System.out.print(" ");

			System.out.print(item.grade);
			System.out.println();
		}

		System.out.println("Lab Average : " + labAverage);
		System.out.println();

		count = assignList[EXAM].size();
		
		for (Assignment item : assignList[EXAM]) 
		{
			System.out.print(item.assignmentName);
			System.out.print(" ");

			System.out.print(item.assignmentDescription);
			System.out.print(" ");

			System.out.print(item.grade);
			System.out.println();
		}

		System.out.println("Exam Average : " + examAverage);
		System.out.println();

		count = assignList[QUIZ].size();
		
		for (Assignment item : assignList[QUIZ]) 
		{
			System.out.print(item.assignmentName);
			System.out.print(" ");

			System.out.print(item.assignmentDescription);
			System.out.print(" ");

			System.out.print(item.grade);
			System.out.println();
		}

		System.out.println("Quiz Average : " + quizAverage);
		System.out.println();

		count = assignList[PARTICIPATION].size();
		
		for (Assignment item : assignList[PARTICIPATION]) 
		{
			System.out.print(item.assignmentName);
			System.out.print(" ");

			System.out.print(item.assignmentDescription);
			System.out.print(" ");

			System.out.print(item.grade);
			System.out.println();
		}

		System.out.println("Participation Average : " + partAverage);
		System.out.println();

		System.out.print("Grade Summary : ");
		System.out.print(" ");
		System.out.print("Final Grade : ");
		System.out.print(courseAverage);
		System.out.print(" ");
		System.out.println(letterGrade);

		return 0;
	}
	
	public double computeGradeAverage()
	{
		double final_grade = (homeworkAverage * 2.5 + labAverage * 2.5 + quizAverage * 2 + examAverage * 2 + partAverage * 1) / 10;
		return final_grade;
	}
}