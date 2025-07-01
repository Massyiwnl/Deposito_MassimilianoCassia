import java.util.ArrayList;
import java.util.Scanner;

class Auto {
    String targa;
    String modello;

    // Costruttore della classe Auto
    Auto(String targa, String modello) {
        this.targa = targa;
        this.modello = modello;
    }
}

class Officina {
    ArrayList<Auto> autoList = new ArrayList<>(); // Lista di auto nell'officina

    // Metodo per aggiungere un'auto all'officina
    void aggiungiAuto(Auto auto) {
        autoList.add(auto);
    }

    // Metodo per stampare l'elenco di tutte le auto presenti nell'officina
    void stampaAuto() {
        System.out.println("Elenco delle auto presenti nell'officina:");
        for (Auto auto : autoList) {
            System.out.println("Targa: " + auto.targa + ", Modello: " + auto.modello);
        }
    }
}

public class EsercizioFinaleOggetti {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Scanner per input da tastiera
        Officina officina = new Officina(); // Creazione dell'officina

        // Ciclo per inserire almeno due auto
        for (int i = 0; i < 2; i++) {
            System.out.println("Inserisci la targa dell'auto " + (i + 1) + ":");
            String targa = scanner.nextLine();
            //regole per la targa
            while (!targa.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")) { // La targa deve essere nel formato AB123CD, grazie alla regex
                // la regex è una espressione regolare che definisce un pattern per la targa (in questo caso).
                // Controllo che la targa sia nel formato corretto
                // [A-Z]{2} indica due lettere maiuscole
                // [0-9]{3} indica tre cifre
                // [A-Z]{2} indica due lettere maiuscole
                // matches() verifica se la stringa corrisponde al pattern specificato
                // Regola: due lettere maiuscole, tre cifre, due lettere maiuscole
                // Esempio di targa valida: AB123CD
                System.out.println("Targa non valida. Inserisci una targa valida (es. AB123CD):");
                targa = scanner.nextLine();
            }
            System.out.println("Inserisci il modello dell'auto " + (i + 1) + " (scegli una vera marca, altrimenti darà errore):");
            String modello = scanner.nextLine();
            // Regole per il modello: deve essere scelto tra i seguenti elencati. Controllo che il modello sia uno di quelli validi
            while (!modello.matches("(?i)^(Alfa Romeo|Lancia|Ferrari|Maserati|Lamborghini|Pagani|Abarth|Iveco|Fiat|Volkswagen|Audi|BMW|Mercedes|Opel|Porsche|Smart|Mini|Seat|Renault|Peugeot|Citroen|Dacia|Ford|Chevrolet|Chrysler|Dodge|Jeep|Ram|Tesla|Toyota|Lexus|Subaru|Mazda|Mitsubishi|Nissan|Suzuki|Honda|Kia|Hyundai|Volvo|Land Rover|Jaguar|Aston Martin|Bentley|Rolls-Royce|McLaren|Lotus)$")) {
                // Regola: il modello deve essere uno dei seguenti
                // Alfa Romeo, Lancia, Ferrari, Maserati, Lamborghini, Pagani, Abarth, Iveco etc.
                // (?i) rende la regex case-insensitive, cioè non fa distinzione tra maiuscole e minuscole
                // ^ indica l'inizio della stringa
                // matches() verifica se la stringa corrisponde al pattern specificato
                // $ indica la fine della stringa
                // | indica una scelta tra le opzioni    
                System.out.println("Modello non valido. Scegli tra Alfa Romeo, Lancia, Ferrari, Maserati, Lamborghini, Pagani, Abarth, Iveco:");
                modello = scanner.nextLine();
            }
            // Creazione dell'oggetto Auto
            Auto auto = new Auto(targa, modello);
            // Aggiunta dell'auto all'officina
            officina.aggiungiAuto(auto);
        }
        //Vuoi aggiungere un'altra auto?
        String risposta;
        do {
            System.out.println("Vuoi aggiungere un'altra auto? (s/n)");
            risposta = scanner.nextLine();
            if (risposta.equalsIgnoreCase("s")) {
                System.out.println("Inserisci la targa dell'auto:");
                String targa = scanner.nextLine();
                System.out.println("Inserisci il modello dell'auto:");
                String modello = scanner.nextLine();
                // Creazione dell'oggetto Auto
                Auto auto = new Auto(targa, modello);
                // Aggiunta dell'auto all'officina
                officina.aggiungiAuto(auto);
            }
        } while (risposta.equalsIgnoreCase("s"));
        // Stampa di tutte le auto presenti nell'officina
        officina.stampaAuto();
    }
}
