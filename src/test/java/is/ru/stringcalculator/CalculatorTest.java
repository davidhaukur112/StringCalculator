package is.ru.stringcalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest{

    //   *** STEP 1 ***

	// i
	// The method can take 0, 1, or 2 numbers and will return their sum.

	@Test
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
		assertEquals(55, Calculator.add("55"));
	}

	@Test
	public void testTwoNumber(){
		assertEquals(12, Calculator.add("5,7"));
	}

	// ii
	// An empty string will return 0.
	
	@Test
	public void testEmptyString(){
		assertEquals(0, Calculator.add(""));
	}

	// iii and iv (a few more test cases added)
	// Example inputs: "", "1", or "1,2"
	
	// v and vi are included below.

	@Test
	public void someOtherTests(){
		assertEquals(0, Calculator.add(""));
		assertEquals(1, Calculator.add("1"));
		assertEquals(3, Calculator.add("1,2"));
		assertEquals(7, Calculator.add("3,4"));
		assertEquals(11, Calculator.add("5,6"));
		assertEquals(11, Calculator.add("6,5"));
		assertEquals(7, Calculator.add("4,3"));
		assertEquals(3, Calculator.add("2,1"));
		assertEquals(2, Calculator.add("2"));
		assertEquals(0, Calculator.add("0,0"));
		assertEquals(0, Calculator.add("0"));
	}

	//   *** STEP 2 ***

	// Allow the Add method to handle an unknown number of arguments/numbers.

	@Test
	public void testMultipleNumbers(){
		// testing 3 numbers
		assertEquals(6, Calculator.add("1,2,3"));
		assertEquals(6, Calculator.add("3,2,1"));
		assertEquals(60, Calculator.add("10,20,30"));
		
		// 3 numbers zero tests
		assertEquals(2, Calculator.add("1,1,0"));
		assertEquals(2, Calculator.add("1,0,1"));
		assertEquals(2, Calculator.add("0,1,1"));
		assertEquals(0, Calculator.add("0,0,0"));
		
		// testing 4 numbers
		assertEquals(10, Calculator.add("1,2,3,4"));
		assertEquals(10, Calculator.add("4,3,2,1"));
		assertEquals(100, Calculator.add("10,20,30,40"));
		
		// 4 numbers zero tests
		assertEquals(3, Calculator.add("1,1,1,0"));
		assertEquals(3, Calculator.add("1,1,0,1"));
		assertEquals(3, Calculator.add("1,0,1,1"));
		assertEquals(3, Calculator.add("0,1,1,1"));
		assertEquals(1, Calculator.add("0,0,0,01"));
		
		// testing 10 numbers
		assertEquals(55, Calculator.add("1,2,3,4,5,6,7,8,9,10"));
		assertEquals(0, Calculator.add("0,0,0,0,0,0,0,0,0,0"));
		assertEquals(1, Calculator.add("0,0,0,0,0,0,0,0,0,1"));
		assertEquals(1, Calculator.add("1,0,0,0,0,0,0,0,0,0"));
	}


	//   *** STEP 2 ***	

	// Allow the Add method to handle new lines between numbers (instead of commas).
	
	// i
	// Example: "1\n2,3" should return 6.

	@Test
	public void newLinesTest(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	// ii and iii
	// Example: "1,\n" is invalid.
	// I only test correct inputs.

	@Test
	public void moreNewLinesTests(){
		// The first test (the one that is commented) is invalid.
		// It would be handled with an exception inside the 
		// changeNewLinesToCommas method. 
		// SEE changeNewLinesToCommas() for an explanation!
		
		//assertEquals(1, Calculator.add("1,\n"));
		
		assertEquals(3, Calculator.add("1\n2"));
		assertEquals(3, Calculator.add("2\n1"));
		assertEquals(7, Calculator.add("3\n4"));
		assertEquals(3, Calculator.add("3\n0"));
		assertEquals(4, Calculator.add("0\n4"));
		assertEquals(0, Calculator.add("0\n0"));
		assertEquals(12, Calculator.add("5\n4\n3"));
		assertEquals(14, Calculator.add("5\n4\n3\n2"));
		assertEquals(15, Calculator.add("5\n4\n3\n2\n1"));
		assertEquals(15, Calculator.add("5\n4\n3\n2\n1\n0"));
		assertEquals(15, Calculator.add("0\n1\n2\n3\n4\n5"));
		assertEquals(0, Calculator.add("0\n0\n0\n0\n0\n0"));
	}


	
}
