package Baitapso2;
import java.util.*;
public class Bai2 {
    public static ArrayList<Sinhvien> nhap()
    {
        ArrayList<Sinhvien> a = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 1; i <= n; i++)
        {
            Sinhvien x = new Sinhvien();
            a.add(x);
        }
        return a;
    }
    public static void doPartA()
    {
        ArrayList<Sinhvien> a = nhap();
        for(int i = 0; i < a.size(); i++)
        {
            System.out.println("Sinh viên "+(i+1)+":");
            a.get(i).inThongTin();
        }
    }
    public static void doPartB(){
        ArrayList<Sinhvien> a = nhap();
        Collections.sort(a, Sinhvien.CompareName);
        for(int i = 0; i < a.size(); i++)
        {
            System.out.println("Sinh viên "+(i+1)+":");
            a.get(i).inThongTin();
        }
    }
    public static void doPartC(){
        ArrayList<Sinhvien> a = nhap();
        Collections.sort(a, Sinhvien.CompareGroups);
        for(int i = 0; i < a.size(); i++)
        {
            System.out.println("Sinh viên "+(i+1)+":");
            a.get(i).inThongTin();
        }
    }
    public static void execute() {
        Scanner in = new Scanner(System.in);
        String part = in.next();
        switch (part)
        {
            case "a":
                Bai2.doPartA();
                break;
            case "b":
                Bai2.doPartB();
                break;
            case "c":
                Bai2.doPartC();
                break;
        }
    }

    public static void main(String[] args) {
        execute();
    }
}
