package contactosCRUD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jquezada
 */
public class ConexionMYSQL {

    String db = "contactos";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cn;

    /**
     *
     * @return @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public Connection conectar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (cn == null) {
            try {
                Class.forName(driver);
                cn = (Connection) DriverManager.getConnection(url + db, user, password);
                System.out.println("Estamos conectados con exito.");

            } catch (SQLException | ClassNotFoundException  ex) {
                System.out.println("Error en la conexion :" + ex);
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return cn;
    }

    public void desconectar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
