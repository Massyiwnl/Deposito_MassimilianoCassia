import java.util.Scanner; // Importa la classe Scanner per leggere input da tastiera

// ===================== SOTTOSISTEMI =====================
class Bios2 {
    // Metodo per simulare l'inizializzazione del BIOS
    public void inizializza(){ 
        System.out.println("[BIOS] Inizializzazione in corso..."); 
    }
    // Metodo per simulare il caricamento del BIOS
    public void carica(){ 
        System.out.println("[BIOS] Caricamento in corso..."); 
    }
    // Metodo per simulare l'avvio del BIOS
    public void avvia(){ 
        System.out.println("[BIOS] Avvio in corso..."); 
    }
}

class HardDisk2 {
    // Metodo per simulare l'inizializzazione dell'Hard Disk
    public void inizializza(){ 
        System.out.println("[HardDisk] Inizializzazione in corso..."); 
    }
    // Metodo per simulare il caricamento dell'Hard Disk
    public void carica(){ 
        System.out.println("[HardDisk] Caricamento in corso..."); 
    }
    // Metodo per simulare l'avvio dell'Hard Disk
    public void avvia(){ 
        System.out.println("[HardDisk] Avvio in corso..."); 
    }
}

class SistemaOperativo2 {
    // Metodo per simulare l'inizializzazione del Sistema Operativo
    public void inizializza(){ 
        System.out.println("[SO] Inizializzazione in corso..."); 
    }
    // Metodo per simulare il caricamento del Sistema Operativo
    public void carica(){ 
        System.out.println("[SO] Caricamento in corso..."); 
    }
    // Metodo per simulare l'avvio del Sistema Operativo
    public void avvia(){ 
        System.out.println("[SO] Avvio in corso..."); 
    }
}

// ===================== STRATEGY PATTERN =====================

// Interfaccia per la strategia di avvio
interface AvvioStrategy2 {
    // Metodo da implementare per definire la sequenza di avvio
    void avvia(Bios2 bios, HardDisk2 hd, SistemaOperativo2 so);
}

// Strategia concreta: Avvio Normale
class AvvioNormale2 implements AvvioStrategy2 {
    @Override
    public void avvia(Bios2 bios, HardDisk2 hd, SistemaOperativo2 so) {
        System.out.println("== Avvio Normale ==");
        // Avvia BIOS, HardDisk e Sistema Operativo in sequenza normale
        bios.inizializza(); bios.carica(); bios.avvia();
        hd.inizializza();   hd.carica();   hd.avvia();
        so.inizializza();   so.carica();   so.avvia();
        System.out.println("== Computer avviato normalmente! ==");
    }
}

// Strategia concreta: Avvio Sicuro
class AvvioSicuro2 implements AvvioStrategy2 {
    @Override
    public void avvia(Bios2 bios, HardDisk2 hd, SistemaOperativo2 so) {
        System.out.println("== Avvio Sicuro ==");
        // Avvia BIOS, inizializza e carica HardDisk ma NON lo avvia completamente
        bios.inizializza(); 
        bios.carica(); 
        bios.avvia();
        hd.inizializza();   
        hd.carica();   // Non esegue hd.avvia();
        so.inizializza();   
        so.carica();   
        so.avvia();
        System.out.println("== Computer avviato in modalità sicura! ==");
    }
}

// Classe Facade (gestisce l'avvio del computer nascondendo la complessità dei sottosistemi)
// Implementa anche il Singleton: una sola istanza per tutta l'applicazione
class ComputerFacade2 {
    private static ComputerFacade2 instance; // Riferimento statico all'unica istanza
    private Bios2 bios;
    private HardDisk2 hd;
    private SistemaOperativo2 so;
    private AvvioStrategy2 strategy; // Strategy pattern: permette di cambiare modalità di avvio

    // Costruttore privato per Singleton: impedisce la creazione diretta di oggetti
    private ComputerFacade2() {
        bios = new Bios2();
        hd = new HardDisk2();
        so = new SistemaOperativo2();
        strategy = new AvvioNormale2(); // Strategia di default: avvio normale
    }

    // Metodo statico per ottenere l'unica istanza della Facade (Singleton)
    public static ComputerFacade2 getInstance() {
        if (instance == null) {
            instance = new ComputerFacade2();
        }
        return instance;
    }

    // Permette di cambiare la strategia di avvio a runtime
    public void setStrategy(AvvioStrategy2 strategy) {
        this.strategy = strategy;
    }

    // Metodo Facade: avvia il computer secondo la strategia scelta
    public void accendiComputer() {
        strategy.avvia(bios, hd, so);
    }
}

// Classe Main che gestisce il menu di scelta per la modalità di avvio
public class Esercizio2FacadeVersione2 {
    public static void main(String[] args) {
        ComputerFacade2 computer = ComputerFacade2.getInstance(); // Ottiene l'istanza Singleton della Facade
        Scanner scanner = new Scanner(System.in); // Scanner per input utente

        while (true) { // Ciclo infinito finché non si sceglie di uscire
            System.out.println("\nScegli una delle tre opzioni");
            System.out.println("1. Avvio Normale");
            System.out.println("2. Avvio Sicuro");
            System.out.println("3. Esci");
            System.out.print("-> ");
            String scelta = scanner.nextLine(); // Legge la scelta utente

            switch (scelta) {
                case "1": // Avvio normale
                    computer.setStrategy(new AvvioNormale2());
                    computer.accendiComputer();
                    break;
                case "2": // Avvio sicuro
                    computer.setStrategy(new AvvioSicuro2());
                    computer.accendiComputer();
                    break;
                case "3": // Esci dal programma
                    System.out.println("Uscita dal programma.");
                    scanner.close();
                    return; // Termina il main (quindi il programma)
                default: // Caso di input non valido
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}
