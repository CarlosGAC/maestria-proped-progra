package ejercicio7;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class UtilidadesTexto {

    private static final String VOWEL_REGEX = "[aeiou]";
    private static final String CONSONANT_REGEX = "[bcdefghijklmnpqrstvwxyz]";
    private static final String DIGIT_REGEX = "[\\d]";

    public static void describirString(String s) {
        System.out.println("Vocales: " + calcularCantidadVocales(s));
        System.out.println("Consonantes: " + calcularCantidadConsonantes(s));
        System.out.println("Digitos: " + calcularCantidadDigitos(s));
    }

    private static int iterarMatcher(String s, String regex) {
        int contadorMatches = 0;
        Matcher matcher = Pattern.compile(regex).matcher(s);
        while(matcher.find()) {
            contadorMatches += 1;
        }
        return contadorMatches;
    }

    private static int calcularCantidadVocales(String s) {
        return iterarMatcher(s, VOWEL_REGEX);
    }

    private static int calcularCantidadConsonantes(String s) {
        return iterarMatcher(s, CONSONANT_REGEX);
    }

    private static int calcularCantidadDigitos(String s) {
        return iterarMatcher(s, DIGIT_REGEX);
    }

}
