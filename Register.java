/**
 * @author Michelle Nguyen
 * @version 2024-07-27
 */


// IMPORT CLASSES
import java.math.BigDecimal;
import java.util.TreeMap;

/**
 * Data Class,
 * Cash registers or general sets of cash
 */
public class Register {
	private TreeMap<Cash.Type, Integer> bills;
	private TreeMap<Cash.Type, Integer> coins;
	
	/*
	 * CONSTRUCTOR
	 * Might consider combining bills and coins into one map
	 */
	
	public Register(int hundredCount, int fiftyCount, int twentyCount, int tenCount, int fiveCount,
			int toonieCount, int loonieCount, int quarterCount, int dimeCount, int nickelCount) {
		// ADDING BILL COUNT
		bills = new TreeMap<>();
		bills.put(Cash.Type.HUNDRED, hundredCount);
		bills.put(Cash.Type.FIFTY, fiftyCount);
		bills.put(Cash.Type.TWENTY, twentyCount);
		bills.put(Cash.Type.TEN, tenCount);
		bills.put(Cash.Type.FIVE, fiveCount);
		//System.out.println(bills);	// bug-testing
		// ADDING COIN COUNT
		coins = new TreeMap<>();
		coins.put(Cash.Type.TOONIE, toonieCount);
		coins.put(Cash.Type.LOONIE, loonieCount);
		coins.put(Cash.Type.QUARTER, quarterCount);
		coins.put(Cash.Type.DIME, dimeCount);
		coins.put(Cash.Type.NICKEL, nickelCount);
		//System.out.println(coins);	// bug-testing
	}
	
	/* GET METHODS */
	
	/**
	 * Return a TreeMap of all the bills in the register
	 * 
	 * @return	The bills in the register
	 */
	public TreeMap<Cash.Type, Integer> getBills() {
		return bills;
	}
	
	/**
	 * Return a TreeMap of all the coins in the register
	 * 
	 * @return	The coins in the register
	 */
	public TreeMap<Cash.Type, Integer> getCoins() {
		return coins;
	}
	
	/* METHODS */
	
	/**
	 * Get the value of the register
	 * 
	 * @return	The monetary value of the register as a BigDecimal
	 */
	public BigDecimal getRegisterBalance()
	{
		BigDecimal registerValue = BigDecimal.valueOf(0.0);
		
		for (Cash.Type type : bills.keySet()) {
			BigDecimal cashValue = Cash.getValue(type);
			registerValue = registerValue.add(cashValue.multiply(BigDecimal.valueOf(bills.get(type))));
			
		}
		for (Cash.Type type : coins.keySet()) {
			BigDecimal cashValue = Cash.getValue(type);
			registerValue = registerValue.add(cashValue.multiply(BigDecimal.valueOf(coins.get(type))));
		}
		return registerValue;
	}
	
	/* OVERRIDE METHODS */
	
	/**
	 * Determine if two registers have the same contents
	 * 
	 * @param r	The other register to compare
	 * @return	Whether the two register have equal components
	 */
	public boolean equals(Register r)
	{
		if (!(r.getBills().equals(bills)))
			return false;
		if (!(r.getCoins().equals(coins)))
			return false;
		return true;
	}
	
	/**
	 * Print out all the bills and coins
	 */
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
