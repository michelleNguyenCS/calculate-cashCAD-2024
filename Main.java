/**
 * This program will generate a payment scenario where the user must determine the correct
 * amount of change to return to the customer.
 * 
 * @author Michelle Nguyen
 * @version 2024-05-02
 */


// IMPORT CLASSES
//import java.util.Random;
import java.math.BigDecimal;


public class Main {

	public static void main(String[] args) {
		
		// TESTING REGISTER VALUE COUNTING
		/*
		//Register register = new Register(2, 3, 14, 19, 8, 25, 25, 40, 50, 40);	// $952.00
		Register register = new Register(1, 2, 3, 5, 2, 1, 3, 2, 1, 2);	// $325.70
		
		System.out.println(register);
		System.out.printf("$%.2f\n", register.getRegisterBalance());
		*/
		
		// TESTING SIMPLE CHANGE CALCULATION
		
		System.out.println("100.25");
		System.out.println(Cash.calculateChange(BigDecimal.valueOf(100.25)));
		
		System.out.println("\n0.80");
		System.out.println(Cash.calculateChange(BigDecimal.valueOf(0.80)));
		
		System.out.println("\n0.85");
		System.out.println(Cash.calculateChange(BigDecimal.valueOf(0.85)));
		
	}
}
