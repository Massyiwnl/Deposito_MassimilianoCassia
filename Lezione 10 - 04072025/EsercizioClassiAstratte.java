import java.util.ArrayList;   
import java.util.Scanner;     

// INTERFACCIA
interface Tracciabile {
    // Definisce un comportamento che permette a un veicolo di essere tracciato tramite un codice tracking
    void tracciaConsegna(String codiceTracking);
}

// CLASSE ASTRATTA: rappresenta un concetto astratto di veicolo per consegne
abstract class VeicoloConsegna {
    protected String targa;          // Ogni veicolo ha una targa (o identificativo)
    protected float caricoMassimo;   // Ogni veicolo ha un limite massimo di carico in kg

    // Costruttore: inizializza targa e carico massimo
    public VeicoloConsegna(String targa, float caricoMassimo) {
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }

    // Metodo concreto: stampa le informazioni generali del veicolo
    public void stampaInfo() {
        System.out.println("Targa/ID: " + targa + ", Carico massimo: " + caricoMassimo + "kg");
    }

    // Metodo astratto: da implementare nelle classi figlie con la logica specifica per la consegna
    public abstract void consegnaPacco(String destinazione, float pesoPacco);
}

// CLASSE CONCRETA: Furgone eredita da VeicoloConsegna e implementa Tracciabile
class Furgone extends VeicoloConsegna implements Tracciabile {
    // Costruttore: richiama quello della classe madre
    public Furgone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    // Implementazione del metodo astratto per la consegna specifica del furgone
    @Override
    public void consegnaPacco(String destinazione, float pesoPacco) {
        if (pesoPacco > caricoMassimo) {
            // Controlla se il pacco è troppo pesante
            System.out.println("Furgone -> Errore: peso pacco (" + pesoPacco + "kg) supera il carico massimo!");
        } else {
            System.out.println("Furgone -> Consegna via strada. Targa " + targa + " -> Destinazione: " + destinazione);
        }
    }

    // Implementazione dell'interfaccia Tracciabile: stampa info sul tracking del furgone
    @Override
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Furgone -> Tracking spedizione (" + codiceTracking + "): In transito su strada.");
    }
}

// CLASSE CONCRETA: Drone eredita da VeicoloConsegna e implementa Tracciabile
class Drone extends VeicoloConsegna implements Tracciabile {
    // Costruttore: richiama quello della classe madre
    public Drone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    // Implementazione del metodo astratto per la consegna specifica del drone
    @Override
    public void consegnaPacco(String destinazione, float pesoPacco) {
        if (pesoPacco > caricoMassimo) {
            System.out.println("Drone -> Peso pacco supera il carico massimo! kg: " + pesoPacco);
        } else {
            System.out.println("Drone -> Consegna partita. Destinazione: " + destinazione + ", identificativo: " + targa);
        }
    }

    // Implementazione dell'interfaccia Tracciabile: tracking automatico via GPS per i droni
    @Override
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Drone -> Tracking automatico: pacco " + codiceTracking + " localizzato via GPS.");
    }
}

// CLASSE: Consegna (gestisce tutte le spedizioni)
class Consegna {
    // Attributo statico per generare codici tracking univoci
    private static int contatore = 1;

    private String codiceTracking;         // Codice tracking generato automaticamente
    private VeicoloConsegna veicolo;       // Veicolo che effettua la spedizione (polimorfismo)
    private String destinazione;           // Destinazione del pacco
    private float pesoPacco;               // Peso del pacco

    // Costruttore: inizializza i campi e genera il tracking code
    public Consegna(VeicoloConsegna veicolo, String destinazione, float pesoPacco) {
        this.veicolo = veicolo;
        this.destinazione = destinazione;
        this.pesoPacco = pesoPacco;
        this.codiceTracking = generaTracking();
    }

    // Metodo privato: genera un codice tracking univoco (es. TRK1, TRK2, ...)
    private String generaTracking() {
        return "TRK" + (contatore++);
    }

    // Getter per il codice tracking
    public String getCodiceTracking() { return codiceTracking; }
    // Getter per il veicolo
    public VeicoloConsegna getVeicolo() { return veicolo; }
    // Getter per la destinazione
    public String getDestinazione() { return destinazione; }
    // Getter per il peso
    public float getPesoPacco() { return pesoPacco; }

    // Metodo per stampare i dettagli della spedizione (tracking, destinazione, veicolo e peso)
    public void stampaDettagli() {
        System.out.println("Codice: " + codiceTracking + " | Destinazione: " + destinazione +
                " | Veicolo: " + veicolo.targa + " | Peso: " + pesoPacco + "kg");
    }
}

