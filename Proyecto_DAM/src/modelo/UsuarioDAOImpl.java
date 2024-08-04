/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Usuario;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sara_
 */
public class UsuarioDAOImpl extends Conexion implements UsuarioDAO {

    // Variables necesarias para hacer las consultas a la base de datos
    PreparedStatement ps; //Se importa
    ResultSet rs; //Se importa

    //Metodo Buscar
    @Override
    public boolean buscar(Usuario usuario) {
        Connection conexion = getConnection();
        try {
            ps = conexion.prepareStatement("select * from usuario where email=?");
            ps.setString(1, usuario.getEmail());
            rs = ps.executeQuery();

            rs = ps.executeQuery(); //En la variable rs guarda los resultados devueltos de la BD
            
            if(rs.next()){ //Si lo devuelto es TRUE, es decir, ha devuelto información con la consulta 
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setDni(rs.getString("dni"));
                usuario.setRol(rs.getString("rol"));
                return true;
            }else{
                return false;
            } 

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error, " + ex);
            }
        }
    }

    // Método restaurar contraseña
    public boolean restaurarContrasena(Usuario usuario) {
        Connection conexion = getConnection();

        try {
            ps = conexion.prepareStatement("update usuario set contrasena=? where id_usuario=?");
            ps.setString(1, usuario.getContrasena());
            ps.setInt(2, usuario.getId_usuario());
            ps.executeUpdate();

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.err.println("Error, " + ex);
            return false;

        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error, " + ex);
            }
        }
    }

    public boolean insertar(Usuario usuario) {
        Connection conexion = getConnection();
        int res = 0;
        try {
            ps = conexion.prepareStatement("insert into usuario (dni, nombre, apellidos, departamento, puesto, email, contrasena, rol) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, usuario.getDni());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellidos());
            ps.setString(4, usuario.getDepartamento());
            ps.setString(5, usuario.getPuesto());
            ps.setString(6, usuario.getEmail());
            ps.setString(7, usuario.getContrasena());
            ps.setString(8, usuario.getRol());

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error, " + ex);
            return false;

        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.println("Error, " + ex);
            }
        }
    }

    


}
