package bai9;

import bai7.StackOfChars;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cs = scanner.nextInt();
        StackOfChars st = new StackOfChars();
        while(n > 0){
            int du = n%cs;
            if(du < 10) st.push((char)(du+'0'));
            else {
                st.push((char)('A'+du-10));
            }
            n/=cs;
        }
        while (st.getSize()>0){
            System.out.print(st.pop());
        }
    }
}
