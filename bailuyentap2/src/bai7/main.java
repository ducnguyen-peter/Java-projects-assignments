package bai7;

import bai4.StackOfIntergers;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = infToPost(s);
        StackOfIntergers stk = new StackOfIntergers(100);
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(String.valueOf(s.charAt(i)).equals("+")| String.valueOf(s.charAt(i)).equals("-")|
                    String.valueOf(s.charAt(i)).equals("*")|
                    String.valueOf(s.charAt(i)).equals("/")|
                    String.valueOf(s.charAt(i)).equals("^")|
                    String.valueOf(s.charAt(i)).equals("%")){
                int a = stk.pop();
                int b = stk.pop();
                int tmp = 0;
                if(String.valueOf(s.charAt(i)).equals("+")) tmp = b+a;
                else if(String.valueOf(s.charAt(i)).equals("-")) tmp = b-a;
                else if(String.valueOf(s.charAt(i)).equals("*")) tmp = b*a;
                else if(String.valueOf(s.charAt(i)).equals("/")) tmp = b/a;
                else if(String.valueOf(s.charAt(i)).equals("%")) tmp = b%a;
                else if(String.valueOf(s.charAt(i)).equals("^")){
                    tmp = b;
                    for (int j = 0; j < a-1; j++){
                        tmp*=b;
                    }
                }
                stk.push(tmp);
            }
            else {
                int tmp = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    tmp = 10*tmp + (s.charAt(i) - '0');
                    i++;
                }
                if(String.valueOf(s.charAt(i)).equals("#") == false) i--;
                stk.push(tmp);
            }
        }
        System.out.println(stk.peak());
    }
    public static int degree(char c){
        if(String.valueOf(c).equals("^")) return 5;
        else if(String.valueOf(c).equals("*") | String.valueOf(c).equals("/")) return 4;
        else if(String.valueOf(c).equals("+") | String.valueOf(c).equals("-")) return 3;
        return 2;
    }
    public static String infToPost(String s){
        String res = "";
        StackOfChars stk = new StackOfChars(100);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') res+=String.valueOf(s.charAt(i));
            else if(String.valueOf(s.charAt(i)).equals("(")) stk.push(s.charAt(i));
            else if(String.valueOf(s.charAt(i)).equals(")")){
                while (stk.getSize() > 0 && String.valueOf(stk.peak()).equals("(")==false){
                    res += String.valueOf(stk.pop());
                }
                stk.pop();
            }
            else if(String.valueOf(s.charAt(i)).equals("+")|
                    String.valueOf(s.charAt(i)).equals("-")|
                    String.valueOf(s.charAt(i)).equals("*")|
                    String.valueOf(s.charAt(i)).equals("/")|
                    String.valueOf(s.charAt(i)).equals("^")|
                    String.valueOf(s.charAt(i)).equals("%")){
                if(res.charAt(res.length()-1) >= '0' && res.charAt(res.length()-1) <= '9') res+="#";
                while (stk.getSize() > 0 && degree(stk.peak()) >= degree(s.charAt(i))){
                    res+=String.valueOf(stk.pop());
                }
                stk.push(s.charAt(i));
            }
        }
        while (stk.getSize() > 0){
            if(String.valueOf(stk.peak()).equals("(") == false) res+=String.valueOf(stk.peak());
            stk.pop();
        }
        return res;
    }
}
