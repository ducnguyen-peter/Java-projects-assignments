package Baitapso2;
import java.util.*;
public class Bai7 {
    public static int pre(char opr)
    {
        if(opr=='+'||opr=='-') return 1;
        if(opr=='x'||opr=='/') return 2;
        return 0;
    }
    public static int calculate(int a, int b, char opr)
    {
        switch (opr)
        {
            case '+': return a + b;
            case '-': return a - b;
            case 'x': return a * b;
            case '/':
                if(b==0)
                    throw new
                        UnsupportedOperationException("Cannot divide by zero");
                return a/b;
        }
        return 0;
    }
    public static boolean isDigit(char x)
    {
        return x>='0'&&x<='9';
    }
    public static int evaluate(String exp)
    {
        StackOfIntegers value = new StackOfIntegers();
        StackOfChars op = new StackOfChars();
        for(int i = 0; i < exp.length(); i++)
        {
            if(exp.charAt(i)==' ') continue;
            else if(isDigit(exp.charAt(i)))
            {
                int tmp = 0;
                while(i<exp.length() && isDigit(exp.charAt(i))){
                    tmp = tmp*10+exp.charAt(i)-'0';
                    i++;
                }
                i--;
                value.push(tmp);
//                System.out.println("push value: "+tmp);
            }
            else if(exp.charAt(i)=='(')
            {
//                System.out.println("push ngoac: "+exp.charAt(i));
                op.push(exp.charAt(i));
            }
            else if(exp.charAt(i)==')')
            {
                while(!op.isEmpty() && op.peak()!='(')
                {
                    int tmp2 = value.peak(); value.pop();
                    int tmp1 = value.peak(); value.pop();
                    char opr = op.peak(); op.pop();
//                    System.out.println("push value: "+calculate(tmp1,tmp2,opr));
                    value.push(calculate(tmp1,tmp2,opr));
                }
                if(!op.isEmpty()) op.pop();
            }
            else if(exp.charAt(i)=='+'||exp.charAt(i)=='-'||exp.charAt(i)=='x'||exp.charAt(i)=='/')
            {
                while(!op.isEmpty() && pre(exp.charAt(i))<=pre(op.peak()))
                {
                    int tmp2 = value.peak(); value.pop();
                    int tmp1 = value.peak(); value.pop();
                    char opr = op.peak(); op.pop();
//                    System.out.println("push value: "+calculate(tmp1,tmp2,opr));
                    value.push(calculate(tmp1,tmp2,opr));
                }
//                System.out.println("push op: "+exp.charAt(i));
                op.push(exp.charAt(i));
            }
        }
        while(!op.isEmpty())
        {
            int tmp2 = value.peak(); value.pop();
            int tmp1 = value.peak(); value.pop();
            char opr = op.peak(); op.pop();
//            System.out.println("push value: "+calculate(tmp1,tmp2,opr));
            value.push(calculate(tmp1,tmp2,opr));
        }
        return value.peak();
    }
    public static void execute() {
        Scanner in = new Scanner(System.in);
        String exp = in.nextLine();
        System.out.println(evaluate(exp));
    }

    public static void main(String[] args) {
        execute();
    }
}
//((3+7)x(9-(6-2)))
//( ( 3 + 7 ) x ( 9 - ( 6 - 2 ) ) )