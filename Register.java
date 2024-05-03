/**
 * @author Michelle Nguyen
 * @since 2024-05-01
 */


// IMPORT CLASSES
import java.util.TreeMap;


public class Register {
	private TreeMap<Cash.Type, Integer> bills;
	private TreeMap<Cash.Type, Integer> coins;
	
	/* CONSTRUCTOR */
	
	public Register(int hundredCount, int fiftyCount, int twentyCount, int tenCount, int fiveCount,
			int toonieCount, int loonieCount, int quarterCount, int dimeCount, int nickelCount) {
		// ADDING BILL COUNT
		bills = new TreeMap<>();
		bills.put(Cash.Type.HUNDRED, hundredCount);
		bills.put(Cash.Type.FIFTY, fiftyCount);
		bills.put(Cash.Type.TWENTY, twentyCount);
		bills.put(Cash.Type.TEN, tenCount);
		bills.put(Cash.Type.FIVE, fiveCount);
		System.out.println(bills);
		// ADDING COIN COUNT
		coins = new TreeMap<>();
		coins.put(Cash.Type.TOONIE, toonieCount);
		coins.put(Cash.Type.LOONIE, loonieCount);
		coins.put(Cash.Type.QUARTER, quarterCount);
		coins.put(Cash.Type.DIME, dimeCount);
		coins.put(Cash.Type.NICKEL, nickelCount);
		System.out.println(coins);
	}
	
	/* METHODS */
	
	public double getRegisterBalance()
	{
		double value = 0.0;
		
		for (Cash.Type type : bills.keySet()) {
			value += Cash.getValue(type) * bills.get(type);
		}
		for (Cash.Type type : coins.keySet()) {
			value += Cash.getValue(type) * coins.get(type);
		}
		return value;
	}
	
	/* OVERRIDE METHODS */
	
	public String toString()
	{
		String s = "REGISTER";
		
		s += "\n[---------------------------------------------------------------------------]\n";
		s += String.format("|%-5s", " ");
		for (Cash.Type type : bills.keySet()) {
			s += String.format("%-5s%-5d%-5s", Cash.getCashType(type) + ":", bills.get(type), "|");
		}
		s += "\n|---------------------------------------------------------------------------|\n";
		s += String.format("|%-5s", " ");
		for (Cash.Type type : coins.keySet()) {
			s += String.format("%-5s%-5d%-5s", Cash.getCashType(type) + ":", coins.get(type), "|");
		}
		s += "\n[---------------------------------------------------------------------------]";
		
		return s;
	}
}