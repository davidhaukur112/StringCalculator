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

	// iii & iv (a few more test cases added)
	// Example inputs: "", "1", or "1,2"
	
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









	
}
