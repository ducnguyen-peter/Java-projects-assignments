import java.util.*;
public class java26_chuanhoaxau2 {
    public static String solution(String S)
    {
        StringBuilder kq = new StringBuilder();
        StringTokenizer st = new StringTokenizer(S);
        String tmp = st.nextToken();
        while(st.hasMoreTokens())
        {
            String t = st.nextToken();
            kq.append(Character.toUpperCase(t.charAt(0)));
            for(int i = 1; i < t.length(); i++)
            {
                kq.append(Character.toLowerCase(t.charAt(i)));
            }
            kq.append(" ");
        }
        kq.deleteCharAt(kq.length()-1);
        kq.append(", ");
        for(int i = 0; i < tmp.length(); i++)
        {
            kq.append(Character.toUpperCase(tmp.charAt(i)));
        }
        return kq.toString();
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = Integer.parseInt(cin.nextLine());
        while(t>0)
        {
            String s = cin.nextLine();
            System.out.println(solution(s));
            t--;
        }
    }
}
