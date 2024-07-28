/**
 * This program will generate a payment scenario where the user must determine the correct
 * amount of change to return to the customer.
 * 
 * @author Michelle Nguyen
 * @version 2024-07-27
 */


// IMPORT CLASSES
//import java.util.Random;
import java.math.BigDecimal;


/**
 * Driver Class
 */
public class Main {

	/**
	 * Main Driver
	 */
	public static void main(String[] args) {
		
		// TESTING REGISTER VALUE COUNTING
		/*
		//Register register = new Register(2, 3, 14, 19, 8, 25, 25, 40, 50, 40);	// $952.00
		Register register = new Register(1, 2, 3, 5, 2, 1, 3, 2, 1, 2);	// $325.70
		
		System.out.println(register);
		System.out.printf("$%.2f\n", register.getRegisterBalance());
		*/
		
		// TESTING SIMPLE CHANGE CALCULATION
		/*
		Register register = new Register(0, 0, 0, 0, 0, 0, 0, 3, 0, 2);
		System.out.println(register + "\n");
		
		System.out.println("100.25");
		System.out.println(Cash.calculateChange(BigDecimal.valueOf(100.25), register));
		
		System.out.println("\n0.80");
		System.out.println(Cash.calculateChange(BigDecimal.valueOf(0.80), register));
		
		System.out.println("\n0.85");
		System.out.println(Cash.calculateChange(BigDecimal.valueOf(0.85), register));
		
		System.out.println("\n0.90");
		System.out.println(Cash.calculateChange(BigDecimal.valueOf(0.90), register));
		*/
		
		// TESTING CASH ROUND 
		/*
		System.out.println(Cash.roundCash(BigDecimal.valueOf(0.00)));
		System.out.println(Cash.roundCash(BigDecimal.valueOf(0.01)));
		System.out.println(Cash.roundCash(BigDecimal.valueOf(0.02)));
		System.out.println(Cash.roundCash(BigDecimal.valueOf(0.03)));
		System.out.println(Cash.roundCash(BigDecimal.valueOf(0.04)));
		System.out.println(Cash.roundCash(BigDecimal.valueOf(0.05)));
		System.out.println(Cash.roundCash(BigDecimal.valueOf(0.06)));
		System.out.println(Cash.roundCash(BigDecimal.valueOf(0.07)));
		System.out.println(Cash.roundCash(BigDecimal.valueOf(0.08)));
		System.out.println(Cash.roundCash(BigDecimal.valueOf(0.09)));
		System.out.println(Cash.roundCash(BigDecimal.valueOf(0.10)));
		System.out.println();
		System.out.println(Cash.roundCash(BigDecimal.valueOf(1.98)));
		*/
		
		// TESTING REGISTER EQUALITY
		
		Register r1 = new Register(0, 0, 0, 3, 0, 0, 0, 0, 1, 2);
		Register r2 = new Register(0, 0, 0, 3, 0, 0, 0, 0, 1, 2);
		System.out.println(r1.equals(r2));
		System.out.println(r1.getRegisterBalance());
		System.out.println(r2.getRegisterBalance());
		Register r3 = new Register(0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
		Register r4 = new Register(0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
		System.out.println(r3.equals(r4));
		System.out.println(r3.getRegisterBalance());
		System.out.println(r4.getRegisterBalance());
	}
}
