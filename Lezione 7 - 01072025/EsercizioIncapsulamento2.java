/*
 * Esercizio: Gestione Flotta di una Compagnia Aerea (Incapsulamento)
Obiettivo: Allenati con l’incapsulamento in Java usando almeno tre classi collegate tra loro nel dominio dell’aeronautica.

Traccia:
Crea queste tre classi:
Aereo
    Attributi privati:
    modello (String)
    numeroPosti (int)
    codice (String, identificativo dell’aereo)
    Getter e setter per tutti gli attributi (il setter di numeroPosti deve accettare solo valori positivi).

Pilota
    Attributi privati:
    nome (String)
    numeroBrevetto (String)
    oreVolo (int)
    Getter e setter per tutti gli attributi (il setter di oreVolo deve accettare solo valori maggiori di zero).

CompagniaAerea
    Attributi privati:
    nome (String)
    flotta (ArrayList di oggetti Aereo)
    piloti (ArrayList di oggetti Pilota)
    
    Metodo per aggiungere un aereo alla flotta.
    Metodo per aggiungere un pilota.
    Metodo per stampare tutte le informazioni sulla flotta e i piloti della compagnia.

Obblighi minimi:
Crea almeno due aerei e due piloti e aggiungili alla compagnia aerea.
Stampa a schermo le informazioni della compagnia, mostrando dati di aerei e piloti.
 */
import java.util.ArrayList;
import java.util.Scanner;

class Aereo {
    private String modello;
    private int numeroPosti;
    private String codice;
    private Pilota pilota; // Associazione con la classe Pilota, perchè un aereo ha un pilota.
    // Mettiamo private Pilota pilota; per modellare il legame tra aereo e pilota. 
    //corretto per esprimere che un oggetto (l'aereo) "contiene" o è "associato" a un altro oggetto (il pilota).
   // consigliato quando le classi devono collaborare tra loro

    public Aereo(String modello, int numeroPosti, String codice, Pilota pilota) { // Costruttore della classe Aereo
        this.modello = modello;
        setNumeroPosti(numeroPosti); // Usa il setter per garantire che il numero di posti sia positivo
        this.codice = codice;
        this.pilota = pilota;
    }

    public String getModello() { // Metodo getter per il modello dell'aereo, dove il get restituisce il valore dell'attributo privato modello
        return modello;
    }
    public void setModello(String modello) { // Metodo setter per il modello dell'aereo, dove il set imposta il valore dell'attributo privato modello
        this.modello = modello;
    }
    public int getNumeroPosti() {
        return numeroPosti;
    }
    public void setNumeroPosti(int numeroPosti) { // Metodo setter per il numero di posti dell'aereo, dove il set imposta il valore dell'attributo privato numeroPosti
        // Controlla che il numero di posti sia positivo
        if (numeroPosti > 0) {
            this.numeroPosti = numeroPosti;
        } else {
            System.out.println("Errore: il numero di posti deve essere positivo.");
        }
    }
    public String getCodice() {
        return codice;
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }
    public Pilota getPilota() {
        return pilota;
    }
    public void setPilota(Pilota pilota) {
        this.pilota = pilota;
    }
}

class Pilota {
    private String nome; // Attributo privato nome del pilota
    private String numeroBrevetto; // Attributo privato numero di brevetto del pilota
    private int oreVolo; // Attributo privato ore di volo del pilota

    public Pilota(String nome, String numeroBrevetto, int oreVolo) { // Costruttore della classe Pilota
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        setOreVolo(oreVolo); // Usa il setter per garantire che le ore di volo siano maggiori di zero
    }

    public String getNome() {
        return nome;
    }
    public String getNumeroBrevetto() {
        return numeroBrevetto;
    }
    public int getOreVolo() {
        return oreVolo;
    }
    public void setOreVolo(int oreVolo) { // Metodo setter per le ore di volo del pilota, dove il set imposta il valore dell'attributo privato oreVolo
        // Controlla che le ore di volo siano maggiori di zero
        if (oreVolo > 0) {
            this.oreVolo = oreVolo;
        } else {
            System.out.println("Errore: le ore di volo devono essere maggiori di zero.");
        }
    }
}

class CompagniaAerea {
    private String nome; // Attributo privato nome della compagnia aerea
    private ArrayList<Aereo> flotta; // Attributo privato flotta che contiene una lista di oggetti Aereo
    private ArrayList<Pilota> piloti; // Attributo privato piloti che contiene una lista di oggetti Pilota

    public CompagniaAerea(String nome) {
        this.nome = nome;
        this.flotta = new ArrayList<>(); // Inizializza la flotta come un ArrayList vuoto
        this.piloti = new ArrayList<>(); // Inizializza i piloti come un ArrayList vuoto
    }

    public void aggiungiPilota(Pilota pilota) { // Metodo per aggiungere un pilota alla compagnia aerea
        piloti.add(pilota);
    }

    public void aggiungiAereo(Aereo aereo) { // Metodo per aggiungere un aereo alla flotta della compagnia aerea
        flotta.add(aereo);
    }

