import java.util.*;
import static java.lang.Math.sqrt;
public class java19_pitagoreantriple {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-->0)
        {
            int n = cin.nextInt();
            long []a = new long [n];
            for(int i = 0; i < n; i++)
            {
                a[i] = cin.nextLong();
            }
            for(int i = 0; i < n; i++) a[i] = a[i]*a[i];
            Arrays.sort(a);
            boolean kt = false;
            for(int i = n-1; i >=2; i--)
            {
                if(kt==true) break;
                int l = 0, r = i-1;
                while(l<r)
                {
                    if(a[l]+a[r]==a[i])
                    {
                        kt = true; break;
                    }
                    if(a[l]+a[r]<a[i]) l++;
                    else r--;
                }
            }
            if(kt) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
