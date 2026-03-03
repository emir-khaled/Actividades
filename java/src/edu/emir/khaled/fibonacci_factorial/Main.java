package edu.emir.khaled.fibonacci_factorial;
import edu.emir.khaled.fibonacci_factorial.process.FactorialCalculator;
import edu.emir.khaled.fibonacci_factorial.process.FibonacciCalculator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- cálculo de factorial y fibonacci ---");

        try {
            // Pedir el número al usuario
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("ingresa un número (n): ");
            String input = reader.readLine();
            int n = Integer.parseInt(input);

            System.out.println();

            // Calcular factorial usando la clase FactorialCalculator
            long factorial = FactorialCalculator.calculate(n);
            System.out.println("[factorial]");
            System.out.println("el factorial de " + n + " es: " + factorial);

            System.out.println();

            // Calcular y mostrar serie Fibonacci usando la clase FibonacciCalculator
            System.out.println("[fibonacci]");
            System.out.print("la serie de " + n + " términos: ");

            int[] fibonacci = FibonacciCalculator.calculateSequence(n);
            for (int i = 0; i < fibonacci.length; i++) {
                System.out.print(fibonacci[i]);
                if (i < fibonacci.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Debes ingresar un número entero válido.");
        }

        System.out.println("\nProcess finished with exit code 0");
    }
}