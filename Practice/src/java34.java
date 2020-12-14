import java.util.*;
public class java34 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        cin.nextLine();
        while(t-->0)
        {
            String s = cin.nextLine();
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String s1 = new String(tmp);
            int so = 0;
            for(int i = 0; i < s1.length(); i++)
            {
                if(s1.charAt(i)>='0'&&s1.charAt(i)<='9')
                {
                    so+=(int)(s1.charAt(i)-'0');
                }
                else System.out.print(s1.charAt(i));
            }
            System.out.println(so);
        }
    }
}
