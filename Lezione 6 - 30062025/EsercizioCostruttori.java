// Creare una classe persona con un costruttore
class Persona {
    String nome;
    int eta;
    String citta;

    // Costruttore della classe Persona
    //il costruttore è senza parametri, predefinito, o personalizzato? 
    // In questo caso, il costruttore è personalizzato perché accetta due parametri: nome ed eta, però 
    // la città non è passata come parametro, quindi viene inizializzata con un valore predefinito. Può comunque essere modificata successivamente.
    Persona(String nome, int eta) {
        this.nome = nome; // Inizializza il nome della persona
        this.eta = eta;   // Inizializza l'età della persona
        this.citta = "Non specificata"; // Inizializza la città con un valore predefinito, perchè non è stato passato come parametro 
        // Il costruttore viene chiamato quando si crea un nuovo oggetto Persona
    }

    // Metodo per visualizzare le informazioni della persona
    void mostraInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Età: " + eta);
        System.out.println("Città: " + citta);
    }

    // Faccio un metodo per modificare la città
    void setCitta(String citta) {
        this.citta = citta; // Imposta la città della persona
    }
}

public class EsercizioCostruttori {
    public static void main(String[] args) {
        // Creazione di un oggetto Persona utilizzando il costruttore
        Persona persona1 = new Persona("Mario", 30); // Crea un oggetto Persona con nome "Mario" e età 30
        persona1.mostraInfo(); // Chiamata al metodo per visualizzare le informazioni della persona

        // Creazione di un altro oggetto Persona
        Persona persona2 = new Persona("Luigi", 25); // Crea un altro oggetto Persona con nome "Luigi" e età 25
        persona2.setCitta("Roma"); // Modifica la città della seconda persona a "Roma"
        persona2.mostraInfo(); // Visualizza le informazioni del secondo oggetto
    }
    
}
