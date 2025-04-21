package com.mycompany.javanangcao.de1.dao;

import com.mycompany.javanangcao.de1.file.FileConnector;
import com.mycompany.javanangcao.de1.model.ClientConnectionInfo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private static final String CLIENT_LOCATION = "./data/client.dat";
    private static final String CONNECTED = "Connected";
    private static final String DE_CONNECTED = "Deconnected";
    private static final String RUNNING = "running";

    private static List<ClientConnectionInfo> clients =  FileConnector.readFromFile(CLIENT_LOCATION);

    public ClientDAO() {
        if (clients == null) {
            clients = new ArrayList<>();
        }
    }


    public ClientConnectionInfo saveInfo(String pcName, String ipAddress, Integer port) {
        System.out.println("Lưu phiên đăng nhập");
        boolean exists = clients.stream()
                .anyMatch(c ->
                {
                    boolean result = c.getPcName().equals(pcName) &&
                            c.getIpAddress().equals(ipAddress) &&
                            c.getPort() == port &&
                            c.getStatus().equals(CONNECTED) ;
                    return result;
                });

        if (!exists) {
            ClientConnectionInfo info = new ClientConnectionInfo();
            info.setPcName(pcName);
            info.setIpAddress(ipAddress);
            info.setPort(port);
            info.setStatus(CONNECTED);
            info.setStartTime(LocalDateTime.now().toString());
            info.setEndTime(RUNNING);

            clients.add(info);
            System.out.println("New client saved: " + ipAddress);
            saveChange();
            return info;
        }
        else {
            System.out.println("Client already exist: " + ipAddress);
        }

        return null;
    }

    private void saveChange() {
        FileConnector.saveToFile(CLIENT_LOCATION, clients);
//        clients = FileConnector.readFromFile(CLIENT_LOCATION);
    }

    public List<ClientConnectionInfo> getAll() {
        System.out.println("Số lượng client: " + clients.size());
        return clients;
    }

    public void updateStatusAndEndTime(String pcName, String ipAddress, Integer port) {
        for (var item : clients) {
            if (item.getIpAddress().equals(ipAddress) && item.getPort() == port && item.getPcName().equals(pcName)) {
                item.setStatus(DE_CONNECTED);
                item.setEndTime(LocalDateTime.now().toString());
                saveChange();
                break;
            }
        }
    }
}
