package Baitapso2;
import java.util.*;
public class Test {
    public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
        StackOfIntegers values = new StackOfIntegers();

        // Stack for Operators: 'ops'
        StackOfChars ops = new StackOfChars();

        for (int i = 0; i < tokens.length; i++)
        {
            // Current token is a whitespace, skip it
//            if (tokens[i] == ' ')
//                continue;

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                i--;
                values.push(Integer.parseInt(sbuf.toString()));
            }

            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peak() != '(') {
                    int val2 = values.peak();
                    values.pop();
                    int val1 = values.peak();
                    values.pop();
                    char op = ops.peak();
                    ops.pop();
                    values.push(applyOp(op, val2, val1));
                }
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.isEmpty() && hasPrecedence(tokens[i], ops.peak())) {
                    int val1 = values.peak();
                    values.pop();
                    int val2 = values.peak();
                    values.pop();
                    char op = ops.peak();
                    ops.pop();
                    values.push(applyOp(op, val2, val1));
                }
                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.isEmpty()) {
            int val1 = values.peak();
            values.pop();
            int val2 = values.peak();
            values.pop();
            char op = ops.peak();
            ops.pop();
            values.push(applyOp(op, val2, val1));
        }
        // Top of 'values' contains result, return it
        return values.peak();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    // Driver method to test above methods
    public static void main(String[] args)
    {
//        Scanner in = new Scanner(System.in);
//        String exp = in.nextLine();
        System.out.println(Test.evaluate("((3+7)*(9-(6-2)))"));
        System.out.println(Test.evaluate("100*2+12"));
        System.out.println(Test.evaluate("100*(2+12)"));
        System.out.println(Test.evaluate("100*(2+12)/14"));
    }
}
