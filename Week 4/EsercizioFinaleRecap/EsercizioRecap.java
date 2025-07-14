/*
Esercizio 2: Sistema di Pagamento E-commerce

Simula un checkout con metodi di pagamento differenti (Carta,
PayPal, Crypto).

Usa Factory Method per creare il tipo corretto di pagamento.

Usa Facade per nascondere la complessità del processo di
pagamento.

 */
// Questo esercizio implementa i pattern Factory Method e Facade
// Il Factory Method serve a creare diversi tipi di pagamento in modo astratto
// Il Facade serve come "pannello di controllo" principale dell’applicazione, così l’utente ha un solo punto da cui gestire tutto in modo facile.

import java.util.ArrayList;
import java.util.Scanner;

// INTERFACCIA per i diversi metodi di pagamento, PRODUCT
interface MetodoPagamento {
    // Metodo astratto per processare il pagamento, implementato dalle classi concrete
    boolean processaPagamento(double importo);
}

// IMPLEMENTAZIONE CONCRETA 1 - Pagamento con Carta di Credito
class PagamentoCarta implements MetodoPagamento {
    private String numeroCarta;
    private String cvv;
    private String dataScadenza;

    // Costruttore: inizializza i dati della carta
    public PagamentoCarta(String numeroCarta, String cvv, String dataScadenza) {
        this.numeroCarta = numeroCarta;
        this.cvv = cvv;
        this.dataScadenza = dataScadenza;
    }

    @Override
    public boolean processaPagamento(double importo) {
        // Simulazione del processo di pagamento con carta
        System.out.println("\n[CARTA] Processando pagamento...");
        String numeroMascherato = mascheraNumeroCarta(); // Maschera il numero per privacy
        System.out.println("[CARTA] Validazione numero carta: " + numeroMascherato);
        System.out.println("[CARTA] Verifica CVV in corso...");

        if (validaCarta()) { // Verifica formale di validità della carta
            System.out.println("[CARTA] Contattando banca emittente...");
            System.out.println("[CARTA] Autorizzazione ricevuta!");
            System.out.println("[CARTA] Addebitati EURO" + importo + " con successo");
            return true;
        } else {
            System.out.println("[CARTA] Errore: Dati carta non validi!");
            return false;
        }
    }

    // Metodo privato per validare la carta (solo come esempio, non reale)
    private boolean validaCarta() {
        return numeroCarta.length() == 16 && cvv.length() == 3;
    }

    // Maschera il numero carta per non mostrare tutto all'utente
    private String mascheraNumeroCarta() {
        String ultimeQuattro = numeroCarta.substring(12); // Prende solo le ultime 4 cifre
        return "**** **** **** " + ultimeQuattro;
    }
}

// IMPLEMENTAZIONE CONCRETA 2 - Pagamento con PayPal
class PagamentoPayPal implements MetodoPagamento {
    private String email;
    private String password;

    // Costruttore: salva email e password
    public PagamentoPayPal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean processaPagamento(double importo) {
        // Simulazione pagamento PayPal
        System.out.println("\n[PAYPAL] Processando pagamento...");
        System.out.println("[PAYPAL] Connessione ai server PayPal...");

        if (effettuaLogin()) { // Finta verifica delle credenziali
            System.out.println("[PAYPAL] Login effettuato per: " + email);
            System.out.println("[PAYPAL] Verifica saldo disponibile...");
            System.out.println("[PAYPAL] Trasferiti EURO" + importo + " con successo");
            return true;
        } else {
            System.out.println("[PAYPAL] Errore: Credenziali non valide!");
            return false;
        }
    }

    // Metodo privato per simulare il login
    private boolean effettuaLogin() {
        return email.contains("@") && password.length() > 0;
    }
}

// IMPLEMENTAZIONE CONCRETA 3 - Pagamento con Criptovaluta
class PagamentoCrypto implements MetodoPagamento {
    private String indirizzoWallet;
    private String chiavePrivata;

