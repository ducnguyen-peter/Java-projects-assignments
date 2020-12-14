package bai18;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RaVaoFile {
    private Scanner scanner;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;

    public void openFileToWrite(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName, true);
        bufferedWriter = new BufferedWriter(fileWriter);
        printWriter = new PrintWriter(bufferedWriter);
    }

    public void closeFileAfterWrite(String fileName) throws IOException {
        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();
    }

    public void openFileToRead(String fileName) throws IOException {
        scanner = new Scanner(Paths.get(fileName), "UTF-8");
    }

    public void closeFileAfterRead(String fileName){
        scanner.close();
    }

    public ArrayList<MonHoc> readMonHocFormFile(String fileName) throws IOException {
        File file = new File(fileName);
        if(!file.exists()) file.createNewFile();
        openFileToRead(fileName);
        ArrayList<MonHoc> monHocs = new ArrayList<>();
        int maMon = 0, dem = 0, kt = 0;
        String tenMon = "", nhomMon = "";
        int soTinchi = 0;
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
                    maMon = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                }
                if(kt1(maMon)) kt++;
            }
            else if(dem == 2) {
                tenMon = scanner.nextLine();
                if(kt2(tenMon)) kt++;
            }
            else if(dem == 3) {
                nhomMon = scanner.nextLine();
                if(kt3(nhomMon)) kt++;
            }
            else {
                try {
                    soTinchi = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                }
                if(kt4(soTinchi)) kt++;
            }
            if(dem == 4 && kt == 4){
                MonHoc monHoc = new MonHoc(maMon, tenMon, nhomMon, soTinchi);
                monHocs.add(monHoc);
            }
        }
        closeFileAfterRead(fileName);
        return monHocs;
    }

    public void writeFile(ArrayList<MonHoc> monHocs, String fileNme) throws IOException {
        File file = new File(fileNme);
        if(file.exists()) file.delete();
        openFileToWrite(fileNme);
        for (MonHoc r: monHocs){
            printWriter.println(r.getMaMon()+" "+r.getTenMon()+" "+r.getNhomMon()+" "+r.getSoTinchi());
        }
        closeFileAfterWrite(fileNme);
    }

    private boolean kt4(double soTinchi) {
        if (soTinchi > 0 && soTinchi < 7) return true;
        return false;
    }

    private boolean kt3(String nhom) {
        nhom = nhom.trim();
        nhom = nhom.replaceAll("\\s+", " ");
        nhom = nhom.toLowerCase();
        if(nhom.equals("cơ bản")|nhom.equals("cơ sở ngành")
                | nhom.equals("chuyên ngành")|nhom.equals("kỹ năng mềm")) return true;
        return false;
    }

    private boolean kt2(String ten) {
        if (ten.length() == 0) return false;
        return true;
    }

    private boolean kt1(int maHang) {
        if(maHang >= 1000 && maHang <= 9999) return true;
        else return false;
    }

}
