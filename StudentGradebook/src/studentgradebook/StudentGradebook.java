package studentgradebook;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * @author David Church
 * @version 1.0.0 Build 1 April 13, 2016. */
 
 /**
 *  <h1>Program StudentProgram Description</h1></br>
 *
 *  Ussge :% java StudentProgram
 *
 *  This program demonstrates Polymorphism and OOP concepts
 *
 */
public class StudentGradebook {
   /** Description of main(String[] args)
	* 
	* @param args		String[] args
	* This is the main routine required for ALL Java console programs
	*/
	public static void main (String[] argv)  {
		Student student = new Student();

		//Usage : StudentProgram no arguments
		//OR
		//		: StudentProgram -i input_file
		//OR
		//		: StudentProgram -o output_file
		//OR
		//		: StudentProgram -i input_file -o output_file
		
		System.out.print("Argument Count : ");
		System.out.println(argv.length);
		System.out.println();
		
		switch(argv.length)
		{
			case 0:
				student.EnterGrades();
				student.computeGradeAverages();
				student.PrintGrades();
				break;
					
			case 2:
				//System.out.println(argv[0]);
				//System.out.println(argv[1]);
				
				if(argv[0].equals("-i"))
				{
					student.EnterGrades(argv[1]);
					student.computeGradeAverages();
					student.PrintGrades();
				}
				else
				if(argv[0].equals("-o"))
				{
					student.EnterGrades();
					student.computeGradeAverages();
					student.PrintGrades(argv[1]);
				}
				else
				{
					PrintUsage();
				}
				break;
				
			case 4:
				if(argv[0].equals("-i") && argv[2].equals("-o") )
				{
					student.EnterGrades(argv[1]);
					student.computeGradeAverages();
					student.PrintGrades(argv[3]);
				}
				else
				{
					PrintUsage();
				}
				break;

			default:
				PrintUsage();
				break;
		}
	}
	
	static void PrintUsage()
	{
		System.out.println("Usage : StudentProgram no arguments");
		System.out.println("OR");
		System.out.println("StudentProgram -i input_file");
		System.out.println("OR");
		System.out.println("StudentProgram -o output_file");
		System.out.println("OR");
		System.out.println("StudentProgram -i input_file -o output_file");
	}
}