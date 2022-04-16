/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Wypozyczalnia;

public class KontoPracownika extends Konto {

	/**
	 * 
	 * @param nazwa
	 * @param haslo
	 * @param imie
	 * @param nazwisko
	 * @param email
	 */
	public KontoPracownika(String nazwa, String haslo, String imie, String nazwisko, String email) {
		this.nazwa = nazwa;
		this.haslo = haslo;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
	}

}
