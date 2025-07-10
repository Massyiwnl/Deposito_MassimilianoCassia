/*
Design pattern ES Facile Factory Method

Crea un’interfaccia IShape con un metodo Draw(). Definisci
due classi concrete Circle e Square che implementano
IShape. Realizza una classe astratta ShapeCreator con il
metodo CreateShape(string type). 


Poi implementa due ConcreteShapeCreator (“creator”) che, a
seconda di “type” (“circle” o “square”), restituiscano
l’istanza corretta. 


Infine, scrivi un client che chieda all’utente quale forma
disegnare e la disegni tramite la funzione Draw()
 */

/*Userò Factory + Observer + Strategy (molto polimorfismo: Perchè? tutte le parti principali,le forme (IShape), 
le factory (ShapeCreator), le strategie di disegno (DrawStrategy) e il sistema di notifiche (Observer),sono progettate 
tramite interfacce o classi astratte. Questo significa che il programma può trattare oggetti diversi come 
fossero dello stesso tipo astratto, senza conoscere la loro classe concreta. Così, ad esempio, posso aggiungere nuove forme, 
strategie di disegno o tipi di notifiche senza modificare il codice del client, ma solo aggiungendo nuove classi che implementano le interfacce. 
Questo rende il sistema flessibile ed estendibile).

*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interfaccia forma
interface IShape { 
    void draw(); // Metodo per disegnare la forma
}

// Implementazioni concrete delle forme
class Circle implements IShape {
    public void draw() { // Stampa messaggio che rappresenta il disegno di un cerchio
        System.out.println("Sto disegnando un cerchio!");
    }
}

class Square implements IShape {
    public void draw() { // Stampa messaggio che rappresenta il disegno di un quadrato
        System.out.println("Sto disegnando un quadrato!");
    }
}

// Observer pattern: interfaccia e implementazione concreta
interface Observer { 
    void update(String message); // Metodo da chiamare per notificare l'observer
}

// Observer che stampa la notifica su console
class ConsoleObserver implements Observer {
    public void update(String message) { 
        System.out.println("[NOTIFICA] " + message); // Visualizza la notifica all'utente
    }
}

// Factory + Observer
class ObservableShapeFactory {
    private List<Observer> observers = new ArrayList<>(); // Lista degli observer registrati

    public void addObserver(Observer o) {
        observers.add(o); // Registra un observer
    }

    // Factory method: crea la forma e notifica gli observer
    public IShape createShape(String type) {
        IShape shape = null; // Variabile per la forma da restituire
        if ("circle".equalsIgnoreCase(type)){ // Se tipo "circle"
            shape = new Circle();
        } 
        else if ("square".equalsIgnoreCase(type)){ // Se tipo "square"
            shape = new Square();
        }

        // Se la forma è stata creata, notifica tutti gli observer
        if (shape != null) {
            for (Observer o : observers)
                o.update("Creato shape di tipo: " + type);
        }
        return shape; // Ritorna la forma (o null se non riconosciuta)
    }
}

// Strategy pattern: interfaccia e strategie concrete
interface DrawStrategy { 
    void draw(IShape shape); // Metodo per disegnare una forma secondo la strategia
}

// Strategia che stampa il numero di lati
class LatiDrawStrategy implements DrawStrategy {
    public void draw(IShape shape) {
        shape.draw(); // Esegue il metodo draw della forma
        // Aggiunge informazione specifica sulla forma
        if (shape instanceof Circle) 
            System.out.println("Un cerchio ha infiniti lati!");
        else if (shape instanceof Square) 
            System.out.println("Un quadrato ha 4 lati.");
    }
}

// Strategia che disegna una cornice attorno alla forma
class FrameDrawStrategy implements DrawStrategy {
    public void draw(IShape shape) {
        System.out.println("*****");
        shape.draw(); // Disegna la forma
        System.out.println("*****");
    }
}

// Main
public class Esercizio2FactoryMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Per leggere input utente
        ObservableShapeFactory factory = new ObservableShapeFactory(); // Istanzia la factory
        factory.addObserver(new ConsoleObserver()); // Aggiunge observer che notifica su console

        //Menu scelta forma
        String shapeType = ""; // Conterrà la scelta dell'utente (circle/square)
        while (true) {
            System.out.println("\nScegli la forma da disegnare:");
            System.out.println("1. Cerchio");
            System.out.println("2. Quadrato");
            System.out.print("Scelta: ");
            String scelta = scanner.nextLine().trim(); // Legge input

            // Decodifica scelta utente (accetta sia numero che parola)
            if ("1".equals(scelta) || "cerchio".equalsIgnoreCase(scelta)) {
                shapeType = "circle";
                break;
            } else if ("2".equals(scelta) || "quadrato".equalsIgnoreCase(scelta)) {
                shapeType = "square";
                break;
            } else {
                System.out.println("Scelta non valida, riprova!");
            }
        }

        // Usa la factory per creare la forma e notificare gli observer
        IShape shape = factory.createShape(shapeType);

        // Se la forma non è stata creata, termina il programma con errore
        if (shape == null) {
            System.out.println("Errore nella creazione della forma.");
            scanner.close();
            return;
        }

        //Menu scelta strategia
        DrawStrategy strategy = null; // Conterrà la strategy scelta
        while (true) {
            System.out.println("\nScegli come disegnare la forma:");
            System.out.println("1. Mostra lati");
            System.out.println("2. Disegna con cornice");
            System.out.print("Scelta: ");
            String scelta = scanner.nextLine().trim();

            // Decodifica scelta utente (accetta sia numero che parola)
            if ("1".equals(scelta) || "lati".equalsIgnoreCase(scelta)) {
                strategy = new LatiDrawStrategy();
                break;
            } else if ("2".equals(scelta) || "cornice".equalsIgnoreCase(scelta)) {
                strategy = new FrameDrawStrategy();
                break;
            } else {
                System.out.println("Scelta non valida, riprova!");
            }
        }

        // Applica la strategy scelta: disegna la forma secondo la strategia
        strategy.draw(shape);

        scanner.close(); // Chiude lo scanner
    }
}
