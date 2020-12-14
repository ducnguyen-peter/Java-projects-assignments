package bai14;

import bai12.Matrix;
import jdk.jshell.spi.SPIResolutionException;

import java.util.Scanner;

public class SoPhuc {
    private float a;
    private float b;

    public SoPhuc() {
        a = 0;
        b = 0;
    }

    public SoPhuc(float thuc, float ao) {
        this.a = a;
        this.b = b;
    }

    public SoPhuc cong(SoPhuc sp2){
        SoPhuc s = new SoPhuc();
        s.a = this.a + sp2.a;
        s.b = this.b + sp2.b;
        return s;
    }

    public SoPhuc tru(SoPhuc sp2){
        SoPhuc s = new SoPhuc();
        s.a = this.a - sp2.a;
        s.b = this.b - sp2.b;
        return s;
    }

    public SoPhuc nhan(SoPhuc sp2){
        SoPhuc s = new SoPhuc();
        s.a = this.a* sp2.a - this.b* sp2.b;
        s.b = this.a* sp2.b + this.b* sp2.a;
        return s;
    }

    public SoPhuc chia(SoPhuc sp2){
        SoPhuc s = new SoPhuc();
        s.a = (this.a*sp2.a + sp2.b*this.b)/(sp2.a*sp2.a + sp2.b*sp2.b);
        s.b = (sp2.a*this.b - sp2.b*this.a)/(sp2.a*sp2.a + sp2.b*sp2.b);
        return s;
    }

    public SoPhuc nghichDao(){
        SoPhuc s = new SoPhuc();
        float m = this.a*this.a + this.b*this.b;
        s.a = this.a/m;
        s.b = -this.b/m;
        return s;
    }

    public boolean bangNhau(SoPhuc sp2){
        if(this.a == sp2.a && this.b == sp2.b) return true;
        return false;
    }

    public boolean lonHon(SoPhuc sp2){
        double modul1 = Math.sqrt(this.a*this.a+this.b*this.b);
        double modul2 = Math.sqrt(sp2.a*sp2.a+sp2.b*sp2.b);
        if(modul1 > modul2) return true;
        return false;
    }

    public boolean nhoHon(SoPhuc sp2){
        double modul1 = Math.sqrt(this.a*this.a+this.b*this.b);
        double modul2 = Math.sqrt(sp2.a*sp2.a+sp2.b*sp2.b);
        if(modul1 < modul2) return true;
        return false;
    }

    public void hien(){
        System.out.println(a + " + j"+b);
    }

    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.trim();
        s = s.replaceAll("\\s+", "");
        String s1 = "";
        for(int i = 0; i < s.length(); i++){
            if(String.valueOf(s.charAt(i)).equals("+") == false){
                s1+= String.valueOf(s.charAt(i));
            }
        }
        String[] ss = s1.split("j");
        a = Float.parseFloat(ss[0]);
        b = Float.parseFloat(ss[1]);
    }
}
