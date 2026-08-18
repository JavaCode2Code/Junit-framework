/**
 * 
 */
package com.scjp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.scjp.java.entity.Account;
import com.scjp.java.exception.AccountNotFoundException;
import com.scjp.java.service.AccountService;

/**
 * 
 */
class AccountServiceTest {

	private static AccountService accountService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUp() throws Exception {
		accountService = new AccountService();
		System.out.println("Inililization Service");
	}

	@AfterAll
	static void tearDown() {
		accountService = null;
		System.out.println("Dinililization Service");
	}

	@Nested
	class CurdTest {
		@Test
		void testCreateaAccount() {
			Account account = (Account) accountService.createAccount(108L, "Sateesh", 20000.0);
			assertNotNull(account);
			assertEquals(108L, account.getAccountNumer());
			assertEquals("Sateesh", account.getAccHolderName());
			assertEquals(20000.0, account.getBalance());
			System.out.println("Test exceuted Successfully");
		}

		@Test
		public void testUpdateAccount() {
			Account account = accountService.createAccount(111L, "Rajesh", 2000.0);
			assertNotNull(account);
			Account updateAcc = accountService.updateAccount(111L, "Ramu");
			assertEquals("Ramu", updateAcc.getAccHolderName());
			AccountNotFoundException exception = assertThrows(AccountNotFoundException.class,
					() -> accountService.updateAccount(133L, "Ramu"));
			assertEquals("Account not found", exception.getMessage());
		}

		@Test
		public void testGetAccount() {
			Account account = accountService.createAccount(137L, "Brijendra", 20000.0);
			assertNotNull(account);
			assertEquals(137L, account.getAccountNumer());
			assertEquals("Brijendra", account.getAccHolderName());
			assertEquals(20000.0, account.getBalance());
			AccountNotFoundException exception = assertThrows(AccountNotFoundException.class,
					() -> accountService.getAccount(123L));
			assertEquals("Account not found", exception.getMessage());
		}

		@Test
		public void testRemoveAccout() {
			Account account = accountService.createAccount(138L, "Monu", 1000.0);

			assertNotNull(account);
			accountService.removeAccount(138L);
			AccountNotFoundException exception = assertThrows(AccountNotFoundException.class,
					() -> accountService.removeAccount(138L));
			assertEquals("Account not found", exception.getMessage());
		}
	}

	@Nested
	class WithdrawTests {
		@Test
		public void TestdepositAccout() {
			Account account = accountService.createAccount(139L, "Rahul", 20000.0);
			assertNotNull(account);
			accountService.deposit(139L, 4000.0);
			Account updateAcc = accountService.getAccount(139L);
			Double actualAmt = updateAcc.getBalance();
			assertEquals(actualAmt, 24000);
		}

		@Test
		public void TestdepositAccout_negative() {
			Account account = accountService.createAccount(140L, "Binu", 20000.0);
			assertNotNull(account);

			IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
				accountService.deposit(140L, -20000.0);
			});
			assertNotNull(exception);
			assertEquals("Deposit amount must be greater than zero.", exception.getMessage());
		}

		@Test
		public void testWithdrawAcc() {
			Account account = accountService.createAccount(141L, "Dinu", 20000.0);
			assertNotNull(account);
			accountService.withdraw(141L, 5000.0);
			Account updatAcc = accountService.getAccount(141L);
			Double ammout = updatAcc.getBalance();
			assertEquals(15000, ammout);

		}

		@Test
		public void testWithdrawAcc_Insufficiant() {
			accountService.createAccount(142L, "Dinu", 500.0);

			IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
				accountService.withdraw(142L, 1000.00);
			});
			assertNotNull(exception);
			assertEquals("Insuficient Balance", exception.getMessage());
		}

		@Test
		public void testWithdrawAcc_Negative() {
			accountService.createAccount(143L, "Minu", 3000.0);

			IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
				accountService.withdraw(143L, -1000.00);
			});
			assertNotNull(exception);
			assertEquals("Withdraw amount must be greater than zero.", exception.getMessage());
		}
	}

	@Nested
	class TestTrasferMoney {
		@Test
		public void testTransferMoney() {
			accountService.createAccount(144L, "Rani", 20000.0);
			accountService.createAccount(145L, "Raj", 2000.0);

			accountService.transferMoney(144L, 145L, 10000.0);

			Account updateFromAccount = accountService.getAccount(144L);
			Account updatToAcc = accountService.getAccount(145L);

			Double fromAmout = updateFromAccount.getBalance();
			Double toAmmount = updatToAcc.getBalance();

			assertEquals(10000.0, fromAmout);
			assertEquals(12000.0, toAmmount);
		}

		@Test
		public void testTransferInsufficiantFund() {
			accountService.createAccount(146L, "Rani", 2000.0);
			accountService.createAccount(147L, "Raj", 2000.0);
			assertThrows(IllegalArgumentException.class, () -> {
				accountService.transferMoney(146l, 147l, 3000.0);
			});

		}

		 @Test
		public void testTransfer_NegativeFund() {
			accountService.createAccount(148L, "Rani", 20000.0);
			accountService.createAccount(149L, "Raj", 2000.0);

			assertThrows(IllegalArgumentException.class, () -> {
				accountService.transferMoney(148l, 149l, -2000.0);
			});
		}
	}
}
