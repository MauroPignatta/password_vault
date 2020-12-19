package com.Sabuin.factory;

import com.Sabuin.entity.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountFactoryTest {

    @Test
    public void createAccount_validUserAndPasswordAccount(){
        AccountFactory factory = new AccountFactory();
        String username = "Pedro";
        String password = "AJsdashfad";

        Account account = factory.createAccount(username, password);

        assertEquals(username, account.getUsername());
        assertEquals(password, account.getPassword());
    }

    @Test
    public void createAccount_validStringAccount(){
        AccountFactory factory = new AccountFactory();
        String accountString = "Pedro;AJsdashfad";

        Account account = factory.createAccount(accountString);

        assertEquals(accountString, account.toString());
    }

}