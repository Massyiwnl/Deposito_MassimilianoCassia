// Classe di esempio Pippo
class Pippo {
    public Pippo() {
        System.out.println("Oggetto Pippo creato!");
    }

    public void saluta() {
        System.out.println("Ciao, sono Pippo!");
    }
}

// Definizione della classe Logger come singleton
class Logger 
{
  // Istanza privata statica della classe Logger
  private static Logger instance;

  // Attributo privato di tipo Pippo
  private Pippo pippo;

  // Costruttore privato per impedire l'istanziazione diretta
  private Logger() {
      // Qui costruisco l'oggetto pippo
      pippo = new Pippo();
  }

  // Metodo pubblico statico per ottenere l'unica istanza di Logger
  public static Logger getInstance() 
  {
    // Se l'istanza non esiste, viene creata
    if (instance == null) 
    {
      instance = new Logger();
    }
    // Restituisce l'istanza esistente
    return instance;
  }

  // Metodo per stampare un messaggio di log
  public void log(String msg) 
  {
    System.out.println("[LOG] " + msg);
  }

  // Metodo pubblico per usare Pippo
  public void usaPippo() {
      pippo.saluta();
  }
}

public class ProvaSingleton2 {
    public static void main(String[] args) {
        // Ottengo l'istanza del Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Scrivo due messaggi di log
        logger1.log("Primo messaggio!");
        logger2.log("Secondo messaggio!");

        // Uso pippo tramite il logger
        logger1.usaPippo();

        // Dimostrazione che logger1 e logger2 sono lo stesso oggetto (singleton)
        if (logger1 == logger2) {
            System.out.println("logger1 e logger2 sono la stessa istanza (singleton funzionante)");
        } else {
            System.out.println("Qualcosa non va col singleton!");
        }
    }
}
