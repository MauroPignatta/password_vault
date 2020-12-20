package com.Sabuin.validator;

import com.Sabuin.entity.Account;
import com.Sabuin.factory.AccountFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountValidatorTest {

    @Test
    public void validateAccount_true_validAccount(){
        Account account = new AccountFactory().createAccount("MauroPignatta123", "Aa123456");

        assertTrue(new AccountValidator().validateAccount(account));
    }

    @Test
    public void validateAccount_false_invalidUsername_tooShort(){
        Account account = new AccountFactory().createAccount("Maurn", "Aa123456");

        assertFalse(new AccountValidator().validateAccount(account));
    }

    @Test
    public void validateAccount_false_invalidPassword_tooShort(){
        Account account = new AccountFactory().createAccount("MauroPignatta123", "Aa12");

        assertFalse(new AccountValidator().validateAccount(account));
    }

    @Test
    public void validateAccount_false_invalidPassword_doesNotIncludeNumber(){
        Account account = new AccountFactory().createAccount("MauroPignatta123", "AAasdjh!d");

        assertFalse(new AccountValidator().validateAccount(account));
    }

    @Test
    public void validateAccount_false_invalidPassword_doesNotIncludeLowerCaseLetter(){
        Account account = new AccountFactory().createAccount("MauroPignatta123", "AAABANSD22");

        assertFalse(new AccountValidator().validateAccount(account));
    }

    @Test
    public void validateAccount_false_invalidPassword_doesNotIncludeUpperCaseLetter(){
        Account account = new AccountFactory().createAccount("MauroPignatta123", "asdjhiv22");

        assertFalse(new AccountValidator().validateAccount(account));
    }

}