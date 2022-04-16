/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Wypozyczalnia;

public class Reklamacja {

	protected int nrReklamacji;
	protected String tresc;
	protected String data;
	protected int status;

	public int getNrReklamacji() {
		return this.nrReklamacji;
	}

	/**
	 * 
	 * @param nrReklamacji
	 */
	public void setNrReklamacji(int nrReklamacji) {
		this.nrReklamacji = nrReklamacji;
	}

	public String getTresc() {
		return this.tresc;
	}

	/**
	 * 
	 * @param tresc
	 */
	public void setTresc(String tresc) {
		this.tresc = tresc;
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

	public int getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 *
	 * @param tresc
	 * @param data
	 * @param status
	 */
	public Reklamacja(int nrReklamacji, String tresc, String data, int status) {
		this.nrReklamacji = nrReklamacji;
		this.tresc = tresc;
		this.data = data;
		this.status = status;
	}

}
