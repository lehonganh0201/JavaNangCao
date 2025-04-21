package com.mycompany.javanangcao.de2.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final Integer PORT = 8080;
    private static ServerSocket server;

    public static void start() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("SERVER IS ALREADY TO USE IN PORT: " + PORT);

            while (true) {
                Socket socket = server.accept();

                System.out.println("NEW CLIENT IS ACCEPT");

                ClientHandler handler = new ClientHandler(socket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
