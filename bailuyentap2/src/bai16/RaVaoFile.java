package bai16;

import javax.print.attribute.standard.NumberUp;
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

    public ArrayList<MatHang> readMatHangFormFile(String fileName) throws IOException {
        File file = new File(fileName);
        if(!file.exists()) file.createNewFile();
        openFileToRead(fileName);
        ArrayList<MatHang> matHangs = new ArrayList<>();
        int maHang = 0, dem = 0, kt = 0;
        String ten = "", nhom = "";
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
                    maHang = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                }
                if(kt1(maHang)) kt++;
            }
            else if(dem == 2) {
                ten = scanner.nextLine();
                if(kt2(ten)) kt++;
            }
            else if(dem == 3) {
                nhom = scanner.nextLine();
                if(kt3(nhom)) kt++;
            }
            else {
                try {
                    giaBan = Double.parseDouble(scanner.nextLine());
                }catch (NumberFormatException e){
                }
                if(kt4(giaBan)) kt++;
            }
            if(dem == 4 && kt == 4){
                MatHang matHang = new MatHang(maHang, ten, nhom, giaBan);
                matHangs.add(matHang);
            }
        }
        closeFileAfterRead(fileName);
        return matHangs;
    }

    public void writeFile(ArrayList<MatHang> matHangs, String fileNme) throws IOException {
        File file = new File(fileNme);
        if(file.exists()) file.delete();
        openFileToWrite(fileNme);
        for (MatHang r: matHangs){
            printWriter.println(r.getMaHang()+" "+r.getTen()+" "+r.getNhom()+" "+r.getGiaBan());
        }
        closeFileAfterWrite(fileNme);
    }

    private boolean kt4(double giaBan) {
        if (giaBan > 0) return true;
        return false;
    }

    private boolean kt3(String nhom) {
        nhom = nhom.trim();
        nhom = nhom.replaceAll("\\s+", " ");
        nhom = nhom.toLowerCase();
        if(nhom.equals("hàng tiêu dùng")|nhom.equals("hàng thời trang")
        | nhom.equals("điện tử - điện lạnh")) return true;
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
