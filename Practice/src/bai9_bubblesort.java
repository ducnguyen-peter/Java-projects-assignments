import java.util.*;
public class bai9_bubblesort {
    public static void solution(int a[])
    {
        int n = a.length;
        for(int i = 0; i < n; i++)
        {
            boolean sorted = true;
            for(int j = 1; j<n-i; j++)
            {
                if(a[j-1]>a[j])
                {
                    int tmp = a[j]; a[j] = a[j-1]; a[j-1] = tmp;
                    sorted = false;
                }
            }
            if(sorted) break;
            System.out.print("Buoc " + (i+1) + ": ");
            for(int j = 0; j<n; j++)
            {
                System.out.print(a[j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
            int n = cin.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++) a[i] = cin.nextInt();
            solution(a);

    }
}
