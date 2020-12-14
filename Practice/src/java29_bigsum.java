import java.math.BigInteger;
import java.util.*;
public class java29_bigsum {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        cin.nextLine();
        while(t-->0)
        {
            BigInteger a = cin.nextBigInteger(), b = cin.nextBigInteger();
            System.out.println(a.add(b));
        }
    }
}
