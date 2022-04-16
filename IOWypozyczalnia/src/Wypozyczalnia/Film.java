/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Wypozyczalnia;

public class Film {

	protected String tytul;
	protected String rezyser;
	protected int rokProdukcji;
	protected float ocena = 0;
	protected float cena;
	protected float liczbaOcen = 0;

	public String getTytul() {
		return this.tytul;
	}

	/**
	 * 
	 * @param tytul
	 */
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public String getRezyser() {
		return this.rezyser;
	}

	/**
	 * 
	 * @param rezyser
	 */
	public void setRezyser(String rezyser) {
		this.rezyser = rezyser;
	}

	public int getRokProdukcji() {
		return this.rokProdukcji;
	}

	/**
	 * 
	 * @param rokProdukcji
	 */
	public void setRokProdukcji(int rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}

	public float getOcena() {
		return this.ocena;
	}

	/**
	 * 
	 * @param ocena
	 */
	public void setOcena(float ocena) {
		this.ocena = ocena;
	}

	public float getCena() {
		return this.cena;
	}

	/**
	 * 
	 * @param cena
	 */
	public void setCena(float cena) {
		this.cena = cena;
	}

	public float getLiczbaOcen() {
		return this.liczbaOcen;
	}

	/**
	 * 
	 * @param liczbaOcen
	 */
	public void setLiczbaOcen(float liczbaOcen) {
		this.liczbaOcen = liczbaOcen;
	}

	/**
	 *
	 * @param tytul
	 * @param rezyser
	 * @param rokProdukcji
	 * @param cena
	 */
	public Film(String tytul, String rezyser, int rokProdukcji, float cena) {
		this.tytul = tytul;
		this.rezyser = rezyser;
		this.rokProdukcji = rokProdukcji;
		this.cena = cena;
	}
}