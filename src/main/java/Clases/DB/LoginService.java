package Clases.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    
    private Connection connection;

    public LoginService(Connection connection) {
        this.connection = connection;
    }
    // Método para verificar el inicio de sesión
    public boolean verificarInicioSesion(String nombreUsuario, String contrasena) {
        // Consulta SQL para buscar las credenciales en la tabla login
        String sql = "SELECT * FROM login WHERE nombreUsuario = ? AND contrasena = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasena);
            try (ResultSet resultSet = statement.executeQuery()) {
                // Si el conjunto de resultados tiene al menos una fila, las credenciales son válidas
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
