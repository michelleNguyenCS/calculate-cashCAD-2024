/**
 * This program will generate a payment scenario where the user must determine the correct
 * amount of change to return to the customer.
 * 
 * @author Michelle Nguyen
 * @since 2024-05-01
 */


// IMPORT CLASSES
//import java.util.Random;


public class Main {

	public static void main(String[] args) {
		
		// TESTING
		
		Register register = new Register(2, 3, 14, 19, 8, 25, 25, 40, 50, 40);	// $952.00
		//Register register = new Register(1, 2, 3, 5, 2, 1, 3, 2, 1, 2);	// $325.70
		
		System.out.println(register);
		System.out.printf("$%.2f", register.getRegisterBalance());
	}

}
