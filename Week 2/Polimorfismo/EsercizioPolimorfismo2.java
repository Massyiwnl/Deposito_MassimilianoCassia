import java.util.ArrayList;  
import java.util.Scanner;    

// Classe base Hamburger (definisce il concetto generico di panino)
class Hamburger {
    protected String nome;    // Nome del panino (accessibile alle sottoclassi)

    // Costruttore: imposta il nome del panino
    public Hamburger(String nome) {
        this.nome = nome;
    }

    // Metodo getter per ottenere il nome del panino
    public String getNome() {
        return nome;
    }

    // Metodo da sovrascrivere nelle sottoclassi: stampa come si prepara il panino
    public void prepara() {
        System.out.println("Preparazione panino base...");
    }
}

// Sottoclasse Cheeseburger (specializzazione di Hamburger)
class Cheeseburger extends Hamburger {
    // Costruttore: chiama quello della superclasse con il nome giusto
    public Cheeseburger() {
        super("Cheeseburger");
    }

    // stampa il procedimento specifico per il Cheeseburger
    @Override
    public void prepara() {
        System.out.println("Preparazione Cheeseburger: pane, carne, formaggio, ketchup");
    }
}

// Sottoclasse VegBurger
class VegBurger extends Hamburger {
    public VegBurger() {
        super("VegBurger");
    }

    // stampa il procedimento specifico per il VegBurger
    @Override
    public void prepara() {
        System.out.println("Preparazione VegBurger: pane integrale, burger vegetale, insalata, pomodoro");
    }
}

// Sottoclasse DoubleBacon
class DoubleBacon extends Hamburger {
    public DoubleBacon() {
        super("DoubleBacon");
    }

    // stampa il procedimento specifico per il DoubleBacon
    @Override
    public void prepara() {
        System.out.println("Preparazione DoubleBacon: pane, doppia carne, bacon, cheddar, maionese");
    }
}

// Sottoclasse PaninoPersonalizzato (per creare panini con ingredienti scelti dall'utente)
class PaninoPersonalizzato extends Hamburger {
    private ArrayList<String> ingredienti; // Lista degli ingredienti scelti dall’utente

    // Costruttore: imposta il nome fisso e la lista ingredienti scelta
    public PaninoPersonalizzato(ArrayList<String> ingredienti) {
        super("Panino Personalizzato");
        this.ingredienti = ingredienti;
    }

    // stampa tutti gli ingredienti scelti dall’utente
    @Override
    public void prepara() {
        System.out.print("Preparazione Panino Personalizzato: ");
        for (int i = 0; i < ingredienti.size(); i++) {
            System.out.print(ingredienti.get(i)); // Stampa l’ingrediente
            if (i < ingredienti.size() - 1) System.out.print(", "); // Aggiungi virgola se non è l’ultimo
        }
        System.out.println(); // Vai a capo dopo l’elenco
    }
}

