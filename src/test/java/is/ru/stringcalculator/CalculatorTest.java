package is.ru.stringcalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest{

    //   *** STEP 1 ***

    // i 

	@Test
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumber(){
		assertEquals(3, Calculator.add("1,2"));
	}






	
}
