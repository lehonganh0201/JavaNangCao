package com.mycompany.javanangcao.de2;


import com.mycompany.javanangcao.de2.db.DatabaseConnector;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConnector.getConnection();

            DatabaseConnector.runSQLScript("src/main/java/com/mycompany/javanangcao/de2/file/scripts.sql");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
