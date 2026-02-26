package test;

import model.User;
import java.util.Objects;

public class UserTest {

    public static void main(String[] args) {
        testUserConstructor();
    }

    public static void testUserConstructor() {
        String test_username = "mike@test.com";
        String test_password = "my_passwd";
        String test_first_name = "Mike";
        String test_last_name = "Smith";
        String test_mobile_number = "07771234567";

        User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);

        System.out.println("Starting the assertions of the test method: testUserConstructor");

        if (Objects.equals(testUser.getUsername(), test_username)) {
            TestUtils.printPass("TC1-getUsername");
        } else {
            TestUtils.printFail("TC1-getUsername");
        }

        if (Objects.equals(testUser.getPassword(), test_password)) {
            TestUtils.printPass("TC2-getPassword");
        } else {
            TestUtils.printFail("TC2-getPassword");
        }

        if (Objects.equals(testUser.getFirst_name(), test_first_name)) {
            TestUtils.printPass("TC3-getFirst_name");
        } else {
            TestUtils.printFail("TC3-getFirst_name");
        }

        if (Objects.equals(testUser.getLast_name(), test_last_name)) {
            TestUtils.printPass("TC4-getLast_name");
        } else {
            TestUtils.printFail("TC4-getLast_name");
        }

        if (Objects.equals(testUser.getMobile_number(), test_mobile_number)) {
            TestUtils.printPass("TC5-getMobile_number");
        } else {
            TestUtils.printFail("TC5-getMobile_number");
        }
    }
}