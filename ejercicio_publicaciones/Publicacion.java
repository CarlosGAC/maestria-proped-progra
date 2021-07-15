package ejercicio_publicaciones;

public class Publicacion {
    private String titulo;
    private int numpag;
    private double precio;
    private String autor;

    public Publicacion(String titulo, String autor, int numpag, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.numpag = numpag;
        this.precio = precio;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumpag(){
     return numpag;
    }
    
    public void setNumpag(int numpag){
        this.numpag = numpag;
    }
    
    public double getPrecio(){
     return precio;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    protected void imprimirDatosPublicacion() {
        System.out.println("---" + titulo + "---");
        System.out.println("Autor: " + autor);
        System.out.println("Numero de paginas: " + numpag);
        System.out.println("$" + precio);
    }
}
