
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.PantallaPrincipal;
import vista.PantallaSecundaria;
import vista.PantallaResultados;
import clases.Frutal;
import clases.Albaricoquero;
import clases.Almendro;
import modelo.FrutalDAO;
import clases.Validacion;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import vista.PantallaLogin;

public class ControladorFrutal implements ActionListener, ListSelectionListener {
    private PantallaPrincipal pantallaP;
    private PantallaSecundaria pantallaS;
    private PantallaResultados pantallaRes;
    private PantallaLogin pantallaL;
    private Frutal frutal;
    private Albaricoquero albaricoquero;
    private Almendro almendro;
    private FrutalDAO daoFrutal;

    
    private boolean jTableAlmendro = false;
    private boolean jTableAlbaricoquero = false;

    
    //Constructor
    public ControladorFrutal(PantallaPrincipal pantallaP,PantallaSecundaria pantallaS, PantallaResultados pantallaRes, PantallaLogin pantallaL, Frutal frutal, Albaricoquero albaricoquero, Almendro almendro, FrutalDAO daoFrutal) {
        this.pantallaP = pantallaP;
        this.pantallaS = pantallaS;
        this.pantallaRes = pantallaRes;
        this.pantallaL = pantallaL;
        
        this.frutal = frutal;
        this.albaricoquero = albaricoquero;
        this.almendro = almendro;
        this.daoFrutal = daoFrutal;

        pantallaP.jButton_FichaVarietal.addActionListener(this);
        pantallaP.jButton_BuscarCv.addActionListener(this);

        pantallaP.jButton_FichaVarietal.addActionListener(this);
        
        pantallaRes.jButton_FiltrarResultados.addActionListener(this);
        pantallaRes.jButton_Atras.addActionListener(this);
        pantallaRes.jButton_Modificar.addActionListener(this);
        pantallaRes.jButton_Eliminar.addActionListener(this);
        pantallaRes.jTable_resultados.getSelectionModel().addListSelectionListener(this); 
        pantallaRes.jComboBox_filtroFloracion.addActionListener(this); 
        pantallaRes.jComboBox_filtroColor.addActionListener(this); 
        pantallaRes.jComboBox_filtroForma.addActionListener(this); 
        
        pantallaS.jButton_Insertar.addActionListener(this);
        pantallaS.jButton_Atras.addActionListener(this);
        
      
    }
    
