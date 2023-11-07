import java.io.File;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Add_Video extends javax.swing.JFrame 
{
    Vector<String> catlist;
    
    File selectedposter;
    File selectedvideo;
    
    public Add_Video() 
    {   
        initComponents();
        
        setSize(800,600);
        
        loadCategories();
        
        // show category names of vector in combobox
        jComboBox1.setModel(new DefaultComboBoxModel<>(catlist));
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    void loadCategories()
    {
        catlist = new Vector<>();
        
        String ans = MyClient.getCategoriesFromServer();
        
        StringTokenizer st = new StringTokenizer(ans,";");
        
        int n  = st.countTokens();
        
        for(int i=1;i<=n;i++)
        {
            String singlecat = st.nextToken();
            
            StringTokenizer st2 = new StringTokenizer(singlecat,",");
            
            String catname = st2.nextToken();
            String photo = st2.nextToken();
            
            catlist.add(catname);
            
            System.out.println(catname);
        }
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        tf_trailer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tf_title = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_desc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_running = new javax.swing.JTextField();
        btadd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(tf_trailer);
        tf_trailer.setBounds(230, 300, 390, 23);

        jLabel1.setText("Title");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 90, 60, 17);
        getContentPane().add(tf_title);
        tf_title.setBounds(230, 90, 390, 23);

        jLabel2.setText("Short Description");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 140, 120, 17);
        getContentPane().add(tf_desc);
        tf_desc.setBounds(230, 140, 390, 23);

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 190, 130, 23);

        jLabel3.setText("Movie Poster");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 190, 90, 17);

        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(410, 190, 220, 17);

        jLabel5.setText("Video (MP4)");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 240, 100, 17);

        jButton2.setText("Select");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(230, 240, 130, 23);

        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(410, 240, 60, 17);

        jLabel7.setText("Trailer ( YouTube Link )");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(80, 300, 140, 17);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(230, 350, 140, 23);

        jLabel8.setText("Category");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 350, 70, 17);

        jLabel9.setText("Running Time");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(80, 400, 110, 17);
        getContentPane().add(tf_running);
        tf_running.setBounds(230, 400, 140, 23);

        btadd.setText("Add Video");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });
        getContentPane().add(btadd);
        btadd.setBounds(230, 450, 130, 40);

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel10.setText("ADD NEW MOVIE");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(230, 30, 240, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed

        String videoname = tf_title.getText().trim();
        String desc = tf_desc.getText().trim();
        
        String trailer = tf_trailer.getText().trim();
        
        String catname = jComboBox1.getSelectedItem().toString();
        
        int running_time = Integer.parseInt(tf_running.getText());
        
        String ans = MyClient.addVideo(videoname, desc, selectedposter, selectedvideo, trailer, catname, running_time);
        
        JOptionPane.showMessageDialog(this, ans);
    }//GEN-LAST:event_btaddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int ans  = jFileChooser1.showOpenDialog(this);
        
        if(ans==JFileChooser.APPROVE_OPTION)
        {
            selectedposter = jFileChooser1.getSelectedFile();
            jLabel4.setText(selectedposter.getName());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int ans  = jFileChooser2.showOpenDialog(this);
        
        if(ans==JFileChooser.APPROVE_OPTION)
        {
            selectedvideo = jFileChooser2.getSelectedFile();
            jLabel6.setText(selectedvideo.getName());
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Video.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Video.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Video.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Video.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Video().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btadd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tf_desc;
    private javax.swing.JTextField tf_running;
    private javax.swing.JTextField tf_title;
    private javax.swing.JTextField tf_trailer;
    // End of variables declaration//GEN-END:variables
}
