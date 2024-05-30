package Clases.DB;

import clases.Empleado;
import clases.DB.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class EmpleadoDAO {
    private Connection connection;

    public EmpleadoDAO(Connection connection) {
        this.connection = connection;
    }

    public void agregarEmpleado(Empleado empleado) throws SQLException {
    String sql = "INSERT INTO empleados (dni, nombre, apellidos, numero, correo, direccion, cargo) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, empleado.getDni());
        statement.setString(2, empleado.getNombres());
        statement.setString(3, empleado.getApellidos());
        statement.setInt(4, empleado.getNumero());
        statement.setString(5, empleado.getCorreo());
        statement.setString(6, empleado.getDireccion());
        statement.setString(7, empleado.getCargo()); // Agregar cargo aquí
        statement.executeUpdate();
    }
}


    
    public void eliminarEmpleado(int dni) throws SQLException {
        String sql = "DELETE FROM empleados WHERE dni = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dni);
            statement.executeUpdate();
        }
    }
    
    public void editarEmpleado(Empleado empleado) throws SQLException {
    String sql = "UPDATE empleados SET nombre = ?, apellidos = ?, numero = ?, correo = ?, direccion = ?, cargo = ? WHERE dni = ?";
    
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, empleado.getNombres());
        statement.setString(2, empleado.getApellidos());
        statement.setInt(3, empleado.getNumero());
        statement.setString(4, empleado.getCorreo());
        statement.setString(5, empleado.getDireccion());
        statement.setString(6, empleado.getCargo());
        statement.setInt(7, empleado.getDni());
        
        statement.executeUpdate();
    }
}


    
    public Empleado buscarPorDni(int dni) throws SQLException {
    String sql = "SELECT * FROM empleados WHERE dni = ?";
    
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, dni);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                // Construir y devolver un objeto Empleado basado en los resultados de la consulta
                return new Empleado(
                    resultSet.getInt("dni"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellidos"),
                    resultSet.getString("correo"),
                    resultSet.getInt("numero"),
                    resultSet.getString("direccion"),
                    resultSet.getString("cargo")
                );
            } else {
                return null; // Si no se encuentra ningún empleado con el DNI dado
            }
        }
    }
}

    

}
