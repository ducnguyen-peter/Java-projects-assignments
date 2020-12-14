/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thanh;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Windows 10
 */
public class Student implements Serializable{
    private static int currentId = 1000;
    private String ten, lop;
    private double dtb;
    private int id;

    public  Student(String ten, String lop, double dtb) {
        this.ten = ten;
        this.lop = lop;
        this.dtb = dtb;
        this.id = ++currentId;
    }

    public static void setCurrentId(int currentId) {
        Student.currentId = currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public String getTen() {
        return ten;
    }

    public String getLop() {
        return lop;
    }

    public double getDtb() {
        return dtb;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + '\n' + ten + '\n' + lop + '\n' + dtb;
    }
    public Object[] toObjects(){
        return new Object[]{id,ten,lop,dtb};
    }


    
}
