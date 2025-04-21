/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javanangcao.de1.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author le296
 */

public class Client {
    private static final String IP_ADDRESS = "localhost";
    private static final Integer PORT = 8080;

    private static BufferedReader in;
    private static PrintWriter out;
    private static Socket socket;

    public Client() {
        try {
            connect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void connect() throws Exception {
        socket = new Socket(IP_ADDRESS, PORT);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public boolean authentication(String username, String password) {
        while (true) {
            try {
                connect();
                System.out.println(in.readLine());

                out.println("LOGIN");
                String message = username + ";" + password;
                out.println(message);

                String response = in.readLine();
                System.out.println("Client response: " + response);
                return Boolean.parseBoolean(response);

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public void updateLogout() {
        out.println("LOGOUT");
    }
}
