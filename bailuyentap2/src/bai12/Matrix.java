package bai12;

import java.util.Scanner;

public class Matrix {
    private float[][] a;

    public Matrix() {
        a = new float[3][3];
    }

    public Matrix(int rows, int cols) {
        a = new float[rows][cols];
    }

    public Matrix add(Matrix m) {
        if(checkSubOrAdd(m)){
            Matrix kq = new Matrix(a.length, a[0].length);
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[0].length; j++){
                    kq.a[i][j] = this.a[i][j] + m.a[i][j];
                }
            }
            return kq;
        }
        else return null;
    }

    private boolean checkSubOrAdd(Matrix m) {
        if(m.a.length == this.a.length && m.a[0].length == this.a[0].length) return true;
        return false;
    }

    public Matrix sub(Matrix m) {
        if(checkSubOrAdd(m)){
            Matrix kq = new Matrix(a.length, a[0].length);
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[0].length; j++){
                    kq.a[i][j] = this.a[i][j] - m.a[i][j];
                }
            }
            return kq;
        }
        else return null;
    }

    public Matrix neg() {
        Matrix m = new Matrix(a.length, a[0].length);
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                m.a[i][j] = -a[i][j];
            }
        }
        return m;
    }

    public Matrix transpose() {
        Matrix m = new Matrix(a[0].length, a.length);
        for (int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                m.a[j][i] = this.a[i][j];
            }
        }
        return m;
    }

    public Matrix mul(Matrix m) {
        if(checkMul(m)){
            Matrix kq = new Matrix(this.a.length, m.a[0].length);
            for(int i = 0; i < this.a.length; i++){
                for(int j = 0; j < m.a[0].length; j++){
                    kq.a[i][j] = 0;
                    for(int k = 0; k  < this.a[0].length; k++){
                        kq.a[i][j] += this.a[i][k] * m.a[k][j];
                    }
                }
            }
            return kq;
        }
        else return null;
    }

    private boolean checkMul(Matrix m) {
        if(this.a[0].length == m.a.length) return true;
        return false;
    }

    public void print() {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = scanner.nextFloat();
            }
        }
    }
}
