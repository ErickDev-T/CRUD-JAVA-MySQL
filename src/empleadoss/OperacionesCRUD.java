package empleadoss;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Erick Tejada
 */
public class OperacionesCRUD {

    private static final String INSERT_QUERY = "insert into empleados (Nombres, Apellidos, Correo, Departamento, Telefono) values (?,?,?,?,?)";
    private static final String SELECT_QUERY = "select * from empleados";
    private static final String LIST_QUERY = "select * from empleados where id = ?";
    private static final String UPDATE_QUERY = "update empleados set Nombres=?, Apellidos=?, Correo=?, Departamento=?, Telefono=? where ID=?";
    private static final String DELETE_QUERY = "delete from empleados where id =?";

    // metodo INSERTAR 
    public static void inserEmpleado(String nombre, String apellido, String correo, String departamento, String telefono) throws FileNotFoundException, SQLException {
        try {
            Connection conexion = ConexionDB.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, correo);
            preparedStatement.setString(4, departamento);
            preparedStatement.setString(5, telefono);
            int insertado = preparedStatement.executeUpdate();
            if (insertado > 0) {
                System.out.println("Empleado Insertado correctamente");
            } else {
                System.out.println("EL empleado no fue Insertado");
            }
        } catch (SQLException e) {
            System.out.println("INSERT (ERROR): " + e.getMessage());
        }
    }

    //mostral persona     
    public static void mostrarPersona() throws FileNotFoundException {
        try {
            Connection conexion = ConexionDB.getConexion();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nombre = resultSet.getString("nombres");
                String apellido = resultSet.getString("apellidos");
                String Correo = resultSet.getString("Correo");
                String dep = resultSet.getString("Departamento");
                String telefono = resultSet.getString("telefono");
                System.out.println("**---------------------------------------------------------------------------------------------------------------**");
                System.out.println("** ID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nEdad: " + Correo + "\nDepartamento:" + dep + "\nTelefono: " + telefono);
                System.out.println("**----------------------------------------------------------------------------------------------------------------**");
            }
        } catch (SQLException e) {
            System.out.println("SELECT (mensaje: )" + e.getMessage());
        }
    }

    public static void buscarPersonabiID(int id) throws FileNotFoundException {
        try {
            Connection conexion = ConexionDB.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(LIST_QUERY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombres");
                String apellido = resultSet.getString("apellidos");
                String Correo = resultSet.getString("Correo");
                String dep = resultSet.getString("Departamento");
                String telefono = resultSet.getString("telefono");
                System.out.println("**---------------------------------------------------------------------------------------------------------------**");
                System.out.println("** ID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nEdad: " + Correo + "\nDepartamento:" + dep + "\nTelefono: " + telefono);
                System.out.println("**----------------------------------------------------------------------------------------------------------------**");
            } else {
                System.out.println("La persono que busca no esta registradaa con el ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Buscar (mensaje: )" + e.getMessage());
        }
    }

    public static void actualizarPersona(String nombres, String apellidos, String Correo, String Depepartamento, String telefono, int id) throws FileNotFoundException {
        try {
            Connection conexion = ConexionDB.getConexion();
            PreparedStatement preparedStatement = conexion.prepareCall(UPDATE_QUERY);
            preparedStatement.setString(1, nombres);
            preparedStatement.setString(2, apellidos);
            preparedStatement.setString(3, Correo);
            preparedStatement.setString(4, Depepartamento);
            preparedStatement.setString(5, telefono);
            preparedStatement.setInt(6, id);
            
            int filasActaulizada = preparedStatement.executeUpdate();  
            if (filasActaulizada > 0) {
                System.out.println("Persona ACTUALIZADA corectamente");
            } else {
                System.out.println("Persona ACTUALIZADA incorectamente");
            }

        } catch (SQLException e) {
            System.out.println("Actulizar (mensaje): " + e.getMessage());
        }
    }

    public static void eliminarPersona(int id) throws FileNotFoundException {
        try {
            Connection conexion = ConexionDB.getConexion();          
            PreparedStatement preparedStatement = conexion.prepareStatement(DELETE_QUERY); 
            preparedStatement.setInt(1, id);        
            int filasInsertadas = preparedStatement.executeUpdate();
            if (filasInsertadas > 0) {              
                System.out.println("Empleado ELIMINADA corectamente");
            } else {
                System.out.println("Empleado NO EXISTE");
            }
        } catch (SQLException e) {
            System.out.println("ELIMINAR (mensaje): " + e.getMessage());
        }
    }

}
