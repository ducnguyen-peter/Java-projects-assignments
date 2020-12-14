package Baitapso2;

import java.util.Scanner;

public class PhanSo {
    private int ts, ms;
    public PhanSo()
    {

    }
    public PhanSo(int ts, int ms)
    {
        this.ts = ts;
        this.ms = ms;
    }
    public int gcd(int a, int b)
    {
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public PhanSo toiGian()
    {
        int div = gcd(ts,ms);
        PhanSo result = new PhanSo(this.ts/div, this.ms/div);
        return result;
    }
    public PhanSo cong(PhanSo ps2)
    {
        int tu1 = this.ts, mau1 = this.ms, tu2 = ps2.ts, mau2 = ps2.ms;
        int mau = mau1*mau2, tu = tu1*mau2+tu2*mau1;
        PhanSo result = new PhanSo(tu, mau);
        return result.toiGian();
    }
    public PhanSo tru(PhanSo ps2)
    {
        int tu1 = this.ts, mau1 = this.ms, tu2 = ps2.ts, mau2 = ps2.ms;
        int mau = mau1*mau2, tu = tu1*mau2-tu2*mau1;
        PhanSo result = new PhanSo(tu, mau);
        return result.toiGian();
    }
    public PhanSo nhan(PhanSo ps2)
    {
        int tu1 = this.ts, mau1 = this.ms, tu2 = ps2.ts, mau2 = ps2.ms;
        int mau = mau1*mau2, tu = tu1*tu2;
        PhanSo result = new PhanSo(tu, mau);
        return result.toiGian();
    }
    public PhanSo nghichDao()
    {
        PhanSo result = new PhanSo(this.ms, this.ts);
        return result;
    }
    public PhanSo chia(PhanSo ps2)
    {
        return this.nhan(ps2.nghichDao());
    }
    public PhanSo doiDau()
    {
        PhanSo result = this;
        result.ts*=-1;
        result.ms*=-1;
        return result;
    }
    public boolean bangNhau(PhanSo ps2)
    {
        return this.tru(ps2).ts==0;
    }
    public boolean lonHon(PhanSo ps2)
    {
        PhanSo a = this.tru(ps2);
        return a.ts/a.ms>0;
    }
    public void hien()
    {
        if(ms==1) System.out.println(ts);
        else if(ts==0) System.out.println(0);
        else System.out.println(ts+"/"+ms);
    }
    public void nhap()
    {
        Scanner in = new Scanner(System.in);
        this.ts = in.nextInt();
        this.ms = in.nextInt();
    }
}
