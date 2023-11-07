/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Test_Client_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Test_Client_GUI
     */
    public Test_Client_GUI() {
        initComponents();
        setSize(600,400);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bt.setText("Fetch Index From Server");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(175, 70, 250, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(187, 180, 240, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        String ans=MyClient.fetchIndex();
        jLabel1.setText(ans);
        
    }//GEN-LAST:event_btActionPerformed

   
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test_Client_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
