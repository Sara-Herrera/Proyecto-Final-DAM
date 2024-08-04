
package vista;

public class PantallaPrincipal extends javax.swing.JFrame {

    
    public PantallaPrincipal() {
        initComponents();
        jButton_FichaVarietal.setVisible(false);
        jButton_registro.setVisible(false);
        jButton_logout.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jButton_login = new javax.swing.JButton();
        jButton_registro = new javax.swing.JButton();
        jButton_logout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel_usuarioLogueado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton_FichaVarietal = new javax.swing.JButton();
        jComboBox_Especie = new javax.swing.JComboBox<>();
        jTextField_Buscador_principal = new javax.swing.JTextField();
        jButton_BuscarCv = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 204));
        setResizable(false);

        jPanel3.setPreferredSize(new java.awt.Dimension(730, 447));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscador de variedades");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, 40));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 480, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fotoFondo.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 550, 280));

        jButton_login.setBackground(new java.awt.Color(0, 51, 51));
        jButton_login.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_login.setForeground(new java.awt.Color(255, 255, 255));
        jButton_login.setText("Iniciar sesión");
        jButton_login.setAlignmentY(0.0F);
        jButton_login.setBorder(null);
        jButton_login.setBorderPainted(false);
        jButton_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_login.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jPanel3.add(jButton_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 90, 180, 36));

        jButton_registro.setBackground(new java.awt.Color(0, 51, 51));
        jButton_registro.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_registro.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registro.setText("Nuevo usuario");
        jButton_registro.setAlignmentY(0.0F);
        jButton_registro.setBorder(null);
        jButton_registro.setBorderPainted(false);
        jButton_registro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_registro.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jPanel3.add(jButton_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 180, 36));

        jButton_logout.setBackground(new java.awt.Color(0, 51, 51));
        jButton_logout.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_logout.setForeground(new java.awt.Color(255, 255, 255));
        jButton_logout.setText("Cerrar sesión");
        jButton_logout.setAlignmentY(0.0F);
        jButton_logout.setBorder(null);
        jButton_logout.setBorderPainted(false);
        jButton_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_logout.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jPanel3.add(jButton_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 180, 36));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 450));

        jLabel_usuarioLogueado.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel_usuarioLogueado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addComponent(jLabel_usuarioLogueado)
                .addGap(21, 21, 21))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 450));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton_FichaVarietal.setBackground(new java.awt.Color(47, 95, 95));
        jButton_FichaVarietal.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_FichaVarietal.setForeground(new java.awt.Color(255, 255, 255));
        jButton_FichaVarietal.setText("Nueva ficha varietal");
        jButton_FichaVarietal.setBorder(null);
        jButton_FichaVarietal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_FichaVarietal.setPreferredSize(new java.awt.Dimension(193, 30));

        jComboBox_Especie.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jComboBox_Especie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar especie", "Albaricoquero", "Almendro" }));
        jComboBox_Especie.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBox_Especie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTextField_Buscador_principal.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTextField_Buscador_principal.setToolTipText("Nombre");

        jButton_BuscarCv.setBackground(new java.awt.Color(47, 95, 95));
        jButton_BuscarCv.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_BuscarCv.setForeground(new java.awt.Color(255, 255, 255));
        jButton_BuscarCv.setText("Buscar");
        jButton_BuscarCv.setBorder(null);
        jButton_BuscarCv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_BuscarCv.setPreferredSize(new java.awt.Dimension(81, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox_Especie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_Buscador_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_BuscarCv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_FichaVarietal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox_Especie)
                    .addComponent(jTextField_Buscador_principal))
                .addGap(18, 18, 18)
                .addComponent(jButton_BuscarCv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jButton_FichaVarietal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 277, 550, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_BuscarCv;
    public javax.swing.JButton jButton_FichaVarietal;
    public javax.swing.JButton jButton_login;
    public javax.swing.JButton jButton_logout;
    public javax.swing.JButton jButton_registro;
    public javax.swing.JComboBox<String> jComboBox_Especie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel_usuarioLogueado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextField jTextField_Buscador_principal;
    // End of variables declaration//GEN-END:variables
}
