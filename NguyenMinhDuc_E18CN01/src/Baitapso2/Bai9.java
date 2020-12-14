package Baitapso2;
import java.util.*;
public class Bai9 {
    public static void execute() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        StackOfChars st = new StackOfChars();
        while((n)>0)
        {
            if(n%k<=9)
                st.push((char) ((n % k) + '0'));
            else
                st.push((char)((n%k)-10+'A'));
            n/=k;
        }
        while(!st.isEmpty())
        {
            System.out.print(st.peak());
            st.pop();
        }
    }
}
