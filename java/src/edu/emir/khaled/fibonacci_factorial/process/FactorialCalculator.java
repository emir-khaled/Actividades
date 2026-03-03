package edu.emir.khaled.fibonacci_factorial.process;

public class FactorialCalculator {
    public static long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }

        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}