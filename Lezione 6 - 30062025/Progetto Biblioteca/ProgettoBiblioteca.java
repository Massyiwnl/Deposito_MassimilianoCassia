/*
 Sfida Avanzata:
Sistema di Gestione
della Biblioteca
Progetto: Costruire un Semplice Sistema di Gestione della Biblioteca
Sfida Avanzata: Sistema di Gestione della Biblioteca

Requisiti Base:

1️⃣ Creare una Classe Book con:
String title (Titolo del libro)
String author (Autore del libro)
boolean isAvailable (Disponibilità del libro)
Metodo void displayBookInfo() → Mostra le informazioni del libro.
2️⃣ Creare una Classe Library con:
ArrayList<Book> books → Una lista dinamica di libri.
Metodo void addBook(Book book) → Aggiunge un libro alla biblioteca.
Metodo void displayBooks() → Mostra tutti i libri presenti nella biblioteca.
Metodo void borrowBook(String title) → Permette di prendere in prestito un libro
(solo se disponibile).
3️⃣ Implementare il Programma Principale per:
Aggiungere libri alla biblioteca.
Mostrare tutti i libri disponibili.
Permettere agli utenti di prendere in prestito un libro.

Se hai completato il progetto in anticipo, prova a implementare queste funzionalità
avanzate:
🔹 4️⃣ Restituzione di un Libro (returnBook(String title))
Implementa un metodo che permette agli utenti di restituire un libro e segnarlo
come disponibile.
🔹 5️⃣ Ricerca di un Libro (searchBook(String keyword))
Permetti agli utenti di cercare un libro per titolo o autore e visualizzare i
risultati.
🔹 6️⃣ Gestione di Più Utenti (User Class - Sistema di Prestiti)
Crea una classe User con attributi come String name e una ArrayList<Book> per
memorizzare i libri presi in prestito.
Modifica il sistema in modo che ogni utente possa prendere in prestito un massimo
di 3 libri alla volta.
🔹 7️⃣ Sistema di Scadenza e Penalità
Implementa un meccanismo che registra la data di prestito e impone una penale se il
libro non viene restituito entro un certo periodo (es. 14 giorni).

Extra Bonus:
- Aggiungi un sistema di menu interattivo in main() per permettere agli utenti di navigare nel sistema con opzioni come:
        Aggiungere un nuovo libro
        Visualizzare tutti i libri disponibili
        Cercare un libro
        Prendere in prestito un libro
        Restituire un libro
        Visualizzare i libri presi in prestito da un utente
       
 */

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title; //Titolo del libro
    String author; //Autore del libro
    boolean isAvailable; //Disponibilità del libro
    boolean isRitardo; //Segna se il libro è in ritardo (opzionale)

    Book(String title, String author, boolean isAvailable, boolean isRitardo) { //Costruttore della classe Book
        this.title = title; //Inizializza il titolo del libro
        this.author = author; //Inizializza l'autore del libro
        this.isAvailable = isAvailable; //Inizializza la disponibilità del libro
        this.isRitardo = false; //Inizializza lo stato di ritardo del libro
    }
    void displayBookInfo() { //Mostra le informazioni del libro
        System.out.println("Titolo: " + title);
        System.out.println("Autore: " + author);
        System.out.println("Disponibile: " + (isAvailable ? "Sì" : "No")); //Mostra se il libro è disponibile con la condizione ternaria
        if (isRitardo) {
            System.out.println("ATTENZIONE: Questo libro è in ritardo!");
        } else {
            System.out.println("Stato: In regola");
        }
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>(); //Lista dinamica di libri

    void addBook(Book book) { // Aggiunge un libro alla biblioteca
        books.add(book);
        //System.out.println("Libro aggiunto: " + book.title);
    }

    void displayBooks() { // Mostra tutti i libri presenti nella biblioteca
        System.out.println("Libri disponibili nella biblioteca:");
        for (Book book : books) { //Scorre e scansiona la lista di libri
            book.displayBookInfo();
            System.out.println("-------------------");
        }
    }

    void borrowBook(String title) { //Permette di prendere in prestito un libro
        for (Book book : books) { //Scorre la lista di libri
            if (book.title.equalsIgnoreCase(title) && book.isAvailable) { //Controlla se il titolo corrisponde e se il libro è disponibile
                book.isAvailable = false; //Segna il libro come non disponibile
                System.out.println("Hai preso in prestito: " + book.title);
                return; //Esce dal metodo dopo aver trovato e preso in prestito il libro
            }
        }
        System.out.println("Libro non disponibile o non trovato: " + title); //Messaggio se il libro non è disponibile o non esiste
    }

    void returnBook(String title) { //Permette di restituire un libro
        for (Book book : books) { //Scorre la lista di libri
            if (book.title.equalsIgnoreCase(title)) { //Controlla se il titolo corrisponde
                book.isAvailable = true; //Segna il libro come disponibile
                System.out.println("Hai restituito: " + book.title);
                return; //Esce dal metodo dopo aver trovato e restituito il libro
            }
        }
        System.out.println("Libro non trovato: " + title); //Messaggio se il libro non esiste
    }

    void searchBook(String keyword) { //Permette di cercare un libro per titolo o autore
        boolean trovato = false; //Variabile per controllare se il libro è stato trovato
        for (Book book : books) { //Scorre la lista di libri
            //Controlla se il titolo o l'autore contiene la parola chiave
            //Se sì, mostra le informazioni del libro trovato, grazie al metodo displayBookInfo()
            //e segna che il libro è stato trovato
            if (book.title.toLowerCase().contains(keyword.toLowerCase()) ||
                book.author.toLowerCase().contains(keyword.toLowerCase())) { //Controlla se il titolo o l'autore contiene la parola chiave
                book.displayBookInfo(); //Mostra le informazioni del libro trovato
                System.out.println("-------------------");
                trovato = true; //Segna che il libro è stato trovato
            }
        }
        if (!trovato) { //Se non è stato trovato nessun libro
            System.out.println("Nessun libro trovato con la parola chiave: " + keyword);
        }
    }
}

