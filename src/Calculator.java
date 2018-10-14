
/**
 * @author user
 *
 */
public class Calculator {
	/**
	 * Internal variable to store number for add, subtract, multiply and divide methods
	 */
	private double num1 = 0;
	
	
	/**
	 * Second Internal variable to store number for add, subtract, multiply and divide methods
	 */
	private double num2 = 0;
	
	
	/**
	 * <h3>Default Constructor (does nothing for now)</h3>
	 */
	public Calculator() {
		// Do nothing for now
	}
	

	/**
	 * <h3>Constructor that initializes local variables</h3>
	 * @param num1  - first number to add
	 * @param num2 - second number to add
	 */
	public Calculator(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
			
	}

	/**
	 * <h3>Method that adds 2 numbers</h3>
	 * @param num1 - first number to add
	 * @param num2 - second number to add
	 * @return the sum of num1 and num2
	 */
	public double add(double num1, double num2) {
		return num1 + num2;
	}
	
	/**
	 * <h3>Method that takes the Difference of 2 numbers</h3>
	 * @param num1 - first number to subtract
	 * @param num2 - second number to subtract
	 * @return the difference between num1 and num2 (num1 - num2)
	 */
	public double subtract(double num1, double num2) {
		return num1 - num2;
	}

	/**
	 * <h3>Method that multiplies 2 numbers</h3>
	 * @param num1 - first number of the product
	 * @param num2 - second number of the product
	 * @return the product of num1 and num2
	 */
	public double multiply(double num1, double num2) {
		return num1 * num2;
	}

	/**
	 * <h3>Method that calculates the quotient of 2 numbers</h3>
	 * @param num1 - first number of the quotient
	 * @param num2 - second number of the quotient
	 * @return the quotient of num1 and num2 (num1 / num2)
	 */
	public double divide(double num1, double num2) {
		return num1 / num2;
	}

	/**
	 * @return - num1 + num2
	 */
	public double add() {
		return num1 + num2;
	}
	
	/**
	 * @return num1 - num2
	 */
	public double subtract() {
		return num1 - num2;
	}

	/**
	 * @return num1 * num2
	 */
	public double multiply() {
		return num1 * num2;
	}

	/**
	 * @return num1 / num2
	 */
	public double divide() {
		return num1 / num2;
	}
}
