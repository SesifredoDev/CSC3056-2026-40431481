package test;

import model.Transaction;
import java.util.Date;
import java.util.Objects;
import java.util.Calendar;

public class TransactionTest {

    public static void main(String[] args) {
        testTransactionConstructor();
    }

    public static void testTransactionConstructor() {
        String test_account_number = "987654321";
        double test_amount = 500.25;
        Date test_date = Calendar.getInstance().getTime();

        Transaction testTransaction = new Transaction(test_account_number, test_amount, test_date);

        System.out.println("Starting the assertions of the test method: testTransactionConstructor");

        if (Objects.equals(testTransaction.getAccount_number(), test_account_number)) {
            TestUtils.printPass("TC1-getAccount_number");
        } else {
            TestUtils.printFail("TC1-getAccount_number");
        }

        if (testTransaction.getTransaction_amount() == test_amount) {
            TestUtils.printPass("TC2-getTransaction_amount");
        } else {
            TestUtils.printFail("TC2-getTransaction_amount");
        }

        if (Objects.equals(testTransaction.getTransaction_date(), test_date)) {
            TestUtils.printPass("TC3-getTransaction_date");
        } else {
            TestUtils.printFail("TC3-getTransaction_date");
        }
    }
}