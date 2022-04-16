/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Wypozyczalnia;

import SuitePackage.TestEntity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Łukasz
 */
@Category({TestEntity.class})
@RunWith(Parameterized.class)
public class WypozyczenieTest {
    Dane dane = new Dane();
    
    public WypozyczenieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getNrWypozyczenia method, of class Wypozyczenie.
     */
    @Parameterized.Parameter
    public int nr1;
    
    @Parameterized.Parameter
    public Film film1;
    
    @Parameterized.Parameter
    public String data1;
    
    @Parameterized.Parameter
    public int waznosc1;
    
    @Parameterized.Parameter
    public boolean aktywna1;
    
    @Test
    public void testGetNrWypozyczenia() {
        System.out.println("getNrWypozyczenia");
        Wypozyczenie instance = new Wypozyczenie(dane.nr[0], film1, data1, waznosc1, aktywna1);
        int result = instance.getNrWypozyczenia();
        assertEquals(dane.nr[0], result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setNrWypozyczenia method, of class Wypozyczenie.
     */
    @Test
    public void testSetNrWypozyczenia() {
        System.out.println("setNrWypozyczenia");
        Wypozyczenie instance = new Wypozyczenie(nr1, film1, data1, waznosc1, aktywna1);
        instance.setNrWypozyczenia(dane.nr[0]);
        assertEquals(dane.nr[0], instance.getNrWypozyczenia());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
