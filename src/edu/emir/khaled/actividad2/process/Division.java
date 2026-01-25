package edu.emir.khaled.actividad2.process;
// Clase para realizar división usando solo sumas y restas

public class Division {
    public double calcular(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("División por cero");
        }

        boolean negativo = (dividendo < 0 && divisor > 0) || (dividendo > 0 && divisor < 0);
        double a = Math.abs(dividendo);
        double b = Math.abs(divisor);

        double cociente = 0;
        double acumulado = 0;

        while (acumulado + b <= a) {
            acumulado += b;
            cociente++;
        }

        double residuo = a - acumulado;

        if (residuo > 0) {
            double fraccion = 0;
            double precision = 0.1;

            for (int i = 0; i < 6; i++) {
                double tempResiduo = residuo * 10;
                double tempDivisor = b;

                int contador = 0;
                while (tempResiduo >= tempDivisor) {
                    tempResiduo -= tempDivisor;
                    contador++;
                }

                fraccion += contador * precision;
                precision *= 0.1;
                residuo = tempResiduo;
            }

            cociente += fraccion;
        }

        if (negativo) {
            cociente = -cociente;
        }

        return cociente;
    }
}
