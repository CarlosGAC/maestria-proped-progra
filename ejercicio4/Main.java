package ejercicio4;

import java.util.Scanner;
public class Main {
    private static Scanner entrada;
    public static void main(String[] args) {
        entrada = new Scanner(System.in);

        System.out.println("Ingrese Numero: ");
        int numero = Integer.parseInt(entrada.nextLine());

        System.out.println("Ingrese Rango: ");
        int rango = Integer.parseInt(entrada.nextLine());

        try {
            System.out.println(TablasMultiplicar.calcularTabla(numero, rango));
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        entrada.close();
    }
}
