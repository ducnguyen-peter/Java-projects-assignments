package bai12;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        do{
            System.out.println("Các chức năng: ");
            System.out.println("1.Tính tổng và hiệu hai ma trận.");
            System.out.println("2.Tính tích hai ma trận.");
            System.out.println("3.Tìm chuyển vị của một ma trận.");
            System.out.println("4.Kết thúc chương trình.");
            System.out.println("Bạn chọn?");
            n = scanner.nextInt();
            switch (n){
                case 1:
                    System.out.println("Chức năng tính tổng và hiệu hai ma trận!");
                    int rows1, clos1, rows2, clos2;
                    System.out.println("Nhập ma trận thứ nhất: ");
                    System.out.println("Nhập số hàng: ");
                    rows1 = scanner.nextInt();
                    System.out.println("Nhập số cột: ");
                    clos1 = scanner.nextInt();
                    Matrix m1 = new Matrix(rows1, clos1);
                    m1.input();
                    System.out.println("Nhập ma trận thứ hai: ");
                    System.out.println("Nhập số hàng: ");
                    rows2 = scanner.nextInt();
                    System.out.println("Nhập số cột: ");
                    clos2 = scanner.nextInt();
                    Matrix m2 = new Matrix(rows2, clos2);
                    m2.input();
                    Matrix resultAdd = m1.add(m2);
                    Matrix resultSub = m1.sub(m2);
                    if(resultAdd != null){
                        System.out.println("Tổng hai ma trận: ");
                        resultAdd.print();
                    }else System.out.println("Không tính đươc!");
                    if(resultSub != null){
                        System.out.println("Hiệu hai ma trận: ");
                        resultSub.print();
                    }else System.out.println("Không tính được!");
                    break;
                case 2:
                    System.out.println("Chức năng tính tích hai ma trận!");
                    int h1, c1, h2, c2;
                    System.out.println("Nhập ma trận thứ nhất: ");
                    System.out.println("Nhập số hàng: ");
                    h1 = scanner.nextInt();
                    System.out.println("Nhập số cột: ");
                    c1 = scanner.nextInt();
                    Matrix a1 = new Matrix(h1, c1);
                    a1.input();
                    System.out.println("Nhập ma trận thứ hai: ");
                    System.out.println("Nhập số hàng: ");
                    h2 = scanner.nextInt();
                    System.out.println("Nhập số cột: ");
                    c2 = scanner.nextInt();
                    Matrix a2 = new Matrix(h2, c2);
                    a2.input();
                    Matrix kq = a1.mul(a2);
                    if(kq != null){
                        System.out.println("Tích hai ma trận: ");
                        kq.print();
                    }else System.out.println("Không tính được!");
                    break;
                case 3:
                    int h, c;
                    System.out.println("Chức năng tìm chuyển vị của một ma trận!");
                    System.out.println("Nhập ma trận: ");
                    System.out.println("Nhập số hàng: ");
                    h = scanner.nextInt();
                    System.out.println("Nhập số cột: ");
                    c = scanner.nextInt();
                    Matrix m = new Matrix(h, c);
                    m.input();
                    Matrix result = m.transpose();
                    System.out.println("Ma trận chuyển vị: ");
                    result.print();
                    break;
                case 4:
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
            }
        }while (n != 4);
    }
}
