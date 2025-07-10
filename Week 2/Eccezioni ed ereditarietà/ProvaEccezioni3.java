import java.util.Scanner;

public class ProvaEccezioni3 {
    public static void main(String[] args) {   
        //Qui puoi solo aprire una risorsa che ha metodo close()
        try (Scanner scanner = new Scanner(System.in)){; // Inizializza lo scanner per l'input da tastiera
            System.out.println("Inserisci un numero intero:");
            int numero = scanner.nextInt(); // Legge un numero intero dall'input
            System.out.println("Hai inserito il numero: " + numero);
            int x = numero / 0; // Questo causerà un'eccezione di divisione per zero
            System.out.println("Il risultato della divisione è: " + x);
        } catch (Exception ex) {
            ex.printStackTrace(); // Stampa la traccia dello stack dell'eccezione
        }      
    }
}
