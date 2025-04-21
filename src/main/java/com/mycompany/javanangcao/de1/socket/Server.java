/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javanangcao.de1.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author le296
 */
public class Server {
    private static final Integer PORT = 8080;
    private static ServerSocket server;
    
    
    public static void start() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT + "...");
            
            while(true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());
                
                ClientHandler handler = new ClientHandler(clientSocket);
                new Thread(handler).start();
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
