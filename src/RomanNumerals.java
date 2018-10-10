import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/*Rules:
There were certain rules that the numerals followed which should be observed:
•The symbols 'I', 'X', 'C', and 'M' can be repeated at most 3 times in a row.
•The symbols 'V', 'L', and 'D' can never be repeated.
•The '1' symbols ('I','X', and 'C') can only be subtracted from 
the 2 next highest values ('IV' and  'IX',  'XL' and 'XC', 'CD' and 'CM').
•Only one subtraction can be made per numeral ('XC' is allowed, 'XXC' is not).
•The '5' symbols ('V', 'L', and 'D') can never be subtracted*/




public class RomanNumerals {
	public int convertToInteger(String romanNum) {
		
			String redString1 = romanNum;
			boolean empty = redString1.isEmpty();
				if(empty) {
					return 0;
				}
			boolean hadCommaSlash = redString1.contains(",\n");
			if(hadCommaSlash) {
				return -1;
			}		
			//String delims = "[,\n]";
			String delims = "";
			String[] numbers = redString1.split(delims);
			
			int lukuja = numbers.length;
			int summa = 0;
			String number = "";
			for (int i = 0; i < lukuja ; i++ ) {
				char[] c = numbers[i].toCharArray();
				int  merkkeja = c.length;
				 number = ""; 
				if(Character.isAlphabetic(c[merkkeja-1])) {
					summa = parseArabic(numbers);
					
					
				}else if (Character.isDigit(c[merkkeja-1])) {
					//do nothing
				//summa = summa+ Integer.parseInt(numbers[i]);
				}
			}
			summa = Integer.parseInt(number);
			return summa;
			
				
	}
	public int parseArabic(String[] romans) {
		String [] RomanNumbers = romans;
		int merkkeja = RomanNumbers.length; 
		int number =0;
		if(merkkeja < 2) {
			if(RomanNumbers[1] == "I" && merkkeja < 2) {
				 number = number + 1;
			}
			if(RomanNumbers[1] == "V") {
				 number = number + 5;
			}
			if(RomanNumbers[1] == "X") {
				 number = number + 10;
			}
			if(RomanNumbers[1] == "C") {
				 number = number + 100;
			}
			if(RomanNumbers[1] == "D") {
				 number = number + 500;
			}
			if(RomanNumbers[1] == "M") {
				 number = number + 1000;
			}
		}
		
		
		int conventerRoman = number;
		return conventerRoman;
		
	}
	
	public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;
        int occured = 0;
        
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
        	RomanNumeral symbol = romanNumerals.get(i);
        	if (i>1) {
        		RomanNumeral symbol2 = romanNumerals.get(i-1);
        		//RomanNumeral symbol1 = romanNumerals.get(i-1);
        		if( symbol2 == symbol) {
        			occured ++;
        		}
        		if(occured > 3) {
        			throw new IllegalArgumentException(input + " too many same Letters");
        		}
        	}
             
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
	}
	enum RomanNumeral {
	    I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);

	    private int value;

	    RomanNumeral(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	    
	    public static List<RomanNumeral> getReverseSortedValues() {
	        return Arrays.stream(values())
	          .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
	          .collect(Collectors.toList());
	    }
	}
		
}

