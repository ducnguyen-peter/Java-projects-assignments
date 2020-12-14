import java.util.*;
public class bai10_lcmgcd {
    public static long gcd(long a, long b)
    {
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-->0)
        {
            long a = cin.nextLong(), b = cin.nextLong();
            System.out.println((a*b)/gcd(a,b)+" "+gcd(a,b));
        }
    }
}
