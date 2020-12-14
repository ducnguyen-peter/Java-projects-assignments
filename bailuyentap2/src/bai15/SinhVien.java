package bai15;

public class SinhVien {
    private int maSV;
    private String ten;
    private String lop;
    private double dtb;

    public SinhVien() {
    }

    public SinhVien(int m, String t, String l, double d) {
        this.maSV = m;
        this.ten = t;
        this.lop = l;
        this.dtb = d;
    }

    public int getMaSV() {
        return maSV;
    }

    public String getLop() {
        return lop;
    }

    public double getDtb() {
        return dtb;
    }

    public String getTen() {
        return ten;
    }

    public void hien(){
        System.out.println(maSV + " "+ten+" "+lop+" "+dtb);
    }

    public String xepLoai(){
        if(dtb >= 8) return "Gioi";
        else if(dtb >= 7 && dtb < 8) return "Kha";
        else if(dtb >= 5 && dtb < 7) return "Trung Binh";
        else return "Yeu";
    }
}