    public void iniciar(){
        pantallaP.setTitle("Pantalla Principal");
        pantallaP.setLocationRelativeTo(null); //Centra la ventana en la pantalla
        pantallaS.setTitle("Nueva ficha varietal");       
        pantallaS.setLocationRelativeTo(null);
        pantallaRes.setTitle("Resultados");
        pantallaRes.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        //FUNCIONALIDAD VISTAS

        //PANTALLA PRINCIPAL
        if(ae.getSource() == pantallaP.jButton_FichaVarietal){
            pantallaP.setVisible(false);
            pantallaS.setVisible(true); 
            listarZonasGeograficas();
        }
        
        if(ae.getSource() == pantallaP.jButton_BuscarCv){

            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Especie");
            pantallaRes.jTable_resultados.setModel(modeloTabla);
            pantallaRes.jTable_resultados.setRowSelectionAllowed(true);

            String especie_seleccionada = (String) pantallaP.jComboBox_Especie.getSelectedItem();
            String nombre_introducido = pantallaP.jTextField_Buscador_principal.getText();
            
            boolean cambiarDePantalla = false; 
            
            if(especie_seleccionada.equals("Seleccionar especie") && !nombre_introducido.equals("")){
                JOptionPane.showMessageDialog(null, "Es necesario seleccionar una especie para buscar por nombre. ");
            }else{
                if(especie_seleccionada.equals("Seleccionar especie") && nombre_introducido.equals("")){
                    cambiarDePantalla = daoFrutal.listar(modeloTabla);
                }else if(!especie_seleccionada.equals("Seleccionar especie") && nombre_introducido.equals("")){
                    cambiarDePantalla = daoFrutal.listar(modeloTabla, especie_seleccionada);
                }else{
                    if(Validacion.validarNombre(nombre_introducido)){
                        cambiarDePantalla = daoFrutal.listar(modeloTabla, especie_seleccionada, nombre_introducido);
                    }
                }

                if (cambiarDePantalla) {
                    pantallaP.setVisible(false);
                    pantallaRes.setVisible(true);

                    listarFloraciones();
                    listarFormas();
                    listarColores();            

                    // Aplicar condiciones según el valor de la columna "Especie"
                    recoger_especies_JTable(pantallaRes.jTable_resultados);
                    if (this.jTableAlmendro && !this.jTableAlbaricoquero) {
                        pantallaRes.jComboBox_filtroForma.setVisible(true);  
                        pantallaRes.jComboBox_filtroColor.setVisible(false);
                        pantallaRes.jLabel_filtroForma.setVisible(true);  
                        pantallaRes.jLabel_filtroColor.setVisible(false);
                    } if (this.jTableAlbaricoquero  && !this.jTableAlmendro) {
                        pantallaRes.jComboBox_filtroColor.setVisible(true);
                        pantallaRes.jComboBox_filtroForma.setVisible(false);
                        pantallaRes.jLabel_filtroColor.setVisible(true);
                        pantallaRes.jLabel_filtroForma.setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron resultados para los criterios de búsqueda proporcionados. ");
                }
            }
            limpiar_pantallaP();
        }
        
         if(ae.getSource() == pantallaP.jButton_logout){
            pantallaP.jButton_login.setText("Iniciar sesión");
            pantallaP.jButton_FichaVarietal.setVisible(false);
            pantallaRes.jButton_Modificar.setVisible(false);
            pantallaRes.jButton_Eliminar.setVisible(false);
        }
         

        //PANTALLA RESULTADOS
        if(ae.getSource() == pantallaRes.jButton_Atras){
            pantallaRes.setVisible(false);
            pantallaP.setVisible(true); 
            limpiar_pantallaRes();
            ocultar_ficha_varietal();
        }

        
        if(ae.getSource() == pantallaRes.jButton_FiltrarResultados){
            ocultar_ficha_varietal();
            String filtro_floracion = pantallaRes.jComboBox_filtroFloracion.getSelectedItem().toString();
            String filtro_color = pantallaRes.jComboBox_filtroColor.getSelectedItem().toString();
            String filtro_forma = pantallaRes.jComboBox_filtroForma.getSelectedItem().toString();
            
            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Especie");
//            pantallaRes.jTable_resultados.setModel(modeloTabla);
        
            boolean resultadosFiltrado = false; 
            
            // Seleccion de filtros
            boolean hayFiltroFloracion = !filtro_floracion.equals("Selecciona");
            boolean hayFiltroColor = !filtro_color.equals("Elige");
            boolean hayFiltroForma = !filtro_forma.equals("Elige");

                if(this.jTableAlbaricoquero && this.jTableAlmendro){ // && hayFiltroFloracion
                    if (hayFiltroFloracion) {
                        resultadosFiltrado = daoFrutal.filtrar(modeloTabla, filtro_floracion);
                    }else{
                        resultadosFiltrado = daoFrutal.listar(modeloTabla);
                    }
                } else if(this.jTableAlbaricoquero && !this.jTableAlmendro){
                    if (hayFiltroFloracion || hayFiltroColor) {
                        resultadosFiltrado = daoFrutal.filtrarPorColor(modeloTabla, filtro_floracion, filtro_color);
                    }else{
                        resultadosFiltrado = daoFrutal.listar(modeloTabla, "Albaricoquero");
                    }
                } else if(!this.jTableAlbaricoquero && this.jTableAlmendro){
                    if (hayFiltroFloracion || hayFiltroForma) {
                        resultadosFiltrado = daoFrutal.filtrarPorForma(modeloTabla, filtro_floracion, filtro_forma);
                    }else{
                        resultadosFiltrado = daoFrutal.listar(modeloTabla, "Almendro");
                    }
                }
                
                // Si hay resultados, actualizar la tabla con el modelo temporal
                if (resultadosFiltrado) {
                    pantallaRes.jTable_resultados.setModel(modeloTabla);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron resultados para los criterios de búsqueda proporcionados.");
                }
            
        }
        
       
        //PANTALLA SECUNDARIA
        if(ae.getSource() == pantallaS.jButton_Atras){
            pantallaS.setVisible(false);
            pantallaP.setVisible(true); 
            limpiar_pantallaSec();
        }
        
        // Botón INSERTAR
        if(ae.getSource()== pantallaS.jButton_Insertar){
            switch (pantallaS.jComboBox_Especie.getSelectedIndex()) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Tienes que seleccionar una especie"); // Finalmente no utilizo el método de validación ya que con el switch se obliga a que haya que seleccionar una especie
                    break;
                case 1:
                    if(Validacion.validarNombre(pantallaS.jTextField_Nombre.getText())){ // Validación del campo 'Nombre' introducido
                        albaricoquero.setEspecie(pantallaS.jComboBox_Especie.getSelectedItem().toString());
                        albaricoquero.setNombre(pantallaS.jTextField_Nombre.getText());
                        albaricoquero.setFloracion(pantallaS.jTextField_Floracion.getText());
                        albaricoquero.setColor(pantallaS.jTextField_Color.getText());
                        albaricoquero.setZonasGeograficas(pantallaS.jList_zona_geografica.getSelectedValuesList());
                        
                        if(daoFrutal.insertar(albaricoquero)){
                            JOptionPane.showMessageDialog(null, "Inserción correcta");
                            limpiar_pantallaSec();
                        }else{
                            JOptionPane.showMessageDialog(null, "Inserción incorrecta");
                            //limpiar();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "El nombre introducido es incorrecto");
                    }
                    break;
                case 2:
                    if(Validacion.validarNombre(pantallaS.jTextField_Nombre.getText())){ // Validación del campo 'Nombre' introducido
                        almendro.setEspecie(pantallaS.jComboBox_Especie.getSelectedItem().toString());
                        almendro.setNombre(pantallaS.jTextField_Nombre.getText());
                        almendro.setFloracion(pantallaS.jTextField_Floracion.getText());
                        almendro.setForma(pantallaS.jTextField_Forma.getText());
                        almendro.setZonasGeograficas(pantallaS.jList_zona_geografica.getSelectedValuesList());

                        if(daoFrutal.insertar(almendro)){
                            JOptionPane.showMessageDialog(null, "Inserción correcta");
                            limpiar_pantallaSec();
                        }else{
                            JOptionPane.showMessageDialog(null, "Inserción incorrecta");
                            //limpiar();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "El nombre introducido es incorrecto");
                    }
                    break;
            }
        } // Cierre if-insertar

        
        // Botón ELIMINAR
        if(ae.getSource() == pantallaRes.jButton_Eliminar){ //Si se selecciona el botón eliminar..
            int numFila = pantallaRes.jTable_resultados.getSelectedRow();
            
            if (numFila == -1) {
                JOptionPane.showMessageDialog(null, "Es necesario seleccionar una variedad para eliminar. ");
                return;
            }
            
            String nombre = (String) pantallaRes.jTable_resultados.getValueAt(numFila, 0);  
            String especie = (String) pantallaRes.jTable_resultados.getValueAt(numFila, 1);            
            
            boolean esEliminado = false;
            
            if (especie.equals("Albaricoquero")){ 
                albaricoquero.setNombre(nombre);
                albaricoquero.setEspecie(especie);
                esEliminado = daoFrutal.eliminar(albaricoquero);
            } else if(especie.equals("Almendro")) {
                almendro.setNombre(nombre);
                almendro.setEspecie(especie);
                esEliminado = daoFrutal.eliminar(almendro);
            }
            
            if(esEliminado){
                try {
                    DefaultTableModel model = (DefaultTableModel) pantallaRes.jTable_resultados.getModel(); 
                    model.removeRow(numFila);
                    ocultar_ficha_varietal();
                    JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
                } catch (Exception ex) {
                    System.err.println("Error actualizando la tabla: " + ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se puede eliminar el registro. ");
            }        
        }        
        

        // Botón MODIFICAR
        if(ae.getSource()== pantallaRes.jButton_Modificar){ //Si se selecciona el botón modificar..
            int numFila = pantallaRes.jTable_resultados.getSelectedRow();
            
            if (numFila == -1) {
                JOptionPane.showMessageDialog(null, "Es necesario seleccionar una variedad para modificar. ");
                return;
            }
            
            String especie = (String) pantallaRes.jTable_resultados.getValueAt(numFila, 1);
            
            if (especie.equals("Albaricoquero")){ 
                albaricoquero.setEspecie(especie);
                albaricoquero.setNombre(pantallaRes.jTextField_Nombre.getText());
                albaricoquero.setFloracion(pantallaRes.jTextField_Floracion.getText());
                albaricoquero.setColor(pantallaRes.jTextField_Color.getText());
                albaricoquero.setZonasGeograficas(pantallaRes.jList_zona_geografica.getSelectedValuesList());

                if(daoFrutal.modificar(albaricoquero)){
                    JOptionPane.showMessageDialog(null, "Modificación correcta"); //En el caso de que devuelva true
                }else{
                    JOptionPane.showMessageDialog(null, "Modificación incorrecta");
                }
            } else if(especie.equals("Almendro")) {
                almendro.setEspecie(especie);
                almendro.setNombre(pantallaRes.jTextField_Nombre.getText());
                almendro.setFloracion(pantallaRes.jTextField_Floracion.getText());
                almendro.setForma(pantallaRes.jTextField_Forma.getText());
                almendro.setZonasGeograficas(pantallaRes.jList_zona_geografica.getSelectedValuesList());

                if(daoFrutal.modificar(almendro)){
                    JOptionPane.showMessageDialog(null, "Modificación correcta"); //En el caso de que devuelva true
                }else{
                    JOptionPane.showMessageDialog(null, "Modificación incorrecta");
                }
            }
        }
    }
    
    // Método LIMPIAR para pantalla principal
    public void limpiar_pantallaP(){
        pantallaP.jComboBox_Especie.setSelectedIndex(0);
        pantallaP.jTextField_Buscador_principal.setText("");
    }
    
    public void ocultar_ficha_varietal(){
        pantallaRes.jLabel_Nombre.setVisible(false);
        pantallaRes.jLabel_Floracion.setVisible(false);
        pantallaRes.jLabel_Forma.setVisible(false);
        pantallaRes.jLabel_Color.setVisible(false);
        pantallaRes.jTextField_Nombre.setVisible(false);
        pantallaRes.jTextField_Floracion.setVisible(false);
        pantallaRes.jLabel_zona.setVisible(false);
        pantallaRes.jScrollPane2.setVisible(false);
        pantallaRes.jList_zona_geografica.setVisible(false);
        pantallaRes.jTextField_Color.setVisible(false);
        pantallaRes.jTextField_Forma.setVisible(false);
    }
    
    // Método LIMPIAR
    public void limpiar_pantallaRes(){
        jTableAlmendro = false;
        jTableAlbaricoquero = false;
        
        pantallaRes.jTextField_Nombre.setText(null);
        pantallaRes.jTextField_Floracion.setText(null);
        pantallaRes.jTextField_Color.setText(null);
        pantallaRes.jTextField_Forma.setText(null);
        pantallaRes.jComboBox_filtroFloracion.setSelectedIndex(-1);
        pantallaRes.jComboBox_filtroColor.setSelectedIndex(-1);
        pantallaRes.jComboBox_filtroForma.setSelectedIndex(-1);
        
        pantallaRes.jLabel_filtroColor.setVisible(false);
        pantallaRes.jLabel_filtroForma.setVisible(false);
        pantallaRes.jComboBox_filtroColor.setVisible(false);
        pantallaRes.jComboBox_filtroForma.setVisible(false);
        
        DefaultTableModel modeloTabla = (DefaultTableModel) pantallaRes.jTable_resultados.getModel();
        modeloTabla.setRowCount(0);
   
    }

    //Método limpiar para pantalla de insertar ficha varietal
    public void limpiar_pantallaSec(){
        pantallaS.jComboBox_Especie.setSelectedIndex(-1);
        pantallaS.jTextField_Nombre.setText(null);
        pantallaS.jTextField_Floracion.setText(null);
        pantallaS.jTextField_Forma.setText(null);
        pantallaS.jTextField_Color.setText(null);
        pantallaS.jList_zona_geografica.clearSelection();
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            return;
        }
        if (e.getSource() == pantallaRes.jTable_resultados.getSelectionModel()) {
            if (pantallaRes.jTable_resultados.getSelectedRow() != -1) {
                pantallaRes.jLabel_Nombre.setVisible(true);
                pantallaRes.jLabel_Floracion.setVisible(true);
                pantallaRes.jTextField_Nombre.setVisible(true);
                pantallaRes.jTextField_Floracion.setVisible(true);
                pantallaRes.jLabel_zona.setVisible(true);
                pantallaRes.jScrollPane2.setVisible(true);        
                pantallaRes.jList_zona_geografica.setVisible(true);

                pantallaRes.jLabel_Color.setVisible(false);
                pantallaRes.jTextField_Color.setVisible(false);
                pantallaRes.jLabel_Forma.setVisible(false);
                pantallaRes.jTextField_Forma.setVisible(false);

                DefaultListModel<String> listModel = new DefaultListModel<>();
                pantallaRes.jList_zona_geografica.setModel(listModel);

                int numFila = pantallaRes.jTable_resultados.getSelectedRow();
                if (numFila != -1) {
                    String nombre = (String) pantallaRes.jTable_resultados.getValueAt(numFila, 0);  
                    String especie = (String) pantallaRes.jTable_resultados.getValueAt(numFila, 1);

                    if (especie.equals("Albaricoquero")){ 
                        pantallaRes.jLabel_Color.setVisible(true);
                        pantallaRes.jTextField_Color.setVisible(true);

                        Albaricoquero alb = new Albaricoquero();
                        alb.setNombre(nombre);
                        alb.setEspecie(especie);
                        daoFrutal.buscar(alb);
                        pantallaRes.jTextField_Nombre.setText(alb.getNombre());
                        pantallaRes.jTextField_Floracion.setText(alb.getFloracion());
                        pantallaRes.jTextField_Color.setText(alb.getColor());
                        pantallaRes.jList_zona_geografica.setModel(listModel);
                        listarZonasGeograficasEspecificas(alb);

                    }else{
                        pantallaRes.jLabel_Forma.setVisible(true);
                        pantallaRes.jTextField_Forma.setVisible(true);

                        Almendro alm = new Almendro();
                        alm.setNombre(nombre);
                        alm.setEspecie(especie);
                        daoFrutal.buscar(alm);
                        pantallaRes.jTextField_Nombre.setText(alm.getNombre());
                        pantallaRes.jTextField_Floracion.setText(alm.getFloracion());
                        pantallaRes.jTextField_Forma.setText(alm.getForma());
                        pantallaRes.jList_zona_geografica.setModel(listModel);
                        listarZonasGeograficasEspecificas(alm);
                    }
                }
            }
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
        
   
    public void recoger_especies_JTable(JTable modeloTabla){
            // Obtener el número de filas en la tabla
        int rowCount = modeloTabla.getRowCount();

        // Iterar a través de las filas de la tabla
        for (int i = 0; i < rowCount; i++) {
            // Obtener el valor de la columna "Especie" (col. 1) en la fila actual
            String especie = (String) modeloTabla.getValueAt(i, 1);

            // Verificar si la especie es "Almendro" o "Albaricoquero"
            if (especie.equals("Almendro")) {
                this.jTableAlmendro = true;
            } 
            if (especie.equals("Albaricoquero")) {
                this.jTableAlbaricoquero = true;
            }
        }
    
    }
    
    //Para la pantalla de nueva ficha varietal (opción insertar)
    public void listarZonasGeograficas() {
        DefaultListModel<String> listadoModelo = new DefaultListModel<>();
        ArrayList<String> listado = daoFrutal.obtenerZonasGeograficas();

        for (String elemento : listado) {
            listadoModelo.addElement(elemento);
        }
        pantallaS.jList_zona_geografica.setModel(listadoModelo);
    }
    
    //Para la pantalla de fichas varietales (visualizar)
    public void listarZonasGeograficasEspecificas(Frutal frutal){
        DefaultListModel<String> listModel = new DefaultListModel<>();                
        ArrayList<String> zonas = daoFrutal.obtenerZonasGeograficas();

        for (String zona : zonas) {
            listModel.addElement(zona);
        }
        pantallaRes.jList_zona_geografica.setModel(listModel);
        // Seleccionar las zonas encontradas por el método buscar
        int[] indices = new int[frutal.getZonasGeograficas().size()];
        int i = 0;
        for (String zona : frutal.getZonasGeograficas()) {
            int index = listModel.indexOf(zona);
            if (index != -1) { // Si la zona está en la lista
                indices[i++] = index;
            }
        }
        pantallaRes.jList_zona_geografica.setSelectedIndices(indices);       
    }
    
    //Filtro - combobox floraciones disponibles
    public void listarFloraciones() {
        DefaultComboBoxModel comboboxModelo = new DefaultComboBoxModel();
        ArrayList<String> listado = daoFrutal.obtenerFloraciones();
        
        comboboxModelo.addElement("Selecciona");
        for (String elemento : listado) {
            comboboxModelo.addElement(elemento);
        }
        pantallaRes.jComboBox_filtroFloracion.setModel(comboboxModelo);
    }

    //Filtro - combobox colores disponibles
    public void listarColores() {
        DefaultComboBoxModel comboboxModelo = new DefaultComboBoxModel();
        ArrayList<String> listado = daoFrutal.obtenerColores();
        
        comboboxModelo.addElement("Elige");
        for (String elemento : listado) {
            comboboxModelo.addElement(elemento);
        }
        pantallaRes.jComboBox_filtroColor.setModel(comboboxModelo);
    }    
    
    //Filtro - combobox formas disponibles
    public void listarFormas() {
        DefaultComboBoxModel comboboxModelo = new DefaultComboBoxModel();
        ArrayList<String> listado = daoFrutal.obtenerFormas();
        
        comboboxModelo.addElement("Elige");
        for (String elemento : listado) {
            comboboxModelo.addElement(elemento);
        }
        pantallaRes.jComboBox_filtroForma.setModel(comboboxModelo);
    } 
    
} //Fin clase
