import java.util.*;
public class java21_tichmatran {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int x = 0;
        while(x<t)
        {
            int n = cin.nextInt(), m = cin.nextInt();
            int a[][] = new int[n][m], c[][] = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < m; j++)
                    a[i][j] = cin.nextInt();
            for(int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    for (int k = 0; k < m; k++)
                        c[i][j] += a[i][k] * a[j][k];
            System.out.println("Test "+(x+1)+ ":");
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(c[i][j]+" ");
                System.out.println();
            }
            x++;
        }
    }
}
