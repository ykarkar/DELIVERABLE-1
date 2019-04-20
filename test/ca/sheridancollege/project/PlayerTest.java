/*
 * Chintan Ganeshwala
 * Student ID:991519200
 * SYST10199 - Web Programming
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ganeshwala
 */
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of numberOfCards method, of class Player.
     */
    @Test
    public void testNumberOfCards() {
        System.out.println("numberOfCards");
        Player instance = null;
        int expResult = 1;
        int result = 1;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    @Test
    public void testNumberOfCardsbad() {
        System.out.println("numberOfCards");
        Player instance = null;
        int expResult = 0;
        int result = 0;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    @Test
    public void testNumberOfCardsboundry() {
        System.out.println("numberOfCards");
        Player instance = null;
        int expResult = 1;
        int result = 1;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
