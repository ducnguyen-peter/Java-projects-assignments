package bai14;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SoPhuc[] s = new SoPhuc[2];
        s[0] = new SoPhuc();
        s[1] = new SoPhuc();
        System.out.println("Nhập vào hai số phức: ");
        System.out.println("Nhập số thứ nhất: ");
        s[0].nhap();
        System.out.println("Nhập số thứ hai: ");
        s[1].nhap();
        System.out.println("Tổng hai số phức: ");
        SoPhuc kqAdd = s[0].cong(s[1]);
        kqAdd.hien();
        System.out.println("Hiệu hai số phức: ");
        SoPhuc kqSub = s[0].tru(s[1]);
        kqSub.hien();
        System.out.println("Tích hai số phức: ");
        SoPhuc kqMul = s[0].nhan(s[1]);
        kqMul.hien();
        System.out.println("Thương hai số phức: ");
        SoPhuc kqDiv = s[0].chia(s[1]);
        kqDiv.hien();
        System.out.println("Nghịch đảo của số phức thứ nhất: ");
        SoPhuc nd1 = s[0].nghichDao();
        nd1.hien();
        System.out.println("Nghịch đảo của số phức thứ hai: ");
        SoPhuc nd2 = s[1].nghichDao();
        nd2.hien();
        if(s[0].lonHon(s[1])) System.out.println("Số phức thứ nhất lớn hơn!");
        else if(s[0].nhoHon(s[1])) System.out.println("Số phức thứ hai lớn hơn!");
        else System.out.println("Hai số phức bằng nhau!");
    }
}
