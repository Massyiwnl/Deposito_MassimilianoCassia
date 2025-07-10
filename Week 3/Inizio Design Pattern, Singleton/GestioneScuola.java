/*
Titolo: Gestione di una Scuola – Esercizio OOP completo
Obiettivo: Progettare un sistema che rappresenti una scuola con più tipologie di persone (studenti e docenti), applicando tutte le regole dell’OOP:
    Incapsulamento: dati privati con metodi getter e setter
    Ereditarietà: classi che estendono una classe base comune
    Polimorfismo: metodo sovrascritto chiamato su riferimenti generici
    Astrazione: uso di classe astratta e interfaccia

Traccia:

Classe Astratta Persona
    Attributi privati: nome (String), età (int)
    Costruttore con parametri
    Metodi getter/setter
    Metodo astratto descriviRuolo()
    Interfaccia Registrabile
    Metodo: registrazione() che stampa la modalità di registrazione della persona

Classe Studente (extends Persona, implements Registrabile)
    Attributo: classeFrequentata (String)
    Override di descriviRuolo() che stampa “Sono uno studente della classe …”
    Implementazione di registrazione() che stampa “Registrazione tramite modulo online”

Classe Docente (extends Persona, implements Registrabile)
    Attributo: materia (String)
    Override di descriviRuolo() che stampa “Sono un docente di …”
    Implementazione di registrazione() che stampa “Registrazione tramite segreteria didattica”

Classe Principale GestioneScuola
    Istanzia una lista di tipo Persona con oggetti Studente e Docente
    Usa un ciclo per chiamare descriviRuolo() e registrazione() su ogni elemento della lista

Requisiti Obbligatori:
    I campi devono essere privati → incapsulamento
    L’interfaccia e la classe astratta devono essere usate → astrazione
    Le classi concrete devono derivare da una classe base → ereditarietà
    I metodi devono essere richiamati da riferimenti generici → polimorfismo
 */

/*provare a mettere i controlli sugli input */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//Interfaccia Registrabile
interface Registrabile{
    void registrazione();
}

/*Classe Astratta Persona
    Attributi privati: nome (String), età (int)
    Costruttore con parametri
    Metodi getter/setter
    Metodo astratto descriviRuolo()
    Metodo: registrazione() che stampa la modalità di registrazione della persona
 */
abstract class Persona{
    private String nome;
    private int eta;

