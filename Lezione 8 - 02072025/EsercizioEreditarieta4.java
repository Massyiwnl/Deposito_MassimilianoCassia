/*
Tema: Missione Spaziale

Classe Base: Astronauta
Ogni oggetto Astronauta dovrà avere:
    - name (String)
    - email (String)
    - creditoOssigeno (float) – inizializzato in modo casuale ogni volta che l’utente accede (login)

Classe Contenitore: StazioneSpaziale
Questa classe rappresenta il contesto in cui operano gli astronauti. Contiene due array:
    - esperimenti – elenco dei nomi degli esperimenti scientifici proposti
    - valutazioni – valutazioni numeriche associate agli esperimenti (interi da 1 a 5)

Classi Derivate:
    - Scienziato – derivata da Astronauta, può aggiungere esperimenti alla stazione
    - Ispettore – derivata da Astronauta, può inserire valutazioni per gli esperimenti

Dopo 3 azioni svolte (aggiunta di esperimenti o valutazioni), le classi evolvono:
    - Scienziato diventa ScienziatoCapo, con la possibilità di stampare tutti gli esperimenti in una sola operazione
    - Ispettore diventa IspettoreEsperto, con la possibilità di stampare tutte le valutazioni

Menu principale:
L’applicazione mostrerà un menu ciclico che consente di:
    1. Creare un nuovo astronauta (inserendo nome ed email)
    2. Visualizzare i dati dell’astronauta
    3. Ripetere il login (rigenera l’ossigeno in modo casuale)
    4. Interagire con il profilo:
        - Se Scienziato: aggiungere esperimenti
        - Se Ispettore: inserire valutazioni
        - Dopo 3 azioni, accedere alle funzioni avanzate
    5. Uscire dal programma

Meccanismo di Identificazione
Per determinare se l’astronauta è un Scienziato o un Ispettore, è possibile utilizzare un input iniziale specifico
(es. una domanda tipo: “Qual è il tuo pianeta preferito?”). La risposta definisce il ruolo.
*/


/*Classe Base: Astronauta
Ogni oggetto Astronauta dovrà avere:
    - name (String)
    - email (String)
    - creditoOssigeno (float) – inizializzato in modo casuale ogni volta che l’utente accede (login) */

import java.util.ArrayList;   
import java.util.List;        // Importa l’interfaccia List (per astrazione delle liste)
import java.util.Random;      // Importa la classe Random (per generare numeri casuali)
import java.util.Scanner;     

/*
 * CLASSE BASE: Astronauta
 * Serve da base per tutte le "tipologie" di astronauti. 
 * Dimostra il concetto di ereditarietà e riuso del codice.
 */
class Astronauta {
    protected String name;             // Nome dell’astronauta, protected: visibile nelle sottoclassi
    protected String email;            // Email dell’astronauta
    protected float creditoOssigeno;   // Quantità di ossigeno a disposizione

    // Costruttore: serve per creare un nuovo oggetto Astronauta con nome ed email
    public Astronauta(String name, String email) {
        this.name = name;              // Assegna il parametro name al campo name
        this.email = email;            // Assegna il parametro email al campo email
        randomOssigeno();              // Chiama randomOssigeno per inizializzare il credito casualmente
    }

    // Metodo per rigenerare (randomizzare) il credito di ossigeno a ogni "login"
    public void randomOssigeno() {
        Random rnd = new Random();     // Crea oggetto Random per generare numeri casuali
        // rnd.nextFloat() restituisce un float tra 0.0 e 1.0
        // Si moltiplica per 50 per avere [0, 50), poi si aggiunge 50 → range [50, 100)
        this.creditoOssigeno = 50 + rnd.nextFloat() * 50;
    }

    // Metodo per visualizzare i dati dell’astronauta a schermo
    public void visualizzaDati() {
        System.out.println("Nome: " + name);                 // Stampa il nome
        System.out.println("Email: " + email);               // Stampa l’email
        System.out.println("Credito Ossigeno: " + creditoOssigeno); // Stampa ossigeno
    }
}

