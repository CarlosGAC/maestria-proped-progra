package ejercicio5;

import java.math.BigInteger;

public class NumerosPrimos {
    
    public static boolean esPrimo(long numero) {
        BigInteger b = new BigInteger(String.valueOf(numero));

        return b.isProbablePrime(1);
    }

    public static void iterarArreglo(long[] arreglo) {
        for(long numero : arreglo) {
            if(esPrimo(numero))  {
                System.out.println("El número " + numero + " es primo");
            } else {
                System.out.println("El número " + numero + " no es primo");
            }
        }
    }
}
