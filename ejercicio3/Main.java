package ejercicio3;

import java.util.Scanner;
public class Main {
    private static Scanner entrada;
    private static String esPerfecto = "El numero es perfecto";
    private static String noEsPerfecto = "El numero no es perfecto";
    public static void main(String[] args) {
        entrada = new Scanner(System.in);

        System.out.println("Ingrese Numero: ");
        int numero = Integer.parseInt(entrada.nextLine());

        if(esPerfecto(numero)) {
            System.out.println(esPerfecto);
        } else {
            System.out.println(noEsPerfecto);
        }
    }  
    
    public static boolean esPerfecto(int numero) {
        int sumaDivisores = 0;
        for(int i = 1; i < numero; i++) {
            if(numero % i == 0) {
                sumaDivisores += i;
                System.out.println("Divisor: " + i);
            }
        }
        return sumaDivisores == numero;
    }
}
