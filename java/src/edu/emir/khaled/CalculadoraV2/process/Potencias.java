package src.edu.emir.khaled.CalculadoraV2.process;

/**
 * Calculo de potencias mediante multiplicaciones sucesivas
 * @author Emir Khaled
 * @version 2.0
 */
public class Potencias {

    private final Multiplicaciones multiplicaciones;
    private final Divisiones divisiones;
    private final Restas restas;

    public Potencias() {
        this.multiplicaciones = new Multiplicaciones();
        this.divisiones = new Divisiones();
        this.restas = new Restas();
    }

    /**
     * @param base numero base
     * @param exponente potencia a elevar
     * @return base^exponente
     */
    public double calcular(double base, double exponente) {
        if (exponente == 0) {
            return 1;
        }

        if (exponente < 0) {
            return calcularPotenciaNegativa(base, exponente);
        }

        return calcularPotenciaPositiva(base, exponente);
    }

    /**
     * @param base número base
     * @param exponente exponente positivo
     * @return base^exponente mediante multiplicaciones
     */
    private double calcularPotenciaPositiva(double base, double exponente) {
        double resultado = 1;

        for (int i = 0; i < exponente; i++) {
            resultado = multiplicaciones.calcular(resultado, base);
        }

        return resultado;
    }

    /**
     * @param base numero base
     * @param exponente exponente negativo
     * @return 1 / base^|exponente|
     */
    private double calcularPotenciaNegativa(double base, double exponente) {
        double exponentePositivo = restas.negar(exponente);
        double potencia = calcularPotenciaPositiva(base, exponentePositivo);
        return divisiones.calcular(1, potencia);
    }
}