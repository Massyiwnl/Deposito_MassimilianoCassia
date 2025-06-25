import java.util.Scanner;
public class ProvaWhile {
    public static void main(String[] args) {
        int i = 1;

        while (i <= 5){
            i++; // Incrementa i di 1 ad ogni iterazione
            System.out.println("Iterazione numero: " + i); // Stampa il numero di iterazione
        }
    

    Scanner input = new Scanner(System.in);
    int numero;

    do{
        System.out.println("Inserisci un numero (0 per uscire): ");
        numero = input.nextInt(); // Legge un numero intero dall'input dell'utente
    } while (numero != 0);

    System.out.println("Hai inserito 0, il programma termina."); // Messaggio di uscita
    }
}
