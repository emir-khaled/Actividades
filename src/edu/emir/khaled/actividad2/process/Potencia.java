package edu.emir.khaled.actividad2.process;
// Clase para calcular potencias

public class Potencia {
    public double calcular(double base, double exponente) {
    if (exponente == 0) {
        return 1;
    }

    if (exponente < 0) {
        return 1 / calcular(base, -exponente);
    }

    double resultado = 1;
    Multiplicacion multiplicacion = new Multiplicacion();

    for (int i = 0; i < exponente; i++) {
        resultado = multiplicacion.calcular(resultado, base);
    }

    return resultado;
}
}
