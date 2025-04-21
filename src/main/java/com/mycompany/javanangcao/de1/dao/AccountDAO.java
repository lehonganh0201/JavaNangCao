package com.mycompany.javanangcao.de1.dao;

import com.mycompany.javanangcao.de1.file.FileConnector;
import com.mycompany.javanangcao.de1.model.Account;

import java.util.List;

public class AccountDAO {
    private static final String ACCOUNT_LOCATION = "./data/account.dat";

    private static List<Account> accounts = FileConnector.readFromFile(ACCOUNT_LOCATION);

    public AccountDAO() {
    }

    public boolean authenticate(String username, String password) {
        return accounts.stream()
                .anyMatch(a -> a.getUsername().equals(username) && a.getPassword()
                        .equals(password));
    }
}
