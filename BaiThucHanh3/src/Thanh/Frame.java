/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thanh;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Windows 10
 */
public class Frame extends JFrame {

    ArrayList<Student> studentsList;
    JTable table;
    DefaultTableModel tm1;
    JPanel p1 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p2 = new JPanel();
    String file = "SV.TXT";
    TableModel tb;
    JTable table2 = table;

    public Frame() throws IOException {

        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Form", p1);
        tp.addTab("Table", p2);
        tp.addTab("Sort", p3);
        form();
        sortingTable();
        createTable();
        this.add(tp);
    }

    public void chooseFile(String s) throws IOException {
        ArrayList<Student> list = docFile(file);
        ArrayList<Student> students = new ArrayList<>();
        for (Student st : list) {
            if (st.getLop().equals(s)) {
                students.add(st);
            }
        }
        students.sort(new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getDtb() > o2.getDtb() ? -1 : 1;
            }
            
        });
        tb = new StudentTableModel(students);
        table2.setModel(tb);
    }

    public void createTable() throws IOException {
        JButton b = new JButton("Read");
        //b.addActionListener(new ActionPerform(this));
        b.addActionListener((e) -> {
            try {
                createTable1();
            } catch (IOException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ArrayList<Student> st = new ArrayList<>();
        TableModel tm = new StudentTableModel(st);
        table = new JTable(tm);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(table);
        p2.add(sp);
        p2.add(b);
    }

    public void createTable1() throws IOException {
        Student.setCurrentId(999);
        ArrayList<Student> list = docFile(file);
        tb = new StudentTableModel(list);
        table.setModel(tb);
    }

    public void setFile(String file) throws IOException {
        this.file = file;
        Student.setCurrentId(999);
        ArrayList<Student> list = docFile(file);
        tb = new StudentTableModel(list);
        table.setModel(tb);
    }

    public void form() {
        studentsList = new ArrayList<>();
        JLabel l1 = new JLabel("Họ & tên :");
        JLabel l2 = new JLabel("Chuyên ngành :");
        JLabel l3 = new JLabel("Điểm :");
        JComboBox cb2 = new JComboBox();
        cb2.addItem("Kĩ thuật");
        cb2.addItem("Kinh tế");
        cb2.addItem("Ngôn ngữ");
        JTextField tf1 = new JTextField(30);
        JTextField tf3 = new JTextField(9);
        JButton add = new JButton("Thêm");
        JButton save = new JButton("Thêm vào File");
        p1.setLayout(null);
        l1.setBounds(20, 20, 100, 20);
        tf1.setBounds(150, 20, 200, 20);
        l2.setBounds(20, 70, 100, 20);
        cb2.setBounds(150, 70, 100, 20);
        l3.setBounds(20, 120, 100, 20);
        tf3.setBounds(150, 120, 100, 20);
        add.setBounds(30, 160, 100, 20);
        save.setBounds(160, 160, 100, 20);
        save.addActionListener((e) -> {
            String name = tf1.getText();
            String lop = (String) cb2.getItemAt(cb2.getSelectedIndex());
            String gpa = tf3.getText();

            if (name.equals("") || lop.equals("") || gpa.equals("")) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
                return;
            }

            try {

                double diem = Double.parseDouble(gpa);
                System.out.println(studentsList.size());
                if (diem > 4.0 || diem < 0.0) {
                    JOptionPane.showMessageDialog(null, "Sai format điểm");
                    return;
                }

                Student student = new Student(name, lop, diem);
                studentsList.add(student);
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Nhập lại điểm");
            }
            tf1.setText("");
            tf3.setText("");
            try {
                ghiFile(file);
            } catch (IOException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        );
        p1.add(l1);
        p1.add(tf1);
        p1.add(l2);
        p1.add(cb2);
        p1.add(l3);
        p1.add(tf3);
        //p1.add(add);
        p1.add(save);
    }

    public void sortingTable() {
        JComboBox cb = new JComboBox();
        cb.addItem("Kĩ thuật");
        cb.addItem("Ngôn ngữ");
        cb.addItem("Kinh tế");
        JButton choose = new JButton("Choose");
        choose.addActionListener((e) -> {
            Student.setCurrentId(999);
            String s = cb.getSelectedItem().toString();
            try {
                chooseFile(s);
            } catch (IOException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ArrayList<Student> st = new ArrayList<>();
        TableModel tm = new StudentTableModel(st);
        table2 = new JTable(tm);
        table2.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table2.setFillsViewportHeight(true);
        JScrollPane sp1 = new JScrollPane(table2);
        p3.add(sp1);
        p3.add(choose);
        p3.add(cb);
    }

    public void ghiFile(String filename) throws FileNotFoundException, IOException {
        StringBuilder sb = new StringBuilder("");
        for (Student o : studentsList) {
            sb.append(o.getId());
            sb.append('\n' + o.getTen() + '\n' + o.getLop() + '\n' + o.getDtb() + '\n');
        }
        FileOutputStream fos;
        fos = new FileOutputStream(file);
        byte[] b = sb.toString().getBytes();
        fos.write(b);
    }

    public ArrayList<Student> docFile(String filename) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String s;
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        while ((s = br.readLine()) != null) {
            list.add(s);
        }
        br.close();
        int i = 0;
        while (i < list.size()) {
            String id = list.get(i);
            String name = list.get(i + 1);
            String lop = list.get(i + 2);
            String gpa = list.get(i + 3);
            double diem = 0;
            int stt = 1000;
            try {
                stt = Integer.parseInt(id);
                diem = Double.parseDouble(gpa);
            } catch (NumberFormatException ex) {
            }
            Student st = new Student(name, lop, diem);
            students.add(st);
            i += 4;
        }
        return students;
    }

}
