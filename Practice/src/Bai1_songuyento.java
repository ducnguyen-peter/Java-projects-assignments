import java.util.Scanner;
public class Bai1_songuyento {
    public static boolean check(long n)
    {
        if(n<2) return false;
        if(n==2) return true;
        for(int i = 2; i*i <= n; i++)
        {
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0)
        {
            long n = in.nextInt();
            if(check(n)) System.out.println("YES");
            else System.out.println("NO");
            t--;
        }
    }
}
