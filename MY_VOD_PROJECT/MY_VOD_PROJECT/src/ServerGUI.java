
import java.awt.Color;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class ServerGUI extends javax.swing.JFrame {

  MyServer serverobj;
  boolean isserverrunning=false;
    public ServerGUI() {
        initComponents();
        setSize(800,500);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        btstart = new javax.swing.JButton();
        btstop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(380, 90, 37, 16);

        jScrollPane1.setViewportView(jEditorPane1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(145, 62, 490, 100);

        btstart.setText("START");
        btstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btstartActionPerformed(evt);
            }
        });
        getContentPane().add(btstart);
        btstart.setBounds(160, 270, 140, 50);

        btstop.setText("STOP");
        btstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btstopActionPerformed(evt);
            }
        });
        getContentPane().add(btstop);
        btstop.setBounds(480, 270, 130, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btstopActionPerformed
       serverobj.shutdown();
       jLabel1.setText("Server Stopped!!");
       jLabel1.setForeground(Color.RED);
    }//GEN-LAST:event_btstopActionPerformed

    private void btstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btstartActionPerformed
         try{
             if(isserverrunning){
         
                 
                 JOptionPane.showMessageDialog(this, "Server is already running!!");
                 
             }
             else{serverobj  =new MyServer(9000);
         jLabel1.setText("Server started");
         jLabel1.setForeground(Color.GREEN);
         
         isserverrunning=true;}
            
        }
        catch(Exception ex){
            
            
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.toString());
        }
        
    }//GEN-LAST:event_btstartActionPerformed

    /**
    
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
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btstart;
    private javax.swing.JButton btstop;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
