import java.util.ArrayList;
import java.util.Scanner;
//creare una funzione che scorra un arraylist

//ES 1 Scrivi un metodo che calcola la somma di due numeri e restituisce il risultato.
//ES 2 Poi, crea due metodi multiply() sovraccaricati: 1) Uno che accetta due interi; 2)Uno che accetta tre numeri in virgola mobile (double).
//ES 3 Scrivi una funzione ricorsiva che calcola la somma dei primi n numeri naturali. Esempio: sommaNaturali(5) -> 5 + 4 + 3 + 2 + 1 = 15.
// Classe che contiene metodi per operazioni matematiche
class metodiMatematici {
    // Metodo che calcola la somma di due numeri interi
    public static int somma(int a, int b) {
        return a + b;
    }

    // Metodo overload che moltiplica due numeri interi
    public static int moltiplica(int a, int b) {
        return a * b;
    }

    // Metodo overload che moltiplica tre numeri in virgola mobile
    public static double moltiplica(double a, double b, double c) {
        return a * b * c;
    }

    // Metodo ricorsivo che calcola la somma dei primi n numeri naturali
    public static int sommaNaturali(int n) { // Metodo che calcola la somma dei primi n numeri naturali
        if (n == 1) return 1;  // Caso base, ferma la ricorsione quando n è 1
        // Altrimenti, somma n con la somma dei numeri naturali precedenti
        // Ad esempio, sommaNaturali(5) = 5 + sommaNaturali(4)
        // che a sua volta calcola 4 + sommaNaturali(3), e così via
        // Questo continua fino a raggiungere il caso base
        return n + sommaNaturali(n - 1);  // Chiamata ricorsiva
    }
}

// ES 4 Crea un metodo che modifica una variabile primitiva. Crea un altro metodo che modifica un array. Stampa variabili prima e dopo.
// Classe che gestisce le operazioni su array e variabili
class GestioneArray {
    // Metodo che modifica il valore di una variabile primitiva
    public static void modificaVariabile(int numero) {
        System.out.println(">> Dentro il metodo - valore ricevuto: " + numero);
        numero += 10; // Modifica il numero aggiungendo 10
        // Nota: Non modifica il numero originale passato come argomento, poiché le variabili primitive sono passate per valore
        // Quindi, questa modifica non influenzerà il numero originale al di fuori di questo metodo
        // Per dimostrare la modifica, possiamo stamparlo qui
        System.out.println(">> Dentro il metodo - dopo modifica: " + numero);
    }

    // Metodo che modifica un array (aggiunge 5 a ogni elemento)
    public static void modificaArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += 5; // Aggiunge 5 a ogni elemento dell'array
        }
        System.out.print("Array modificato: ");
        stampaArray(array); // Stampa l'array modificato
    }

    // Metodo che stampa un array
    public static void stampaArray(int[] array) {
        for (int num : array) { // Itera su ogni elemento dell'array
            System.out.print(num + " "); // Stampa l'elemento seguito da uno spazio
        }
        System.out.println(); // Va a capo dopo aver stampato tutti gli elementi
    }

    //Metodo che scorre un ArrayList e stampa i suoi elementi
    public static void stampaArrayList(ArrayList<Integer> list) {
        System.out.print("ArrayList: ");
        for (int num : list) { // Itera su ogni elemento dell'ArrayList
            System.out.print(num + " "); // Stampa l'elemento seguito da uno spazio
        }
        System.out.println(); // Va a capo dopo aver stampato tutti gli elementi
    }
}


// Classe principale che contiene il main e il menu
//Fare il menu dove scegli le opzioni.
public class Esercizio1FunzioniRecap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Scanner per leggere input da tastiera
        boolean continua = true;  // Variabile per controllare il ciclo del menu
        while (continua) {
            // Stampa il menu a schermo
            System.out.println("\nScegli un'opzione:");
            System.out.println("1. Somma di due numeri");
            System.out.println("2. Moltiplicazione di due interi");
            System.out.println("3. Moltiplicazione di tre numeri in virgola mobile");
            System.out.println("4. Somma dei primi n numeri naturali");
            System.out.println("5. Modifica variabile primitiva");
            System.out.println("6. Stampa e modifica array");
            System.out.println("7. Scorrimento di un ArrayList");
            System.out.println("0. Uscita");
            System.out.print("Inserisci la tua scelta: ");
            int scelta = scanner.nextInt();
            switch (scelta) {
                case 0:
                    System.out.println("Uscita dal programma.");
                    continua = false;
                    break;

                case 1:
                    System.out.print("Inserisci il primo numero: ");
                    int a = scanner.nextInt();
                    System.out.print("Inserisci il secondo numero: ");
                    int b = scanner.nextInt();
                    System.out.println("Somma: " + metodiMatematici.somma(a, b));
                    break;

                case 2:
                    System.out.print("Inserisci il primo numero intero: ");
                    int x = scanner.nextInt();
                    System.out.print("Inserisci il secondo numero intero: ");
                    int y = scanner.nextInt();
                    System.out.println("Moltiplicazione: " + metodiMatematici.moltiplica(x, y));
                    break;

                case 3:
                    System.out.print("Inserisci il primo numero in virgola mobile: ");
                    double d1 = scanner.nextDouble();
                    System.out.print("Inserisci il secondo numero in virgola mobile: ");
                    double d2 = scanner.nextDouble();
                    System.out.print("Inserisci il terzo numero in virgola mobile: ");
                    double d3 = scanner.nextDouble();
                    System.out.println("Moltiplicazione: " + metodiMatematici.moltiplica(d1, d2, d3)); //il metodo moltiplica con tre parametri in virgola mobile
                    break;

                case 4:
                    System.out.print("Inserisci un numero naturale n: ");
                    int n = scanner.nextInt();
                    System.out.println("Somma dei primi " + n + " numeri naturali: " + metodiMatematici.sommaNaturali(n));
                    break;

                case 5:
                    System.out.print("Inserisci un numero da modificare: ");
                    int numero = scanner.nextInt();
                    System.out.println("Prima della chiamata al metodo, numero = " + numero);
                    GestioneArray.modificaVariabile(numero);
                    System.out.println("Dopo la chiamata al metodo, numero = " + numero);
                    break;

                case 6:
                    System.out.print("Inserisci la dimensione dell'array: ");
                    int size = scanner.nextInt();
                    int[] array = new int[size];

                    for (int i = 0; i < size; i++) {
                        System.out.print("Inserisci l'elemento " + (i + 1) + ": ");
                        array[i] = scanner.nextInt();
                    }

                    GestioneArray.modificaArray(array);
                    break;
                
                case 7:
                    ArrayList<Integer> list = new ArrayList<>();
                    System.out.print("Inserisci il numero di elementi nell'ArrayList: ");
                    int numElementi = scanner.nextInt();
                    for (int i = 0; i < numElementi; i++) { // Ciclo per inserire gli elementi nell'ArrayList
                        System.out.print("Inserisci l'elemento " + (i + 1) + ": ");
                        list.add(scanner.nextInt());
                    }
                    System.out.println("ArrayList originale:");
                    GestioneArray.stampaArrayList(list);
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}

