package com.mycompany.javanangcao.de1.service;

import com.mycompany.javanangcao.de1.dao.AccountDAO;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAO();
    }

    public boolean authenticate(String username, String password) {
        return accountDAO.authenticate(username, password);
    }
}
