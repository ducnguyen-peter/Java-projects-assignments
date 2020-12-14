import java.util.*;
public class java35_uniqueWords {
    public static void solution(String a, String b)
    {
        StringTokenizer st1 = new StringTokenizer(a);
        StringTokenizer st2 = new StringTokenizer(b);
        HashMap<String, Integer> map = new HashMap<>();
        while(st2.hasMoreTokens())
        {
            String tmp = st2.nextToken();
            map.put(tmp, 1);
        }
        Vector<String> res = new Vector<>();
        while(st1.hasMoreTokens())
        {
            String tmp = st1.nextToken();
            if(!map.containsKey(tmp))
            {
                res.add(tmp);
                map.put(tmp, 1);
            }
        }
        Collections.sort(res);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        cin.nextLine();
        while(t-->0)
        {
            String a = cin.nextLine(), b = cin.nextLine();
            solution(a,b);
            System.out.println();
        }
    }
}
