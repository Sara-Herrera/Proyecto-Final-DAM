
package modelo;

import javax.swing.table.DefaultTableModel;
import clases.Frutal;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;


public interface FrutalDAO {
    
    boolean insertar(Frutal frutal);
        
    boolean modificar(Frutal frutal);
    
    boolean listar(DefaultTableModel modeloTabla);
    
    boolean listar(DefaultTableModel modeloTabla, String especie_seleccionada);
    
    boolean listar(DefaultTableModel modeloTabla, String especie_seleccionada, String nombre_introducido);
    
    boolean filtrar(DefaultTableModel modeloTabla, String filtro_floracion);
    
    boolean filtrarPorColor(DefaultTableModel modeloTabla, String filtro_floracion, String filtro_color);
    
    boolean filtrarPorForma(DefaultTableModel modeloTabla, String filtro_floracion, String filtro_forma);
    
    void buscar(Frutal frutal);
    
    boolean eliminar(Frutal frutal);
    
    ArrayList<String> obtenerZonasGeograficas();
    
    ArrayList<String> obtenerFloraciones();
    
    ArrayList<String> obtenerColores();
    
    ArrayList<String> obtenerFormas();
}
