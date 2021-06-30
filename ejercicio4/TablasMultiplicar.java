package ejercicio4;

public class TablasMultiplicar {
    public static String calcularTabla(int numero, int rango) {
        String tabla = "";
        if(rango > 0) {
            for(int i = 0; i <= rango; i++) {
                tabla += numero + "x" + i + ": " + (numero*i) + "\n"; 
            }
        } else {
            throw new IllegalArgumentException("El rango debe ser positivo");
        }
        return tabla;
    }
}
