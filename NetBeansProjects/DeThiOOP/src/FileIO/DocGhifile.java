package FileIO;
import java.io.*;
import java.util.*;
import Model.*;
public class DocGhifile {
    public static void write(ArrayList ObjList, String filename){
        ObjectOutputStream oout;
        try{
            oout = new ObjectOutputStream(new FileOutputStream(filename));
                for(Object o : ObjList){
                oout.writeObject(o);
            }
            oout.close();
        }
        catch(IOException e){    
        }
    }
    public static void read(ArrayList ObjList, String filename){
        ObjectInputStream oin;
        try{
        oin = new ObjectInputStream(new FileInputStream(filename));
        Object obj = null;
        while((obj = oin.readObject())!=null){
            Object o = (Object)obj;
            ObjList.add(o);
        }
        }
        catch(IOException | ClassNotFoundException e){
        }
    }
}
