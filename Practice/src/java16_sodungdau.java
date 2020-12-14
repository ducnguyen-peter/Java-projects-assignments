import java.util.*;
public class java16_sodungdau {
    public static void solution(int [] a, int n)
    {
        int i = n-1, max = 0;
        Vector<Integer>res = new Vector<>();
        while(i>=0)
        {
            if(a[i]>max)
            {
                max = a[i];
                res.add(max);
            }
            i--;
        }
        for(int j = res.size()-1; j>=0; j--) System.out.print(res.get(j)+" ");
        System.out.print("\n");
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-->0)
        {
            int n = cin.nextInt();
            int [] a = new int [n+1];
            for(int i = 0; i < n; i++) a[i] = cin.nextInt();
            solution(a,n);
        }
    }
}
