/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javanangcao.de1.service;

import com.mycompany.javanangcao.de1.model.Account;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author le296
 */
public class AccountService {
    private static List<Account> accounts = new ArrayList<>(
            Arrays.asList(
                    new Account("sv001", "Pass@123"),
                    new Account("sv002", "123Abc@"),
                    new Account("admin", "Admin@2025")
            )
    );

    public AccountService() {
    }

    public boolean authenticate(String username, String password) {
        return accounts.stream()
                .anyMatch(a -> a.getUsername().equals(username) && a.getPassword()
                        .equals(password));
    }
}
