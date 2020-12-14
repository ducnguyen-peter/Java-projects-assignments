import java.math.BigInteger;
import java.util.*;
public class java33_chiahet11 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t-->0)
        {
            BigInteger n = cin.nextBigInteger();
            BigInteger i = new BigInteger("11");
            BigInteger[] res = n.divideAndRemainder(i);
            if(Integer.parseInt(res[1].toString())==0) System.out.println(1);
            else System.out.println(0);
        }
    }
}
