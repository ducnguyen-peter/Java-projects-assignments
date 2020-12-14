package bai16;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException {
        RaVaoFile raVaoFile = new RaVaoFile();
        ArrayList<MatHang> matHangs = raVaoFile.readMatHangFormFile("MH.INP");
        System.out.println("---------------Danh sách các mặt hàng---------------");
        for (MatHang r: matHangs){
            r.hien();
        }
        ArrayList<MatHang> kq1 = XuLyData.sortTheoGiaBan(matHangs);
        raVaoFile.writeFile(kq1, "SX.OUT");
        ArrayList<MatHang> kq2 = XuLyData.sortTheoNhomABC(matHangs);
        raVaoFile.writeFile(kq2, "NHOM.OUT");
    }
}
