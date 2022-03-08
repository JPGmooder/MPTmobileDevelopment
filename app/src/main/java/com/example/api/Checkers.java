package com.example.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checkers {
    public boolean checkLogin(String log){
        if(!log.matches("^[a-zA-Z0-9_]+$") || log.length() < 3)
        {
            return false;
        }
        else
            return true;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public boolean checkPassword(String log){
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}";
        if(!log.matches(pattern))
        {
            return false;
        }
        else
            return true;
    }
}
