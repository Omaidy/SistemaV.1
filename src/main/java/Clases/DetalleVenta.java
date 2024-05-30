package Clases;

import java.util.Stack;

public class DetalleVenta {
    private Stack<Productos> productosStack;

    public DetalleVenta() {
        productosStack = new Stack<>();
    }

    public void agregarProducto(Productos producto) {
        productosStack.push(producto);
    }

    public Productos eliminarUltimoProducto() {
        if (!productosStack.isEmpty()) {
            return productosStack.pop();
        }
        return null;
    }


}
