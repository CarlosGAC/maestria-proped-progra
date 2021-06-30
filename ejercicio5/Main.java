package ejercicio5;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        long[] numeros = new long[10];

        ingresarArreglo(numeros);

        NumerosPrimos.iterarArreglo(numeros);
    }

    private static void ingresarArreglo(long[] arreglo) {
        Scanner entrada = new Scanner(System.in);
        for(int i = 0; i < arreglo.length; i++) {
            System.out.println("Posicion [" + i + "]: ");
            try {
                long tempInput = Long.parseLong(entrada.nextLine());
                arreglo[i] = tempInput;
            } catch(NumberFormatException e) {
                System.out.println("Error: El valor ingresado no es un numero entero");
                i--;
            }
        }
        entrada.close();
    }
}
