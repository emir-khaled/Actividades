package edu.emir.khaled.actividad2.process;
// Clase para realizar multiplicación usando solo sumas y restas

public class Multiplicacion {
    public double calcular(double a, double b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        double resultado = 0;
        double multiplicador = Math.abs(b);

        for (int i = 0; i < multiplicador; i++) {
            resultado += Math.abs(a);
        }

        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            resultado = -resultado;
        }

        return resultado;
    }
}
