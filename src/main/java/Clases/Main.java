package Clases;

import Clases.DB.EmpleadoDAO;
import Clases.DB.LoginService;
import clases.DB.DataBase;
import java.sql.Connection;
import javax.swing.JOptionPane;
//import sistemaV.DiseñoV;
import Frames.Jframe_empleados;

public class Main {
    public static void main(String[] args) {
        // Intenta establecer la conexión con la base de datos
        Connection connection = DataBase.conectar();
        
        // Si la conexión se estableció correctamente, inicializa el formulario DiseñoV
        if (connection != null) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(connection);
            //LoginService loginService = new LoginService(connection); // Proporciona la conexión a la clase LoginService
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Jframe_empleados(empleadoDAO).setVisible(true);
                    //new DiseñoV(loginService).setVisible(true);
                }
            });
        } else {
            // Si no se pudo establecer la conexión, muestra un mensaje de error y termina la aplicación
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con la base de datos.");
            System.exit(1);
        }
    }
}


