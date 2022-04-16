/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Wypozyczalnia;

import SuitePackage.TestControl;
import SuitePackage.TestEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Łukasz
 */
@Category({TestEntity.class, TestControl.class})

public class AplikacjaTest {
    
    static Dane dane;
    
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
    
    public AplikacjaTest() {
    }


    /**
     * Test of dodajFilm method, of class Aplikacja.
     */
    @Test
    public void testDodajFilm() {
        System.out.println("dodajFilm");
        Aplikacja instance = new Aplikacja();
        
        for(int i=0;i<4;i++){
            instance.dodajFilm(dane.tytuly[i], dane.rezyserzy[i], dane.lataProdukcji[i], dane.ceny[i]);
            Film film1 = instance.szukajFilm(dane.tytuly[i]);
            assertEquals(film1.tytul, dane.filmyTab[i].tytul);
            assertEquals(film1.rezyser, dane.filmyTab[i].rezyser);
            assertEquals(film1.rokProdukcji, dane.filmyTab[i].rokProdukcji);
            float d = (float) Math.pow(10, Math.log10(Math.abs(film1.cena)) - 12);
            assertEquals(film1.cena, dane.filmyTab[i].cena, d);
        }
        int rozmiar = instance.getFilmy().size();
        assertEquals(rozmiar, dane.filmyTab.length);
        
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Brak tytulu.");
        instance.dodajFilm(dane.tytuly[4], dane.rezyserzy[4], dane.lataProdukcji[4], dane.ceny[4]);
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Bledna cena.");
        instance.dodajFilm(dane.tytuly[5], dane.rezyserzy[5], dane.lataProdukcji[5], dane.ceny[5]);
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Bledny rok produkcji.");
        instance.dodajFilm(dane.tytuly[6], dane.rezyserzy[6], dane.lataProdukcji[6], dane.ceny[6]);
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Brak rezysera.");
        instance.dodajFilm(dane.tytuly[7], dane.rezyserzy[7], dane.lataProdukcji[7], dane.ceny[7]);
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Film o danym tytyle juz istnieje.");
        instance.dodajFilm(dane.tytuly[8], dane.rezyserzy[8], dane.lataProdukcji[8], dane.ceny[8]);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("Dodaj film failed.");
    }


    /**
     * Test of wykupienie method, of class Aplikacja.
     */
    @Test
    public void testWykupienie() {
        System.out.println("wykupienie");
        Aplikacja instance = new Aplikacja();
        instance.dodajFilm(dane.tytuly[0], dane.rezyserzy[0], dane.lataProdukcji[0], dane.ceny[0]);
        instance.dodajFilm(dane.tytuly[1], dane.rezyserzy[1], dane.lataProdukcji[1], dane.ceny[1]);
        instance.dodajKlienta(dane.rezyserzy[1], "1234", "Jan", "Kowalski", "JK@gmail.com");
        
        for(int i=0;i<2;i++){
            instance.wykupienie(dane.nr[i], dane.rezyserzy[1], dane.tytuly[i], dane.daty[i]);
            Wypozyczenie wypozyczenie1 = instance.szukajWypozyczenie(dane.nr[i],dane.rezyserzy[1]);
            assertEquals(wypozyczenie1.nrWypozyczenia, dane.wypozyczeniaTab[i].nrWypozyczenia);
            assertEquals(wypozyczenie1.film.tytul, dane.wypozyczeniaTab[i].film.tytul);
            assertEquals(wypozyczenie1.film.rezyser, dane.wypozyczeniaTab[i].film.rezyser);
            assertEquals(wypozyczenie1.film.rokProdukcji, dane.wypozyczeniaTab[i].film.rokProdukcji);
            float d = (float) Math.pow(10, Math.log10(Math.abs(wypozyczenie1.waznosc)) - 12);
            assertEquals(wypozyczenie1.film.cena, dane.wypozyczeniaTab[i].film.cena, d);
            assertEquals(wypozyczenie1.data, dane.wypozyczeniaTab[i].data);
            assertEquals(wypozyczenie1.waznosc, 14.0, d);
            assertEquals(wypozyczenie1.aktywna, true);
        }
        KontoKlienta konto = instance.szukajKienta(dane.rezyserzy[1]);
        int rozmiar = konto.getWypozyczenia().size();
        assertEquals(rozmiar, dane.wypozyczeniaTab.length);
        
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Brak tytulu filmu.");
        instance.wykupienie(dane.nr[2], dane.rezyserzy[1], dane.tytuly[4], dane.daty[4]);
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Brak nazwy klienta.");
        instance.wykupienie(dane.nr[3], dane.rezyserzy[7], dane.tytuly[0], dane.daty[5]);
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Bledna nazwa klienta.");
        instance.wykupienie(dane.nr[4], dane.rezyserzy[2], dane.tytuly[0], dane.daty[6]);
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage("Bledny nr wypozyczenia.");
        instance.wykupienie(dane.nr[5], dane.rezyserzy[1], dane.tytuly[0], dane.daty[7]);
        // TODO review the generated test code and remove the default call to fail.
        fail("Blad wykupienia.");
    }

