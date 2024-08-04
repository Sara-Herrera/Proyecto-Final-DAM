
package clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
    
    public static boolean validarEspecie (String funcion){
        return funcion.contains(funcion);
    }

    public static boolean validarNombre(String Nombre){
        boolean checkNombre = false;
    
        // En primer lugar se verifica que no sea null
        if(Nombre != null && Nombre.length() != 0){
            boolean isPrimeraMayuscula = Character.isUpperCase(Nombre.charAt(0)); // Se verifica que la letra inicial sea mayúscula
            boolean isUnico = Nombre.matches("[a-zA-Z]+"); // Se verifica que sea texto y no haya números
            // Si las dos condiciones son verdaderas se guarda en la variable el resultado true
            checkNombre = (isPrimeraMayuscula==true && isUnico==true);
        }
        return checkNombre;
    }
    
    public static boolean validarContrasena(String contrasena){
        if (contrasena.length() != 10) {
            return false;
        }

        // Verificar si la contraseña contiene al menos un número
        boolean contieneNumero = false;
        for (int i = 0; i < contrasena.length(); i++) {
            if (Character.isDigit(contrasena.charAt(i))) {
                contieneNumero = true;
                break;
            }
        }

        // Verificar si la contraseña contiene al menos una letra mayúscula
        boolean contieneMayuscula = false;
        for (int i = 0; i < contrasena.length(); i++) {
            if (Character.isUpperCase(contrasena.charAt(i))) {
                contieneMayuscula = true;
                break;
            }
        }

        // Devolver verdadero solo si la contraseña cumple con todos los criterios
        return contieneNumero && contieneMayuscula;
    }

    public static boolean validarEmail(String email) {

        String texto_email = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
   	Pattern patron_email = Pattern.compile(texto_email);
        Matcher resultado_coincidencia = patron_email.matcher(email);
        
        return resultado_coincidencia.matches();
    }

}

