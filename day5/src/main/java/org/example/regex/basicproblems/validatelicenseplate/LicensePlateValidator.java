package org.example.regex.basicproblems.validatelicenseplate;

import java.util.regex.*;

public class LicensePlateValidator {
    public static void main(String[] args) {
        String[] plates = {"AB1234", "A12345", "XY9876", "ZZ12", "CD0000"};

        for (String plate : plates) {
            if (isValidLicensePlate(plate)) {
                System.out.println("\"" + plate + "\" → Valid");
            } else {
                System.out.println("\"" + plate + "\" → Invalid");
            }
        }
    }

    public static boolean isValidLicensePlate(String plate) {
        String regex = "^[A-Z]{2}\\d{4}$";
        return plate.matches(regex);
    }
}
