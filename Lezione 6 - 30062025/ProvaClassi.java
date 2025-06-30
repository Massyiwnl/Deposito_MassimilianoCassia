import java.util.ArrayList;
class Auto{
    String marca;
    int anno;
    double prezzo;

    void mostraInfo(){
        System.out.println("Marca: " + marca);
        System.out.println("Anno: " + anno);
        System.out.println("Prezzo: " + prezzo);
    }

    //Costruttore della classe Auto
    Auto(String marca, int anno, double prezzo) {
        this.marca = marca; // Inizializza la marca dell'auto
        this.anno = anno; // Inizializza l'anno dell'auto
        this.prezzo = prezzo; // Inizializza il prezzo dell'auto
    }
}

class Studente{
    String nome;
    static int totaleStudenti = 0; // Variabile statica per tenere traccia del numero totale di studenti

    Studente(String nome) { //costruttore della classe Studente
        // Il costruttore viene chiamato quando si crea un nuovo oggetto Studente
        this.nome = nome; // Inizializza il nome dello studente
        totaleStudenti++; // Incrementa il conteggio degli studenti ogni volta che viene creato un nuovo oggetto Studente
    } 
//metodo per stampare il contatore, senza riportarlo sempre
    static int getTotaleStudenti(){
        return Studente.totaleStudenti; // Restituisce il numero totale di studenti
    }
}

class Calcolatore{
    //Metodo con ritorno
    int somma(int a, int b){
        return a + b; // Restituisce la somma di a e b
    }
}

class Salutiamo{
    void saluta(){
        System.out.println("Ciao, benvenuto!"); // Stampa un messaggio di saluto
    }
}


public class ProvaClassi {
    public static void main(String[] args) {
        Auto auto1 = new Auto("Fiat", 2020, 20000); // Creazione di un oggetto Auto
        //auto1.marca = "Fiat"; // Assegnazione del valore alla proprietà marca
        //auto1.anno = 2020; // Assegnazione del valore alla proprietà anno
        //auto1.prezzo = 15000.0; // Assegnazione del valore alla proprietà prezzo

        auto1.mostraInfo(); // Chiamata al metodo mostraInfo per visualizzare le informazioni dell'auto

        Auto auto2 = new Auto("Audi", 2021, 40000); // Creazione di un altro oggetto Auto
        //auto2.marca = "Toyota"; // Assegnazione del valore alla proprietà marca
        //auto2.anno = 2021; // Assegnazione del valore alla proprietà anno
        //auto2.prezzo = 20000.0; // Assegnazione del valore alla proprietà prezzo

        auto2.mostraInfo(); // Chiamata al metodo mostraInfo per visualizzare le informazioni della seconda auto

        // Creazione di oggetti Studente
        Studente studente1 = new Studente("Alice"); // Creazione di un oggetto Studente con nome "Alice"
        Studente studente2 = new Studente("Bob"); // Creazione di un altro oggetto Studente con nome "Bob"
        Studente studente3 = new Studente("Charlie"); // Creazione di un altro oggetto Studente con nome "Charlie"
        // Stampa del numero totale di studenti creati
        System.out.println("Totale studenti creati: " + Studente.getTotaleStudenti()); // Chiamata al metodo statico getTotaleStudenti per ottenere il numero totale di studenti
        // Il numero totale di studenti è una variabile statica, quindi può essere accessibile senza creare un oggetto Studente
        // In questo caso, Studente.totaleStudenti è accessibile direttamente dalla classe  Studente, senza bisogno di un'istanza specifica.

        // Esempio di utilizzo della classe Calcolatore e Salutiamo
        Calcolatore calc = new Calcolatore(); // Crea un oggetto Calcolatore
        Salutiamo saluto = new Salutiamo(); // Crea un oggetto Salutiamo
        saluto.saluta(); // Chiama il metodo saluta dell'oggetto Salutiamo
        int risultato = calc.somma(5, 10); // Chiama il metodo somma dell'oggetto Calcolatore con i valori 5 e 10
        System.out.println("La somma è: " + risultato); // Stampa il risultato della somma

        // Creazione di una lista di oggetti Auto (utilizzando ArrayList)
        // Utilizzo di ArrayList per gestire una lista dinamica di oggetti Auto
        ArrayList<Auto> autoList = new ArrayList<>(); // Crea una lista di oggetti Auto
        autoList.add(new Auto("Tesla", 2023, 20000)); // Aggiunge il primo oggetto Auto alla lista
        autoList.add(new Auto("Ford", 2020, 20000)); // Aggiunge il secondo oggetto Auto alla lista

        for (Auto auto : autoList) { // Itera attraverso la lista di auto
            System.out.println("Marca: " + auto.marca + ", Anno: " + auto.anno + ", Prezzo: " + auto.prezzo); // Stampa le informazioni di ogni auto nella lista
        }
        //lista di tutte le auto (stampando nome)
        System.out.println("Lista delle auto:");
        for (Auto auto : autoList) { // Itera attraverso la lista di auto   
            System.out.println(auto.marca); // Stampa la marca di ogni auto nella lista
        }
    }
}
