package src.edu.emir.khaled.CalculadoraV2.process;

/**
 * Cálculo de raiz cuadrada mediante metodo de Newton-Raphson
 * @author Emir Khaled
 * @version 2.0
 */
public class RaicesCuadradas {

    private final Sumas sumas;
    private final Restas restas;
    private final Divisiones divisiones;
    private final Multiplicaciones multiplicaciones;

    private static final double PRECISION = 0.000001;

    public RaicesCuadradas() {
        this.sumas = new Sumas();
        this.restas = new Restas();
        this.divisiones = new Divisiones();
        this.multiplicaciones = new Multiplicaciones();
    }

    /**
     * @param numero número a calcular raiz cuadrada
     * @return √numero
     * @throws ArithmeticException si numero < 0
     */
    public double calcular(double numero) {
        validarArgumento(numero);

        if (numero == 0 || numero == 1) {
            return numero;
        }

        double estimacion = divisiones.calcular(numero, 2);
        double diferencia = 1;

        while (diferencia > PRECISION) {
            double nuevaEstimacion = calcularNuevaEstimacion(numero, estimacion);
            diferencia = restas.diferencia(nuevaEstimacion, estimacion);
            estimacion = nuevaEstimacion;
        }

        return estimacion;
    }

    /**
     * @param numero argumento a validar
     * @throws ArithmeticException si numero < 0
     */
    private void validarArgumento(double numero) {
        if (numero < 0) {
            throw new ArithmeticException("Raíz cuadrada de número negativo");
        }
    }

    /**
     * @param numero valor original
     * @param estimacionActual aproximacion actual
     * @return nueva estimacion mediante metodo de Newton
     */
    private double calcularNuevaEstimacion(double numero, double estimacionActual) {
        double cociente = divisiones.calcular(numero, estimacionActual);
        double suma = sumas.calcular(estimacionActual, cociente);
        return divisiones.calcular(suma, 2);
    }
}