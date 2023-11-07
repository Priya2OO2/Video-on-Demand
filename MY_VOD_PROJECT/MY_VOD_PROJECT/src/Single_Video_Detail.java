
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Single_Video_Detail extends javax.swing.JFrame 
{
    int vid;
    String vname;
    String desc;
    String photo;
    String catname;
    int runningtime;
    String trailerlink;
    String videolink;
    
    public Single_Video_Detail(int vid)
    {
        initComponents();
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800,400);
        
        lbposter.setSize(400,400);
        
        setVisible(true);
        
        fetchVideoDetail(vid);
    }
    
    void fetchVideoDetail(int vid)
    {
           String ans = MyClient.getSingleVideoDetailFromServer(vid);
           
           JOptionPane.showMessageDialog(this, ans);
           
           StringTokenizer st = new StringTokenizer(ans, ",");
           
           vname = st.nextToken();
           desc = st.nextToken();
           photo = st.nextToken();
           videolink = st.nextToken();
           trailerlink = st.nextToken();
           catname = st.nextToken();
           runningtime = Integer.parseInt(st.nextToken());
          
           try 
            {
                BufferedImage bi = ImageIO.read(new File(photo));
                
                bi = scale(bi, 400, 400);
                
                lbposter.setIcon(new ImageIcon(bi));
            } 
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
           
           
           
           lbname.setText(vname);
           lbdesc.setText(desc);
           lbcat.setText(catname);
           lbrunning.setText(runningtime+" Minutes");
    }
    
     public static BufferedImage scale(BufferedImage src, int w, int h) 
    {
        BufferedImage img
                = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int x, y;
        
        int ww = src.getWidth();
        int hh = src.getHeight();
        
        int[] ys = new int[h];
        for (y = 0; y < h; y++) {
            ys[y] = y * hh / h;
        }
        for (x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbposter = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        lbdesc = new javax.swing.JLabel();
        lbrunning = new javax.swing.JLabel();
        bttrailer = new javax.swing.JButton();
        btmovie = new javax.swing.JButton();
        lbcat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbposter.setText("jLabel1");
        getContentPane().add(lbposter);
        lbposter.setBounds(0, 0, 370, 350);

        lbname.setText("Name");
        getContentPane().add(lbname);
        lbname.setBounds(430, 20, 90, 17);

        lbdesc.setText("Description");
        getContentPane().add(lbdesc);
        lbdesc.setBounds(430, 50, 290, 30);

        lbrunning.setText("Running Time");
        getContentPane().add(lbrunning);
        lbrunning.setBounds(430, 100, 110, 17);

        bttrailer.setText("Play Trailer");
        bttrailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttrailerActionPerformed(evt);
            }
        });
        getContentPane().add(bttrailer);
        bttrailer.setBounds(430, 180, 170, 40);

        btmovie.setText("Play Movie");
        btmovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmovieActionPerformed(evt);
            }
        });
        getContentPane().add(btmovie);
        btmovie.setBounds(430, 250, 170, 40);

        lbcat.setText("Category");
        getContentPane().add(lbcat);
        lbcat.setBounds(430, 130, 150, 17);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttrailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttrailerActionPerformed
       
        try
        {
            Desktop.getDesktop().browse(URI.create(trailerlink));
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
        
    }//GEN-LAST:event_bttrailerActionPerformed

    private void btmovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmovieActionPerformed
        
        MyClient.playMovie(videolink);
        
    }//GEN-LAST:event_btmovieActionPerformed

   
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
            java.util.logging.Logger.getLogger(Single_Video_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Single_Video_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Single_Video_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Single_Video_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Single_Video_Detail(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmovie;
    private javax.swing.JButton bttrailer;
    private javax.swing.JLabel lbcat;
    private javax.swing.JLabel lbdesc;
    private javax.swing.JLabel lbname;
    private javax.swing.JLabel lbposter;
    private javax.swing.JLabel lbrunning;
    // End of variables declaration//GEN-END:variables
}
