import java.util.Scanner; 

public class Esercizio1For {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Creiamo un oggetto Scanner per leggere l'input dell'utente

        String risposta; // Variabile per salvare la risposta se continuare o meno

        // Ciclo do-while per ripetere l'inserimento per più studenti
        do {
            System.out.println("Inserisci il nome dello studente:");
            String nome = scanner.nextLine(); // Legge il nome dello studente
            System.out.println("Quanti voti vuoi inserire per " + nome + "?");
            int numVoti = scanner.nextInt(); // Legge il numero dei voti da inserire

            // Primo controllo: il numero dei voti deve essere positivo
            while (numVoti <= 0) {
                System.out.println("Devi inserire un numero positivo, riprova:");
                numVoti = scanner.nextInt();
            }

            int sommaVoti = 0; // Variabile per sommare i voti
            int votiValidi = 0; // Contatore dei voti validi inseriti
            // Ciclo per inserire i voti uno alla volta
            for (int i = 0; i < numVoti; i++) {
                System.out.println("Inserisci il voto n. " + (i + 1) + " di " + nome + " (voto che va da 0-30):");
                int voto = scanner.nextInt(); // Legge il voto inserito
                // Secondo controllo: il voto deve essere tra 0 e 30
                while (voto < 0 || voto > 30) {
                    System.out.println("Voto non valido, riprova:");
                    voto = scanner.nextInt();
                }

                sommaVoti += voto; // Aggiungo il voto alla somma totale
                votiValidi++; // Incremento il contatore dei voti validi

                // Valutazione del voto
                System.out.print(nome + " ha un voto di " + voto + ": ");
                if (voto >= 18 && voto < 24) {
                    System.out.println("Sufficiente");
                } else if (voto >= 24 && voto < 28) {
                    System.out.println("Buono");
                } else if (voto >= 28) {
                    System.out.println("Ottimo");
                } else {
                    System.out.println("Insufficiente");
                }
            }
            // Calcolo e stampa della media
            double media = (double) sommaVoti / votiValidi; 
            System.out.println("Hai inserito " + votiValidi + " voti validi, di " + nome);
            System.out.printf("\n%s ha una media finale di: %.2f\n", nome, media);

            Scanner scanner2 = new Scanner (System.in);
            System.out.println("\nVuoi inserire i voti per un altro studente? (s/n)");
            risposta = scanner2.nextLine(); // Legge la risposta per continuare o meno

        } while (risposta.equalsIgnoreCase("s")); // Se la risposta è "s" o "S", ripete il ciclo
        System.out.println("Hai finito le operazioni, chiusura del programma"); 
    }
}
