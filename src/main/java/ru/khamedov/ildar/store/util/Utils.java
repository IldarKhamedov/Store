package ru.khamedov.ildar.store.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class Utils {

    public boolean isValidPhoneNumber(CharSequence numberToParse) throws NumberParseException {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(numberToParse,
                Phonenumber.PhoneNumber.CountryCodeSource.UNSPECIFIED.name());
        return phoneNumberUtil.isValidNumber(phoneNumber);
    }

}