    // Costruttore: salva wallet e chiave privata
    public PagamentoCrypto(String indirizzoWallet, String chiavePrivata) {
        this.indirizzoWallet = indirizzoWallet;
        this.chiavePrivata = chiavePrivata;
    }

    @Override
    public boolean processaPagamento(double importo) {
        // Simulazione pagamento crypto
        System.out.println("\n[CRYPTO] Processando pagamento blockchain...");
        System.out.println("[CRYPTO] Connessione alla rete Bitcoin...");

        if (verificaWallet()) { // Simula verifica wallet
            String indirizzoMascherato = mascheraIndirizzo();
            System.out.println("[CRYPTO] Wallet verificato: " + indirizzoMascherato);
            System.out.println("[CRYPTO] Calcolo fee di transazione...");
            double importoBitcoin = convertiInBitcoin(importo);
            System.out.println("[CRYPTO] Creazione transazione per " + importoBitcoin + " BTC");
            System.out.println("[CRYPTO] Broadcasting alla rete...");
            System.out.println("[CRYPTO] Transazione confermata!");
            return true;
        } else {
            System.out.println("[CRYPTO] Errore: Wallet non valido!");
            return false;
        }
    }

    // Simula la verifica del wallet
    private boolean verificaWallet() {
        return indirizzoWallet.length() > 20 && chiavePrivata.length() > 0;
    }

    // Maschera il wallet per privacy
    private String mascheraIndirizzo() {
        return indirizzoWallet.substring(0, 6) + "..." + indirizzoWallet.substring(indirizzoWallet.length() - 4);
    }

    // Simula la conversione da euro a bitcoin (tasso fittizio)
    private double convertiInBitcoin(double euro) {
        double tassoEuroBitcoin = 50000.0; // 1 BTC = 50.000€
        return euro / tassoEuroBitcoin;
    }
}

// FACTORY METHOD - Crea i metodi di pagamento tramite appositi metodi. 
// Questa è la factory, che espone i metodi per generare prodotti/metodi di pagamento (restituisce l’interfaccia MetodoPagamento).
//funge sia da Creator che da ConcreteCreator
class FabbricaPagamenti {
    // Factory Method per la carta di credito
    public MetodoPagamento creaPagamentoCarta(String numero, String cvv, String scadenza) {
        return new PagamentoCarta(numero, cvv, scadenza);
    }

    // Factory Method per PayPal
    public MetodoPagamento creaPagamentoPayPal(String email, String password) {
        return new PagamentoPayPal(email, password);
    }

    // Factory Method per Crypto
    public MetodoPagamento creaPagamentoCrypto(String wallet, String chiave) {
        return new PagamentoCrypto(wallet, chiave);
    }
}

// CLASSE DI SUPPORTO: Carrello
class Carrello {
    // ArrayList per contenere gli articoli inseriti
    private ArrayList<String> articoli = new ArrayList<>();
    private double totale = 0;

    // Aggiunge un articolo e aggiorna il totale
    public void aggiungiArticolo(String nome, double prezzo) {
        articoli.add(nome + " (EURO " + prezzo + ")"); // Aggiunge nome e prezzo in stringa
        totale += prezzo;
        System.out.println("Aggiunto: " + nome + " (EURO " + prezzo + ")");
    }

    // Ritorna il totale degli articoli
    public double ottieniTotale() {
        return totale;
    }

    // Stampa il contenuto del carrello, uno per riga
    public void stampaContenuto() {
        if (articoli.isEmpty()) {
            System.out.println("Il carrello è vuoto.");
        } else {
            for (String articolo : articoli) {
                System.out.println("- " + articolo);
            }
        }
    }

    // Svuota il carrello e resetta il totale
    public void svuota() {
        articoli.clear();
        totale = 0;
        System.out.println("Carrello svuotato");
    }
}

