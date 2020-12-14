import java.util.*;
public class java18_capsotongbangk {
    public static long solution(long []a, long k)
    {
        HashMap<Long, Integer> m = new HashMap<>();
        for(int i = 0; i < a.length; i++)
        {
            if(!m.containsKey(a[i]))
                m.put(a[i], 0);
            m.put(a[i], m.get(a[i])+1);
        }
        long ans = 0;
        for(int i = 0; i<a.length; i++)
        {
            if(m.get(k-a[i])!=null) ans+=m.get(k-a[i]);
            if(k-a[i]==a[i]) ans--;
        }
        if(ans==0) return -1;
        return ans/2;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            long k = in.nextLong();
            long []a = new long [n];
            for(int i = 0; i < n; i++) a[i] = in.nextLong();
            System.out.println(solution(a,k));
        }
    }
}
