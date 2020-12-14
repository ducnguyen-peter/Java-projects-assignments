import java.util.Scanner;
public class bai3_thuasonguyento {
    public static void solution(long n)
    {
        long dem = 0;
        while(n%2==0) {
            dem++;
            n/=2;
        }
        if(dem>0) System.out.print(2+"("+dem+") ");

        for(long i = 3; i*i<=n; i+=2)
        {
            dem = 0;
            while(n%i==0)
            {
                dem++;
                n/=i;
            }
            if(dem>0) System.out.print(i+"("+dem+") ");
        }
        if(n>1) System.out.print(n+"(1)");
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int x = 0;
        while(x<t)
        {
            long  n = cin.nextLong();
            System.out.print("Test "+(x+1)+": ");
            solution(n);
            System.out.print("\n");
            x++;
        }
    }
}
