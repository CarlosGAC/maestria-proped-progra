package ejercicio7;

import java.util.Scanner;

public class Main {

    private static Scanner entrada;
    public static void main(String[] args) {
        entrada = new Scanner(System.in);

        System.out.println("Ingresar cadena a analizar: ");
        UtilidadesTexto.describirString(entrada.nextLine().toLowerCase());

        entrada.close();
    }
}
