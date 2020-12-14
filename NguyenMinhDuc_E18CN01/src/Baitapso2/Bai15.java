package Baitapso2;
import java.util.*;
import java.io.*;
public class Bai15 {
    public static void main(String[] args) throws IOException{
        FileInputStream input = new FileInputStream(new File("SV.INP"));
        SinhVien2 tmp;
        int ma = 0;
        String ten = null, lop = null;
        double diem = 0;
        ArrayList<SinhVien2> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i, j = 0, att_num = 4;
        boolean tieptuc = true;
        while((i = input.read())!=-1)
        {
            if((char)i == '\n')
            {
                if(j==0)
                {
                    tieptuc = true;
                    try{
                        ma = Integer.parseInt(sb.toString());
                    }
                    catch (NumberFormatException e){
                        tieptuc = false;
                    }
                    if(sb.toString().length()!=4) tieptuc = false;
                }
                if(j==1){
                    if(sb.length()==0) tieptuc = false;
                }
                if(j==2)
                {
                    if(sb.length()==0) tieptuc = false;
                }
                if(j==3){
                    try{
                        diem = Double.parseDouble(sb.toString());
                    }
                    catch(NumberFormatException e){
                        tieptuc = false;
                    }
                }
                if(tieptuc)
                {
                    switch (j){
                        case 1:
                            ten = sb.toString();
                            break;
                        case 2:
                            lop = sb.toString();
                            break;
                        case 3:
                            tmp = new SinhVien2(ma, ten, lop, diem);
                            list.add(tmp);
                            break;
                    }
                }
                sb.delete(0, sb.length());
                j = (j+1)%att_num;
            }
            else{
                if((char)i!='\r') sb.append((char)i);
            }
        }
        Collections.sort(list, SinhVien2.CompareLop);
        for (SinhVien2 x : list) {
            System.out.println(x.toString());
        }
        FileOutputStream fout = new FileOutputStream("SX.OUT");
        for(i = 0; i < list.size(); i++)
        {
            tmp = list.get(i);
            byte[] b = (tmp.toString()+'\n').getBytes();
            fout.write(b);
        }
    }
}