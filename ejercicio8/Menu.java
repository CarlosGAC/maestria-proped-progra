package ejercicio8;

import java.util.Scanner;

public class Menu {
    
    private static Scanner entrada;
    private static final String MENU_STRING = "----------" 
    + "\n1)El Usuario Adivina"
    + "\n2)El Programa Adivina"
    + "\n3)Salir"
    + "\nIngresar opcion: ";

    public static void imprimirMenu() {
        entrada = new Scanner(System.in);

        int opcion;
        do {
            opcion = -1;
            System.out.println(MENU_STRING);
            try {
                opcion = Integer.parseInt(entrada.nextLine());
            }catch(Exception e) {
                System.err.println("El valor ingresado no es un número");
                continue;
            }

            if(opcion == 1) {
                JuegoAdivinacion.usuarioAdivina();
            } else if(opcion == 2) {
                JuegoAdivinacion.programaAdivina();
            } else if(opcion == 3){
                System.out.println("Saliendo...");
            } else {
                System.err.println("La opcion " + opcion + " no existe");
            }

        }while(opcion != 3);
        entrada.close();
    }

}