/*
 * CLASSE CONTENITORE: StazioneSpaziale
 * Contiene tutti gli esperimenti scientifici e le relative valutazioni
 * Permette di aggiungere esperimenti e voti (da parte delle sottoclassi)
 */
class StazioneSpaziale {
    private List<String> esperimenti;     // Lista dei nomi degli esperimenti proposti
    private List<Integer> valutazioni;    // Lista delle valutazioni numeriche (uno per esperimento)

    // Costruttore: inizializza le due liste vuote
    public StazioneSpaziale() {
        esperimenti = new ArrayList<>();  // Crea una nuova lista vuota di Stringhe (esperimenti)
        valutazioni = new ArrayList<>();  // Crea una nuova lista vuota di Integer (valutazioni)
    }

    // Metodo per aggiungere un nuovo esperimento scientifico
    public void aggiungiEsperimento(String nomeEsperimento) {
        esperimenti.add(nomeEsperimento); // Aggiunge il nome dell’esperimento alla lista
        valutazioni.add(null);            // Aggiunge un placeholder "null" per la futura valutazione
    }

    // Metodo per assegnare una valutazione a un esperimento
    public void aggiungiValutazione(int indiceEsperimento, int valutazione) {
        // Controlla che l’indice sia valido (l’esperimento esiste)
        if (indiceEsperimento >= 0 && indiceEsperimento < valutazioni.size()) {
            valutazioni.set(indiceEsperimento, valutazione); // Assegna la valutazione all’esperimento
        }
    }

    // Restituisce la lista degli esperimenti
    public List<String> getEsperimenti() {
        return esperimenti;
    }

    // Restituisce la lista delle valutazioni
    public List<Integer> getValutazioni() {
        return valutazioni;
    }

    // Stampa la lista di tutti gli esperimenti disponibili (solo nomi)
    public void stampaEsperimenti() {
        System.out.println("Elenco esperimenti:");
        // Cicla tutta la lista e stampa ogni esperimento con il suo indice (partendo da 1)
        for (int i = 0; i < esperimenti.size(); i++) {
            System.out.println((i + 1) + ". " + esperimenti.get(i));
        }
    }

    // Stampa la lista di tutti gli esperimenti e, se esiste, la relativa valutazione
    public void stampaValutazioni() {
        System.out.println("Elenco valutazioni:");
        // Cicla tutti gli esperimenti
        for (int i = 0; i < esperimenti.size(); i++) {
            String esperimento = esperimenti.get(i);    // Nome esperimento
            Integer valutazione = valutazioni.get(i);   // Valutazione (può essere null)
            // Se valutazione è null, scrive "Non valutato", altrimenti stampa il valore
            String valore = (valutazione == null) ? "Non valutato" : valutazione.toString();
            System.out.println((i + 1) + ". " + esperimento + " - Valutazione: " + valore);
        }
    }
}

/*
 * CLASSE DERIVATA: Scienziato (extends Astronauta)
 * Un tipo di astronauta che può proporre nuovi esperimenti
 */
class Scienziato extends Astronauta {
    private int azioni = 0;    // Tiene il conteggio delle azioni svolte (aggiunta esperimenti)

    // Costruttore: richiama il costruttore della classe base
    public Scienziato(String name, String email) {
        super(name, email);
    }

    // Metodo per aggiungere un esperimento. Restituisce true se raggiunge 3 azioni (per "evoluzione").
    public boolean aggiungiEsperimento(StazioneSpaziale stazione, String esperimento) {
        stazione.aggiungiEsperimento(esperimento); // Chiama il metodo della stazione
        azioni++;                                  // Incrementa il contatore delle azioni
        return azioni >= 3;                        // Restituisce true se l’utente può "evolvere"
    }
}

/*
 * CLASSE DERIVATA: ScienziatoCapo (extends Scienziato)
 * Dopo 3 azioni, il "giocatore" viene promosso a ScienziatoCapo (nuove funzionalità)
 */
