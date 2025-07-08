import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//aggiungi try e catch sugli input e fare aggiornare dei dati sugli input

// INTERFACCIA OBSERVER
// rappresenta il contratto che ogni observer deve rispettare. Ogni investitore (observer) deve essere in grado di ricevere notifiche di variazioni di azioni.
interface Investitore {
    void notifica(String azione, double valore); // Metodo chiamato dal Subject per informare di un cambiamento
}

// SUBJECT + SINGLETON - Agenzia Borsa
// Questa classe rappresenta il "subject" nel pattern Observer (ossia la fonte degli eventi).
// Tiene traccia di tutti gli observer e invia notifiche quando qualcosa cambia.
// Implementa anche il Singleton, quindi ne esiste una sola istanza per tutta l'applicazione.
/*perche qui? esiste tipicamente una sola agenzia centrale che gestisce e comunica i cambiamenti di tutte le azioni a tutti gli investitori.
Se ci fossero più istanze di AgenziaBorsa, ogni istanza avrebbe la sua lista di observer e i suoi dati, portando a incoerenze 
(es: alcuni investitori riceverebbero aggiornamenti da una borsa, altri da un’altra. qui ipotizzo che sto utilizzando e modellando quella che è la borsa italiana, non altre borse mondiali).
Invece, con il Singleton, tutti gli observer sono registrati sulla stessa istanza e ricevono sempre le stesse notifiche. */
class AgenziaBorsa {
    // SINGLETON: Istanza unica della classe
    private static AgenziaBorsa instance = null;

    // Lista degli observer registrati (tutti gli investitori che vogliono ricevere notifiche)
    private List<Investitore> investitori = new ArrayList<>();

    // SINGLETON: Costruttore privato (impedisce la creazione diretta di oggetti dall'esterno)
    private AgenziaBorsa() {}

    // SINGLETON: Metodo statico per ottenere l'unica istanza (l'accesso avviene sempre da qui). Garantisce l'accesso globale e unico all'oggetto.
    public static AgenziaBorsa getInstance() {
        if (instance == null) {
            instance = new AgenziaBorsa(); // Se non esiste, crea l'istanza.
        }
        return instance; // Ritorna sempre la stessa istanza.
    }

    // Metodi Observer:
    // Registra un observer nella lista. permette agli observer di "osservare" il subject, ovvero iscriversi alle notifiche.
    public void aggiungiInvestitore(Investitore i) {
        investitori.add(i);
    }

    // Rimuove un observer dalla lista. permette di annullare l'iscrizione alle notifiche ("unsubscribe").
    public void rimuoviInvestitore(Investitore i) {
        investitori.remove(i);
    }

    public List<Investitore> getInvestitori() { //aggiunto questo metodo
        return investitori;
    }

    // Notifica a tutti gli observer un cambiamento. chiama il metodo di notifica per ogni observer registrato, passando i dati dell'evento.
    private void notificaInvestitori(String azione, double valore) {
        for (Investitore i : investitori) {
            i.notifica(azione, valore); // Chiama la notifica su ogni investitore.
        }
    }

    // Cambia il valore di un'azione: aggiorna lo stato e notifica tutti gli observer. simula la variazione di un'azione e la relativa comunicazione a tutti.
    public void aggiornaValoreAzione(String nome, double valore) {
        System.out.println("\n[INFO] Aggiornamento azione " + nome + ": " + valore + "€");
        notificaInvestitori(nome, valore); // Invia la notifica a tutti
    }
}

// IMPLEMENTAZIONE DI UN OBSERVER Investitore Privato
// questa classe rappresenta un tipo concreto di observer. realizza il "contratto" dell'interfaccia Investitore; qui definisci come risponde un investitore privato alla notifica.
class InvestitorePrivato implements Investitore {
    public void notifica(String azione, double valore) {
        System.out.println("Investitore Privato - Nuovo valore per " + azione + ": " + valore + "€");
    }
}

// IMPLEMENTAZIONE DI UN ALTRO OBSERVER Investitore Bancario
// altro observer, ma la reazione è diversa (personalizzabile).
class InvestitoreBancario implements Investitore {
    public void notifica(String azione, double valore) {
        System.out.println("Investitore Bancario - Notifica ricevuta. " + azione + " ora vale " + valore + "€");
    }
}
public class Esercizio2Observer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AgenziaBorsa agenzia = AgenziaBorsa.getInstance();

        Investitore privato = new InvestitorePrivato();
        Investitore bancario = new InvestitoreBancario();

        agenzia.aggiungiInvestitore(privato);
        agenzia.aggiungiInvestitore(bancario);

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Aggiorna valore azione");
            System.out.println("2. Rimuovi investitore privato");
            System.out.println("3. Rimuovi investitore bancario");
            System.out.println("4. Aggiungi investitore privato");
            System.out.println("5. Aggiungi investitore bancario");
            System.out.println("6. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = 0;
            try {
                scelta = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Input non valido! Inserisci un numero.");
                continue;
            }

            switch (scelta) {
                case 1: // Aggiorna valore azione
                    System.out.print("Nome azione: ");
                    String nome = scanner.nextLine();
                    double valore = 0.0;
                    while (true) {
                        System.out.print("Nuovo valore (in euro): ");
                        try {
                            valore = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Errore: inserisci un numero decimale valido (usa il punto per i decimali).");
                        }
                    }
                    agenzia.aggiornaValoreAzione(nome, valore);
                    break;
                case 2: // Rimuovi privato
                    if (!agenzia.getInvestitori().contains(privato)) {
                        System.out.println("Non puoi rimuovere l'investitore privato: non è presente! Devi prima aggiungerlo.");
                    } else {
                        agenzia.rimuoviInvestitore(privato);
                        System.out.println("Investitore privato rimosso.");
                    }
                    break;
                case 3: // Rimuovi bancario
                    if (!agenzia.getInvestitori().contains(bancario)) {
                        System.out.println("Non puoi rimuovere l'investitore bancario: non è presente! Devi prima aggiungerlo.");
                    } else {
                        agenzia.rimuoviInvestitore(bancario);
                        System.out.println("Investitore bancario rimosso.");
                    }
                    break;
                case 4: // Aggiungi privato
                    if (agenzia.getInvestitori().contains(privato)) {
                        System.out.println("Investitore privato già presente!");
                    } else {
                        agenzia.aggiungiInvestitore(privato);
                        System.out.println("Investitore privato aggiunto.");
                    }
                    break;
                case 5: // Aggiungi bancario
                    if (agenzia.getInvestitori().contains(bancario)) {
                        System.out.println("Investitore bancario già presente!");
                    } else {
                        agenzia.aggiungiInvestitore(bancario);
                        System.out.println("Investitore bancario aggiunto.");
                    }
                    break;
                case 6: // Esci
                    running = false;
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
        scanner.close();
    }
}
