package classi_aiutanti;

/*
 * Questa classe l'ho creata per facilitare 
 * le operazioni di stampa dei dati
 */
public class Stampa
{
	/*
	 * Questo metodo si limita a stampare i messaggi
	 * aggiungendo una cornice, inutile ma carino
	 */
	public static void con_corince(String messaggio)
	{		
		// Divido la stringa in base alle righe (carattere a capo \n)
		String[] output = messaggio.split("\n");

		// Cerco dimensione della riga più lunga
		int maxStringLength = -1;		
		for(String riga : output)
			maxStringLength = Math.max(maxStringLength, riga.length());		
		
		// Stampo il bordo alto
		System.out.print("+-" +  "-".repeat(maxStringLength)+ "-+\n");
		
		// Stampo il corpo del messaggio
		for(String riga : output)		
			System.out.print("| " + riga +  " ".repeat(maxStringLength - riga.length())+ " |\n");
		
		// Stampo il bordo basso
		System.out.print("+-" +  "-".repeat(maxStringLength)+ "-+\n");
	}
	
	static void stringa(String s)
	{
		System.out.print(s);
	}
}
