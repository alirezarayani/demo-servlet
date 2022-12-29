package ir.lazydeveloper.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToolsValidator {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isEmailValidate(String email) {
        boolean isEmailValid = false;
        if (email != null && !email.isEmpty()) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
            isEmailValid = matcher.find();
        }
        return isEmailValid;
    }


    public static int calcPasswordComplexity(String password) {
        int complexity = 0;
        if (password != null && password.length() >= 6) {
            complexity += password.matches(".*[0-9].*") ? 1 : 0;
            complexity += password.matches(".*[A-Z].*") ? 1 : 0;
            complexity += password.matches(".*[a-z].*") ? 1 : 0;
            complexity += password.matches(".*[?!@$%^&*()\\[\\]_=+~/*-.,{}|\\/\'\";:].*") ? 1 : 0;
        }
        return complexity;
    }
}
