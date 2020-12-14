package bai17;

import bai16.MatHang;

import java.util.ArrayList;

public class XuLyData {
    public static ArrayList<Sach> sortTheoGiaBan(ArrayList<Sach> sachs){
        for(int i = 0; i < sachs.size()-1; i++){
            for(int j = i+1; j < sachs.size(); j++){
                Sach a = sachs.get(i);
                Sach b = sachs.get(j);
                if(a.getGiaBan() < b.getGiaBan()){
                    sachs.set(i, b);
                    sachs.set(j, a);
                }
            }
        }
        return sachs;
    }
    public static ArrayList<Sach> sortTheoCNABC(ArrayList<Sach> sachs){
        for(int i = 0; i < sachs.size()-1; i++){
            for(int j = i+1; j < sachs.size(); j++){
                Sach a = sachs.get(i);
                Sach b = sachs.get(j);
                String c = a.getChuyenNganh().trim().replaceAll("\\s+", " ").toLowerCase();
                String d = b.getChuyenNganh().trim().replaceAll("\\s+", " ").toLowerCase();
                if(c.compareTo(d) < 0){
                    sachs.set(i, b);
                    sachs.set(j, a);
                }
            }
        }

        for(int i = 0; i < sachs.size()-1; i++){
            for(int j = i+1; j < sachs.size(); j++){
                Sach a = sachs.get(i);
                Sach b = sachs.get(j);
                String c = a.getChuyenNganh().trim().replaceAll("\\s+", " ").toLowerCase();
                String d = b.getChuyenNganh().trim().replaceAll("\\s+", " ").toLowerCase();
                if(c.equals(d) &&
                        a.getTenSach().toLowerCase().compareTo(b.getTenSach().toLowerCase()) > 0){
                    sachs.set(i, b);
                    sachs.set(j, a);
                }
            }
        }
        return sachs;
    }
}

