/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Usuario;
import java.awt.event.ActionListener;
import modelo.UsuarioDAO;
import vista.PantallaLogin;
import vista.PantallaPrincipal;
import vista.PantallaResultados;
import vista.PantallaRestaurarContrasena;
import vista.PantallaUsuario;
import clases.Validacion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import vista.PantallaSecundaria;

/**
 *
 * @author sara_
 */
public class ControladorUsuario implements ActionListener {
    
    private PantallaPrincipal pantallaP;
    private PantallaResultados pantallaRes;
    private PantallaSecundaria pantallaS;
    private PantallaLogin pantallaL;
    private PantallaUsuario pantallaR;
    private PantallaRestaurarContrasena pantallaC;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    
    public ControladorUsuario(PantallaPrincipal pantallaP, PantallaSecundaria pantallaS, PantallaResultados pantallaRes, PantallaLogin pantallaL, PantallaUsuario pantallaR, PantallaRestaurarContrasena pantallaC, UsuarioDAO usuarioDAO, Usuario usuario){
        this.pantallaP = pantallaP;
        this.pantallaS = pantallaS;
        this.pantallaRes = pantallaRes;
        this.pantallaL = pantallaL;
        this.pantallaR = pantallaR;
        this.pantallaC = pantallaC;
        this.usuarioDAO = usuarioDAO;
        this.usuario = usuario;
        
        pantallaP.jButton_logout.addActionListener(this);
        pantallaP.jButton_login.addActionListener(this);
        pantallaP.jButton_registro.addActionListener(this);
        
        pantallaL.jButton_iniciar.addActionListener(this);
        pantallaL.jButton_cambiarContrasena.addActionListener(this);
        pantallaL.jButton_Atras.addActionListener(this);

        
        pantallaC.jButton_restaurar.addActionListener(this);
        pantallaC.jButton_Atras.addActionListener(this);
        
        pantallaR.jButton_registrarse.addActionListener(this);
        pantallaR.jButton_Atras.addActionListener(this);
        pantallaR.jButton_logout.addActionListener(this);
        //pantallaR.jButton_logout.addActionListener(this);
        
        pantallaS.jButton_logout.addActionListener(this);
        
        pantallaRes.jButton_logout.addActionListener(this);
    }
    
