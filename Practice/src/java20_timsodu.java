import java.util.*;
public class java20_timsodu {
    public static int solution(String n)
    {
        long x = (n.charAt(n.length()-1)-'0');
        if(n.length()>1) x+=((n.charAt(n.length()-2)-'0'))*10;
        if(x%4==0) return 4;
        return 0;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        cin.nextLine();
        while(t-->0)
        {
            String n = cin.next();
            System.out.println(solution(n));
        }
    }
}
