package edu.emir.khaled.fibonacci_factorial.process;

public class FibonacciCalculator {
    public static int[] calculateSequence(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número de términos no puede ser negativo");
        }

        int[] secuencia = new int[n];

        if (n >= 1) {
            secuencia[0] = 0;
        }
        if (n >= 2) {
            secuencia[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            secuencia[i] = secuencia[i-1] + secuencia[i-2];
        }

        return secuencia;
    }
}