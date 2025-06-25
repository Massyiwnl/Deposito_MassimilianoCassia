import java.util.Scanner; // Importa la classe Scanner per leggere l'input dell'utente

public class Esercizio2Condizioni{
    public static void main(String[] args) {
        int base = 500; //prezzo base assicurazione
        double prezzoFinale = base; 
        System.out.println("Il prezzo base dell'assicurazione è: " + base + " euro");

        Scanner scannerNum = new Scanner(System.in); // Creiamo un oggetto Scanner per leggere l'input dell'utente
        System.out.println("Inserisci l'età:");
        int eta = scannerNum.nextInt(); // Legge l'età dell'utente come un numero intero

        if(eta < 18){
            System.out.println("Non sei idoneo per l'assicurazione");
            return;
        }else if(eta >= 18 && eta <= 25){
            System.out.println("Applicata una maggioranza del 20% sul prezzo base");
            // Calcola il prezzo con la maggioranza del 20%
            prezzoFinale += base * 0.20; // Calcola il 20% del prezzo base
        }else if( eta > 25 && eta <= 50){
            System.out.println("Nessuna maggioranza");
        }else if(eta > 50){
            System.out.println("Sconto del 10%");
            // Calcola il prezzo con lo sconto del 10%
            prezzoFinale -= base * 0.10; // Calcola il 10% di sconto sul prezzo base
        }

       
        System.out.println("Inserisci gli anni di esperienza alla guida");
        int anniEsperienza = scannerNum.nextInt(); // Legge gli anni di esperienza alla guida come un numero intero
        if(anniEsperienza < 2){
            System.out.println("Applicata una maggioranza del 30% sul prezzo base");
            // Calcola il prezzo con la maggioranza del 30%
            prezzoFinale += base * 0.30; // Calcola il 30% del
        }else if(anniEsperienza >= 2){
            System.out.println("Nessuna maggioranza");
        }
        
        System.out.println("Inserisci il numero di incidenti negli ultimi 5 anni");
        int numeroIncidenti = scannerNum.nextInt(); // Legge il numero di incidenti come un numero intero

        switch(numeroIncidenti){
            case 0:
                System.out.println("Nessun aumento");
                break; // Esce dallo switch
            case 1:
                System.out.println("Applicata una maggioranza del 15%");
                // Calcola il prezzo con la maggioranza del 15%
                prezzoFinale += base * 0.15; // Calcola il 15%
                break; // Esce dallo switch
            case 2:
                System.out.println("Applicata una maggioranza del 30%");
                // Calcola il prezzo con la maggioranza del 30%
                prezzoFinale += base * 0.30; // Calcola il 30% 
                break; // Esce dallo switch
            case 3:
                System.out.println("Applicata una maggioranza del 30%");
                // Calcola il prezzo con la maggioranza del 30%
                prezzoFinale += base * 0.30; // Calcola il 30% 
                break; // Esce dallo switch
            default:
                System.out.println("Non sei idoneo per l'assicurazione");
                return; // Esce dal programma se il numero di incidenti non è valido
        }

        System.out.println("Scegli il pacchetto assicurativo");
        String pacchetto = scannerNum.next(); // Legge il pacchetto assicurativo scelto dall'utente

        if(pacchetto.equals("base")){
            System.out.println("Hai scelto il prezzo standard");
        } else if(pacchetto.equals("intermedio")){
            System.out.println("Aumento del 20%");
            // Calcola il prezzo con l'aumento del 20%
            prezzoFinale += base * 0.20; // Aggiunge il 20% al prezzo base
        } else if(pacchetto.equals("premium")){
            System.out.println("Aumento del 50%");
            // Calcola il prezzo con l'aumento del 50%
            prezzoFinale += base * 0.50; // Aggiunge il 50%
        } else {
            System.out.println("Pacchetto non valido");
            return; // Esce dal programma se il pacchetto non è valido
        }



        // Mostriamo il prezzo finale
        System.out.println("Il prezzo finale della tua assicurazione è: " + prezzoFinale + " euro");
    }
}