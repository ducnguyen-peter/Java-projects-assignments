package Baitapso2;

import java.util.*;
public class Bai12 {
    public static void execute()
    {
        Scanner in = new Scanner(System.in);
        int i = 0;
        Matrix m1, m2;
        while(i!=4)
        {
            System.out.print("select actions: ");
            i = in.nextInt();
            if(i==1)
            {
                System.out.println("Type in size of the first matrix");
                int row = in.nextInt(), col = in.nextInt();
                m1 = new Matrix(row, col);
                System.out.println("Data for m1: ");
                m1.input();
                System.out.println("Type in size of the second matrix");
                row = in.nextInt(); col = in.nextInt();
                m2 = new Matrix(row, col);
                System.out.println("Data for m2: ");
                m2.input();
                System.out.println("add: "); m1.add(m2).print();
                System.out.println("sub: "); m1.sub(m2).print();
            }
            if(i==2)
            {
                System.out.println("Type in size of the first matrix");
                int row = in.nextInt(), col = in.nextInt();
                m1 = new Matrix(row, col);
                System.out.println("Data for m1: ");
                m1.input();
                System.out.println("Type in size of the second matrix");
                row = in.nextInt(); col = in.nextInt();
                m2 = new Matrix(row, col);
                System.out.println("Data for m2: ");
                m2.input();
                System.out.println("Multiply: "); m1.mul(m2).print();
            }
            if(i==3)
            {
                System.out.println("Type in size of the matrix");
                int row = in.nextInt(), col = in.nextInt();
                m1 = new Matrix(row, col);
                m1.input();
                System.out.println("Transpose: "); m1.transpose().print();
            }
        }
    }

    public static void main(String[] args) {
        execute();
    }
}
