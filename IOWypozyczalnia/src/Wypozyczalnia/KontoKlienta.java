/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Wypozyczalnia;

import java.util.*;

public class KontoKlienta extends Konto {

	protected Collection<Wypozyczenie> wypozyczenia = new ArrayList<>();

	public Collection<Wypozyczenie> getWypozyczenia() {
		return this.wypozyczenia;
	}

	public void setWypozyczenia(Collection<Wypozyczenie> wypozyczenia) {
		this.wypozyczenia = wypozyczenia;
	}

	/**
	 * 
	 * @param nazwa
	 * @param haslo
	 * @param imie
	 * @param nazwisko
	 * @param email
	 */
	public KontoKlienta(String nazwa, String haslo, String imie, String nazwisko, String email) {
		this.nazwa = nazwa;
		this.haslo = haslo;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
	}
}