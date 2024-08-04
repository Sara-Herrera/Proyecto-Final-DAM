
package vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PantallaSecundaria extends JFrame {

    public PantallaSecundaria() {
        initComponents();
        jTextField_Forma.setVisible(false);
        jLabel_Forma.setVisible(false);
        jTextField_Color.setVisible(false);
        jLabel_Color.setVisible(false);
        jButton_logout.setVisible(false);
    }
    //Código creado automáticamente por cada uno de los botones de la interfaz
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jButton_Atras = new javax.swing.JButton();
        jComboBox_Especie = new javax.swing.JComboBox<>();
        jLabel_Especie = new javax.swing.JLabel();
        jTextField_Nombre = new javax.swing.JTextField();
        jLabel_Floracion = new javax.swing.JLabel();
        jTextField_Floracion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_zona_geografica = new javax.swing.JList<>();
        jLabel_zona = new javax.swing.JLabel();
        jLabel_Forma = new javax.swing.JLabel();
        jTextField_Forma = new javax.swing.JTextField();
        jLabel_Color = new javax.swing.JLabel();
        jTextField_Color = new javax.swing.JTextField();
        jLabel_Nombre1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jButton_Insertar = new javax.swing.JButton();
        jButton_logout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel_usuarioLogueado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bg.setPreferredSize(new java.awt.Dimension(730, 450));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Atras.setBackground(new java.awt.Color(0, 51, 51));
        jButton_Atras.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_Atras.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Atras.setText("Atrás");
        jButton_Atras.setBorder(null);
        jButton_Atras.setBorderPainted(false);
        jButton_Atras.setPreferredSize(new java.awt.Dimension(110, 30));
        bg.add(jButton_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, -1, -1));

        jComboBox_Especie.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jComboBox_Especie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar especie", "Albaricoquero", "Almendro" }));
        jComboBox_Especie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox_Especie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_EspecieActionPerformed(evt);
            }
        });
        bg.add(jComboBox_Especie, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 243, -1));

        jLabel_Especie.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel_Especie.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_Especie.setText("Especie");
        jLabel_Especie.setPreferredSize(new java.awt.Dimension(97, 18));
        bg.add(jLabel_Especie, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        jTextField_Nombre.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        bg.add(jTextField_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 243, -1));

        jLabel_Floracion.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel_Floracion.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_Floracion.setText("Floración");
        jLabel_Floracion.setPreferredSize(new java.awt.Dimension(97, 18));
        bg.add(jLabel_Floracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 100, -1));

        jTextField_Floracion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        bg.add(jTextField_Floracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 243, -1));

        jList_zona_geografica.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jList_zona_geografica.setSelectionBackground(new java.awt.Color(47, 95, 95));
        jList_zona_geografica.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jList_zona_geografica);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 243, 88));

        jLabel_zona.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel_zona.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_zona.setText("Zona geográfica");
        bg.add(jLabel_zona, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, 21));

        jLabel_Forma.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel_Forma.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_Forma.setText("Forma");
        jLabel_Forma.setPreferredSize(new java.awt.Dimension(97, 18));
        bg.add(jLabel_Forma, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));
        bg.add(jTextField_Forma, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 240, -1));

        jLabel_Color.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel_Color.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_Color.setText("Color");
        jLabel_Color.setPreferredSize(new java.awt.Dimension(97, 18));
        bg.add(jLabel_Color, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));
        bg.add(jTextField_Color, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 240, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_Nombre1.setText("Nombre");
        jLabel_Nombre1.setPreferredSize(new java.awt.Dimension(97, 18));
        bg.add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 51));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 480, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Nueva ficha varietal");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, 40));

        jButton_Insertar.setBackground(new java.awt.Color(0, 51, 51));
        jButton_Insertar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_Insertar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Insertar.setText("Insertar");
        jButton_Insertar.setAlignmentY(0.0F);
        jButton_Insertar.setBorder(null);
        jButton_Insertar.setBorderPainted(false);
        jButton_Insertar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Insertar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        bg.add(jButton_Insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 180, 36));

        jButton_logout.setBackground(new java.awt.Color(0, 51, 51));
        jButton_logout.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_logout.setForeground(new java.awt.Color(255, 255, 255));
        jButton_logout.setText("Cerrar sesión");
        jButton_logout.setAlignmentY(0.0F);
        jButton_logout.setBorder(null);
        jButton_logout.setBorderPainted(false);
        jButton_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_logout.setMargin(new java.awt.Insets(2, 2, 2, 2));
        bg.add(jButton_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 180, 36));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 450));

        jLabel_usuarioLogueado.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel_usuarioLogueado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addComponent(jLabel_usuarioLogueado)
                .addGap(21, 21, 21))
        );

        bg.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 450));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 550, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_EspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_EspecieActionPerformed
        switch (jComboBox_Especie.getSelectedIndex()) {
            case 0:
            jTextField_Color.setVisible(false);
            jLabel_Color.setVisible(false);
            jTextField_Forma.setVisible(false);
            jLabel_Forma.setVisible(false);
            break;
            case 1:
            jTextField_Color.setVisible(true);
            jLabel_Color.setVisible(true);
            jTextField_Forma.setVisible(false);
            jLabel_Forma.setVisible(false);
            break;
            case 2:
            jTextField_Forma.setVisible(true);
            jLabel_Forma.setVisible(true);
            jTextField_Color.setVisible(false);
            jLabel_Color.setVisible(false);
            break;
        }
    }//GEN-LAST:event_jComboBox_EspecieActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    public javax.swing.JButton jButton_Atras;
    public javax.swing.JButton jButton_Insertar;
    public javax.swing.JButton jButton_logout;
    public javax.swing.JComboBox<String> jComboBox_Especie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Color;
    private javax.swing.JLabel jLabel_Especie;
    private javax.swing.JLabel jLabel_Floracion;
    private javax.swing.JLabel jLabel_Forma;
    private javax.swing.JLabel jLabel_Nombre1;
    public javax.swing.JLabel jLabel_usuarioLogueado;
    private javax.swing.JLabel jLabel_zona;
    public javax.swing.JList<String> jList_zona_geografica;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextField jTextField_Color;
    public javax.swing.JTextField jTextField_Floracion;
    public javax.swing.JTextField jTextField_Forma;
    public javax.swing.JTextField jTextField_Nombre;
    // End of variables declaration//GEN-END:variables
}
