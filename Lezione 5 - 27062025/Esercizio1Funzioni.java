import java.util.Scanner;
//modificare la funzione della stringa andando a conteggiare quante char ci sono in quella stringa
public class Esercizio1Funzioni {

    public static int Fattoriale(int n) {
        int risultato = 1;
        for (int i = 1; i <= n; i++) { // vado a fare il fattoriale
            risultato = risultato * i;
        }
        return risultato;
    }

    public static void Fattoriale(String s) {
        int lunghezza = s.length(); // conteggio dei caratteri
        System.out.println("Hai inserito una parola di " + lunghezza + " caratteri.");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // Esempio semplice: o scrivo direttamente un numero o una parola nel codice
        System.out.println("Esempio con numero 5: " + Fattoriale(5));
        System.out.println("Esempio con parola ciao:");
        Fattoriale("ciao");
    }
}
