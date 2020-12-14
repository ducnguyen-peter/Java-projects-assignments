import java.util.*;
public class java31_maxprimefactor {
    public static long solution(long n)
    {
        while(n%2==0)
        {
            n/=2;
            if(n==1) return 2;
        }
        for(long i = 3; i*i<=n; i+=2)
        {
            while(n%i==0)
            {
                n/=i;
                if(n==1) return i;
            }
        }
        return n;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-->0)
        {
            long n = cin.nextLong();
            System.out.println(solution(n));
        }
    }
}
