package Baitapso2;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String command = in.next();
        switch (command)
        {
            case "Bai1":
                Bai1.execute();
                break;
            case "Bai2":
                Bai2.execute();
                break;
            case "Bai3":
                Bai3.execute();
                break;
            case "Bai4":
                Bai4.execute();
                break;
            case "Bai5":
                Bai5.execute();
                break;
            case "Bai6":
                Bai6.execute();
                break;
            case "Bai9":
                Bai9.execute();
                break;
            default:
                System.out.println("Chưa làm :)");
        }
    }
}
