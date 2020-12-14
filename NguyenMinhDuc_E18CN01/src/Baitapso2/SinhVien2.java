package Baitapso2;

import java.util.Comparator;

public class SinhVien2 {
    private int maSV;
    private String ten;
    private String lop;
    private double dtb;
    public SinhVien2()
    {

    }
    public SinhVien2(int m, String t, String l, double d)
    {
        this.maSV = m;
        this.ten = t;
        this.lop = l;
        this.dtb = d;
    }
    @Override
    public String toString()
    {
        String ma = Integer.toString(maSV);
        while(ma.length()<4) ma = '0'+ma;
        return "Mã sinh viên: "+ma+", Họ tên: "+this.ten+", Lớp: "+this.lop+", Điểm trung bình: "+this.dtb;
    }
    public static Comparator<SinhVien2> CompareLop= new Comparator<SinhVien2>()
    {
        public int compare(SinhVien2 o1, SinhVien2 o2)
        {
            if(o1.lop.compareTo(o2.lop)==0) return Double.valueOf(o2.dtb).compareTo(o1.dtb);
            return o1.lop.compareTo(o2.lop);
        }
    };
}
