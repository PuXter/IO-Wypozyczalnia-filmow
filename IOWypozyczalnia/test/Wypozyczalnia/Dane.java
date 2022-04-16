/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Wypozyczalnia;

/**
 *
 * @author Łukasz
 */
public class Dane {
    
    public String tytuly[] = new String []{"f1", "f2", "f3", "f4", "", "f6", "f7", "f8", "f1"};
    public String rezyserzy[] = new String []{"r1", "r2", "r3", "r4", "r5", "r6", "r7", "", "r9"};
    public int lataProdukcji[] = new int []{2001, 2002, 2003, 2004, 2005, 2006, -2007, 2008, 2009};
    public float ceny[] = new float []{1.0F, 2.0F, 3.0F, 4.0F, 5.0F, -6.0F, 7.0F, 8.0F, 9.0F};
            
    public static Film filmyTab [] = {
        new Film ("f1", "r1", 2001, 1.0F), new Film ("f2", "r2", 2002, 2.0F), new Film ("f3", "r3", 2003, 3.0F), new Film ("f4", "r4", 2004, 4.0F)
    };
    
    public int nr[] = new int []{1, 2, 3, 4, 5, 1, -6};
    public String daty[] = new String []{"01.01.2001", "02.02.2002", "03.03.2003", "nie", "05.05.2005", "06.06.2006"};
    
    public static Wypozyczenie wypozyczeniaTab [] = {
        new Wypozyczenie (1, filmyTab[0], "01.01.2001", 1, true), new Wypozyczenie (2, filmyTab[1], "02.02.2002", 2, true)
    };
    
    public String nazwy[] = new String []{"n1", "n2", "n3", "n4"};
    public String hasla[] = new String []{"h1", "h2", "h3", "h4"};
    public String imiona[] = new String []{"i1", "i2", "i3", "i4"};
    public String nazwiska[] = new String []{"na1", "na2", "na3", "na4"};
    public String maile[] = new String []{"m1", "m2", "m3", "m4"};
    
    public static KontoKlienta klienci [] = {
        new KontoKlienta ("n1", "h1", "i1", "na1", "m1"), new KontoKlienta ("n2", "h2", "i2", "na2", "m2"), new KontoKlienta ("n3", "h3", "i3", "na3", "m3"), 
        new KontoKlienta ("n4", "h4", "i4", "na4", "m4"), new KontoKlienta ("n5", "h5", "i5", "na5", "m5")
    };
    
}