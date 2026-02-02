package edu.emir.khaled.actividad3.test;

import edu.emir.khaled.actividad3.models.EmployeeGenerator;
import edu.emir.khaled.actividad3.process.Employee;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class EmployeeTest {

    //  Tests para empleadoConMayorSalario

    @Test
    public void testEmpleadoConMayorSalario() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 20000, "ventas"),
                new EmployeeGenerator("Luis", 30, 35000, "sistemas"),
                new EmployeeGenerator("Maria", 28, 28000, "rrhh")
        );

        EmployeeGenerator resultado = Employee.empleadoConMayorSalario(empleados);
        assertEquals("Luis", resultado.getNombre());
        assertEquals(35000, resultado.getSalario(), 0.01);
    }

    @Test
    public void testEmpleadoConMayorSalarioListaVacia() {
        assertNull(Employee.empleadoConMayorSalario(new ArrayList<>()));
    }

    @Test
    public void testEmpleadoConMayorSalarioListaNull() {
        assertNull(Employee.empleadoConMayorSalario(null));
    }

    //  Tests para edadMasComun

    @Test
    public void testEdadMasComun() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 20000, "ventas"),
                new EmployeeGenerator("Luis", 30, 35000, "sistemas"),
                new EmployeeGenerator("Maria", 25, 28000, "rrhh"),
                new EmployeeGenerator("Pedro", 25, 22000, "ventas"),
                new EmployeeGenerator("Juan", 30, 27000, "sistemas")
        );

        assertEquals(25, Employee.edadMasComun(empleados));
    }

    @Test
    public void testEdadMasComunListaVacia() {
        assertEquals(-1, Employee.edadMasComun(new ArrayList<>()));
    }

    @Test
    public void testEdadMasComunTodasDistintas() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 20000, "ventas"),
                new EmployeeGenerator("Luis", 30, 35000, "sistemas"),
                new EmployeeGenerator("Maria", 28, 28000, "rrhh")
        );

        int resultado = Employee.edadMasComun(empleados);
        assertTrue(resultado == 25 || resultado == 30 || resultado == 28);
    }

    // Tests para promedioEdad

    @Test
    public void testPromedioEdad() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 20, 20000, "ventas"),
                new EmployeeGenerator("Luis", 30, 35000, "sistemas"),
                new EmployeeGenerator("Maria", 25, 28000, "rrhh")
        );

        assertEquals(25.0, Employee.promedioEdad(empleados), 0.01);
    }

    @Test
    public void testPromedioEdadListaVacia() {
        assertEquals(0.0, Employee.promedioEdad(new ArrayList<>()), 0.01);
    }

    // Tests para promedioSalario

    @Test
    public void testPromedioSalario() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 20000, "ventas"),
                new EmployeeGenerator("Luis", 30, 30000, "sistemas"),
                new EmployeeGenerator("Maria", 28, 25000, "rrhh")
        );

        assertEquals(25000.0, Employee.promedioSalario(empleados), 0.01);
    }

    @Test
    public void testPromedioSalarioListaVacia() {
        assertEquals(0.0, Employee.promedioSalario(new ArrayList<>()), 0.01);
    }

    //  Tests para promedioEdadSalarioMayor25K

    @Test
    public void testPromedioEdadSalarioMayor25K() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 20, 20000, "ventas"),
                new EmployeeGenerator("Luis", 30, 30000, "sistemas"),
                new EmployeeGenerator("Maria", 40, 28000, "rrhh"),
                new EmployeeGenerator("Pedro", 50, 35000, "ventas")
        );

        // Solo Luis (30), Maria (40) y Pedro (50) ganan mas de 25K
        // Promedio: (30 + 40 + 50) / 3 = 40
        assertEquals(40.0, Employee.promedioEdadSalarioMayor25K(empleados), 0.01);
    }

    @Test
    public void testPromedioEdadSalarioMayor25KNingunoCumple() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 20000, "ventas"),
                new EmployeeGenerator("Luis", 30, 24000, "sistemas")
        );

        assertEquals(0.0, Employee.promedioEdadSalarioMayor25K(empleados), 0.01);
    }

    // Tests para filtrarMenoresDe25

    @Test
    public void testFiltrarMenoresDe25() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 22, 20000, "ventas"),
                new EmployeeGenerator("Luis", 30, 35000, "sistemas"),
                new EmployeeGenerator("Maria", 24, 28000, "rrhh"),
                new EmployeeGenerator("Pedro", 26, 22000, "ventas")
        );

        List<EmployeeGenerator> resultado = Employee.filtrarMenoresDe25(empleados);
        assertEquals(2, resultado.size());
        assertEquals("Ana", resultado.get(0).getNombre());
        assertEquals("Maria", resultado.get(1).getNombre());
    }

    @Test
    public void testFiltrarMenoresDe25NingunoCumple() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 20000, "ventas"),
                new EmployeeGenerator("Luis", 30, 35000, "sistemas")
        );

        assertEquals(0, Employee.filtrarMenoresDe25(empleados).size());
    }

    @Test
    public void testFiltrarMenoresDe25ListaNull() {
        assertEquals(0, Employee.filtrarMenoresDe25(null).size());
    }

    // Tests para contarDepartamentoSistemas

    @Test
    public void testContarDepartamentoSistemas() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 20000, "ventas"),
                new EmployeeGenerator("Luis", 30, 35000, "sistemas"),
                new EmployeeGenerator("Maria", 28, 28000, "sistemas"),
                new EmployeeGenerator("Pedro", 26, 22000, "rrhh")
        );

        assertEquals(2, Employee.contarDepartamentoSistemas(empleados));
    }

    @Test
    public void testContarDepartamentoSistemasCaseInsensitive() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 20000, "SISTEMAS"),
                new EmployeeGenerator("Luis", 30, 35000, "Sistemas"),
                new EmployeeGenerator("Maria", 28, 28000, "sistemas")
        );

        assertEquals(3, Employee.contarDepartamentoSistemas(empleados));
    }

    @Test
    public void testContarDepartamentoSistemasNingunoCumple() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 20000, "ventas"),
                new EmployeeGenerator("Pedro", 26, 22000, "rrhh")
        );

        assertEquals(0, Employee.contarDepartamentoSistemas(empleados));
    }

    // Tests para mayorSalarioMayorDe30

    @Test
    public void testMayorSalarioMayorDe30() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 40000, "ventas"),
                new EmployeeGenerator("Luis", 35, 30000, "sistemas"),
                new EmployeeGenerator("Maria", 40, 45000, "rrhh"),
                new EmployeeGenerator("Pedro", 32, 28000, "ventas")
        );

        EmployeeGenerator resultado = Employee.mayorSalarioMayorDe30(empleados);
        assertEquals("Maria", resultado.getNombre());
        assertEquals(45000, resultado.getSalario(), 0.01);
    }

    @Test
    public void testMayorSalarioMayorDe30NingunoCumple() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 40000, "ventas"),
                new EmployeeGenerator("Luis", 30, 35000, "sistemas")
        );

        assertNull(Employee.mayorSalarioMayorDe30(empleados));
    }

    @Test
    public void testMayorSalarioMayorDe30ListaVacia() {
        assertNull(Employee.mayorSalarioMayorDe30(new ArrayList<>()));
    }

    // Tests para menorSalarioEdadMenosComun

    @Test
    public void testMenorSalarioEdadMenosComun() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 30000, "ventas"),
                new EmployeeGenerator("Luis", 25, 35000, "sistemas"),
                new EmployeeGenerator("Maria", 30, 28000, "rrhh"),
                new EmployeeGenerator("Pedro", 30, 32000, "ventas"),
                new EmployeeGenerator("Juan", 40, 50000, "sistemas")  // edad menos comun
        );

        // Edad 40 es la menos comun (1 vez)
        // Edades 25 y 30 aparecen 2 veces cada una
        EmployeeGenerator resultado = Employee.menorSalarioEdadMenosComun(empleados);
        assertEquals("Juan", resultado.getNombre());
        assertEquals(40, resultado.getEdad());
    }

    @Test
    public void testMenorSalarioEdadMenosComunVariosConMismaEdad() {
        List<EmployeeGenerator> empleados = Arrays.asList(
                new EmployeeGenerator("Ana", 25, 30000, "ventas"),
                new EmployeeGenerator("Luis", 25, 35000, "sistemas"),
                new EmployeeGenerator("Maria", 40, 28000, "rrhh"),
                new EmployeeGenerator("Pedro", 40, 22000, "ventas")  // menor salario con edad menos comun
        );

        // Edades 40 y 25 aparecen 2 veces cada una (ambas menos comunes)
        // Entre los de edad menos comun, Pedro tiene el menor salario
        EmployeeGenerator resultado = Employee.menorSalarioEdadMenosComun(empleados);
        assertEquals("Pedro", resultado.getNombre());
        assertEquals(22000, resultado.getSalario(), 0.01);
    }

    @Test
    public void testMenorSalarioEdadMenosComunListaVacia() {
        assertNull(Employee.menorSalarioEdadMenosComun(new ArrayList<>()));
    }
}
