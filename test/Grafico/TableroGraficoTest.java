/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Grafico;

import java.awt.Dimension;
import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author domi1
 */
public class TableroGraficoTest {
    
    public TableroGraficoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of colocarPalabra method, of class TableroGrafico.
     */
    @Test
    public void testColocarPalabra_String() {
        System.out.println("colocarPalabra");
        String palabra = "mundo";
        TableroGrafico instance = new TableroGrafico();
        instance.colocarPalabra(palabra);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarColorCuadro method, of class TableroGrafico.
     */
    @Test
    public void testCambiarColorCuadro() {
        System.out.println("cambiarColorCuadro");
        int fila = 1;
        int columna = 1;
        int estado = 1;
        TableroGrafico instance = new TableroGrafico();
        instance.cambiarColorCuadro(fila, columna, estado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of paint method, of class TableroGrafico.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics g = null;
        TableroGrafico instance = new TableroGrafico();
        instance.paint(g);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPreferredSize method, of class TableroGrafico.
     */
    @Test
    public void testGetPreferredSize() {
        System.out.println("getPreferredSize");
        TableroGrafico instance = new TableroGrafico();
        Dimension expResult = null;
        Dimension result = instance.getPreferredSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarTablero method, of class TableroGrafico.
     */
    @Test
    public void testActualizarTablero() {
        System.out.println("actualizarTablero");
        String palabra = "";
        String referencia = "";
        int linea = 0;
        TableroGrafico instance = new TableroGrafico();
        instance.actualizarTablero(palabra, referencia, linea);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarTablero method, of class TableroGrafico.
     */
    @Test
    public void testMostrarTablero() {
        System.out.println("mostrarTablero");
        TableroGrafico instance = new TableroGrafico();
        instance.mostrarTablero();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of colocarPalabra method, of class TableroGrafico.
     */
    @Test
    public void testColocarPalabra_String_Graphics() {
        System.out.println("colocarPalabra");
        String palabra = "mundo";
        Graphics g = null;
        TableroGrafico instance = new TableroGrafico();
        instance.colocarPalabra(palabra, g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
