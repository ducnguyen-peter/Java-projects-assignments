import java.util.*;
public class java37_tuThuannghich {
    public static boolean check(String a)
    {
        for(int i = 0, j = a.length()-1; i < a.length() && j>=0; i++, j--)
        {
            if(a.charAt(i)!=a.charAt(j)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String t = cin.nextLine();
//        cin.skip("\n");
        StringTokenizer st = new StringTokenizer(t);
        String ans = "";
        int freq = 0;
        HashMap<String, Integer> map = new HashMap<>();
        Stack res = new Stack<>();
        while(st.hasMoreTokens())
        {
            String tmp = st.nextToken();
            if(ans.length()<=tmp.length() && check(tmp))
            {
                res.pop();
                res.push(tmp);
                if(!map.containsKey(tmp))
                    map.put(tmp, 0);
                map.put(tmp, map.get(tmp)+1);
                ans = tmp;
                freq = map.get(tmp);
            }
        }
        System.out.println(ans+" "+freq);
    }
}
/*    AAA BAABA HDHDH ACBSD SRGTDH DDDDS DUAHD AAA AD DA HDHDH AAA AAA AAA AAA DDDAS HDHDH HDH AAA AAA AAA AAA AAA AAA AAA AAA DHKFKH DHDHDD HDHDHD DDDHHH HHHDDD TDTD*/