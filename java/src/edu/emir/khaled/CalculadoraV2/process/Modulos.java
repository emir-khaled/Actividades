package src.edu.emir.khaled.CalculadoraV2.process;

/**
 * Calculo de residuo mediante restas sucesivas
 * @author Emir Khaled
 * @version 2.0
 */
public class Modulos {

    private final Sumas sumas;
    private final Restas restas;

    public Modulos() {
        this.sumas = new Sumas();
        this.restas = new Restas();
    }

    /**
     * @param dividendo numero a dividir
     * @param divisor numero divisor
     * @return residuo de dividendo ÷ divisor
     * @throws ArithmeticException si divisor es cero
     */
    public double calcular(double dividendo, double divisor) {
        validarDivisor(divisor);

        double valorAbsolutoDividendo = obtenerValorAbsoluto(dividendo);
        double valorAbsolutoDivisor = obtenerValorAbsoluto(divisor);

        double residuo = calcularResiduo(valorAbsolutoDividendo, valorAbsolutoDivisor);

        if (dividendo < 0) {
            residuo = restas.negar(residuo);
        }

        return residuo;
    }

    /**
     * @param divisor número divisor a validar
     * @throws ArithmeticException si divisor es cero
     */
    private void validarDivisor(double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Módulo por cero");
        }
    }

    /**
     * @param dividendo dividendo absoluto
     * @param divisor divisor absoluto
     * @return residuo de la división
     */
    private double calcularResiduo(double dividendo, double divisor) {
        double residuo = dividendo;

        while (residuo >= divisor) {
            residuo = restas.calcular(residuo, divisor);
        }

        return residuo;
    }

    /**
     * @param valor numero a evaluar
     * @return valor absoluto
     */
    private double obtenerValorAbsoluto(double valor) {
        return valor < 0 ? restas.negar(valor) : valor;
    }
}
