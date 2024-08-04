
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //Info necesaria para conectar a la base de datos
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/proyecto?autoReconnect=true&useSSL=false";
    public static final String usuario = "root";
    public static final String contraseña = ""; //cambiado 'root'
    
        
    // Método para la conexion
    public Connection getConnection(){
        Connection conexion = null;        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(URL, usuario, contraseña);            
        }catch(Exception ex){
                System.err.println("El error es "+ ex);
        }        
        return conexion;
    }
}
