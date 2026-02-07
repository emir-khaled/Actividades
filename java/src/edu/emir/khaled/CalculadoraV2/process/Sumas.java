package src.edu.emir.khaled.CalculadoraV2.process;

/**
 * Clase base para operaciones mediante sumas
 * @author Emir Khaled
 * @version 2.0
 */
public class Sumas {

    /**
     * @param a primer operando
     * @param b segundo operando
     * @return a + b
     */
    public double calcular(double a, double b) {
        return a + b;
    }

    /**
     * @param valor numero a acumular
     * @param veces cantidad de repeticiones
     * @return valor × veces
     */
    public double sumaAcumulada(double valor, int veces) {
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
     * @param valores numeros a sumar
     * @return suma total
     */
    public double sumarVariosValores(double... valores) {
        double resultado = 0;
        for (double valor : valores) {
            resultado = calcular(resultado, valor);
        }
        return resultado;
    }

    /**
     * @param valor numero a incrementar
     * @return valor + 1
     */
    public double incrementar(double valor) {
        return calcular(valor, 1);
    }
}


