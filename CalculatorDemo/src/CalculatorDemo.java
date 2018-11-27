import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author David Church
 * 
 * <h1>ALGORITHM</h1>
 * BEGIN<br>
 * <h2>
 * &nbsp;&nbsp;Demonstrate Various Calls to different ways of using the Calculator Class<br>
 * </h2>
 * END<br>
 *
 */
public class CalculatorDemo {
	public static void main(String[] args) {
		calcDemo5();
	}
	
	/**
	 * <h3>
	 * This method gets a string from the user that indicates a mathematical operation<br>
	 * to be performd
	 * </h3>
	 * @return char that indicates which Calcultor method is to be called
	 * @throws IOException - Used to handle an I/O exception from the user console
	 */
	public static char getUserChoice() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = "|";
			boolean done = false;
			char choice = '\0';

			System.out.println("Enter add, subtract, multiply or divide : ");
			
			try {
				while(!done)  {
					str = br.readLine();
		  
					if(str.equals("add")) {
						choice = 'a'; 
						done = true;
					}
					else 
					if(str.equals("subtract")) {
						choice = 's'; 
						done = true;
					}
					else 
					if(str.equals("multiply")) {
						choice = 'm'; 
						done = true;
					}
					else 
					if(str.equals("divide")) {
						choice = 'd'; 
						done = true;
					}
					else {
						System.out.println("Please enter add, subtract, multiply or divide");
					}
					
				      System.out.println(str);
			    } 
			}
			catch(Exception except) {
				System.out.println(except.getMessage());
			}

