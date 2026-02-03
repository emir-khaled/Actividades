package edu.emir.khaled.actividad2.process;
// Clase para calcular logaritmo natural usando la serie de Taylor con solo sumas y restas

public class Logaritmo {
    public double calcular(double x) {
        if (x <= 0) {
            throw new ArithmeticException("Logaritmo de número no positivo");
        }

        if (x == 1) {
            return 0;
        }

        if (x > 1) {
            return calcularExpansion(x - 1);
        }

        return -calcularExpansion(1/x - 1);
    }

    private double calcularExpansion(double z) {
        double resultado = 0;
        Potencia potencia = new Potencia();
        Division division = new Division();

        for (int n = 1; n <= 100; n++) {
            double termino = division.calcular(potencia.calcular(z, n), n);
            if (n % 2 == 0) {
                resultado -= termino;
            } else {
                resultado += termino;
            }
        }

        return resultado;
    }

}
