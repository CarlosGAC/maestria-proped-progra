package ejercicio_publicaciones;

public class Periodico extends Publicacion implements Periodicidad{
    String fecha;

    public Periodico(String titulo, String autor, int numpag, double precio) {
        super(titulo, autor, numpag, precio);
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String getPeriodicidad() {
        return "Diaria";
    }

    public void imprimirDatosPeriodico() {
        imprimirDatosPublicacion();

        System.out.println("Fecha: " + fecha);
        System.out.println("Periodicidad " + getPeriodicidad());
    }
}
