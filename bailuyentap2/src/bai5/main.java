package bai5;

import bai4.StackOfIntergers;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StackOfIntergers st = new StackOfIntergers(n);
        for(int i = 2; i <= Math.sqrt(n); i++){
            while(n%i == 0){
                st.push(i);
                n/=i;
            }
        }
        if(n > 1) st.push(n);
        while (st.getSize() > 0){
            System.out.print(st.pop() + " ");
        }
    }
}
