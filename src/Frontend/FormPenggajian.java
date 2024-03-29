
package Frontend;

import Backend.*;
import DBConfig.DBHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class FormPenggajian extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public FormPenggajian() {
        initComponents();
        
        setResizable(false);
        setLocationRelativeTo(null);
        
        tampilkanData();
        tampilkanCmbNip();
        
    }
    
     public void kosongkanForm() {
        inputTglPenggajian.setText("");
        labTotalGaji.setText("");

        dataNip.setSelectedIndex(0);
    }
    
    public void tampilkanData() {
        
        String[] kolom = {"ID Penggajian", "ID Pegawai", "Gaji Pokok", "Tgl. Penggajian", "Total Gaji"};
        ArrayList<Penggajian> listPenggajian = new Penggajian().getAll();
        
        Object[] rowData = new Object[5];
        tblPenggajian.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for (int i = 0; i < listPenggajian.size(); i++) { 
            rowData[0] = listPenggajian.get(i).getIdPenggajian();
            rowData[1] = listPenggajian.get(i).getPegawai().getIdPegawai();
            rowData[2] = listPenggajian.get(i).getGajiPokok();
            rowData[3] = listPenggajian.get(i).getTglPenggajian();
            rowData[4] = listPenggajian.get(i).getPegawai().hitungTotalGaji();
            
            ((DefaultTableModel) tblPenggajian.getModel()).addRow(rowData);
        }
        
    }
    
    public void search(String keyword) {
        
        String[] kolom = {"ID Penggajian", "ID Pegawai", "Gaji Pokok", "Tgl. Penggajian", "Total Gaji"};
        ArrayList<Penggajian> listPenggajian = new Penggajian().getAll();
        
        Object[] rowData = new Object[5];
        tblPenggajian.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for (int i = 0; i < listPenggajian.size(); i++) {
            rowData[0] = listPenggajian.get(i).getIdPenggajian();
            rowData[1] = listPenggajian.get(i).getPegawai().getIdPegawai();
            rowData[2] = listPenggajian.get(i).getGajiPokok();
            rowData[3] = listPenggajian.get(i).getTglPenggajian();
            rowData[4] = listPenggajian.get(i).getTotalGaji();
            
            ((DefaultTableModel) tblPenggajian.getModel()).addRow(rowData);
        }
        
    }
    
    public void tampilkanCmbNip() {
        dataNip.setModel(new DefaultComboBoxModel(new Penggajian().getPegawai().getAll().toArray()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnHapusPenggajian = new javax.swing.JButton();
        btnTampilTotalGaji = new javax.swing.JButton();
        btnSimpanPenggajian = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPenggajian = new javax.swing.JTable();
        dataNip = new javax.swing.JComboBox<>();
        inputTglPenggajian = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        labTotalGaji = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        serachField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        labMenuDashboard1 = new javax.swing.JLabel();
        labMenuPegawai1 = new javax.swing.JLabel();
        labMenuPenggajian1 = new javax.swing.JLabel();
        labMenuLogout1 = new javax.swing.JLabel();
        iconMenuDashboard1 = new javax.swing.JLabel();
        iconMenuPegawai1 = new javax.swing.JLabel();
        iconMenuPenggajian1 = new javax.swing.JLabel();
        IconMenuLogout1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("PENGGAJIAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(225, 225, 225));

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        jLabel8.setText("NIP");

        btnHapusPenggajian.setBackground(new java.awt.Color(255, 87, 87));
        btnHapusPenggajian.setFont(new java.awt.Font("Nirmala UI", 0, 15)); // NOI18N
        btnHapusPenggajian.setForeground(new java.awt.Color(0, 0, 0));
        btnHapusPenggajian.setText("Hapus");
        btnHapusPenggajian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapusPenggajian.setFocusable(false);
        btnHapusPenggajian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPenggajianActionPerformed(evt);
            }
        });

        btnTampilTotalGaji.setBackground(new java.awt.Color(252, 255, 87));
        btnTampilTotalGaji.setFont(new java.awt.Font("Nirmala UI", 0, 15)); // NOI18N
        btnTampilTotalGaji.setForeground(new java.awt.Color(0, 0, 0));
        btnTampilTotalGaji.setText("Tampil Total Gaji");
        btnTampilTotalGaji.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTampilTotalGaji.setFocusable(false);
        btnTampilTotalGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilTotalGajiActionPerformed(evt);
            }
        });

        btnSimpanPenggajian.setBackground(new java.awt.Color(131, 255, 87));
        btnSimpanPenggajian.setFont(new java.awt.Font("Nirmala UI", 0, 15)); // NOI18N
        btnSimpanPenggajian.setForeground(new java.awt.Color(0, 0, 0));
        btnSimpanPenggajian.setText("Simpan");
        btnSimpanPenggajian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpanPenggajian.setFocusable(false);
        btnSimpanPenggajian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPenggajianActionPerformed(evt);
            }
        });

        tblPenggajian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPenggajian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPenggajianMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPenggajian);

        dataNip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dataNip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataNipActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(225, 225, 225, 150));

        labTotalGaji.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        labTotalGaji.setText("0");

        jLabel16.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        jLabel16.setText("Total Gaji Rp.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labTotalGaji)
                .addGap(358, 358, 358))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTotalGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jLabel13.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        jLabel13.setText("Tgl. Penggajian");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(dataNip, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(112, 112, 112)
                            .addComponent(jLabel13)
                            .addGap(18, 18, 18)
                            .addComponent(inputTglPenggajian, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12))))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnTampilTotalGaji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSimpanPenggajian)
                        .addGap(60, 60, 60)
                        .addComponent(btnHapusPenggajian)))
                .addGap(316, 316, 316))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dataNip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(inputTglPenggajian, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapusPenggajian)
                    .addComponent(btnSimpanPenggajian))
                .addGap(18, 18, 18)
                .addComponent(btnTampilTotalGaji)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        serachField.setFont(new java.awt.Font("Nirmala UI", 0, 15)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(0, 0, 0, 120));
        jPanel4.setPreferredSize(new java.awt.Dimension(280, 492));

        labMenuDashboard1.setBackground(new java.awt.Color(255, 255, 255));
        labMenuDashboard1.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        labMenuDashboard1.setForeground(new java.awt.Color(225, 225, 225));
        labMenuDashboard1.setText("Dashboard");
        labMenuDashboard1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMenuDashboard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMenuDashboard1MouseClicked(evt);
            }
        });

        labMenuPegawai1.setBackground(new java.awt.Color(255, 255, 255));
        labMenuPegawai1.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        labMenuPegawai1.setForeground(new java.awt.Color(225, 225, 225));
        labMenuPegawai1.setText("Pegawai");
        labMenuPegawai1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMenuPegawai1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMenuPegawai1MouseClicked(evt);
            }
        });

        labMenuPenggajian1.setBackground(new java.awt.Color(255, 255, 255));
        labMenuPenggajian1.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        labMenuPenggajian1.setForeground(new java.awt.Color(225, 225, 225));
        labMenuPenggajian1.setText("Penggajian");
        labMenuPenggajian1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMenuPenggajian1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMenuPenggajian1MouseClicked(evt);
            }
        });

        labMenuLogout1.setBackground(new java.awt.Color(255, 255, 255));
        labMenuLogout1.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        labMenuLogout1.setForeground(new java.awt.Color(225, 225, 225));
        labMenuLogout1.setText("Logout");
        labMenuLogout1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labMenuLogout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labMenuLogout1MouseClicked(evt);
            }
        });

        iconMenuDashboard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/dashboard (1).png"))); // NOI18N
        iconMenuDashboard1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconMenuDashboard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMenuDashboard1MouseClicked(evt);
            }
        });

        iconMenuPegawai1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/teamwork (1).png"))); // NOI18N
        iconMenuPegawai1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconMenuPegawai1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMenuPegawai1MouseClicked(evt);
            }
        });

        iconMenuPenggajian1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/payment (1).png"))); // NOI18N
        iconMenuPenggajian1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconMenuPenggajian1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMenuPenggajian1MouseClicked(evt);
            }
        });

        IconMenuLogout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/power (1).png"))); // NOI18N
        IconMenuLogout1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IconMenuLogout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IconMenuLogout1MouseClicked(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/profile-user (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iconMenuDashboard1)
                                    .addComponent(iconMenuPegawai1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labMenuPegawai1)
                                    .addComponent(labMenuDashboard1))
                                .addGap(6, 6, 6))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iconMenuPenggajian1)
                                    .addComponent(IconMenuLogout1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labMenuLogout1)
                                    .addComponent(labMenuPenggajian1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(70, 70, 70))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel20)
                .addGap(70, 70, 70)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconMenuDashboard1)
                    .addComponent(labMenuDashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconMenuPegawai1)
                    .addComponent(labMenuPegawai1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconMenuPenggajian1)
                    .addComponent(labMenuPenggajian1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IconMenuLogout1)
                    .addComponent(labMenuLogout1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/magnifying-glass (1).png"))); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(serachField, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(serachField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labMenuDashboard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMenuDashboard1MouseClicked
        this.setVisible(false);
        new FormDashboard().setVisible(true);
    }//GEN-LAST:event_labMenuDashboard1MouseClicked

    private void labMenuPegawai1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMenuPegawai1MouseClicked
        this.setVisible(false);
        new FormPegawai().setVisible(true);
    }//GEN-LAST:event_labMenuPegawai1MouseClicked

    private void labMenuPenggajian1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMenuPenggajian1MouseClicked
        if (evt.getSource() == this) {
            this.setVisible(true);
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_labMenuPenggajian1MouseClicked

    private void iconMenuDashboard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMenuDashboard1MouseClicked
        this.setVisible(false);
        new FormDashboard().setVisible(true);
    }//GEN-LAST:event_iconMenuDashboard1MouseClicked

    private void iconMenuPegawai1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMenuPegawai1MouseClicked
        this.setVisible(false);
        new FormPegawai().setVisible(true);
    }//GEN-LAST:event_iconMenuPegawai1MouseClicked

    private void iconMenuPenggajian1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMenuPenggajian1MouseClicked
        if (evt.getSource() == this) {
            this.setVisible(true);
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_iconMenuPenggajian1MouseClicked

    private void labMenuLogout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labMenuLogout1MouseClicked
        this.setVisible(false);
        new FormLogout().setVisible(true);
    }//GEN-LAST:event_labMenuLogout1MouseClicked

    private void IconMenuLogout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconMenuLogout1MouseClicked
        this.setVisible(false);
        new FormLogout().setVisible(true);
    }//GEN-LAST:event_IconMenuLogout1MouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        search(serachField.getText());
    }//GEN-LAST:event_btnSearchMouseClicked

    private void dataNipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataNipActionPerformed

    }//GEN-LAST:event_dataNipActionPerformed

    private void tblPenggajianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPenggajianMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblPenggajian.getModel();
        int row = tblPenggajian.getSelectedRow();
        Penggajian penggajian = new Penggajian();

        penggajian = penggajian.getByid(Integer.parseInt(model.getValueAt(row, 0).toString()));
        inputTglPenggajian.setText(penggajian.getTglPenggajian());
        labTotalGaji.setText(String.valueOf(penggajian.getTotalGaji()));
    }//GEN-LAST:event_tblPenggajianMouseClicked

    private void btnSimpanPenggajianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPenggajianActionPerformed
        Penggajian penggajian = new Penggajian();
        dataNip.getModel().getSelectedItem();
        penggajian.setTglPenggajian(inputTglPenggajian.getText());
        //labTotalGaji.setText(String.valueOf(((Pegawai)dataNip.getSelectedItem()).hitungTotalGaji()));

        penggajian.save();
        tampilkanData();
    }//GEN-LAST:event_btnSimpanPenggajianActionPerformed

    private void btnTampilTotalGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilTotalGajiActionPerformed
        labTotalGaji.setText(String.valueOf(((Pegawai)dataNip.getSelectedItem()).hitungTotalGaji()));
        //kosongkanForm();
    }//GEN-LAST:event_btnTampilTotalGajiActionPerformed

    private void btnHapusPenggajianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusPenggajianActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblPenggajian.getModel();
        int row = tblPenggajian.getSelectedRow();

        Penggajian penggajian = new Penggajian().getByid(Integer.parseInt(model.getValueAt(row, 0).toString()));
        penggajian.delete();
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnHapusPenggajianActionPerformed

    
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
            java.util.logging.Logger.getLogger(FormPenggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPenggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPenggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPenggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPenggajian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconMenuLogout1;
    private javax.swing.JButton btnHapusPenggajian;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JButton btnSimpanPenggajian;
    private javax.swing.JButton btnTampilTotalGaji;
    private javax.swing.JComboBox<String> dataNip;
    private javax.swing.JLabel iconMenuDashboard1;
    private javax.swing.JLabel iconMenuPegawai1;
    private javax.swing.JLabel iconMenuPenggajian1;
    private javax.swing.JTextField inputTglPenggajian;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel labMenuDashboard1;
    private javax.swing.JLabel labMenuLogout1;
    private javax.swing.JLabel labMenuPegawai1;
    private javax.swing.JLabel labMenuPenggajian1;
    private javax.swing.JLabel labTotalGaji;
    private javax.swing.JTextField serachField;
    private javax.swing.JTable tblPenggajian;
    // End of variables declaration//GEN-END:variables
}
