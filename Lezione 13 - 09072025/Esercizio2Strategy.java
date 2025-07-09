/*
Esercizio Medio:

Obiettivo: Gestire un sistema di pagamento che può variare il metodo in fase di
esecuzione.

Richiesta:
Crea un'interfaccia MetodoPagamento con void paga(double importo).
Implementa almeno due strategie: CartaDiCredito e PayPal.
Crea la classe PagamentoContext per assegnare e utilizzare il metodo scelto.
Permetti all'utente di scegliere il metodo di pagamento e simula un acquisto stampando
il metodo usato e l'importo pagato.
 */
import java.util.*;
/*
Ho scelto: Strategy, Singleton, Observer, perchè:
- Serve per poter cambiare a runtime la strategia di pagamento. Permette di passare facilmente da Carta di Credito a PayPal 
o altre strategie senza modificare il context.
- Serve a garantire che ci sia una sola istanza di una classe nel sistema. Possiamo rendere PagamentoContext un singleton, 
così da avere un unico gestore dei pagamenti.
- Serve per notificare altri oggetti quando avviene un evento.
Lo uso per notificare, ad esempio, un sistema di log o un osservatore quando viene effettuato un pagamento.
Così, ogni volta che si effettua un pagamento, tutti gli “ascoltatori” vengono avvisati (es. logger, notifiche, ecc).
 */
// Interfaccia Strategy
interface MetodoPagamento {
    void paga(double importo);
}

// Strategia concreta: Carta di Credito
class CartaDiCredito implements MetodoPagamento {
    @Override
    public void paga(double importo) {
        System.out.println("[Carta di Credito] Pagato: " + importo + "€");
    }
}

// Strategia concreta: PayPal
class PayPal implements MetodoPagamento {
    @Override
    public void paga(double importo) {
        System.out.println("[PayPal] Pagato: " + importo + "€");
    }
}

// Interfaccia Observer
interface PagamentoObserver {
    void aggiorna(double importo, String metodo);
}

// Concrete Observer: LoggerPagamento
class LoggerPagamento implements PagamentoObserver {
    @Override
    public void aggiorna(double importo, String metodo) {
        System.out.println("Notifica: Pagamento di " + importo + "euro effettuato con " + metodo + ".");
    }
}

// SUBJECT: gestisce la lista di observer e le notifiche
interface SubjectPagamento {
    void addObserver(PagamentoObserver obs);
    void removeObserver(PagamentoObserver obs);
    void notificaObserver(double importo, String metodo);
}

// DECORATOR PATTERN

// Decorator astratto: estende MetodoPagamento e ha un riferimento a un MetodoPagamento
abstract class MetodoPagamentoDecorator implements MetodoPagamento {
    protected MetodoPagamento wrappee;

    public MetodoPagamentoDecorator(MetodoPagamento wrappee) {
        this.wrappee = wrappee;
    }
}

// Decorator concreto: aggiunge la stampa della ricevuta
class RicevutaDecorator extends MetodoPagamentoDecorator {
    public RicevutaDecorator(MetodoPagamento wrappee) {
        super(wrappee);
    }

    @Override
    public void paga(double importo) {
        wrappee.paga(importo); // Chiamo il metodo originale (es. CartaDiCredito/PayPal)
        System.out.println("Ricevuta: Pagamento di " + importo + " euro registrato in archivio.");
    }
}


// SINGLETON + STRATEGY + OBSERVER PATTERN

class PagamentoContext implements SubjectPagamento {
    private MetodoPagamento strategia;
    private List<PagamentoObserver> observers = new ArrayList<>();

    // SINGLETON: istanza unica del context
    private static PagamentoContext instance;

    // Costruttore privato
    private PagamentoContext() {}

    // Metodo per ottenere l'unica istanza (Singleton)
    public static PagamentoContext getInstance() {
        if (instance == null) {
            instance = new PagamentoContext();
        }
        return instance;
    }

    // Cambia la strategia di pagamento (Strategy)
    public void setMetodo(MetodoPagamento strategia) {
        this.strategia = strategia;
    }

    // Restituisce il nome reale del metodo di pagamento, anche se decorato
    private String trovaMetodoReale(MetodoPagamento strategia) {
        MetodoPagamento corrente = strategia;
        while (corrente instanceof MetodoPagamentoDecorator) {
            corrente = ((MetodoPagamentoDecorator) corrente).wrappee;
        }
        if (corrente instanceof CartaDiCredito) return "Carta di Credito";
        if (corrente instanceof PayPal) return "PayPal";
        return "Sconosciuto";
    }
    // Effettua il pagamento e notifica gli observer (Observer)
    public void paga(double importo) {
        //potrà accadere solo se chiami il metodo paga(importo) senza aver 
        //impostato prima la strategia (cioè senza aver chiamato setMetodo(...) con un oggetto valido).
        //controllo usato solo per avere maggiore sicurezza
        if (strategia == null) {
            throw new IllegalStateException("Metodo di pagamento non impostato!");
        }

        String nomeMetodo = trovaMetodoReale(strategia);

        strategia.paga(importo); // Strategy
        notificaObserver(importo, nomeMetodo); // Observer
    }

    // Metodi Observer
    @Override
    public void addObserver(PagamentoObserver obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(PagamentoObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void notificaObserver(double importo, String metodo) {
        for (PagamentoObserver obs : observers) {
            obs.aggiorna(importo, metodo);
        }
    }
}

public class Esercizio2Strategy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PagamentoContext context = PagamentoContext.getInstance(); // Singleton

        // Registra un observer (Logger)
        context.addObserver(new LoggerPagamento());

        System.out.println("Inserisci importo da pagare:");
        double importo = input.nextDouble();
        input.nextLine(); // consuma newline
        
        boolean sceltaValida = false;
        MetodoPagamento strategiaScelta = null;

        while (!sceltaValida) {
            System.out.println("Scegli il metodo di pagamento: (1) Carta di Credito (2) PayPal");
            String scelta = input.nextLine();
            switch (scelta) {
                case "1":
                    strategiaScelta = new CartaDiCredito();
                    sceltaValida = true;
                    break;
                case "2":
                    strategiaScelta = new PayPal();
                    sceltaValida = true;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova!");
                    break;
            }
        }

        System.out.println("Vuoi la ricevuta? (s/n)");
        String ricevuta = input.nextLine();
        switch (ricevuta.toLowerCase()) {
            case "s":
                strategiaScelta = new RicevutaDecorator(strategiaScelta);
                break;
            case "n":
                // Niente
                break;
            default:
                System.out.println("Risposta non valida. Procedo senza ricevuta.");
                break;
        }

        context.setMetodo(strategiaScelta);
        context.paga(importo);
        input.close();
    }
}
