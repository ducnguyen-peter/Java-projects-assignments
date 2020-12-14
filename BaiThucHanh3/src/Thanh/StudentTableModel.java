/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thanh;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows 10
 */
public class StudentTableModel extends AbstractTableModel {

    private final String[] colNames = {"ID", "Name", "Major", "GPA"};
    private ArrayList<Student> studentList;

    @Override
    public int getRowCount() {
        return studentList.size();
    }

    public StudentTableModel(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }
    @Override
    public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
    }

//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        if (studentList.isEmpty()) {
//            return Object.class;
//        }
//        return getValueAt(0, columnIndex).getClass();
//    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = studentList.get(rowIndex);
        Object returnVal = null;
        switch (columnIndex) {
            case 0:
                returnVal = student.getId();
                break;
            case 1:
                returnVal = student.getTen();
                break;
            case 2:
                returnVal = student.getLop();
                break;
            case 3:
                returnVal = student.getDtb();
                break;
            default:
                throw new IllegalArgumentException("Invalid col index");
        }
        return returnVal;
    }

}
