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

		// If the string contains a minus symbol
		if(text.contains("-")){
			String numbers[] = text.split(",");
			// error!
			negativeError(numbers);
		}
		
		// Here I check if a delimiter is present
		if(text.contains("//")){
			// delimiterOperation returns a String array of numbers
			String numbers[] = delimiterOperation(text);
			return sumUp(numbers);
		}

		// Multiple Numbers.
	    if(text.contains(",")){
			String numbers[] = text.split(",");

			return sumUp(numbers);
		}

		// A single number as input
		// should be returned without changes.
		return toInt(text);
	}

	// This method takes in a String number 
	// and returns an Integer.
	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	// This method sums up all the numbers in the string array
	// that are less than 1001 and returns the total.
	private static int sumUp(String [] numbers){
		int total = 0;
		int value = 0;
		for(String number : numbers){
			value = toInt(number);
			// Numbers bigger than 1000 should be ignored.
			if(numberIsLargerThanThousand(value)){
				// We don't want to add this number to the total
				// so we 
				continue;
			}
			else{
				total += toInt(number);
			}
		}
		return total;
	}

	private static Boolean numberIsLargerThanThousand(int number){
		if(number > 1000){
			return true;
		}			
		return false;
	}

	// This method replaces the newlines (\n) with a comma.
	private static String changeNewLinesToCommas(String text){
		
		char[] characterArray = text.toCharArray();
		
		// Replacement loop
		for(int i=0;i<text.length();i++){
			if(text.charAt(i) == '\n'){
				if(characterArray[i-1] == ',' && i > 0){
					// Here an exception would be thrown
					// Because the string cannot have two commas in a row
				}
				else{
					characterArray[i] = ',';
				}
			}
		}
		
		String withoutNewLines = new String(characterArray);
		// A valid string is returned
		return withoutNewLines;
	}

	// This method finds all negative numbers in the string,
	// and throws an appropriate exception.
	private static void negativeError(String [] numbers){
		
		int length = numbers.length;
		int [] negativeArray = new int [length];
		String stringVal;
		int intVal;
		int index = 0;

		for(int i=0; i<numbers.length; i++){
			stringVal = numbers[i];
			intVal = toInt(stringVal);
			if(intVal < 0){
				negativeArray[index] = intVal;
				index = index + 1; 
			}
		}
		// The errorMessage is created and an exception is thrown!
		String errorMessage = createErrorMessage(negativeArray);
		throw new IllegalArgumentException(errorMessage);
	}

	private static String createErrorMessage(int [] negNumbers){
		
		// To create the string I use the Stringbuilder
		StringBuilder message = new StringBuilder();
		message.append("Negatives not allowed: ");
	
		int length = negNumbers.length;
		
		boolean lastZero = false;
		// This checks the last index of the array.
		// If the last index contains zero (initialization of the array)
		// then it is safe to check the i+1 index of negNumbers.
		// (I do this to remove the comma behind the last negative number).
		if(negNumbers[length-1] == 0){
			lastZero = true;
		}

		// If the last number is not zero
		if(lastZero == false){
			
			for(int i=0; i<length; i++){
				message.append(Integer.toString(negNumbers[i]));
				
				// Here it is ok to return the string
				if(i == length-1){
					String negativeWarning = message.toString();
					return negativeWarning;
				}
				message.append(",");
			}
		}

		for(int i=0; i<length; i++){
	
			if(negNumbers[i] == 0){
				break;
			}
			message.append(Integer.toString(negNumbers[i]));
			if(lastZero == true && negNumbers[i+1] == 0){
				break;
			}
			else{
				message.append(",");
			}
			
		}
		String negativeWarning = message.toString();
		return negativeWarning;
	}

	private static String[] delimiterOperation(String text){
		// The delimiter symbol is extracted.
		String delSymb = Character.toString(text.charAt(2));
		// The delimiter itself is removed.
		String result = text.substring(4);
		String numbers[] = result.split(delSymb);
		return numbers;
	}

}
