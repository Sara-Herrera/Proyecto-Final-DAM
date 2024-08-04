
package clases;

import clases.Frutal;
import clases.Albaricoquero;
import clases.Almendro;
import modelo.FrutalDAO;
import modelo.FrutalDAOImpl;
import controlador.ControladorFrutal;
import controlador.ControladorUsuario;
import controlador.ControladorMouseEvent;
import modelo.UsuarioDAO;
import modelo.UsuarioDAOImpl;
import vista.PantallaLogin;
import vista.PantallaPrincipal;
import vista.PantallaRestaurarContrasena;
import vista.PantallaResultados;
import vista.PantallaSecundaria;
import vista.PantallaUsuario;

public class Main {
    public static void main(String args[]) {
        PantallaPrincipal pantallaP = new PantallaPrincipal();
        PantallaSecundaria pantallaS = new PantallaSecundaria();
        PantallaResultados pantallaRes = new PantallaResultados();
        PantallaLogin pantallaL = new PantallaLogin();
        PantallaUsuario pantallaR = new PantallaUsuario();
        PantallaRestaurarContrasena pantallaC = new PantallaRestaurarContrasena();
        Frutal frutal = new Frutal();
        Albaricoquero albaricoquero = new Albaricoquero();
        Almendro almendro = new Almendro();
        FrutalDAOImpl daoFrutal = new FrutalDAOImpl();
        UsuarioDAOImpl daoUsuario = new UsuarioDAOImpl();
        Usuario usuario = new Usuario();
        ControladorFrutal controlFrutal = new ControladorFrutal(pantallaP,pantallaS,pantallaRes,pantallaL,frutal,albaricoquero,almendro,daoFrutal);
        ControladorUsuario controlUsuario = new ControladorUsuario(pantallaP, pantallaS, pantallaRes, pantallaL, pantallaR, pantallaC, daoUsuario, usuario);
        ControladorMouseEvent MeC = new ControladorMouseEvent(pantallaL, pantallaP, pantallaC, pantallaRes, pantallaS, pantallaR);
        
        controlFrutal.iniciar();
        controlUsuario.iniciar();
        pantallaP.setVisible(true);

        
    }
    
    //TODO: Pendiente al atras en pantalla resultados borrar pantalla resultados y al avanzar en pantalla ppal también porque si se va atrás está marcado lo que se había introducido
    
}
