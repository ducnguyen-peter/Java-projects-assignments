package Baitapso2;
import java.util.*;
public class Bai8 {
    public static void main(String[] args) {
        execute();
    }

    public static void execute() {
        Scanner in = new Scanner(System.in);
        String exp = in.nextLine();
        System.out.println(evaluate(exp));
    }
    public static int pre(char opr)
    {
        if(opr=='+'||opr=='-') return 1;
        if(opr=='*'||opr=='/') return 2;
        return -1;
    }
    private static String evaluate(String exp) {
        String res = new String("");
        StackOfChars st = new StackOfChars();
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                res+=c;
            }
            else if(c=='(') st.push(c);
            else if(c==')')
            {
                while(!st.isEmpty() && st.peak()!='(') res+=st.pop();
                st.pop();
            }
            else
            {
                while(!st.isEmpty() && pre(c)<=pre(st.peak()))
                {
                    res+=st.pop();
                }
                st.push(c);
            }
        }
        while(!st.isEmpty())
        {
            if(st.peak()=='(') return ":)";
            res+=st.pop();
        }
        return res;
    }
}
