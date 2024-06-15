/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.io.InputStream;

/**
 *
 * @author Felix Coral
 */
public class Star extends javax.swing.JFrame {

    int Xmouse, Ymouse;

    /**
     * Creates new form Login
     */
    public Star() {
        initComponents();
        setRoundedShape();
        loadCustomFont();
        Movilidad.setBackground(new Color(0, 0, 0, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CerrarPanel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Movilidad = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        roundedPanel2 = new redondeado.RoundedPanel();
        PanelCambio = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(730, 490));
        setMinimumSize(new java.awt.Dimension(730, 490));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(152, 199, 202));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CerrarPanel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CerrarPanel.setForeground(new java.awt.Color(0, 0, 0));
        CerrarPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CerrarPanel.setText("X");
        CerrarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CerrarPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CerrarPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CerrarPanelMousePressed(evt);
            }
        });
        jPanel1.add(CerrarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 60, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Stude");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 29));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Icon Login.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 22, -1, -1));

        Movilidad.setBackground(new java.awt.Color(152, 199, 202));
        Movilidad.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MovilidadMouseDragged(evt);
            }
        });
        Movilidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MovilidadMousePressed(evt);
            }
        });
        Movilidad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Academy ");
        Movilidad.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 40));

        jPanel1.add(Movilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 40));

        roundedPanel2.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel2.setForeground(new java.awt.Color(255, 255, 255));
        roundedPanel2.setCornerRadius(30);
        roundedPanel2.setNormalColor(new java.awt.Color(255, 255, 255));
        roundedPanel2.setText("");
        roundedPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelCambio.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel2.add(PanelCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 400, 430));

        jPanel1.add(roundedPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 430, 490));

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("De Asistencias  y Justificaciones");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 130, 250, 40));

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Administración Efeciente ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 108, 200, 40));

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Bienvenido Al Sistema De");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 86, 190, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Si eres Docente , Incia Sesión ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 165, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Usuario De Docente");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 188, 110, 10));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Portada2 - Login.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 240, 220));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CerrarPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarPanelMouseEntered
        CerrarPanel.setForeground(Color.RED);
    }//GEN-LAST:event_CerrarPanelMouseEntered

    private void CerrarPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarPanelMouseExited
        CerrarPanel.setForeground(Color.BLACK);
    }//GEN-LAST:event_CerrarPanelMouseExited

    private void CerrarPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarPanelMousePressed
        System.exit(0);
    }//GEN-LAST:event_CerrarPanelMousePressed

    private void MovilidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovilidadMousePressed
        Xmouse = evt.getX();
        Ymouse = evt.getY();
    }//GEN-LAST:event_MovilidadMousePressed

    private void MovilidadMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovilidadMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - Xmouse, y - Ymouse);
    }//GEN-LAST:event_MovilidadMouseDragged

    //Fuentes
    private void loadCustomFont() {
        try {
            // Carga la fuente desde un archivo
            InputStream is = getClass().getResourceAsStream("/Fuentes/Arturo-Heavy_Outline_trial.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);

            // Deriva el tamaño de la fuente y aplica la fuente al JLabel
            jLabel1.setFont(font.deriveFont(Font.ITALIC + font.BOLD, 12f));
            jLabel2.setFont(font.deriveFont(Font.ITALIC + font.BOLD, 12f));
        } catch (Exception ex) {
            ex.printStackTrace();
            // Maneja cualquier excepción que pueda ocurrir al cargar la fuente
        }
    }

    //Bordes Del Pnael
    private void setRoundedShape() {
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
    }

    @Override
    public void paint(Graphics g) {
        ((Graphics2D) g).fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paint(g);
    }

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
            java.util.logging.Logger.getLogger(Star.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Star.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Star.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Star.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Star().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CerrarPanel;
    private javax.swing.JPanel Movilidad;
    public javax.swing.JPanel PanelCambio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private redondeado.RoundedPanel roundedPanel2;
    // End of variables declaration//GEN-END:variables

}