package com.mycompany.javanangcao.de1.service;

import com.mycompany.javanangcao.de1.dao.ClientDAO;
import com.mycompany.javanangcao.de1.model.ClientConnectionInfo;

import java.util.List;

public class ClientService {
    private ClientDAO clientDAO;

    public ClientService() {
        this.clientDAO = new ClientDAO();
    }

    public ClientConnectionInfo saveInfo(String pcName, String ipAddress, Integer port) {
        return clientDAO.saveInfo(pcName, ipAddress, port);
    }

    public List<ClientConnectionInfo> getAll() {
        return clientDAO.getAll();
    }

    public void updateStatusAndEndTime(String pcName, String ipAddress, Integer port) {
        clientDAO.updateStatusAndEndTime(pcName, ipAddress, port);
    }
}
