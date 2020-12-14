package Bai2;
import java.util.*;
public class SinhVien {
    private int maSV;
    private String ten;
    private String lop;
    private double dtb;
    private static int currentID = 0;


    public SinhVien()
    {

    }

    public SinhVien(String t, String l, double d)
    {
        this.maSV = currentID++;
        this.ten = t;
        this.lop = l;
        this.dtb = d;
    }

    public int getMaSV() {
        return maSV;
    }

    public String getTen() {
        return ten;
    }

    public String getLop() {
        return lop;
    }

    public double getDtb() {
        return dtb;
    }

    public void setCurrentID(int currentID)
    {
        this.currentID = currentID;
    }
    @Override
    public String toString()
    {
        String ma = Integer.toString(maSV);
        while(ma.length()<4) ma = '0'+ma;
        return ma+'\n'+this.ten+'\n'+this.lop+'\n'+this.dtb + '\n';
    }
    public static Comparator<SinhVien> CompareLop= new Comparator<SinhVien>()
    {
        public int compare(SinhVien o1, SinhVien o2)
        {
            if(o1.lop.compareTo(o2.lop)==0) return Double.valueOf(o2.dtb).compareTo(o1.dtb);
            return o1.lop.compareTo(o2.lop);
        }
    };
}
