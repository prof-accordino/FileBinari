import java.io.*;

public class MainClass 
{
    public static void main(String[] args)
    {
    	/*
    	 * !!! SCRITTURA !!!
    	 */
        Persona persona = new Persona("Mario", "Rossi", 35);

        try  
        {
            // Instanzio l'oggetto che conterrà il file binario
        	FileOutputStream f = new FileOutputStream("persona.dat");
            // Instanzio l'oggetto che permetterà la scrittura binaria
        	ObjectOutputStream o = new ObjectOutputStream(f);
        	// Scrivo la classe
            o.writeObject(persona);
            // Chiudo file e outputstream
            f.close();
            o.close();
        } 
        catch (IOException e) 
        {
        	System.out.println("Errore di lettura");
        }

    	/*
    	 * !!! LETTURA !!!
    	 */
        
        // Leggiamo l'oggetto dal file
        Persona personaLetta = null;        
        try  
        {
            // Instanzio l'oggetto che conterrà il file binario
        	FileInputStream f = new FileInputStream("persona.dat");
            // Instanzio l'oggetto che permetterà la lettura binaria
        	ObjectInputStream i = new ObjectInputStream(f);
        	// Scrivo la classe
        	personaLetta = (Persona) i.readObject();
            // Chiudo file e inputstream
            f.close();
            i.close();
        } 
        catch (IOException e) 
        {
        	System.out.println("Errore di lettura");
        }
        catch (ClassNotFoundException e) 
        {
        	System.out.println("Classe non trovata nel file");
        }

        // Stampiamo l'oggetto letto dal file
        System.out.println(personaLetta);
    }
}