/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Wypozyczalnia;

public class Wypozyczenie {

	protected int nrWypozyczenia;
	protected Film film;
	protected String data;
	protected int waznosc;
	protected boolean aktywna;
	private Reklamacja reklamacja = null;

	public int getNrWypozyczenia() {
		return this.nrWypozyczenia;
	}

	/**
	 * 
	 * @param nrWypozyczenia
	 */
	public void setNrWypozyczenia(int nrWypozyczenia) {
		this.nrWypozyczenia = nrWypozyczenia;
	}

	public Film getFilm() {
		return this.film;
	}

	/**
	 * 
	 * @param film
	 */
	public void setFilm(Film film) {
		this.film = film;
	}

	public String getData() {
		return this.data;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	public int getWaznosc() {
		return this.waznosc;
	}

	/**
	 * 
	 * @param waznosc
	 */
	public void setWaznosc(int waznosc) {
		this.waznosc = waznosc;
	}

	public boolean getAktywna() {
		return this.aktywna;
	}

	/**
	 * 
	 * @param aktywna
	 */
	public void setAktywna(boolean aktywna) {
		this.aktywna = aktywna;
	}

	public Reklamacja getReklamacja() {
		// TODO - implement Wypozyczenie.getReklamacja
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reklamacje
	 */
	public void setReklamacja(Reklamacja reklamacje) {
		// TODO - implement Wypozyczenie.setReklamacja
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param film
	 * @param data
	 * @param waznosc
	 * @param aktywna
	 */
	public Wypozyczenie(int nrWypozyczenia, Film film, String data, int waznosc, boolean aktywna) {
		this.nrWypozyczenia = nrWypozyczenia;
		this.film = film;
		this.data = data;
		this.waznosc = waznosc;
		this.aktywna = aktywna;
	}
}
