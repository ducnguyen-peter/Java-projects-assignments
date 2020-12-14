import java.util.*;
public class bai6_interchangesort {
    public static void intersort(int[] a, int n)
    {
        int buoc = 1;
        for(int i = 0; i < n - 1; i++)
        {
            boolean sorted = true;
            for(int j = i+1; j < n; j++)
            {
                if(a[j]<a[i])
                {
                    int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
                    sorted = false;
                }
            }
            if(sorted) break;
            System.out.print("Buoc "+ (buoc++) + ": ");
            for(int j = 0; j < n; j++) System.out.print(a[j]+" ");
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int [] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = cin.nextInt();
        intersort(a,n);
    }
}
