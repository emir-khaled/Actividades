package src.edu.emir.khaled.CalculadoraV2.process;

/**
 * Calculo de logaritmo natural mediante serie de Taylor
 * @author Emir Khaled
 * @version 2.0
 */
public class Logaritmos {

    private final Sumas sumas;
    private final Restas restas;
    private final Divisiones divisiones;
    private final Potencias potencias;
    private final Modulos modulos;

    public Logaritmos() {
        this.sumas = new Sumas();
        this.restas = new Restas();
        this.divisiones = new Divisiones();
        this.potencias = new Potencias();
        this.modulos = new Modulos();
    }

    /**
     * @param x número a calcular logaritmo
     * @return ln(x)
     * @throws ArithmeticException si x <= 0
     */
    public double calcular(double x) {
        validarArgumento(x);

        if (x == 1) {
            return 0;
        }

        if (x > 1) {
            double z = restas.calcular(x, 1);
            return calcularExpansion(z);
        }

        double inverso = divisiones.calcular(1, x);
        double z = restas.calcular(inverso, 1);
        return restas.negar(calcularExpansion(z));
    }

    /**
     * @param x argumento a validar
     * @throws ArithmeticException si x <= 0
     */
    private void validarArgumento(double x) {
        if (x <= 0) {
            throw new ArithmeticException("Logaritmo de número no positivo");
        }
    }

    /**
     * @param z argumento de la serie de Taylor
     * @return ln(1 + z) mediante expansión
     */
    private double calcularExpansion(double z) {
        double resultado = 0;

        for (int n = 1; n <= 100; n++) {
            double termino = calcularTermino(z, n);

            if (esPar(n)) {
                resultado = restas.calcular(resultado, termino);
            } else {
                resultado = sumas.calcular(resultado, termino);
            }
        }

        return resultado;
    }

    /**
     * @param z base de la potencia
     * @param n indice del término
     * @return z^n / n
     */
    private double calcularTermino(double z, int n) {
        double potencia = potencias.calcular(z, n);
        return divisiones.calcular(potencia, n);
    }

    /**
     * @param n numero a evaluar
     * @return true si n es par
     */
    private boolean esPar(int n) {
        return modulos.calcular(n, 2) == 0;
    }
}
