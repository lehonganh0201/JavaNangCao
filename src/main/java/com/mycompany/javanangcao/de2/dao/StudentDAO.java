package com.mycompany.javanangcao.de2.dao;

import com.mycompany.javanangcao.de2.file.FileConnector;
import com.mycompany.javanangcao.de2.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String PATH = "./data/student.dat";

    private static List<Student> students = FileConnector.readFromFile(PATH);

    public StudentDAO() {
        if (students == null) {
            students = new ArrayList<>();
        }
    }

    public void saveStudent(Student student) {
        students.add(student);
        saveChange();
    }

    private void saveChange() {
        FileConnector.saveToFile(PATH, students);
    }

    public List<Student> findAll() {
        return students;
    }
}
