package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		String expectedName = "SweBank";
		assertEquals(expectedName, new Bank(expectedName, SEK).getName());
	}

	@Test
	public void testGetCurrency() {

		assertEquals(SEK, new Bank("SweBank", SEK).getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException, IllegalAccessException, NoSuchFieldException {
		String Account = "Account";
		Nordea.openAccount(Account);
		assertNotNull(Nordea.accountlist.get(Account));
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		Integer balanceBefore = SweBank.getBalance("Ulrika");
		SweBank.deposit("Ulrika", new Money(10, SEK));
		assertEquals(balanceBefore + 10, SweBank.getBalance("Ulrika").intValue());
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		Integer balanceBefore = SweBank.getBalance("Ulrika");
		SweBank.withdraw("Ulrika", new Money(100, SEK));
		assertEquals(balanceBefore - 100, SweBank.getBalance("Ulrika").intValue());
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException, AccountExistsException {
		String Account = "Account2";
		Money depositAmount = new Money(500, SEK);

		SweBank.openAccount(Account);
		SweBank.deposit(Account, depositAmount);
		assertEquals(depositAmount.getAmount(), SweBank.getBalance(Account));
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		Integer amount = 500;
		SweBank.deposit("Ulrika", new Money(amount, SEK));
		SweBank.transfer("Ulrika", Nordea, "Bob", new Money(amount, SEK));
		assertEquals(amount, Nordea.getBalance("Bob"));
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.addTimedPayment("Bob", "BotToUlrika", 5000, 50, new Money(500, SEK), SweBank, "Ulrika");
	}
}
