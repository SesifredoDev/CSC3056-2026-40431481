package test;

import model.Account;
import java.util.Date;
import java.util.Objects;
import java.util.Calendar;

public class AccountTest {

    public static void main(String[] args) {
        testAccountConstructor();
    }

    public static void testAccountConstructor() {
        String test_account_number = "987654321";
        String test_username = "mike@test.com";
        String test_account_type = "Standard";
        Date test_date = Calendar.getInstance().getTime();

        Account testAccount = new Account(test_account_number, test_username, test_account_type, test_date);

        System.out.println("Starting the assertions of the test method: testAccountConstructor");

        if (Objects.equals(testAccount.getAccount_number(), test_account_number)) {
            TestUtils.printPass("TC1-getAccount_number");
        } else {
            TestUtils.printFail("TC1-getAccount_number");
        }

        if (Objects.equals(testAccount.getUsername_of_account_holder(), test_username)) {
            TestUtils.printPass("TC2-getUsername_holder");
        } else {
            TestUtils.printFail("TC2-getUsername_holder");
        }

        if (Objects.equals(testAccount.getAccount_type(), test_account_type)) {
            TestUtils.printPass("TC3-getAccount_type");
        } else {
            TestUtils.printFail("TC3-getAccount_type");
        }

        if (Objects.equals(testAccount.getAccount_opening_date(), test_date)) {
            TestUtils.printPass("TC4-getAccount_opening_date");
        } else {
            TestUtils.printFail("TC4-getAccount_opening_date");
        }
    }
}