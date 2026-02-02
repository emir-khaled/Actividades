package edu.emir.khaled.actividad2.process;
// Clase para calcular el residuo de la división usando solo sumas y restas

public class Modulo {
    public double calcular(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Módulo por cero");
        }

        double a = Math.abs(dividendo);
        double b = Math.abs(divisor);

        while (a >= b) {
            a -= b;
        }

        if (dividendo < 0) {
            a = -a;
        }

        return a;
    }
}