    /**
     * Test of getFilmy method, of class Aplikacja.
     */
    @Test
    public void testGetFilmy() {
        System.out.println("getFilmy");
        Aplikacja instance = new Aplikacja();
        Collection<Film> expResult = null;
        Collection<Film> result = instance.getFilmy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFilmy method, of class Aplikacja.
     */
    @Test
    public void testSetFilmy() {
        System.out.println("setFilmy");
        Collection<Film> filmy = null;
        Aplikacja instance = new Aplikacja();
        instance.setFilmy(filmy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKlienci method, of class Aplikacja.
     */
    @Test
    public void testGetKlienci() {
        System.out.println("getKlienci");
        Aplikacja instance = new Aplikacja();
        Collection<Konto> expResult = null;
        Collection<Konto> result = instance.getKlienci();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKlienci method, of class Aplikacja.
     */
    @Test
    public void testSetKlienci() {
        System.out.println("setKlienci");
        Collection<Konto> klienci = null;
        Aplikacja instance = new Aplikacja();
        instance.setKlienci(klienci);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPracownicy method, of class Aplikacja.
     */
    @Test
    public void testGetPracownicy() {
        System.out.println("getPracownicy");
        Aplikacja instance = new Aplikacja();
        Collection<Konto> expResult = null;
        Collection<Konto> result = instance.getPracownicy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPracownicy method, of class Aplikacja.
     */
    @Test
    public void testSetPracownicy() {
        System.out.println("setPracownicy");
        List<Konto> pracownicy = null;
        Aplikacja instance = new Aplikacja();
        instance.setPracownicy(pracownicy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of szukajFilm method, of class Aplikacja.
     */
    @Test
    public void testSzukajFilm() {
        System.out.println("szukajFilm");
        String tytul = "";
        Aplikacja instance = new Aplikacja();
        Film expResult = null;
        Film result = instance.szukajFilm(tytul);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edytujFilm method, of class Aplikacja.
     */
    @Test
    public void testEdytujFilm() {
        System.out.println("edytujFilm");
        String tytul1 = "";
        String tytul2 = "";
        String rezyser = "";
        int rokProdukcji = 0;
        float cena = 0.0F;
        Aplikacja instance = new Aplikacja();
        instance.edytujFilm(tytul1, tytul2, rezyser, rokProdukcji, cena);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of usunFilm method, of class Aplikacja.
     */
    @Test
    public void testUsunFilm() {
        System.out.println("usunFilm");
        String tytul = "";
        Aplikacja instance = new Aplikacja();
        instance.usunFilm(tytul);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of informacjeFilm method, of class Aplikacja.
     */
    @Test
    public void testInformacjeFilm() {
        System.out.println("informacjeFilm");
        String tytul = "";
        Aplikacja instance = new Aplikacja();
        instance.informacjeFilm(tytul);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelFilmy method, of class Aplikacja.
     */
    @Test
    public void testModelFilmy() {
        System.out.println("modelFilmy");
        Aplikacja instance = new Aplikacja();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.modelFilmy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of szukajKienta method, of class Aplikacja.
     */
    @Test
    public void testSzukajKienta() {
        System.out.println("szukajKienta");
        String nazwa = "";
        Aplikacja instance = new Aplikacja();
        KontoKlienta expResult = null;
        KontoKlienta result = instance.szukajKienta(nazwa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of szukajPracownika method, of class Aplikacja.
     */
    @Test
    public void testSzukajPracownika() {
        System.out.println("szukajPracownika");
        String nazwa = "";
        Aplikacja instance = new Aplikacja();
        KontoPracownika expResult = null;
        KontoPracownika result = instance.szukajPracownika(nazwa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dodajKlienta method, of class Aplikacja.
     */
    @Test
    public void testDodajKlienta() {
        System.out.println("dodajKlienta");
        String nazwa = "";
        String haslo = "";
        String imie = "";
        String nazwisko = "";
        String email = "";
        Aplikacja instance = new Aplikacja();
        instance.dodajKlienta(nazwa, haslo, imie, nazwisko, email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edytujKlient method, of class Aplikacja.
     */
    @Test
    public void testEdytujKlient() {
        System.out.println("edytujKlient");
        String nazwa1 = "";
        String nazwa2 = "";
        String haslo = "";
        String imie = "";
        String nazwisko = "";
        String email = "";
        int nrWypozyczenia = 0;
        int waznosc = 0;
        boolean aktywna = false;
        Aplikacja instance = new Aplikacja();
        instance.edytujKlient(nazwa1, nazwa2, haslo, imie, nazwisko, email, nrWypozyczenia, waznosc, aktywna);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of informacjeKlient method, of class Aplikacja.
     */
    @Test
    public void testInformacjeKlient() {
        System.out.println("informacjeKlient");
        String nazwa = "";
        Aplikacja instance = new Aplikacja();
        instance.informacjeKlient(nazwa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zalogujKlient method, of class Aplikacja.
     */
    @Test
    public void testZalogujKlient() {
        System.out.println("zalogujKlient");
        String nazwa = "";
        String haslo = "";
        Aplikacja instance = new Aplikacja();
        instance.zalogujKlient(nazwa, haslo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zalogujPracownik method, of class Aplikacja.
     */
    @Test
    public void testZalogujPracownik() {
        System.out.println("zalogujPracownik");
        String nazwa = "";
        String haslo = "";
        Aplikacja instance = new Aplikacja();
        instance.zalogujPracownik(nazwa, haslo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelKlienci method, of class Aplikacja.
     */
    @Test
    public void testModelKlienci() {
        System.out.println("modelKlienci");
        Aplikacja instance = new Aplikacja();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.modelKlienci();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modelPracownicy method, of class Aplikacja.
     */
    @Test
    public void testModelPracownicy() {
        System.out.println("modelPracownicy");
        Aplikacja instance = new Aplikacja();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.modelPracownicy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of szukajWypozyczenie method, of class Aplikacja.
     */
    @Test
    public void testSzukajWypozyczenie() {
        System.out.println("szukajWypozyczenie");
        int nrWypozyczenia = 0;
        String nazwa = "";
        Aplikacja instance = new Aplikacja();
        Wypozyczenie expResult = null;
        Wypozyczenie result = instance.szukajWypozyczenie(nrWypozyczenia, nazwa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of informacjeWypozyczenie method, of class Aplikacja.
     */
    @Test
    public void testInformacjeWypozyczenie() {
        System.out.println("informacjeWypozyczenie");
        int nrWyporzyczenia = 0;
        String nazwa = "";
        Aplikacja instance = new Aplikacja();
        instance.informacjeWypozyczenie(nrWyporzyczenia, nazwa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wystawOcene method, of class Aplikacja.
     */
    @Test
    public void testWystawOcene() {
        System.out.println("wystawOcene");
        String nazwa = "";
        int nrWypozyczenia = 0;
        float nowaOcena = 0.0F;
        Aplikacja instance = new Aplikacja();
        instance.wystawOcene(nazwa, nrWypozyczenia, nowaOcena);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zlozenieReklamacji method, of class Aplikacja.
     */
    @Test
    public void testZlozenieReklamacji() {
        System.out.println("zlozenieReklamacji");
        int nrReklamacji = 0;
        String nazwa = "";
        int nrWypozyczenia = 0;
        String tresc = "";
        String data = "";
        Aplikacja instance = new Aplikacja();
        instance.zlozenieReklamacji(nrReklamacji, nazwa, nrWypozyczenia, tresc, data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of szukajRekalamacji method, of class Aplikacja.
     */
    @Test
    public void testSzukajRekalamacji() {
        System.out.println("szukajRekalamacji");
        int nrWyporzyczenia = 0;
        String nazwa = "";
        Aplikacja instance = new Aplikacja();
        Reklamacja expResult = null;
        Reklamacja result = instance.szukajRekalamacji(nrWyporzyczenia, nazwa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rozpatrzenieReklamacji method, of class Aplikacja.
     */
    @Test
    public void testRozpatrzenieReklamacji() {
        System.out.println("rozpatrzenieReklamacji");
        String nazwa = "";
        int nrWypozyczenia = 0;
        int status = 0;
        Aplikacja instance = new Aplikacja();
        instance.rozpatrzenieReklamacji(nazwa, nrWypozyczenia, status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of informacjeReklamacja method, of class Aplikacja.
     */
    @Test
    public void testInformacjeReklamacja() {
        System.out.println("informacjeReklamacja");
        int nrWyporzyczenia = 0;
        String nazwa = "";
        Aplikacja instance = new Aplikacja();
        instance.informacjeReklamacja(nrWyporzyczenia, nazwa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Aplikacja.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Aplikacja.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
