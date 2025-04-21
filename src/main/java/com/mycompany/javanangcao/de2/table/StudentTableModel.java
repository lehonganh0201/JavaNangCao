/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javanangcao.de2.table;

import com.mycompany.javanangcao.de2.model.Student;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author le296
 */
public class StudentTableModel extends AbstractTableModel{
    private List<Student> students;
    private String[] names = {"STT", "Ho va Ten", "Ma sinh vien", "Ngay sinh", "Gioi tinh", "Ngon ngu", "Diem trung binh"};
    private Class[] classes = {Integer.class, String.class, String.class, String.class, String.class, String.class, Float.class};

    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return names[column];
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return student.getFullName();
            case 2:
                return student.getStudentId();
            case 3:
                return student.getDateOfBirth();
            case 4:
                return student.getGender();
            case 5:
                return student.getForeignLanguages();
            case 6:
                return student.getGpa();
            default:
                return null;
        }
    }
    
}
