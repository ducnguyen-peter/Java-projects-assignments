package bai3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tạo hình chữ nhật: ");
        double width, height;
        String color;
        System.out.println("Nhập chiều rộng: ");
        width = scanner.nextDouble();
        System.out.println("Nhập chiều dài: ");
        height = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập màu: ");
        color = scanner.nextLine();
        Rectangle rectangle = new Rectangle(width, height, color);
        System.out.println("-----------------Thông tin hình chữ nhật vừa tạo-----------------");
        System.out.println("Chiều rộng: " + rectangle.getWidth());
        System.out.println("Chiều dài: " + rectangle.getHeight());
        System.out.println("Màu: " + rectangle.getColor());
        System.out.println("Diện tích: " + rectangle.findArea());
        System.out.println("Chu vi: " + rectangle.findPerimeter());
    }
}
