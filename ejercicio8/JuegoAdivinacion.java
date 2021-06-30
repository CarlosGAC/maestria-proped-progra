package ejercicio8;

import java.util.Scanner;

public class JuegoAdivinacion {
    
    private static Scanner entrada;

    public static void usuarioAdivina() {

        entrada = new Scanner(System.in);
        
        System.out.println("-----El Usuario Adivina-----");

        int num = numeroAzar();
        System.out.println(num);
        
        boolean answerCorrect = false;
        int answer = 0;

        while(!answerCorrect) {
            System.out.println("Ingrese numero: ");
            try {
                
                answer = Integer.parseInt(entrada.nextLine());
                if(answer == num) {
                    answerCorrect = true;
                    System.out.println("Felicidades! Respuesta correcta!");
                } else if(answer > num) {
                    System.out.println("El numero es menor que tu respuesta");
                } else {
                    System.out.println("El numero es mayor que tu respuesta");
                }

            }catch(NumberFormatException e) {
                System.err.println("El valor ingresado no es un numero entero");
            }
        }
    }

    private static int numeroAzar() {
        return (int)(Math.random() * 100 + 1);
    }

    public static void programaAdivina() {
        
        entrada = new Scanner(System.in);
        
        System.out.println("-----El Programa Adivina-----");

        int num = 0;
        boolean correctNumber = false;
        do {
            System.out.println("Ingrese el numero que el programa quiere adivinar: ");
            try {
                num = Integer.parseInt(entrada.nextLine());
            }catch(NumberFormatException e) {
                System.err.println("Error: El valor ingresado no es un numero entero");
                continue;
            }

            if(num > 0 && num <= 100) {
                correctNumber = true;
            }
        }while(!correctNumber);

        System.out.println(num);

        boolean answerCorrect = false;
        int answer = 50;

        int limiteInferior = 0;
        int limiteSuperior = 100;

        char inputUsuario;

        while(!answerCorrect) {
            answer = (limiteInferior + limiteSuperior) / 2;
            System.out.println("Respuesta del programa: " + answer);
            if(answer == num) {
                System.out.println("La respuesta es correcta!");
                answerCorrect = true;
            } else {
                System.out.println("Ingrese si su numero es mayor(>) o menor(<): ");
                inputUsuario = entrada.nextLine().charAt(0);

                if(inputUsuario == '>') {
                    limiteInferior = answer;
                } else if(inputUsuario == '<') {
                    limiteSuperior = answer;
                } else {
                    System.err.println("El caracter ingresado no es correcto");
                }
            }
        }
    }
}
