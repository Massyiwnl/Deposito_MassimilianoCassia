/*
Esercizio 3: App di Fitness con Monitoraggio Stato Utente

Implementa un'app che cambia comportamento a seconda dello stato
fisico dell'utente (riposo, allenamento, recupero).

Usa State per cambiare il comportamento in base allo stato.

Usa Singleton per gestire un'unica istanza del profilo utente.
 */
// Utilizza State per cambiare comportamento dinamicamente in base allo stato fisico
// Utilizza Singleton per gestire l'unico profilo utente dell'app

import java.util.Scanner;

// INTERFACCIA DEL PATTERN STATE
// Definisce le azioni possibili in ogni stato dell'utente
interface StatoFisico {
    void monitoraggio();           // Azione da compiere durante il monitoraggio
    String getNomeStato();         // Ritorna il nome dello stato corrente (utile per stampa)
}

// STATO: RIPOSO
class StatoRiposo implements StatoFisico {
    @Override
    public void monitoraggio() {
        // Comportamento specifico durante il riposo
        System.out.println("Stato: RIPOSO. Frequenza cardiaca e sonno monitorati.");
        System.out.println("Consiglio: Approfitta del riposo per recuperare energia.");
    }
    @Override
    public String getNomeStato() {
        return "Riposo";
    }
}

// STATO: ALLENAMENTO
class StatoAllenamento implements StatoFisico {
    @Override
    public void monitoraggio() {
        // Comportamento specifico durante l'allenamento
        System.out.println("Stato: ALLENAMENTO. Calorie bruciate e battito monitorati.");
        System.out.println("Consiglio: Tieni alto il ritmo e idratati!");
    }
    @Override
    public String getNomeStato() {
        return "Allenamento";
    }
}

// STATO: RECUPERO
class StatoRecupero implements StatoFisico {
    @Override
    public void monitoraggio() {
        // Comportamento specifico durante il recupero dopo uno sforzo
        System.out.println("Stato: RECUPERO. Analisi tempi di recupero e stretching consigliato.");
        System.out.println("Consiglio: Esegui esercizi di stretching e respira profondamente.");
    }
    @Override
    public String getNomeStato() {
        return "Recupero";
    }
}

// SINGLETON: PROFILO UTENTE
// Esiste una sola istanza di questa classe (utente loggato nell'app)
class ProfiloUtente {
    private static ProfiloUtente istanza;       // Attributo statico per la singola istanza (Singleton)
    private String nome;
    private int eta;
    private StatoFisico statoAttuale;           // Riferimento allo stato corrente (State pattern)

    // Costruttore privato: non può essere istanziato da fuori
    private ProfiloUtente(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
        this.statoAttuale = new StatoRiposo();  // Stato iniziale: riposo
    }

    // Metodo pubblico statico: crea o restituisce l'unica istanza
    public static ProfiloUtente getIstanza(String nome, int eta) {
        if (istanza == null) {
            istanza = new ProfiloUtente(nome, eta);
        }
        return istanza;
    }

    // Getter per l'istanza esistente (senza crearne di nuove)
    public static ProfiloUtente getIstanza() {
        return istanza;
    }

    // Cambia lo stato fisico dell'utente (State pattern)
    public void setStato(StatoFisico nuovoStato) {
        this.statoAttuale = nuovoStato;
    }

    // Esegue il monitoraggio, che cambia comportamento in base allo stato
    public void monitora() {
        System.out.println("\n--- Monitoraggio Utente ---");
        System.out.println("Utente: " + nome + ", Età: " + eta);
        System.out.println("Stato corrente: " + statoAttuale.getNomeStato());
        statoAttuale.monitoraggio();     // Qui viene applicato il pattern State!
        System.out.println("--------------------------\n");
    }

    // Mostra i dati del profilo utente
    public void mostraProfilo() {
        System.out.println("\n--- Profilo Utente ---");
        System.out.println("Nome: " + nome);
        System.out.println("Età: " + eta);
        System.out.println("Stato corrente: " + statoAttuale.getNomeStato());
        System.out.println("----------------------\n");
    }
}

// MAIN: App con Menu e interazione utente
public class Esercizio3Recap {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Chiede dati all'utente una sola volta, poi crea la Singleton
        System.out.println("Benvenuto nell'App Fitness!");
        System.out.print("Inserisci il tuo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci la tua età: ");
        int eta = Integer.parseInt(scanner.nextLine());

        // Crea il profilo utente Singleton
        ProfiloUtente utente = ProfiloUtente.getIstanza(nome, eta);

        boolean continua = true;
        while (continua) {
            mostraMenu();
            int scelta = leggiInt("Scegli un'opzione: ");

            switch (scelta) {
                case 1 -> utente.mostraProfilo();      // Visualizza dati utente
                case 2 -> cambiaStato(utente);         // Cambia lo stato fisico
                case 3 -> utente.monitora();           // Esegue monitoraggio (comportamento dinamico!)
                case 4 -> {
                    System.out.println("Arrivederci!");
                    continua = false;
                }
                default -> System.out.println("Opzione non valida!");
            }
        }
    }

    // Mostra le opzioni del menu principale
    private static void mostraMenu() {
        System.out.println("========= MENU APP FITNESS =========");
        System.out.println("1. Mostra dati profilo");
        System.out.println("2. Cambia stato fisico");
        System.out.println("3. Avvia monitoraggio");
        System.out.println("4. Esci");
        System.out.println("====================================");
    }

    // Permette di cambiare lo stato (State pattern)
    private static void cambiaStato(ProfiloUtente utente) {
        System.out.println("\nScegli nuovo stato:");
        System.out.println("1. Riposo");
        System.out.println("2. Allenamento");
        System.out.println("3. Recupero");
        int scelta = leggiInt("Scelta: ");

        switch (scelta) {
            case 1 -> utente.setStato(new StatoRiposo());
            case 2 -> utente.setStato(new StatoAllenamento());
            case 3 -> utente.setStato(new StatoRecupero());
            default -> System.out.println("Stato non valido!");
        }
        System.out.println("Stato aggiornato!\n");
    }

    // Metodo utility per leggere un intero
    private static int leggiInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Inserisci un numero valido!");
            scanner.next();
        }
        int valore = scanner.nextInt();
        scanner.nextLine(); // Consuma newline
        return valore;
    }
}
