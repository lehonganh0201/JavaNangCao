package com.mycompany.javanangcao.de2.socket;

import com.mycompany.javanangcao.de2.model.Student;
import com.mycompany.javanangcao.de2.service.StudentService;
import com.mycompany.javanangcao.de2.view.ServerView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    private StudentService service = new StudentService();

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String command;
            while ((command = in.readLine()) != null) {
                switch (command) {
                    case "ADD": {
                        String input = in.readLine();
                        String[] data = input.split(";");

                        Student student = new Student();
                        student.setFullName(data[0]);
                        student.setStudentId(data[1]);
                        student.setDateOfBirth(data[2]);
                        student.setGender(data[3]);
                        student.setForeignLanguages(data[4]);
                        student.setGpa(Float.parseFloat(data[5]));


                        out.println("ADD USER");
                        service.saveStudent(student);
                        ServerView.getInstance().change();

                        System.out.println(service.findAll().size());
                        break;
                    }
                    case "CLOSE": {
                        if (in != null) {
                            in.close();
                        }
                        if (out != null) {
                            out.close();
                        }
                        if (socket != null) {
                            socket.close();
                        }

                        out.println("CLOSE SOCKET");
                        break;
                    }
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (socket != null) {
                    socket.close();
                }
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
