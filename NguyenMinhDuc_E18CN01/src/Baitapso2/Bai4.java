package Baitapso2;

import java.util.Arrays;
import java.util.Scanner;

public class Bai4 {
    public static void execute() {
        boolean[] a = new boolean[100000];
        Arrays.fill(a, true);
        a[0] = a[1] = false;
        for (int i = 2; i * i <= 100000; i++) {
            if (a[i]) {
                for (int j = i * i; j < 100000; j += i) {
                    a[j] = false;
                }
            }
        }
        Scanner in = new Scanner(System.in);
        StackOfIntegers st = new StackOfIntegers();
        int n = in.nextInt();
        for (int i = 0; i <= n; i++) {
            if (a[i]) st.push(i);
        }
        while (!st.isEmpty()) {
            System.out.print(st.peak()+" ");
            st.pop();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        execute();
    }
}
