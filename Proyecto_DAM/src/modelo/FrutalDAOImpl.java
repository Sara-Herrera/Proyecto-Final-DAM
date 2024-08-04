/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import clases.Albaricoquero;
import clases.Almendro;
import conexion.Conexion;
import clases.Frutal;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sara_
 */
public class FrutalDAOImpl extends Conexion implements FrutalDAO {
    
    // Variables necesarias para hacer las consultas a la base de datos
    PreparedStatement ps; //Se importa
    ResultSet rs; //Se importa
    
    private Albaricoquero albaricoquero;
    private Almendro almendro;
    
    // Método INSERTAR
    public boolean insertar(Frutal frutal){
        Connection conexion = getConnection(); //Establece la conexion. Utilizo el método de la clase Connection
        try{     
            
           // Insertar en la tabla Frutal
            ps = conexion.prepareStatement("INSERT INTO Frutal (nombre, especie, floracion) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, frutal.getNombre());
            ps.setString(2, frutal.getEspecie());
            ps.setString(3, frutal.getFloracion());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                int frutalId = rs.getInt(1); // Obtener el ID generado
                if("Albaricoquero".equals(frutal.getEspecie())){
                    ps = conexion.prepareStatement("INSERT INTO Albaricoquero (id, nombre, Color) VALUES (?, ?, ?)");
                        ps.setInt(1, frutalId);
                        ps.setString(2, frutal.getNombre());
                        ps.setString(3,((Albaricoquero) frutal).getColor());
                    ps.executeUpdate();                
                }else if ("Almendro".equals(frutal.getEspecie())){
                    ps = conexion.prepareStatement("INSERT INTO Almendro (id, nombre, forma) VALUES (?, ?, ?)");
                        ps.setInt(1, frutalId);
                        ps.setString(2, frutal.getNombre());
                        ps.setString(3,((Almendro) frutal).getForma());
                    ps.executeUpdate();                
                }
                
                // Obtener las zonas geográficas del frutal
                List<String> zonasGeograficas = frutal.getZonasGeograficas();

                // Insertar en la tabla Frutal_Zona
                ps = conexion.prepareStatement("INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (?, ?)");
                for (String zona : zonasGeograficas) {
                    // Obtener el ID de la zona por su nombre
                    PreparedStatement psZona = conexion.prepareStatement("SELECT ID FROM ZonaGeografica WHERE Nombre = ?");
                    psZona.setString(1, zona);
                    ResultSet rsZona = psZona.executeQuery();
                    if (rsZona.next()) {
                        int zonaId = rsZona.getInt("ID");
                        ps.setInt(1, frutalId);
                        ps.setInt(2, zonaId);
                        ps.addBatch();
                    }
                }
                ps.executeBatch();
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex){
            System.err.println("El error es " + ex);
            return false;
        }finally{
            try{
                conexion.close();
            }catch (SQLException ex){
                System.err.println("El error es " + ex);
            }
        }
    }
           
    // Método MODIFICAR
    public boolean modificar(Frutal frutal){
        Connection conexion = getConnection(); //Establece la conexion
        try{              
            // Actualizar información general del frutal en la tabla Frutal
            ps = conexion.prepareStatement("UPDATE Frutal SET nombre = ?, especie = ?, floracion = ? WHERE nombre = ?");
            ps.setString(1, frutal.getNombre());
            ps.setString(2, frutal.getEspecie());
            ps.setString(3, frutal.getFloracion());
            ps.setString(4, frutal.getNombre());
            ps.execute();
            if("Albaricoquero".equals(frutal.getEspecie())){
                ps = conexion.prepareStatement("UPDATE Albaricoquero SET nombre = ?, Color = ? WHERE nombre = ?");
                ps.setString(1, frutal.getNombre());
                ps.setString(2,((Albaricoquero) frutal).getColor());
                ps.setString(3, frutal.getNombre());
            }else if ("Almendro".equals(frutal.getEspecie())){
                ps = conexion.prepareStatement("UPDATE Almendro SET nombre = ?, Forma = ? WHERE nombre = ?");
                ps.setString(1, frutal.getNombre());
                ps.setString(2,((Almendro) frutal).getForma());
                ps.setString(3, frutal.getNombre());
            }
            ps.execute(); 
            
            //Recoger el id del Frutal
            ps = conexion.prepareStatement("SELECT ID FROM Frutal WHERE nombre = ?");
            ps.setString(1, frutal.getNombre());
            rs = ps.executeQuery();

            int frutalId = -1;
            // Verificar si se encontró el frutal y obtener su ID
            if (rs.next()) {
                frutalId = rs.getInt("ID");
            }
            
            // Eliminar las asociaciones de zonas geográficas anteriores en la tabla Frutal_Zona
            ps = conexion.prepareStatement("DELETE FROM Frutal_Zona WHERE FrutalID = ?");
            ps.setInt(1, frutalId);
            ps.execute();

            // Obtener las nuevas zonas geográficas del frutal
            List<String> zonasGeograficas = frutal.getZonasGeograficas();

            // Insertar las nuevas asociaciones de zonas geográficas en la tabla Frutal_Zona
            ps = conexion.prepareStatement("INSERT INTO Frutal_Zona (FrutalID, ZonaID) VALUES (?, ?)");
            for (String zona : zonasGeograficas) {
                // Obtener el ID de la zona por su nombre
                PreparedStatement psZona = conexion.prepareStatement("SELECT ID FROM ZonaGeografica WHERE Nombre = ?");
                psZona.setString(1, zona);
                ResultSet rsZona = psZona.executeQuery();
                if (rsZona.next()) {
                    int zonaId = rsZona.getInt("ID");
                    ps.setInt(1, frutalId);
                    ps.setInt(2, zonaId);
                    ps.addBatch();
                }
            }
            ps.executeBatch();
            return true;
        }catch (Exception ex){
            System.err.println("El error es " + ex);
            return false;
        }finally{
            try{
                conexion.close();
            }catch (Exception ex){
                System.err.println("El error es " + ex);
            }
        }
    } 
    
    public boolean listar(DefaultTableModel modeloTabla){
            Connection conexion = null;
        
        try{
            conexion = getConnection(); //Establece la conexion
            ps = conexion.prepareStatement("SELECT f.nombre, f.especie FROM frutal f");
            rs = ps.executeQuery();
 
            if (rs.next()) {
                while(rs.next()){
                    Object fila[] = new Object [2];
                    for(int i=0;i<2;i++){
                        fila[i] = rs.getObject(i+1);
                    }
                    modeloTabla.addRow(fila);
                }
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrutalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                conexion.close();
            }catch (Exception ex){
                System.err.println("El error es " + ex);
            }
        }
        return false;
    }
    
    public boolean listar(DefaultTableModel modeloTabla, String especie_seleccionada){
        Connection conexion = null;
        
        try{
            conexion = getConnection(); //Establece la conexion
            ps = conexion.prepareStatement("SELECT f.nombre, f.especie FROM frutal f WHERE f.especie = ?");
            ps.setString(1,especie_seleccionada);
            rs = ps.executeQuery();
            
            if (rs.next()) { 
                while(rs.next()){
                    Object fila[] = new Object [2];
                    for(int i=0;i<2;i++){
                        fila[i] = rs.getObject(i+1);
                    }
                    modeloTabla.addRow(fila);
                }
                return true;
            }else{
                return false;
            }    
        } catch (SQLException ex) {
            Logger.getLogger(FrutalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                conexion.close();
            }catch (Exception ex){
                System.err.println("El error es " + ex);
            }
        }
        return false;
    }
    
    public boolean listar(DefaultTableModel modeloTabla, String especie_seleccionada, String nombre_introducido){
        Connection conexion = null;
        
        try{
            conexion = getConnection(); //Establece la conexion
            
            ps = conexion.prepareStatement("SELECT f.nombre, f.especie FROM frutal f WHERE f.especie = ? AND f.nombre = ?");
            ps.setString(1,especie_seleccionada);
            ps.setString(2, nombre_introducido);
            rs = ps.executeQuery();

            if (rs.next()) { 
                System.out.println("ha etrado");
                do {
                    Object fila[] = new Object[2];
                    fila[0] = rs.getObject("nombre");
                    fila[1] = rs.getObject("especie");
                    modeloTabla.addRow(fila);
                } while (rs.next());
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrutalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                conexion.close();
            }catch (Exception ex){
                System.err.println("El error es " + ex);
            }
        }
        return false;
    }
    
    public boolean filtrar(DefaultTableModel modeloTabla, String filtro_floracion){
        Connection conexion = null;
        
        try{
            conexion = getConnection(); //Establece la conexion
            ps = conexion.prepareStatement("SELECT f.nombre, f.especie FROM frutal f WHERE f.floracion = ?");
            ps.setString(1,filtro_floracion);
            rs = ps.executeQuery();
            
            if (rs.next()) {  
                do {
                    Object fila[] = new Object[2];
                    fila[0] = rs.getObject("nombre");
                    fila[1] = rs.getObject("especie");
                    modeloTabla.addRow(fila);
                } while (rs.next());
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrutalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                conexion.close();
            }catch (Exception ex){
                System.err.println("El error es " + ex);
            }
        }
        return false;
    }
    
    public boolean filtrarPorColor(DefaultTableModel modeloTabla, String filtro_floracion, String filtro_color){
        Connection conexion = null;
        
        try{
            conexion = getConnection(); //Establece la conexion
            
            String query = "SELECT f.nombre, f.especie FROM frutal f JOIN albaricoquero a ON (f.nombre = a.nombre) ";
            boolean floracionSeleccionada = !filtro_floracion.equals("Selecciona");
            boolean colorSeleccionado = !filtro_color.equals("Elige");

            if(floracionSeleccionada || colorSeleccionado){
                query += "WHERE ";
            }
            
            if(colorSeleccionado){
                query += " a.Color = ?";
            }
            
            if(floracionSeleccionada){
                if(colorSeleccionado){
                    query += " AND ";
                }
                query += " f.floracion = ?";
            }
            ps = conexion.prepareStatement(query);
            int parametroIndex = 1;
            if (colorSeleccionado) {
                ps.setString(parametroIndex++, filtro_color);
            }
            if (floracionSeleccionada) {
                ps.setString(parametroIndex++, filtro_floracion);
            }
            rs = ps.executeQuery();

            if (rs.next()) {  
                do {
                    Object fila[] = new Object[2];
                    fila[0] = rs.getObject("nombre");
                    fila[1] = rs.getObject("especie");
                    modeloTabla.addRow(fila);
                } while (rs.next());
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrutalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                conexion.close();
            }catch (Exception ex){
                System.err.println("El error es " + ex);
            }
        }
        return false;
    }


    public boolean filtrarPorForma(DefaultTableModel modeloTabla, String filtro_floracion, String filtro_forma){
        Connection conexion = null;
        
        try{
            conexion = getConnection(); //Establece la conexion
            
            String query = "SELECT f.nombre, f.especie FROM frutal f JOIN almendro al ON (f.nombre = al.nombre) ";
            boolean floracionSeleccionada = !filtro_floracion.equals("Selecciona");
            boolean colorSeleccionado = !filtro_forma.equals("Elige");
            
            if(floracionSeleccionada || colorSeleccionado){
                query += "WHERE ";
            }
            
            if(colorSeleccionado){
                query += " al.Forma = ?";
            }
            
            if(floracionSeleccionada){
                if(colorSeleccionado){
                    query += " AND ";
                }
                query += " f.floracion = ?";
            }
            

            ps = conexion.prepareStatement(query);
            int parametroIndex = 1;
            if (colorSeleccionado) {
                ps.setString(parametroIndex++, filtro_forma);
            }
            if (floracionSeleccionada) {
                ps.setString(parametroIndex++, filtro_floracion);
            }
            rs = ps.executeQuery();
 
            if (rs.next()) {
                do {
                    Object fila[] = new Object[2];
                    fila[0] = rs.getObject("nombre");
                    fila[1] = rs.getObject("especie");
                    modeloTabla.addRow(fila);
                } while (rs.next());
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrutalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                conexion.close();
            }catch (Exception ex){
                System.err.println("El error es " + ex);
            }
        }
        return false;
    }
    
    public void buscar(Frutal frutal){
        Connection conexion = getConnection(); //Establece la conexion
        
        try {
            if ("Albaricoquero".equals(frutal.getEspecie())) {
                ps = conexion.prepareStatement("SELECT a.ID, a.nombre, f.especie, f.floracion, a.color, z.nombre AS ZonaGeografica "
                                               + "FROM Albaricoquero a "
                                               + "JOIN Frutal f ON a.ID = f.ID "
                                               + "JOIN Frutal_Zona fz ON f.ID = fz.FrutalID "
                                               + "JOIN ZonaGeografica z ON fz.ZonaID = z.ID "
                                               + "WHERE a.Nombre = ?");
                ps.setString(1, ((Albaricoquero) frutal).getNombre());
            } else if ("Almendro".equals(frutal.getEspecie())) {
                ps = conexion.prepareStatement("SELECT a.ID, a.nombre, f.especie, f.floracion, a.forma, z.nombre AS ZonaGeografica "
                                               + "FROM Almendro a "
                                               + "JOIN Frutal f ON a.ID = f.ID "
                                               + "JOIN Frutal_Zona fz ON f.ID = fz.FrutalID "
                                               + "JOIN ZonaGeografica z ON fz.ZonaID = z.ID "
                                               + "WHERE a.Nombre = ?");
                ps.setString(1, ((Almendro) frutal).getNombre());
            }

            rs = ps.executeQuery();

            if (rs.next()) {
                frutal.setNombre(rs.getString("nombre"));
                frutal.setFloracion(rs.getString("floracion"));

                if ("Albaricoquero".equals(frutal.getEspecie())) {
                    ((Albaricoquero) frutal).setColor(rs.getString("color"));
                } else if ("Almendro".equals(frutal.getEspecie())) {
                    ((Almendro) frutal).setForma(rs.getString("forma"));
                }

                // Se añade la primera zona geográfica a la lista
                frutal.getZonasGeograficas().add(rs.getString("ZonaGeografica"));

                while (rs.next()) {
                    // Se añaden las demás zonas geográficas a la lista
                    frutal.getZonasGeograficas().add(rs.getString("ZonaGeografica"));
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe el registro indicado");
            }
        } catch (HeadlessException | SQLException ex) {
            System.err.println("El error es " + ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                System.err.println("El error es " + ex);
            }
        }
    }    
    
    public boolean eliminar(Frutal frutal){
        Connection conexion = getConnection(); //Establece la conexion
        
        try{    
            
            ps = conexion.prepareStatement("DELETE FROM Frutal_Zona WHERE FrutalID IN (SELECT ID FROM Frutal WHERE nombre = ?)");
            ps.setString(1, frutal.getNombre());
            ps.execute();
            
            if("Albaricoquero".equals(frutal.getEspecie())){
                ps = conexion.prepareStatement("DELETE FROM Albaricoquero WHERE nombre = ?");
                ps.setString(1, ((Albaricoquero) frutal).getNombre());
                ps.execute(); 
            }else if ("Almendro".equals(frutal.getEspecie())){
                ps = conexion.prepareStatement("DELETE FROM Almendro WHERE nombre = ?");
                ps.setString(1, ((Almendro) frutal).getNombre());
                ps.execute();         
            }  
            ps = conexion.prepareStatement("DELETE FROM Frutal WHERE nombre = ?");
            ps.setString(1, frutal.getNombre());
            ps.execute();

            return true;  
        }catch (SQLException ex){
            System.err.println("El error es " + ex);
            return false;
        }finally{
            try{
                conexion.close();
            }catch (SQLException ex){
                System.err.println("El error es " + ex);
            }
        }
    }     
    
    public ArrayList<String> obtenerZonasGeograficas() {
        ArrayList<String> zonas = new ArrayList<>();
        Connection conexion = getConnection(); //Establece la conexion
        try {
            ps = conexion.prepareStatement("SELECT Nombre FROM ZonaGeografica");
            rs = ps.executeQuery();
            while (rs.next()) {
                zonas.add(rs.getString("Nombre"));
            }

        } catch (SQLException ex){
            System.err.println("El error es " + ex);
        }
        return zonas;
    }
    
    public ArrayList<String> obtenerFloraciones() {
        ArrayList<String> listado = new ArrayList<>();
        Connection conexion = null; //Establece la conexion
        try {
            conexion = getConnection();
            ps = conexion.prepareStatement("SELECT DISTINCT Floracion FROM Frutal ORDER BY Floracion ASC");
            rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(rs.getString("Floracion"));
            }

        } catch (SQLException ex){
            System.err.println("El error es " + ex);
        }
        return listado;
    }
    
    public ArrayList<String> obtenerColores() {
        ArrayList<String> listado = new ArrayList<>();
        Connection conexion = null; //Establece la conexion
        try {
            conexion = getConnection();
            ps = conexion.prepareStatement("SELECT DISTINCT Color FROM Albaricoquero ORDER BY Color ASC");
            rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(rs.getString("Color"));
            }

        } catch (SQLException ex){
            System.err.println("El error es " + ex);
        }
        return listado;
    }
    
    public ArrayList<String> obtenerFormas() {
        ArrayList<String> listado = new ArrayList<>();
        Connection conexion = null; //Establece la conexion
        try {
            conexion = getConnection();
            ps = conexion.prepareStatement("SELECT DISTINCT Forma FROM Almendro ORDER BY Forma ASC");
            rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(rs.getString("Forma"));
            }

        } catch (SQLException ex){
            System.err.println("El error es " + ex);
        }
        return listado;
    }

}
