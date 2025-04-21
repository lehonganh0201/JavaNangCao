package com.mycompany.javanangcao.de1.dao;

import com.mycompany.javanangcao.de1.db.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
    public AccountDAO() {
    }

    public boolean authenticate(String username, String password) {
        String sql = "SELECT * FROM Accounts WHERE username = ? AND password = ?";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return true;
            }

            return false;
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
