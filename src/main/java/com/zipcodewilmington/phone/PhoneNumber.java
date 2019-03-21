package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by leon on 5/10/17.
 */
public final class PhoneNumber {
    private final String phoneNumberString;

    String areaCode;
    String centralOfficeCode;
    String phoneLineCode;

    // default constructor is uncallable
    private PhoneNumber() throws InvalidPhoneNumberFormatException {
        this(null);
    }

    // non-default constructor is package-protected
    protected PhoneNumber(String phoneNumber) throws InvalidPhoneNumberFormatException {
        //validate phone number with format `(###)-###-####`
        String toMatchPattern = "\\((\\d{3}\\))-(\\d{3})-(\\d{4})";
        if (!phoneNumber.matches(toMatchPattern)) {
            throw new InvalidPhoneNumberFormatException();
        }
        Pattern pattern = Pattern.compile(toMatchPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(phoneNumber);
        matcher.find();
        areaCode = matcher.group(1);
        centralOfficeCode = matcher.group(2);
        centralOfficeCode = matcher.group(3);
        this.phoneNumberString = phoneNumber;
    }

    public String getAreaCode() {
        return toString().substring(1, 4);
    }

    public String getCentralOfficeCode() {
        return toString().substring(6, 9);
    }

    public String getPhoneLineCode() {
        return toString().substring(10, 14);
}

    @Override
    public String toString() {
        return phoneNumberString;
    }
}
