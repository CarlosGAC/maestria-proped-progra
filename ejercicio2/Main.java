package ejercicio2;

import java.util.Scanner;
public class Main {
    private static Scanner entrada;
    public static void main(String[] args) {
        entrada = new Scanner(System.in);

        System.out.println("Ingrese Numero: ");
        int numero = Integer.parseInt(entrada.nextLine());

        System.out.println("\nOctal: " + ConversorDecimal.DecimalAOctal(numero));
        System.out.println("Hexadecimal: " + ConversorDecimal.DecimalAHexadecimal(numero).toUpperCase());
        System.out.println("Binario: " + ConversorDecimal.DecimalABinario(numero));
        
        entrada.close();
    }
}