    public void iniciar(){
        pantallaP.setTitle("Pantalla Principal");
        pantallaP.setLocationRelativeTo(null);
        pantallaL.setTitle("Login");
        pantallaL.setLocationRelativeTo(null);
        pantallaR.setTitle("Crear usuario");
        pantallaR.setLocationRelativeTo(null);
        pantallaC.setTitle("Restaurar contraseña");
        pantallaC.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae) {

        //Acceso a pantalla Login
        if(ae.getSource() == pantallaP.jButton_login){
            pantallaP.setVisible(false);
            pantallaR.setVisible(false);
            pantallaL.setVisible(true);
        }

        if(ae.getSource() == pantallaP.jButton_logout || ae.getSource() == pantallaRes.jButton_logout || ae.getSource() == pantallaS.jButton_logout  || ae.getSource() == pantallaR.jButton_logout){
            pantallaP.setVisible(true);
            pantallaRes.setVisible(false);
            pantallaS.setVisible(false);
            pantallaR.setVisible(false);
            
            pantallaP.jButton_registro.setVisible(false);
            pantallaP.jButton_FichaVarietal.setVisible(false);
            pantallaP.jButton_logout.setVisible(false);
            pantallaRes.jButton_Modificar.setVisible(false);
            pantallaRes.jButton_Eliminar.setVisible(false);
            pantallaRes.jButton_logout.setVisible(false);
            pantallaP.jLabel_usuarioLogueado.setText("");
            pantallaRes.jLabel_usuarioLogueado.setText("");
            pantallaS.jLabel_usuarioLogueado.setText("");
            pantallaR.jLabel_usuarioLogueado.setText("");
            pantallaS.jButton_logout.setVisible(false);
            pantallaP.jButton_login.setVisible(true);
            JOptionPane.showMessageDialog(null, "Sesión cerrada correctamente. ");
        }
        // ######### LOGUEARSE #########        
        
        //Ir a pantalla Login
        if (ae.getSource() == pantallaL.jButton_iniciar) {
            if(Validacion.validarEmail(pantallaL.jTextField_email.getText())){
                usuario.setEmail(pantallaL.jTextField_email.getText());
                if (usuarioDAO.buscar(usuario)) {
                    String contrasena_introducida = pantallaL.jTextField_contrasena.getText();
                    if (contrasena_introducida.equals(usuario.getContrasena())) {
                        pantallaP.setVisible(true);
                        pantallaL.setVisible(false);
                        pantallaP.jLabel_usuarioLogueado.setText(usuario.getNombre());
                        pantallaRes.jLabel_usuarioLogueado.setText(usuario.getNombre());
                        pantallaS.jLabel_usuarioLogueado.setText(usuario.getNombre());
                        pantallaR.jLabel_usuarioLogueado.setText(usuario.getNombre());
                        
                        pantallaP.jButton_login.setVisible(false);

                        if(usuario.getRol().equals("admin")){
                            pantallaP.jButton_registro.setVisible(true);
                            pantallaP.jButton_FichaVarietal.setVisible(true);
                            pantallaP.jButton_logout.setVisible(true);
                            pantallaP.jButton_login.setVisible(false);
                            pantallaRes.jButton_Modificar.setVisible(true);
                            pantallaRes.jButton_Eliminar.setVisible(true);
                            pantallaRes.jButton_logout.setVisible(true);
                            pantallaS.jButton_logout.setVisible(true);
                            
                        }
                        JOptionPane.showMessageDialog(null, "Sesión iniciada correctamente.");
                        limpiar_pantalla_login();
                    } else {
                        JOptionPane.showMessageDialog(null, "La contraseña introducida no es correcta.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario introducido no existe.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El formato de email introducido es incorrecto.");
            }
        }
        
        if(ae.getSource() == pantallaL.jButton_Atras){
            pantallaL.setVisible(false);
            pantallaP.setVisible(true); 
            limpiar_pantalla_login();
        }

        
        // ######### CAMBIAR CONTRASEÑA #########

        //Ir a pantalla Restaurar Contraseña
        if (ae.getSource() == pantallaL.jButton_cambiarContrasena) {
            pantallaL.setVisible(false);
            pantallaC.setVisible(true);
            limpiar_pantalla_login();
        }
        
        //Cambiar Contraseña
        if (ae.getSource() == pantallaC.jButton_restaurar) {
            String email = pantallaC.jTextField_usuario.getText();
            String dni_introducido = pantallaC.jTextField_dni.getText();
            String dni_basedatos = "";
            String contrasena_nueva = pantallaC.jTextField_contrasena_nueva.getText();
            
            if(Validacion.validarEmail(email)){
                usuario.setEmail(email);
                if (usuarioDAO.buscar(usuario)) {
                    dni_basedatos = usuario.getDni();
                    if (dni_introducido.equals(dni_basedatos)) {
                        if (Validacion.validarContrasena(contrasena_nueva)) {
                            usuario.setContrasena(contrasena_nueva);
                            if (usuarioDAO.restaurarContrasena(usuario)) {
                                JOptionPane.showMessageDialog(null, "Contraseña actualizada. ");
                                limpiar_pantalla_resturarContrasena();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al actualizar contraseña. ");
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "La contraseña introducida no es válida. ");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El DNI introducido no es correcto. ");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario introducido no existe.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El formato de email introducido es incorrecto.");
            }            
        }
        
        if(ae.getSource() == pantallaC.jButton_Atras){
            pantallaL.setVisible(true);
            pantallaC.setVisible(false); 
            limpiar_pantalla_resturarContrasena();
        }  
        
        
        // ######### CREAR USUARIO #########
        
        //Ir a pantalla Crear un usuario
        if (ae.getSource() == pantallaP.jButton_registro) {
            pantallaP.setVisible(false);
            pantallaL.setVisible(false);
            pantallaR.setVisible(true);
            limpiar_pantalla_login();
        }
        
        if(ae.getSource() == pantallaR.jButton_Atras){
            pantallaP.setVisible(true);
            pantallaR.setVisible(false); 
            limpiar_pantalla_crearUsuario();
        } 
        
        //Inscribirse
        if (ae.getSource() == pantallaR.jButton_registrarse) {
            if(Validacion.validarEmail(pantallaR.jTextField_email.getText())){
                if (Validacion.validarContrasena(pantallaR.jTextField_contrasena.getText())) {
                    usuario.setDni(pantallaR.jTextField_dni.getText());
                    usuario.setNombre(pantallaR.jTextField_nombre.getText());
                    usuario.setApellidos(pantallaR.jTextField_apellidos.getText());
                    usuario.setDepartamento(pantallaR.jTextField_departamento.getText());
                    usuario.setPuesto(pantallaR.jTextField_puesto.getText());
                    usuario.setEmail(pantallaR.jTextField_email.getText());
                    usuario.setContrasena(pantallaR.jTextField_contrasena.getText());

                    //Rol fijo -> 'admin'
                    usuario.setRol("admin");

                    if (usuarioDAO.insertar(usuario)) {
                        JOptionPane.showMessageDialog(null, "Usuario creado correctamente.");
                        limpiar_pantalla_crearUsuario();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al crear el usuario. ");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña introducida no es válida. ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El formato de email introducido es incorrecto.");
            }
        }


    }
    
    // Métodos LIMPIAR
    public void limpiar_pantalla_login(){
        pantallaL.jTextField_email.setText("");
        pantallaL.jTextField_contrasena.setText("");
    }

    public void limpiar_pantalla_resturarContrasena(){
        pantallaC.jTextField_usuario.setText("");
        pantallaC.jTextField_dni.setText("");
        pantallaC.jTextField_contrasena_nueva.setText("");
    }

    public void limpiar_pantalla_crearUsuario(){
        pantallaR.jTextField_dni.setText("");
        pantallaR.jTextField_nombre.setText("");
        pantallaR.jTextField_apellidos.setText("");
        pantallaR.jTextField_departamento.setText("");
        pantallaR.jTextField_puesto.setText("");
        pantallaR.jTextField_email.setText("");
        pantallaR.jTextField_contrasena.setText("");
    }
}
