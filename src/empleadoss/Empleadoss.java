package empleadoss;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Empleadoss {

    public static void main(String[] args) throws FileNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Insetar Empleado");
            System.out.println("2. Mostrar Empleados");
            System.out.println("3. buscar por ID");
            System.out.println("4. Actualizar Empleados");
            System.out.println("5. Eliminar Empleado");
            int op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1:
                    System.out.println("\nIsertar empleado. ");
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Correo: ");
                    String correo = scanner.nextLine();
                    System.out.println("Departamento: ");
                    String departamento = scanner.nextLine();
                    System.out.println("Telefono: ");
                    String telefono = scanner.nextLine();

                    OperacionesCRUD.inserEmpleado(nombre, apellido, correo, departamento, telefono);
                    break;
                    
                case 2:
                    System.out.println("Personas:");
                    OperacionesCRUD.mostrarPersona();                    
                    break;
                    
                case 3:
                    System.out.println("Buscar persona:");
                    System.out.println("Igresa el id de la persona");
                    int id = scanner.nextInt();  
                    OperacionesCRUD.buscarPersonabiID(id);
                    break;
                    
                case 4:
                    System.out.println("Actualizar persona:");
                    System.out.println("ID de la persona a Actulizar: ");
                    int idActual = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Nombre: ");
                    String nombreNew = scanner.nextLine();
                    
                    System.out.println("Apellido: ");
                    String apellidoNew = scanner.nextLine();
                    
                    System.out.println("Correo: ");
                    String CorreoNew = scanner.nextLine();
                    
                    System.out.println("Departamento: ");
                    String departamentoNew = scanner.nextLine();
                    
                    System.out.println("Telefono: ");
                    String telefonoNew = scanner.nextLine();
                    
                    OperacionesCRUD.actualizarPersona(nombreNew, apellidoNew, CorreoNew, departamentoNew, telefonoNew, idActual);
                    break;
                    
                case 5:
                    System.out.println("Eliminar persona:");
                    System.out.println("digite el ID De la persona a ELIMINAR: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();
                    OperacionesCRUD.eliminarPersona(idEliminar);                    
                    break;
                default:
                    System.out.println("\n Opcion no valida.");
                    throw new AssertionError();
            }

        }
    }
}
