package bai10;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
     public MyPoint(MyPoint p){
        this.x = p.x;
        this.y = p.y;
     }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(MyPoint secondPont){
        double c1 = Math.abs(this.x - secondPont.x);
        double c2 = Math.abs(this.y - secondPont.y);
        return Math.sqrt((c1*c1)+(c2*c2));
    }

    public double distance(MyPoint p1, MyPoint p2){
        double c1 = Math.abs(p1.x - p2.x);
        double c2 = Math.abs(p1.y- p2.y);
        return Math.sqrt((c1*c1)+(c2*c2));
    }
}
