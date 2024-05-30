package Clases;

import Clases.DB.PedidoDAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Productos {
    private String codigo;
    private String nombre;
    private String descripcion;
    private List<String> tallas;
    private int cantidad;
    private Connection connection;

    public Productos(String codigo, String nombre, String descripcion, List<String> tallas, int cantidad, Connection connection) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tallas = tallas;
        this.cantidad = cantidad;
        this.connection = connection;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<String> getTallas() {
        return tallas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTallas(List<String> tallas) {
        this.tallas = tallas;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método para generar un pedido de este producto
    public void generarPedido() {
        PedidoDAO pedidoDAO = new PedidoDAO(connection);
        pedidoDAO.generarPedido(this);
    }

    public List<String> encontrarTallas(PedidoDAO pedidoDAO) {
        List<String> tallasDisponibles = pedidoDAO.obtenerTallasParaProducto(this);
        return tallasDisponibles;
    }
}
