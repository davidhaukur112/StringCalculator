package is.ru.stringcalculator;

public class Calculator{

	public static int add(String text){

		// If the string is empty, zero is returned
		if(text.equals("")){
			return 0;
		}
		
		// If the string contains the newline symbol
		if(text.contains("\n")){
			// We run this method to change the newLines to commas.
			String tempString = changeNewLinesToCommas(text);
			text = tempString;
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

	// This method replaces the newlines (\n) with a comma.
	private static String changeNewLinesToCommas(String text){
		
		char[] characterArray = text.toCharArray();
		
		// Replacement loop
		for(int i=0;i<text.length();i++){
			if(text.charAt(i) == '\n'){
				characterArray[i] = ',';
			}
		}
		
		String withoutNewLines = new String(characterArray);
		// A valid string is returned
		return withoutNewLines;
	}

}
