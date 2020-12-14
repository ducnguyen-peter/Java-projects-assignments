package Model;

import java.io.Serializable;

public class MatHang implements Serializable{
    private int maHang;
    private String tenHang;
    private String nhomHang;
    private int giaBan;
    private static int maHienTai = -1;

    public MatHang() {
        this.maHang = ++maHienTai;
    }

    public MatHang(String tenHang, String nhomHang, int giaBan) {
        this.maHang = ++maHienTai;
        this.tenHang = tenHang;
        this.nhomHang = nhomHang;
        this.giaBan = giaBan;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getNhomHang() {
        return nhomHang;
    }

    public void setNhomHang(String nhomHang) {
        this.nhomHang = nhomHang;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public static int getMaHienTai() {
        return maHienTai;
    }

    public static void setMaHienTai(int maHienTai) {
        MatHang.maHienTai = maHienTai;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }
    
    
    @Override
    public String toString()
    {
        String ma = Integer.toString(maHang);
        if(ma.length()<4) ma = '0' + ma;
        return ma + '\n' + tenHang + '\n' + nhomHang +'\n' + giaBan + '\n';
    }
    public Object[] toObject()
    {
        return new Object[]{maHang, tenHang, nhomHang, giaBan};
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj instanceof MatHang)
        {
            MatHang m = (MatHang)obj;
            if(this.tenHang.toUpperCase().equals(m.tenHang.toUpperCase()) && this.nhomHang.toUpperCase().equals(m.nhomHang.toUpperCase()) && this.giaBan==m.giaBan)
            {
                return true;
            }
        }
        return false;
    }
    
}
