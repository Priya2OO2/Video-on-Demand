
import java.io.File;
import javax.swing.*;

public class Add_Category_1 extends javax.swing.JFrame 
{
    File selectedfile;
    
    public Add_Category_1() 
    {
        initComponents();
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600,400);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        tf1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btadd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(tf1);
        tf1.setBounds(250, 90, 170, 30);

        jLabel1.setText("Category Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 100, 150, 17);

        bt1.setText("Select");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(250, 150, 170, 23);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(440, 150, 120, 17);

        jLabel3.setText("Photo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 150, 80, 17);

        btadd.setText("Add");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });
        getContentPane().add(btadd);
        btadd.setBounds(250, 210, 130, 30);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setText("Add New Category");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 30, 280, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        
        int ans  = jFileChooser1.showOpenDialog(this);
        
        if(ans==JFileChooser.APPROVE_OPTION)
        {
            selectedfile = jFileChooser1.getSelectedFile();
        }
        
    }//GEN-LAST:event_bt1ActionPerformed

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed
        
        String catname = tf1.getText().trim();
        
        String ans = MyClient.addCategory(catname, selectedfile);
        
        JOptionPane.showMessageDialog(this, ans);
        
    }//GEN-LAST:event_btaddActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Category_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Category_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Category_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Category_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Category_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton btadd;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
