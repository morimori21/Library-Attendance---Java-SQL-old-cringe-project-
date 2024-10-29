/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lbrryattendance;
import com.mysql.cj.xdevapi.Statement;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.table.*;
import java.time.*;
import java.text.SimpleDateFormat;  
import java.util.*;  
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.time.format.DateTimeFormatter;

public class main_menu extends javax.swing.JFrame {
Connection con;
    ResultSet rs;
    PreparedStatement pst;    
    LocalDateTime now = LocalDateTime.now();
    int month = now.getMonthValue();
   
    public main_menu() throws SQLException {
    try {
        initComponents();
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryttndncsql","root","_Magiec24");
        attendanceCalendar(month);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(main_menu.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    private void attendanceCalendar(int month) //SEASONAL ATTENDANCE CALENDAR
        {
            try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
                pst = con.prepareStatement("select * from attendance_jan;");
                todayMonth.setText("JANUARY");
                rs = pst.executeQuery();        
             
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
     public void currDateTIme() //FOR LIVE DATE AND TIEM DISPLAY
        { 
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
          
        }
       private String insertAttendanceCalendar() //THE MONTH SELECTOR FOR I.D.U
        {       
        if (month == Month.JANUARY.getValue()) {
                return "jan";
            }   
        else if (month == Month.FEBRUARY.getValue()) {
               return "feb";
            } 
        else if (month == Month.MARCH.getValue()) {
               return "mar";
            }
        else if (month == Month.APRIL.getValue()) {
               return "apr";
            }
        else if (month == Month.MAY.getValue()) {
                return "may";            
        }
        else{
        return null;} 
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        attendlist = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jan = new javax.swing.JButton();
        feb = new javax.swing.JButton();
        mar = new javax.swing.JButton();
        apr = new javax.swing.JButton();
        may = new javax.swing.JButton();
        jun = new javax.swing.JButton();
        jul = new javax.swing.JButton();
        aug = new javax.swing.JButton();
        sep = new javax.swing.JButton();
        oct = new javax.swing.JButton();
        nov = new javax.swing.JButton();
        dec = new javax.swing.JButton();
        todayMonth = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        attendlist.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        attendlist.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 10)); // NOI18N
        attendlist.setForeground(new java.awt.Color(51, 51, 51));
        attendlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATE / TIME", "NAME", "SECTION"
            }
        ));
        attendlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(attendlist);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 830, 500));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jan.setBackground(new java.awt.Color(0, 0, 0));
        jan.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jan.setForeground(new java.awt.Color(255, 255, 255));
        jan.setText("JAN");
        jan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                janActionPerformed(evt);
            }
        });

        feb.setBackground(new java.awt.Color(0, 0, 0));
        feb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        feb.setForeground(new java.awt.Color(255, 255, 255));
        feb.setText("FEB");
        feb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                febActionPerformed(evt);
            }
        });

        mar.setBackground(new java.awt.Color(0, 0, 0));
        mar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        mar.setForeground(new java.awt.Color(255, 255, 255));
        mar.setText("MAR");
        mar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marActionPerformed(evt);
            }
        });

        apr.setBackground(new java.awt.Color(0, 0, 0));
        apr.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        apr.setForeground(new java.awt.Color(255, 255, 255));
        apr.setText("APR");
        apr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprActionPerformed(evt);
            }
        });

        may.setBackground(new java.awt.Color(0, 0, 0));
        may.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        may.setForeground(new java.awt.Color(255, 255, 255));
        may.setText("MAY");
        may.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mayActionPerformed(evt);
            }
        });

        jun.setBackground(new java.awt.Color(0, 0, 0));
        jun.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jun.setForeground(new java.awt.Color(255, 255, 255));
        jun.setText("JUN");
        jun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                junActionPerformed(evt);
            }
        });

        jul.setBackground(new java.awt.Color(0, 0, 0));
        jul.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jul.setForeground(new java.awt.Color(255, 255, 255));
        jul.setText("JUL");
        jul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                julActionPerformed(evt);
            }
        });

        aug.setBackground(new java.awt.Color(0, 0, 0));
        aug.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        aug.setForeground(new java.awt.Color(255, 255, 255));
        aug.setText("AUG");
        aug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                augActionPerformed(evt);
            }
        });

        sep.setBackground(new java.awt.Color(0, 0, 0));
        sep.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        sep.setForeground(new java.awt.Color(255, 255, 255));
        sep.setText("SEP");
        sep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sepActionPerformed(evt);
            }
        });

        oct.setBackground(new java.awt.Color(0, 0, 0));
        oct.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        oct.setForeground(new java.awt.Color(255, 255, 255));
        oct.setText("OCT");
        oct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                octActionPerformed(evt);
            }
        });

        nov.setBackground(new java.awt.Color(0, 0, 0));
        nov.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        nov.setForeground(new java.awt.Color(255, 255, 255));
        nov.setText("NOV");
        nov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novActionPerformed(evt);
            }
        });

        dec.setBackground(new java.awt.Color(0, 0, 0));
        dec.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        dec.setForeground(new java.awt.Color(255, 255, 255));
        dec.setText("DEC");
        dec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decActionPerformed(evt);
            }
        });

        todayMonth.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        todayMonth.setForeground(new java.awt.Color(255, 255, 255));
        todayMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        todayMonth.setText("MONTH");
        todayMonth.setToolTipText("");

        back.setBackground(new java.awt.Color(51, 51, 255));
        back.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lbrryattendance/arrow (1).png"))); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(may, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jun, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jul, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aug, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(feb, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apr, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sep, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nov, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dec, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(todayMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apr, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(may, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jun, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jul, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aug, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sep, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oct, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nov, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dec, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(todayMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(58, 58, 58))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void attendlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendlistMouseClicked

    }//GEN-LAST:event_attendlistMouseClicked

    private void janActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_janActionPerformed
 try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            
                pst = con.prepareStatement("select * from attendance_jan;");
                todayMonth.setText("JANUARY");
                rs = pst.executeQuery();        
            
            
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }//GEN-LAST:event_janActionPerformed

    private void febActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_febActionPerformed
        try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            
                pst = con.prepareStatement("select * from attendance_feb;");
                todayMonth.setText("FEBRUARY");
                rs = pst.executeQuery();        
            
            
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_febActionPerformed

    private void marActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marActionPerformed
        try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            
                pst = con.prepareStatement("select * from attendance_mar;");
                todayMonth.setText("MARCH");
                rs = pst.executeQuery();        
            
            
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_marActionPerformed

    private void aprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprActionPerformed
      try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            
                pst = con.prepareStatement("select * from attendance_apr;");
                todayMonth.setText("APRIL");
                rs = pst.executeQuery();        
            
            
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aprActionPerformed

    private void mayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mayActionPerformed
       try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            
                pst = con.prepareStatement("select * from attendance_may;");
                todayMonth.setText("MAY");
                rs = pst.executeQuery();        
            
            
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mayActionPerformed

    private void junActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_junActionPerformed
