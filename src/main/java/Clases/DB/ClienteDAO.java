package clases.DB;

import clases.Cliente;
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

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void agregarCliente(Cliente cliente, int idEmpleado) throws SQLException {
        String sql = "INSERT INTO clientes (tipo, dni, nombre, apellidos, numero,correo, direccion, idEmpleado) VALUES (?, ?,?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getTipo());
            statement.setInt(2, cliente.getDni());
            statement.setString(3, cliente.getNombre());
            statement.setString(4, cliente.getApellidos());
            statement.setInt(5, cliente.getNumero());
            statement.setString(6, cliente.getCorreo());
            statement.setString(7, cliente.getDireccion());
            // Ajusta el valor según tu lógica para determinar si es mayorista
            statement.setInt(8, idEmpleado);
            
            statement.executeUpdate();
        }
    }
    
    public void eliminarCliente(int dni) throws SQLException {
        String sql = "DELETE FROM clientes WHERE dni = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dni);
            statement.executeUpdate();
        }
    }
    
    public void editarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET tipo = ?, nombre = ?, apellidos = ?, numero = ?, correo = ?, direccion = ? WHERE dni = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getTipo());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellidos());
            statement.setInt(4, cliente.getNumero());
            statement.setInt(5, cliente.getDni());
            
            statement.executeUpdate();
        }
    }
    
    public Cliente buscarPorDni(int dni) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE dni = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dni);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Construir y devolver un objeto Cliente basado en los resultados de la consulta
                    return new Cliente(
                        resultSet.getString("tipo"),
                        resultSet.getInt("dni"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("correo"),
                        resultSet.getInt("numero"),
                        resultSet.getString("direccion")
                    );
                } else {
                    return null; // Si no se encuentra ningún cliente con el DNI dado
                }
            }
        }
    }
    public void MostrarClientes(JTable paramTablaClientes){
        
        DataBase objetoDataBase = new DataBase();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
            paramTablaClientes.setRowSorter(OrdenarTabla);
        
        String sql="";
        
        modelo.addColumn("Apellidos");
        modelo.addColumn("Nombres");
        modelo.addColumn("DNI");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        modelo.addColumn("Direccion");
        
        paramTablaClientes.setModel(modelo);
        
        sql ="select * from clientes;";
        
        String[] datos = new String[3];
        Statement st;
        
        try{
            st= objetoDataBase.conectar().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                
                modelo.addRow(datos);    
            }
            
            paramTablaClientes.setModel(modelo);
            
        }catch (Exception e) {
        
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+e.toString());
    }
        }
    
    public void SeleccionarCliente(JTable paramTablaClientes, JTextField paramApellidos, JTextField paramNombres, JTextField paramDNI, JTextField paramTelefono, JTextField paramCorreo, JTextField paramDireccion){
        
    try{
        int fila = paramTablaClientes.getSelectedRow();
        
        if (fila >=0){
            
            paramApellidos.setText((paramTablaClientes.getValueAt(fila,0).toString()));
            paramNombres.setText((paramTablaClientes.getValueAt(fila,1).toString()));
            paramDNI.setText((paramTablaClientes.getValueAt(fila,2).toString()));
            paramTelefono.setText((paramTablaClientes.getValueAt(fila,3).toString()));
            paramCorreo.setText((paramTablaClientes.getValueAt(fila,4).toString()));
            paramDireccion.setText((paramTablaClientes.getValueAt(fila,5).toString()));
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }    
            
    } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null, "Error de seleccion, error: "+e.toString());
        
    }
}
    }
    

