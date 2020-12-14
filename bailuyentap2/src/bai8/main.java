package bai8;

import bai7.StackOfChars;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackOfChars st = new StackOfChars();
        String s = scanner.nextLine();
        String kq = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') kq+= String.valueOf(s.charAt(i));
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') kq+= String.valueOf(s.charAt(i));
            else if(String.valueOf(s.charAt(i)).equals("(")) st.push(s.charAt(i));
            else if(String.valueOf(s.charAt(i)).equals(")")){
                while(st.getSize()>0 && String.valueOf(st.peak()).equals("(") == false){
                    kq += String.valueOf(st.pop());
                }
                st.pop();
            }
            else if(String.valueOf(s.charAt(i)).equals("+")| String.valueOf(s.charAt(i)).equals("-")|
                    String.valueOf(s.charAt(i)).equals("*") |
                    String.valueOf(s.charAt(i)).equals("/")|String.valueOf(s.charAt(i)).equals("^")){
                while(st.getSize()>0 && degree(s.charAt(i)) <= degree(st.peak())){
                    kq+= String.valueOf(st.pop());
                }
                st.push(s.charAt(i));
            }
        }
        while (st.getSize() > 0){
            if(String.valueOf(st.peak()).equals("(") == false) kq+= String.valueOf(st.peak());
            st.pop();
        }
        System.out.println(kq);
    }

    public static int degree(char charAt) {
        if(String.valueOf(charAt).equals("^")) return 5;
        else if(String.valueOf(charAt).equals("*")| String.valueOf(charAt).equals("/")) return 4;
        else if(String.valueOf(charAt).equals("+") | String.valueOf(charAt).equals("-")) return 3;
        return  2;
    }
}

