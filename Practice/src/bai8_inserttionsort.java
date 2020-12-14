import java.util.*;
public class bai8_inserttionsort {
    public static void solution(int a[])
    {
        int n = a.length;
        int key;
        for(int i = 0; i < n; i++)
        {
            key = a[i];
            int j = i-1;
            while(j>=0 && a[j]>key)
            {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
            System.out.print("Buoc "+i+": ");
            for(j = 0; j <= i; j++) System.out.print(a[j]+" ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int a[] = new int [n];
        for(int i = 0; i < n; i++) a[i] = cin.nextInt();
        solution(a);
    }
}
