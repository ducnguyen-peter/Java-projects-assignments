package bai17;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws Exception{
        RaVaoFile raVaoFile = new RaVaoFile();
        try {
            ArrayList<Sach> sachs = raVaoFile.readSachFormFile("SACH.P");
            System.out.println("---------------Danh sách các sách---------------");
            for(Sach r: sachs){
                r.hien();
            }
            sachs = XuLyData.sortTheoGiaBan(sachs);
            raVaoFile.writeFile(sachs, "SX.OUT");
            sachs = XuLyData.sortTheoCNABC(sachs);
            raVaoFile.writeFile(sachs, "CN.OUT");
        }catch (Exception e){
            System.out.println("không có file!");
        }
    }
}
