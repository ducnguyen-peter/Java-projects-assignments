import java.util.*;
public class java32_checkfibo {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        long f[] = new long[94];
        f[0] = 0; f[1] = 1;
        for(int i = 2; i < 94; i++) f[i] = f[i-1] + f[i-2];
        while(t-->0)
        {
            long n = cin.nextLong();
            if(Arrays.binarySearch(f,n)>=0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
