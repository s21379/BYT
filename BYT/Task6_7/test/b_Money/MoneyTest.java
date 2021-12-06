package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		int amount = 500;
		Money newSEK5 = new Money(amount, SEK);
		assertEquals(newSEK5.getAmount().intValue(), amount);
	}

	@Test
	public void testGetCurrency() {
		Currency currency = EUR;
		assertEquals(currency, EUR20.getCurrency());
	}

	@Test
	public void testToString() {
		String msg = "200.00 SEK";
		assertEquals(SEK200.toString(), msg);
	}

	@Test

	public void testGlobalValue() {
		Integer expectedCurr = (int)(SEK100.getAmount() * SEK100.getCurrency().getRate());
		assertEquals(expectedCurr, SEK100.universalValue());
	}

	@Test
	public void testEqualsMoney() {
		Money newEUR10 = new Money(1000, EUR);
		Money SEK100 = new Money(10000, SEK);
		assertTrue(newEUR10.equals(EUR10));
		assertNotEquals(newEUR10, EUR10);
		assertFalse(newEUR10.equals(SEK200));
	}

	@Test
	public void testAdd() {
		Money result = new Money((int)((EUR10.universalValue() + SEK200.universalValue()) / EUR.getRate()), EUR);
		assertEquals(result.getAmount(), EUR10.add(SEK200).getAmount());
	}

	@Test
	public void testSub() {
		Money result = new Money((int)((EUR0.universalValue() - SEK100.universalValue()) / EUR.getRate()), EUR);
		assertEquals(result.getAmount(), EUR0.sub(SEK100).getAmount());
	}

	@Test
	public void testIsZero() {
		assertTrue(EUR0.isZero());
	}

	@Test
	public void testNegate() {
		int result = -2000;
		assertEquals(result, EUR20.negate().getAmount().intValue());
		assertNotEquals(result , SEK200.negate().getAmount().intValue());
		assertNotEquals(SEK200, SEK200.negate());
	}

	@Test
	public void testCompareTo() {
		Money newEUR20 = new Money(2000, EUR);
		assertEquals(0, newEUR20.compareTo(EUR20));
		assertTrue(EUR10.compareTo(SEK0) > 0);
		assertTrue(SEK100.compareTo(EUR20) < 0);
	}
}
