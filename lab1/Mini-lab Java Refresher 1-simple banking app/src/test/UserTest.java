package test;

import model.User;
import java.util.Objects;

public class UserTest {

    public static void main(String[] args) {
        testUserConstructor();
    }

    public static void testUserConstructor() {
        // Setup
        String test_username = "mike@test.com";
        String test_password = "my_passwd";
        String test_first_name = "Mike";
        String test_last_name = "Smith";
        String test_mobile_number = "07771234567";

        User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);

        System.out.println("Starting the assertions of the test method: testUserConstructor");

        assert testUser.getUsername().equals(test_username) : "TC1-getUsername-FAILED";
        assert testUser.getPassword().equals(test_password) : "TC2-getPassword-FAILED";
        assert testUser.getFirst_name().equals(test_first_name) : "TC3-getFirst_name-FAILED";
        assert testUser.getLast_name().equals(test_last_name) : "TC4-getLast_name-FAILED";
        assert testUser.getMobile_number().equals(test_mobile_number) : "TC5-getMobile_number-FAILED";

        assert testUser.toString().contains("First");

        System.out.println("All assertions passed successfully!");
    }
}