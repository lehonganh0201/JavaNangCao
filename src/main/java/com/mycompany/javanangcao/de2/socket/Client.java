package com.mycompany.javanangcao.de2.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String IP_ADDRESS = "localhost";
    private static final Integer PORT = 8080;

    private static BufferedReader in;
    private static PrintWriter out;
    private static Socket socket;

    public Client() {
    }

    public void connect() throws Exception {
        socket = new Socket(IP_ADDRESS, PORT);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void addStudent(String message) {
        try {
            out.println("ADD");
            out.println(message);

            System.out.println("SERVER RESPONSE: " + in.readLine());
        } catch (Exception ex) {
            System.out.println("Vui long ket noi server truoc khi gui du lieu");
        }
    }

    public void closeSocket() {
        out.println("CLOSE");
        try {
            System.out.println("SERVER RESPONSE: " + in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
