package com.mycompany.javanangcao.de1.dao;

import com.mycompany.javanangcao.de1.db.DatabaseConnector;
import com.mycompany.javanangcao.de1.model.ClientConnectionInfo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private static final String CONNECTED = "Connected";
    private static final String DE_CONNECTED = "Deconnected";
    private static final String RUNNING = "running";

    private static List<ClientConnectionInfo> clients = new ArrayList<>();

    public ClientConnectionInfo saveInfo(String pcName, String ipAddress, Integer port) {
        String checkExistSql = "SELECT * FROM ClientConnectionInfo WHERE pc_name = ? AND ip_address = ? AND port = ? AND status = ?";
        String sql = "INSERT INTO ClientConnectionInfo (pc_name, ip_address, port, status, start_time, end_time) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(checkExistSql)) {
            statement.setString(1, pcName);
            statement.setString(2, ipAddress);
            statement.setInt(3, port);
            statement.setString(4, CONNECTED);

            ResultSet rs = statement.executeQuery();

            if (!rs.next()) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, pcName);
                    preparedStatement.setString(2, ipAddress);
                    preparedStatement.setInt(3, port);
                    preparedStatement.setString(4, CONNECTED);
                    preparedStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
                    preparedStatement.setString(6, RUNNING);

                    preparedStatement.executeUpdate();

                    ClientConnectionInfo info = new ClientConnectionInfo();
                    info.setPcName(pcName);
                    info.setIpAddress(ipAddress);
                    info.setPort(port);
                    info.setStatus(CONNECTED);
                    info.setStartTime(LocalDateTime.now().toString());
                    info.setEndTime(RUNNING);

                    System.out.println("New client saved: " + ipAddress);
                    return info;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public List<ClientConnectionInfo> getAll() {
        clients.clear();
        String sql = "SELECT * FROM ClientConnectionInfo";
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                ClientConnectionInfo info = new ClientConnectionInfo(
                        rs.getString("pc_name"),
                        rs.getString("ip_address"),
                        rs.getInt("port"),
                        rs.getString("status"),
                        rs.getString("start_time"),
                        rs.getString("end_time")
                );
                clients.add(info);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return clients;
    }

    public void updateStatusAndEndTime(String pcName, String ipAddress, Integer port) {
        String sql = "UPDATE ClientConnectionInfo SET status = ?, end_time = ? WHERE pc_name = ? AND ip_address = ? AND port = ?";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, DE_CONNECTED);
            statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            statement.setString(3, pcName);
            statement.setString(4, ipAddress);
            statement.setInt(5, port);

            int row = statement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}