/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

/**
 *
 * @author Felix Coral
 */
public class RecoverPassword extends javax.swing.JPanel {

    /**
     * Creates new form RecuperarContraseña
     */
    public RecoverPassword() {
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

        VolverInicio = new redondeado.RoundedPanel();
        validarCredencial = new redondeado.RoundedPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        DNI = new texField.TextField();
        User = new texField.TextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(400, 430));
        setMinimumSize(new java.awt.Dimension(400, 430));
        setPreferredSize(new java.awt.Dimension(400, 430));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VolverInicio.setBackground(new java.awt.Color(30, 133, 139));
        VolverInicio.setForeground(new java.awt.Color(255, 255, 255));
        VolverInicio.setCornerRadius(17);
        VolverInicio.setFont(new java.awt.Font("Cambria", 3, 12)); // NOI18N
        VolverInicio.setHoverColor(new java.awt.Color(152, 199, 202));
        VolverInicio.setName(""); // NOI18N
        VolverInicio.setNormalColor(new java.awt.Color(30, 133, 139));
        VolverInicio.setText("Volver Al Incio");
        VolverInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(VolverInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 320, 40));

        validarCredencial.setBackground(new java.awt.Color(30, 133, 139));
        validarCredencial.setForeground(new java.awt.Color(255, 255, 255));
        validarCredencial.setCornerRadius(17);
        validarCredencial.setFont(new java.awt.Font("Cambria", 3, 12)); // NOI18N
        validarCredencial.setHoverColor(new java.awt.Color(152, 199, 202));
        validarCredencial.setName(""); // NOI18N
        validarCredencial.setNormalColor(new java.awt.Color(30, 133, 139));
        validarCredencial.setText("Verificar");
        validarCredencial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(validarCredencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 320, 40));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("haber Sido Registrada En Nuestra Base De Datos");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 64, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingresa Tu Usuario y DNI. Ten Presente que tu cuenta debe ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 44, -1, -1));

        jLabel1.setFont(new java.awt.Font("Cambria", 2, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Recuperar Contraseña");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        DNI.setBackground(new java.awt.Color(255, 255, 255));
        DNI.setLabelText("DNI");
        add(DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 320, -1));

        User.setBackground(new java.awt.Color(255, 255, 255));
        User.setLabelText("Usuario");
        add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 320, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public texField.TextField DNI;
    public texField.TextField User;
    public redondeado.RoundedPanel VolverInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public redondeado.RoundedPanel validarCredencial;
    // End of variables declaration//GEN-END:variables
}
