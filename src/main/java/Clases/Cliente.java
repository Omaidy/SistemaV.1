package clases;

public class Cliente {
    
	private String tipo;
	private int dni;
	private String nombre;
	private String apellidos;
	private int numero;
        private String correo;
        private String direccion;
        
	public Cliente(String tipo, int dni, String nombre, String apellidos, String correo, int numero, String direccion){
        
        this.tipo = tipo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numero = numero;
        this.correo= correo;
        this.direccion= direccion;
        
        }
        public String getTipo(){
            return tipo;
        }
        public void setTipo(String tipo){
            this.tipo = tipo;
        }
        public int getDni(){
            return dni;
        }
        public void setDni(int dni){
            this.dni = dni;
        }
        public String getNombre(){
            return nombre;
        }
        public void setNombre(String nombre){
            this.nombre = nombre;
        }
        public String getApellidos(){
            return apellidos;
        }
        public void setApellidos(String apellidos){
            this.apellidos = apellidos;
        }
        public int getNumero(){
            return numero;
        }
        public void setNumero(int numero){
            this.numero = numero;
        }
        public String getCorreo(){
            return correo;
        }
        public void setCorreo(String correo){
            this.correo = correo;
        }
        public String getDireccion(){
            return direccion;
        }
        public void setDireccion(String direccion){
            this.direccion = direccion;
        }
}