class User {
    String name; //Nome dell'utente
    ArrayList<Book> borrowedBooks = new ArrayList<>(); //Lista di libri presi in prestito

    User(String name) { //Costruttore della classe User
        this.name = name; //Inizializza il nome dell'utente
    }

    void borrowBook(Library library, String title) { //Permette all'utente di prendere in prestito un libro dalla biblioteca
        if (borrowedBooks.size() < 3) { //Controlla se l'utente ha meno di 3 libri presi in prestito
            for (Book book : library.books) { //Scorre la lista di libri nella biblioteca
                if (book.title.equalsIgnoreCase(title) && book.isAvailable) { //Controlla se il titolo corrisponde e se il libro è disponibile
                    book.isAvailable = false;
                    borrowedBooks.add(book); //Aggiunge il libro alla lista di libri presi in prestito dall'utente

                    book.isRitardo = true; //Simula che il libro è in ritardo (opzionale)
                    System.out.println("Hai preso in prestito: " + book.title);
                    return; //Esce dal metodo dopo aver preso in prestito il libro
                }
            }
            System.out.println("Libro non disponibile o non trovato: " + title);
        } else {
            System.out.println("Hai già preso in prestito 3 libri. Restituisci un libro prima di prenderne un altro.");
        }
    }

    void returnBook(Library library, String title) {
    for (Book book : borrowedBooks) {
        if (book.title.equalsIgnoreCase(title)) {
            if (book.isRitardo) { // Controlla se il libro è in ritardo
                System.out.println("ATTENZIONE: Il libro è stato restituito in ritardo. Potresti ricevere una penalità.");
            }
            library.returnBook(title);
            borrowedBooks.remove(book);
            book.isRitardo = false; // Resetta lo stato di ritardo
            System.out.println("Hai restituito: " + book.title);
            return;
        }
    }
    System.out.println("Libro non trovato tra i tuoi libri presi in prestito: " + title);
}


    void displayBorrowedBooks() { //Mostra i libri presi in prestito dall'utente
        if (borrowedBooks.isEmpty()) { //Controlla se l'utente ha libri presi in prestito   
            System.out.println("Non hai libri in prestito.");
        } else {
            System.out.println("Libri attualmente in tuo possesso:");
            for (Book book : borrowedBooks) { //Scorre la lista di libri presi in prestito dall'utente
                book.displayBookInfo();
                System.out.println("-------------------");
            }
        }
    }

    
}

public class ProgettoBiblioteca {
    public static void main(String[] args) {
        Library library = new Library(); //Crea un'istanza della biblioteca

        //Aggiungi libri alla biblioteca
        library.addBook(new Book("Il signore degli Anelli", "J.R.R. Tolkien", true, false));
        library.addBook(new Book("La vita secondo Massimiliano", "Massimiliano Cassia", true, false));
        library.addBook(new Book("Ciao bello", "Luigi Pirandello", true, false));
        library.addBook(new Book("E qui che si fa?", "Giuseppe Tomasi", true, false));

        ArrayList<User> users = new ArrayList<>(); //Lista utenti

        //Crea alcuni utenti di esempio
        users.add(new User("Mario"));
        users.add(new User("Anna"));

        Scanner scanner = new Scanner(System.in);
        User loggedUser = null;

        //Login semplice
        while (loggedUser == null) {
            System.out.print("Inserisci il tuo nome utente per accedere: ");
            String username = scanner.nextLine();

            for (User user : users) {
                if (user.name.equalsIgnoreCase(username)) {
                    loggedUser = user;
                    break;
                }
            }

            if (loggedUser == null) {
                System.out.println("Utente non trovato. Riprova.");
            }
        }

        System.out.println("Benvenuto " + loggedUser.name + "!");

        //Menu
        while (true) {
            System.out.println("\nMenu:");

            System.out.println("1. Visualizza tutti i libri disponibili");
            System.out.println("2. Prendi in prestito un libro");
            System.out.println("3. Restituisci un libro");
            System.out.println("4. Cerca un libro");
            System.out.println("5. Visualizza i tuoi libri presi in prestito");
            System.out.println("6. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Inserisci il titolo del libro da prendere in prestito: ");
                    String borrowTitle = scanner.nextLine();
                    loggedUser.borrowBook(library, borrowTitle);
                    break;
                case 3:
                    System.out.print("Inserisci il titolo del libro da restituire: ");
                    String returnTitle = scanner.nextLine();
                    loggedUser.returnBook(library, returnTitle);
                    break;
                case 4:
                    System.out.print("Inserisci la parola chiave per la ricerca: ");
                    String parolaChiave = scanner.nextLine();
                    library.searchBook(parolaChiave);
                    break;
                case 5:
                    loggedUser.displayBorrowedBooks(); //Mostra i libri presi in prestito dall'utente
                    break;
                case 6:
                    System.out.println("Uscita dal programma.");
                    return;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        }
    }
}