class ScienziatoCapo extends Scienziato {
    // Costruttore: richiama il costruttore della classe base
    public ScienziatoCapo(String name, String email) {
        super(name, email);
    }

    // Metodo esclusivo della versione evoluta: stampa tutti gli esperimenti
    public void stampaTuttiEsperimenti(StazioneSpaziale stazione) {
        stazione.stampaEsperimenti();
    }
}

/*
 * CLASSE DERIVATA: Ispettore (extends Astronauta)
 * Un tipo di astronauta che può assegnare valutazioni agli esperimenti
 */
class Ispettore extends Astronauta {
    private int azioni = 0;    // Tiene il conteggio delle azioni svolte (aggiunta valutazioni)

    // Costruttore: richiama il costruttore della classe base
    public Ispettore(String name, String email) {
        super(name, email);
    }

    // Metodo per inserire la valutazione ad un esperimento. Ritorna true se raggiunge 3 azioni (per evolvere)
    public boolean inserisciValutazione(StazioneSpaziale stazione, int indice, int valutazione) {
        stazione.aggiungiValutazione(indice, valutazione); // Chiama il metodo della stazione
        azioni++;                                          // Incrementa il contatore delle azioni
        return azioni >= 3;                                // Restituisce true se può evolvere
    }
}

/*
 * CLASSE DERIVATA: IspettoreEsperto (extends Ispettore)
 * Dopo 3 azioni, l’utente viene promosso a IspettoreEsperto (nuove funzionalità)
 */
class IspettoreEsperto extends Ispettore {
    // Costruttore: richiama il costruttore della classe base
    public IspettoreEsperto(String name, String email) {
        super(name, email);
    }

    // Metodo esclusivo della versione evoluta: stampa tutte le valutazioni
    public void stampaTutteValutazioni(StazioneSpaziale stazione) {
        stazione.stampaValutazioni();
    }
}

/*
 * CLASSE PRINCIPALE: EsercizioEreditarieta4
 * Qui viene gestita tutta la logica di interazione utente, i menu e le sessioni
 */
