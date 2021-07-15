package ejercicio_publicaciones;

public class Revista extends Publicacion implements Periodicidad {
    private String issn;
    private int numero;

    public Revista(String titulo, String autor, int numpag, double precio) {
        super(titulo, autor, numpag, precio);
    }

    public String getISSN() {
        return issn;
    }

    public void setISSN(String issn) {
        this.issn = issn;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String getPeriodicidad() {
        return "Semanal";
    }

    public void imprimirDatosRevista() {
        imprimirDatosPublicacion();

        System.out.println("ISSN: " + issn);
        System.out.println("Numero #" + numero);
        System.out.println("Periodicidad " + getPeriodicidad());
    }

}
