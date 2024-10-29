/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lbrryattendance;

import com.mysql.cj.xdevapi.Statement;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Inpur extends javax.swing.JFrame {
    //the msql infortant stuffs
    Connection con;
    ResultSet rs ;
    PreparedStatement pst;    
    
    // Global Variables//
    private Timer timer; 
    LocalDateTime now = LocalDateTime.now();
    int month = now.getMonthValue();
    
    //DATA MANIPULATION GUARD
    JTextField password = new JPasswordField();
    Object[] message = { "Password:", password };
    String madmin_key = "32304";
    
    
    //MONTH IDNTCATOR
    String monthNow = insertAttendanceCalendar();
    
    //=================//
    
    public Inpur() {
        initComponents();
        try 
        {
            //========================Connection===============//
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryttndncsql","root","_Magiec24");
            //================================================//
            
            //================TIME RELATED==============================//
            attendanceCalendar(month);
           
            currDateTIme();
            
           //===========================================================//
           
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
  
    private void attendanceCalendar(int month) //SEASONAL ATTENDANCE CALENDAR
        {
            try 
            {
            DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
            model.setRowCount(0);
            
            if (month == Month.JANUARY.getValue()) {
                pst = con.prepareStatement("select * from attendance_jan;");
                todayMonth.setText("JANUARY");
                rs = pst.executeQuery();        
            } 
            else if (month == Month.FEBRUARY.getValue()) {
                pst = con.prepareStatement("select * from attendance_feb;");
                todayMonth.setText("FEBRUARY");
                rs = pst.executeQuery();
            } 
            else if (month == Month.MARCH.getValue()) {
                pst = con.prepareStatement("select * from attendance_mar;");
                todayMonth.setText("MARCH");
                rs = pst.executeQuery();
            }
            else if (month == Month.APRIL.getValue()) {
                pst = con.prepareStatement("select * from attendance_apr;");
                todayMonth.setText("APRIL");
                rs = pst.executeQuery();
            }
            else if (month == Month.MAY.getValue()) {
                pst = con.prepareStatement("select * from attendance_may;");
                todayMonth.setText("MAY");
                rs = pst.executeQuery();
            }
            else if (month == Month.JUNE.getValue()) {
                pst = con.prepareStatement("select * from attendance_jun;");
                todayMonth.setText("JUNE");
                rs = pst.executeQuery();
            }
            else if (month == Month.JULY.getValue()) {
                pst = con.prepareStatement("select * from attendance_july;");
                todayMonth.setText("JULY");
                rs = pst.executeQuery();
            }
            else if (month == Month.AUGUST.getValue()) {
                pst = con.prepareStatement("select * from attendance_aug;");
                todayMonth.setText("AUGUST");
                rs = pst.executeQuery();
            }
            else if (month == Month.SEPTEMBER.getValue()) {
                pst = con.prepareStatement("select * from attendance_sep;");
                todayMonth.setText("SEPTEMBER");
                rs = pst.executeQuery();
            }
            else if (month == Month.NOVEMBER.getValue()) {
                pst = con.prepareStatement("select * from attendance_may;");
                todayMonth.setText("NOVEMBER");
                rs = pst.executeQuery();
            }
            else if (month == Month.DECEMBER.getValue()) {
                pst = con.prepareStatement("select * from attendance_dec;");
                todayMonth.setText("DECEMBER");
                rs = pst.executeQuery();
            }
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
            JOptionPane.showMessageDialog(null,ex);
        }
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
         else if (month == Month.JUNE.getValue()) {
                return "jun";            
        }
          else if (month == Month.JULY.getValue()) {
                return "jul";            
        }
           else if (month == Month.AUGUST.getValue()) {
                return "aug";            
        }
           else if (month == Month.SEPTEMBER.getValue()) {
                return "sep";            
        }
            else if (month == Month.OCTOBER.getValue()) {
                return "oct";            
        }
             else if (month == Month.NOVEMBER.getValue()) {
                return "nov";            
        }
              else if (month == Month.DECEMBER.getValue()) {
                return "dec";            
        } 
        else{
        return null;} 
        }
        public void currDateTIme() //FOR LIVE DATE AND TIEM DISPLAY
        { 
            timer = new javax.swing.Timer(1000, (ActionEvent evt) -> 
            {
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd || HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            dateNtime.setText(dt.format(now));
            });
            timer.start(); 
        }
 
        public void clearAfter(){     stuID.setText("");last_name.setText("");first_name.setText("");stuSection.setSelectedIndex(0);}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        del = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendlist = new javax.swing.JTable();
        MAIN = new javax.swing.JPanel();
        stuSection = new javax.swing.JComboBox<>();
        stuID = new javax.swing.JTextField();
        first_name = new javax.swing.JTextField();
        last_name = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        sectionn1 = new javax.swing.JLabel();
        sectionHint = new javax.swing.JLabel();
        stuIDHint = new javax.swing.JLabel();
        nameHint = new javax.swing.JLabel();
        nameHint2 = new javax.swing.JLabel();
        todayMonth = new javax.swing.JLabel();
        dateNtime = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        clear_section = new javax.swing.JButton();
        clear_name = new javax.swing.JButton();
        clear_id = new javax.swing.JButton();
        clear_name1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        clear_all = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NEUST LIBRARY ACCESS LOG");
        setBackground(new java.awt.Color(204, 255, 102));
        setMinimumSize(new java.awt.Dimension(1218, 584));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(226, 226, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon("C:\\Users\\jervi\\OneDrive\\Desktop\\Java RIce\\JAVA\\lbrryAttendance\\ICON\\history.png")); // NOI18N
        back.setText("OTHER LOGS");
        back.setToolTipText("OTHER ATTENDANCE LOGS");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 720, 160, 50));

        del.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        del.setForeground(new java.awt.Color(255, 255, 255));
        del.setIcon(new javax.swing.ImageIcon("C:\\Users\\jervi\\OneDrive\\Desktop\\Java RIce\\JAVA\\lbrryAttendance\\ICON\\delete.png")); // NOI18N
        del.setToolTipText("DELETES A DATA");
        del.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });
        jPanel1.add(del, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 720, 50, 50));

        attendlist.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        attendlist.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 10)); // NOI18N
        attendlist.setForeground(new java.awt.Color(51, 51, 51));
        attendlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATE / TIME", "NAME", "SECTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        attendlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(attendlist);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 630, 590));

        MAIN.setBackground(new java.awt.Color(255, 255, 255));
        MAIN.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 224, 140), 4, true));
        MAIN.setForeground(new java.awt.Color(255, 202, 89));
        MAIN.setAlignmentX(10.0F);

        stuSection.setBackground(new java.awt.Color(204, 204, 255));
        stuSection.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        stuSection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT SECTION", "BSIT 1A", "BSIT 1B", "BSIT 1C", "BSIT 1D", "BSIT 1E", "BSIT 2A", "BSIT 2B", "BSIT 2C", "BSIT 2D", "BSIT 3A", "BSIT 3B" }));
        stuSection.setToolTipText("");
        stuSection.setAutoscrolls(true);
        stuSection.setBorder(null);
        stuSection.setName(""); // NOI18N
        stuSection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stuSectionMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                stuSectionMouseReleased(evt);
            }
        });

        stuID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        stuID.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        stuID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stuIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stuIDKeyTyped(evt);
            }
        });

        first_name.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        first_name.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        first_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                first_nameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                first_nameKeyTyped(evt);
            }
        });

        last_name.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        last_name.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        last_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                last_nameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                last_nameKeyTyped(evt);
            }
        });

        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jSeparator4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jSeparator3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setText("SECTION");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("STUDENT ID");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel5.setText("LAST NAME");

        firstname.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        firstname.setText("FIRST NAME");

        sectionn1.setText("....");

        sectionHint.setFont(new java.awt.Font("Rockwell", 0, 8)); // NOI18N
        sectionHint.setForeground(new java.awt.Color(255, 0, 0));
        sectionHint.setToolTipText("");

        stuIDHint.setFont(new java.awt.Font("Rockwell", 0, 8)); // NOI18N
        stuIDHint.setForeground(new java.awt.Color(255, 0, 0));

        nameHint.setFont(new java.awt.Font("Rockwell", 0, 8)); // NOI18N
        nameHint.setForeground(new java.awt.Color(255, 0, 51));
        nameHint.setToolTipText("");

        nameHint2.setFont(new java.awt.Font("Rockwell", 0, 8)); // NOI18N
        nameHint2.setForeground(new java.awt.Color(255, 0, 51));
        nameHint2.setToolTipText("");

        todayMonth.setBackground(new java.awt.Color(0, 0, 0));
        todayMonth.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        todayMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        todayMonth.setText("MONTH");
        todayMonth.setToolTipText("");
        todayMonth.setVerifyInputWhenFocusTarget(false);

        dateNtime.setBackground(new java.awt.Color(51, 51, 51));
        dateNtime.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        dateNtime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateNtime.setText("yyyy/MM/dd || HH:mm:ss");

        submit.setBackground(new java.awt.Color(62, 57, 57));
        submit.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 51));
        submit.setText("SUBMIT");
        submit.setBorder(null);
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        clear_section.setBackground(new java.awt.Color(235, 235, 235));
        clear_section.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        clear_section.setForeground(new java.awt.Color(255, 255, 255));
        clear_section.setIcon(new javax.swing.ImageIcon("C:\\Users\\jervi\\OneDrive\\Desktop\\Java RIce\\JAVA\\lbrryAttendance\\ICON\\clear_solo.png")); // NOI18N
        clear_section.setBorder(null);
        clear_section.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_sectionActionPerformed(evt);
            }
        });

        clear_name.setBackground(new java.awt.Color(235, 235, 235));
        clear_name.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        clear_name.setForeground(new java.awt.Color(255, 255, 255));
        clear_name.setIcon(new javax.swing.ImageIcon("C:\\Users\\jervi\\OneDrive\\Desktop\\Java RIce\\JAVA\\lbrryAttendance\\ICON\\clear_solo.png")); // NOI18N
        clear_name.setBorder(null);
        clear_name.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_nameActionPerformed(evt);
            }
        });

        clear_id.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        clear_id.setForeground(new java.awt.Color(255, 255, 255));
        clear_id.setIcon(new javax.swing.ImageIcon("C:\\Users\\jervi\\OneDrive\\Desktop\\Java RIce\\JAVA\\lbrryAttendance\\ICON\\clear_solo.png")); // NOI18N
        clear_id.setBorder(null);
        clear_id.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_idActionPerformed(evt);
            }
        });

        clear_name1.setBackground(new java.awt.Color(235, 235, 235));
        clear_name1.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        clear_name1.setForeground(new java.awt.Color(255, 255, 255));
        clear_name1.setIcon(new javax.swing.ImageIcon("C:\\Users\\jervi\\OneDrive\\Desktop\\Java RIce\\JAVA\\lbrryAttendance\\ICON\\clear_solo.png")); // NOI18N
        clear_name1.setBorder(null);
        clear_name1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_name1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MAINLayout = new javax.swing.GroupLayout(MAIN);
        MAIN.setLayout(MAINLayout);
        MAINLayout.setHorizontalGroup(
            MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAINLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(todayMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(sectionHint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addComponent(stuIDHint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addComponent(stuID, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear_id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stuSection, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MAINLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sectionn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clear_section, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addComponent(nameHint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addComponent(nameHint2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addComponent(first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(clear_name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(dateNtime, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MAINLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );
        MAINLayout.setVerticalGroup(
            MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAINLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(todayMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateNtime, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addComponent(sectionn1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(clear_section, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stuSection, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MAINLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stuID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MAINLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(clear_id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MAINLayout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MAINLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(MAINLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(clear_name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(stuIDHint)))
                    .addComponent(sectionHint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameHint)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MAINLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MAINLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGroup(MAINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameHint2)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel1.add(MAIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 500, 590));

        update.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lbrryattendance/edit-text (1).png"))); // NOI18N
        update.setText("EDIT TEXT");
        update.setToolTipText("EDIT TEXT");
        update.setBorder(new javax.swing.border.MatteBorder(null));
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 720, 120, 50));

        clear_all.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        clear_all.setText("CLEAR ALL");
        clear_all.setToolTipText("CLEAR ALL TEXT");
        clear_all.setBorder(null);
        clear_all.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_allActionPerformed(evt);
            }
        });
        jPanel1.add(clear_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 720, 110, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -50, 1250, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        try {
                DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
                int selectedRow = attendlist.getSelectedRow();
                String id = model.getValueAt(selectedRow, 1).toString();
                
                int option = JOptionPane.showConfirmDialog(null, "ARE YOU SURE", "REQUEST ADMIN FOR DELETION", JOptionPane.OK_CANCEL_OPTION);
                int option2 = JOptionPane.showConfirmDialog(null, message, "", JOptionPane.OK_CANCEL_OPTION);
                if (option2 == JOptionPane.OK_OPTION && password.getText().equals(madmin_key))
            {//IF STARTS
                String monthNow = insertAttendanceCalendar();
                pst = con.prepareStatement("DELETE FROM attendance_" + monthNow + " WHERE datetime=?");
                pst.setString(1, id);
                pst.executeUpdate();
                    /// =======================REFRESH==========//
                        model.setRowCount(0);
                        attendanceCalendar(month);
                    // ======================================= //    
            JOptionPane.showMessageDialog(this, "DATA DELETED");
            clearAfter();
            submit.setEnabled(true);
            }//if ends
                else   {   JOptionPane.showMessageDialog(null, "Request Admin for DELETION"); password.setText(""); }
            } catch (SQLException ex) 
                    {
                       JOptionPane.showMessageDialog(null,ex);
                    }       
    }//GEN-LAST:event_delActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String section = stuSection.getSelectedItem().toString();
        String fname = first_name.getText();
       if (stuID.getText().trim().isEmpty() && last_name.getText().trim().isEmpty() &&  first_name.getText().trim().isEmpty() &&section.equals("SELECT SECTION") )
            {
               stuIDHint.setText("ENTER STUDENT ID");
               sectionHint.setText("SELECT SECTION");
               nameHint.setText("ENTER LAST NAME");
               nameHint2.setText("ENTER FIRST NAME");
            }
        else if (stuID.getText().trim().isEmpty() && last_name.getText().trim().isEmpty())
        {
                   stuIDHint.setText("ENTER STUDENT ID");
                   nameHint.setText("ENTER FULL NAME");
        }
        else if (stuID.getText().trim().isEmpty() && section.equals("SELECT SECTION") )
        {
                    stuIDHint.setText("ENTER STUDENT ID");
                    sectionHint.setText("SELECT SECTION");
        }
         else if (stuID.getText().trim().isEmpty() && first_name.getText().trim().isEmpty())
        {
                   stuIDHint.setText("ENTER STUDENT ID");
                   nameHint2.setText("ENTER FIRST NAME");
        }
        else if (stuID.getText().trim().isEmpty())
        {
                    stuIDHint.setText("ENTER STUDENT ID");
        }
        else if (last_name.getText().trim().isEmpty())
        {
                    nameHint.setText("ENTER FULL NAME");
        }
         else if (first_name.getText().trim().isEmpty())
        {
                    nameHint2.setText("ENTER FIRST NAME");
        }
        else if (section.equals("SELECT SECTION"))
        {
                    sectionHint.setText("SELECT SECTION");
        }
        else {
            try {
            pst = con.prepareStatement("INSERT INTO attendance_" + monthNow + " (id, datetime, name, section) VALUES (?, ?, ?, ?)");
            pst.setString(1, stuID.getText());
            pst.setString(2, dateNtime.getText());
            pst.setString(3, fname + " "+ last_name.getText()  );
            pst.setString(4, section);;
            pst.executeUpdate();        
            /// =======================REFRESH==========//
                   attendanceCalendar(month);
            // ======================================= //
            JOptionPane.showMessageDialog(this, "DATA SUBMITED");
            clearAfter();
        }   catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,ex);
            }
        }
    }//GEN-LAST:event_submitActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String section = stuSection.getSelectedItem().toString();
        String fname = first_name.getText();
        if (stuID.getText().trim().isEmpty() && last_name.getText().trim().isEmpty() &&  first_name.getText().trim().isEmpty() &&section.equals("SELECT SECTION") )
            {
               stuIDHint.setText("ENTER STUDENT ID");
               sectionHint.setText("SELECT SECTION");
               nameHint.setText("ENTER LAST NAME");
               nameHint2.setText("ENTER FIRST NAME");
            }
        else if (stuID.getText().trim().isEmpty() && last_name.getText().trim().isEmpty())
        {
                   stuIDHint.setText("ENTER STUDENT ID");
                   nameHint.setText("ENTER FULL NAME");
        }
        else if (stuID.getText().trim().isEmpty() && section.equals("SELECT SECTION") )
        {
                    stuIDHint.setText("ENTER STUDENT ID");
                    sectionHint.setText("SELECT SECTION");
        }
         else if (stuID.getText().trim().isEmpty() && first_name.getText().trim().isEmpty())
        {
                   stuIDHint.setText("ENTER STUDENT ID");
                   nameHint2.setText("ENTER FIRST NAME");
        }
        else if (stuID.getText().trim().isEmpty())
        {
                    stuIDHint.setText("ENTER STUDENT ID");
        }
        else if (last_name.getText().trim().isEmpty())
        {
                    nameHint.setText("ENTER FULL NAME");
        }
         else if (first_name.getText().trim().isEmpty())
        {
                    nameHint2.setText("ENTER FIRST NAME");
        }
        else if (section.equals("SELECT SECTION"))
        {
                    sectionHint.setText("SELECT SECTION");
        }
        else {
        try {
                int option = JOptionPane.showConfirmDialog(null, message, "REQUEST ADMIN FOR TEXT ALTERING", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                if (!password.getText().equals(madmin_key)) 
                {//if startr    
        DefaultTableModel model = (DefaultTableModel) attendlist.getModel();
        int selectedRow = attendlist.getSelectedRow();
            String id = model.getValueAt(selectedRow, 0).toString();
            pst = con.prepareStatement("update attendance_" + monthNow +" SET id=?, datetime=?, name=?, section=? where id=?");
            pst.setString(1, stuID.getText());
            pst.setString(2, dateNtime.getText());
            pst.setString(3, fname + " "+ last_name.getText() );
            pst.setString(4, section);
            pst.setString(5, id);
            pst.executeUpdate();
                /// =======================REFRESH==========//
                    attendanceCalendar(month);
                // ======================================= // 
               JOptionPane.showMessageDialog(this, "DATA UPDATED");
               clearAfter();
               submit.setEnabled(true);
                  }
                } //IF ENDS                
                else{   JOptionPane.showMessageDialog(null, "Request Admin for TEXT ALTERING");  password.setText("");  } //MISSION FAILED
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }    
        }
    }//GEN-LAST:event_updateActionPerformed

    private void stuIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuIDKeyTyped
        //no char text input
        int maxLength = 5; 
        String text = ((JTextField)evt.getSource()).getText();
        char c = evt.getKeyChar();
        if ( text.length() >= maxLength ||!Character.isDigit(c))
        {evt.consume();}
    }//GEN-LAST:event_stuIDKeyTyped

    private void stuIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuIDKeyReleased
        stuIDHint.setText("");
    }//GEN-LAST:event_stuIDKeyReleased

    private void last_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_last_nameKeyReleased
        nameHint.setText("");
    }//GEN-LAST:event_last_nameKeyReleased

    private void clear_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_allActionPerformed
       stuID.setText("");
       first_name.setText("");
       last_name.setText("");
       stuSection.setSelectedIndex(0);
       submit.setEnabled(true);
    }//GEN-LAST:event_clear_allActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
