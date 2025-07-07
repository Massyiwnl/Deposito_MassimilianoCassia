/*
Design pattern ES Singleton
Realizza una classe DatabaseManager che segua il pattern Singleton. La classe deve:
    Avere un costruttore privato e un metodo statico getInstance() che restituisce
    sempre la stessa istanza.
    Simulare una connessione al database con un metodo connect() che:
        Stampi un messaggio del tipo: "Connessione stabilita. Connessioni attive: X"
        Incrementi un contatore interno ogni volta che viene chiamato.
    Fornire un metodo getConnectionCount() che restituisca il numero totale di
    connessioni effettuate.

Nel main:
    Chiama DatabaseManager.getInstance() da più punti del programma simulando diverse
    richieste di connessione.
    Dimostra che l’oggetto utilizzato è sempre lo stesso.
    Stampa il numero totale di connessioni con getConnectionCount().
 */
import java.util.ArrayList;
import java.util.Scanner; 

// Classe che simula la gestione delle connessioni a un database usando il pattern Singleton
class DatabaseManager {
    // Campo statico che contiene l'unica istanza della classe (Singleton)
    private static DatabaseManager instance;
    // ArrayList per simulare le "connessioni" effettuate, qui ogni connessione è rappresentata da una stringa (es. nome utente)
    private ArrayList<String> connessioni = new ArrayList<>();

    // Costruttore privato: impedisce la creazione di oggetti dall'esterno (fondamentale per il Singleton)
    private DatabaseManager() {}

    // Metodo statico pubblico che restituisce l'unica istanza della classe (o la crea se non esiste ancora)
    public static DatabaseManager getInstance() {
        if (instance == null) { // Se l'istanza non esiste ancora
            instance = new DatabaseManager(); // crea la nuova istanza
        }
        return instance; // Restituisce sempre la stessa istanza
    }
     // Metodo per azzerare il singleton (solo per test o casi particolari!)
    public static void resetInstance() {
        instance = null;
    }
    // Simula una connessione al database aggiungendo il nome dell'utente all'ArrayList
    public void connect(String utente) {
        connessioni.add(utente); // Aggiunge l'utente alla lista delle connessioni
        // Stampa un messaggio che mostra chi si è connesso e il numero attuale di connessioni attive
        System.out.println("Connessione stabilita da: " + utente + ". Connessioni attive: " + connessioni.size());
    }

    // Ritorna il numero totale di connessioni effettuate (praticamente la size della lista)
    public int getConnectionCount() {
        return connessioni.size();
    }

    // Mostra a video tutti gli utenti che si sono connessi finora (contenuto dell'ArrayList)
    public void mostraConnessioni() {
        System.out.println("Utenti che si sono connessi: " + connessioni);
    }
}

// Classe di test con il metodo main
public class Esercizio2Singleton {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Variabile che conterrà il riferimento al singleton DatabaseManager
        DatabaseManager db = null;

        // Variabile per memorizzare la scelta dell'utente dal menu
        int scelta = 0;

        // Ciclo do-while per mostrare il menu finché l'utente non sceglie di uscire
        do {
            // Stampa il menu delle operazioni disponibili
            System.out.println("\nCiao, benvenuto nel menù Singleton DatabaseManager! Come posso esserti d'aiuto?");
            System.out.println("1. Crea DatabaseManager");
            System.out.println("2. Usa (connetti un utente)");
            System.out.println("3. Cancella (resetta il singleton)");
            System.out.println("4. Mostra connessioni");
            System.out.println("5. Esci");
            System.out.print("Scegli: ");

            // Prova a leggere la scelta dell'utente (gestione di eventuali errori di input)
            try {
                scelta = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                // Se l'utente inserisce un input non numerico, imposta scelta a 0 (scelta non valida)
                scelta = 0;
            }
            
            //Switch per eseguire la funzione scelta dall'utente
            switch (scelta) {
                //Crea o ottiene l'istanza singleton del DatabaseManager
                case 1:
                    db = DatabaseManager.getInstance(); // getInstance() crea o restituisce l'istanza unica
                    System.out.println("Db creato!");
                    break;

                //Simula una connessione: chiede il nome dell'utente e chiama connect()
                case 2:
                    if (db == null) { // Se il singleton non è stato ancora creato
                        System.out.println("Prima devi creare il DatabaseManager!");
                    } else {
                        System.out.print("Inserisci nome utente da connettere: ");
                        String utente = sc.nextLine();
                        db.connect(utente); // Simula la connessione aggiungendo il nome alla lista
                    }
                    break;

                //Cancella l'istanza singleton (reset) e azzera il riferimento locale
                case 3:
                    DatabaseManager.resetInstance(); // Metodo statico che mette a null la variabile instance
                    db = null; // Azzera anche il riferimento locale
                    System.out.println("Reset istanza");
                    break;

                //Mostra tutte le connessioni simulate e il conteggio totale
                case 4:
                    if (db == null) { // Non puoi vedere le connessioni se il singleton non è stato creato
                        System.out.println("Prima devi creare/ottenere il DatabaseManager!");
                    } else {
                        db.mostraConnessioni(); // Mostra la lista di utenti connessi
                        System.out.println("Numero totale di connessioni: " + db.getConnectionCount());
                    }
                    break;

                //Esci dal programma
                case 5:
                    System.out.println("Ciao!");
                    break;

                //Gestione delle scelte non valide (default)
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (scelta != 5); // Continua finché l'utente non sceglie 5

        sc.close();
    }
}

