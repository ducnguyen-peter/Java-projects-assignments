package bai1;

public class main {
    public static void main(String[] args) {
        System.out.println("Nhập vào một sinh viên: ");
        SinhVien sinhVien = new SinhVien();
        sinhVien.setStudent();
        System.out.println("Thông tin sinh viên vừa nhập: ");
        sinhVien.showInfoStudent();
    }
}

