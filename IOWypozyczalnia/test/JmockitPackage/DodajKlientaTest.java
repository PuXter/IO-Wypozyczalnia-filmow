/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JmockitPackage;

import Wypozyczalnia.Aplikacja;
import Wypozyczalnia.Dane;
import Wypozyczalnia.KontoKlienta;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 *
 * @author Łukasz
 */

public class DodajKlientaTest {
    Dane dane = new Dane();
    KontoKlienta result;
    
    @Mocked
    Aplikacja aplikacja;
    
    @Test
    public void testDodajKlienta() {
        System.out.println("dodajKlienta");
        new Expectations(){
            aplikacja.dodajKlienta(dane.nazwy[0], dane.hasla[0], dane.imiona[0], dane.nazwiska[0], dane.maile[0]); result = KontoKlienta[0];
        };
        aplikacja.dodajKlienta(nazwa, haslo, imie, nazwisko, email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
