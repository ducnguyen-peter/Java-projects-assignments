import java.util.Scanner;
public class bai2_fibonacci {
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        long[] f;
        f = new long[94];
        f[0] = 0; f[1] = 1;
        for(int i = 2; i < 94; i++)
        {
            f[i] = f[i-1]+f[i-2];
        }
        int t = cin.nextInt();
        while(t>0)
        {
            int n = cin.nextInt();
            System.out.println(f[n]);
            t--;
        }
    }
}
