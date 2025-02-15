package org.example.regex.basicproblems.validateuser;

public class ValidateUser {
    public static void main(String[] args) {
        String[] usernames = {"user_123", "123user", "us", "ValidUser99", "User_Too_Long_123456"};

        for (String username : usernames) {
            if (isValidUsername(username)) {
                System.out.println("\"" + username + "\" → Valid");
            } else {
                System.out.println("\"" + username + "\" → Invalid");
            }
        }
    }

    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        return username.matches(regex);
    }
}


