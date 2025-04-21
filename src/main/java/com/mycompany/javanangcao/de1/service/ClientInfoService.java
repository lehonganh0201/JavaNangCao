/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javanangcao.de1.service;

import com.mycompany.javanangcao.de1.model.ClientConnectionInfo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author le296
 */
public class ClientInfoService {
    private static List<ClientConnectionInfo> clients = new ArrayList<>();
    
    private static final String CONNECTED = "Connected";
    private static final String DE_CONNECTED = "Deconnected";
    private static final String RUNNING = "running";
    
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

            return info;
        }
        else {
            System.out.println("Client already exist: " + ipAddress);
        }

        return null;
    }

    public List<ClientConnectionInfo> getAll() {
        return clients;
    }

    public void updateStatusAndEndTime(String pcName, String ipAddress, Integer port) {
        for (var item : clients) {
            if (item.getIpAddress().equals(ipAddress) && item.getPort() == port && item.getPcName().equals(pcName)) {
                item.setStatus(DE_CONNECTED);
                item.setEndTime(LocalDateTime.now().toString());
                break;
            }
        }
    }
    
}
