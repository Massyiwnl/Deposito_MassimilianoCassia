import java.util.Scanner;
/*
 * ANDIAMO A CREARE UN INPUT PER OGNI TIPO DI DATO,
 * UTILIZZANDO UNO SCANNER DIVERSO PER OGNUNO,
 * E STAMPIAMOLI A SCHERMO.
 * CONVERTIRE UN INT IN DOUBLE, UN DOUBLE IN INT,
 * UN FLOAT IN INT, UN INT IN FLOAT.
 */
public class Esercizio1 { // casting o conversione di tipo
    public static void main(String[] args) {

        // Creiamo un oggetto Scanner per leggere l'input dell'intero
        Scanner myObj = new Scanner(System.in);
        System.out.print("Inserisci un numero intero: ");
        int numInt = myObj.nextInt(); // Legge un numero intero dall'input dato da me

        // Creiamo un oggetto Scanner per leggere l'input del double
        Scanner myObj2 = new Scanner(System.in);
        System.out.print("Inserisci un numero decimale (double): ");
        double numDouble = myObj2.nextDouble(); // Legge un numero decimale dall'input dato da me

        // Creiamo un oggetto Scanner per leggere l'input del float
        Scanner myObj3 = new Scanner(System.in);
        System.out.print("Inserisci un numero decimale (float): ");
        float numFloat = myObj3.nextFloat(); // Legge un numero decimale float dall'input dato da me

        // Creiamo un oggetto Scanner per leggere l'input booleano
        Scanner myObj4 = new Scanner(System.in);
        System.out.print("Inserisci true o false: ");
        boolean boolVal = myObj4.nextBoolean(); // Legge un valore booleano (true o false) dall'input dato da me

        // Creiamo un oggetto Scanner per leggere l'input della stringa
        Scanner myObj5 = new Scanner(System.in);
        System.out.print("Inserisci una stringa: ");
        String strVal = myObj5.nextLine(); // Legge una stringa dall'input dato da me

        // Stampa dei dati 
        System.out.println("\nNumero intero: " + numInt); 
        System.out.println("Numero decimale double: " + numDouble);
        System.out.println("Numero decimale float: " + numFloat);
        System.out.println("Valore booleano: " + boolVal);
        System.out.println("Stringa: " + strVal);

        // Conversioni 
        double intToDouble = numInt; // Conversione implicita da int a double
        int doubleToInt = (int) numDouble; // Conversione esplicita da double a int
        float intToFloat = numInt; // Conversione implicita da int a float
        int floatToInt = (int) numFloat; // Conversione esplicita da float a int

        // Stampa delle conversioni
        System.out.println("\nConversioni:");
        System.out.println("Intero convertito in double: " + intToDouble);
        System.out.println("Double convertito in intero: " + doubleToInt);
        System.out.println("Float convertito in intero: " + floatToInt);
        System.out.println("Intero convertito in float: " + intToFloat);
    }
}
