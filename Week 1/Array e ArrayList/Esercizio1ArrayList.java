import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Esercizio1ArrayList {
    public static void main(String[] args) {
        
        ArrayList<String> nomiStudenti = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String nome;

        while (true) { //Qui inserisco sempre nomi, fino a quando non viene scritto "fine"
            System.out.println("Inserisci un nome (scrivi \"fine\" per terminare):");
            nome = input.nextLine();

            if (nome.equalsIgnoreCase("fine")) { 
                System.out.println("Hai terminato l'inserimento.");
                break; // Uscita dal ciclo
            }
            nomiStudenti.add(nome); //Con add vado ad aggiungere il nome nella lista 
        }

        // Dopo qui faccio le altre parti (ordinamento, stampa, eliminazione ecc.)
        Collections.sort(nomiStudenti); //Ordiniamo gli studenti
        System.out.println("Lista ordinata: " + nomiStudenti);

        //Indico quanti studenti ci sono nella lista
        System.out.println("Hai inserito " + nomiStudenti.size() + " studenti."); //Uso size invece di lenght proprio perchè è un ArrayList

        //Mi inizio a gestire l'eliminazione con una richiesta
        System.out.println("Vuoi eliminare uno studente? (scrivi il nome esatto oppure 'no' per terminare)");
        String daEliminare = input.nextLine();
        while (!daEliminare.equalsIgnoreCase("no")) { //Se è diverso da "no" allora elimina nell'if l'utente, ma se il nome è diverso non viene eliminato nessuno
            
            if (nomiStudenti.remove(daEliminare)) {
                System.out.println(daEliminare + " è stato rimosso.");
            } else { //Qui entrerai solamente se il nome scritto è diverso rispetto ai nomi presenti nella lista
                System.out.println(daEliminare + " non è presente nella lista.");
            }
            //Lista ordinata aggiornata
            System.out.println("Lista ordinata aggiornata: " + nomiStudenti);

            System.out.println("Vuoi eliminare un altro studente? (scrivi il nome oppure 'no')");
            daEliminare = input.nextLine();
        }


    }
}
