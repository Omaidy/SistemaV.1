package clases.DB;

import clases.Cliente;
import clases.DB.ClienteDAO;
import java.sql.Connection;
import java.sql.SQLException;

public class ClienteService {
    private Connection connection;

    public ClienteService(Connection connection) {
        this.connection = connection;
    }

    public void agregarCliente(Cliente cliente, int idEmpleado) throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO(connection);
        clienteDAO.agregarCliente(cliente, idEmpleado);
    }
}

