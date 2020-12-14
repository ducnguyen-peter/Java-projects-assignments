import java.util.*;
public class bai11_uocsochiahet2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-->0)
        {
            int n = cin.nextInt(), dem = 0, ans = 1;
            while(n%2==0)
            {
                dem++;
                n/=2;
            }
            ans*=dem;
            for(int i = 3; i*i <= n; i+=2)
            {
                dem = 0;
                while(n%i==0)
                {
                    dem++;
                    n/=i;
                }
                ans*=(dem+1);
            }
            if(n>1) ans*=2;
            System.out.println(ans);
        }
    }
}
