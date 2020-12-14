package Baitapso2;
import java.util.*;
public class Bai6 {
    public static void execute()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StackOfIntegers res = new StackOfIntegers();
        while(n>0)
        {
            res.push(n%2);
            n/=2;
        }
        while(!res.isEmpty())
        {
            System.out.print(res.peak());
            res.pop();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        execute();
    }
}
