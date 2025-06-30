class Auto{
    String marca;
    int anno;
    double prezzo;

    void mostraInfo(){
        System.out.println("Marca: " + marca);
        System.out.println("Anno: " + anno);
        System.out.println("Prezzo: " + prezzo);
    }
}

class Studente{
    String nome;
    static int totaleStudenti = 0; // Variabile statica per tenere traccia del numero totale di studenti

    Studente(String nome) { //costruttore della classe Studente
        // Il costruttore viene chiamato quando si crea un nuovo oggetto Studente
        this.nome = nome; // Inizializza il nome dello studente
        totaleStudenti++; // Incrementa il conteggio degli studenti ogni volta che viene creato un nuovo oggetto Studente
    } 
//metodo per stampare il contatore, senza riportarlo sempre
    static int getTotaleStudenti(){
        return Studente.totaleStudenti; // Restituisce il numero totale di studenti
    }
}

public class EsempioClassi {
    public static void main(String[] args) {
        Auto auto1 = new Auto(); // Creazione di un oggetto Auto
        auto1.marca = "Fiat"; // Assegnazione del valore alla proprietà marca
        auto1.anno = 2020; // Assegnazione del valore alla proprietà anno
        auto1.prezzo = 15000.0; // Assegnazione del valore alla proprietà prezzo

        auto1.mostraInfo(); // Chiamata al metodo mostraInfo per visualizzare le informazioni dell'auto

        Auto auto2 = new Auto(); // Creazione di un altro oggetto Auto
        auto2.marca = "Toyota"; // Assegnazione del valore alla proprietà marca
        auto2.anno = 2021; // Assegnazione del valore alla proprietà anno
        auto2.prezzo = 20000.0; // Assegnazione del valore alla proprietà prezzo

        auto2.mostraInfo(); // Chiamata al metodo mostraInfo per visualizzare le informazioni della seconda auto

        // Creazione di oggetti Studente
        Studente studente1 = new Studente("Alice"); // Creazione di un oggetto Studente con nome "Alice"
        Studente studente2 = new Studente("Bob"); // Creazione di un altro oggetto Studente con nome "Bob"
        Studente studente3 = new Studente("Charlie"); // Creazione di un altro oggetto Studente con nome "Charlie"
        // Stampa del numero totale di studenti creati
        System.out.println("Totale studenti creati: " + Studente.getTotaleStudenti()); // Chiamata al metodo statico getTotaleStudenti per ottenere il numero totale di studenti
        // Il numero totale di studenti è una variabile statica, quindi può essere accessibile senza creare un oggetto Studente
        // In questo caso, Studente.totaleStudenti è accessibile direttamente dalla classe  Studente, senza bisogno di un'istanza specifica.
    }
}
