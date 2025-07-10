public class TestDivisione {
    public static void main(String[] args){ //se mettessimo throws Exception scaricare il problema in chi ti chiama, ma non va bene
        try {
                ProvaEccezioniDivisione.divisioneChecked(4, 2); // Esempio di divisione corretta
                try {
                    ProvaEccezioniDivisione.divisioneUnChecked(4, 1); // Esempio di divisione che genera un'eccezione non controllata
                } catch (Exception ex) {
                    ex.printStackTrace(); // Gestione dell'eccezione non controllata
                    String message = ex.getMessage(); // Ottieni il messaggio dell'eccezione
                    System.out.println("Messaggio dell'eccezione: " + message); // Stampa il messaggio dell'eccezione
                }
                try {
                    ProvaEccezioniDivisione.divisione3(1,0);
                } catch (Exception e) {
                    String message = e.getMessage(); // Ottieni il messaggio dell'eccezione
                    System.out.println("Messaggio dell'eccezione: " + message); // Stampa il messaggio dell'eccezione
                    Throwable cause = e.getCause(); // Ottieni la causa dell'eccezione
                    e.printStackTrace(); // Stampa la traccia dello stack dell'eccezione
                    cause.printStackTrace(); // Stampa la traccia dello stack della causa dell'eccezione
                }
                System.out.println("Ciao"); //Questo non verrà eseguito se si verifica un'eccezione
            } catch (Exception e) {
            e.printStackTrace(); // Gestione dell'eccezione
        }
        System.out.println("Programma terminato senza errori."); // Questo messaggio verrà stampato anche se si verifica un'eccezione
    }    
}
//è tutto un problema di compilazione, non di esecuzione
//se non gestisci l'eccezione, il compilatore ti dice che non puoi  usare il metodo
//se gestisci l'eccezione, il compilatore ti dice che puoi usare il metodo
//la unchecked è più snella, però molto più pericoloso.