package bai15;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("SV.INP"), "UTF8");
        String ten = "", lop = "";
        int maSV = 0;
        double dtb = 0;
        int dem = 0, kt = 0;
        ArrayList<SinhVien> sinhViens = new ArrayList<>();
        while (scanner.hasNextLine()){
            if(dem == 4){
                dem = 1;
                kt = 0;
            }else {
                dem++;
            }
            if(dem == 1){
                try {
                    maSV = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                }
                if(kt1(maSV)) kt++;
            }
            else if(dem == 2){
                ten = scanner.nextLine();
                if(kt2(ten)) kt++;
            }
            else if(dem == 3){
                lop = scanner.nextLine();
                if(kt3(lop)) kt++;
            }
            else {
                try {
                    dtb = Double.parseDouble(scanner.nextLine());
                }catch (NumberFormatException e) {
                }
                if(kt4(dtb)) kt++;
            }
            if(dem == 4 && kt == 4){
                SinhVien sv = new SinhVien(maSV, ten, lop, dtb);
                sinhViens.add(sv);
            }
        }
        scanner.close();
        System.out.println("--------------Danh sách sinh viên trong file SV.INP--------------");
        for (SinhVien r: sinhViens){
            r.hien();
        }

        sinhViens = sapXepTheoDTB(sinhViens);
        ArrayList<String> tenlops = timTenCacLop(sinhViens);
        Collections.sort(tenlops);

        System.out.println("--------------Danh sách sinh viên trong file SV.INP sau khi sắp xếp--------------");
        for (int i = 0; i < tenlops.size(); i++){
            System.out.println("Lớp: " + tenlops.get(i));
            for(int j = 0; j < sinhViens.size(); j++){
                if(tenlops.get(i).equals(sinhViens.get(j).getLop().toUpperCase())){
                    sinhViens.get(j).hien();
                }
            }
        }

        File file = new File("SX.OUT");
        if(file.exists()) file.delete();

        FileWriter fileWriter = new FileWriter("SX.OUT", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);

        for (int i = 0; i < tenlops.size(); i++){
            for(int j = 0; j < sinhViens.size(); j++){
                if(tenlops.get(i).equals(sinhViens.get(j).getLop().toUpperCase())){
                    printWriter.println(sinhViens.get(j).getMaSV()+" "+
                            sinhViens.get(j).getTen()+" "+sinhViens.get(j).getLop()
                    +" "+ sinhViens.get(j).getDtb());
                }
            }
        }


        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();

        String[] pl = new String[sinhViens.size()];
        for(int i = 0; i < sinhViens.size(); i++){
            pl[i] = sinhViens.get(i).xepLoai();
        }

        for(int i = 0; i < sinhViens.size() - 1; i++){
            for(int j = i+1; j < sinhViens.size(); j++){
                SinhVien a = sinhViens.get(i);
                SinhVien b = sinhViens.get(j);
                String pla = sinhViens.get(i).xepLoai();
                String plb = sinhViens.get(j).xepLoai();
                String[] as = a.getTen().split(" ");
                String[] bs = b.getTen().split(" ");
                String lastNamea = as[as.length-1];
                String lastNameb = bs[bs.length-1];
                String hoTenDema = "";
                String hoTenDemb = "";
                for (int  k = 0; k < as.length-1; k++){
                    hoTenDema += as[k];
                    if(k != as.length-2){
                        hoTenDema+=" ";
                    }
                }
                for (int  k = 0; k < bs.length-1; k++){
                    hoTenDemb += bs[k];
                    if(k != bs.length-2){
                        hoTenDemb+=" ";
                    }
                }
                if(lastNamea.toLowerCase().compareTo(lastNameb.toLowerCase()) > 0) {
                    sinhViens.set(i, b);
                    sinhViens.set(j, a);
                    pl[i] = plb;
                    pl[j] = pla;
                }
                if (lastNamea.toLowerCase().compareTo(lastNameb.toLowerCase()) == 0 &&
                        hoTenDema.toLowerCase().compareTo(hoTenDemb.toLowerCase()) > 0){
                    sinhViens.set(i, b);
                    sinhViens.set(j, a);
                    pl[i] = plb;
                    pl[j] = pla;
                }
            }
        }

        File file1 = new File("XEPLOAI.OUT");
        if(file1.exists()) file1.delete();

        fileWriter = new FileWriter("XEPLOAI.OUT", true);
        bufferedWriter = new BufferedWriter(fileWriter);
        printWriter = new PrintWriter(bufferedWriter);

        for(int i = 0; i < sinhViens.size(); i++){
            printWriter.println(sinhViens.get(i).getMaSV() + " "+sinhViens.get(i).getTen()
            +" "+sinhViens.get(i).getLop()+" "+sinhViens.get(i).getDtb()+" "+pl[i]);
        }

        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();
    }

    private static ArrayList<String> timTenCacLop(ArrayList<SinhVien> sinhViens) {
        ArrayList<String> tenlops = new ArrayList<>();
        for (int i = 0; i < sinhViens.size(); i++){
            int kt = 0;
            for(int j = 0; j < tenlops.size(); j++){
                if(sinhViens.get(i).getLop().toUpperCase().equals(tenlops.get(j))){
                    kt = 1;
                    break;
                }
            }
            if(kt == 0) tenlops.add(sinhViens.get(i).getLop().toUpperCase());
        }
        return tenlops;
    }

    public static ArrayList<SinhVien> sapXepTheoDTB(ArrayList<SinhVien> sinhViens) {
        for(int i = 0; i < sinhViens.size()-1; i++){
            for(int j = i+1; j < sinhViens.size(); j++){
                SinhVien a = sinhViens.get(i);
                SinhVien b = sinhViens.get(j);
                if(a.getDtb() < b.getDtb()){
                    sinhViens.set(i, b);
                    sinhViens.set(j, a);
                }
            }
        }
        return sinhViens;
    }



    public static boolean kt3(String lop) {
        String regex = "^[dD]{1}\\d{2}[cC]{1}[qQ]{1}[qQvVmMcCnNaAtTdDpPkK]{2}\\d{2}[-bBnN]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lop);
        if(matcher.find()) return true;
        return false;
    }

    public static boolean kt4(double dtb) {
        if(dtb >= 0 && dtb<=10) return true;
        else return false;
    }

    public static boolean kt2(String ten) {
        if (ten.length() == 0) return false;
        String[] tens = ten.split(" ");
        if(tens.length < 2) return false;
        return true;
    }

    public static boolean kt1(int maSV) {
        if(maSV >= 1000 && maSV <= 9999) return true;
        return false;
    }
}
