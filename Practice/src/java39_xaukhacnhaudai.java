import java.util.*;
public class java39_xaukhacnhaudai {
    public static int solution(String a, String b) {
        if(a.length()<b.length()) return b.length();
        if(a.length()>b.length()) return a.length();
        if(a.compareTo(b)==0) return -1;
        return a.length();
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-->0)
        {
            String a = cin.next(), b = cin.next();
            System.out.println(solution(a,b));
        }
    }
}
