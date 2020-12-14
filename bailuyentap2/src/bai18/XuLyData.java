package bai18;

import java.util.ArrayList;

public class XuLyData {
    public static ArrayList<MonHoc> sortTheoSoTinChi(ArrayList<MonHoc> monHocs){
        for(int i = 0; i < monHocs.size()-1; i++){
            for(int j = i+1; j < monHocs.size(); j++){
                MonHoc a = monHocs.get(i);
                MonHoc b = monHocs.get(j);
                if(a.getSoTinchi() < b.getSoTinchi()){
                    monHocs.set(i, b);
                    monHocs.set(j, a);
                }
            }
        }
        return monHocs;
    }
    public static ArrayList<MonHoc> sortTheoNhomMonABC(ArrayList<MonHoc> monHocs){
        for(int i = 0; i < monHocs.size()-1; i++){
            for(int j = i+1; j < monHocs.size(); j++){
                MonHoc a = monHocs.get(i);
                MonHoc b = monHocs.get(j);
                String c = a.getNhomMon().trim().replaceAll("\\s+", " ").toLowerCase();
                String d = b.getNhomMon().trim().replaceAll("\\s+", " ").toLowerCase();
                if(c.compareTo(d) > 0){
                    monHocs.set(i, b);
                    monHocs.set(j, a);
                }
            }
        }

        for(int i = 0; i < monHocs.size()-1; i++){
            for(int j = i+1; j < monHocs.size(); j++){
                MonHoc a = monHocs.get(i);
                MonHoc b = monHocs.get(j);
                String c = a.getNhomMon().trim().replaceAll("\\s+", " ").toLowerCase();
                String d = b.getNhomMon().trim().replaceAll("\\s+", " ").toLowerCase();
                if(c.equals(d) &&
                        a.getTenMon().toLowerCase().compareTo(b.getTenMon().toLowerCase()) > 0){
                    monHocs.set(i, b);
                    monHocs.set(j, a);
                }
            }
        }
        return monHocs;
    }
}

