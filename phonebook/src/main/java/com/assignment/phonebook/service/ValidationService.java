package com.assignment.phonebook.service;
import com.assignment.phonebook.entity.Phonebook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
    public boolean validatePhone(Phonebook contact) {
        boolean flag = false;
        String regex = "^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contact.getPhoneNumber());

        String regex2 = "^([0-9]{5})$";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(contact.getPhoneNumber());

        String regex3 = "^([0-9]{5}.[0-9]{5})$";
        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(contact.getPhoneNumber());

        String regex4 = "^([0-9]{3}-[0-9]{4})$";
        Pattern pattern4 = Pattern.compile(regex4);
        Matcher matcher4 = pattern4.matcher(contact.getPhoneNumber());

        String regex5 = "^(([0-9]{2}|[0-9]{3}) [0-9]{3} [0-9]{3} [0-9]{4})$";
        Pattern pattern5 = Pattern.compile(regex5);
        Matcher matcher5 = pattern5.matcher(contact.getPhoneNumber());

        String regex6 = "^(([0-9]{2}|[0-9]{3}) [0-9]{1} [0-9]{3} [0-9]{3} [0-9]{4})$";
        Pattern pattern6 = Pattern.compile(regex6);
        Matcher matcher6 = pattern6.matcher(contact.getPhoneNumber());

        String regex7 = "^(\\+[0-9]{2} \\([0-9]{2}\\) [0-9]{3}-[0-9]{4})$";
        Pattern pattern7 = Pattern.compile(regex7);
        Matcher matcher7 = pattern7.matcher(contact.getPhoneNumber());

        String regex8 = "^(\\+01 \\([0-9]{3}\\) [0-9]{3}-[0-9]{4})$";
        Pattern pattern8 = Pattern.compile(regex8);
        Matcher matcher8 = pattern8.matcher(contact.getPhoneNumber());

        String regex9 = "^(\\(001\\) [0-9]{3}-[0-9]{4})$";
        Pattern pattern9 = Pattern.compile(regex9);
        Matcher matcher9 = pattern9.matcher(contact.getPhoneNumber());

        String regex10 = "^([0-9]{10})$";
        Pattern pattern10 = Pattern.compile(regex10);
        Matcher matcher10 = pattern10.matcher(contact.getPhoneNumber());

        String regex11 = "^((\\+45 [0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2}|[0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2}|[0-9]{4}.[0-9]{4}|\\+45 [0-9]{4}.[0-9]{4}))$";
        Pattern pattern11 = Pattern.compile(regex11);
        Matcher matcher11 = pattern11.matcher(contact.getPhoneNumber());

        if(matcher.matches())
            flag = true;
        if(matcher2.matches())
            flag = true;
        if(matcher3.matches())
            flag = true;
        if(matcher4.matches())
            flag = true;
        if(matcher5.matches())
            flag = true;
        if(matcher6.matches())
            flag = true;
        if(matcher7.matches())
            flag = true;
        if(matcher11.matches())
            flag = true;
        if(matcher8.matches())
            flag = false;
        if(matcher9.matches())
            flag = false;
        if(matcher10.matches())
            flag = false;

        return flag;
    }

    public boolean validateName(Phonebook contact) {
        boolean flag = false;
        String regex = "^(([A-Z]('|’)[A-Z][a-z]{1,10}|[A-Z][a-z]{1,10})((,\\s|\\s)([A-Z]('|’)[A-Z][a-z]{1,10}|[A-Z][a-z]{1,10}))?(\\s[A-Z][a-z]{1,10}|\\s[A-Z].|-[A-Z][a-z]{1,10})?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contact.getName());
        if(matcher.matches())
            flag = true;

        return flag;
    }
}
