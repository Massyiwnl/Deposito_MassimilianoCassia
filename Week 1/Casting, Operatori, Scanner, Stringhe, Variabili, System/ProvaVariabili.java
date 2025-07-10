public class ProvaVariabili {
    public static void main(String[] args) {
        int provaNumero = 10; // Numero intero
        String provaTesto = "Ciao Mondo"; // Stringa di testo
        boolean provaBool = true; // Valore booleano

        //Stamopa delle variabili
        System.out.println("Numero: " + provaNumero);
        System.out.println("Testo: " + provaTesto);
        System.out.println("Booleano: " + provaBool);

        boolean provaBool2;
        //provaBool2 = false; //non potrà prenderlo
        provaBool2 = true; //prenderà il valore true perchè l'abbiamo cambiato
        // Stampa del secondo booleano
        System.out.println("Secondo Booleano: " + provaBool2);

        final int provaNumero2 = 15; //variabile intera costante data dal final
        //provaNumero2 = 20; questo darà errore perché provaNumero2 è una variabile finale
        System.out.println("Numero Finale: " + provaNumero2);
        
        //stringe
        String testo = "Prova";
        System.out.println(testo);

        testo = "Mondo"; // Combinare il testo con una variabile utilizzando +
        System.out.println("Testo modificato: " + testo); 

        String firstPart = "Ciao";
        String lastPart = "Mondo";
        String fullPart = firstPart + lastPart;
        System.out.println("Concatenazione: " + fullPart); // Concatenazione di stringhe

        // Operazioni con le variabili
        int k = 5;
        int l = 6;
        System.out.println(k + l);

        int a = 5, b = 6, c = 50;
        System.out.println(a + b + c); // Somma di più variabili

        int x,y,z;
        x = y = z = 50; 
        System.out.println(x + y + z); // Assegnazione multipla
        //quello che diciamo cambia, è la metodologia
    }
}