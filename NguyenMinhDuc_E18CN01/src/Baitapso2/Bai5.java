package Baitapso2;
import java.util.*;

public class Bai5 {
    public static void execute() {
        int[] a= new int[100001];
        for(int i = 1; i <= 100000; i++) a[i] = i;
        for(int i = 2; i <= 100000; i+=2) a[i] = 2;
        for(int i = 3; i*i<=100000; i++)
        {
            if(a[i]==i)
                for(int j = i*i; j <= 100000; j+=i)
                    if(a[j]==j) a[j] = i;
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StackOfIntegers res = new StackOfIntegers();
        while(n!=1)
        {
            res.push(a[n]);
            n /= a[n];
        }
        while(!res.isEmpty() && res.peak()!=Integer.MIN_VALUE)
        {
            System.out.print(res.peak()+" ");
            res.pop();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        execute();
    }
}
