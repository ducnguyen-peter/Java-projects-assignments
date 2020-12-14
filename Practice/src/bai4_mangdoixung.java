import java.util.Scanner;
public class bai4_mangdoixung {
    public static boolean solution(long[] A, int n){
        int l = 0, r = n-1;
        while(l<=r)
        {
            if(A[l]==A[r])
            {
                l++; r--;
            }
            else return false;
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t>0)
        {
            int n = cin.nextInt();
            long[] a; a = new long[n];
            for(int i = 0; i < n; i++)
                a[i] = cin.nextLong();
            if(solution(a, n)) System.out.println("YES");
            else System.out.println("NO");
            t--;
        }
    }
}
