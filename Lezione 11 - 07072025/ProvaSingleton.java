// Definizione della classe Singleton
class Singleton 
{
  // Istanza privata statica della classe Singleton
  private static Singleton instance;

  // Costruttore privato per impedire l'istanziazione diretta
  private Singleton() {}
  
  // Metodo pubblico statico per ottenere l'unica istanza della classe
  public static Singleton getInstance() 
  {
    // Se l'istanza non esiste, viene creata
    if (instance == null) 
    {
      instance = new Singleton();
    }
    // Restituisce l'istanza esistente o appena creata
    return instance;
  }

  // Metodo di esempio che può essere chiamato sull'istanza Singleton
  public void DoSomething()
  {
    System.out.println("Singleton: DoSomething() called");
  }
}

public class ProvaSingleton {
    public static void main(String[] args) {
        // Ottengo l'istanza singleton
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        // Chiamo il metodo DoSomething() su entrambe le variabili
        s1.DoSomething();
        s2.DoSomething();

        // Verifico che siano effettivamente la stessa istanza
        if (s1 == s2) {
            System.out.println("s1 e s2 sono la stessa istanza (SINGLETON funzionante)");
        } else {
            System.out.println("Qualcosa non va: istanze diverse!");
        }
    }
}
