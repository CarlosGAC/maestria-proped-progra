package ejercicio2;

public class ConversorDecimal {
    
    public static String DecimalAOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

    public static String DecimalABinario(int decimal) {
        return Integer.toString(decimal, 2);
    }

    public static String DecimalAHexadecimal(int  decimal) {
        return Integer.toHexString(decimal);
    }
}
