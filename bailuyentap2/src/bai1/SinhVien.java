package bai1;


import java.util.Scanner;

public class SinhVien{
    private String studentID;
    private String studentName;
    private String studentClass;
    private String studentCourse;

    public SinhVien(){

    }

    public SinhVien(String studentID, String studentName, String studentClass, String studentCourse) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentCourse = studentCourse;
    }

    public boolean seachStudentClass(String seach){
        if(seach.equalsIgnoreCase(studentClass)){
            return true;
        }
        return false;
    }
    public String separated(){
        String s = studentName;
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        String[] ss = s.split(" ");
        return ss[ss.length-1];
    }

    public void setStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên: ");
        studentID = scanner.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        studentName = scanner.nextLine();
        System.out.print("Nhập lớp: ");
        studentClass = scanner.nextLine();
        System.out.print("Nhập khóa: ");
        studentCourse = scanner.nextLine();
    }
    public void showInfoStudent(){
        System.out.println("Mã sinh viên: " + studentID);
        System.out.println("Tên sinh viên: "+ studentName);
        System.out.println("Lớp: "+ studentClass);
        System.out.println("Khóa: " + studentCourse);
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", studentCourse='" + studentCourse + '\'' +
                '}';
    }
}