    public void stampaInformazioni() { // Metodo per stampare le informazioni della compagnia aerea, della flotta e dei piloti
        System.out.println("\nCompagnia Aerea: " + nome);

        System.out.println("\n--- Piloti Registrati ---");
        for (Pilota pilota : piloti) {
            System.out.println("- Nome: " + pilota.getNome() + ", Numero Brevetto: " + pilota.getNumeroBrevetto() + ", Ore di volo: " + pilota.getOreVolo());
        }

        System.out.println("\n--- Flotta di Aerei ---");
        for (Aereo aereo : flotta) {
            System.out.println("- Modello: " + aereo.getModello() + ", Numero Posti: " + aereo.getNumeroPosti() + ", Codice: " + aereo.getCodice());
            System.out.println("  Pilota Associato: " + aereo.getPilota().getNome() + " (Brevetto: " + aereo.getPilota().getNumeroBrevetto() + ")");
        }
    }

    public ArrayList<Pilota> getPiloti() { // Metodo per ottenere la lista dei piloti della compagnia aerea
        return piloti;
    }
}

public class EsercizioIncapsulamento2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il nome della compagnia aerea: ");
        String nomeCompagnia = scanner.nextLine();

        CompagniaAerea compagnia = new CompagniaAerea(nomeCompagnia);

        // Inserimento dei piloti
        int contatorePiloti = 0; // Contatore per tenere traccia del numero di piloti inseriti
        String risposta;

        do {
            System.out.println("\nInserisci i dati del pilota " + (contatorePiloti + 1) + ":");
            System.out.print("Nome: ");
            String nomePilota = scanner.nextLine();

            System.out.print("Numero brevetto: ");
            String numeroBrevetto = scanner.nextLine();

            System.out.print("Ore di volo: ");
            int oreVolo = scanner.nextInt();
            scanner.nextLine(); // Consuma newline

            Pilota pilota = new Pilota(nomePilota, numeroBrevetto, oreVolo);
            compagnia.aggiungiPilota(pilota);

            contatorePiloti++; // Incrementa il contatore dei piloti inseriti

            if (contatorePiloti >= 2) { // Se sono stati inseriti almeno 2 piloti, chiede se si vuole aggiungerne un altro
                System.out.print("\nVuoi aggiungere un altro pilota? (s/n): ");
                risposta = scanner.nextLine();
            } else {
                risposta = "s"; // Almeno 2 piloti obbligatori
            }

        } while (risposta.equalsIgnoreCase("s")); // Continua a chiedere finché l'utente risponde "s"

        // Inserimento degli aerei
        int contatoreAerei = 0; // Contatore per tenere traccia del numero di aerei inseriti

        do {
            System.out.println("\nInserisci i dati dell'aereo " + (contatoreAerei + 1) + ":");
            System.out.print("Modello: ");
            String modello = scanner.nextLine();

            System.out.print("Numero posti: ");
            int numeroPosti = scanner.nextInt();
            scanner.nextLine(); // Consuma newline

            System.out.print("Codice identificativo: ");
            String codice = scanner.nextLine();

            // Mostra elenco piloti per scegliere chi associare
            System.out.println("\nScegli il pilota da associare all'aereo:");
            ArrayList<Pilota> pilotiDisponibili = compagnia.getPiloti();  //lo faccio perchè voglio usare il metodo getPiloti della classe CompagniaAerea per ottenere la lista dei piloti
            for (int i = 0; i < pilotiDisponibili.size(); i++) { // Stampa l'elenco dei piloti disponibili
                System.out.println((i + 1) + ") " + pilotiDisponibili.get(i).getNome() + " (Brevetto: " + pilotiDisponibili.get(i).getNumeroBrevetto() + ")");
            }

            int sceltaPilota;
            do {
                System.out.print("Inserisci il numero corrispondente al pilota: "); // Chiede all'utente di inserire il numero corrispondente al pilota scelto
                sceltaPilota = scanner.nextInt();
                scanner.nextLine(); // Consuma newline
                //Se la scelta non è valida, richiede di inserire un numero valido
            } while (sceltaPilota < 1 || sceltaPilota > pilotiDisponibili.size()); // Controlla che la scelta sia valida

            Pilota pilotaSelezionato = pilotiDisponibili.get(sceltaPilota - 1); // Ottiene il pilota selezionato in base alla scelta dell'utente. Prende la posizione scelta dall'utente (sceltaPilota - 1) dalla lista dei piloti disponibili.
            // Esempio: se l'utente sceglie 1, prende il primo pilota della lista perchè gli indici degli array partono da 0.   
            Aereo aereo = new Aereo(modello, numeroPosti, codice, pilotaSelezionato);
            compagnia.aggiungiAereo(aereo);

            contatoreAerei++;

            if (contatoreAerei >= 2) { // Se sono stati inseriti almeno 2 aerei, chiede se si vuole aggiungerne un altro    
                System.out.print("\nVuoi aggiungere un altro aereo? (s/n): ");
                risposta = scanner.nextLine();
            } else {
                risposta = "s"; // Almeno 2 aerei obbligatori
            }

        } while (risposta.equalsIgnoreCase("s"));

        compagnia.stampaInformazioni();
    }
}
