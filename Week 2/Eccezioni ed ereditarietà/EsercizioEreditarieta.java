/*
 * Esercizio: Animali e Ereditarietà
Obiettivo:
Comprendere il concetto di ereditarietà in Java tramite la creazione di una
classe base e due sottoclassi.
Traccia:
Crea una classe Animale con:
    Attributi: nome (String), età (int)
    Metodo: faiVerso() che stampa “Verso generico…”
Crea due sottoclassi che estendono Animale:
    Cane, con override di faiVerso() che stampa “Bau!”
    Gatto, con override di faiVerso() che stampa “Miao!”
Nel main:
    Crea un array di Animale che contiene sia cani che gatti.
    Stampa nome, età e verso di ciascun animale nel ciclo.
    vai a creare una classe zoo con dentro almeno 3 tipi di animali divisi in
    liste diverse riempite dall’utente
 */

 //Crea una classe animale con Attributi: nome (String), età (int) e Metodo: faiVerso() che stampa “Verso generico…”
import java.util.ArrayList;
import java.util.Scanner;
class Animale{
    protected String nome; 
    protected int eta;

    public Animale(String nome, int eta) { // Costruttore della classe Animale
        // Inizializza gli attributi nome ed eta
        this.nome = nome;
        this.eta = eta;
    }
    public void faiVerso() {
        System.out.println("Verso generico...");
    }
}

//Crea due sottoclassi che estendono Animale: Cane, con override di faiVerso() che stampa “Bau!” e Gatto, con override di faiVerso() che stampa “Miao!”
class Cane extends Animale {
    public Cane(String nome, int eta) {
        super(nome, eta); // Chiamata al costruttore della classe padre Animale
    }
    //invece di fare un override, riscrivo il metodo del padre nel figlio
    @Override
    public void faiVerso() {    
        System.out.println("Bau!");
    }   
}

class Gatto extends Animale {
    public Gatto(String nome, int eta) {
        super(nome, eta); // Chiamata al costruttore della classe padre Animale
    }
    
    @Override // Riscrivo il metodo del padre nel figlio
    //l'override è una riscrittura del metodo del padre nel figlio
    public void faiVerso() {    
        System.out.println("Miao!");
    }   
}

class Leone extends Animale {
    public Leone(String nome, int eta) {
        super(nome, eta); // Chiamata al costruttore della classe padre Animale
    }
    @Override 
    public void faiVerso() { 
        System.out.println("Ruggito del leone!");
    }   
}

class Tigre extends Animale {
    public Tigre(String nome, int eta) {
        super(nome, eta); // Chiamata al costruttore della classe padre Animale
    }
    @Override
    public void faiVerso() {    
        System.out.println("Ruggito della tigre!");
    }   
}

class Zebra extends Animale { // Creazione della classe Zebra che estende Animale
    // La classe Zebra eredita gli attributi nome ed eta dalla classe Animale
    public Zebra(String nome, int eta) {
        super(nome, eta); // Chiamata al costruttore della classe padre Animale
    }
    @Override
    public void faiVerso() {    
        System.out.println("Verso della zebra!");
    }   
}
// Creazione della classe Zoo con almeno 3 tipi di animali divisi in liste diverse riempite dall’utente
class Zoo{
    private ArrayList<Leone> leoni; // Lista di leoni nello zoo
    private ArrayList<Tigre> tigri;// Lista di tigri nello zoo
    private ArrayList<Zebra> zebre; // Lista di zebre nello zoo

    // Costruttore della classe Zoo che inizializza le liste degli animali
    public Zoo() {
        this.leoni = new ArrayList<>();
        this.tigri = new ArrayList<>();
        this.zebre = new ArrayList<>();
    }
    public void aggiungiLeone(Leone leone) {
        leoni.add(leone);
    }
    public void aggiungiTigre(Tigre tigre) {
        tigri.add(tigre);
    }
    public void aggiungiZebra(Zebra zebra) {
        zebre.add(zebra);
    }

    public ArrayList<Leone> getLeoni() { // Metodo per ottenere la lista dei leoni
        // Restituisce la lista dei leoni nello zoo
        return leoni;
    }
    public ArrayList<Tigre> getTigri() { // Metodo per ottenere la lista delle tigri
        // Restituisce la lista delle tigri nello zoo
        return tigri;
    }
    public ArrayList<Zebra> getZebre() { // Metodo per ottenere la lista delle zebre
        // Restituisce la lista delle zebre nello zoo
        return zebre;
    }
}


public class EsercizioEreditarieta {
    public static void main(String[] args) {
        //Crea un arraylist di Animale che contiene sia cani che gatti.
        ArrayList<Animale> animali = new ArrayList<>(); // Creazione di un ArrayList per contenere gli animali
        // Aggiunta di cani e gatti all'arraylist
        animali.add(new Cane("Fido", 3));
        animali.add(new Gatto("Micio", 2));
        animali.add(new Cane("Rex", 5));
        animali.add(new Gatto("Whiskers", 4));

        
        //Stampa nome, età e verso di ciascun animale nel ciclo.
        for (Animale animale : animali) {
            System.out.println("Nome: " + animale.nome + ", Età: " + animale.eta);
            animale.faiVerso(); // Chiamata al metodo faiVerso() dell'animale
        }
        // aggiunta di almeno 3 tipi di animali divisi in liste diverse riempite dall’utente
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        System.out.println("Aggiungi animali allo zoo:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Inserisci il nome del leone: ");
            String nomeLeone = scanner.nextLine();
            System.out.print("Inserisci l'età del leone: ");
            int etaLeone = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline
            zoo.aggiungiLeone(new Leone(nomeLeone, etaLeone)); // Aggiunta del leone allo zoo grazie al metodo aggiungiLeone
        }
        for (int i = 0; i < 3; i++) {
            System.out.print("Inserisci il nome della tigre: ");
            String nomeTigre = scanner.nextLine();
            System.out.print("Inserisci l'età della tigre: ");
            int etaTigre = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline
            zoo.aggiungiTigre(new Tigre(nomeTigre, etaTigre)); // Aggiunta della tigre allo zoo grazie al metodo aggiungiTigre
        }
        for (int i = 0; i < 3; i++) {
            System.out.print("Inserisci il nome della zebra: ");
            String nomeZebra = scanner.nextLine();
            System.out.print("Inserisci l'età della zebra: ");
            int etaZebra = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline
            zoo.aggiungiZebra(new Zebra(nomeZebra, etaZebra)); // Aggiunta della zebra allo zoo grazie al metodo aggiungiZebra. 
        }
        System.out.println("Animali aggiunti allo zoo!");
        System.out.println("Leoni nello zoo:");
        for (Leone leone : zoo.getLeoni()) {
            System.out.println("Nome: " + leone.nome + ", Età: " + leone.eta);
            leone.faiVerso();
        }

        System.out.println("Tigri nello zoo:");
        for (Tigre tigre : zoo.getTigri()) {
            System.out.println("Nome: " + tigre.nome + ", Età: " + tigre.eta);
            tigre.faiVerso();
        }
        System.out.println("Zebre nello zoo:");
        for (Zebra zebra : zoo.getZebre()) {
            System.out.println("Nome: " + zebra.nome + ", Età: " + zebra.eta);
            zebra.faiVerso();
        }

        scanner.close();
    }
}