try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            
                pst = con.prepareStatement("select * from attendance_jun;");
                todayMonth.setText("JUNE");
                rs = pst.executeQuery();        
            
            
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_junActionPerformed

    private void julActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_julActionPerformed
       try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            
                pst = con.prepareStatement("select * from attendance_jul;");
                todayMonth.setText("JULY");
                rs = pst.executeQuery();        
            
            
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_julActionPerformed

    private void augActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_augActionPerformed
       try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            
                pst = con.prepareStatement("select * from attendance_aug;");
                todayMonth.setText("AUGUST");
                rs = pst.executeQuery();        
            
            
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_augActionPerformed

    private void sepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sepActionPerformed
       try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            
                pst = con.prepareStatement("select * from attendance_sep;");
                todayMonth.setText("SEPTEMBER");
                rs = pst.executeQuery();        
            
            
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sepActionPerformed

    private void octActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_octActionPerformed
    try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            
                pst = con.prepareStatement("select * from attendance_oct;");
                todayMonth.setText("OCTOBER");
                rs = pst.executeQuery();        
            
            
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_octActionPerformed

    private void novActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novActionPerformed
       try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            
                pst = con.prepareStatement("select * from attendance_nov;");
                todayMonth.setText("NOVEMBER");
                rs = pst.executeQuery();        
            
            
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_novActionPerformed

    private void decActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decActionPerformed
       try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            
                pst = con.prepareStatement("select * from attendance_dec;");
                todayMonth.setText("DECEMBER");
                rs = pst.executeQuery();        
            
            
            TableRowSorter sort = new TableRowSorter<> (model);
            attendlist.setRowSorter(sort);
            while (rs.next()) 
             {
                Object[] row = 
                    {
                            rs.getInt("id"),
                            rs.getString("datetime"),
                            rs.getString("name"),
                            rs.getString("section"),
                    };
                    model.addRow(row);
             }
            //------//
            } catch (SQLException ex) {
            Logger.getLogger(Inpur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_decActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
            Inpur second = new Inpur();
            second.setVisible(true);

            this.dispose();
        
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(main_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new main_menu().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(main_menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apr;
    private javax.swing.JTable attendlist;
    private javax.swing.JButton aug;
    private javax.swing.JButton back;
    private javax.swing.JButton dec;
    private javax.swing.JButton feb;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jan;
    private javax.swing.JButton jul;
    private javax.swing.JButton jun;
    private javax.swing.JButton mar;
    private javax.swing.JButton may;
    private javax.swing.JButton nov;
    private javax.swing.JButton oct;
    private javax.swing.JButton sep;
    private javax.swing.JLabel todayMonth;
    // End of variables declaration//GEN-END:variables
}
