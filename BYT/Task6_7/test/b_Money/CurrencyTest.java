package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		NOK = new Currency("NON", 4.4);
	}

	@Test
	public void testGetName() {
		String name = "BLR";
		Currency BLR = new Currency(name, 2.2);
		assertEquals(name, BLR.getName());
	}
	
	@Test
	public void testGetRate() {
		Double rate = 2.2;
		Currency BLR = new Currency("BLR", rate);
		assertEquals(rate, BLR.getRate());
	}
	
	@Test
	public void testSetRate() {
		Double rate = 2.2;
		Currency BLR = new Currency("BLR", rate);
		assertEquals(rate, BLR.getRate());
		rate = 4.4;
		BLR.setRate(rate);
		assertEquals(rate, BLR.getRate());
	}
	
	@Test
	public void testGlobalValue() {
		Integer amount = 500;
		Integer universalCurrency = (int)(500 * 4.4);
		assertEquals(universalCurrency, NOK.universalValue(amount));
	}
	
	@Test
	public void testValueInThisCurrency() {
		Integer amount = 500;
		Integer expected = (int)(500 * SEK.getRate()/DKK.getRate());
		assertEquals(expected, DKK.valueInThisCurrency(500, SEK));
	}

}
