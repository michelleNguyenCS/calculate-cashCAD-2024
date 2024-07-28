/**
 * @author Michelle Nguyen
 * @version 2024-07-27
 */


// IMPORT CLASSES
import java.math.BigDecimal;
import java.util.TreeMap;


/**
 * Helper Class,
 * Methods with cash
 */
public class Cash {
	// The different types of bills and coins
	enum Type { HUNDRED, FIFTY, TWENTY, TEN, FIVE, TOONIE, LOONIE, QUARTER, DIME, NICKEL }
	// Array of the different types of bills and coins
	// Static so that this array remains the same throughout all instances (if I implement that)
	private static Type types[] = new Type[] {Type.HUNDRED, Type.FIFTY, Type.TWENTY, Type.TEN, Type.FIVE,
			Type.TOONIE, Type.LOONIE, Type.QUARTER, Type.DIME, Type.NICKEL};
	
	/* GET METHODS */
	
	/**
	 * Return a String representation of the value of the cash type,
	 * for printing purposes
	 * 
	 * @param type	The cash type
	 * @return		The string representation of the value
	 */
	public static String getCashType(Type type)
	{
		switch (type) {
			case HUNDRED: 
				return "100";
			case FIFTY: 
				return "50";
			case TWENTY: 
				return "20";
			case TEN: 
				return "10";
			case FIVE: 
				return "5";
			case TOONIE: 
				return "2";
			case LOONIE: 
				return "1";
			case QUARTER: 
				return "25c";
			case DIME: 
				return "10c";
			case NICKEL: 
				return "5c";
		}
		return "invalid coin type";	// bug-testing
	}
	
	/**
	 * Return a BigDecimal representation of the value of the cash type
	 * 
	 * @param type	The cash type
	 * @return		The BigDecimal representation of the value
	 */
	public static BigDecimal getValue(Type type)
	{
		switch (type) {
			case HUNDRED: 
				// new BigDecimal(100.00) 
				// ^ do NOT use constructor using double, has problems with floating point rep.
				return BigDecimal.valueOf(100.00);
			case FIFTY: 
				return BigDecimal.valueOf(50.00);
			case TWENTY: 
				return BigDecimal.valueOf(20.00);
			case TEN: 
				return BigDecimal.valueOf(10.00);
			case FIVE: 
				return BigDecimal.valueOf(5.00);
			case TOONIE: 
				return BigDecimal.valueOf(2.00);
			case LOONIE: 
				return BigDecimal.valueOf(1.00);
			case QUARTER: 
				return BigDecimal.valueOf(0.25);
			case DIME: 
				return BigDecimal.valueOf(0.10);
			case NICKEL: 
				return BigDecimal.valueOf(0.05);
		}
		return new BigDecimal(-10000.00);	// incredibly negative for bug-testing
	}
	
	/* METHODS */
	
	/**
	 * Rounds a cash value to the nearest x.x5 or x.x0,
	 * assumes the cash input is positive
	 * 
	 * @param c	The cash value
	 * @return	The rounded cash value
	 */
	public static BigDecimal roundCash(BigDecimal c)
	{
		// If it does not evenly divide (r != 0), then it needs to be rounded
		// r is the remainder
		BigDecimal r = c.remainder(BigDecimal.valueOf(0.05));
		
		// bug-testing
		System.out.println("original: " + c + "\t" + "remainder: " + r);
		
		// For some reason "BigDecimal.valueOf()" won't work properly
		/*
		if (r.equals(BigDecimal.valueOf(0.0)) || r.equals(BigDecimal.valueOf(0.00))) {
			return c; }
		*/

		// If the cash is already rounded, remainder is 0.00
		if (r.equals(new BigDecimal("0.0")) || r.equals(new BigDecimal("0.00")))
			return c;
		
		// Determines if cash needs to be rounded up or down
		/*
		 * Explaining my logic for when I work on this every blue moon
		 * Looking back at this makes me think I over-complicated this but,
		 * I can think about that another time
		 * 
		 * range is the remainder subtracted by 0.02
		 * we subtract 0.02 since it is the turning point for rounding
		 * and will help us determine if the value should be rounded up or down
		 * 
		 * if the range is lower than or equal to 0 (remain. = 0.01, 0.02), round down
		 * if the range is greater than 0 (remainder = 0.03, 0.04), round up
		 * range = 0.01 - 0.02 = -0.01
		 * range = 0.02 - 0.02 = 0.00
		 * range = 0.03 - 0.02 = 0.01
		 * range = 0.04 - 0.02 = 0.02 
		 */
		BigDecimal range = r.subtract(BigDecimal.valueOf(0.02));
		
		// The remainder is 0.01 or 0.02
		// compareTo returns a (-) or 0 if range is less than or equal to 0, round down
		if (range.compareTo(BigDecimal.valueOf(0.0)) <= 0)
			return c.subtract(r);
		// The remainder is 0.03 or 0.04
		// compareTo returns a + if range is greater than 0, round up
		else if (range.compareTo(BigDecimal.valueOf(0.0)) > 0)
			return c.add(BigDecimal.valueOf(0.05).subtract(r));
		return BigDecimal.valueOf(-1000.00);	// bug-testing, this case shouldn't occur
	}
	
	/**
	 * Calculates the best change to give based on the contents of the cash register,
	 * assumes the payment (p) is rounded to the nearest x.x5 or x.x0
	 * 
	 * @param p	The payment the customer has given us
	 * @param r	The contents of the cash register
	 * @return	The best change to return based on the contents of the register
	 */
	public static TreeMap<Type, Integer> calculateChange(BigDecimal p, Register r)
	{
		// The payment the customer makes to the cashier
		BigDecimal payment = p;
		
		// The cashier's current register
		TreeMap<Type, Integer> register = new TreeMap<>();
		register.putAll(r.getBills());
		register.putAll(r.getCoins());

		// The best change to return to the customer (this is what the method will return)
		TreeMap<Type, Integer> change = new TreeMap<>();
		// Go through all the cash types
		for (Type type : types) {
			// Get the value of the cash type
			BigDecimal value = getValue(type);
			//System.out.println("VALUE: " + value);
			 
			// How much of the cash type we need for the return change
			int n = 0;
			// If the payment is >= than the current cash type, and we still have that type left
			while (payment.compareTo(value) >= 0.0 && register.get(type) > 0) {
				// Subtract the cash type value from the payment
				payment = payment.subtract(value);
				//System.out.println("REMAINING: " + value + ", " + payment);
				n++;
				register.put(type, register.get(type) - 1);
				//System.out.println("NUMBER: " +  n + "\n");
			}
			change.put(type, n);
		}
		// If the payment is not yet 0, then there is not enough cash types in the register
		if (payment.compareTo(BigDecimal.valueOf(0.0)) != 0)
			System.out.println("Value was not reached " + payment + " remaining.");
		// If the payment is 0, then there is enough change in the register
		else
			System.out.println("Value was reached.");
		return change;
	}
}
