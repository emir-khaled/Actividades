package edu.emir.khaled.actividad2.process;
// Clase para calcular raíz cuadrada usando el método de babilonia con solo sumas y restas

public class RaizCuadrada {
    public double calcular(double numero) {
        if (numero < 0) {
            throw new ArithmeticException("Raíz cuadrada de número negativo");
        }

        if (numero == 0 || numero == 1) {
            return numero;
        }

        double estimacion = numero / 2;
        double precision = 0.000001;
        double diferencia = 1;

        Multiplicacion multi = new Multiplicacion();
        Division div = new Division();

        while (diferencia > precision) {
            double nuevaEstimacion = div.calcular(estimacion + div.calcular(numero, estimacion), 2);
            diferencia = Math.abs(nuevaEstimacion - estimacion);
            estimacion = nuevaEstimacion;
        }

        return estimacion;
    }
}
