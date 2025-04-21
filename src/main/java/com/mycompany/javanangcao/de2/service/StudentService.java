package com.mycompany.javanangcao.de2.service;

import com.mycompany.javanangcao.de2.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static List<Student> students = new ArrayList<>();

    public void saveStudent(Student student) {
        students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }
}
