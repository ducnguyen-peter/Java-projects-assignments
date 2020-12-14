import java.util.*;
public class java28_bigdiff {
    public static boolean smaller(String a, String b)
    {
        if(a.length()<b.length()) return true;
        if(a.length()>b.length()) return false;
        for(int i = 0; i < a.length(); i++)
        {
            if(a.charAt(i)<b.charAt(i)) return true;
            else if(a.charAt(i)>b.charAt(i)) return false;
        }
        return false;
    }
    public static String solution(String a, String b)
    {
        if(smaller(a,b))
        {
            String tmp = a; a = b; b = tmp;
        }
        StringBuilder a1 = new StringBuilder(a), b1 = new StringBuilder(b), result = new StringBuilder();
        while(a1.toString().length()<b1.toString().length()) a1.insert(0, '0');
        while(b1.toString().length()<a1.toString().length()) b1.insert(0, '0');
        a = a1.toString(); b = b1.toString();
        int nho = 0;
        for(int i = a.length()-1; i >= 0; i--)
        {
            int so = a.charAt(i)-b.charAt(i)-nho;
            if(so<0)
            {
                result.append((char)(so+10+'0'));
                nho = 1;
            }
            else
            {
                result.append((char)(so+'0'));
                nho = 0;
            }
        }
        return result.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        cin.nextLine();
        while(t-->0)
        {
            String a = cin.next(), b = cin.next();
            System.out.println(solution(a,b));
        }
    }
}
