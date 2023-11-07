
import java.io.File;
import javax.swing.*;


public class User_Signup extends javax.swing.JFrame {

       File selectedfile;
       
    public User_Signup() {
        initComponents();
        setSize(700,600);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        tf_username = new javax.swing.JTextField();
        jp1 = new javax.swing.JPasswordField();
        tf_email = new javax.swing.JTextField();
        tf_mobile = new javax.swing.JTextField();
        bt_select = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bt = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(tf_username);
        tf_username.setBounds(210, 70, 360, 22);

        jp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jp1ActionPerformed(evt);
            }
        });
        getContentPane().add(jp1);
        jp1.setBounds(210, 130, 360, 22);

        tf_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_emailActionPerformed(evt);
            }
        });
        getContentPane().add(tf_email);
        tf_email.setBounds(210, 250, 360, 22);

        tf_mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_mobileActionPerformed(evt);
            }
        });
        getContentPane().add(tf_mobile);
        tf_mobile.setBounds(210, 190, 360, 22);

        bt_select.setText("Choose Photo");
        bt_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_selectActionPerformed(evt);
            }
        });
        getContentPane().add(bt_select);
        bt_select.setBounds(190, 320, 190, 50);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(447, 340, 130, 16);

        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(77, 70, 80, 16);

        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(77, 140, 70, 16);

        jLabel4.setText("Mobile");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(77, 190, 70, 16);

        jLabel5.setText("Email");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 250, 70, 20);

        jLabel6.setText("Profile Photo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(57, 330, 70, 30);

        bt.setText("Submit");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(270, 440, 140, 23);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("SIGN UP");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(247, 20, 90, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jp1ActionPerformed

    private void tf_mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_mobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_mobileActionPerformed

    private void tf_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_emailActionPerformed

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_usernameActionPerformed

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
       String u = tf_username.getText().trim();
        String p=jp1.getText();
         String m=tf_mobile.getText().trim();
          String e=tf_email.getText().trim();
          
          
          
          
          
          if(u.equals("")|| p.equals("")||m.equals("")||e.equals("")){
              
              JOptionPane.showMessageDialog(this, "All Fields are Compulsory !!!!");
          }
          else if(selectedfile==null){
              
              
              JOptionPane.showMessageDialog(this,"Select a photo ");
          }
          else{
               String ans=  MyClient.signupUsingServer(u, p, m, e,selectedfile);
        
        JOptionPane.showMessageDialog(this, ans);
              
          }
       
        
        
        
        
        
    }//GEN-LAST:event_btActionPerformed

    private void bt_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_selectActionPerformed
      int ans=  jFileChooser1.showOpenDialog(this);
      
      if(ans==JFileChooser.APPROVE_OPTION){
          
          selectedfile =jFileChooser1.getSelectedFile();
      }
    }//GEN-LAST:event_bt_selectActionPerformed

    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User_Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JButton bt_select;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jp1;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_mobile;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
