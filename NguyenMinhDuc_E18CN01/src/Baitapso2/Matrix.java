package Baitapso2;

import java.util.Scanner;

public class Matrix {
        private float[][] a;
        public Matrix()
        {
            a = new float[3][3];
        }
        public Matrix(int rows, int cols)
        {
            a = new float[rows][cols];
        }
        public Baitapso2.Matrix add(Baitapso2.Matrix m)
        {
            if(this.a.length!=m.a.length||this.a[0].length!=m.a[0].length)
            {
                throw new UnsupportedOperationException("Cannot add matrix with different sizes");
            }
            Baitapso2.Matrix result = new Baitapso2.Matrix(this.a.length, this.a[0].length);
            for(int i = 0; i < this.a.length; i++)
            {
                for (int j = 0; j < this.a[0].length; j++)
                {
                    result.a[i][j] = this.a[i][j]+m.a[i][j];
                }
            }
            return result;
        }
        public Baitapso2.Matrix sub(Baitapso2.Matrix m)
        {
            if(this.a.length!=m.a.length||this.a[0].length!=m.a[0].length)
            {
                throw new UnsupportedOperationException("Cannot sub matrices with different sizes");
            }
            Baitapso2.Matrix result = new Baitapso2.Matrix(this.a.length, this.a[0].length);
            for(int i = 0; i < this.a.length; i++)
            {
                for (int j = 0; j < this.a[0].length; j++)
                {
                    result.a[i][j] = this.a[i][j]-m.a[i][j];
                }
            }
            return result;
        }
        public Baitapso2.Matrix neg()
        {
            Baitapso2.Matrix result = this;
            for(int i = 0; i < this.a.length; i++)
            {
                for(int j = 0; j < this.a[0].length; j++)
                {
                    result.a[i][j]*=-1;
                }
            }
            return result;
        }
        public Baitapso2.Matrix transpose()
        {
            int row = this.a.length, col = this.a[0].length;
            Baitapso2.Matrix result = new Baitapso2.Matrix(col, row);
            for(int i = 0; i<row; i++)
            {
                for(int j = 0; j<col; j++)
                {
                    result.a[j][i] = this.a[i][j];
                }
            }
            return result;
        }
        public Baitapso2.Matrix mul(Baitapso2.Matrix m)
        {
            int row = this.a.length, col = this.a[0].length;
            if(col!=m.a.length)
            {
                throw new UnsupportedOperationException("Cannot Multiply matrices m1 and m2 when number of cols of m1 is different from m2 numbers of rows");
            }
            Baitapso2.Matrix result = new Baitapso2.Matrix(row, row);
            for(int i = 0; i < row; i++)
            {
                for(int j = 0; j < m.a[0].length; j++)
                {
                    for(int k = 0; k < col; k++)
                    {
                        result.a[i][j] += this.a[i][k]*m.a[k][j];
                    }
                }
            }
            return result;
        }
        public void print()
        {
            int row = this.a.length, col = this.a[0].length;
            for(int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    System.out.print(this.a[i][j]+" ");
                }
                System.out.println();
            }
        }
        public void input()
        {
            Scanner in = new Scanner(System.in);
            int row = this.a.length, col = this.a[0].length;
            for(int i = 0; i < row; i++)
                for(int j = 0; j < col; j++)
                    this.a[i][j] = in.nextFloat();
        }
}
