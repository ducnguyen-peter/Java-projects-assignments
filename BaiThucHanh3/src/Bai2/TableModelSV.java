package Bai2;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModelSV extends AbstractTableModel {
    private String[] att = {"Mã", "Tên", "Lớp", "Điểm"};
    private ArrayList<SinhVien> list;
    public TableModelSV(ArrayList<SinhVien> list)
    {
        this.list = list;
    }
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return att.length;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        return att[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SinhVien sinhVien = list.get(rowIndex);
        Object returnVal = null;
        switch(columnIndex)
        {
            case 0:
                returnVal = sinhVien.getMaSV();
                break;
            case 1:
                returnVal = sinhVien.getTen();
                break;
            case 2:
                returnVal = sinhVien.getLop();
                break;
            case 3:
                returnVal = sinhVien.getDtb();
                break;
            default:
                throw new IllegalArgumentException("Invalid col index");
        }
        return returnVal;
    }

}
