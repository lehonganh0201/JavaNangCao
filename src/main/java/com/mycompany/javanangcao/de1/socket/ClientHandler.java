/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javanangcao.de1.socket;

import com.mycompany.javanangcao.de1.service.AccountService;
import com.mycompany.javanangcao.de1.service.ClientService;
import com.mycompany.javanangcao.de1.view.ServerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author le296
 */
class ClientHandler implements Runnable {

    private Socket client;
    private AccountService accountService = new AccountService();
    private ClientService clientInfoService = new ClientService();

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true)
        ) {
            out.println("Chào mừng bạn đến với server!");

            String command;
            while ((command = in.readLine()) != null) {
                System.out.println("STATEMENT: " + command);
                switch (command) {
                    case "LOGIN": {
                        String input = in.readLine();
                        if (input != null && input.contains(";")) {
                            String[] parts = input.split(";");
                            String username = parts[0];
                            String password = parts[1];

                            boolean result = accountService.authenticate(username, password);

                            if (result) {
                                System.out.println("Người dùng " + username + " đăng nhập thành công");
                                out.println("true");

                                InetAddress address = client.getInetAddress();
                                Integer port = client.getPort();

                                clientInfoService.saveInfo(address.getHostName(), address.getHostAddress(), port);

                                ServerView.getInstance().change();
                            } else {
                                System.out.println("Người dùng " + username + " đăng nhập thất bại");
                                out.println("false");
                            }
                        }
                        break;
                    }

                    case "LOGOUT": {
                        InetAddress address = client.getInetAddress();
                        Integer port = client.getPort();
                        clientInfoService.updateStatusAndEndTime(address.getHostName(), address.getHostAddress(), port);

                        System.out.println("Client đã logout: " + address.getHostAddress() + ":" + port);
                        ServerView.getInstance().change();
                        break;
                    }

                    default: {
                        System.out.println("Yêu cầu không hợp lệ: " + command);
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
