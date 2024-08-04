package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.PantallaLogin;
import vista.PantallaPrincipal;
import vista.PantallaRestaurarContrasena;
import vista.PantallaResultados;
import vista.PantallaSecundaria;
import vista.PantallaUsuario;

public class ControladorMouseEvent implements MouseListener {

    int xMouse, yMouse;
    //Colores
    Color color_VerdeOscuro = new Color(0,51,51);
    Color color_VerdeClaro = new Color(47,95,95);
    Color color_GrisVerde = new Color(227,95,95);

    private PantallaLogin pantallaL;
    private PantallaPrincipal pantallaP;
    private PantallaRestaurarContrasena pantallaRC;
    private PantallaResultados pantallaR;
    private PantallaSecundaria pantallaSec;
    private PantallaUsuario pantallaU;

    public ControladorMouseEvent(PantallaLogin pantallaL, PantallaPrincipal pantallaP, PantallaRestaurarContrasena pantallaRC, PantallaResultados pantallaR, PantallaSecundaria pantallaSec, PantallaUsuario pantallaU) {
        this.pantallaL = pantallaL;
        this.pantallaP = pantallaP;
        this.pantallaRC = pantallaRC;
        this.pantallaR = pantallaR;
        this.pantallaSec = pantallaSec;
        this.pantallaU = pantallaU;

        pantallaL.jButton_Atras.addMouseListener(this);
        pantallaL.jButton_cambiarContrasena.addMouseListener(this);
        pantallaL.jButton_iniciar.addMouseListener(this);
        
        pantallaP.jButton_BuscarCv.addMouseListener(this);
        pantallaP.jButton_FichaVarietal.addMouseListener(this);
        pantallaP.jButton_login.addMouseListener(this);
        pantallaP.jButton_logout.addMouseListener(this);
        pantallaP.jButton_registro.addMouseListener(this);

        pantallaRC.jButton_Atras.addMouseListener(this);
        pantallaRC.jButton_restaurar.addMouseListener(this);
        
        pantallaR.jButton_Atras.addMouseListener(this);
        pantallaR.jButton_Eliminar.addMouseListener(this);
        pantallaR.jButton_FiltrarResultados.addMouseListener(this);
        pantallaR.jButton_Modificar.addMouseListener(this);
        pantallaR.jButton_logout.addMouseListener(this);
        
        pantallaSec.jButton_Atras.addMouseListener(this);
        pantallaSec.jButton_Insertar.addMouseListener(this);
        pantallaSec.jButton_logout.addMouseListener(this);
        
        pantallaU.jButton_Atras.addMouseListener(this);
        pantallaU.jButton_logout.addMouseListener(this);
        pantallaU.jButton_registrarse.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //Pantalla Login
        if (me.getSource() == pantallaL.jButton_Atras) {
            pantallaL.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaL.jButton_cambiarContrasena) {
            pantallaL.jButton_cambiarContrasena.setForeground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaL.jButton_iniciar) {
            pantallaL.jButton_iniciar.setBackground(color_VerdeOscuro);
        }
        
        //Pantalla Principal
        if (me.getSource() == pantallaP.jButton_BuscarCv) {
            pantallaP.jButton_BuscarCv.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaP.jButton_FichaVarietal) {
            pantallaP.jButton_FichaVarietal.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaP.jButton_login) {
            pantallaP.jButton_login.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaP.jButton_logout) {
            pantallaP.jButton_logout.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaP.jButton_registro) {
            pantallaP.jButton_registro.setBackground(color_VerdeOscuro);
        }
        //Pantalla Restaurar Contrasena
        if (me.getSource() == pantallaRC.jButton_Atras) {
            pantallaRC.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaRC.jButton_restaurar) {
            pantallaRC.jButton_restaurar.setBackground(color_VerdeOscuro);
        }
        //Pantalla Resultados
        if (me.getSource() == pantallaR.jButton_Atras) {
            pantallaR.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaR.jButton_Eliminar) {
            pantallaR.jButton_Eliminar.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaR.jButton_FiltrarResultados) {
            pantallaR.jButton_FiltrarResultados.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaR.jButton_Modificar) {
            pantallaR.jButton_Modificar.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaR.jButton_logout) {
            pantallaR.jButton_logout.setBackground(color_VerdeOscuro);
        }
        //Pantalla Secundaria
        if (me.getSource() == pantallaSec.jButton_Atras) {
            pantallaSec.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaSec.jButton_Insertar) {
            pantallaSec.jButton_Insertar.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaSec.jButton_logout) {
            pantallaSec.jButton_logout.setBackground(color_VerdeOscuro);
        }
        //Pantalla Usuario
        if (me.getSource() == pantallaU.jButton_Atras) {
            pantallaU.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaU.jButton_logout) {
            pantallaU.jButton_logout.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaU.jButton_registrarse) {
            pantallaU.jButton_registrarse.setBackground(color_VerdeOscuro);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //Pantalla Login
        if (me.getSource() == pantallaL.jButton_Atras) {
            pantallaL.jButton_Atras.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaL.jButton_cambiarContrasena) {
            pantallaL.jButton_cambiarContrasena.setForeground(color_GrisVerde);
        }
        if (me.getSource() == pantallaL.jButton_iniciar) {
            pantallaL.jButton_iniciar.setBackground(color_GrisVerde);
        }
        //Pantalla Principal
        if (me.getSource() == pantallaP.jButton_BuscarCv) {
            pantallaP.jButton_BuscarCv.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaP.jButton_FichaVarietal) {
            pantallaP.jButton_FichaVarietal.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaP.jButton_login) {
            pantallaP.jButton_login.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaP.jButton_logout) {
            pantallaP.jButton_logout.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaP.jButton_registro) {
            pantallaP.jButton_registro.setBackground(color_GrisVerde);
        }
        //Pantalla Restaurar Contrasena
        if (me.getSource() == pantallaRC.jButton_Atras) {
            pantallaRC.jButton_Atras.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaRC.jButton_restaurar) {
            pantallaRC.jButton_restaurar.setBackground(color_GrisVerde);
        }
        //Pantalla Resultados
        if (me.getSource() == pantallaR.jButton_Atras) {
            pantallaR.jButton_Atras.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaR.jButton_Eliminar) {
            pantallaR.jButton_Eliminar.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaR.jButton_FiltrarResultados) {
            pantallaR.jButton_FiltrarResultados.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaR.jButton_Modificar) {
            pantallaR.jButton_Modificar.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaR.jButton_logout) {
            pantallaR.jButton_logout.setBackground(color_GrisVerde);
        }
        //Pantalla Secundaria
        if (me.getSource() == pantallaSec.jButton_Atras) {
            pantallaSec.jButton_Atras.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaSec.jButton_Insertar) {
            pantallaSec.jButton_Insertar.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaSec.jButton_logout) {
            pantallaSec.jButton_logout.setBackground(color_GrisVerde);
        }
        //Pantalla Usuario
        if (me.getSource() == pantallaU.jButton_Atras) {
            pantallaU.jButton_Atras.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaU.jButton_logout) {
            pantallaU.jButton_logout.setBackground(color_GrisVerde);
        }
        if (me.getSource() == pantallaU.jButton_registrarse) {
            pantallaU.jButton_registrarse.setBackground(color_GrisVerde);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //Pantalla Login
        if (me.getSource() == pantallaL.jButton_Atras) {
            pantallaL.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaL.jButton_cambiarContrasena) {
            pantallaL.jButton_cambiarContrasena.setForeground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaL.jButton_iniciar) {
            pantallaL.jButton_iniciar.setBackground(color_VerdeOscuro);
        }
        //Pantalla Principal
        if (me.getSource() == pantallaP.jButton_BuscarCv) {
            pantallaP.jButton_BuscarCv.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaP.jButton_FichaVarietal) {
            pantallaP.jButton_FichaVarietal.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaP.jButton_login) {
            pantallaP.jButton_login.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaP.jButton_logout) {
            pantallaP.jButton_logout.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaP.jButton_registro) {
            pantallaP.jButton_registro.setBackground(color_VerdeOscuro);
        }
        //Pantalla Restaurar Contrasena
        if (me.getSource() == pantallaRC.jButton_Atras) {
            pantallaRC.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaRC.jButton_restaurar) {
            pantallaRC.jButton_restaurar.setBackground(color_VerdeOscuro);
        }
        //Pantalla Resultados
        if (me.getSource() == pantallaR.jButton_Atras) {
            pantallaR.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaR.jButton_Eliminar) {
            pantallaR.jButton_Eliminar.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaR.jButton_FiltrarResultados) {
            pantallaR.jButton_FiltrarResultados.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaR.jButton_Modificar) {
            pantallaR.jButton_Modificar.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaR.jButton_logout) {
            pantallaR.jButton_logout.setBackground(color_VerdeOscuro);
        }
        //Pantalla Secundaria
        if (me.getSource() == pantallaSec.jButton_Atras) {
            pantallaSec.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaSec.jButton_Insertar) {
            pantallaSec.jButton_Insertar.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaSec.jButton_logout) {
            pantallaSec.jButton_logout.setBackground(color_VerdeOscuro);
        }
        //Pantalla Usuario
        if (me.getSource() == pantallaU.jButton_Atras) {
            pantallaU.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaU.jButton_logout) {
            pantallaU.jButton_logout.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaU.jButton_registrarse) {
            pantallaU.jButton_registrarse.setBackground(color_VerdeOscuro);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //Pantalla Login
        if (me.getSource() == pantallaL.jButton_Atras) {
            pantallaL.jButton_Atras.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaL.jButton_cambiarContrasena) {
            pantallaL.jButton_cambiarContrasena.setForeground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaL.jButton_iniciar) {
            pantallaL.jButton_iniciar.setBackground(color_VerdeClaro);
        }
        //Pantalla Principal
        if (me.getSource() == pantallaP.jButton_BuscarCv) {
            pantallaP.jButton_BuscarCv.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaP.jButton_FichaVarietal) {
            pantallaP.jButton_FichaVarietal.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaP.jButton_login) {
            pantallaP.jButton_login.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaP.jButton_logout) {
            pantallaP.jButton_logout.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaP.jButton_registro) {
            pantallaP.jButton_registro.setBackground(color_VerdeClaro);
        }
        //Pantalla Restaurar Contrasena
        if (me.getSource() == pantallaRC.jButton_Atras) {
            pantallaRC.jButton_Atras.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaRC.jButton_restaurar) {
            pantallaRC.jButton_restaurar.setBackground(color_VerdeClaro);
        }
        //Pantalla Resultados
        if (me.getSource() == pantallaR.jButton_Atras) {
            pantallaR.jButton_Atras.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaR.jButton_Eliminar) {
            pantallaR.jButton_Eliminar.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaR.jButton_FiltrarResultados) {
            pantallaR.jButton_FiltrarResultados.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaR.jButton_Modificar) {
            pantallaR.jButton_Modificar.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaR.jButton_logout) {
            pantallaR.jButton_logout.setBackground(color_VerdeClaro);
        }
        //Pantalla Secundaria
        if (me.getSource() == pantallaSec.jButton_Atras) {
            pantallaSec.jButton_Atras.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaSec.jButton_Insertar) {
            pantallaSec.jButton_Insertar.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaSec.jButton_logout) {
            pantallaSec.jButton_logout.setBackground(color_VerdeClaro);
        }
        //Pantalla Usuario
        if (me.getSource() == pantallaU.jButton_Atras) {
            pantallaU.jButton_Atras.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaU.jButton_logout) {
            pantallaU.jButton_logout.setBackground(color_VerdeClaro);
        }
        if (me.getSource() == pantallaU.jButton_registrarse) {
            pantallaU.jButton_registrarse.setBackground(color_VerdeClaro);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //Pantalla Login
        if (me.getSource() == pantallaL.jButton_Atras) {
            pantallaL.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaL.jButton_cambiarContrasena) {
            pantallaL.jButton_cambiarContrasena.setForeground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaL.jButton_iniciar) {
            pantallaL.jButton_iniciar.setBackground(color_VerdeOscuro);
        }
        //Pantalla Principal
        if (me.getSource() == pantallaP.jButton_BuscarCv) {
            pantallaP.jButton_BuscarCv.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaP.jButton_FichaVarietal) {
            pantallaP.jButton_FichaVarietal.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaP.jButton_login) {
            pantallaP.jButton_login.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaP.jButton_logout) {
            pantallaP.jButton_logout.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaP.jButton_registro) {
            pantallaP.jButton_registro.setBackground(color_VerdeOscuro);
        }
        //Pantalla Restaurar Contrasena
        if (me.getSource() == pantallaRC.jButton_Atras) {
            pantallaRC.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaRC.jButton_restaurar) {
            pantallaRC.jButton_restaurar.setBackground(color_VerdeOscuro);
        }
        //Pantalla Resultados
        if (me.getSource() == pantallaR.jButton_Atras) {
            pantallaR.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaR.jButton_Eliminar) {
            pantallaR.jButton_Eliminar.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaR.jButton_FiltrarResultados) {
            pantallaR.jButton_FiltrarResultados.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaR.jButton_Modificar) {
            pantallaR.jButton_Modificar.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaR.jButton_logout) {
            pantallaR.jButton_logout.setBackground(color_VerdeOscuro);
        }
        //Pantalla Secundaria
        if (me.getSource() == pantallaSec.jButton_Atras) {
            pantallaSec.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaSec.jButton_Insertar) {
            pantallaSec.jButton_Insertar.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaSec.jButton_logout) {
            pantallaSec.jButton_logout.setBackground(color_VerdeOscuro);
        }
        //Pantalla Usuario
        if (me.getSource() == pantallaU.jButton_Atras) {
            pantallaU.jButton_Atras.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaU.jButton_logout) {
            pantallaU.jButton_logout.setBackground(color_VerdeOscuro);
        }
        if (me.getSource() == pantallaU.jButton_registrarse) {
            pantallaU.jButton_registrarse.setBackground(color_VerdeOscuro);
        }
    }

}
