package Baitapso2;
import java.util.*;
public class Sinhvien {
    Scanner in = new Scanner(System.in);
    private String ID;
    private String name;
    private String group;
    private String classname;
    public Sinhvien(){
        this.ID = in.nextLine();
        this.name = in.nextLine();
        this.group = in.nextLine();
        this.classname = in.nextLine();
    }
    public String getName()
    {
        return name;
    }
    public String getGroup()
    {
        return group;
    }
    public void inThongTin()
    {
        System.out.println("ID: "+ this.ID);
        System.out.println("Tên: "+ this.name);
        System.out.println("Lớp: "+ this.group);
        System.out.println("Khóa: "+ this.classname);
    }
    public static Comparator<Sinhvien> CompareName = new Comparator<Sinhvien>() {
        public int compare(Sinhvien o1, Sinhvien o2) {
            String name1 = o1.getName().toUpperCase();
            String name2 = o2.getName().toUpperCase();
            return name1.compareTo(name2);
        }
    };
    public static Comparator<Sinhvien> CompareGroups = new Comparator<Sinhvien>() {
        public int compare(Sinhvien o1, Sinhvien o2) {
            String G1 = o1.getGroup().toUpperCase();
            String G2 = o2.getGroup().toUpperCase();
            return G1.compareTo(G2);
        }
    };
}
