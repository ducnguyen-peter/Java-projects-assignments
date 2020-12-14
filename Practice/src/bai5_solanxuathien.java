import java.util.Scanner;
public class bai5_solanxuathien {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int x = 0;
        while(x<t) {
            int n = cin.nextInt();
            int [] a = new int[n];
            int [] d = new int[100000];
            boolean[] vis = new boolean[100000];
            for(int i = 0; i < n; i++) {
                a[i] = cin.nextInt();
                d[a[i]]++;
            }
            System.out.println("Test "+(x+1)+":");
            for(int i = 0; i < n; i++)
            {
                if(!vis[a[i]]&&d[a[i]]>0)
                {
                    vis[a[i]] = true;
                    System.out.println(a[i]+" xuat hien "+d[a[i]]+" lan");
                }
            }
            x++;
        }
    }
}
