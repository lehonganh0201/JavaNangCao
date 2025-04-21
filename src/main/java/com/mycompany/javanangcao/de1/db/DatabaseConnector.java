package com.mycompany.javanangcao.de1.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/javanangcao?createDatabaseIfNotExist=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }

    public static void runSQLScript(String filePath) {
        try (Connection conn = getConnection();
             Statement statement = conn.createStatement();
             BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");

                if (line.trim().endsWith(";")) {
                    statement.execute(sql.toString());
                    sql.setLength(0);
                }
            }
            System.out.println("Run Script Success!");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
