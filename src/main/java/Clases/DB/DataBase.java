package clases.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/aed";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexión establecida correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }

    public static void desconectar(Connection connection) {
        
        if (connection != null) {
            try {
                connection.close();
                JOptionPane.showMessageDialog(null,"Conexión cerrada correctamente.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    
    
}

