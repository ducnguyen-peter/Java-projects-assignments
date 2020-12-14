import java.util.*;
public class java24_beauty3 {
    public static String check(String s)
    {
        int n = s.length();
        boolean []a = new boolean[10];
        a[2] = a[3] = a[5] = a[7] = true;
        for(int i = 0, j = n-1; i<n&&j>=0; i++, j--)
        {
            if(s.charAt(i)!=s.charAt(j)||!a[s.charAt(i)-'0']) return "NO";
        }
        return "YES";
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        cin.nextLine();
        while(t-->0)
        {
            String s = cin.next();
            System.out.println(check(s));
        }
    }
}
