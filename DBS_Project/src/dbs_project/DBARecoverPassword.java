/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sichi
 */
public class DBARecoverPassword extends javax.swing.JFrame {

    /**
     * Creates new form DBARecoverPassword
     */
    public DBARecoverPassword() {
        initComponents();
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
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
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        l2 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        pw = new javax.swing.JPasswordField();
        pw1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Username :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 59, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 5, 101));
        jLabel2.setText("Enter details of the account you want to create a new password for :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setText("Create new password :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 97, 116, -1));

        jLabel4.setText("Confirm new password :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 135, -1, -1));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 256, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 56, 127, -1));

        l2.setForeground(new java.awt.Color(204, 204, 204));
        l2.setText("Password Succesfully Changed!!!");
        getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 230, -1, -1));

        l1.setForeground(new java.awt.Color(204, 204, 204));
        l1.setText("Passwords Dont Match.");
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 210, -1, -1));

        l3.setForeground(new java.awt.Color(204, 204, 204));
        l3.setText("Same as your old password.");
        getContentPane().add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 250, -1, -1));
        getContentPane().add(pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 94, 127, -1));
        getContentPane().add(pw1, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 132, 127, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbs_project/d_login.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String uname=jTextField1.getText();
        String npass=new String(pw.getPassword());
        String cnpass1=new String(pw1.getPassword());
        if(npass.equals(cnpass1)&&(!npass.isEmpty()))
        {    String cnpass=HashingPassword.hashPassword(cnpass1);   
            try{
             Connection conn = Conn.connect();
             PreparedStatement pst =   conn.prepareStatement("Select * from login where username = '"
                                +uname+"'");
            ResultSet rs = pst.executeQuery();    
            if(rs.next()){
                String oldpassword=rs.getString(2);
                if(!(oldpassword.equals(HashingPassword.hashPassword(npass))))
                    {
                        PreparedStatement pst1 =   conn.prepareStatement("update login set password='"+cnpass+"'where username='"+uname+"';");
                        pst1.executeUpdate();
                        l2.setVisible(true);
                    }
                else {
                    l3.setVisible(true);
            }
            }
            } catch (SQLException ex) {
                Logger.getLogger(AccountSettings.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
        {
           l1.setVisible(true); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DBARecoverPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DBARecoverPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DBARecoverPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DBARecoverPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DBARecoverPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JPasswordField pw;
    private javax.swing.JPasswordField pw1;
    // End of variables declaration//GEN-END:variables
}
