/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javanangcao.de1.model;

import java.io.Serializable;

/**
 *
 * @author le296
 */
public class ClientConnectionInfo implements Serializable {
    private String pcName;
    private String ipAddress;
    private int port;
    private String status;
    private String startTime;
    private String endTime;

    public ClientConnectionInfo(String pcName, String ipAddress, int port, String status, String startTime, String endTime) {
        this.pcName = pcName;
        this.ipAddress = ipAddress;
        this.port = port;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ClientConnectionInfo() {
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    
}
