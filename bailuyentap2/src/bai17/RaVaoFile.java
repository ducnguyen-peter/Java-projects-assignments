package bai17;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RaVaoFile {
    private Scanner scanner;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;

    public void openFileToWrite(String fileName) throws Exception {
        fileWriter = new FileWriter(fileName, true);
        bufferedWriter = new BufferedWriter(fileWriter);
        printWriter = new PrintWriter(bufferedWriter);
    }

    public void closeFileAfterWrite(String fileName) throws Exception {
        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();
    }

    public void openFileToRead(String fileName) throws Exception {
        scanner = new Scanner(Paths.get(fileName), "UTF-8");
    }

    public void closeFileAfterRead(String fileName){
        scanner.close();
    }

    public ArrayList<Sach> readSachFormFile(String fileName) throws Exception {
        openFileToRead(fileName);
        ArrayList<Sach> sachs = new ArrayList<>();
        int masach = 0, dem = 0, kt = 0;
        String ten = "", cn = "";
        double giaBan = 0;
        while (scanner.hasNextLine()){
            if(dem == 4){
                dem = 1;
                kt = 0;
            }
            else {
                dem++;
            }
            if(dem == 1) {
                try {
                    masach = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                }
                if(kt1(masach)) kt++;
            }
            else if(dem == 2) {
                ten = scanner.nextLine();
                if(kt2(ten)) kt++;
            }
            else if(dem == 3) {
                cn = scanner.nextLine();
                if(kt3(cn)) kt++;
            }
            else {
                try {
                    giaBan = Double.parseDouble(scanner.nextLine());
                }catch (NumberFormatException e){
                }
                if(kt4(giaBan)) kt++;
            }
            if(dem == 4 && kt == 4){
                Sach sach = new Sach(masach, ten, cn, giaBan);
                sachs.add(sach);
            }
        }
        closeFileAfterRead(fileName);
        return sachs;
    }

    public void writeFile(ArrayList<Sach> sachs, String fileNme) throws Exception {
        File file = new File(fileNme);
        if(file.exists()) file.delete();
        openFileToWrite(fileNme);
        for (Sach r: sachs){
            printWriter.println(r.getMaSach()+" "+r.getTenSach()+" "+r.getChuyenNganh()+" "+r.getGiaBan());
        }
        closeFileAfterWrite(fileNme);
    }

    private boolean kt4(double giaBan) {
        if (giaBan > 0) return true;
        return false;
    }

    private boolean kt3(String cn) {
       if (cn.length() == 0) return false;
       return true;
    }

    private boolean kt2(String ten) {
        if (ten.length() == 0) return false;
        return true;
    }

    private boolean kt1(int maSach) {
        if(maSach >= 1000 && maSach <= 9999) return true;
        else return false;
    }

}

