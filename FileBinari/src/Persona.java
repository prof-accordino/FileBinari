import java.io.Serializable;

import classi_aiutanti.Inserisci;

class Persona implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* 
	 * La costante serialVersionUID dell'interfaccia Serializable
	 * serve solo a fare un controllo di versione
	 * della classe (se un altro programma con una classe
	 * "persona" fatta diversamente importasse questo file
	 * riceverebbe un errore).
	*/
	private String nome;
    private String cognome;
    private int eta;

    public Persona(String nome, String cognome, int eta) 
    {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public Persona() 
    {
        this.nome = Inserisci.stringa("Inserire nome");
        this.cognome = Inserisci.stringa("Inserire cognome");
        this.eta = Inserisci.numero_intero("Inserire età");
    }
    
    @Override
    public String toString() 
    {
        return "Nome: "		+ nome 		+ ", " 	+
               "Cognome: " 	+ cognome 	+ ", " 	+
               "Età: " 		+ eta 		+ "\n";
    }
}