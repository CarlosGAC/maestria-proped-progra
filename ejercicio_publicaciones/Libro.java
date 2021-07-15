package ejercicio_publicaciones;

public class Libro extends Publicacion{
    private String isbn;
    private String edicion;

    public Libro(String titulo, String autor, int numpag, double precio) {
        super(titulo, autor, numpag, precio);
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public void imprimirDatosLibro() {
        imprimirDatosPublicacion();

        System.out.println("ISBN: " + isbn);
        System.out.println(edicion + " Edicion");
    }
}
