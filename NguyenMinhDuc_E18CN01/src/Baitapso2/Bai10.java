package Baitapso2;

import java.util.*;

public class Bai10 {
    public static void execute() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<MyPoint> points = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            double x = in.nextDouble();
            double y = in.nextDouble();
            MyPoint a = new MyPoint(x, y);
            points.add(a);
        }
        Collections.sort(points, MyPoint.CompareDistance);
        System.out.println(MyPoint.distance(points.get(0), points.get(n-1)));
    }
    public static void main(String[] args) {
        execute();
    }
}
