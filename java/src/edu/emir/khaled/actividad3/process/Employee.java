package edu.emir.khaled.actividad3.process;

import edu.emir.khaled.actividad3.models.EmployeeGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utilidades para operaciones con listas de empleados
 */

public class Employee {

    /**
     * Encuentra el empleado con el mayor salario
     *
     * @param empleados lista de empleados
     * @return empleado con mayor salario o null si la lista esta vacia
     */
    public static EmployeeGenerator empleadoConMayorSalario(List<EmployeeGenerator> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return null;
        }

        EmployeeGenerator maxSalario = empleados.get(0);
        for (EmployeeGenerator emp : empleados) {
            if (emp.getSalario() > maxSalario.getSalario()) {
                maxSalario = emp;
            }
        }
        return maxSalario;
    }

    /**
     * Encuentra la edad mas comun entre los empleados
     *
     * @param empleados lista de empleados
     * @return edad mas frecuente o -1 si la lista esta vacia
     */
    public static int edadMasComun(List<EmployeeGenerator> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return -1;
        }

        Map<Integer, Integer> frecuencias = new HashMap<>();

        // Contar frecuencia de cada edad
        for (EmployeeGenerator emp : empleados) {
            int edad = emp.getEdad();
            frecuencias.put(edad, frecuencias.getOrDefault(edad, 0) + 1);
        }

        // Encontrar la edad con mayor frecuencia
        int edadMasComun = -1;
        int maxFrecuencia = 0;

        for (Map.Entry<Integer, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                edadMasComun = entry.getKey();
            }
        }

        return edadMasComun;
    }

    /**
     * Calcula el promedio de edad de todos los empleados
     *
     * @param empleados lista de empleados
     * @return promedio de edad o 0 si la lista esta vacia
     */
    public static double promedioEdad(List<EmployeeGenerator> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return 0.0;
        }

        int sumaEdades = 0;
        for (EmployeeGenerator emp : empleados) {
            sumaEdades += emp.getEdad();
        }

        return (double) sumaEdades / empleados.size();
    }

    /**
     * Calcula el promedio de salario de todos los empleados
     *
     * @param empleados lista de empleados
     * @return promedio de salario o 0 si la lista esta vacia
     */
    public static double promedioSalario(List<EmployeeGenerator> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return 0.0;
        }

        double sumaSalarios = 0;
        for (EmployeeGenerator emp : empleados) {
            sumaSalarios += emp.getSalario();
        }

        return sumaSalarios / empleados.size();
    }

    /**
     * Calcula el promedio de edad de empleados que ganan mas de 25000
     *
     * @param empleados lista de empleados
     * @return promedio de edad o 0 si no hay empleados que cumplan
     */
    public static double promedioEdadSalarioMayor25K(List<EmployeeGenerator> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return 0.0;
        }

        int sumaEdades = 0;
        int contador = 0;

        for (EmployeeGenerator emp : empleados) {
            if (emp.getSalario() > 25000) {
                sumaEdades += emp.getEdad();
                contador++;
            }
        }

        return contador == 0 ? 0.0 : (double) sumaEdades / contador;
    }

    /**
     * Filtra empleados menores de 25 años
     *
     * @param empleados lista de empleados
     * @return lista con empleados menores de 25 años
     */
    public static List<EmployeeGenerator> filtrarMenoresDe25(List<EmployeeGenerator> empleados) {
        List<EmployeeGenerator> resultado = new ArrayList<>();

        if (empleados == null) {
            return resultado;
        }

        for (EmployeeGenerator emp : empleados) {
            if (emp.getEdad() < 25) {
                resultado.add(emp);
            }
        }

        return resultado;
    }

    /**
     * Cuenta empleados del departamento de sistemas.
     *
     * @param empleados lista de empleados
     * @return cantidad de empleados en sistemas
     */
    public static int contarDepartamentoSistemas(List<EmployeeGenerator> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return 0;
        }

        int contador = 0;
        for (EmployeeGenerator emp : empleados) {
            if ("sistemas".equalsIgnoreCase(emp.getDepartamento())) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Encuentra el empleado con mayor salario entre los mayores de 30 años.
     *
     * @param empleados lista de empleados
     * @return empleado con mayor salario mayor de 30 o null si no existe
     */
    public static EmployeeGenerator mayorSalarioMayorDe30(List<EmployeeGenerator> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return null;
        }

        EmployeeGenerator resultado = null;

        for (EmployeeGenerator emp : empleados) {
            if (emp.getEdad() > 30) {
                if (resultado == null || emp.getSalario() > resultado.getSalario()) {
                    resultado = emp;
                }
            }
        }

        return resultado;
    }

    /**
     * Encuentra el empleado con menor salario cuya edad sea la menos comun.
     *
     * @param empleados lista de empleados
     * @return empleado que cumple las condiciones o null si lista vacia
     */
    public static EmployeeGenerator menorSalarioEdadMenosComun(List<EmployeeGenerator> empleados) {
        if (empleados == null || empleados.isEmpty()) {
            return null;
        }

        // Calcular frecuencias de edades
        Map<Integer, Integer> frecuencias = new HashMap<>();
        for (EmployeeGenerator emp : empleados) {
            int edad = emp.getEdad();
            frecuencias.put(edad, frecuencias.getOrDefault(edad, 0) + 1);
        }

        // Encontrar la frecuencia minima
        int frecuenciaMinima = Integer.MAX_VALUE;
        for (int frec : frecuencias.values()) {
            if (frec < frecuenciaMinima) {
                frecuenciaMinima = frec;
            }
        }

        // Filtrar empleados con edad menos comun
        List<EmployeeGenerator> empleadosEdadMenosComun = new ArrayList<>();
        for (EmployeeGenerator emp : empleados) {
            if (frecuencias.get(emp.getEdad()) == frecuenciaMinima) {
                empleadosEdadMenosComun.add(emp);
            }
        }

        // Encontrar el de menor salario entre ellos
        EmployeeGenerator resultado = empleadosEdadMenosComun.get(0);
        for (EmployeeGenerator emp : empleadosEdadMenosComun) {
            if (emp.getSalario() < resultado.getSalario()) {
                resultado = emp;
            }
        }

        return resultado;
    }
}