// CLASSE PRINCIPALE: contiene il main e il menu interattivo
public class EsercizioClassiAstratte {
    public static void main(String[] args) {
        // Lista di tutti i veicoli inseriti (sia furgoni che droni)
        ArrayList<VeicoloConsegna> veicoli = new ArrayList<>();
        // Lista di tutte le spedizioni effettuate
        ArrayList<Consegna> spedizioni = new ArrayList<>();
        // Scanner per input da tastiera
        Scanner sc = new Scanner(System.in);

        boolean running = true; // Variabile di controllo per il menu

        while (running) { // Ciclo del menu
            System.out.println("\n1. Aggiungi veicolo");
            System.out.println("2. Esegui consegna");
            System.out.println("3. Traccia spedizione");
            System.out.println("4. Stampa info veicoli");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            int scelta = sc.nextInt(); // Legge la scelta dell'utente
            sc.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    // --- AGGIUNTA DI UN NUOVO VEICOLO ---
                    String tipo;
                    // Ciclo per assicurarsi che l'utente scelga solo "furgone" o "drone"
                    while (true) {
                        System.out.print("Tipo veicolo (furgone/drone): ");
                        tipo = sc.nextLine().toLowerCase();
                        if (tipo.equals("furgone") || tipo.equals("drone")) {
                            break;
                        } else {
                            System.out.println("Tipo non valido, riprova.");
                        }
                    }

                    String targa;
                    if (tipo.equals("furgone")) {
                        // Per i furgoni, la targa deve essere in formato AB123CD
                        while (true) {
                            System.out.print("Targa (formato AB123CD): ");
                            targa = sc.nextLine().toUpperCase();
                            if (targa.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")) {
                                break;
                            } else {
                                System.out.println("Targa non valida. Inserisci una targa valida (es. AB123CD):");
                            }
                        }
                    } else { // drone
                        // Per i droni, l'identificativo deve essere solo numerico
                        while (true) {
                            System.out.print("Identificativo drone (solo numeri): ");
                            targa = sc.nextLine();
                            if (targa.matches("\\d+")) {
                                break;
                            } else {
                                System.out.println("Identificativo non valido. Inserisci solo numeri (es. 12345):");
                            }
                        }
                    }

                    // Chiede il carico massimo del veicolo
                    System.out.print("Carico massimo (kg): ");
                    float carico = sc.nextFloat();
                    sc.nextLine();

                    // Aggiunge il veicolo creato alla lista
                    if (tipo.equals("furgone")) {
                        veicoli.add(new Furgone(targa, carico));
                    } else if (tipo.equals("drone")) {
                        veicoli.add(new Drone(targa, carico));
                    }
                    System.out.println("Veicolo aggiunto correttamente!");
                    break;

                case 2:
                    // --- ESECUZIONE DI UNA CONSEGNA ---
                    if (veicoli.size() == 0) {
                        System.out.println("Nessun veicolo registrato.");
                        break;
                    }
                    // Stampa l'elenco di tutti i veicoli disponibili con tipo e targa/ID
                    System.out.println("Elenco veicoli disponibili:");
                    for (int v = 0; v < veicoli.size(); v++) {
                        // Ottengo il tipo concreto del veicolo usando instanceof:
                        // Se il veicolo all'indice v è un oggetto della classe Furgone, assegno la stringa "Furgone".
                        // Altrimenti (unico altro caso nel programma: Drone) assegno "Drone".
                        // L'operatore ternario ? : compatta la scelta tra due alternative.
                        String tipoVeicolo = (veicoli.get(v) instanceof Furgone) ? "Furgone" : "Drone";
                        // Stampo l'indice, il tipo e la targa del veicolo:
                        // Così l'utente vede subito per ogni indice che tipo di veicolo sta selezionando
                        System.out.println("[" + v + "] " + tipoVeicolo + " - " + veicoli.get(v).targa);
                    }
                    System.out.print("Indice veicolo: ");
                    int idxConsegna = sc.nextInt();
                    sc.nextLine();
                    if (idxConsegna < 0 || idxConsegna >= veicoli.size()) {
                        System.out.println("Indice non valido!");
                        break;
                    }
                    System.out.print("Destinazione: ");
                    String dest = sc.nextLine();
                    System.out.print("Peso pacco (kg): ");
                    float peso = sc.nextFloat();
                    sc.nextLine();
                    VeicoloConsegna veicolo = veicoli.get(idxConsegna);
                    // Esegue la consegna tramite il metodo specifico del veicolo (polimorfismo!)
                    veicolo.consegnaPacco(dest, peso);

                    // Registra la spedizione solo se il peso è valido (cioè la consegna è possibile)
                    if (peso <= veicolo.caricoMassimo) {
                        Consegna nuova = new Consegna(veicolo, dest, peso);
                        spedizioni.add(nuova);
                        System.out.println("Spedizione creata! Codice tracking: " + nuova.getCodiceTracking());
                    }
                    break;


                case 3:
                    // --- TRACKING DI UNA SPEDIZIONE ---
                    if (spedizioni.size() == 0) {
                        System.out.println("Nessuna spedizione disponibile.");
                        break;
                    }
                    // Stampa tutte le spedizioni disponibili (con indice)
                    System.out.println("Elenco spedizioni:");
                    for (int j = 0; j < spedizioni.size(); j++) {
                        System.out.print("[" + j + "] ");
                        spedizioni.get(j).stampaDettagli();
                    }
                    System.out.print("Seleziona spedizione da tracciare (indice): ");
                    int idxSped = sc.nextInt();
                    sc.nextLine();
                    if (idxSped < 0 || idxSped >= spedizioni.size()) {
                        System.out.println("Indice non valido!");
                        break;
                    }
                    Consegna spedizione = spedizioni.get(idxSped);
                    // Usa polimorfismo: chiama il metodo di tracking specifico del veicolo che ha effettuato la spedizione
                    ((Tracciabile)spedizione.getVeicolo()).tracciaConsegna(spedizione.getCodiceTracking());
                    break;

                case 4:
                    // --- STAMPA TUTTI I VEICOLI ---
                    if (veicoli.size() == 0) {
                        System.out.println("Nessun veicolo registrato.");
                        break;
                    }
                    int i = 0;
                    for (VeicoloConsegna v : veicoli) {
                        System.out.print("[" + i + "] ");
                        v.stampaInfo();
                        i++;
                    }
                    break;

                case 0:
                    // --- USCITA ---
                    System.out.println("Grazie per aver utilizzato il nostro servizio! ");
                    running = false;
                    break;

                default:
                    // --- GESTIONE SCELTE NON VALIDE ---
                    System.out.println("Scelta non valida!");
            }
        }
        sc.close(); // Chiude lo scanner (buona pratica!)
    }
}
