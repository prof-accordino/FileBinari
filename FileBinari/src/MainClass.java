import java.io.*;
import java.util.ArrayList;

import classi_aiutanti.Inserisci;
import classi_aiutanti.Stampa;

public class MainClass 
{
	static ArrayList<Persona> persone = null;
	
	public static void main(String[] args)
	{
		while(true)
		{
			stampaMenu();
			switch(Inserisci.numero_intero("Inserisci la tua scelta:"))
			{
				case 1:
					persone = riempiArrayList();
					break;
				case 2:
					// Salvo tutto l'arrayList nel file
					if(persone != null)
						scriviNelFile("persona.dat", persone);
					break;
				case 3:
					persone = leggiDalFile("persona.dat");
					break;
				case 4:
					String stringhePersone = "";
					if(persone != null)
					{
						for(Persona p : persone)
							stringhePersone += p.toString();
						Stampa.con_corince(stringhePersone);
					}
					else
						System.out.println("l'arrayList è vuoto");

					break;
				case 5:
					persone.add(new Persona());
					break;
				case 6:
					System.out.println("Grazie per aver usato il mio programma");
					return;
				default: 
					System.out.println("Scelta errata, riprovare");
					break;				
			}
		}
	}
	
	static void stampaMenu()
	{
		
		String menu = "Programma FILE BINARI"
				+ "\n1 - Carica lista persone predefinite nell'array"
				+ "\n2 - Salva array nel file"
				+ "\n3 - Carica Array da file"
				+ "\n4 - Stampa array"
				+ "\n5 - Inserisci persona manualmente"
				+ "\n6 - Esci dal programma";

		Stampa.con_corince(menu);
	}
	
	/*
	 * Questo metodo restituisce un arrayList di esempio
	 */
	static ArrayList<Persona> riempiArrayList()
	{
		// Creiamo il nostro arraylist di persone		
		ArrayList<Persona> persone = new ArrayList<Persona>();
		persone.add(new Persona("Mario", "Rossi", 35));
		persone.add(new Persona("Luisa", "Bianchi", 24));
		persone.add(new Persona("Antonio", "Verdi", 57));
		persone.add(new Persona("Federico", "Esposito", 12));
		persone.add(new Persona("Antonella", "Brambilla", 63));
		persone.add(new Persona("Veronica", "Di Stefano", 78));
		return persone;
	}
	
	/*
	 * Questo metodo scrive un arrayList<Persone> in un file binario
	 */
	static void scriviNelFile(String nomeFile, ArrayList<Persona> persone)
	{
		try  
		{
			// Instanzio l'oggetto che conterrà il file binario
			FileOutputStream f = new FileOutputStream(nomeFile);
			// Instanzio l'oggetto che permetterà la scrittura binaria
			ObjectOutputStream o = new ObjectOutputStream(f);
			// Scrivo la classe
			o.writeObject(persone);
			// Chiudo file e outputstream
			f.close();
			o.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Errore di lettura");
		}
	}
	
	/*
	 * Questo metodo legge un arrayList<Persone> da un file binario
	 */
	static ArrayList<Persona> leggiDalFile(String nomeFile)
	{
		ArrayList<Persona> personeLette = new ArrayList<Persona>();
		try  
		{
			// Instanzio l'oggetto che conterrà il file binario
			FileInputStream f = new FileInputStream(nomeFile);
			// Instanzio l'oggetto che permetterà la lettura binaria
			ObjectInputStream i = new ObjectInputStream(f);
			// Scrivo la classe
			personeLette = (ArrayList<Persona>) i.readObject();
			// Chiudo file e inputstream
			f.close();
			i.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Errore di lettura");
			return null;
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("Classe non trovata nel file");
			return null;
		}
		return personeLette;
	}
}