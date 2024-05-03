/**
 * @author Michelle Nguyen
 * @since 2024-05-01
 */


public class Cash {
	enum Type { HUNDRED, FIFTY, TWENTY, TEN, FIVE, TOONIE, LOONIE, QUARTER, DIME, NICKEL }
	
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
	
	public static double getValue(Type type)
	{
		switch (type) {
			case HUNDRED: 
				return 100.00;
			case FIFTY: 
				return 50.00;
			case TWENTY: 
				return 20.00;
			case TEN: 
				return 10.00;
			case FIVE: 
				return 5.00;
			case TOONIE: 
				return 2.00;
			case LOONIE: 
				return 1.00;
			case QUARTER: 
				return 0.25;
			case DIME: 
				return 0.10;
			case NICKEL: 
				return 0.05;
		}
		return -1000000;	// incredibly negative for bug-testing
	}
}
