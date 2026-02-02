package edu.emir.khaled.actividad3.process;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilidades para operaciones con listas de numeros enteros
 */

public class ListNumbers {

    /**
     * Mueve todos los ceros al final de la lista
     *
     * @param numeros lista de enteros a procesar
     * @return nueva lista con ceros al final
     */

    public static List<Integer> moverCerosAlFinal(List<Integer> numeros) {
        List<Integer> resultado = new ArrayList<>();
        int contadorCeros = 0;

        // Agregar elementos no cero en orden
        for (int num : numeros) {
            if (num == 0) {
                contadorCeros++;
            } else {
                resultado.add(num);
            }
        }

        // Agregar los ceros al final
        for (int i = 0; i < contadorCeros; i++) {
            resultado.add(0);
        }

        return resultado;
    }

    /**
     * Cuenta la cantidad de numeros pares en la lista
     *
     * @param numeros lista de enteros a analizar
     * @return cantidad de numeros pares encontrados
     */

    public static int contarPares(List<Integer> numeros) {
        int contador = 0;

        for (int num : numeros) {
            if (num % 2 == 0) {
                contador++;
            }
        }

        return contador;
    }
}

