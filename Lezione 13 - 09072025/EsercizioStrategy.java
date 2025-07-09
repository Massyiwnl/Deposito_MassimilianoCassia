// INTERFACCIA STRATEGY: rappresenta una "strategia" per una operazione matematica
interface Operazione {
    int esegui(int a, int b); // Metodo che tutte le strategie devono implementare
}

// STRATEGIA CONCRETA: Addizione
class Addizione implements Operazione {
    @Override
    public int esegui(int a, int b) {
        return a + b;
    }
}

// STRATEGIA CONCRETA: Moltiplicazione
class Moltiplicazione implements Operazione {
    @Override
    public int esegui(int a, int b) {
        return a * b;
    }
}

// CONTEXT: Calcolatore, usa la strategia scelta dall'utente
class Calcolatore {
    private Operazione strategia; // Riferimento alla strategia attuale

    // Permette di cambiare la strategia a runtime
    public void setStrategia(Operazione strategia) {
        this.strategia = strategia;
    }

    // Usa la strategia attuale per calcolare il risultato
    public int eseguiOperazione(int a, int b) {
        if (strategia == null) {
            System.out.println("Errore");
        }
        return strategia.esegui(a, b);
    }
}

// MAIN: testiamo il cambio di strategia a runtime
public class EsercizioStrategy {
    public static void main(String[] args) {
        Calcolatore calc = new Calcolatore();

        // Imposta strategia Addizione
        calc.setStrategia(new Addizione());
        System.out.println("5 + 3 = " + calc.eseguiOperazione(5, 3));

        // Cambia strategia a Moltiplicazione
        calc.setStrategia(new Moltiplicazione());
        System.out.println("5 * 3 = " + calc.eseguiOperazione(5, 3));
    }
}
