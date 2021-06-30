package ejercicio9;

import java.util.Scanner;
public class Main {
      
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        

        String cadena1 = "";
        String cadena2 = "";

        System.out.println("Ingrese cadena 1: ");
        cadena1 = entrada.nextLine();

        System.out.println("Ingrese cadena 2: ");
        cadena2 = entrada.nextLine();

        if(Anagrama.esAnagrama(cadena1, cadena2)) {
            System.out.println("Las cadenas son anagramas");
        } else {
            System.out.println("Las cadenas no son anagramas");
        }

        entrada.close();
    }


}
