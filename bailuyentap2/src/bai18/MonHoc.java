package bai18;

public class MonHoc {
    private int maMon;
    private String tenMon;
    private String nhomMon;
    private int soTinchi;

    public MonHoc() {
    }

    public MonHoc(int m, String t, String nhom, int so) {
        this.maMon = m;
        this.tenMon = t;
        this.nhomMon = nhom;
        this.soTinchi = so;
    }

    public int getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public String getNhomMon() {
        return nhomMon;
    }

    public int getSoTinchi() {
        return soTinchi;
    }

    public void hien(){
        System.out.println(maMon +" " + tenMon+" "+nhomMon+" "+soTinchi);
    }
}
