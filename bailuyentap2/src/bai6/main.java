package bai6;

import bai4.StackOfIntergers;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StackOfIntergers st = new StackOfIntergers();
        while(n != 0){
            st.push(n%2);
            n/=2;
        }
        while (st.getSize() > 0){
            System.out.print(st.pop());
        }
    }
}
