package Baitapso2;
import java.util.*;
public class Bai11 {
    public static boolean isTriangle(MyPoint p1, MyPoint p2, MyPoint p3)
    {
        double a = MyPoint.distance(p1, p2), b = MyPoint.distance(p2, p3), c = MyPoint.distance(p3, p1);
        return a+b!=c || a+c!=b || b+c!=a;
    }
    public static boolean isSquareTriangle(MyPoint a, MyPoint b, MyPoint c) {
        MyPoint ab = MyPoint.MakeVector(a, b);
        MyPoint bc = MyPoint.MakeVector(b, c);
        MyPoint ac = MyPoint.MakeVector(a, c);
        return isTriangle(a,b,c)&&(MyPoint.VectorMul(ab, bc)==0||MyPoint.VectorMul(ab,ac)==0||MyPoint.VectorMul(bc,ac)==0);
    }
    public static boolean isScaleneTriangle(MyPoint a, MyPoint b, MyPoint c)
    {
        double ab = MyPoint.distance(a, b);
        double bc = MyPoint.distance(b, c);
        double ac = MyPoint.distance(a, c);
        return isTriangle(a, b, c)&&(ab==bc||bc==ac||ab==ac);
    }
    public static boolean isSquareScalene(MyPoint a, MyPoint b, MyPoint c)
    {
        return isSquareTriangle(a, b, c) && isScaleneTriangle(a, b, c);
    }
    public static boolean isEquilateral(MyPoint a, MyPoint b, MyPoint c)
    {
        double ab = MyPoint.distance(a, b);
        double bc = MyPoint.distance(b, c);
        double ac = MyPoint.distance(a, c);
        return isTriangle(a, b, c)&&(ab==bc&&bc==ac);
    }
    public static void execute() {
        Scanner in = new Scanner(System.in);
        MyPoint[] a = new MyPoint[4];
        for(int i = 1; i<=3; i++)
        {
            double x = in.nextDouble(), y = in.nextDouble();
            a[i] = new MyPoint(x, y);
        }
        if(isTriangle(a[1],a[2],a[3])) System.out.println("Is a Triangle");
        if(isSquareTriangle(a[1],a[2],a[3])) System.out.println("Is a Square triangle");
        if(isScaleneTriangle(a[1],a[2],a[3])) System.out.println("Is a Scalene triangle");
        if(isSquareScalene(a[1],a[2],a[3])) System.out.println("Is a Square Scalene triangle");
        if(isEquilateral(a[1],a[2],a[3])) System.out.println("Is an Equilateral triangle");
    }
    public static void main(String[] args) {
        execute();
    }
}
