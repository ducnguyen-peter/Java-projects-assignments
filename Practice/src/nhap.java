import java.util.*;
public class nhap {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String a = cin.next(), b = cin.next();
        if(a.compareTo(b)<0)
        {
            String tmp = a; a = b; b = tmp;
        }
        System.out.println(a+" "+b);
    }
}
