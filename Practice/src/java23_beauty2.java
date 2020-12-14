import java.util.*;
public class java23_beauty2 {
    public static String check(String s)
    {
        int n = s.length();
        if(s.charAt(n-1)!='8'||s.charAt(0)!='8') return "NO";
        int so = 0;
        for(int i = 0, j = n-1; i < n && j>=0; i++, j--)
        {
            if(s.charAt(i)!=s.charAt(j)) return "NO";
        }
        for(int i = 0; i < n; i++) so = (so+s.charAt(i)-'0')%10;
        if(so==0) return "YES";
        return "NO";
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
