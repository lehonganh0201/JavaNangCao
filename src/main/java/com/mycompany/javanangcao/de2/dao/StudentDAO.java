package com.mycompany.javanangcao.de2.dao;

import com.mycompany.javanangcao.de2.db.DatabaseConnector;
import com.mycompany.javanangcao.de2.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void saveStudent(Student student) {
        String sql = "INSERT INTO Student (student_id, full_name, date_of_birth, gender, foreign_languages, gpa) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getStudentId());
            stmt.setString(2, student.getFullName());
            stmt.setString(3, student.getDateOfBirth());
            stmt.setString(4, student.getGender());
            stmt.setString(5, student.getForeignLanguages());
            stmt.setFloat(6, student.getGpa());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getString("student_id"));
                s.setFullName(rs.getString("full_name"));
                s.setDateOfBirth(rs.getString("date_of_birth"));
                s.setGender(rs.getString("gender"));
                s.setForeignLanguages(rs.getString("foreign_languages"));
                s.setGpa(rs.getFloat("gpa"));

                students.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
