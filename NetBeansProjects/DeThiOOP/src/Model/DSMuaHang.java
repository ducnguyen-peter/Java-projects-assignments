/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class DSMuaHang implements Serializable {

    private KhachHang khachHang;
    private MatHang matHang;
    private int soLuong;

    public DSMuaHang() {
    }

    public DSMuaHang(MatHang matHang, KhachHang khachHang, int soLuong) {
        this.matHang = matHang;
        this.khachHang = khachHang;
        this.soLuong = soLuong;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public Object[] toObject() {
        return new Object[]{khachHang.getMaKhachHang(), khachHang.getHoTen(), matHang.getMaHang(), matHang.getTenHang(), soLuong};
    }
    
    public String[] toStrings()
    {
        return new String[]{Integer.toString(matHang.getMaHang()), matHang.getTenHang(), matHang.getNhomHang(), Integer.toString(soLuong), Integer.toString(soLuong*matHang.getGiaBan())};
    }

    public static ArrayList<DSMuaHang> search(ArrayList<DSMuaHang> ds, int MaKH){
        ArrayList<DSMuaHang> list = new ArrayList<>();
        for(DSMuaHang a : ds){
            if(a.getKhachHang().getMaKhachHang()==MaKH){
                list.add(a);
            }
        }
        return list;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DSMuaHang) {
            DSMuaHang ds = (DSMuaHang) obj;
            if (this.matHang.equals(ds.matHang) && this.khachHang.equals(ds.khachHang)) {
                return true;
            }
        }
        return false;
    }
}
