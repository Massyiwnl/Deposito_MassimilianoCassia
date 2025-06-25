//Versione 2 dell'esercizio 3 con condizioni
// In questa versione, i dati dell'atleta vengono generati casualmente invece di essere inseriti dall'utente.
public class Esercizio3Versione2Condizioni {
    public static void main(String[] args) {
        double BMI;
        // Inserimento dati
        
        int eta = (int) (Math.random() * 51); // Numero casuale tra 0 e 50
        System.out.println("L'età dell'atleta è: " + eta); // Stampa dell'età casuale

        
        double secondi = (double) (Math.random() * 21); // Numero casuale tra 0 e 20
        System.out.println("In quanti secondi ha completato almeno una volta i 100 metri: %.2f\n" + secondi); // Stampa dei secondi casuali


        double peso = (double) (Math.random() * 101); // Numero casuale tra 0 e 100
        System.out.println("il peso dell'atleta in kg: %.2f\n" + peso); // Stampa del peso casuale

        double altezza = (double) (Math.random() * 201); // Numero casuale tra 0 e 200
        System.out.println("l'altezza dell'atleta in centimetri: %.2f\n " + altezza); // Stampa dell'altezza casuale

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


