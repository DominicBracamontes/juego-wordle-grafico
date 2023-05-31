/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Grafico;

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
public class LetraTest {
    
    public LetraTest() {
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
     * Test of getLetra method, of class Letra.
     */
    @Test
    public void testGetLetra() {
        System.out.println("getLetra");
        Letra instance = null;
        char expResult = ' ';
        char result = instance.getLetra();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Letra.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Letra instance = null;
        EstadoLetra expResult = null;
        EstadoLetra result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Letra.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoLetra estado = null;
        Letra instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
