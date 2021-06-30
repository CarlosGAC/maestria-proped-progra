package ejercicio6;

import java.util.HashMap;

public class Roman {
    
    private static HashMap<Character, Integer> map = new HashMap<>();
    public static final String ROMAN_NUMBER_REGEX = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    

    public static int romanoAEntero(String roman) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int decimal = 0;

        for(int i = 0; i < roman.length(); i++) {
            char caracterActual = roman.charAt(i);
            if(i > 0 && (map.get(caracterActual) > map.get(roman.charAt(i - 1)))) {
                decimal += map.get(caracterActual) - 2 * map.get(roman.charAt(i - 1));
            } else {
                decimal += map.get(caracterActual);
            }
        }

        map.clear();

        return decimal;
    }
}
