import java.util.*;
public class java17_diemcanbang {
    public static int solution(int []a, int n)
    {
        int sum = 0, ans = -1;
        for(int i = 1; i <= n; i++) sum+=a[i];
        int s1=0, s2;
        for(int i = 0; i < n+1; i++)
        {
            s1+=a[i];
            s2 = sum - s1 - a[i+1];
            if(s1==s2)
            {
                ans =  i+1; break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-->0)
        {
            int n = cin.nextInt();
            int []a = new int[n+2];
            for(int i = 1; i <= n; i++) a[i] = cin.nextInt();
            System.out.println(solution(a,n));
        }
    }
}
