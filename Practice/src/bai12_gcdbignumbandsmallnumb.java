import java.util.*;
public class bai12_gcdbignumbandsmallnumb {
    public static long gcd(long a, long b)
    {
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        long t = cin.nextLong();
        while(t-->0)
        {
            long a = cin.nextLong();
            cin.nextLine();
            String b = cin.next();
            long num = 0;
            for(int i = 0; i < b.length(); i++)
            {
                num = (num*10+b.charAt(i)-'0')%a;
            }
            if (a == 0)
                System.out.println(b);
            else
                System.out.println(gcd(num, a));
        }
    }
}
