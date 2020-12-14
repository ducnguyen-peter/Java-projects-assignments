import java.util.*;
public class bai7_selectionsort {
    public static void solution(int a[])
    {
        int n = a.length;
        int min, buoc = 1;
        for(int i = 0; i < n-1; i++)
        {
            min = i;
            boolean sorted = true;
            for(int j = i+1; j < n; j++)
            {
                if(a[j]<a[min])
                {
                    min = j;
                    sorted = false;
                }
            }
            if(sorted) break;
            int tmp = a[i]; a[i] = a[min]; a[min] = tmp;
            System.out.print("Buoc " + (buoc++) + ": ");
            for(int j = 0; j < n; j++)
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
        for(int i = 0 ; i < n; i++) a[i] = cin.nextInt();
        solution(a);
    }
}
