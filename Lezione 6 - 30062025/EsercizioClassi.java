import java.util.Scanner;
// Classe Libro che rappresenta un libro con titolo, autore, prezzo e codice autoincrementante
class Libro{
    String titolo;
    String autore;
    double prezzo;
    static int codiceNumeroAutoincrementante = 0; // Variabile statica per il codice autoincrementante

    // Costruttore della classe Libro, che viene chiamato quando si crea un nuovo oggetto Libro
    // Il costruttore accetta tre parametri: titolo, autore e prezzo
    Libro(String titolo, String autore, double prezzo){
        this.titolo = titolo; // Inizializza il titolo del libro
        this.autore = autore; // Inizializza l'autore del libro
        this.prezzo = prezzo; // Inizializza il prezzo del libro
        codiceNumeroAutoincrementante++; // Incrementa il codice autoincrementante ogni volta che viene creato un nuovo libro
    }
}

public class EsercizioClassi {
    public static void main(String[] args) {
        //crea due oggetti libro e stampa i loro dettagli
        Scanner scanner = new Scanner(System.in); // Crea un oggetto Scanner per leggere l'input dell'utente
        System.out.print("Inserisci il titolo del libro: ");
        String titolo = scanner.nextLine(); // Legge il titolo del libro
        System.out.print("Inserisci l'autore del libro: ");
        String autore = scanner.nextLine(); // Legge l'autore del libro
        System.out.print("Inserisci il prezzo del libro: ");
        double prezzo = scanner.nextDouble(); // Legge il prezzo del libro
        Libro libro1 = new Libro(titolo, autore, prezzo); // Crea un oggetto Libro con i dati inseriti
        System.out.println("Libro 1: " + libro1.titolo + ", Autore: " + libro1.autore + ", Prezzo: " + libro1.prezzo + ", Codice: " + libro1.codiceNumeroAutoincrementante);
        
        // Crea un secondo oggetto libro e stampa i suoi dettagli
        scanner.nextLine(); // Consuma il newline rimasto dopo nextDouble()
        System.out.print("Inserisci il titolo del secondo libro: ");
        String titolo2 = scanner.nextLine(); // Legge il titolo del secondo libro
        System.out.print("Inserisci l'autore del secondo libro: ");
        String autore2 = scanner.nextLine(); // Legge l'autore del secondo libro
        System.out.print("Inserisci il prezzo del secondo libro: ");
        double prezzo2 = scanner.nextDouble(); // Legge il prezzo del secondo libro
        Libro libro2 = new Libro(titolo2, autore2, prezzo2); // Crea un secondo oggetto Libro con i dati inseriti
        System.out.println("Libro 2: " + libro2.titolo + ", Autore: " + libro2.autore + ", Prezzo: " + libro2.prezzo + ", Codice: " + libro2.codiceNumeroAutoincrementante);
        // Stampa il numero totale di libri creati  
        System.out.println("Totale libri creati: " + libro2.codiceNumeroAutoincrementante); // Stampa il numero totale di libri creati
        scanner.close(); // Chiude lo scanner per evitare perdite di risorse
    }
}
