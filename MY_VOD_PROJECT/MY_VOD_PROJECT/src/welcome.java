import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.*;

public class welcome extends javax.swing.JFrame {
File obj = new File ("src//myuploads//Backgrounds//dddd.jpg/");
    
    public welcome(String u) {
        initComponents();
        
        jLabel4.setText("Categories"+u);
        
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700,600);
        setVisible(true);
        try
        {
            BufferedImage bi = ImageIO.read(obj);
            bi = scale(bi, 700, 600);
            jLabel1.setIcon(new ImageIcon(bi));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
         String ans = MyClient.getCategoriesFromServer();
        // JOptionPane.showMessageDialog(this,ans);
         System.out.println(ans);
         
         drawDynamicButtons(ans);
    }
    public static BufferedImage scale(BufferedImage src, int w, int h)
    {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int x, y;

        int ww = src.getWidth();
        int hh = src.getHeight();

        int[] ys = new int[h];
        for (y = 0; y < h; y++)
        {
            ys[y] = y * hh / h;
        }
        for (x = 0; x < w; x++)
        {
            int newX = x * ww / w;
            for (y = 0; y < h; y++)
            {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel4.setText("Categories");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 130, 210, 48);

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 220, 490, 160);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 600);

        pack();
    }// </editor-fold>                        

    
    void drawDynamicButtons(String ans)
              {
        StringTokenizer st  = new StringTokenizer(ans,";");
        
        int n = st.countTokens();
        
        System.out.println("No of tokens "+n);
        
        for(int i=1; i<=n; i++)
        {
            String singledata = st.nextToken();
            
            StringTokenizer st2 = new StringTokenizer(singledata,",");
            
            String catname = st2.nextToken();
            String photo = st2.nextToken();
            
            JButton bt = new JButton();
            
            bt.setText(catname);
            
            bt.setVerticalTextPosition(SwingConstants.BOTTOM);
            bt.setHorizontalTextPosition(SwingConstants.CENTER);
            
            try
            {
               BufferedImage bi = ImageIO.read(new File(photo)); 
                
               bi = scale(bi,100,100);
               
               bt.setIcon(new ImageIcon( bi));
            }
            catch(Exception ex)
            {
              ex.printStackTrace();
            }
            
            bt.setBounds((160*i),300,160,160);
            
            jPanel1.add(bt);
            
            //shortcut to create ActionListener and register with button
            bt.addActionListener(new ActionListener()
                    //aninymous inner class starts here
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                     //logic
                    View_Videos obj = new View_Videos(catname);
                }
            }//tillhere
            );
            
            
        }
        
        setVisible(false);
        setVisible(true);
    }
    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new welcome("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
