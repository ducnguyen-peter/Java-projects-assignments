package bai13;

import java.util.Scanner;

public class Phanso {
    private int ts;
    private int ms;

    public Phanso() {
        ts = 0;
        ms = 1;
    }

    public Phanso(int ts, int ms) {
        this.ts = ts;
        this.ms = ms;
    }

    public Phanso cong(Phanso sp2){
        Phanso p = new  Phanso();
        if(this.ms == sp2.ms){
            p.ms = this.ms;
            p.ts = this.ts + sp2.ts;
        }else {
            int a = this.ts;
            int b = this.ms;
            p.ts = a* sp2.ms + sp2.ts*b;
            p.ms = b*sp2.ms;
        }
        return p.toiGian();
    }

    public Phanso tru(Phanso sp2){
        Phanso p = new  Phanso();
        if(this.ms == sp2.ms){
            p.ms = this.ms;
            p.ts = this.ts - sp2.ts;
        }else {
            int a = this.ts;
            int b = this.ms;
            p.ts = a*sp2.ms - sp2.ts*b;
            p.ms = b*sp2.ms;
        }
        return p.toiGian();
    }

    public Phanso nhan(Phanso sp2){
        Phanso p = new  Phanso();
        p.ts = this.ts* sp2.ts;
        p.ms = this.ms* sp2.ms;
        return p.toiGian();
    }

    public Phanso chia(Phanso sp2){
        Phanso p = sp2.Nghichdao();
        Phanso kq = new Phanso();
        kq.ts = this.ts*p.ts;
        kq.ms = this.ms*p.ms;
        return kq.toiGian();
    }

    public Phanso Nghichdao(){
        Phanso p = new Phanso();
        p.ts = this.ms;
        p.ms = this.ts;
        return p;
    }

    public Phanso doiDau(){
        Phanso p = new Phanso();
        p.ts = -this.ts;
        p.ms = this.ms;
        return p;
    }

    public Phanso toiGian(){
        Phanso p = new Phanso();
        if(ucln() != 1){
            p.ts = this.ts/ucln();
            p.ms = this.ms/ucln();
        }
        else p = this;
        return p;
    }

    private int ucln() {
        int a = this.ts;
        int b = this.ms;
        if(a < 0) a = -a;
        if(b < 0) b = -b;
        int tmp;
        while (b != 0){
            tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public boolean bangNhau(Phanso sp2){
        int a = this.ts;
        int b = this.ms;
        if(a* sp2.ms == b* sp2.ts) return true;
        return false;
    }

    public boolean lonHon(Phanso sp2){
        int a = this.ts;
        int b = this.ms;
        if(a* sp2.ms > b* sp2.ts) return true;
        return false;
    }

    public boolean nhoHon(Phanso sp2){
        int a = this.ts;
        int b = this.ms;
        if(a* sp2.ms < b* sp2.ts) return true;
        return false;
    }


    public void hien(){
        System.out.println(ts+"/"+ms);
    }

    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập phân số: ");
        String s = scanner.nextLine();
        String[] ss = s.split("/");
        ts = Integer.parseInt(ss[0]);
        ms = Integer.parseInt(ss[1]);
    }
}
