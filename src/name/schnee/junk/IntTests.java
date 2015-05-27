package name.schnee.junk;

import java.math.BigDecimal;

public class IntTests {
	public static void main(String args[])
	{
		int hoursPerDay = 24;
		double daysPerYear = 365.25;
		
		String twentyNines = "99999999999999999999";
		
		BigDecimal bigAssNumber = new BigDecimal(twentyNines); 
		
		BigDecimal yearsToRollOver = bigAssNumber.divideToIntegralValue(new BigDecimal(hoursPerDay)).divideToIntegralValue(new BigDecimal(daysPerYear));
		
		System.out.print(yearsToRollOver);
	}
	
	

}
