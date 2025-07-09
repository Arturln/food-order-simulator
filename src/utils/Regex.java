package src.utils;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public String nameValidation(String name) throws InvalidNameException {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new InvalidNameException("Invalid name");
        }
    }

    public Long phoneNumberValidation(long phoneNumber) throws InvalidNumberException {
        Pattern pattern = Pattern.compile("^375(33|44|29)[0-9]{7}$");
        Matcher matcher = pattern.matcher(String.valueOf(phoneNumber));
        if (matcher.find()) {
            return Long.parseLong(matcher.group());
        } else {
            throw new InvalidNumberException("Invalid number");
        }
    }
}
