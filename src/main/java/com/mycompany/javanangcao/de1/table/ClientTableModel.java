/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javanangcao.de1.table;

import com.mycompany.javanangcao.de1.model.ClientConnectionInfo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author le296
 */
public class ClientTableModel extends AbstractTableModel{
    private List<ClientConnectionInfo> clients;
    private final String[] names = {"PC Name", "IP", "Port", "Status", "Start Time", "End Time"};
    private final Class[] classes = {String.class, String.class, Integer.class, String.class, String.class, String.class};

    public ClientTableModel(List<ClientConnectionInfo> clients) {
        this.clients = clients;
    }

    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClientConnectionInfo info = clients.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return info.getPcName();
            case 1:
                return info.getIpAddress();
            case 2:
                return info.getPort();
            case 3:
                return info.getStatus();
            case 4:
                return info.getStartTime();
            case 5:
                return info.getEndTime();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return names[column];
    }
    
    
}
