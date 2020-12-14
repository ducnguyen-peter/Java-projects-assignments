import java.util.*;
public class bai14_matrixmax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        Vector<Long> Row = new Vector<>();
        Vector<Long> Col = new Vector<>();
        while(t-->0)
        {
            long a = in.nextLong(), b = in.nextLong();
            Row.add(a); Col.add(b);
        }
        System.out.println(Collections.min(Row)*Collections.min(Col));
    }
}
