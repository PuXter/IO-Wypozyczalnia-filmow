/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Wypozyczalnia;

import java.util.*;

public class Aplikacja {

	private Collection<Film> filmy = new ArrayList<>();
	private Collection<KontoKlienta> klienci = new ArrayList<>();
	private Collection<KontoPracownika> pracownicy = new ArrayList<>();

	public Collection<Film> getFilmy() {
                return filmy;
	}

	/**
	 * 
	 * @param filmy
	 */
	public void setFilmy(Collection<Film> filmy) {

		throw new UnsupportedOperationException();
	}

	public Collection<Konto> getKlienci() {

		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param klienci
	 */
	public void setKlienci(Collection<Konto> klienci) {

		throw new UnsupportedOperationException();
	}

	public Collection<Konto> getPracownicy() {

		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param pracownicy
	 */
	public void setPracownicy(List<Konto> pracownicy) {

		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tytul
	 */
	public Film szukajFilm(String tytul) throws IllegalFormatCodePointException{
		Film film;
		Iterator<Film> it = filmy.iterator();
		while (it.hasNext()) {
			film = it.next();
			if (film.getTytul() == tytul){
				return film;
			}
		}
		return null;
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tytul
	 * @param rezyser
	 * @param rokProdkcji
	 * @param cena
	 */
	public void dodajFilm(String tytul, String rezyser, int rokProdkcji, float cena) throws IllegalFormatCodePointException{
		if (tytul.isEmpty())throw new UnsupportedOperationException("Brak tytulu.");
		Film film = szukajFilm(tytul);
		if(film == null){
			if (rokProdkcji < 1895)throw new UnsupportedOperationException("Bledny rok produkcji.");
			if (cena < 0.0F)throw new UnsupportedOperationException("Bledna cena.");
			if (rezyser.isEmpty())throw new UnsupportedOperationException("Brak rezysera.");
			film = new Film(tytul, rezyser, rokProdkcji, cena);
			filmy.add(film);
		}
		else {
			throw new UnsupportedOperationException("Film o danym tytyle juz istnieje.");
		}
	}

	/**
	 * 
	 * @param tytul1
	 * @param tytul2
	 * @param rezyser
	 * @param rokProdukcji
	 * @param cena
	 */
	public void edytujFilm(String tytul1, String tytul2, String rezyser, int rokProdukcji, float cena) throws IllegalFormatCodePointException{
		Film film = szukajFilm(tytul1);
		if (film != null){
			film.setTytul(tytul2);
			film.setRezyser(rezyser);
			film.setRokProdukcji(rokProdukcji);
			film.setCena(cena);
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tytul
	 */
	public void usunFilm(String tytul) throws IllegalFormatCodePointException{
		Film film = szukajFilm(tytul);
		if (film != null){
			filmy.remove(film);
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tytul
	 */
	public void informacjeFilm(String tytul) throws IllegalFormatCodePointException{
		Film film = szukajFilm(tytul);
		if (film != null){
			System.out.println(tytul);
			System.out.println(film.getRezyser());
			System.out.println(film.getRokProdukcji());
			System.out.println(film.getCena());
			System.out.println(film.getOcena());
			System.out.println(film.getLiczbaOcen());
		}
		//throw new UnsupportedOperationException();
	}

	public ArrayList<String> modelFilmy() {
		// TODO - implement Aplikacja.modelFilmy
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazwa
	 */
	public KontoKlienta szukajKienta(String nazwa) {
		Iterator<KontoKlienta> it = klienci.iterator();
		while (it.hasNext()) {
			KontoKlienta klient = it.next();
			if (klient.getNazwa() == nazwa){
				return klient;
			}
		}
		return null;
		//throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param nazwa
	 */
	public KontoPracownika szukajPracownika(String nazwa) {
		Iterator<KontoPracownika> it = pracownicy.iterator();
		while (it.hasNext()) {
			KontoPracownika pracownik = it.next();
			if (pracownik.getNazwa() == nazwa){
				return pracownik;
			}
		}
		return null;
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazwa
	 * @param haslo
	 * @param imie
	 * @param nazwisko
	 * @param email
	 */
	public void dodajKlienta(String nazwa, String haslo, String imie, String nazwisko, String email) {
		KontoKlienta klient = szukajKienta(nazwa);
		if (klient == null){
			klient = new KontoKlienta(nazwa, haslo, imie, nazwisko, email);
			klienci.add(klient);
			System.out.println("Stworzono nowe konto.");
		}
		else{
			System.out.println("Konto o podanej nazwie już istnieje.");
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazwa1
	 * @param nazwa2
	 * @param haslo
	 * @param imie
	 * @param nazwisko
	 * @param email
	 * @param nrWypozyczenia
	 * @param waznosc
	 * @param aktywna
	 */
	public void edytujKlient(String nazwa1, String nazwa2, String haslo, String imie, String nazwisko, String email, int nrWypozyczenia, int waznosc, boolean aktywna) {
		KontoKlienta klient = szukajKienta(nazwa1);
		if(klient != null){
			klient.setHaslo(haslo);
			klient.setImie(imie);
			klient.setNazwisko(nazwisko);
			klient.setEmail(email);
		}
		else{
			KontoPracownika pracownik = szukajPracownika(nazwa1);
			if(pracownik != null){
				Wypozyczenie wypozyczenie = szukajWypozyczenie(nrWypozyczenia, nazwa2);
				if(wypozyczenie != null){
					wypozyczenie.setWaznosc(waznosc);
					wypozyczenie.setAktywna(aktywna);
				}
			}
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazwa
	 */
	public void informacjeKlient(String nazwa) {
		KontoKlienta klient = szukajKienta(nazwa);
		if(klient != null){
			System.out.println(nazwa);
			System.out.println(klient.getImie());
			System.out.println(klient.getNazwisko());
			System.out.println(klient.getEmail());
			Wypozyczenie wypozyczenie;
			if(klient.wypozyczenia.isEmpty()){
				System.out.println("Brak wypozyczen.");
			}
			else{
				System.out.println("Wypozyczenia:");
				Iterator<Wypozyczenie> it = klient.wypozyczenia.iterator();
				while (it.hasNext()) {
					wypozyczenie = it.next();
					System.out.println(wypozyczenie.film.getTytul());
				}
			}
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazwa
	 * @param haslo
	 */
	public void zalogujKlient(String nazwa, String haslo) {
		KontoKlienta klient = szukajKienta(nazwa);
		if(klient != null){
			String trueHaslo = klient.getHaslo();
			if(trueHaslo == haslo){
				System.out.println("Logowanie powiodło się.");
			}
			else{
				System.out.println("Logowanie nie powiodło się.");
			}
		}
		else{
			System.out.println("Nie ma takiego uzytkownika.");
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazwa
	 * @param haslo
	 */
	public void zalogujPracownik(String nazwa, String haslo) {
		KontoPracownika pracownik = szukajPracownika(nazwa);
		if(pracownik != null){
			String trueHaslo = pracownik.getHaslo();
			if(trueHaslo == haslo){
				System.out.println("Logowanie powieodło się.");
			}
			else{
				System.out.println("Logowanie nie powieodło się.");
			}
		}
		else{
			System.out.println("Nie ma takiego urzytkownika.");
		}
		//throw new UnsupportedOperationException();
	}

	public ArrayList<String> modelKlienci() {
		// TODO - implement Aplikacja.modelKonta
		throw new UnsupportedOperationException();
	}

	public ArrayList<String> modelPracownicy() {
		// TODO - implement Aplikacja.modelKonta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazwa
	 * @param tytul
	 * @param data
	 */
	public void wykupienie(int nrWypozyczenia, String nazwa, String tytul, String data) throws IllegalFormatCodePointException{
		if (tytul.isEmpty())throw new UnsupportedOperationException("Brak tytulu filmu.");
		KontoKlienta klient = szukajKienta(nazwa);
                if (nazwa.isEmpty())throw new UnsupportedOperationException("Brak nazwy klienta.");
		if (klient == null)throw new UnsupportedOperationException("Bledna nazwa klienta.");
		Film film = szukajFilm(tytul);
		if(film != null){
			Wypozyczenie wypozyczenie = szukajWypozyczenie(nrWypozyczenia, nazwa);
			if (wypozyczenie == null){
				wypozyczenie = new Wypozyczenie(nrWypozyczenia, film, data, 14, true);
				klient.wypozyczenia.add(wypozyczenie);
			}
                        else{
                            throw new UnsupportedOperationException("Bledny nr wypozyczenia.");
                        }
		}
                else{
                    throw new UnsupportedOperationException("Nie ma takiego filmu.");
                }
	}

	/**
	 * 
	 * @param nrWypozyczenia
	 * @param nazwa
	 */
	public Wypozyczenie szukajWypozyczenie(int nrWypozyczenia, String nazwa) throws IllegalFormatCodePointException{
		KontoKlienta klient = szukajKienta(nazwa);
		if(klient != null){
			Iterator<Wypozyczenie> it = klient.wypozyczenia.iterator();
			while (it.hasNext()) {
				Wypozyczenie wypozyczenie = it.next();
				if (wypozyczenie.getNrWypozyczenia() == nrWypozyczenia){
					return wypozyczenie;
				}
			}
		}
		return null;
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrWyporzyczenia
	 * @param nazwa
	 */
	public void informacjeWypozyczenie(int nrWyporzyczenia, String nazwa) throws IllegalFormatCodePointException{
		Wypozyczenie wypozyczenie = szukajWypozyczenie(nrWyporzyczenia, nazwa);
		if(wypozyczenie != null){
			System.out.println(wypozyczenie.getNrWypozyczenia());
			System.out.println(wypozyczenie.film.getTytul());
			System.out.println(wypozyczenie.getData());
			System.out.println(wypozyczenie.getWaznosc());
			boolean aktywna = wypozyczenie.getAktywna();
			if(aktywna){
				System.out.println("aktywne");
			}
			else{
				System.out.println("nieaktywne");
			}
			Reklamacja reklamacja = wypozyczenie.getReklamacja();
			if(reklamacja != null){
				System.out.println(reklamacja.getNrReklamacji());
			}
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazwa
	 * @param nrWypozyczenia
	 * @param nowaOcena
	 */
	public void wystawOcene(String nazwa, int nrWypozyczenia, float nowaOcena) throws IllegalFormatCodePointException{
		Wypozyczenie wypozyczenie = szukajWypozyczenie(nrWypozyczenia, nazwa);
		if(wypozyczenie != null){
			float ocena = wypozyczenie.film.getOcena();
			float liczba = wypozyczenie.film.getLiczbaOcen();
			wypozyczenie.film.setOcena((ocena*liczba+nowaOcena)/(liczba+1));
			wypozyczenie.film.setLiczbaOcen(liczba+1);
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazwa
	 * @param nrWypozyczenia
	 * @param tresc
	 * @param data
	 */
	public void zlozenieReklamacji(int nrReklamacji, String nazwa, int nrWypozyczenia, String tresc, String data) {
		Wypozyczenie wypozyczenie = szukajWypozyczenie(nrWypozyczenia, nazwa);
		if(wypozyczenie != null){
			Reklamacja reklamacja = wypozyczenie.getReklamacja();
			if(reklamacja == null){
				reklamacja = new Reklamacja(nrReklamacji, tresc, data, 0);
				wypozyczenie.setReklamacja(reklamacja);
			}
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrWyporzyczenia
	 * @param nazwa
	 */
	public Reklamacja szukajRekalamacji(int nrWyporzyczenia, String nazwa) {
		Wypozyczenie wypozyczenie = szukajWypozyczenie(nrWyporzyczenia, nazwa);
		Reklamacja reklamacja = wypozyczenie.getReklamacja();
		return reklamacja;
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazwa
	 * @param nrWypozyczenia
	 * @param status
	 */
	public void rozpatrzenieReklamacji(String nazwa, int nrWypozyczenia, int status) {
		Reklamacja reklamacja = szukajRekalamacji(nrWypozyczenia, nazwa);
		if(reklamacja != null){
			if(reklamacja.getStatus() == 0){
				reklamacja.setStatus(status);
			}
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrWyporzyczenia
	 * @param nazwa
	 */
	public void informacjeReklamacja(int nrWyporzyczenia, String nazwa) {
		Reklamacja reklamacja = szukajRekalamacji(nrWyporzyczenia, nazwa);
		if(reklamacja != null){
			System.out.println(reklamacja.getNrReklamacji());
			System.out.println(reklamacja.getTresc());
			System.out.println(reklamacja.getData());
			System.out.println(reklamacja.getStatus());
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Aplikacja aplikacja = new Aplikacja();
//		aplikacja.dodajKlienta("PuXter", "1234", "Puki", "June", "pukiJ@gmail.com");
//		aplikacja.dodajFilm("Your Name", "Makoto Shinkai", 2016, (float)8.9);
//		aplikacja.informacjeFilm("Your Name");
//		aplikacja.informacjeFilm("Your name");
//		aplikacja.informacjeKlient("PuXter");
//		aplikacja.zalogujKlient("Puxter", "1234");
//		aplikacja.zalogujKlient("PuXter", "1234");
//		aplikacja.wykupienie(1, "PuXter", "Your Name", "21.12.2021");
//		aplikacja.informacjeKlient("PuXter");
		KontoPracownika pracownik = new KontoPracownika("Paul", "1234", "Paul", "Jan", "hjkfahgfjdgshj");
		aplikacja.pracownicy.add(pracownik);
		KontoKlienta klient = new KontoKlienta("Max", "1234", "Paul", "Jan", "hjkfahgfjdgshj");
		aplikacja.klienci.add(klient);
		aplikacja.informacjeKlient("Paul");
		aplikacja.informacjeKlient("Max");
		//throw new UnsupportedOperationException();
	}
}