			return choice;
 	}

	 /**
	  * <h1>ALGORITHM</h1>
	  * <h2>BEGIN</h2>
	  * <h3>
	  * &nbsp;&nbsp;1. Loop through input from user<br>
	  * &nbsp;&nbsp;2. Get a string from the user<br>
	  * &nbsp;&nbsp;3. Check to determine if the String is empty<br>
	  * &nbsp;&nbsp;4. IF the String IS Empty -- exit the loop and return 0<br>
	  * &nbsp;&nbsp;5. ELSE<br>
	  * &nbsp;&nbsp;6. &nbsp;&nbsp;IF String is Valid<br>
	  * &nbsp;&nbsp;7. &nbsp;&nbsp;&nbsp;&nbsp;Convert String to a double<br>
	  * &nbsp;&nbsp;8. &nbsp;&nbsp;ENDIF<br>
	  * &nbsp;&nbsp;8. END-ELSE<br>
	  * &nbsp;&nbsp;9. Return double value<br>
	  * </h3>
	  * <h2>END</h2>
	  * @return double that is converted from a validated string that represents a number 
	  */
	public static double getDouble() {
		String choice = new String("|");
		ValidateData validate = new ValidateData();
		double doubleValue = 0;
		boolean done = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		while(!done) {
			try 
			{
				choice = br.readLine();
				
				if(choice.length() == 0) {
					done = true;
				}
				else {
					if(validate.validateDecimal(choice)) {
						doubleValue = Double.parseDouble(choice);
						done = true;
						
					}
					else {
						System.out.println("Please enter a valid number");
					}
				}
			}
			catch(Exception except) {
				System.out.println(except.getMessage());
				done = true;
			}

		}
		
		try {
			br = null;
		}
		catch(Exception except) {
			System.out.println("Error closing BufferedReader");
		}

		return doubleValue;
	}

	 /**
	  * <h3>
	  * &nbsp;&nbsp;Demonstrates creating a calculator class<br>
	  * &nbsp;&nbsp;Calls each method in the calcultor class and displayst the results<br>
	  * &nbsp;&nbsp;Of add, subtract, multiply and divide<br>
	  * </h3>
	  */
	public static void calcDemo1() {
			Scanner scan = new Scanner(System.in);
			Calculator calc = new Calculator();
			
			double number1 = 0;
			double number2 = 0;
			double number3 = 0;
			
			System.out.print("Please enter a number : ");
			number1 = scan.nextDouble();
			
			System.out.print("Please enter another number : ");
			number2 = scan.nextDouble();
		
			// Add 2 numbers
			number3 = calc.add(number1,number2);
			System.out.println(number1 + " + " + number2 + " = " + number3);
			
			// Subtract 2 numbers
			number3 = calc.subtract(number1,number2);
			System.out.println(number1 + " - " + number2 + " = " + number3);

			// Multiply 2 numbers
			number3 = calc.multiply(number1,number2);
			System.out.println(number1 + " * " + number2 + " = " + number3);

			// Divide 2 numbers
			number3 = calc.divide(number1,number2);
			System.out.println(number1 + " / " + number2 + " = " + number3);
			
			scan.close();
	}
	 
	 /**
	  * <h3>
	  * &nbsp;&nbsp;Demonstrates creating a calculator class<br>
	  * &nbsp;&nbsp;This time, user entered data is passed-into the class constructor<br>
	  * &nbsp;&nbsp;And add, subtract, multiply and divide methods are called<br>
	  * &nbsp;&nbsp;That take no arguments (uses the constructor - set values<br>
	  * </h3>
	  */
	public static void calcDemo2() {
			Scanner scan = new Scanner(System.in);
			
			double number1 = 0;
			double number2 = 0;
			double number3 = 0;
			
			System.out.print("Please enter a number : ");
			number1 = scan.nextDouble();
			
			System.out.print("Please enter another number : ");
			number2 = scan.nextDouble();
		
			Calculator calc = new Calculator(number1, number2);
			
			// Add 2 numbers
			number3 = calc.add();
			System.out.println(number1 + " + " + number2 + " = " + number3);
			
			// Subtract 2 numbers
			number3 = calc.subtract();
			System.out.println(number1 + " - " + number2 + " = " + number3);

			// Multiply 2 numbers
			number3 = calc.multiply();
			System.out.println(number1 + " * " + number2 + " = " + number3);

			// Divide 2 numbers
			number3 = calc.divide();
			System.out.println(number1 + " / " + number2 + " = " + number3);
		
			scan.close();
			
	}
	 
	 /**
	  * <h3>
	  * &nbsp;&nbsp;Demonstrates creating a calculator class<br>
	  * &nbsp;&nbsp;And displays a menu to allow the user to pick<br>
	  * &nbsp;&nbsp;Either add, subtract, multiply or divide<br>
	  * &nbsp;&nbsp;This time, user entered data is passed-into the class constructor<br>
	  * &nbsp;&nbsp;And add, subtract, multiply and divide methods are called<br>
	  * &nbsp;&nbsp;That take no arguments (uses the constructor - set values<br>
	  * </h3>
	  */
	public static void calcDemo3() {
			Scanner scan = new Scanner(System.in);
			
			double number1 = 0;
			double number2 = 0;
			double number3 = 0;
			
			int choice = 0;
		
			System.out.print("Please enter a number : ");
			number1 = scan.nextDouble();
			
			System.out.print("Please enter another number : ");
			number2 = scan.nextDouble();
		
			Calculator calc = new Calculator(number1, number2);
		
			System.out.println("----------------------------------------------");
			System.out.println("Enter 0 to add 2 numbers");
			System.out.println("Enter 1 to subtract 2 numbers");
			System.out.println("Enter 2 to multiply 2 numbers");
			System.out.println("Enter 3 to divide 2 numbers");
			System.out.println("----------------------------------------------");

			choice = scan.nextInt();
			
			switch(choice) {
				case 0:
					// Add 2 numbers
					number3 = calc.add();
					System.out.println(number1 + " + " + number2 + " = " + number3);
					break;
				
				case 1:
					// Subtract 2 numbers
					number3 = calc.subtract();
					System.out.println(number1 + " - " + number2 + " = " + number3);
					break;

				case 2:
					// Multiply 2 numbers
					number3 = calc.multiply();
					System.out.println(number1 + " * " + number2 + " = " + number3);
					break;

				case 3:
					// Divide 2 numbers
					number3 = calc.divide();
					System.out.println(number1 + " / " + number2 + " = " + number3);
					break;

				default:
					System.out.println("Please enter 0-3");
					break;
			}
			scan.close();
	}

	 
	 
	 /**
	  * <h3>
	  * &nbsp;&nbsp;Demonstrates creating a calculator class<br>
	  * &nbsp;&nbsp;And displays a menu to allow the user to pick<br>
	  * &nbsp;&nbsp;Either add, subtract, multiply or divide<br>
	  * &nbsp;&nbsp;This time though, the getUserChoice and getDouble methods are called<br>
	  * &nbsp;&nbsp;These routines validate the user input and continue to query the user<br>
	  * &nbsp;&nbsp;For a correct entry (or nothing at all to terminate)<br>
	  * &nbsp;&nbsp;This time, user entered data is passed-into the class constructor<br>
	  * &nbsp;&nbsp;And add, subtract, multiply and divide methods are called<br>
	  * &nbsp;&nbsp;That take no arguments (uses the constructor - set values<br>
	  * </h3>
	  */
	public static void calcDemo5() {
			Calculator calc = new Calculator();
			
			double number1 = 0;
			double number2 = 0;
			double number3 = 0;
			char choice = '\0';
			
			try
			{
				choice =  getUserChoice();
				
				System.out.println("Please enter number 1 : ");
				number1 = getDouble();
				
				System.out.println("Please enter number 2 : ");
				number2 = getDouble();
		
				switch(choice) {
					case 'a':
						number3 = calc.add(number1, number2);
						System.out.println(number1 + " + " + number2 + " = " + number3);
						break;
						
					case 's':
						number3 = calc.subtract(number1, number2);
						System.out.println(number1 + " - " + number2 + " = " + number3);
						break;

					case 'm':
						number3 = calc.multiply(number1, number2);
						System.out.println(number1 + " * " + number2 + " = " + number3);
						break;
				
					case 'd':
						number3 = calc.divide(number1, number2);
						System.out.println(number1 + " / " + number2 + " = " + number3);
						break;
				
					default:
						break;
			
				}
				
			}
			catch(Exception except) {
				System.out.println("Error!");;
			}
			
			System.out.println();
			System.out.println("Done!");
	 }
}
