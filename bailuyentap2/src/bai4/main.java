package bai4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[10005];
        for(int i = 2; i <= 10000; i++){
            a[i] = 1;
        }
        for(int i = 2; i <= 10000; i++){
            if(a[i] == 1){
                for(int j = i*i; j <= 10000; j+=i){
                    a[j] = 0;
                }
            }
        }
        System.out.println("Nhập n: ");
        int n = scanner.nextInt();
        StackOfIntergers st = new StackOfIntergers(n);
        for(int i = 2; i < n; i++){
            if(a[i] == 1){
                st.push(i);
            }
        }
        System.out.println("Các số nguyên tố nhỏ hơn "+n+": ");
        while (st.getSize() > 0){
            System.out.print(st.pop()+" ");
        }
    }
}
