package edu.emir.khaled.actividad3.test;

import edu.emir.khaled.actividad3.process.ListNumbers;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class ListNumbersTest {

    // Tests para moverCerosAlFinal

    @Test
    public void testMoverCerosAlFinalCasoBasico() {
        List<Integer> input = Arrays.asList(0, 2, 1, 4, 0, 2);
        List<Integer> esperado = Arrays.asList(2, 1, 4, 2, 0, 0);
        assertEquals(esperado, ListNumbers.moverCerosAlFinal(input));
    }

    @Test
    public void testMoverCerosAlFinalSinCeros() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        List<Integer> esperado = Arrays.asList(1, 2, 3, 4);
        assertEquals(esperado, ListNumbers.moverCerosAlFinal(input));
    }

    @Test
    public void testMoverCerosAlFinalTodosCeros() {
        List<Integer> input = Arrays.asList(0, 0, 0);
        List<Integer> esperado = Arrays.asList(0, 0, 0);
        assertEquals(esperado, ListNumbers.moverCerosAlFinal(input));
    }

    @Test
    public void testMoverCerosAlFinalListaVacia() {
        List<Integer> input = new ArrayList<>();
        List<Integer> esperado = new ArrayList<>();
        assertEquals(esperado, ListNumbers.moverCerosAlFinal(input));
    }

    @Test
    public void testMoverCerosAlFinalUnSoloElemento() {
        List<Integer> input = Arrays.asList(5);
        List<Integer> esperado = Arrays.asList(5);
        assertEquals(esperado, ListNumbers.moverCerosAlFinal(input));
    }

    @Test
    public void testMoverCerosAlFinalCeroAlInicio() {
        List<Integer> input = Arrays.asList(0, 1, 2, 3);
        List<Integer> esperado = Arrays.asList(1, 2, 3, 0);
        assertEquals(esperado, ListNumbers.moverCerosAlFinal(input));
    }

    // Tests para contarPares

    @Test
    public void testContarParesCasoBasico() {
        List<Integer> input = Arrays.asList(3, 4, 5, 7, 6);
        assertEquals(2, ListNumbers.contarPares(input));
    }

    @Test
    public void testContarParesSinPares() {
        List<Integer> input = Arrays.asList(1, 3, 5, 7);
        assertEquals(0, ListNumbers.contarPares(input));
    }

    @Test
    public void testContarParesTodoPares() {
        List<Integer> input = Arrays.asList(2, 4, 6, 8);
        assertEquals(4, ListNumbers.contarPares(input));
    }

    @Test
    public void testContarParesListaVacia() {
        List<Integer> input = new ArrayList<>();
        assertEquals(0, ListNumbers.contarPares(input));
    }

    @Test
    public void testContarParesConCero() {
        List<Integer> input = Arrays.asList(0, 1, 2, 3);
        assertEquals(2, ListNumbers.contarPares(input));
    }

    @Test
    public void testContarParesConNegativos() {
        List<Integer> input = Arrays.asList(-2, -1, 0, 1, 2);
        assertEquals(3, ListNumbers.contarPares(input));
    }
}
