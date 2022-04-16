/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Wypozyczalnia;

import SuitePackage.TestEntity;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Łukasz
 */

@Category({TestEntity.class})
@RunWith(Parameterized.class)

public class FilmTest {
    Dane dane;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp(){
        dane = new Dane();
    }
    
    public FilmTest() {
    }

    /**
     * Test of getTytul method, of class Film.
     */
    @Parameterized.Parameter
    public String tytul1;
    
    @Parameterized.Parameter
    public String rezyser1;
    
    @Parameterized.Parameter
    public int rok1;
    
    @Parameterized.Parameter
    public float cena1;
//    public static Collection<Film> data() {
//        Film[] data1 = new Film[] {{"t1", "r1", 2001, 10.0F}};
//        return data1;
//    }
    
    @Test
    public void testGetTytul() {
        System.out.println("getTytul");
        Film instance = new Film(dane.tytuly[0], rezyser1, rok1, cena1);
        String result = instance.getTytul();
        assertEquals(dane.tytuly[0], result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setTytul method, of class Film.
     */
    @Test
    public void testSetTytul() {
        System.out.println("setTytul");
        Film instance = new Film(tytul1, rezyser1, rok1, cena1);
        instance.setTytul(dane.tytuly[0]);
        assertEquals(dane.tytuly[0], instance.getTytul());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
