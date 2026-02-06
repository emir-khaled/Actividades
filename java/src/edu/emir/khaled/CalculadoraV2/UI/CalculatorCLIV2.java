package src.edu.emir.khaled.CalculadoraV2.UI;

import src.edu.emir.khaled.CalculadoraV2.process.*;
import java.util.Scanner;

/**
 * Interfaz de linea de comandos para la calculadora
 * @author Emir Khaled
 * @version 2.0
 */
public class CalculatorCLIV2 {

    private final Scanner scanner;
    private final Sumas sumas;
    private final Restas restas;
    private final Multiplicaciones multiplicaciones;
    private final Divisiones divisiones;
    private final Modulos modulos;
    private final Potencias potencias;
    private final RaicesCuadradas raicesCuadradas;
    private final Logaritmos logaritmos;

    public CalculatorCLIV2() {
        this.scanner = new Scanner(System.in);
        this.sumas = new Sumas();
        this.restas = new Restas();
        this.multiplicaciones = new Multiplicaciones();
        this.divisiones = new Divisiones();
        this.modulos = new Modulos();
        this.potencias = new Potencias();
        this.raicesCuadradas = new RaicesCuadradas();
        this.logaritmos = new Logaritmos();
    }

    public void runCalculator() {
        boolean running = true;

        while (running) {
            mostrarMenu();
            int opcion = obtenerOpcion();

            if (opcion == -1) continue;

            if (opcion == 9) {
                running = false;
                System.out.println("Calculadora finalizada");
                continue;
            }

            ejecutarOperacion(opcion);
        }

        scanner.close();
    }

    /**
     * Muestra el menu principal
     */
    private void mostrarMenu() {
        System.out.println("\n=== CALCULADORA ARITMETICA ===");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Modulo (Residuo)");
        System.out.println("6. Potencia");
        System.out.println("7. Raiz Cuadrada");
        System.out.println("8. Logaritmo");
        System.out.println("9. Salir");
        System.out.print("Seleccione operacion (1-9): ");
    }

    /**
     * @return opcion seleccionada o -1 si es invalida
     */
    private int obtenerOpcion() {
        if (!scanner.hasNextInt()) {
            System.out.println("Opcion invalida, ingrese un numero del 1 al 9.");
            scanner.next();
            return -1;
        }

        int opcion = scanner.nextInt();

        if (opcion < 1 || opcion > 9) {
            System.out.println("Opcion invalida, ingrese un numero del 1 al 9.");
            return -1;
        }

        return opcion;
    }

    /**
     * @param opcion numero de operacion a ejecutar
     */
    private void ejecutarOperacion(int opcion) {
        try {
            switch (opcion) {
                case 1: performSuma(); break;
                case 2: performResta(); break;
                case 3: performMultiplicacion(); break;
                case 4: performDivision(); break;
                case 5: performModulo(); break;
                case 6: performPotencia(); break;
                case 7: performRaizCuadrada(); break;
                case 8: performLogaritmo(); break;
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void performSuma() {
        double a = solicitarNumero("primer numero");
        double b = solicitarNumero("segundo numero");
        double resultado = sumas.calcular(a, b);
        mostrarResultado(resultado);
    }

    private void performResta() {
        double a = solicitarNumero("minuendo");
        double b = solicitarNumero("segundo numero");
        double resultado = restas.calcular(a, b);
        mostrarResultado(resultado);
    }

    private void performMultiplicacion() {
        double a = solicitarNumero("primer numero");
        double b = solicitarNumero("segundo numero");
        double resultado = multiplicaciones.calcular(a, b);
        mostrarResultado(resultado);
    }

    private void performDivision() {
        double a = solicitarNumero("dividendo");
        double b = solicitarNumero("divisor");
        double resultado = divisiones.calcular(a, b);
        mostrarResultado(resultado);
    }

    private void performModulo() {
        double a = solicitarNumero("dividendo");
        double b = solicitarNumero("divisor");
        double resultado = modulos.calcular(a, b);
        mostrarResultado(resultado);
    }

    private void performPotencia() {
        double a = solicitarNumero("base");
        double b = solicitarNumero("exponente");
        double resultado = potencias.calcular(a, b);
        mostrarResultado(resultado);
    }

    private void performRaizCuadrada() {
        double a = solicitarNumero("numero");
        double resultado = raicesCuadradas.calcular(a);
        mostrarResultado(resultado);
    }

    private void performLogaritmo() {
        double a = solicitarNumero("numero");
        double resultado = logaritmos.calcular(a);
        mostrarResultado(resultado);
    }

    /**
     * @param etiqueta descripcion del numero solicitado
     * @return numero ingresado por el usuario
     */
    private double solicitarNumero(String etiqueta) {
        System.out.print("Ingrese " + etiqueta + ": ");

        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada invalida.");
            System.out.print("Ingrese " + etiqueta + ": ");
            scanner.next();
        }

        return scanner.nextDouble();
    }

    /**
     * @param resultado valor a mostrar
     */
    private void mostrarResultado(double resultado) {
        System.out.println("Resultado: " + resultado);
    }
}