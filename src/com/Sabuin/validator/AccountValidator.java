package com.Sabuin.validator;

import com.Sabuin.entity.Account;

import java.util.regex.Pattern;

public class AccountValidator {

    public boolean validateAccount(Account account){
        if(account == null){
            return false;
        }

        return validateUsername(account.getUsername()) && validatePassword(account.getPassword());
    }

    public boolean validateUsername(String username){
        return Pattern.matches("([a-zA-Z0-9]{8,})", username);
    }

    public boolean validatePassword(String password){
        return Pattern.matches("([!?@#$%^&*]*)((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])).{8,}", password);
    }
}
