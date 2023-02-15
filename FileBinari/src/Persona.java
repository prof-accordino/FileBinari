import java.io.Serializable;

class Persona implements Serializable 
{
	/* 
	 * La costante serialVersionUID dell'interfaccia Serializable
	 * serve solo a fare un controllo di versione
	 * della classe (se un altro programma con una classe
	 * "persona" fatta diversamente importasse questo file
	 * riceverebbe un errore).
	*/
	private static final long serialVersionUID = 1L;
	private String nome;
    private String cognome;
    private int eta;

    public Persona(String nome, String cognome, int eta) 
    {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    @Override
    public String toString() 
    {
        return "Persona{" 		+
                "nome ='" 		+ nome 		+ "', " 	+
                "cognome ='" 	+ cognome 	+ "', " 	+
                "eta =" 		+ eta 		+ '}';
    }
}