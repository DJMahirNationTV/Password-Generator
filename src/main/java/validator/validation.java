package validator;

import org.junit.jupiter.api.Test;

public class validation {
    public static boolean hasMinLength(String password, int min) {
        return password != null && password.length() >= min;
    }

    public static boolean containsDigit(String password) {
        if (password == null) return false;
        return password.matches(".*[0-9].*");
    }

    public static boolean containsUpperAndLower(String password) {
        if (password == null) return false;
        return password.matches(".*[a-z].*") && password.matches(".*[A-Z].*");
    }

    public static boolean isCommonPassword(String password) {
        String[] commonWords = {"qwertz", "qwerty", "123", "xyz", "password", "admin", "admin123"};
        for (String commonWord : commonWords) {
            if (password.equalsIgnoreCase(commonWord)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsSpecialChar(String password, String allowed) {
        if (password == null || allowed == null) return false;
        for (char c : allowed.toCharArray()) {
            if (password.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValid(String password) {
        String specialChars = "!@#$%^&*()-_=+[]{};:',.<>/?";
        return hasMinLength(password, 8)
                && containsDigit(password)
                && containsUpperAndLower(password)
                && !isCommonPassword(password)
                && containsSpecialChar(password, specialChars);
    }
}