int option = JOptionPane.showConfirmDialog(null, message, "", JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION) {
    if (!password.getText().equals(madmin_key)) {
        JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD");  password.setText("");
        }

    else{
            try {
                main_menu second = new main_menu();
                second.setVisible(true);
                this.dispose();
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex);
        }
    }
}
    }//GEN-LAST:event_backActionPerformed

    private void clear_sectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_sectionActionPerformed
        stuSection.setSelectedIndex(0); clearAfter(); submit.setEnabled(true);
    }//GEN-LAST:event_clear_sectionActionPerformed

    private void clear_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_nameActionPerformed
  last_name.setText("");
    }//GEN-LAST:event_clear_nameActionPerformed

    private void attendlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendlistMouseClicked
        int selectedRow = attendlist.getSelectedRow();
        String section = stuSection.getSelectedItem().toString();
        stuID.setText(attendlist.getValueAt(selectedRow, 0).toString());
       
       submit.setEnabled(false); // UPDATE/DELETE ONLY 
        
       stuIDHint.setText(""); //HINTS REMOCED
       nameHint.setText("");
       nameHint2.setText("");
       sectionHint.setText("");
    }//GEN-LAST:event_attendlistMouseClicked

    private void clear_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_idActionPerformed
stuID.setText(""); 
    }//GEN-LAST:event_clear_idActionPerformed

    private void last_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_last_nameKeyTyped
    nameHint.setText("");
    }//GEN-LAST:event_last_nameKeyTyped

    private void stuSectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSectionMouseClicked
        sectionHint.setText("");
    }//GEN-LAST:event_stuSectionMouseClicked

    private void stuSectionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSectionMouseReleased
             sectionHint.setText("");
    }//GEN-LAST:event_stuSectionMouseReleased

    private void first_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_first_nameKeyReleased
        nameHint2.setText("");
    }//GEN-LAST:event_first_nameKeyReleased

    private void first_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_first_nameKeyTyped
                nameHint2.setText("");
    }//GEN-LAST:event_first_nameKeyTyped

    private void clear_name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_name1ActionPerformed
       first_name.setText("");
    }//GEN-LAST:event_clear_name1ActionPerformed

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
            java.util.logging.Logger.getLogger(Inpur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inpur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inpur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inpur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Inpur().setVisible(true);   
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MAIN;
    private javax.swing.JTable attendlist;
    private javax.swing.JButton back;
    private javax.swing.JButton clear_all;
    private javax.swing.JButton clear_id;
    private javax.swing.JButton clear_name;
    private javax.swing.JButton clear_name1;
    private javax.swing.JButton clear_section;
    private javax.swing.JLabel dateNtime;
    private javax.swing.JButton del;
    private javax.swing.JTextField first_name;
    private javax.swing.JLabel firstname;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField last_name;
    private javax.swing.JLabel nameHint;
    private javax.swing.JLabel nameHint2;
    private javax.swing.JLabel sectionHint;
    private javax.swing.JLabel sectionn1;
    private javax.swing.JTextField stuID;
    private javax.swing.JLabel stuIDHint;
    private javax.swing.JComboBox<String> stuSection;
    private javax.swing.JButton submit;
    private javax.swing.JLabel todayMonth;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
