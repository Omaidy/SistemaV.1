package clases;

public class Algoritmos{
    
    public static String generarNombreUsuario(Empleado empleado) {
        // Obtener las 3 primeras letras del nombre
        String nombreAbreviado = empleado.getNombres().substring(0, Math.min(empleado.getNombres().length(), 3));

        // Obtener las 3 últimas letras del apellido
        String apellidoAbreviado = empleado.getApellidos().substring(Math.max(empleado.getApellidos().length() - 3, 0));

        // Intercale las letras para formar el nombre de usuario
        StringBuilder nombreUsuarioBuilder = new StringBuilder();
        for (int i = 0; i < Math.min(nombreAbreviado.length(), apellidoAbreviado.length()); i++) {
            nombreUsuarioBuilder.append(nombreAbreviado.charAt(i));
            nombreUsuarioBuilder.append(apellidoAbreviado.charAt(i));
        }
        // Si uno de los nombres es más corto que el otro, agregar el resto del nombre más largo
        if (nombreAbreviado.length() < apellidoAbreviado.length()) {
            nombreUsuarioBuilder.append(apellidoAbreviado.substring(nombreAbreviado.length()));
        } else if (nombreAbreviado.length() > apellidoAbreviado.length()) {
            nombreUsuarioBuilder.append(nombreAbreviado.substring(apellidoAbreviado.length()));
        }
        return nombreUsuarioBuilder.toString();
    }
    
    
}

