package Baitapso2;
import java.util.*;
public class Bai3 {
    public static void execute() {
        Scanner in = new Scanner(System.in);
        double height = in.nextDouble();
        double width = in.nextDouble();
        in.nextLine();
        String color = in.nextLine();
        Rectangle a = new Rectangle(width, height, color);
        System.out.println("Chiều dài: "+a.getHeight()+"; Chiều rộng: "+a.getWidth()+"; Màu: "+a.getColor()+"; Diện tích: "+a.findArea()+"; Chu vi: "+a.findPerimeter());
    }

    public static void main(String[] args) {
        execute();
    }
}
