package ejercicio1;

import java.util.Scanner;
public class Menu {

    private static final String MENU_STRING = "\n----------"
    + "\nBienvenido, seleccione una opcion"
    + "\n1)Dar de Alta Empleado"
    + "\n2)Salir";

    private static Scanner entrada;

    public static void imprimirMenu() {
        entrada = new Scanner(System.in);

        int opcion;
        do{
            opcion = -1;
            System.out.println(MENU_STRING);
            try {
                opcion = Integer.parseInt(entrada.nextLine());
            }catch(NumberFormatException e) {
                System.err.println("El valor ingresado no es un número");
                continue;
            }

            if(opcion == 1) {
                try {
                    imprimirInformacionEmpleado(altaEmpleado(), ingresarSalario());
                }catch(Exception e) {
                    System.err.println("\n" + e.getMessage());
                    System.err.println("ERROR: Favor de ingresar de nuevo los datos");
                }
            } else if(opcion == 2) {
                System.out.println("Saliendo...");
            } else {
                System.err.println("La opcion " + opcion + " no existe");
            }

        }while(opcion != 2);

        
    }


    private static Empleado altaEmpleado() {
        long numeroEmpleado = 0L;
        String nombre;
        String direccion;
        float salarioHora = 0F;
        
        System.out.println("Ingrese el Numero de Empleado: ");
        try {
            numeroEmpleado = Long.parseLong(entrada.nextLine());
        }catch(NumberFormatException e) {
            System.err.println("El valor ingresado no es un número entero");
        }

        System.out.println("Ingrese el Nombre del Empleado: ");
        nombre = entrada.nextLine();

        System.out.println("Ingrese la Direccion del Empleado: ");
        direccion = entrada.nextLine();

        System.out.println("Ingrese el Salario por Hora: ");
        try {
            salarioHora = Float.parseFloat(entrada.nextLine());
        }catch(NumberFormatException e) {
            System.err.println("El valor ingresado no es un número flotante");
        }

        return new Empleado(numeroEmpleado, nombre, direccion, salarioHora);
    }


    private static void imprimirInformacionEmpleado(Empleado e, int horasTrabajadas) {
        System.out.println(e.GetDatosEmpleado());
        System.out.println("Horas Trabajadas: \t" + horasTrabajadas);
        System.out.println("Salario Final: \t" + e.calcularSalario(horasTrabajadas));
    }


    public static int ingresarSalario() {

        int horasTrabajadas = 0;

        System.out.println("Ingrese la cantidad de horas trabajadas: ");
        try {
            horasTrabajadas = Integer.parseInt(entrada.nextLine());
        }catch(NumberFormatException e) {
            System.err.println("El valor ingresado no es un número entero");
        }

        return horasTrabajadas;
    }
}
