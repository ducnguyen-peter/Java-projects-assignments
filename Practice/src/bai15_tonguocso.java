import java.util.*;
public class bai15_tonguocso {
    public static long sumprimefactors(int n)
    {
        long ans[] = new long[n+1];
        for(int i = 2; i<=n; i++)
        {
            if(ans[i]==0)
            {
                for(int j = i; j<=n; j+=i)
                {
                    ans[j]+=i;
                }
            }
        }
        return ans[n];
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        long [] a = new long[2000005];
        a[1] = 1;
        for(int i = 2; i<=2000000; i++) a[i] = i;
        for(int i = 2; i<=2000000; i+=2) a[i] = 2;
        for(int i = 3; i*i<=2000000; i++)
        {
            if(a[i]==i)
                for(int j = i*i; j<=2000000; j+=i)
                {
                    if(a[j]==j) a[j] = i;
                }
        }
        int t = cin.nextInt();
        long ans = 0;
        while(t-->0)
        {
            int n = cin.nextInt();
            while(n!=1)
            {
                ans+=a[n];
                n/=a[n];
            }
        }
        System.out.println(ans);
    }
}