// CLASSE DI SUPPORTO: Inventario
class Inventario {
    // Verifica sempre la disponibilità dei prodotti (simulazione)
    public boolean verificaDisponibilita() {
        System.out.println("Verifica disponibilità prodotti...");
        System.out.println("Tutti i prodotti sono disponibili");
        return true;
    }

    // Riserva i prodotti dopo il checkout (simulazione)
    public void riservaProdotti() {
        System.out.println("Prodotti riservati per l'ordine");
    }
}

// CLASSE DI SUPPORTO: Spedizione
class GestoreSpedizione {
    // Calcola i costi di spedizione in base all'indirizzo (simulazione, sempre 5.99)
    public double calcolaCostiSpedizione(String indirizzo) {
        System.out.println("Calcolo spedizione per: " + indirizzo);
        System.out.println("Costo spedizione: EURO 5.99");
        return 5.99;
    }

    // Simula la preparazione della spedizione, genera un tracking casuale
    public void preparaSpedizione(String indirizzo) {
        System.out.println("Preparazione spedizione per: " + indirizzo);
        System.out.println("Numero tracking: TRK" + System.currentTimeMillis());
    }
}

// CLASSE DI SUPPORTO: Notifiche
class ServizioNotifiche {
    // Simula l'invio di un'email di conferma
    public void inviaEmailConferma(String email) {
        System.out.println("Email di conferma inviata a: " + email);
    }

    // Simula l'invio di un SMS
    public void inviaSMS(String telefono) {
        System.out.println("SMS di conferma inviato a: " + telefono);
    }
}


// MENU - FACADE
// La classe principale funge da Facade centralizzando tutto il flusso dell'applicazione
public class EsercizioRecap {
    // Scanner per input da tastiera
    private static Scanner scanner = new Scanner(System.in);
    // Fabbrica per creare metodi di pagamento (pattern Factory)
    private static FabbricaPagamenti factory = new FabbricaPagamenti();
    // Support classes per simulare un e-commerce reale
    private static Carrello carrello = new Carrello();
    private static Inventario inventario = new Inventario();
    private static GestoreSpedizione spedizione = new GestoreSpedizione();
    private static ServizioNotifiche notifiche = new ServizioNotifiche();

    // Main: ciclo principale dell'applicazione
    public static void main(String[] args) {
        boolean continua = true;
        System.out.println("SISTEMA E-COMMERCE CON PAGAMENTI");
        while (continua) { // Mostra menu fino a uscita
            mostraMenuPrincipale();
            int scelta = leggiIntero("Scelta: ");
            
            // Nuova sintassi case ->, switch expression, dove non serve il break: l’istruzione dopo la freccia viene eseguita SOLO se il case corrisponde.
            switch (scelta) {
                case 1 -> aggiungiArticoli();         // Aggiungi articoli al carrello
                case 2 -> mostraContenutoCarrello();  // Visualizza contenuto carrello
                case 3 -> mostraTotaleCarrello();     // Visualizza totale carrello
                case 4 -> procediAlCheckout();        // Procedi al pagamento/ordine
                case 5 -> {                           // Esci dal programma
                    continua = false;
                    System.out.println("Grazie per aver usato il nostro e-commerce!");
                }
                default -> System.out.println("\n Opzione non valida!"); // Gestione errori input
            }
        }
    }

    // Stampa il menu principale a schermo
    private static void mostraMenuPrincipale() {
        System.out.println("     MENU PRINCIPALE     ");
        System.out.println(" 1. Aggiungi articoli    ");
        System.out.println(" 2. Mostra contenuto carrello");
        System.out.println(" 3. Visualizza totale carrello  ");
        System.out.println(" 4. Procedi al checkout  ");
        System.out.println(" 5. Esci                 ");
    }

