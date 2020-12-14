import java.util.*;
public class java22_beauty1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        cin.nextLine();
        while(t-->0)
        {
            String s = cin.next();
            boolean kt = true;
            for(int i = 0, j = s.length()-1; i < s.length()&&j>=0; i++, j--)
            {
                if(s.charAt(i)!=s.charAt(j)||s.charAt(i)%2==1||s.charAt(j)%2==1)
                {
                    kt = false;
                    break;
                }
            }
            if(kt) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
