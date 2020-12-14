import java.util.*;
public class java38_symmetricString {
    public static String check(String a)
    {
        int n = a.length();
        int count = 0;
        for(int i = 0; i < n/2; i++)
        {
            if(a.charAt(i)!=a.charAt(n-1-i)) count++;
        }
        if(count==0&&a.length()%2==1) return "YES";
        if(count==1) return "YES";
        return "NO";
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-->0)
        {
            String a = cin.next();
            System.out.println(check(a));
        }
    }
}
