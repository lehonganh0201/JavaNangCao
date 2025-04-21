package com.mycompany.javanangcao.de2.service;

import com.mycompany.javanangcao.de2.dao.StudentDAO;
import com.mycompany.javanangcao.de2.model.Student;

import java.util.List;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    public List<Student> findAll(){
        return studentDAO.findAll();
    }
}