public class EsercizioEreditarieta4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                // Crea lo scanner per leggere input da tastiera
        StazioneSpaziale stazione = new StazioneSpaziale(); // Crea la stazione spaziale (contenitore dati)
        boolean running = true;                             // Flag per tenere acceso il programma principale

        // --- MENU PRINCIPALE (ciclo finché l’utente non sceglie di uscire) ---
        while (running) {
            System.out.println("\n--- MENU PRINCIPALE ---");    // Stampa il menu principale
            System.out.println("1. Sessione Scienziato");       // Opzione: inizia come scienziato
            System.out.println("2. Sessione Ispettore");        // Opzione: inizia come ispettore
            System.out.println("0. Esci");                      // Opzione: esci dal programma
            System.out.print("Scegli una sessione: ");
            int sessione = -1;
            // --- Gestione sicura dell’input ---
            try {
                sessione = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un valore numerico valido!");
                continue; // Ritorna all’inizio del ciclo
            }

            // Switch-case per selezionare la sessione richiesta
            switch (sessione) {
                case 1:
                    creaScienziato(sc, stazione);   // Inizia la sessione come scienziato
                    break;
                case 2:
                    creaIspettore(sc, stazione);    // Inizia la sessione come ispettore
                    break;
                case 0:
                    running = false;                // Ferma il ciclo (uscita dal programma)
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida."); // Se l’utente digita un numero non previsto
            }
        }
        sc.close(); // Chiude lo scanner a fine programma (buona pratica)
    }

    /*
     * Metodo per gestire la sessione scienziato (login, operazioni, evoluzione)
     */
    public static void creaScienziato(Scanner sc, StazioneSpaziale stazione) {
        System.out.print("Nome Scienziato: ");
        String nome = sc.nextLine();             // Legge il nome
        System.out.print("Email: ");
        String email = sc.nextLine();            // Legge l’email
        Astronauta astronauta = new Scienziato(nome, email); // Crea oggetto Scienziato
        gestisciScienziato(sc, stazione, astronauta);        // Passa all’interfaccia operativa
    }

    /*
     * Metodo per gestire la logica della sessione Scienziato
     * Consente di visualizzare dati, login, aggiungere esperimenti, evolversi a capo, ecc.
     */
    public static void gestisciScienziato(Scanner sc, StazioneSpaziale stazione, Astronauta astronauta) {
        int azioni = 0;             // Tiene il conto delle azioni svolte in questa sessione
        boolean avanzato = false;   // Diventa true se lo scienziato si evolve in ScienziatoCapo
        boolean running = true;     // Flag per ciclo della sessione

        // Ciclo menu sessione scienziato (finché non esci)
        while (running) {
            System.out.println("\n--- SESSIONE SCIENZIATO ---");
            System.out.println("1. Visualizza dati");                    // Visualizza dati dell’astronauta
            System.out.println("2. Login (rigenera ossigeno)");          // Simula il login (ossigeno random)
            System.out.println("3. Aggiungi esperimento");               // Permette di aggiungere un esperimento
            if (avanzato) System.out.println("4. Stampa tutti gli esperimenti"); // Opzione sbloccata se sei ScienziatoCapo
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = -1;
            // --- Gestione sicura dell’input ---
            try {
                scelta = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Devi inserire un numero!");
                continue;
            }

            switch (scelta) {
                case 1:
                    astronauta.visualizzaDati();                         // Visualizza i dati
                    break;
                case 2:
                    astronauta.randomOssigeno();                         // Rigenera l’ossigeno
                    System.out.println("Login effettuato. Ossigeno rigenerato!");
                    break;
                case 3:
                    System.out.print("Nome nuovo esperimento: ");
                    String exp = sc.nextLine();                          // Legge il nome dell’esperimento
                    ((Scienziato) astronauta).aggiungiEsperimento(stazione, exp); // Cast: uso i metodi della sottoclasse Scienziato
                    azioni++;                                            // Incrementa il contatore azioni
                    // Se ha raggiunto 3 azioni ed è ancora “base”, lo faccio evolvere in ScienziatoCapo
                    if (azioni == 3 && !avanzato) {
                        astronauta = new ScienziatoCapo(astronauta.name, astronauta.email); // "Upgrade" del tipo oggetto
                        avanzato = true;                                 // Flag per sbloccare opzioni avanzate
                        System.out.println("Ora sei SCIENZIATO CAPO! Funzione avanzata sbloccata.");
                    }
                    break;
                case 4:
                    if (avanzato) {
                        ((ScienziatoCapo) astronauta).stampaTuttiEsperimenti(stazione); // Funzione avanzata (solo ScienziatoCapo)
                        break;
                    }
                    // Se non è avanzato e seleziona 4, va direttamente a 0 (esce)
                case 0:
                    running = false;                                     // Esce dal ciclo sessione
                    System.out.println("Uscita dalla sessione Scienziato.");
                    break;
                default:
                    System.out.println("Scelta non valida.");            // Se l’input non è tra quelli previsti
            }
        }
    }

    /*
     * Metodo per gestire la sessione ispettore (login, valutazione, evoluzione)
     */
    public static void creaIspettore(Scanner sc, StazioneSpaziale stazione) {
        System.out.print("Nome Ispettore: ");
        String nome = sc.nextLine();             // Leggi il nome
        System.out.print("Email: ");
        String email = sc.nextLine();            // Leggi l’email
        Astronauta astronauta = new Ispettore(nome, email); // Crea oggetto Ispettore
        gestisciIspettore(sc, stazione, astronauta);        // Passa all’interfaccia operativa
    }

    /*
     * Metodo per gestire la logica della sessione Ispettore
     * Consente di visualizzare dati, login, valutare esperimenti, evolversi a esperto, ecc.
     */
    public static void gestisciIspettore(Scanner sc, StazioneSpaziale stazione, Astronauta astronauta) {
        int azioni = 0;             // Tiene il conto delle azioni svolte in questa sessione
        boolean avanzato = false;   // Diventa true se l’ispettore si evolve in IspettoreEsperto
        boolean running = true;     // Flag per ciclo della sessione

        // Ciclo menu sessione ispettore (finché non esci)
        while (running) {
            System.out.println("\n--- SESSIONE ISPETTORE ---");
            System.out.println("1. Visualizza dati");                   // Visualizza dati dell’astronauta
            System.out.println("2. Login (rigenera ossigeno)");         // Simula il login (ossigeno random)
            System.out.println("3. Inserisci valutazione");             // Permette di valutare un esperimento
            if (avanzato) System.out.println("4. Stampa tutte le valutazioni"); // Opzione sbloccata se sei IspettoreEsperto
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = -1;
            // --- Gestione sicura dell’input ---
            try {
                scelta = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Devi inserire un numero!");
                continue;
            }             // Leggi la scelta.  è un metodo statico della classe Integer che prende una String 
                                                                        //(che dovrebbe rappresentare un numero intero, ad esempio "3", "12" ecc.) 
                                                                        //e la trasforma in un numero intero (int).

            switch (scelta) {
                case 1:
                    astronauta.visualizzaDati();                        // Visualizza i dati
                    break;
                case 2:
                    astronauta.randomOssigeno();                        // Rigenera l’ossigeno
                    System.out.println("Login effettuato. Ossigeno rigenerato!");
                    break;
                case 3:
                    // Se non ci sono esperimenti inseriti, mostra un messaggio e termina il case
                    if (stazione.getEsperimenti().isEmpty()) {
                        System.out.println("Non ci sono esperimenti da valutare! Torna quando gli scienziati ne avranno inseriti.");
                        break;
                    }
                    stazione.stampaEsperimenti();                       // Stampa elenco esperimenti
                    System.out.print("Scegli esperimento da valutare (numero): ");
                    int ind = Integer.parseInt(sc.nextLine()) - 1;      // Leggi l’indice scelto (l’utente conta da 1)
                    // Controlla che l’indice sia valido
                    if (ind < 0 || ind >= stazione.getEsperimenti().size()) {
                        System.out.println("Esperimento non valido! Nessuna valutazione inserita.");
                        break;
                    }
                    System.out.print("Valutazione (1-5): ");
                    int val = Integer.parseInt(sc.nextLine());          // Leggi la valutazione (da 1 a 5)
                    // Controlla che la valutazione sia valida
                    if (val < 1 || val > 5) {
                        System.out.println("Valutazione non valida! Inserire un valore tra 1 e 5.");
                        break;
                    }
                    ((Ispettore) astronauta).inserisciValutazione(stazione, ind, val); // Cast per usare il metodo della sottoclasse
                    azioni++;                                             // Incrementa il contatore azioni
                    // Se ha raggiunto 3 azioni ed è ancora “base”, lo faccio evolvere in IspettoreEsperto
                    if (azioni == 3 && !avanzato) {
                        astronauta = new IspettoreEsperto(astronauta.name, astronauta.email); // "Upgrade" del tipo oggetto
                        avanzato = true;                                  // Flag per sbloccare opzioni avanzate
                        System.out.println("Ora sei ISPETTORE ESPERTO! Funzione avanzata sbloccata.");
                    }
                    break;
                case 4:
                    if (avanzato) {
                        ((IspettoreEsperto) astronauta).stampaTutteValutazioni(stazione); // Funzione avanzata (solo IspettoreEsperto)
                        break;
                    }
                    // Se non è avanzato e seleziona 4, va direttamente a 0 (esce)
                case 0:
                    running = false;                                      // Esce dal ciclo sessione
                    System.out.println("Uscita dalla sessione Ispettore.");
                    break;
                default:
                    System.out.println("Scelta non valida.");             // Se l’input non è tra quelli previsti
            }
        }
    }
}
