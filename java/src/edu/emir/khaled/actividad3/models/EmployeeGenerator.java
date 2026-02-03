package edu.emir.khaled.actividad3.models;

import java.util.Objects;

/**
 * Representa un empleado con sus atributos basicos
 * Esta clase es inmutable para garantizar la integridad de los datos
 */

public class EmployeeGenerator {
    private final String nombre;
    private final int edad;
    private final double salario;
    private final String departamento;

    /**
     * Crea un nuevo empleado con los atributos especificados
     *
     * @param nombre nombre del empleado
     * @param edad edad del empleado en años
     * @param salario salario mensual del empleado
     * @param departamento departamento al que pertenece
     */
    public EmployeeGenerator(String nombre, int edad, double salario, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeGenerator that = (EmployeeGenerator) o;
        return edad == that.edad &&
                Double.compare(that.salario, salario) == 0 &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(departamento, that.departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, salario, departamento);
    }

    @Override
    public String toString() {
        return String.format("EmployeeGenerator{nombre='%s', edad=%d, salario=%.2f, departamento='%s'}",
                nombre, edad, salario, departamento);
    }
}
