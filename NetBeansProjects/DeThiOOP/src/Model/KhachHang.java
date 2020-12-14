package Model;

import java.io.Serializable;

public class KhachHang implements Serializable{
    private int maKhachHang;
    private String hoTen;
    private String diaChi;
    private String soDT;
    private static int maHienTai = -1;

    public KhachHang() {
        this.maKhachHang = ++maHienTai;
    }

    public KhachHang(String hoTen, String diaChi, String soDT) {
        this.maKhachHang = ++maHienTai;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public static int getMaHienTai() {
        return maHienTai;
    }

    public static void setMaHienTai(int maHienTai) {
        KhachHang.maHienTai = maHienTai;
    }
    
    public Object[] toObject()
    {
        return new Object[]{maKhachHang, hoTen, diaChi, soDT};
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj instanceof KhachHang)
        {
            KhachHang k = (KhachHang)obj;
            if(this.hoTen.toUpperCase().equals(k.hoTen.toUpperCase()) 
                    && this.diaChi.toUpperCase().equals(k.diaChi.toUpperCase()) && this.soDT.equals(k.soDT))
                return true;
        }
        return false;
    }
}
