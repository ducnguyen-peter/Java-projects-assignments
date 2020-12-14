package Baitapso2;
import java.util.*;
public class Rectangle {
    private double width;
    private double height;
    private String color;
    public Rectangle()
    {
        this.width = 1;
        this.height = 1;
    }
    public Rectangle(double width, double height, String color)
    {
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public double getWidth()
    {
        return this.width;
    }
    public void setWidth(double width)
    {
        this.width = width;
    }
    public double getHeight()
    {
        return this.height;
    }
    public void setHeight(double height)
    {
        this.height = height;
    }
    public String getColor()
    {
        return this.color;
    }
    public void setColor(String color)
    {
        this.color = color;
    }
    public double findArea()
    {
        return this.height*this.width;
    }
    public double findPerimeter()
    {
        return (this.height+this.width)*2;
    }
}
