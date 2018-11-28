import java.util.*;

public class Student extends Person {
	private final int NUM_GRADE_CATEGORIES = 5;
	private final int PARTICIPATION = 0;
	private final int EXAMS = 1;
	private final int ASSIGNMENTS = 2;
	private final int SURVEY = 3;
	private final int GROUP_PRESENTATION = 4;
	
	private Calculator calc = new Calculator();
	
	private double compositeGrade = 0;
	
	private final double TOTAL_POINTS = 150.0;
	
	private final double ASSIGNMENT_WEIGHT = 60.0/TOTAL_POINTS ;
	private final double EXAM_WEIGHT = 60.0/TOTAL_POINTS ;
	private final double PRESENTATION_WEIGHT = 10.0/TOTAL_POINTS ;
	private final double PARTICIPATION_WEIGHT = 15.0/TOTAL_POINTS ;
	private final double SURVEY_WEIGHT = 5.0/TOTAL_POINTS ;
	

	//  6 individual program assignments	60 points
	//  7 tests - 							the lowest grade of completed tests will be dropped	60 points
	//  group presentation	10 points
	//  1 survey in canvas	5 points
	//  attendance and class participation	15 points
	//  total	150 points
	
	
	private Double gradeAverage[] = new Double[5];
	
	private ArrayList<Double> grades[] = new ArrayList[NUM_GRADE_CATEGORIES]; 
	
	public Student() {
		initializeGrades();
	}

	private void initializeGrades() {
		for(int index = 0; index < NUM_GRADE_CATEGORIES; index++) {
			grades[index] = new ArrayList<Double>();
		}
	}
	
	
	public void enterGrades(Scanner scan) {
		//-------------------------------------------------------------------
		// Participation Grades
		//-------------------------------------------------------------------
		
		// Display user message
		System.out.println("Enter Participation Grades");
		
		//Get data
		grades[PARTICIPATION ] = calc.getNumericData02();
		
		//Compute Average
		gradeAverage[PARTICIPATION] =  calc.computeAverage(grades[PARTICIPATION] );

		//-------------------------------------------------------------------
		// Exam Grades
		//-------------------------------------------------------------------
		
		// Display user message
		System.out.println("Enter Exam Grades");
		
		//Get data
		grades[EXAMS] = calc.getNumericData02();
		
		//Compute Average
		gradeAverage[EXAMS] =  calc.computeAverage(grades[EXAMS] );

		//-------------------------------------------------------------------
		// Assignment Grades
		//-------------------------------------------------------------------
		
		// Add Code here.....

		//-------------------------------------------------------------------
		// Survey Grades
		//-------------------------------------------------------------------
		
		// Add Code here.....


		//-------------------------------------------------------------------
		// Group Presentation Grades
		//-------------------------------------------------------------------
		
		// Add Code here.....

		
	}
	
	public double computeCompositeGrade() {
		compositeGrade = (gradeAverage[PARTICIPATION] *  PARTICIPATION_WEIGHT);
		compositeGrade += (gradeAverage[EXAMS] *  EXAM_WEIGHT);
		compositeGrade += (gradeAverage[ASSIGNMENTS] *  ASSIGNMENT_WEIGHT);
		compositeGrade += (gradeAverage[SURVEY] *  SURVEY_WEIGHT);	
		compositeGrade += (gradeAverage[GROUP_PRESENTATION ] *  PRESENTATION_WEIGHT);	
			
		
		return compositeGrade;
	}
	
	public char getLetterGrade() {
		if(compositeGrade >= 90) {
			return 'A';
		}
		else
		if(compositeGrade < 90 && compositeGrade >= 80) {
			return 'B';
		}
		if(compositeGrade < 80 && compositeGrade >= 70) {
			return 'C';
		}
		if(compositeGrade < 70 && compositeGrade >= 60) {
			return 'D';
		}
		if(compositeGrade < 60) {
			return 'F';
		}
		else {
			//This is an error!
			return '\0';
		}
	}
}
