package org.example.regex.basicproblems.validatehexcolor;

import java.util.regex.*;

public class HexColorValidator {
    public static void main(String[] args) {
        String[] colors = {"#FFA500", "#ff4500", "#123", "#1a2b3c", "#XYZ123"};

        for (String color : colors) {
            if (isValidHexColor(color)) {
                System.out.println("\"" + color + "\" → Valid");
            } else {
                System.out.println("\"" + color + "\" → Invalid");
            }
        }
    }

    public static boolean isValidHexColor(String color) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        return color.matches(regex);
    }
}
