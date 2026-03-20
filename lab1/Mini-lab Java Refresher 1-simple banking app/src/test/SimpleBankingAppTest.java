package test;

import app.SimpleBankingApp;

public class SimpleBankingAppTest {

    
	// system under test (SUT):
	//static SimpleBankingApp mainApp = new SimpleBankingApp ();

	// this test method (test case) verifies if the data load feature of the class (unit or component) 
	// under test (UUT) works properly
	public static void testLoadData() {
		SimpleBankingApp.loadUserData();
		if (SimpleBankingApp.users.size() == 3)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadUserData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadUserData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);


		
		SimpleBankingApp.loadAccountData();
		if (SimpleBankingApp.accounts.size() == 4)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadAccountData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadAccountData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);


	}


	public static void testDeposits() {
		// 1-Setup phase
		double balanceBefore = SimpleBankingApp.getBalance("5495-1234"); 
		double depositAmount = 50.21;


		SimpleBankingApp.addTransaction("5495-1234", depositAmount);
		double balanceAfter = SimpleBankingApp.getBalance("5495-1234");

		assert balanceBefore + depositAmount == balanceAfter;
		if (balanceBefore + depositAmount == balanceAfter)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testDeposits: TC1 passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED XXX: balanceBefore + depositAmount != balanceAfter");
			System.out.format("testDeposits: balanceBefore = %.2f ; depositAmount = %.2f ; balanceAfter = %.2f %s\n", 
					balanceBefore , depositAmount , balanceAfter, TestUtils.TEXT_COLOR_RESET);
		}
		
		SimpleBankingApp.addTransaction("5495-1234", -depositAmount);
	}

	public static void testWithdrawals() {
		String account_number = "5495-1234";
		double initialBalance = SimpleBankingApp.getBalance(account_number);
		double withdrawalAmount1 = -100.00;
		double withdrawalAmount2 = -50.50;
		double expectedBalance = initialBalance + withdrawalAmount1 + withdrawalAmount2;

		System.out.println("Starting testWithdrawals...");

		SimpleBankingApp.addTransaction(account_number, withdrawalAmount1);
		SimpleBankingApp.addTransaction(account_number, withdrawalAmount2);

		double currentBalance = SimpleBankingApp.getBalance(account_number);

		if (currentBalance == expectedBalance) {
			TestUtils.printPass("testWithdrawals");
		} else {
			TestUtils.printFail("testWithdrawals (Expected " + expectedBalance + " but got " + currentBalance + ")");
		}
	}

	public static void testAddTransaction() {
		String validAccountNumber = "5495-1234";
		String invalidAccountNumber = "0000-0000";
		double amount = 100.00;
		Double failAmount = 100000.00;

		System.out.println("Starting testAddTransaction...");


		boolean resultValid = SimpleBankingApp.addTransaction(validAccountNumber, amount);
		if (resultValid) {
			TestUtils.printPass("testAddTransaction: TC1 - Valid Account");
		} else {
			TestUtils.printFail("testAddTransaction: TC1 - Valid Account");
		}


		boolean resultInvalid = SimpleBankingApp.addTransaction(invalidAccountNumber, amount);
		if (!resultInvalid) {
			TestUtils.printPass("testAddTransaction: TC2 - Invalid Account (Properly Rejected)");
		} else {
			TestUtils.printFail("testAddTransaction: TC2 - Invalid Account (Failed to Reject)");
		}
		boolean amountInvalid = SimpleBankingApp.addTransaction(validAccountNumber, failAmount);
		if (!amountInvalid) {
			TestUtils.printPass("testAddTransaction: TC3 - Invalid Account (Amount Rejected)");
		}else{
			TestUtils.printFail("testAddTransaction: TC3 - Invalid Account (Amount Rejected)");
		}
	}


	
	public static void main(String[] args) {
		testLoadData();
		testDeposits();
		testWithdrawals();
		testAddTransaction();
	}

}
