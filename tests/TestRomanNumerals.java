import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {

	@Test
	public void testEmpty()  {
		RomanNumerals convert = new RomanNumerals();
		
		int result = convert.convertToInteger("");
		// Assert
		assertEquals("No empty string", 0, result);
	}
	@Test
	public void testI()  {
		RomanNumerals convert = new RomanNumerals();
		
		int result = convert.romanToArabic("I");
		// Assert
		assertEquals("Can not find I", 1, result);
	}
	@Test
	public void testV()  {
		RomanNumerals convert = new RomanNumerals();
		
		int result = convert.romanToArabic("V");
		// Assert
		assertEquals("Can not find V", 5, result);
	}
	@Test
	public void testX()  {
		RomanNumerals convert = new RomanNumerals();
		
		int result = convert.romanToArabic("X");
		// Assert
		assertEquals("Can not find X", 10, result);
	}
	@Test
	public void testC()  {
		RomanNumerals convert = new RomanNumerals();
		
		int result = convert.romanToArabic("C");
		// Assert
		assertEquals("Can not find X", 100, result);
	}
	@Test
	public void testD()  {
		RomanNumerals convert = new RomanNumerals();
		
		int result = convert.romanToArabic("D");
		// Assert
		assertEquals("Can not find X", 500, result);
	}
	@Test
	public void testM()  {
		RomanNumerals convert = new RomanNumerals();
		
		int result = convert.romanToArabic("M");
		// Assert
		assertEquals("Can not find M", 1000, result);
	}
	@Test
	public void testMMC()  {
		RomanNumerals convert = new RomanNumerals();
		
		int result = convert.romanToArabic("MMC");
		// Assert
		assertEquals("Can not find M", 2100, result);
	}
	@Test
	public void testIIII()  {
		RomanNumerals convert = new RomanNumerals();
		
		int result = convert.romanToArabic("IIII");
		// Assert
		assertEquals("Can not find M", -1, result);
	}
}
