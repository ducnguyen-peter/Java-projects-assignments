import java.util.*;
public class java27_loaibo100 {
    public static int solution(String s)
    {
        StringBuilder st = new StringBuilder(s);
        int n = s.length();
        while(true)
        {
            int t = st.indexOf("100");
            if(t!=-1) st.delete(t, t+3);
            else return n-st.toString().length();
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-->0)
        {
            String s = cin.next();
            System.out.println(solution(s));
        }
    }
}
