package bai2;
import bai1.SinhVien;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Nhập số sinh viên muốn thêm vào danh sách: ");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SinhVien[] students = new SinhVien[n];
        System.out.println("Nhập thông tin sinh viên: ");
        for(int i = 0; i < n; i++){
            students[i] = new SinhVien();
            System.out.println("Thông tin sinh viên thứ " + (i+1)+ ": ");
            students[i].setStudent();
        }
        System.out.println("-----------------------Thông tin danh sách sinh viên-----------------------");
        for (SinhVien r: students){
            System.out.println(r);
        }
        students = sortName(students);
        System.out.println("-----------------------Thông tin danh sách sau khi sắp xếp(A-Z)-----------------------");
        for (SinhVien r: students){
            System.out.println(r);
        }
        System.out.println("Nhập tên lớp: ");
        String s = scanner.nextLine();
        int kt = 0;
        System.out.println("-----------------------Danh sách sinh viên lớp " + s+"-----------------------");
        for(int i = 0; i < n; i++){
            if(students[i].seachStudentClass(s)){
                kt = 1;
                System.out.println(students[i]);
            }
        }
        if(kt == 0) System.out.println("Không có sinh viên nào lớp " + s+"!");
    }

    private static SinhVien[] sortName(SinhVien[] students) {
        for(int i = 0; i < students.length-1; i++){
            for(int j = i+1; j < students.length; j++){
                String s1 = students[i].separated();
                String s2 = students[j].separated();
                if(s1.compareTo(s2) > 0){
                    SinhVien m = students[i];
                    students[i] = students[j];
                    students[j] = m;
                }
            }
        }
        return students;
    }
}
