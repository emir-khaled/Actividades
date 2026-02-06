package src.edu.emir.khaled.CalculadoraV2.process;

/**
 * Clase para multiplicacion mediante sumas y restas.
 * @author Emir Khaled
 * @version 2.0
 */

public class Multiplicaciones {

    private final Sumas sumas;
    private final Restas restas;

    public Multiplicaciones() {
        this.sumas = new Sumas();
        this.restas = new Restas();
    }

    /**
     * @param a primer factor
     * @param b segundo factor
     * @return a × b
     */
    public double calcular(double a, double b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        double valorAbsolutoA = obtenerValorAbsoluto(a);
        double valorAbsolutoB = obtenerValorAbsoluto(b);

        double resultado = sumas.sumaAcumulada(valorAbsolutoA, (int) valorAbsolutoB);

        if (tieneSignoNegativo(a, b)) {
            resultado = restas.negar(resultado);
        }

        return resultado;
    }

    /**
     * @param valor numero a evaluar
     * @return valor absoluto
     */
    private double obtenerValorAbsoluto(double valor) {
        return valor < 0 ? restas.negar(valor) : valor;
    }

    /**
     * @param a primer numero
     * @param b segundo numero
     * @return true si el resultado debe ser negativo
     */
    private boolean tieneSignoNegativo(double a, double b) {
        return (a < 0 && b > 0) || (a > 0 && b < 0);
    }
}


