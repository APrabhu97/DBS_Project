/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import com.alee.laf.WebLookAndFeel;
import java.sql.SQLException;

/**
 *
 * @author mahe
 */
public class Login extends javax.swing.JFrame {
    public static String username;
    
    /**
     * Creates new form Login
     */
    public Login() {
        
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
        tf1 = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        pw = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Username:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 64, 73, 39));

        jLabel2.setText("Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 129, 73, 43));

        tf1.setBackground(new java.awt.Color(205, 205, 186));
        getContentPane().add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 64, 165, 39));

        submit.setText("Login");
        submit.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 211, 164, 32));

        pw.setBackground(new java.awt.Color(205, 204, 186));
        getContentPane().add(pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 129, 165, 43));

        jButton2.setText("Register");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 211, 157, 32));
        getContentPane().add(jScrollBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, 300));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbs_project/d_login.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents


private boolean validate_login(String username1,String password) {
   try{          //Connection Code 
       Connection conn = Conn.connect();
       PreparedStatement pst =   conn.prepareStatement("Select * from login where username = '"
                                +username1+"' and password = '"+password+"'");
       ResultSet rs = pst.executeQuery();    
       
       username=username1;
       if(rs.next())            
       {
           conn.close();
       return true;
       }    
       else
       {    conn.close();
           return false;
       }            
   }
   catch(Exception e){
       e.printStackTrace();
       return false;
   }       
}
int numberOfTries = 3;
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        
       
            String username1= tf1.getText();
            String password = new String(pw.getPassword());
            String hashedPassword = password;
           // String hashedPassword = generateHash(password);
           MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            hashedPassword = DatatypeConverter.printHexBinary(hash);
            } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println(hashedPassword);
            if(validate_login(username1,hashedPassword)){
                
                    JOptionPane.showMessageDialog(null, "Authenticated");
                    numberOfTries=3; //reseting no. of tries
                    try {
                    Connection conn = Conn.connect();
                    PreparedStatement pst =   conn.prepareStatement("Select * from warden_details where warden_username = '"
                            +username1+"'");
                    ResultSet rs = pst.executeQuery();    
                   
                    if(rs.next())            
                    {       conn.close();
                        new Warden().setVisible(true);
                          this.setVisible(false);
                    }   
                    } 
                    catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                    try{
                Connection conn = Conn.connect();
                    PreparedStatement pst1 =   conn.prepareStatement("Select * from caretaker_details where caretaker_username = '"
                            +username1+"'");
                    ResultSet rs1 = pst1.executeQuery();    
                    
                    if(rs1.next())            
                    {  
                        conn.close();
                        new Caretaker().setVisible(true);
                          this.setVisible(false);
                    }   
                    } 
                    catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                     try{
                Connection conn = Conn.connect();
                    PreparedStatement pst2 =   conn.prepareStatement("Select * from student where student_username = '"
                            +username1+"'");
                    ResultSet rs2 = pst2.executeQuery();    
                   
                    if(rs2.next())            
                    {  
                        conn.close();
                        new Student().setVisible(true);
                          this.setVisible(false);
                    }   
                    } 
                    catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                     if(username1.equals("DBA")){
                         this.setVisible(false);
                         new DBA().setVisible(true);
                         
                     }
            }
            else{
                numberOfTries--;
                if(numberOfTries==0){
                    JOptionPane.showMessageDialog(null,"Login Failed\nPlease Try Later");
                    System.exit(0);         //exit if exceeds no. of tries
                }
                Object[] options = {"Yes",
                        "No",
                        "Register"};
                int n = JOptionPane.showOptionDialog(null,
                            "Do you want to try again?\n"+numberOfTries+" tries remain",
                            "Login Failed",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[2]);
                if(n==2){                                   //chooses register button
                    new Register().setVisible(true);        //go to register form
                    this.setVisible(false);
                }
                else if(n==1)                               // chooses no button
                    System.exit(0);
                else{                                       //wants to try again
                    tf1.setText("");
                    pw.setText("");
                }
            }
    }//GEN-LAST:event_submitActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Register().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//        try {
//        UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
//        } catch (Exception e) {
//    e.printStackTrace();
//        }
//try {
  //  UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
//} catch (Exception e) {
    //e.printStackTrace();
//}//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                WebLookAndFeel.install(true);
                WebLookAndFeel.setDecorateAllWindows(true);
                 new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JPasswordField pw;
    private javax.swing.JButton submit;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
