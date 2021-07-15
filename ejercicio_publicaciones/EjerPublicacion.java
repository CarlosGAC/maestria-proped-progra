package ejercicio_publicaciones;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class EjerPublicacion {

    enum TipoPublicacion {
        LIBRO,
        REVISTA,
        PERIODICO
    };

    public static Scanner entrada;
    public static List<Publicacion> lista;

    public static void main(String[] args) {

        int opcion;
        entrada = new Scanner(System.in);

        lista = new ArrayList<>();

        do {
            System.out.println("\n\n****BIENVENIDO****"
            + "\n\n1) Agregar Libro"
            + "\n2) Agregar Revista"
            + "\n3) Agregar Periodico"
            + "\n4) Imprimir Lista"
            + "\nIngrese Opcion:");

            opcion = Integer.parseInt(entrada.nextLine());

            switch(opcion) {
                case 1:
                    lista.add(agregarPublicacion(TipoPublicacion.LIBRO));
                break;
                case 2:
                    lista.add(agregarPublicacion(TipoPublicacion.REVISTA));
                break;
                case 3:
                    lista.add(agregarPublicacion(TipoPublicacion.PERIODICO));
                break;
                case 4:
                    imprimirListaDePublicaciones();
                break;
                case 5:
                    System.out.println("Saliendo...");
                break;
                default:
                    System.err.println("La opcion no existe");
                break;
            }
        } while(opcion != 5);

        entrada.close();
    }

    public static Publicacion agregarPublicacion(TipoPublicacion tipo) {
        String titulo;
        String autor;
        int numpag;
        double precio;

        System.out.println("Ingrese Titulo: ");
        titulo = entrada.nextLine();

        System.out.println("Ingrese Autor: ");
        autor = entrada.nextLine();

        System.out.println("Ingrese numero de paginas: ");
        numpag = Integer.parseInt(entrada.nextLine());

        System.out.println("Ingrese precio: ");
        precio = Double.parseDouble(entrada.nextLine());

        if(tipo == TipoPublicacion.LIBRO) {
            Libro l = new Libro(titulo, autor, numpag, precio);

            System.out.println("Ingrese isbn: ");
            l.setISBN(entrada.nextLine());

            System.out.println("Ingrese edicion: ");
            l.setEdicion(entrada.nextLine());

            return l;
        } else if(tipo == TipoPublicacion.REVISTA) {
            Revista r = new Revista(titulo, autor, numpag, precio);

            System.out.println("Ingrese issn: ");
            r.setISSN(entrada.nextLine());

            System.out.println("Ingrese numero: ");
            r.setNumero(Integer.parseInt(entrada.nextLine()));

            return r;
        } else if(tipo == TipoPublicacion.PERIODICO) {
            Periodico p = new Periodico(titulo, autor, numpag, precio);

            System.out.println("Ingrese fecha: ");
            p.setFecha(entrada.nextLine());
            return p;
        } else {
            throw new IllegalArgumentException("El argumento tipo no corresponde a ningun tipo de publicacion");
        }
    }

    public static void imprimirListaDePublicaciones() {
        for(int i = 0; i < lista.size(); i++) {
            Publicacion p = lista.get(i);

            if(p instanceof Libro) {
                Libro l = (Libro) p;
                l.imprimirDatosLibro();
            } else if(p instanceof Revista) {
                Revista r = (Revista) p;
                r.imprimirDatosRevista();
            } else if(p instanceof Periodico) {
                Periodico per = (Periodico) p;
                per.imprimirDatosPeriodico();
            }
        }
    }

}
