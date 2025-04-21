package com.mycompany.javanangcao.de1.file;

import java.io.*;
import java.util.List;

public class FileConnector {


    public static <T> void saveToFile(String path, List<T> objects) {
        File directory = new File(path).getParentFile();
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            if (objects != null) {
                outputStream.writeObject(objects);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> readFromFile(String path) {
        File directory = new File(path).getParentFile();
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (List<T>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
