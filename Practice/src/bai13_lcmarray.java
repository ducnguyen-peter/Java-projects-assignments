import java.util.*;
public class bai13_lcmarray {
    public static long gcd(long a, long b)
    {
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public static long solution(long n)
    {
        long ans = 1;
        for(long i = 1; i <= n; i++)
        {
            long x = gcd(ans,i);
            ans = ans*i/x;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        long t = cin.nextInt();
        while(t-->0)
        {
            long n = cin.nextInt();
            System.out.println(solution(n));
        }
    }
}
