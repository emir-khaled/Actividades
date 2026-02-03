package edu.emir.khaled.actividad2.UI;

import edu.emir.khaled.actividad2.process.*;
import java.util.Scanner;

public class CalculatorCLI {
    private Scanner scanner;

    public CalculatorCLI() {
        scanner = new Scanner(System.in);
    }

    public void runCalculator() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== CALCULADORA ARITMÉTICA ===");
            System.out.println("NOTA: Trabaja solo con números positivos");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Módulo (Residuo)");
            System.out.println("6. Potencia");
            System.out.println("7. Raíz Cuadrada");
            System.out.println("8. Logaritmo");
            System.out.println("9. Salir");
            System.out.print("Seleccione operación (1-9): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Opción inválida, solo puede escoger una permitida (1-9)");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            if (choice < 1 || choice > 9) {
                System.out.println("Opción inválida, solo puede escoger una permitida (1-9)");
                continue;
            }

            switch (choice) {
                case 1:
                    performSuma();
                    break;
                case 2:
                    performResta();
                    break;
                case 3:
                    performMultiplicacion();
                    break;
                case 4:
                    performDivision();
                    break;
                case 5:
                    performModulo();
                    break;
                case 6:
                    performPotencia();
                    break;
                case 7:
                    performRaizCuadrada();
                    break;
                case 8:
                    performLogaritmo();
                    break;
                case 9:
                    running = false;
                    System.out.println("Calculadora finalizada.");
                    break;
            }
        }

        scanner.close();
    }

    private void performSuma() {
        System.out.print("Ingrese primer número (positivo): ");
        double a = obtenerNumeroPositivo();
        if (a < 0) return;

        System.out.print("Ingrese segundo número (positivo): ");
        double b = obtenerNumeroPositivo();
        if (b < 0) return;

        Suma suma = new Suma();
        double resultado = suma.calcular(a, b);
        System.out.println("Resultado: " + resultado);
    }

    private void performResta() {
        System.out.print("Ingrese minuendo (positivo): ");
        double a = obtenerNumeroPositivo();
        if (a < 0) return;

        System.out.print("Ingrese sustraendo (positivo): ");
        double b = obtenerNumeroPositivo();
        if (b < 0) return;

        Resta resta = new Resta();
        double resultado = resta.calcular(a, b);
        System.out.println("Resultado: " + resultado);
    }

    private void performMultiplicacion() {
        System.out.print("Ingrese primer número (positivo): ");
        double a = obtenerNumeroPositivo();
        if (a < 0) return;

        System.out.print("Ingrese segundo número (positivo): ");
        double b = obtenerNumeroPositivo();
        if (b < 0) return;

        Multiplicacion multi = new Multiplicacion();
        double resultado = multi.calcular(a, b);
        System.out.println("Resultado: " + resultado);
    }

    private void performDivision() {
        System.out.print("Ingrese dividendo (positivo): ");
        double a = obtenerNumeroPositivo();
        if (a < 0) return;

        System.out.print("Ingrese divisor (positivo, diferente de cero): ");
        double b = obtenerNumeroPositivo();
        if (b < 0) return;

        if (b == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
            return;
        }

        Division division = new Division();
        double resultado = division.calcular(a, b);
        System.out.println("Resultado: " + resultado);
    }

    private void performModulo() {
        System.out.print("Ingrese dividendo (positivo): ");
        double a = obtenerNumeroPositivo();
        if (a < 0) return;

        System.out.print("Ingrese divisor (positivo, diferente de cero): ");
        double b = obtenerNumeroPositivo();
        if (b < 0) return;

        if (b == 0) {
            System.out.println("Error: No se puede calcular módulo con divisor cero.");
            return;
        }

        Modulo modulo = new Modulo();
        double resultado = modulo.calcular(a, b);
        System.out.println("Resultado: " + resultado);
    }

    private void performPotencia() {
        System.out.print("Ingrese base (positivo): ");
        double a = obtenerNumeroPositivo();
        if (a < 0) return;

        System.out.print("Ingrese exponente (positivo): ");
        double b = obtenerNumeroPositivo();
        if (b < 0) return;

        Potencia potencia = new Potencia();
        double resultado = potencia.calcular(a, b);
        System.out.println("Resultado: " + resultado);
    }

    private void performRaizCuadrada() {
        System.out.print("Ingrese número (positivo): ");
        double a = obtenerNumeroPositivo();
        if (a < 0) return;

        RaizCuadrada raiz = new RaizCuadrada();
        double resultado = raiz.calcular(a);
        System.out.println("Resultado: " + resultado);
    }

    private void performLogaritmo() {
        System.out.print("Ingrese número (positivo mayor que cero): ");
        double a = obtenerNumeroPositivo();
        if (a < 0) return;

        if (a == 0) {
            System.out.println("Error: El logaritmo no está definido para cero.");
            return;
        }

        Logaritmo log = new Logaritmo();
        double resultado = log.calcular(a);
        System.out.println("Resultado: " + resultado);
    }

    private double obtenerNumeroPositivo() {
        while (true) {
            if (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida. Ingrese un número positivo: ");
                scanner.next();
                continue;
            }

            double numero = scanner.nextDouble();

            if (numero < 0) {
                System.out.println("Error: Solo se permiten números positivos.");
                System.out.print("Ingrese un número positivo: ");
                continue;
            }

            return numero;
        }
    }
}
