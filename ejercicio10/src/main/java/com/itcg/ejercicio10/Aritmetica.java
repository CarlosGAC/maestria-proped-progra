package com.itcg.ejercicio10;

public class Aritmetica {
    
    public static double suma(double n1, double n2) {
        return n1 + n2;
    }
    
    public static double resta(double n1, double n2) {
        return n1 - n2;
    }
    
    public static double multiplicacion(double n1, double n2) {
        return n1 * n2;
    }
    
    public static double division(double n1, double n2){
        if(n2 == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return n1 / n2;
    }
    
}
