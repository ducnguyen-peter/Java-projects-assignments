package bai18;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException {
        RaVaoFile raVaoFile = new RaVaoFile();
        ArrayList<MonHoc> monHocs = raVaoFile.readMonHocFormFile("MH.INP");
        System.out.println("-------------Danh sách các môn hoc-------------");
        for(MonHoc r: monHocs){
            r.hien();
        }
        monHocs = XuLyData.sortTheoSoTinChi(monHocs);
        raVaoFile.writeFile(monHocs, "SX.OUT");
        monHocs = XuLyData.sortTheoNhomMonABC(monHocs);
        raVaoFile.writeFile(monHocs, "NHOM.OUT");
    }
}
