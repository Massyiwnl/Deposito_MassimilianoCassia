public class ProvaEccezioni {

    public static void main(String[] args) {
        try {
            int a = 5;
            int b = 0;
            int c = a / b; // Questo causerà un'eccezione di divisione per zero
            System.out.println("Il risultato è: " + c);
        } catch (Exception ex) {
            ex.printStackTrace();
            int d = 3/0; // Questo causerà un'eccezione di divisione per zero
            System.out.println(d); // Questo non verrà eseguito a causa dell'eccezione precedente
        } finally{
            System.out.println("Questo blocco finally viene sempre eseguito, indipendentemente dal fatto che si verifichi un'eccezione o meno.");
        }
        //non è vero che si arriva sempre qui, perchè potrebbe saltare sia try che catch
        // e il blocco finally viene eseguito
        System.out.println("Programma terminato senza errori."); // Questo messaggio verrà stampato anche se si verifica un'eccezione
    }   
}
