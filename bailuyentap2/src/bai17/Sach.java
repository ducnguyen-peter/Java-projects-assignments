package bai17;

public class Sach {
    private int maSach;
    private String tenSach;
    private String chuyenNganh;
    private double giaBan;

    public Sach() {
    }

    public Sach(int m, String t, String cn, double gia) {
        this.maSach = m;
        this.tenSach = t;
        this.chuyenNganh = cn;
        this.giaBan = gia;
    }

    public int getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void hien(){
        System.out.println(maSach+" "+tenSach+" "+chuyenNganh+" "+giaBan);
    }
}
