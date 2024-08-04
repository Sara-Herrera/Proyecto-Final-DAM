
package vista;

public class PantallaResultados extends javax.swing.JFrame {

    public PantallaResultados() {
        initComponents();
        this.jButton_Modificar.setVisible(false);
        this.jButton_Eliminar.setVisible(false);
        this.jButton_logout.setVisible(false);
        
        this.jLabel_Nombre.setVisible(false);
        this.jLabel_Floracion.setVisible(false);
        this.jLabel_Forma.setVisible(false);
        this.jLabel_Color.setVisible(false);
        this.jTextField_Nombre.setVisible(false);
        this.jTextField_Floracion.setVisible(false);
        this.jLabel_zona.setVisible(false);
        this.jScrollPane2.setVisible(false);
        this.jList_zona_geografica.setVisible(false);
        this.jTextField_Color.setVisible(false);
        this.jTextField_Forma.setVisible(false);
        
        this.jComboBox_filtroColor.setVisible(false);
        this.jLabel_filtroColor.setVisible(false);
        this.jComboBox_filtroForma.setVisible(false);
        this.jLabel_filtroForma.setVisible(false);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jButton_Atras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_resultados = new javax.swing.JTable();
        jLabel_Nombre = new javax.swing.JLabel();
        jTextField_Nombre = new javax.swing.JTextField();
        jLabel_Floracion = new javax.swing.JLabel();
        jTextField_Floracion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_zona_geografica = new javax.swing.JList<>();
        jLabel_zona = new javax.swing.JLabel();
        jLabel_Forma = new javax.swing.JLabel();
        jLabel_Color = new javax.swing.JLabel();
        jButton_FiltrarResultados = new javax.swing.JButton();
        jButton_Modificar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jButton_logout = new javax.swing.JButton();
        jTextField_Forma = new javax.swing.JTextField();
        jTextField_Color = new javax.swing.JTextField();
        jComboBox_filtroColor = new javax.swing.JComboBox<>();
        jLabel_filtroForma = new javax.swing.JLabel();
        jLabel_filtroColor = new javax.swing.JLabel();
        jComboBox_filtroForma = new javax.swing.JComboBox<>();
        jLabel_filtroFloracion = new javax.swing.JLabel();
        jComboBox_filtroFloracion = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel_usuarioLogueado = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(730, 447));
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(730, 447));
        bg.setPreferredSize(new java.awt.Dimension(730, 447));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Atras.setBackground(new java.awt.Color(0, 51, 51));
        jButton_Atras.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_Atras.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Atras.setText("Atrás");
        jButton_Atras.setBorder(null);
        jButton_Atras.setBorderPainted(false);
        jButton_Atras.setPreferredSize(new java.awt.Dimension(110, 30));
        bg.add(jButton_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, -1, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Ficha varietal");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 51));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 480, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(220, 450));

        jTable_resultados.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTable_resultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Especie"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_resultados.setToolTipText("Selecciona para ver detalle");
        jTable_resultados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_resultados.setGridColor(new java.awt.Color(255, 255, 255));
        jTable_resultados.setSelectionBackground(new java.awt.Color(47, 95, 95));
        jTable_resultados.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable_resultados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 270, 450));

        jLabel_Nombre.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel_Nombre.setText("Nombre");
        bg.add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        jTextField_Nombre.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        bg.add(jTextField_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 240, -1));

        jLabel_Floracion.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel_Floracion.setText("Floración");
        bg.add(jLabel_Floracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jTextField_Floracion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        bg.add(jTextField_Floracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 240, -1));

        jList_zona_geografica.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jList_zona_geografica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jList_zona_geografica.setSelectionBackground(new java.awt.Color(47, 95, 95));
        jList_zona_geografica.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jList_zona_geografica);

        bg.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 240, 102));

        jLabel_zona.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel_zona.setText("Zona geográfica");
        bg.add(jLabel_zona, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));

        jLabel_Forma.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel_Forma.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_Forma.setText("Forma");
        bg.add(jLabel_Forma, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        jLabel_Color.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel_Color.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_Color.setText("Color");
        bg.add(jLabel_Color, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        jButton_FiltrarResultados.setBackground(new java.awt.Color(0, 51, 51));
        jButton_FiltrarResultados.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_FiltrarResultados.setForeground(new java.awt.Color(255, 255, 255));
        jButton_FiltrarResultados.setText("Filtrar");
        jButton_FiltrarResultados.setAlignmentY(0.0F);
        jButton_FiltrarResultados.setBorder(null);
        jButton_FiltrarResultados.setBorderPainted(false);
        jButton_FiltrarResultados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_FiltrarResultados.setMargin(new java.awt.Insets(2, 2, 2, 2));
        bg.add(jButton_FiltrarResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 90, 180, 36));

        jButton_Modificar.setBackground(new java.awt.Color(0, 51, 51));
        jButton_Modificar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_Modificar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Modificar.setText("Modificar");
        jButton_Modificar.setAlignmentY(0.0F);
        jButton_Modificar.setBorder(null);
        jButton_Modificar.setBorderPainted(false);
        jButton_Modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Modificar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        bg.add(jButton_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 180, 36));

        jButton_Eliminar.setBackground(new java.awt.Color(0, 51, 51));
        jButton_Eliminar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.setAlignmentY(0.0F);
        jButton_Eliminar.setBorder(null);
        jButton_Eliminar.setBorderPainted(false);
        jButton_Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Eliminar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        bg.add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 180, 36));

        jButton_logout.setBackground(new java.awt.Color(0, 51, 51));
        jButton_logout.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton_logout.setForeground(new java.awt.Color(255, 255, 255));
        jButton_logout.setText("Cerrar sesión");
        jButton_logout.setAlignmentY(0.0F);
        jButton_logout.setBorder(null);
        jButton_logout.setBorderPainted(false);
        jButton_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_logout.setMargin(new java.awt.Insets(2, 2, 2, 2));
        bg.add(jButton_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 180, 36));

        jTextField_Forma.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        bg.add(jTextField_Forma, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 240, -1));

        jTextField_Color.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        bg.add(jTextField_Color, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 240, -1));

        jComboBox_filtroColor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jComboBox_filtroColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bg.add(jComboBox_filtroColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 140, -1));

        jLabel_filtroForma.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel_filtroForma.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_filtroForma.setText("Forma");
        bg.add(jLabel_filtroForma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 60, -1));

        jLabel_filtroColor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel_filtroColor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_filtroColor.setText("Color");
        bg.add(jLabel_filtroColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 60, -1));

        jComboBox_filtroForma.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        bg.add(jComboBox_filtroForma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 140, -1));

        jLabel_filtroFloracion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel_filtroFloracion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_filtroFloracion.setText("Floración");
        bg.add(jLabel_filtroFloracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 61, -1));

        jComboBox_filtroFloracion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jComboBox_filtroFloracion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jComboBox_filtroFloracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bg.add(jComboBox_filtroFloracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, -1));

        jPanel8.setBackground(new java.awt.Color(0, 51, 51));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 450));

        jLabel_usuarioLogueado.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel_usuarioLogueado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addComponent(jLabel_usuarioLogueado)
                .addGap(21, 21, 21))
        );

        bg.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 450));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        bg.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 550, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    public javax.swing.JButton jButton_Atras;
    public javax.swing.JButton jButton_Eliminar;
    public javax.swing.JButton jButton_FiltrarResultados;
    public javax.swing.JButton jButton_Modificar;
    public javax.swing.JButton jButton_logout;
    public javax.swing.JComboBox<String> jComboBox_filtroColor;
    public javax.swing.JComboBox<String> jComboBox_filtroFloracion;
    public javax.swing.JComboBox<String> jComboBox_filtroForma;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel_Color;
    public javax.swing.JLabel jLabel_Floracion;
    public javax.swing.JLabel jLabel_Forma;
    public javax.swing.JLabel jLabel_Nombre;
    public javax.swing.JLabel jLabel_filtroColor;
    private javax.swing.JLabel jLabel_filtroFloracion;
    public javax.swing.JLabel jLabel_filtroForma;
    public javax.swing.JLabel jLabel_usuarioLogueado;
    public javax.swing.JLabel jLabel_zona;
    public javax.swing.JList<String> jList_zona_geografica;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable jTable_resultados;
    public javax.swing.JTextField jTextField_Color;
    public javax.swing.JTextField jTextField_Floracion;
    public javax.swing.JTextField jTextField_Forma;
    public javax.swing.JTextField jTextField_Nombre;
    // End of variables declaration//GEN-END:variables
}
