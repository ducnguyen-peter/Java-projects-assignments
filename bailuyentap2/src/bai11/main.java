package bai11;

import bai10.MyPoint;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyPoint[] myPoints = new MyPoint[3];
        for(int i = 0; i < 3; i++){
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            myPoints[i] = new MyPoint(x, y);
        }
        double a = myPoints[0].distance(myPoints[1]);
        double b = myPoints[0].distance(myPoints[2]);
        double c = myPoints[1].distance(myPoints[2]);
        if(a+b>c && a+c>b && b+c>a){
            if(a == b && a == c) System.out.println("Là tam giác đều!");
            else if(tgvc(a, b, c)) System.out.println("Là tam giác vuông cân!");
            else if(a==b |a==c|b==c) System.out.println("Là tam giác cân!");
            else if(tgv(a, b, c)) System.out.println("Là tam giác vuông!");
            else System.out.println("Là tam giác!");
        }
        else {
            System.out.println("Không phải tam giác!");
        }
    }

    private static boolean tgvc(double a, double b, double c) {
        if(a == b){
            double count = a*a+b*b;
            count = (double)Math.round(count*10000)/10000;
            double k = (double)Math.round((c*c)*10000)/10000;
            if(k == count) return true;
        }
        else if(a == c){
            double count = a*a+c*c;
            count = (double)Math.round(count*10000)/10000;
            double k = (double)Math.round((b*b)*10000)/10000;
            if(k == count) return true;
        }
        else if(c == b){
            double count = c*c+b*b;
            count = (double)Math.round(count*10000)/10000;
            double k = (double)Math.round((a*a)*10000)/10000;
            if(k == count) return true;
        }
        return false;
    }

    private static boolean tgv(double a, double b, double c) {
        double count = (double)Math.round((a*a+b*b)*10000)/10000;
        double k = (double)Math.round((c*c)*10000)/10000;
        if(count == k) return true;
        count = (double)Math.round((a*a+c*c)*10000)/10000;
        k = (double)Math.round((b*b)*10000)/10000;
        if(count == k) return true;
        count = (double)Math.round((c*c+b*b)*10000)/10000;
        k = (double)Math.round((a*a)*10000)/10000;
        if(count == k) return true;
        return false;
    }

}

