package ejercicio6;

import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        String numeroRomano;
        boolean numeroCorrecto = false;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("Ingrese el numero: ");
            numeroRomano = entrada.nextLine().toUpperCase();

            if(numeroRomano.matches(Roman.ROMAN_NUMBER_REGEX) && numeroRomano.length() <= 10) {
                numeroCorrecto = true;
            } else {
                System.err.println("Error: El valor ingresado no tiene el formato de numero romano");
            }
        } while(!numeroCorrecto);

        System.out.println(Roman.romanoAEntero(numeroRomano));
        entrada.close();
    }
}
