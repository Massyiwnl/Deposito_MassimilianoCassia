import java.util.Scanner;

public class Esercizio1Array {
    public static void main(String[] args) {
        
        final int MAX_DOLCI = 10; // Massimo numero di dolci diversi
        String[] nomiDolci = new String[MAX_DOLCI]; // Array per i nomi dei dolci
        int[] quantitaDolci = new int[MAX_DOLCI];   // Array per le quantità ordinate
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in); //Uso duo scanner per evitare conflitti vari
        System.out.print("Quanti dolci diversi vuoi ordinare? (max 10): ");
        int numDolci = scanner.nextInt();
        
        // Controllo sul numero inserito
        while (numDolci < 1 || numDolci > MAX_DOLCI) {
            System.out.print("Numero non valido, inserisci un numero tra 1 e 10: ");
            numDolci = scanner.nextInt();
        }
        // Raccolta dati
        for (int i = 0; i < numDolci; i++) {
            System.out.print("Inserisci il nome del dolce n. " + (i + 1) + ": ");
            nomiDolci[i] = scanner2.nextLine();
            System.out.print("Inserisci la quantità ordinata per " + nomiDolci[i] + ": ");
            int quantita = scanner.nextInt();
            
            // Controllo quantità negativa
            while (quantita < 0) {
                System.out.print("Quantità non valida, inserisci un numero positivo: ");
                quantita = scanner.nextInt();
            }
            
            quantitaDolci[i] = quantita;
        }
        // Stampa degli ordini effettuati
        System.out.println("\n Riepilogo degli ordini effettuati");
        int totaleDolci = 0;
        for (int i = 0; i < numDolci; i++) {
            System.out.println(nomiDolci[i] + ": " + quantitaDolci[i] + " pezzi");
            totaleDolci += quantitaDolci[i];
        }
        
        System.out.println("Totale dolci ordinati: " + totaleDolci);
    }
}
