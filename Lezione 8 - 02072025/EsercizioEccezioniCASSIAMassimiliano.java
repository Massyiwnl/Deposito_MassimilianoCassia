import java.util.InputMismatchException; // Importa la classe InputMismatchException per gestire errori di tipo di input
import java.util.Scanner;

class NumeroNegativoException extends Exception { // Eccezione personalizzata per numeri negativi
    public NumeroNegativoException(String message, Throwable cause) { // Chiamata al costruttore della superclasse Exception
        super(message, cause); // Passa il messaggio e la causa all'eccezione padre 
    }
}

class NumeroZeroException extends RuntimeException { // Eccezione personalizzata per il numero zero, estende RuntimeException
    public NumeroZeroException(String message, Throwable cause) { // Chiamata al costruttore della superclasse RuntimeException
        super(message, cause); // Passa il messaggio e la causa all'eccezione padre
    }
}

class Controller { // Classe Controller per gestire le operazioni e le eccezioni
    public static void checkPositive(int numero) throws NumeroNegativoException { // Metodo per controllare se il numero è positivo
        // Se il numero è negativo, lancia un'eccezione personalizzata NumeroNegativoException
         // Il metodo può lanciare un'eccezione, quindi si usa throws NumeroNegativoException
        if (numero < 0) {
            throw new NumeroNegativoException("Il numero è negativo.", null);
        }
    }
    public static void checkNotZero(int numero) { // Metodo per controllare se il numero non è zero
        // Se il numero è zero, lancia un'eccezione personalizzata NumeroZeroException
        // Non è necessario dichiarare il metodo con throws perché NumeroZeroException estende RuntimeException
        if (numero == 0) {
            throw new NumeroZeroException("Il numero è zero.", null);
        }
    }
}

public class EsercizioEccezioniCASSIAMassimiliano {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // Ciclo infinito per continuare a chiedere all'utente finché non decide di uscire
            System.out.println("Digita \"1\" per procede con la divisione, \"2\" per uscire: ");
            int scelta = leggiIntero(scanner);
            if (scelta == 2) {
                System.out.println("Operazione conclusa, chiusura del programma.");
                break;
            }
            if (scelta == 1) { // Se l'utente sceglie di procedere con la divisione
                System.out.println("Inserisci il primo numero: ");
                int numero1 = leggiIntero(scanner);
                try { 
                    Controller.checkPositive(numero1); // Controlla se il numero è positivo
                } catch (NumeroNegativoException e) { // Gestione dell'eccezione per numero negativo
                    e.printStackTrace(); // Stampa la traccia dello stack dell'eccezione
                    System.out.println(e.getMessage()); // Stampa il messaggio dell'eccezione
                    continue;
                }
                System.out.println("Inserisci il secondo numero: ");
                int numero2 = leggiIntero(scanner);
                try {
                    Controller.checkNotZero(numero2); // Controlla se il numero non è zero
                } catch (NumeroZeroException e) { // Gestione dell'eccezione per numero zero
                    e.printStackTrace(); // Stampa la traccia dello stack dell'eccezione
                    System.out.println(e.getMessage()); // Stampa il messaggio dell'eccezione
                    continue;
                }
                int ris = (numero1 / numero2); // Esegue la divisione tra i due numeri
                System.out.println(ris); // Stampa il risultato della divisione
            }
        }
        scanner.close();
    }
    
    public static int leggiIntero(Scanner scanner) { // Metodo che effettua un controllo bloccante sul dato richiesto all'utente
        while (true) { // Ciclo infinito per continuare a chiedere all'utente finché non inserisce un numero valido
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) { // Gestione dell'eccezione per input non valido
            // Stampa la traccia dello stack dell'eccezione
                System.out.println("Input non valido, riprova.");
                scanner.next(); // Pulisce l'input errato
            }
        }
    }
}


