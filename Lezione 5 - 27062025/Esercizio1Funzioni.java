import java.util.Scanner;

public class Esercizio1Funzioni {

    public static int Fattoriale(int n) {
        int risultato = 1;
        for (int i = 1; i <= n; i++) { //vado a fare il fattoriale
            risultato = risultato * i;
        }
        return risultato;
    }

    public static void Fattoriale(String s) {
        System.out.println("Inserisci un numero valido");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Esempio semplice: o scrivo direttamente un numero o una parola nel codice

        System.out.println("Esempio con numero:");
        Fattoriale(5);

        System.out.println("Esempio con parola:");
        Fattoriale("ciao");
    }
}
