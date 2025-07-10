import java.util.Scanner;

public class Esercizio3Condizioni {
    public static void main(String[] args) {
        double BMI;

        Scanner input = new Scanner(System.in);
        // Inserimento dati
        System.out.print("Inserisci l'età dell'atleta: ");
        int eta = input.nextInt();

        System.out.print("In quanti secondi ha completato almeno una volta i 100 metri: ");
        double secondi = input.nextDouble();

        System.out.print("Inserisci il peso dell'atleta in kg: ");
        double peso = input.nextDouble();

        System.out.print("Inserisci l'altezza dell'atleta in centimetri: ");
        double altezza = input.nextDouble();

        // Conversione dell'altezza in metri
        double altezzaMetri = altezza / 100.0; // Altezza in metri

        // Calcolo del BMI
        BMI = peso / Math.pow(altezzaMetri, 2); // Formula del BMI: peso (kg) / (altezza (m))^2

        // Stampa del BMI arrotondato a 2 decimali
        System.out.printf("L'indice di massa corporea è: %.2f\n", BMI); // Stampa del BMI con due decimali, se no verrebbe lunghissimo

        // Verifica condizioni
        if (eta >= 18 && eta <= 40 && secondi < 12 && BMI < 25) { // Controllo delle condizioni per l'ammissione alla gara
            // Tutte le condizioni sono soddisfatte
            System.out.println("Ammesso alla gara");
        } else {
            // Almeno una condizione non è soddisfatta
            System.out.println("Non ammesso alla gara");
        }
    }
}
