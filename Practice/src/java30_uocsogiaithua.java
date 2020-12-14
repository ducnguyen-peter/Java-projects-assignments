import java.util.*;
public class java30_uocsogiaithua {
    public static int solution(long n, long p)
    {
        int ans = 0;
        for(long i = p; i <= n; i+=p)
        {
            long x = i;
            while(x%p==0)
            {
                ans++;
                x/=p;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-->0)
        {
            long n = cin.nextLong(), p = cin.nextLong();
            System.out.println(solution(n,p));
        }
    }
}
