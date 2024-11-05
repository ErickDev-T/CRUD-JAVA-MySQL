package empleadoss;

import java.sql.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Erick Tejada
 */
public class ConexionDB {

    private static Connection conexion = null;

    public static Connection getConexion() throws FileNotFoundException, SQLException {

        if (conexion != null && !conexion.isClosed()) {
            return conexion;
        } else {
            try {
                String directorioActual = System.getProperty("user.dir");
                String rutaArchivo = directorioActual + File.separator + "\\src\\empleadoss\\Configuracion.txt";
                
                File archivo = new File(rutaArchivo);             
                
                FileReader lector = new FileReader(archivo);            
                
                String url;
                String user;
                String pass;            
                
                BufferedReader buffer;
                buffer = new BufferedReader(lector);
                
                url = buffer.readLine();
                user = buffer.readLine();
                pass = buffer.readLine();
                
                buffer.close();
                
                conexion = DriverManager.getConnection(url, user, pass);
                System.out.println("Conectado a base de datos");
                return conexion;

            } catch (IOException e) {
                System.out.println("ERROR DE CONEXION: " + e.getMessage());
                return null;
            }
        }
    }
}
