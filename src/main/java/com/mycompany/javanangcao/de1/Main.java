package com.mycompany.javanangcao.de1;

import com.mycompany.javanangcao.de1.file.FileConnector;
import com.mycompany.javanangcao.de1.model.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String ACCOUNT_LOCATION = "./data/account.dat";

    public static void main(String[] args) {
        List<Account> list = new ArrayList<>(
                Arrays.asList(
                        new Account("sv001", "Pass@123"),
                        new Account("sv002", "123Abc@"),
                        new Account("admin", "Admin@2025")
                )
        );
        FileConnector.saveToFile(ACCOUNT_LOCATION, list);
    }
}
