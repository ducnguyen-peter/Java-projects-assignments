package Bai2;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormNhap extends JFrame {
    ArrayList<SinhVien> list = new ArrayList<>();
    JPanel p1 = new JPanel(), p2 = new JPanel(), p3 = new JPanel();
    String file = "SV.TXT";
    JTable table1, table2 = table1;
    TableModel tb;
    public FormNhap() throws IOException
    {
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Form", p1);
        tp.addTab("Table", p2);
        tp.addTab("Sort table", p3);
        createTable();
        form();
        createSortTable();
        this.add(tp);
    }



    private void form() {
        JLabel l1 = new JLabel("Họ tên"), l2 = new JLabel("Ngành"), l3 = new JLabel("Điểm");
        JComboBox cb = new JComboBox();
        cb.addItem("Kĩ thuật");
        cb.addItem("Kinh tế");
        cb.addItem("Ngôn ngữ");
        JTextField tf1 = new JTextField(30), tf3 = new JTextField(9);
        JButton add = new JButton("Thêm"), save = new JButton("Lưu");
        p1.setLayout(null);
        l1.setBounds(20, 20, 100, 20);
        tf1.setBounds(150, 20, 200, 20);
        l2.setBounds(20, 70, 100, 20);
        cb.setBounds(150, 70, 100, 20);
        l3.setBounds(20, 120, 100, 20);
        tf3.setBounds(150, 120, 100, 20);
        add.setBounds(30, 160, 100, 20);
        save.setBounds(160, 160, 100, 20);
        save.addActionListener((e)->{
            String name = tf1.getText();
            String lop = (String)cb.getItemAt(cb.getSelectedIndex());
            String gpa = tf3.getText();
            if(name.equals("")||lop.equals("")||gpa.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Chưa đủ thông tin");
                return;
            }
            try{
                double diem = Double.parseDouble(gpa);
                if(diem>4.0||diem<0.0)
                {
                    JOptionPane.showMessageDialog(null, "Sai điẻm");
                    return;
                }
                SinhVien tmp = new SinhVien(name, lop, diem);
                list.add(tmp);
            }
            catch(NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(null, "Sai điểm");
            }
            tf1.setText("");
            tf3.setText("");
            try{
                writefile(file);
            }
            catch(IOException ioe)
            {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ioe);
            }
        });
        p1.add(l1);
        p1.add(tf1);
        p1.add(l2);
        p1.add(cb);
        p1.add(l3);
        p1.add(tf3);
//        p1.add(add);
        p1.add(save);
    }

    private void createTable() {
        JButton b = new JButton("Đọc");
        b.addActionListener(e -> {
            try {
                createTable1();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        ArrayList<SinhVien> st = new ArrayList<>();
        TableModel tm = new TableModelSV(st);
        table1 = new JTable(tm);
        table1.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table1.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(table1);
        p2.add(sp);
        p2.add(b);
    }

    private void createTable1() throws IOException{
        ArrayList<SinhVien> list = read(file);
        tb = new TableModelSV(list);
        table1.setModel(tb);
    }
    private void createSortTable() {
        JComboBox cb = new JComboBox();
        cb.addItem("Kĩ thuật");
        cb.addItem("Kinh tế");
        cb.addItem("Ngôn ngữ");
        JButton choose = new JButton("Chọn");
        choose.addActionListener(e -> {
            String s = cb.getSelectedItem().toString();
            try {
                chooseCategory(s);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        ArrayList<SinhVien> st = new ArrayList<>();
        TableModel tm = new TableModelSV(st);
        table2 = new JTable(tm);
        table2.setPreferredScrollableViewportSize(new Dimension(400, 300));
        table2.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(table2);
        p3.add(sp);
        p3.add(choose);
        p3.add(cb);
    }
    public void chooseCategory(String s) throws IOException
    {
        ArrayList<SinhVien> list = read(file);
        ArrayList<SinhVien> sinhViens = new ArrayList<>();
        for(SinhVien x : list)
        {
            if(x.getLop().equals(s)){
                sinhViens.add(x);
            }
        }
        sinhViens.sort(new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if(o1.getDtb()>o2.getDtb()) return -1;
                return 1;
            }
        });
        tb = new TableModelSV(sinhViens);
        table2.setModel(tb);
    }

    public void writefile(String filename) throws FileNotFoundException, IOException
    {
        StringBuilder sb = new StringBuilder();
        for(SinhVien a : list)
        {
            sb.append(a.toString());
        }
        FileOutputStream fout = new FileOutputStream(filename, true);
        byte[] b = sb.toString().getBytes();
        fout.write(b);
    }

    public ArrayList<SinhVien> read(String filename) throws IOException
    {
        BufferedReader input = new BufferedReader(new FileReader(filename));
        String s;
        ArrayList<SinhVien> sinhViens = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        while((s = input.readLine())!=null)
        {
            lines.add(s);
        }
        input.close();
        int i = 0;
        while(i<lines.size())
        {
            String id = lines.get(i++);
            String ten = lines.get(i++);
            String lop = lines.get(i++);
            String gpa = lines.get(i++);
            double diem = 0;
            int stt = 0;
            try {
                stt = Integer.parseInt(id);
                diem = Double.parseDouble(gpa);
            }
            catch(NumberFormatException nfe) {
            }
            sinhViens.add(new SinhVien(ten, lop, diem));
        }
        return sinhViens;
    }

    public static void main(String[] args) throws IOException {
        FormNhap f = new FormNhap();
        f.setSize(400, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