    // Permette di aggiungere uno o più articoli al carrello
    private static void aggiungiArticoli() {
        System.out.println("\nAGGIUNGI ARTICOLI");
        boolean continua = true;

        while (continua) {
            String nome = leggiStringa("Nome articolo: ");      // Legge nome articolo
            double prezzo = leggiDouble("Prezzo (EURO): ");     // Legge prezzo articolo
            carrello.aggiungiArticolo(nome, prezzo);            // Aggiunge al carrello
            String risposta = leggiStringa("Aggiungere altro? (s/n): ");
            continua = risposta.equalsIgnoreCase("s");          // Ripete se si vuole aggiungere altro
        }
    }

    // Mostra il totale degli articoli nel carrello
    private static void mostraTotaleCarrello() {
        double totale = carrello.ottieniTotale();
        System.out.println("\nTotale carrello: EURO" + totale);
    }

    // Mostra tutti gli articoli presenti nel carrello
    private static void mostraContenutoCarrello() {
        System.out.println("\nContenuto del carrello:");
        carrello.stampaContenuto();
    }

    // Flusso del checkout: prende dati spedizione, metodo pagamento, paga e notifica
    private static void procediAlCheckout() {
        System.out.println("\nCHECKOUT");
        mostraTotaleCarrello();

        // Raccolta dati utente per spedizione e notifiche
        String indirizzo = leggiStringa("Indirizzo: ");
        String email = leggiStringa("Email: ");
        String telefono = leggiStringa("Telefono: ");

        // Scelta metodo di pagamento (Factory)
        System.out.println("\nMetodo di pagamento");
        System.out.println("1. Carta di credito");
        System.out.println("2. PayPal");
        System.out.println("3. Criptovaluta");
        int scelta = leggiIntero("Scegli metodo: ");

        MetodoPagamento pagamento = null; // Usato per gestire polimorficamente il pagamento
        switch (scelta) {
            case 1 -> pagamento = factory.creaPagamentoCarta(
                leggiStringa("Numero carta: "),
                leggiStringa("CVV: "),
                leggiStringa("Scadenza (MM/YY): "));
            case 2 -> pagamento = factory.creaPagamentoPayPal(
                leggiStringa("Email PayPal: "),
                leggiStringa("Password: "));
            case 3 -> pagamento = factory.creaPagamentoCrypto(
                leggiStringa("Indirizzo wallet: "),
                leggiStringa("Chiave privata: "));
            default -> {
                System.out.println("Metodo non valido.");
                return;
            }
        }

        // Verifica la disponibilità dei prodotti
        if (!inventario.verificaDisponibilita()) {
            System.out.println("Prodotti non disponibili");
            return;
        }

        inventario.riservaProdotti(); // Riserva i prodotti (simulazione)
        double costoSpedizione = spedizione.calcolaCostiSpedizione(indirizzo); // Calcola spedizione
        double totale = carrello.ottieniTotale() + costoSpedizione; // Totale finale da pagare

        // Processo di pagamento
        if (!pagamento.processaPagamento(totale)) {
            System.out.println("\nORDINE ANNULLATO - Pagamento fallito");
            return;
        }

        spedizione.preparaSpedizione(indirizzo);   // Simula la spedizione
        notifiche.inviaEmailConferma(email);       // Notifica via email
        notifiche.inviaSMS(telefono);              // Notifica via SMS
        carrello.svuota();                         // Svuota il carrello
        System.out.println("\nOrdine completato con successo!");
    }

    // Metodo di utilità per leggere una stringa con prompt
    private static String leggiStringa(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Metodo di utilità per leggere un intero con controllo input
    private static int leggiIntero(String prompt) {
        System.out.print(prompt);
        int valore = scanner.nextInt();
        scanner.nextLine(); // Consuma l'eventuale newline rimasto nel buffer
        return valore;
    }

    // Metodo di utilità per leggere un double
    private static double leggiDouble(String prompt) {
        System.out.print(prompt);
        double valore = scanner.nextDouble();
        scanner.nextLine(); // Consuma l'eventuale newline rimasto nel buffer
        return valore;
    }
}

