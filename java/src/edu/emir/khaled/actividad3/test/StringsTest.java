package edu.emir.khaled.actividad3.test;

import edu.emir.khaled.actividad3.process.Strings;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringsTest {

    //  Tests para esPalindromo

    @Test
    public void testEsPalindromoVerdadero() {
        assertTrue(Strings.esPalindromo("ana"));
    }

    @Test
    public void testEsPalindromoFalso() {
        assertFalse(Strings.esPalindromo("hola mundo"));
    }

    @Test
    public void testEsPalindromoConEspacios() {
        assertTrue(Strings.esPalindromo("anita lava la tina"));
    }

    @Test
    public void testEsPalindromoConMayusculas() {
        assertTrue(Strings.esPalindromo("Oso"));
    }

    @Test
    public void testEsPalindromoCadenaVacia() {
        assertTrue(Strings.esPalindromo(""));
    }

    @Test
    public void testEsPalindromoUnCaracter() {
        assertTrue(Strings.esPalindromo("a"));
    }

    @Test
    public void testEsPalindromoNull() {
        assertTrue(Strings.esPalindromo(null));
    }

    //  Tests para contarVocales

    @Test
    public void testContarVocalesCasoBasico() {
        assertEquals(2, Strings.contarVocales("hola"));
    }

    @Test
    public void testContarVocalesSinVocales() {
        assertEquals(0, Strings.contarVocales("xyz"));
    }

    @Test
    public void testContarVocalesConMayusculas() {
        assertEquals(5, Strings.contarVocales("AEIOUaeiou"));
    }

    @Test
    public void testContarVocalesConAcentos() {
        assertEquals(3, Strings.contarVocales("árbol"));
    }

    @Test
    public void testContarVocalesCadenaVacia() {
        assertEquals(0, Strings.contarVocales(""));
    }

    @Test
    public void testContarVocalesNull() {
        assertEquals(0, Strings.contarVocales(null));
    }

    // Tests para invertir

    @Test
    public void testInvertirCasoBasico() {
        assertEquals("aloh", Strings.invertir("hola"));
    }

    @Test
    public void testInvertirUnCaracter() {
        assertEquals("a", Strings.invertir("a"));
    }

    @Test
    public void testInvertirCadenaVacia() {
        assertEquals("", Strings.invertir(""));
    }

    @Test
    public void testInvertirNull() {
        assertNull(Strings.invertir(null));
    }

    @Test
    public void testInvertirConNumeros() {
        assertEquals("54321", Strings.invertir("12345"));
    }

    // -------- Tests para primeraUbicacion --------

    @Test
    public void testPrimeraUbicacionExiste() {
        assertEquals(1, Strings.primeraUbicacion("hola", 'o'));
    }

    @Test
    public void testPrimeraUbicacionNoExiste() {
        assertEquals(-1, Strings.primeraUbicacion("hola", 'r'));
    }

    @Test
    public void testPrimeraUbicacionEnPosicionCero() {
        assertEquals(0, Strings.primeraUbicacion("hola", 'h'));
    }

    @Test
    public void testPrimeraUbicacionCaracterRepetido() {
        assertEquals(1, Strings.primeraUbicacion("casa", 'a'));
    }

    @Test
    public void testPrimeraUbicacionCadenaVacia() {
        assertEquals(-1, Strings.primeraUbicacion("", 'a'));
    }

    @Test
    public void testPrimeraUbicacionNull() {
        assertEquals(-1, Strings.primeraUbicacion(null, 'a'));
    }

    @Test
    public void testPrimeraUbicacionEspacio() {
        assertEquals(4, Strings.primeraUbicacion("hola mundo", ' '));
    }
}

