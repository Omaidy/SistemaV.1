package Clases.DB;
import Clases.Productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    private Connection connection;

    public PedidoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para generar un pedido de un producto
    public void generarPedido(Productos producto) {
        try {
            String sql = "INSERT INTO pedidos (codigo_producto, cantidad) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, producto.getCodigo());
            statement.setInt(2, producto.getCantidad());
            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Pedido generado correctamente para el producto: " + producto.getNombre());
            } else {
                System.out.println("No se pudo generar el pedido para el producto: " + producto.getNombre());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para encontrar las tallas disponibles de un producto
    public List<String> obtenerTallasParaProducto(Productos producto) {
        List<String> tallasDisponibles = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT talla FROM productos WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, producto.getCodigo());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tallasDisponibles.add(resultSet.getString("talla"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tallasDisponibles;
    }
}
