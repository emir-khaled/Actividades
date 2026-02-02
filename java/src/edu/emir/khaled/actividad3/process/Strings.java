package edu.emir.khaled.actividad3.process;

/**
 * Utilidades para operaciones con cadenas de texto
 */

public class Strings {

    /**
     * Verifica si una cadena es un palindromo comparando caracteres
     * desde los extremos hacia el centro
     *
     * @param texto cadena a verificar
     * @return true si es palindromo, false en caso contrario
     */
    public static boolean esPalindromo(String texto) {
        if (texto == null || texto.isEmpty()) {
            return true;
        }

        String textoLimpio = texto.toLowerCase().replaceAll("\\s+", "");
        int izquierda = 0;
        int derecha = textoLimpio.length() - 1;

        while (izquierda < derecha) {
            if (textoLimpio.charAt(izquierda) != textoLimpio.charAt(derecha)) {
                return false;
            }
            izquierda++;
            derecha--;
        }

        return true;
    }

    /**
     * Cuenta el numero de vocales en una cadena, considerando
     * mayusculas, minusculas y vocales acentuadas
     *
     * @param texto cadena a analizar
     * @return cantidad de vocales encontradas
     */
    public static int contarVocales(String texto) {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }

        int contador = 0;
        String textoMinusculas = texto.toLowerCase();

        for (int i = 0; i < textoMinusculas.length(); i++) {
            char c = textoMinusculas.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' || c == 'ü') {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Invierte una cadena de texto recorriendo desde el final
     * hacia el inicio
     *
     * @param texto cadena a invertir
     * @return cadena invertida
     */
    public static String invertir(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }

        StringBuilder resultado = new StringBuilder();

        for (int i = texto.length() - 1; i >= 0; i--) {
            resultado.append(texto.charAt(i));
        }

        return resultado.toString();
    }

    /**
     * Busca la primera aparicion de un caracter en una cadena
     *
     * @param texto cadena donde buscar
     * @param caracter caracter a buscar
     * @return indice de la primera aparicion o -1 si no se encuentra
     */
    public static int primeraUbicacion(String texto, char caracter) {
        if (texto == null || texto.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == caracter) {
                return i;
            }
        }

        return -1;
    }
}