// Classe principale con il main: gestisce l’intero flusso del programma
public class EsercizioPolimorfismo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);         // Crea Scanner per leggere input da tastiera
        ArrayList<Hamburger> ordini = new ArrayList<>();  // Lista dinamica dove si salvano tutti gli ordini

        boolean continua = true; // Variabile di controllo per il ciclo principale del menu
        while (continua) {       // Ciclo principale che gestisce il menu finché l’utente non esce
            System.out.println("\n--- Benvenuto in Hamburgheria! ---");
            System.out.println("1. Nuovo ordine");                             // Opzione per aggiungere un nuovo panino
            System.out.println("2. Visualizza ordini e prepara panini");       // Opzione per vedere e preparare tutti i panini ordinati
            System.out.println("3. Esci");                                     // Opzione per uscire dal programma
            System.out.print("Scegli un'opzione: ");                          // Prompt per la scelta

            int scelta = scanner.nextInt(); // Legge la scelta dell’utente (intero)
            scanner.nextLine();             // Consuma il carattere di newline rimasto dopo nextInt()

            switch (scelta) {               // Switch sulla scelta dell’utente
                case 1:
                    // Case 1: aggiunta di un nuovo ordine
                    System.out.println("\nQuale panino desideri?");
                    System.out.println("1. Cheeseburger");
                    System.out.println("2. VegBurger");
                    System.out.println("3. DoubleBacon");
                    System.out.println("4. Panino Personalizzato"); // Opzione per il panino custom
                    System.out.print("Scegli il numero del panino: ");
                    int panino = scanner.nextInt();    // Legge la scelta del panino
                    scanner.nextLine();                // Consuma newline

                    Hamburger ordine = null;           // Variabile temporanea per il nuovo ordine

                    // Crea l’oggetto del panino scelto
                    if (panino == 1) {
                        ordine = new Cheeseburger();   // Crea un Cheeseburger
                    } else if (panino == 2) {
                        ordine = new VegBurger();      // Crea un VegBurger
                    } else if (panino == 3) {
                        ordine = new DoubleBacon();    // Crea un DoubleBacon
                    } else if (panino == 4) {
                        // Procedura per scegliere gli ingredienti del panino personalizzato
                        ArrayList<String> listaIngredienti = new ArrayList<>();
                        // Lista predefinita degli ingredienti disponibili
                        String[] ingredientiDisponibili = {"pane", "carne", "pollo", "formaggio", "cheddar", "insalata", "pomodoro", "cipolla", "ketchup", "maionese", "bacon", "uovo", "salsa BBQ", "verdure grigliate"};

                        // Mostra all’utente la lista di ingredienti disponibili
                        System.out.println("Ingredienti disponibili:");
                        for (int i = 0; i < ingredientiDisponibili.length; i++) {
                            System.out.println((i+1) + ". " + ingredientiDisponibili[i]);
                        }
                        boolean aggiungi = true;      // Controlla se continuare ad aggiungere ingredienti
                        while (aggiungi) {
                            System.out.print("Scegli l'ingrediente (numero) o 0 per terminare: ");
                            int ingr = scanner.nextInt();  // Legge la scelta ingrediente
                            scanner.nextLine();
                            if (ingr > 0 && ingr <= ingredientiDisponibili.length) {
                                listaIngredienti.add(ingredientiDisponibili[ingr - 1]); // Aggiungi ingrediente scelto
                                System.out.println("Aggiunto: " + ingredientiDisponibili[ingr - 1]);
                            } else if (ingr == 0) {
                                aggiungi = false; // Termina la scelta degli ingredienti
                            } else {
                                System.out.println("Scelta non valida."); // Gestisce scelte errate
                            }
                        }
                        if (listaIngredienti.isEmpty()) { // Se non è stato scelto alcun ingrediente
                            System.out.println("Non hai scelto nessun ingrediente, panino non creato.");
                            break; // Esci dal case senza creare il panino
                        }
                        // Crea il panino personalizzato con gli ingredienti scelti
                        ordine = new PaninoPersonalizzato(listaIngredienti);
                    } else {
                        System.out.println("Scelta non valida!"); // Gestisce scelta non valida
                        break;
                    }
                    ordini.add(ordine); // Aggiunge il nuovo panino alla lista degli ordini
                    System.out.println("Hai ordinato un " + ordine.getNome() + "!");
                    break;

                case 2:
                    // Case 2: visualizza tutti gli ordini correnti e li prepara (POLIMORFISMO)
                    if (ordini.isEmpty()) { // Se non ci sono panini in lista
                        System.out.println("Nessun panino ordinato!");
                    } else {
                        System.out.println("\nPreparazione degli ordini:");
                        // Scorre la lista dei panini ordinati e li prepara
                        for (Hamburger h : ordini) {
                            System.out.print(h.getNome() + ": ");
                            h.prepara(); // Chiamata polimorfica: esegue il metodo specifico della sottoclasse
                        }
                        ordini.clear(); // Svuota la lista degli ordini dopo averli preparati
                    }
                    break;

                case 3:
                    // Case 3: esci dal programma
                    continua = false; // Imposta la variabile per uscire dal ciclo while
                    System.out.println("Grazie e arrivederci!");
                    break;

                default:
                    // Gestione scelte non valide
                    System.out.println("Scelta non valida, riprova!");
            }
        }
        scanner.close(); // Chiude lo Scanner (buona norma per evitare warning)
    }
}
