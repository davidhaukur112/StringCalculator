package is.ru.stringcalculator;

public class Calculator{

	public static int add(String text){

		// If the string is empty, zero is returned
		if(text.equals("")){
			return 0;
		}
	    if(text.contains(",")){
			String numbers[] = text.split(",");
			return sumUp(numbers);
		}

		return toInt(text);
	}

	// This method takes in a String number 
	// and returns an Integer.
	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	// This method sums up the numbers in the string array
	// and returns the total.
	private static int sumUp(String [] numbers){
		int total = 0;
		for(String number : numbers){
			total += toInt(number);
		}
		return total;
	}
}
