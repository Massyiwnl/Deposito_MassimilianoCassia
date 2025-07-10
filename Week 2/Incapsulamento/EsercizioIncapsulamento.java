/*
Esercizio Incapsulamento 
Obiettivo:
Comprendere e applicare il concetto di incapsulamento in Java tramite l’uso di attributi privati e metodi getter/setter.
Traccia:
Crea una classe Studente con i seguenti attributi privati:
    nome (String)
    voto (int)
    id (int - statico - autoincrementante)
Implementa:
Un costruttore per inizializzare nome e voto.
Un metodo getter per leggere il nome.
Un metodo getter per leggere il voto.
Un metodo setter per modificare il voto, assicurandoti che il voto sia sempre compreso tra 0 e 10 (se fuori
intervallo, non modificare e stampa un messaggio di errore).

Nel main:
Crea un oggetto Studente.
Stampa nome e voto iniziale.
Prova a cambiare il voto con valori validi e non validi, stampando il risultato ogni volta.
Gestire la lista di studenti tramite un arraylist 
Rendere possibile la ricerca di uno studente tramite nome
*/

import java.util.ArrayList;
class Studente{
    private String nome;
    private int voto;
    private static int contatotoreID = 0; // Contatore statico per l'ID

    // Costruttore della classe Studente
    public Studente(String nome, int voto) {
        this.nome = nome; // Inizializza il nome dello studente
        this.voto = voto; // Inizializza il voto dello studente
        contatotoreID++; // Incrementa il contatore statico per l'ID ogni volta che viene creato un nuovo studente
        System.out.println("Studente creato: " + this.nome + ", Voto: " + this.voto + ", ID: " + contatotoreID); // Messaggio di conferma della creazione dello studente
    }
    // Metodo getter per il nome
    public String getNome() {
        return nome; // Restituisce il nome dello studente
    }

    // Metodo getter per il voto
    public int getVoto() {
        return voto; // Restituisce il voto dello studente
    }

    // Metodo setter per il voto già esistente
    public void setVoto(int voto) { 
        if (voto >= 0 && voto <= 10) { // Controlla se il voto è compreso tra 0 e 10
            this.voto = voto; // Se il voto è valido, lo imposta
        } else {
            System.out.println("Errore: il voto deve essere compreso tra 0 e 10."); // Messaggio di errore se il voto non è valido
        }
    }

}


public class EsercizioIncapsulamento {
    public static void main(String[] args){
        // Creazione di un ArrayList per gestire più studenti
        ArrayList<Studente> studentiList = new ArrayList<>(); // Crea una lista di studenti
        Studente studente1 = new Studente("Massimiliano", 8); // Inizializzo lo studente con nome e voto
        studentiList.add(studente1); // Aggiunge il primo studente alla lista
        Studente studente2 = new Studente("Alice", 7); // Crea un secondo studente
        studentiList.add(studente2); // Aggiunge il secondo studente alla lista

        // Stampa la lista degli studenti
        System.out.println("Lista degli studenti:");
        for (Studente studente : studentiList) { // Itera attraverso la lista degli studenti
            System.out.println("Nome: " + studente.getNome() + ", Voto: " + studente.getVoto()); // Stampa il nome e il voto di ogni studente
        }

        //Rendere possibile la ricerca di uno studente tramite nome
        String nomeDaCercare = "Massimiliano"; // Nome dello studente da cercare
        boolean trovato = false; // Variabile per verificare se lo studente è stato trovato
        for (Studente studente : studentiList) { // Itera attraverso la lista degli studenti
            if (studente.getNome().equals(nomeDaCercare)) { // Controlla se il nome dello studente corrisponde a quello cercato
                System.out.println("Studente trovato: " + studente.getNome() + ", Voto: " + studente.getVoto()); // Stampa le informazioni dello studente trovato
                trovato = true; // Imposta la variabile trovato a true se lo studente è stato trovato
                break; // Esce dal ciclo una volta trovato lo studente
            }else {
                System.out.println("Studente non trovato: " + nomeDaCercare); // Stampa un messaggio se lo studente non è stato trovato
            }
        } 

        // Provo a cambiare il voto con un valore valido
        studente1.setVoto(9); // Imposta un nuovo voto valido
        System.out.println("Voto aggiornato dello studente: " + studente1.getVoto()); // Stampa il voto aggiornato
        // Provo a cambiare il voto con un valore non valido
        studente1.setVoto(11); // Imposta un nuovo voto non valido
        System.out.println("Voto aggiornato dello Studente: " + studente1.getVoto()); // Stampa il voto dopo il tentativo di aggiornamento non valido

        // Stampa la lista degli studenti
        System.out.println("Lista aggiornata degli studenti:");
        for (Studente studente : studentiList) { // Itera attraverso la lista degli studenti
            System.out.println("Nome: " + studente.getNome() + ", Voto: " + studente.getVoto()); // Stampa il nome e il voto di ogni studente
        }
    }
}
