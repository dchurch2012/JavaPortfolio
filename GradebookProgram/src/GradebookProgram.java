import java.util.*;

public class GradebookProgram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Student student = new Student();
		
		student.enterGrades(scan);
		
		double courseGrade = student.computeCompositeGrade();
		char letterGrade = student.getLetterGrade();
		
		System.out.println("Course Grade : " + courseGrade + " Letter Grade :" + letterGrade);
		
	}
	
	
}
