/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sichi
 */
public class Register_Caretaker extends javax.swing.JFrame {

    /**
     * Creates new form AddStudent
     */
    public Register_Caretaker() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        tf6 = new javax.swing.JTextField();
        tf7 = new javax.swing.JTextField();
        tf8 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf11 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tf12 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Name :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 54, -1, -1));

        jLabel2.setText("Caretaker ID :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 28, -1, -1));

        jLabel3.setText("Date Of Birth :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 86, -1, -1));

        jLabel5.setText("Block No :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 115, -1, -1));

        jLabel7.setText("Phone Number :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 175, -1, -1));

        jLabel8.setText("Email ID :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 144, -1, -1));

        jButton1.setText("Capture Image");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 82, -1, -1));

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 335, -1, -1));

        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 51, 82, -1));
        getContentPane().add(tf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 25, 82, -1));
        getContentPane().add(tf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 112, 82, -1));
        getContentPane().add(tf6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 172, 80, -1));
        getContentPane().add(tf7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 141, 84, -1));
        getContentPane().add(tf8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 83, 82, -1));

        jLabel6.setText("Username :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 213, -1, -1));
        getContentPane().add(tf11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 80, -1));

        jLabel13.setText("Password :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 251, -1, -1));
        getContentPane().add(tf12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 248, 80, -1));

        jLabel4.setText("Address :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 295, -1, -1));
        getContentPane().add(tf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 292, 80, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbs_project/d_login.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 520, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           if( tf1.getText()==null
                   || tf2.getText()==null
                    || tf3.getText()==null
                   || tf4.getText()==null
                   
                   || tf6.getText()==null
                   || tf7.getText()==null
                   || tf8.getText()==null
                   
                   ){
            JOptionPane.showMessageDialog(null,"Please fill all details");
            return;
        }
        else{
            String cID=tf2.getText();
            String Name =tf1.getText();
            String D_O_B =tf8.getText();
            //String Room_no =tf4.getText();
            String Block =tf4.getText();
            //String Semester =tf6.getText();
            String Email =tf7.getText();
            String phone =tf6.getText();
            //String Course =tf9.getText();
            String Address =tf3.getText();
            String uname=tf11.getText();
            String pass=tf12.getText();
            try {
               Connection conn = Conn.connect();
               PreparedStatement pst =   conn.prepareStatement("insert into caretaker_details values('"+cID+"','"+Name+"','"+D_O_B+"','"+Block+"','"+Email+"','"+phone+"','"+Address+"','"+uname+"')");
               pst.execute();
               String password=HashingPassword.hashPassword(pass);
               PreparedStatement pst1 =   conn.prepareStatement("insert into login values('"+uname+"','"+password+"')");
               pst1.execute();
               conn.close();
           } catch (SQLException ex) {
               Logger.getLogger(AddWatchlistEntry.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            JOptionPane.showMessageDialog(null,"Submitted Succesfully");
            
            
            
        }
                          
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed

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
            java.util.logging.Logger.getLogger(Register_Caretaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register_Caretaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register_Caretaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register_Caretaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register_Caretaker().setVisible(true);
            }
        });
    

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf11;
    private javax.swing.JTextField tf12;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf6;
    private javax.swing.JTextField tf7;
    private javax.swing.JTextField tf8;
    // End of variables declaration//GEN-END:variables
}
