package ejercicio1;

public class Empleado {
    
    private long id;
    private String nombre;
    private String direccion;
    private float salarioHora;

    public Empleado() {

    }

    public Empleado(long id, String nombre, String direccion, float salarioHora) throws IllegalArgumentException{
        this.id = id;

        if(nombre.isEmpty() || nombre.isBlank()) {
            throw new IllegalArgumentException("El argumento nombre está vacío");
        } else {
            this.nombre = nombre;
        }

        if(direccion.isEmpty() || direccion.isBlank()) {
            throw new IllegalArgumentException("El argumento direccion está vacío");
        } else {
            this.direccion = direccion;
        }
        
        if(salarioHora <= 0) {
            throw new IllegalArgumentException("El argumento salarioHora debe ser mayor a 0");
        } else {
            this.salarioHora = salarioHora;
        }
    }

    public String GetDatosEmpleado() {
        String datosEmpleado = "\n----------"; 
        datosEmpleado += "\nEmpleado " + id;
        datosEmpleado += "\nNombre: \t" + nombre;
        datosEmpleado += "\nDireccion: \t" + direccion;
        datosEmpleado += "\nSalario Por Hora: \t" + salarioHora;
        
        return datosEmpleado;
    }

    public float calcularSalario(int horasTrabajadas) throws IllegalArgumentException{
        if(horasTrabajadas > 0) {
            return horasTrabajadas * salarioHora;
        } else {
            throw new IllegalArgumentException("El parámetro horasTrabajadas debe ser mayor a 0");
        }
    }
}
