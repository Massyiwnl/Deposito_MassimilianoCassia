import java.util.ArrayList;
import java.util.Collections;

public class ProvaArrayList {
    public static void main(String[] args) {

        ArrayList<Integer> numeri = new ArrayList<>();

        // Riempie l'ArrayList con 10 numeri casuali da 1 a 100
        for (int i = 0; i < 10; i++) {
            numeri.add((int) (Math.random() * 100) + 1);
        }

        System.out.println("Lista originale: " + numeri);

        // Ordina la lista
        Collections.sort(numeri);
        System.out.println("Lista ordinata: " + numeri);

        // Aggiunge un numero in fondo
        numeri.add(50);
        System.out.println("Dopo aggiunta di 50: " + numeri);

        // Aggiunge un numero in posizione specifica
        numeri.add(2, 99);
        System.out.println("Dopo aggiunta di 99 in posizione 2: " + numeri);

        // Rimuove l'elemento in posizione 3
        numeri.remove(3);
        System.out.println("Dopo rimozione elemento in posizione 3: " + numeri);

        // Rimuove il primo 50 che trova
        numeri.remove(Integer.valueOf(50));
        System.out.println("Dopo rimozione del numero 50: " + numeri);

        // Recupera l'elemento in posizione 4
        int valore = numeri.get(4);
        System.out.println("Elemento in posizione 4: " + valore);

        // Modifica l'elemento in posizione 0
        numeri.set(0, 111);
        System.out.println("Dopo modifica del primo elemento a 111: " + numeri);

        // Verifica se contiene un valore
        System.out.println("La lista contiene 99? " + numeri.contains(99));

        // Conta quante volte compare un numero
        int frequenza99 = Collections.frequency(numeri, 99);
        System.out.println("Il numero 99 compare: " + frequenza99 + " volte");

        // Mischia gli elementi
        Collections.shuffle(numeri);
        System.out.println("Lista mischiata: " + numeri);

        // Inverte l'ordine
        Collections.reverse(numeri);
        System.out.println("Lista invertita: " + numeri);

        // Trova il minimo e il massimo
        int minimo = Collections.min(numeri);
        int massimo = Collections.max(numeri);
        System.out.println("Minimo: " + minimo + ", Massimo: " + massimo);

        // Dimensione della lista
        System.out.println("La lista ha " + numeri.size() + " elementi");

        // Verifica se la lista è vuota
        System.out.println("La lista è vuota? " + numeri.isEmpty());

        // Svuota la lista
        numeri.clear();
        System.out.println("Dopo clear, la lista è: " + numeri);
        System.out.println("La lista è vuota? " + numeri.isEmpty());
    }
}

