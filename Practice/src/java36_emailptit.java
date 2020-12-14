import java.util.*;
public class java36_emailptit {
    public static String solution(String a)
    {
        StringBuilder s = new StringBuilder();
        StringTokenizer st = new StringTokenizer(a);
        Vector<String> v = new Vector<>();
        while(st.hasMoreTokens())
        {
            String tmp = st.nextToken();
            v.add(tmp);
        }
        int n = v.size();
        for(int i = 0; i < v.get(n-1).length(); i++)
        {
            s.append(Character.toLowerCase(v.get(n-1).charAt(i)));
        }
        for(int i = 0; i < n-1; i++)
        {
            s.append(Character.toLowerCase(v.get(i).charAt(0)));
        }
        return s.toString();
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        cin.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        while(t-->0)
        {
            String a = cin.nextLine();
            String b = solution(a);
            if(!map.containsKey(b))
            {
                map.put(b,1);
                System.out.println(b+"@ptit.edu.vn");
            }
            else
            {
                map.put(b, map.get(b)+1);
                System.out.println(b+map.get(b)+"@ptit.edu.vn");
            }
        }
    }
}
