package src.edu.emir.khaled.CalculadoraV2.process;

/**
 * Clase base para operaciones mediante restas
 * @author Emir Khaled
 * @version 2.0
 */

public class Restas {

    /**
     * @param a minuendo
     * @param b sustraendo
     * @return a - b
     */
    public double calcular(double a, double b) {
        return a - b;
    }

    /**
     * @param valor numero a acumular
     * @param veces cantidad de repeticiones
     * @return valor restado veces veces desde cero
     */
    public double restaAcumulada(double valor, int veces) {
        if (veces < 0) {
            throw new IllegalArgumentException("Las repeticiones no pueden ser negativas");
        }

        double resultado = 0;
        for (int i = 0; i < veces; i++) {
            resultado = calcular(resultado, valor);
        }
        return resultado;
    }

    /**
     * @param valor numero a negar
     * @return -valor
     */
    public double negar(double valor) {
        return calcular(0, valor);
    }

    /**
     * @param valor numero a decrementar
     * @return valor - 1
     */
    public double decrementar(double valor) {
        return calcular(valor, 1);
    }

    /**
     * @param a primer numero
     * @param b segundo numero
     * @return valor absoluto de a - b
     */
    public double diferencia(double a, double b) {
        double resultado = calcular(a, b);
        return resultado < 0 ? negar(resultado) : resultado;
    }
}