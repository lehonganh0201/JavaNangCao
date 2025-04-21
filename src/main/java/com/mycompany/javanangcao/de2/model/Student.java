/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javanangcao.de2.model;

/**
 *
 * @author le296
 */
public class Student {
    private String fullName;
    private String studentId;
    private String dateOfBirth;
    private String gender;
    private String foreignLanguages;
    private float gpa;

    public Student() {}

    public Student(String fullName, String studentId, String dateOfBirth,
                       String gender, String foreignLanguages, float gpa) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.foreignLanguages = foreignLanguages;
        this.gpa = gpa;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getForeignLanguages() {
        return foreignLanguages;
    }

    public void setForeignLanguages(String foreignLanguages) {
        this.foreignLanguages = foreignLanguages;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    
    
}
