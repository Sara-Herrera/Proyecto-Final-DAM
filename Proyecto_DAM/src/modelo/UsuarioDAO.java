/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Usuario;

/**
 *
 * @author sara_
 */
public interface UsuarioDAO {
    
    boolean buscar(Usuario usuario);
    
    boolean insertar(Usuario usuario);
    
    boolean restaurarContrasena(Usuario usuario);
    
}
