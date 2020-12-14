package Baitapso2;

import java.util.Comparator;

public class MyPoint {
    private double x;
    private double y;
    public MyPoint()
    {
        this.x = 0;
        this.y = 0;
    }
    public MyPoint(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public MyPoint(MyPoint p)
    {
        this.x = p.x;
        this.y = p.y;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public double distance(MyPoint secondPoint)
    {
        double subx = Math.abs(this.x-secondPoint.x);
        double suby = Math.abs(this.y-secondPoint.y);
        return Math.sqrt(Math.pow(subx, 2)+Math.pow(suby, 2));
    }
    public static double distance(MyPoint p1, MyPoint p2)
    {
        double subx = Math.abs(p1.getX()-p2.getX());
        double suby = Math.abs(p1.getY()-p2.getY());
        return Math.sqrt(Math.pow(subx, 2)+Math.pow(suby, 2));
    }
    public static Comparator<MyPoint> CompareDistance= new Comparator<MyPoint>(){
        public int compare(MyPoint p1, MyPoint p2)
        {
            double val1 = p1.getX()-p2.getX();
            if(val1==0)
            {
                return (int)(p1.getY()-p2.getY());
            }
            return (int)val1;
        }
    };
    public static MyPoint MakeVector(MyPoint p1, MyPoint p2)
    {
        return new MyPoint(p2.x-p1.x, p2.y- p1.y);
    }
    public static double VectorMul(MyPoint v1, MyPoint v2)
    {
        return v1.x*v2.x+v1.y* v2.y;
    }
}
