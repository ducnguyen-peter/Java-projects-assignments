package Baitapso2;
public class Bai13 {
    public static void execute()
    {
        PhanSo a = new PhanSo(), b = new PhanSo();
        System.out.print("a = "); a.nhap();
        System.out.print("b = "); b.nhap();
        System.out.print("a + b = "); a.cong(b).hien();
        System.out.print("a - b = "); a.tru(b).hien();
        System.out.print("a * b = "); a.nhan(b).hien();
        System.out.print("a / b = "); a.chia(b).hien();
        System.out.print("a va b toi gian: "); a.toiGian().hien(); b.toiGian().hien();
        if(a.bangNhau(b)) System.out.println("a = b");
        if(a.lonHon(b)) System.out.println("a > b");
        if(b.lonHon(b)) System.out.println("a < b");
    }

    public static void main(String[] args) {
        execute();
    }
}
