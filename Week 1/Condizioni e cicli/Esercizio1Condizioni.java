import java.util.Scanner;
//la sua età (numero intero)
//se possiede un biglietto valido (true o false)
//se è accompagnato da un adulto (true o false)
//se ha acquistato l'opzione "salta la fila" (true o false)
//Extra: andare a inserire il tutto in un macro if che permette dis cegliere il tipo di mezzo in input fra: taxi e bus
public class Esercizio1Condizioni {
    
    public static void main(String[] args) {

        Scanner sceltaMezzo = new Scanner(System.in); // Creiamo un oggetto Scanner per leggere l'input dell'utente
        System.out.println("Hai scelto taxi o bus?:");
        String mezzo = sceltaMezzo.nextLine(); // Legge il mezzo di trasporto scelto dall'utente come una stringa

        if (mezzo.equals("taxi")) { // Controlla se il mezzo scelto è "taxy"
            System.out.println("Hai scelto il taxi.");
            Scanner myObj = new Scanner(System.in); // Creiamo un oggetto Scanner per leggere l'input dell'utente
            System.out.println("Inserisci l'età:");
            int numEta = myObj.nextInt(); // Legge l'età dell'utente come un numero intero

            Scanner myObj2 = new Scanner(System.in); // Creiamo un secondo oggetto Scanner per leggere l'input dell'utente
            System.out.println("Possiedi un biglietto valido? (true/false):");
            boolean bigliettoValido = myObj2.nextBoolean(); // Legge se il biglietto è valido come un booleano
            if (bigliettoValido == true){
                System.out.println("Il biglietto è valido.");
            } else {
                System.out.println("Il biglietto non è valido. non puoi accedere ");
                return; // Esce dal programma se il biglietto non è valido
            }

            if ( numEta < 18) { // Controlla se l'età è inferiore a 18
                System.out.println("Il visitatore è minorenne.");
                boolean accompagnato = true; // Inizializza la variabile per l'accompagnamento
                if (accompagnato == true) {
                    System.out.println("Il visitatore è accompagnato da un adulto.");
                } else {
                    System.out.println("Il visitatore non è accompagnato da un adulto.");
                }
            } else {
                System.out.println("Il visitatore è maggiorenne.");
                boolean accompagnato = false; // Inizializza la variabile per l'accompagnamento
                if (accompagnato == false){
                    System.out.println("Il visitatore non è accompagnato da un adulto.");
                } else {
                    System.out.println("Il visitatore è accompagnato da un adulto.");
                }
            }

            Scanner myObj3 = new Scanner(System.in); // Creiamo un terzo oggetto Scanner per leggere l'input dell'utente
            System.out.println("Hai acquistato l'opzione 'salta la fila'? (true/false):");
            boolean saltaFila = myObj3.nextBoolean(); // Legge se l'opzione "salta la fila" è stata acquistata come un booleano
            if (saltaFila == true) {
                System.out.println("Il visitatore ha acquistato l'opzione 'salta la fila'.");
            } else {
                System.out.println("Il visitatore non ha acquistato l'opzione 'salta la fila'.");
            }

        } else if (mezzo.equals("bus")) { // Controlla se il mezzo scelto è "bus"
            System.out.println("Hai scelto il bus.");
            Scanner myObj = new Scanner(System.in); // Creiamo un oggetto Scanner per leggere l'input dell'utente
            System.out.println("Inserisci l'età:");
            int numEta = myObj.nextInt(); // Legge l'età dell'utente come un numero intero

            Scanner myObj2 = new Scanner(System.in); // Creiamo un secondo oggetto Scanner per leggere l'input dell'utente
            System.out.println("Possiedi un biglietto valido? (true/false):");
            boolean bigliettoValido = myObj2.nextBoolean(); // Legge se il biglietto è valido come un booleano
            if (bigliettoValido == true){
                System.out.println("Il biglietto è valido.");
            } else {
                System.out.println("Il biglietto non è valido. non puoi accedere ");
                return; // Esce dal programma se il biglietto non è valido
            }

            if ( numEta < 18) { // Controlla se l'età è inferiore a 18
                System.out.println("Il visitatore è minorenne.");
                boolean accompagnato = true; // Inizializza la variabile per l'accompagnamento
                if (accompagnato == true) {
                    System.out.println("Il visitatore è accompagnato da un adulto.");
                } else {
                    System.out.println("Il visitatore non è accompagnato da un adulto.");
                }
            } else {
                System.out.println("Il visitatore è maggiorenne.");
                boolean accompagnato = false; // Inizializza la variabile per l'accompagnamento
                if (accompagnato == false){
                    System.out.println("Il visitatore non è accompagnato da un adulto.");
                } else {
                    System.out.println("Il visitatore è accompagnato da un adulto.");
                }
            }

            Scanner myObj3 = new Scanner(System.in); // Creiamo un terzo oggetto Scanner per leggere l'input dell'utente
            System.out.println("Hai acquistato l'opzione 'salta la fila'? (true/false):");
            boolean saltaFila = myObj3.nextBoolean(); // Legge se l'opzione "salta la fila" è stata acquistata come un booleano
            if (saltaFila == true) {
                System.out.println("Il visitatore ha acquistato l'opzione 'salta la fila'.");
            } else {
                System.out.println("Il visitatore non ha acquistato l'opzione 'salta la fila'.");
            }

            } else {
                System.out.println("Mezzo di trasporto non riconosciuto.");
            }
    }
}
