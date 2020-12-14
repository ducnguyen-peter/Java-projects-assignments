/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.*;
import javax.swing.table.DefaultTableModel;
import Model.*;
import FileIO.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public static final String fileMH = "MH.TXT", fileKH = "KH.TXT", fileDS = "QLBH.TXT";
    DefaultTableModel tmMH, tmKH, tmDS;
    ArrayList<MatHang> listMH;
    ArrayList<KhachHang> listKH;
    ArrayList<DSMuaHang> listDS;

    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quản lý bán hàng");
        tmMH = (DefaultTableModel) TableMH.getModel();
        tmKH = (DefaultTableModel) TableKH.getModel();
        tmDS = (DefaultTableModel) jTable1.getModel();
        listMH = new ArrayList<>();
        listKH = new ArrayList<>();
        listDS = new ArrayList<>();
        DocGhifile.read(listMH, fileMH);
        DocGhifile.read(listKH, fileKH);
        cbloadID();
//        getData();
        jButtonAddMH.addActionListener((e) -> {
            String ten = txtGood.getText();
            String nhom = cbGroup.getItemAt(cbGroup.getSelectedIndex());
            String giaHang = txtPrice.getText();
            if (ten.equals("") || nhom.equals("") || giaHang.equals("")) {
                JOptionPane.showMessageDialog(null, "Nhập thiếu thông tin");
                return;
            }
            int gia;
            try {
                gia = Integer.parseInt(giaHang);
                int pos = listMH.size() - 1;
                if (pos != -1) {
                    MatHang.setMaHienTai(listMH.get(pos).getMaHang());
                }
                MatHang tmp = new MatHang(ten, nhom, gia);
                for (MatHang m : listMH) {
                    if (m.equals(tmp)) {
                        JOptionPane.showMessageDialog(null, "Mặt hàng đã tồn tại");
                        return;
                    }
                }
//                tmMH.addRow(tmp.toObject());
                listMH.add(tmp);
                cbloadID();
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, nfe.getMessage());
                return;
            }
            DocGhifile.write(listMH, fileMH);
        });

        jButtonReadMH.addActionListener((e) -> {
            tmMH.getDataVector().removeAllElements();
            tmMH.fireTableDataChanged();
            getDataMH();
        });

        jButtonAddKH.addActionListener((e) -> {
            String ten = txtTen.getText();
            String address = txtAddress.getText();
            String phNum = txtPhNum.getText();
            if (ten.equals("") || address.equals("") || phNum.equals("")) {
                JOptionPane.showMessageDialog(null, "Nhập thiếu thông tin");
                return;
            }
            int pos = listKH.size() - 1;
            if (pos != -1) {
                KhachHang.setMaHienTai(listKH.get(pos).getMaKhachHang());
            }
            KhachHang tmp = new KhachHang(ten, address, phNum);
            for (KhachHang k : listKH) {
                if (k.equals(tmp)) {
                    JOptionPane.showMessageDialog(null, "Khách hàng đã tồn tại");
                    return;
                }
            }
//            tmMH.addRow(tmp.toObject());
            listKH.add(tmp);
            cbloadID();
            DocGhifile.write(listKH, fileKH);
        });

        jButtonReadKH.addActionListener((e) -> {
            tmKH.getDataVector().removeAllElements();
            tmKH.fireTableDataChanged();
            getDataKH();
        });

        jButtonAddQL.addActionListener((e) -> {
            int MHIndex = cbMaMH.getSelectedIndex();
            int KHIndex = cbMaKH.getSelectedIndex();
            int soLuong = Integer.parseInt(cbSoLuong.getItemAt(cbSoLuong.getSelectedIndex()));
            MatHang b = listMH.get(MHIndex);
            KhachHang k = listKH.get(KHIndex);
            DSMuaHang tmp = new DSMuaHang(b, k, soLuong);
            for (DSMuaHang ds : listDS) {
                if (ds.equals(tmp)) {
                    JOptionPane.showMessageDialog(null, "Người dùng đã mua mặt hàng này");
                    return;
                }
            }
            listDS.add(tmp);
            DocGhifile.write(listDS, fileDS);
        });

        jButtonReadDS.addActionListener((e) -> {
            tmDS.getDataVector().removeAllElements();
            tmDS.fireTableDataChanged();
            getDataDS();
        });

        cbSort.addActionListener((e) -> {
            String option = cbSort.getItemAt(cbSort.getSelectedIndex());
            if (option.equals("Sắp xếp theo tên khách hàng")) {
                Comparator<DSMuaHang> cmp = new Comparator<DSMuaHang>() {
                    @Override
                    public int compare(DSMuaHang o1, DSMuaHang o2) {
                        String name1 = o1.getKhachHang().getHoTen();
                        String name2 = o2.getKhachHang().getHoTen();
                        return name1.compareTo(name2);
                    }
                };
                Collections.sort(listDS, cmp);
            } else if (option.equals("Sắp xếp theo tên hàng")) {
                Comparator<DSMuaHang> cmp = new Comparator<DSMuaHang>() {
                    @Override
                    public int compare(DSMuaHang o1, DSMuaHang o2) {
                        String name1 = o1.getMatHang().getTenHang();
                        String name2 = o2.getMatHang().getTenHang();
                        return name1.compareTo(name2);
                    }
                };
                Collections.sort(listDS, cmp);
            }
            tmDS.getDataVector().removeAllElements();
            tmDS.fireTableDataChanged();
            for (DSMuaHang ds : listDS) {
                tmDS.addRow(ds.toObject());
            }
        });
        
        jButtonXuatHD.addActionListener((e) -> {
            DocGhifile.read(listDS, fileDS);
            ArrayList<DSMuaHang> ds = DSMuaHang.search(listDS, Integer.parseInt(cbXuat.getItemAt(cbXuat.getSelectedIndex())));
            new HoaDon(ds).setVisible(true);
            listDS.clear();
        });
    }

    private void getDataMH() {
        listMH = new ArrayList<>();
        DocGhifile.read(listMH, fileMH);
        for (MatHang m : listMH) {
            tmMH.addRow(m.toObject());
        }

    }

    private void getDataKH() {
        listKH = new ArrayList<>();
        DocGhifile.read(listKH, fileKH);
        for (KhachHang k : listKH) {
            tmKH.addRow(k.toObject());
        }
    }

    private void getDataDS() {
        listDS = new ArrayList<>();
        DocGhifile.read(listDS, fileDS);
        for (DSMuaHang ds : listDS) {
            tmDS.addRow(ds.toObject());
        }
    }

    private void cbloadID() {
        cbMaMH.removeAllItems();
        cbMaKH.removeAllItems();
        for (MatHang m : listMH) {
            cbMaMH.addItem(m.getMaHang() + "");
        }
        for (KhachHang k : listKH) {
            cbMaKH.addItem(k.getMaKhachHang() + "");
            cbXuat.addItem(k.getMaKhachHang() + "");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPhNum = new javax.swing.JTextField();
        jButtonAddKH = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableKH = new javax.swing.JTable();
        txtAddress = new javax.swing.JTextField();
        jButtonReadKH = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbMaKH = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbMaMH = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbSoLuong = new javax.swing.JComboBox<>();
        jButtonAddQL = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonReadDS = new javax.swing.JButton();
        cbSort = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbXuat = new javax.swing.JComboBox<>();
        jButtonXuatHD = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtGood = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbGroup = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jButtonAddMH = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMH = new javax.swing.JTable();
        jButtonReadMH = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Họ tên");

        txtTen.setToolTipText("");

        jLabel5.setText("Địa chỉ");

        jLabel6.setText("Số ĐT");

        txtPhNum.setToolTipText("");

        jButtonAddKH.setText("Thêm");

        TableKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ tên", "Địa chỉ", "Số ĐT"
            }
        ));
        jScrollPane2.setViewportView(TableKH);

        jButtonReadKH.setText("Đọc");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(txtPhNum)
                            .addComponent(txtAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(198, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAddKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonReadKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(150, 150, 150)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtPhNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAddKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonReadKH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 169, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khách hàng", jPanel2);

        jLabel7.setText("Chọn mã khách hàng");

        jLabel8.setText("Chọn mã hàng");

        jLabel9.setText("Số lượng mua");

        cbSoLuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jButtonAddQL.setText("Thêm");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Mã MH", "Tên MH", "Số lượng"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jButtonReadDS.setText("Đọc");

        cbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp theo tên khách hàng", "Sắp xếp theo tên hàng" }));
        cbSort.setToolTipText("");

        jLabel10.setText("Chọn khách hàng để xuất hóa đơn:");

        jButtonXuatHD.setText("Xuất");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 38, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbMaKH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMaMH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbSoLuong, 0, 56, Short.MAX_VALUE))
                        .addGap(60, 60, 60))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(cbXuat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonAddQL)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonReadDS))
                            .addComponent(jButtonXuatHD))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddQL)
                    .addComponent(jButtonReadDS))
                .addGap(18, 18, 18)
                .addComponent(cbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonXuatHD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách mua hàng", jPanel3);

        jPanel1.setToolTipText("");

        jLabel1.setText("Tên hàng");

        txtGood.setToolTipText("");

        jLabel2.setText("Nhóm Hàng");

        cbGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thời trang", "Tiêu dùng", "Điện máy", "Gia dụng" }));

        jLabel3.setText("Giá bán");

        txtPrice.setToolTipText("");

        jButtonAddMH.setText("Thêm");

        TableMH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hàng", "Tên hàng", "Nhóm hàng", "Giá bán"
            }
        ));
        jScrollPane1.setViewportView(TableMH);

        jButtonReadMH.setText("Đọc");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGood)
                            .addComponent(cbGroup, 0, 224, Short.MAX_VALUE)
                            .addComponent(txtPrice)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAddMH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonReadMH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtGood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAddMH)
                .addGap(18, 18, 18)
                .addComponent(jButtonReadMH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 169, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mặt hàng", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableKH;
    private javax.swing.JTable TableMH;
    private javax.swing.JComboBox<String> cbGroup;
    private javax.swing.JComboBox<String> cbMaKH;
    private javax.swing.JComboBox<String> cbMaMH;
    private javax.swing.JComboBox<String> cbSoLuong;
    private javax.swing.JComboBox<String> cbSort;
    private javax.swing.JComboBox<String> cbXuat;
    private javax.swing.JButton jButtonAddKH;
    private javax.swing.JButton jButtonAddMH;
    private javax.swing.JButton jButtonAddQL;
    private javax.swing.JButton jButtonReadDS;
    private javax.swing.JButton jButtonReadKH;
    private javax.swing.JButton jButtonReadMH;
    private javax.swing.JButton jButtonXuatHD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtGood;
    private javax.swing.JTextField txtPhNum;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
