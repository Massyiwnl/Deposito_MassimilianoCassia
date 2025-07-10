import java.util.ArrayList;
import java.util.List;

// Interfaccia Observer
interface Observer {
    void update(String message);
}

// Interfaccia Subject
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// ConcreteSubject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(state);
        }
    }
}

// ConcreteObserver
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " ha ricevuto aggiornamento: " + message);
    }
}

public class ProvaObserver {
    public static void main(String[] args) {
        // Crea il soggetto osservabile
        ConcreteSubject newsChannel = new ConcreteSubject();

        // Crea alcuni observer
        Observer alice = new ConcreteObserver("Alice");
        Observer bob = new ConcreteObserver("Bob");
        Observer carol = new ConcreteObserver("Carol");

        // Registrazione degli observer
        newsChannel.registerObserver(alice);
        newsChannel.registerObserver(bob);

        // Cambia lo stato e notifica gli observer
        newsChannel.setState("Breaking News: Nuovo pattern Observer in azione!");

        // Aggiunge un altro observer e invia un altro aggiornamento
        newsChannel.registerObserver(carol);
        newsChannel.setState("Aggiornamento: Carol si è iscritta al canale!");

        // Rimuove un observer e invia un altro messaggio
        newsChannel.removeObserver(alice);
        newsChannel.setState("Alice ha annullato l'iscrizione.");
    }
}