    Persona(String nome, int eta){
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(){
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public abstract void descriviRuolo();
}

/*Classe Studente (extends Persona, implements Registrabile)
    Attributo: classeFrequentata (String)
    Override di descriviRuolo() che stampa “Sono uno studente della classe …”
    Implementazione di registrazione() che stampa “Registrazione tramite modulo online”
    */

class Studente extends Persona implements Registrabile{
    private String classeFrequentata;

    Studente(String nome, int eta, String classeFrequentata){
        super(nome, eta); // Chiama il costruttore di Persona
        this.classeFrequentata = classeFrequentata;
    }

    @Override
    public void descriviRuolo(){
        System.out.println("Sono uno studente della classe " + classeFrequentata);
    }

    @Override
    public void registrazione(){
        System.out.println("Registrazione tramite modulo online");
    }
}
/* 
Classe Docente (extends Persona, implements Registrabile)
    Attributo: materia (String)
    Override di descriviRuolo() che stampa “Sono un docente di …”
    Implementazione di registrazione() che stampa “Registrazione tramite segreteria didattica”
 */

class Docente extends Persona implements Registrabile {
    private String materia;

    Docente(String nome, int eta, String materia) {
        super(nome, eta);
        this.materia = materia;
    }

    // Getter e Setter per materia
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    // Override del metodo astratto: POLIMORFISMO
    @Override
    public void descriviRuolo() {
        System.out.println("Sono un docente di " + materia);
    }

    // Implementazione del metodo dell'interfaccia
    @Override
    public void registrazione() {
        System.out.println("Registrazione tramite segreteria didattica");
    }
}
/* 
Classe Principale GestioneScuola
    Istanzia una lista di tipo Persona con oggetti Studente e Docente
    Usa un ciclo per chiamare descriviRuolo() e registrazione() su ogni elemento della lista
*/

public class GestioneScuola {
    public static void main(String[] args) {
        // Lista di Persona (POLIMORFISMO: può contenere Studenti e Docenti)
        ArrayList<Persona> persone = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int numStudenti = 0;
        int numDocenti = 0;

        // Inserimento Studenti da tastiera, dove sono andato a gestire errori
        // Chiediamo all'utente quanti studenti vuole inserire. 
        System.out.print("Quanti studenti vuoi inserire? ");

        // Questo ciclo while serve a garantire che l'utente inserisca effettivamente un numero intero valido (>=0)
        while (true) {
            try {
                // Proviamo a leggere un intero da tastiera
                numStudenti = scanner.nextInt();
                scanner.nextLine(); // Dopo nextInt(), consumiamo il carattere newline rimasto nel buffer

                // Se l'utente inserisce un numero negativo, lanciamo un'eccezione personalizzata
                if (numStudenti < 0) throw new IllegalArgumentException(); //metodo ha ricevuto un argomento non valido o non appropriato

                // Se arriviamo qui, il valore inserito è corretto e possiamo uscire dal ciclo
                break;
            } catch (InputMismatchException e) {
                // Se l'utente inserisce qualcosa che non è un intero, si entra qua
                System.out.println("Errore: devi inserire un numero intero!");
                scanner.nextLine(); // Puliamo il buffer 
            } catch (IllegalArgumentException e) {
                // Gestiamo il caso in cui il numero inserito sia negativo
                System.out.println("Errore: inserisci un numero valido!");
            }
        }

        // Ora, per ogni studente da inserire, eseguiamo il seguente ciclo for:
        for (int i = 0; i < numStudenti; i++) {
            System.out.println("Inserimento studente");
            String nome;
            int eta = 0;
            String classeFrequentata;

            System.out.print("Nome: ");
            nome = scanner.nextLine();
            // Questo ciclo while garantisce che venga inserita un'età numerica e valida (>0)
            while (true) {
                System.out.print("Età: ");
                try {
                    // Proviamo a leggere l'età come intero
                    eta = scanner.nextInt();
                    scanner.nextLine(); // Consuma l'eventuale newline rimasto

                    // Controlliamo che l'età sia positiva, altrimenti lanciamo un'eccezione personalizzata
                    if (eta <= 0) throw new IllegalArgumentException();
                    break; // Età valida, esco dal ciclo
                } catch (InputMismatchException e) {
                    // L'utente ha inserito un valore non numerico, quindi segnala errore
                    System.out.println("Errore: inserisci un numero intero!");
                    scanner.nextLine(); // Puliamo il buffer
                } catch (IllegalArgumentException e) {
                    // Età minore o uguale a 0
                    System.out.println("Errore: inserisci un'età valida (>0)!");
                }
            }

            // Chiediamo la classe frequentata dallo studente
            System.out.print("Classe frequentata: ");
            classeFrequentata = scanner.nextLine();
            // Creiamo un nuovo oggetto Studente con i dati raccolti e lo aggiungiamo alla lista persone
            // Inserimento e controllo del formato classe frequentata (es: 3A, 4B, 1C, ecc.)
            while (true) {
                System.out.print("Classe frequentata (es: 3A, 4B): ");
                classeFrequentata = scanner.nextLine();
                // La regex ^[1-5][A-Z]$ accetta SOLO stringhe con un numero da 1 a 5 seguito da una lettera maiuscola
                if (classeFrequentata.matches("^[1-5][A-Z]$")) {
                    break; // Formato corretto, esco dal ciclo
                } else {
                    System.out.println("Errore: inserisci una classe nel formato corretto (es: 3A, 4B, 1C)!");
                }
            }
            persone.add(new Studente(nome, eta, classeFrequentata));
        }

        // INSERIMENTO DOCENTI 
        // Chiediamo all'utente quanti docenti vuole inserire.
        System.out.print("Quanti docenti vuoi inserire? ");

        // Stessa logica di validazione usata per gli studenti: assicuriamoci che il valore sia un intero valido (>=0)
        while (true) {
            try {
                numDocenti = scanner.nextInt();
                scanner.nextLine(); // Consuma newline
                if (numDocenti < 0) throw new IllegalArgumentException();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Errore: devi inserire un numero intero!");
                scanner.nextLine(); // Pulizia buffer
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: inserisci un numero valido!");
            }
        }

        // Inseriamo i dati di ciascun docente ripetendo il ciclo per il numero di docenti richiesto
        for (int i = 0; i < numDocenti; i++) {
            System.out.println("Inserimento docente #");
            String nome;
            int eta = 0;
            String materia;
            System.out.print("Nome: ");
            nome = scanner.nextLine();

            // Validazione dell'età come già fatto per gli studenti
            while (true) {
                System.out.print("Età: ");
                try {
                    eta = scanner.nextInt();
                    scanner.nextLine(); // Consuma newline
                    if (eta <= 0) throw new IllegalArgumentException();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Errore: inserisci un numero intero!");
                    scanner.nextLine(); // Pulizia buffer
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: inserisci un'età valida (>0)!");
                }
            }

            // Chiediamo la materia insegnata dal docente
            System.out.print("Materia insegnata: ");
            materia = scanner.nextLine();
            // Creiamo un nuovo oggetto Docente con i dati raccolti e lo aggiungiamo alla lista persone
            persone.add(new Docente(nome, eta, materia));
        }
        // Ciclo su tutte le persone
        for (Persona p : persone) { // Scorro la lista "persone", che contiene sia Studenti che Docenti.
            // Qui 'p' è un riferimento generico di tipo Persona (polimorfismo).

            p.descriviRuolo(); // Chiamo il metodo polimorfo descriviRuolo().
            // In base al vero tipo dell’oggetto (Studente o Docente), verrà eseguita la versione specifica di descriviRuolo():

            // Uso instanceof per chiamare anche registrazione()
            if (p instanceof Registrabile) { // Verifico se l’oggetto puntato da p implementa l’interfaccia Registrabile.
                // Tutti gli Studenti e i Docenti la implementano, quindi la condizione sarà sempre vera.
                ((Registrabile) p).registrazione(); // Effettuo un cast a Registrabile per chiamare il metodo registrazione().
                // Questo permette di chiamare registrazione() su p, anche se è dichiarato come Persona.
                // Grazie al polimorfismo dell'interfaccia, verrà eseguito il metodo
            }
            // Se avessi altre sottoclassi di Persona che NON implementano Registrabile, l'uso di instanceof evita errori a runtime.

            System.out.println(); // Riga vuota
        }

        scanner.close(); // Chiudo lo scanner
    }
}
