package bai10;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        MyPoint[] myPoints = new MyPoint[n];
        for(int i = 0; i < n; i++){
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            myPoints[i] = new MyPoint(x, y);
        }
        double max = 0;
        MyPoint d1 = new MyPoint();
        MyPoint d2 = new MyPoint();
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(myPoints[i].distance(myPoints[j]) > max){
                    max = myPoints[i].distance(myPoints[j]);
                    d1 = myPoints[i];
                    d2 = myPoints[j];
                }
            }
        }
        System.out.println("Hai điểm có khoảng cách lớn nhất là: (" + d1.getX()+", "+ d1.getY()
                +")"+ " (" + d2.getX()+", "+d2.getY()+")");
        System.out.println("Khoảng cách lớn nhất: "+max);
    }
}
