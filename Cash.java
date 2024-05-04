/**
 * @author Michelle Nguyen
 * @version 2024-05-03
 */


// IMPORT CLASSES
import java.math.BigDecimal;
import java.util.TreeMap;


public class Cash {
	enum Type { HUNDRED, FIFTY, TWENTY, TEN, FIVE, TOONIE, LOONIE, QUARTER, DIME, NICKEL }
	private static Type types[] = new Type[] {Type.HUNDRED, Type.FIFTY, Type.TWENTY, Type.TEN, Type.FIVE,
			Type.TOONIE, Type.LOONIE, Type.QUARTER, Type.DIME, Type.NICKEL};
	
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
		return "invalid coin type"; // for bug-testing
	}
	
	public static BigDecimal getValue(Type type)
	{
		switch (type) {
			case HUNDRED: 
				// new BigDecimal(100.00) <-- do NOT use constructor using double, has problems with floating point rep
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
		return new BigDecimal(-1000000);	// incredibly negative for bug-testing
	}
	
	// Assumes that param p (payment) is rounded to nearest 5 or 0
	public static TreeMap<Type, Integer> calculateChange(BigDecimal p, Register r)
	{
		BigDecimal payment = p;
		
		TreeMap<Type, Integer> register = new TreeMap<>();
		register.putAll(r.getBills());
		register.putAll(r.getCoins());

		TreeMap<Type, Integer> change = new TreeMap<>();
		for (Type type : types) {
			BigDecimal value = getValue(type);
			//System.out.println("VALUE: " + value);
			 
			int n = 0;
			while (payment.compareTo(value) >= 0.0 && register.get(type) > 0) {
				payment = payment.subtract(value);
				//System.out.println("REMAINING: " + value + ", " + payment);
				n++;
				register.put(type, register.get(type) - 1);
				//System.out.println("NUMBER: " +  n + "\n");
			}
			change.put(type, n);
		}
		if (payment.compareTo(BigDecimal.valueOf(0.0)) != 0)
			System.out.println("Value was not reached " + payment + " remaining.");
		else
			System.out.println("Value was reached.");
		return change;
	}
}
