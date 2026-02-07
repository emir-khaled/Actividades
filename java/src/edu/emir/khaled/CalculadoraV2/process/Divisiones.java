package src.edu.emir.khaled.CalculadoraV2.process;

/**
 * División entera mediante restas sucesivas
 * @author Emir Khaled
 * @version 2.0
 */

public class Divisiones {

    private final Sumas sumas;
    private final Restas restas;

    public Divisiones() {
        this.sumas = new Sumas();
        this.restas = new Restas();
    }

    /**
     * @param dividendo número a dividir
     * @param divisor número divisor
     * @return cociente entero de dividendo ÷ divisor
     * @throws ArithmeticException si divisor es cero
     */
    public double calcular(double dividendo, double divisor) {
        validarDivisor(divisor);

        double valorAbsolutoDividendo = obtenerValorAbsoluto(dividendo);
        double valorAbsolutoDivisor = obtenerValorAbsoluto(divisor);

        double cociente = contarDivisiones(valorAbsolutoDividendo, valorAbsolutoDivisor);

        if (tieneSignoNegativo(dividendo, divisor)) {
            cociente = restas.negar(cociente);
        }

        return cociente;
    }

    /**
     * @param a número a dividir
     * @return a ÷ 2
     */
    public double mitad(double a) {
        return calcular(a, 2);
    }

    /**
     * @param divisor número divisor a validar
     * @throws ArithmeticException si divisor es cero
     */
    private void validarDivisor(double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("División por cero");
        }
    }

    /**
     * @param dividendo dividendo absoluto
     * @param divisor divisor absoluto
     * @return cantidad de veces que cabe divisor en dividendo
     */
    private double contarDivisiones(double dividendo, double divisor) {
        double cociente = 0;
        double acumulado = 0;

        while (sumas.calcular(acumulado, divisor) <= dividendo) {
            acumulado = sumas.calcular(acumulado, divisor);
            cociente = sumas.incrementar(cociente);
        }

        return cociente;
    }

    /**
     * @param valor número a evaluar
     * @return valor absoluto
     */
    private double obtenerValorAbsoluto(double valor) {
        return valor < 0 ? restas.negar(valor) : valor;
    }

    /**
     * @param a primer número
     * @param b segundo número
     * @return true si el resultado debe ser negativo
     */
    private boolean tieneSignoNegativo(double a, double b) {
        return (a < 0 && b > 0) || (a > 0 && b < 0);
    }
}
