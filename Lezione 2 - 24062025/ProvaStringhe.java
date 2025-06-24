import java.util.Arrays;

public class ProvaStringhe {
    public static void main(String[] args) {
        String txt = "Ciao"; // Inizializza una stringa con spazi all'inizio
        System.out.println("La lunghezza è: " + txt.length()); // Stampa la lunghezza della stringa
        //una funzione è isolata, può essere chiamata anche senza una funzione che la veicola. un metodo no, al contrario, deve avere qualcosa che veicola le sue condizioni, quindi tramite un punto. in comune hanno le parentesi


       //provo altri metodi
       String txt2 = "Ciao Mondo";
       System.out.println(txt2.toUpperCase()); // Stampa la lunghezza della stringa txt2 
       System.out.println(txt2.toLowerCase()); // Stampa la lunghezza della stringa txt2 in minuscolo

       String txt3 = "Please locate where 'locate' occurs!";
       System.out.println(txt3.indexOf("locate")); // Trova la posizione della parola "locate" nella stringa txt3, perchè è l'indice del carattere

       //metodo concatenazione
       String firstName = "Hello";
       String lastName = "\sWorld";
       System.out.println(firstName.concat(lastName)); // Concatena le due stringhe


       String x = "10";
       String y = "20";
       String z = x + y; // Concatena le due stringhe x e y
       System.out.println(z); // Stampa la stringa concatenata z

       String a = "10";
       int b = 20;
       String c = a + b; // Concatena la stringa a con l'intero b
       System.out.println(c); // Stampa la stringa concatenata z

       String txt5 = "We are the so-called \"Vinkings\" from the north.";
       System.out.println(txt5); // Stampa la stringa txt5 con le virgolette

       System.out.println("Sto facendo \nuna prova \rutilizzando \ttutti i caratteri \bspeciali, vediamo \f che succede");

       //provo lo split, qui utilizziamo java.util.Arrays per stampare l'array di parole
        
       String str = "Ciao Mondo";
       String[] words = str.split("\\s"); // Divide la stringa str in un array di parole utilizzando lo spazio come delimitatore
       System.out.println(Arrays.toString(words)); // Stampa l'array di parole ottenuto dallo split della stringa str

       //lenght
        String strPiena = "Ciao Mondo";
        String strVuota = ""; //provo con stringa vuota
        int lenght = strPiena.length(); // Ottiene la lunghezza della stringa str2
        int lenght2 = strVuota.length(); // Ottiene la lunghezza della stringa vuota str3, che è null
        System.out.println("La lunghezza della stringa è: " + lenght); // Stampa la lunghezza della stringa str2
        System.out.println("La lunghezza della stringa vuota è: " + lenght2); // Stampa la lunghezza della stringa vuota str3, che è null
        
        //provo equals
        String str1 = "Ciao Mondo";
        String str2 = "Ciao Mondo";
        String str3 = "Ciao Mondo!";
        System.out.println("str1 è uguale a str2? " + str1.equals(str2)); // Confronta se str1 è uguale a str2
        System.out.println("str1 è uguale a str3? " + str1.equals(str3)); // Confronta se str1 è uguale a str3
    }
}
