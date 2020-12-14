package bai16;

import java.util.ArrayList;

public class XuLyData {
    public static ArrayList<MatHang> sortTheoGiaBan(ArrayList<MatHang> matHangs){
        for(int i = 0; i < matHangs.size()-1; i++){
            for(int j = i+1; j < matHangs.size(); j++){
                MatHang a = matHangs.get(i);
                MatHang b = matHangs.get(j);
                if(a.getGiaBan() < b.getGiaBan()){
                    matHangs.set(i, b);
                    matHangs.set(j, a);
                }
            }
        }
        return matHangs;
    }
    public static ArrayList<MatHang> sortTheoNhomABC(ArrayList<MatHang> matHangs){
        for(int i = 0; i < matHangs.size()-1; i++){
            for(int j = i+1; j < matHangs.size(); j++){
                MatHang a = matHangs.get(i);
                MatHang b = matHangs.get(j);
                String c = a.getNhom().trim().replaceAll("\\s+", " ").toLowerCase();
                String d = b.getNhom().trim().replaceAll("\\s+", " ").toLowerCase();
                if(c.compareTo(d) < 0){
                    matHangs.set(i, b);
                    matHangs.set(j, a);
                }
            }
        }

        for(int i = 0; i < matHangs.size()-1; i++){
            for(int j = i+1; j < matHangs.size(); j++){
                MatHang a = matHangs.get(i);
                MatHang b = matHangs.get(j);
                String c = a.getNhom().trim().replaceAll("\\s+", " ").toLowerCase();
                String d = b.getNhom().trim().replaceAll("\\s+", " ").toLowerCase();
                if(c.equals(d) &&
                        a.getTen().toLowerCase().compareTo(b.getTen().toLowerCase()) > 0){
                    matHangs.set(i, b);
                    matHangs.set(j, a);
                }
            }
        }
        return matHangs;
    }
}
