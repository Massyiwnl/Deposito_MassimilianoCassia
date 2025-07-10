public class ProvaOperatori {
    public static void main(String[] args) {
        int x = 10;

        x += 5; // x = x + 5
        System.out.println("x dopo x += 5: " + x); // Stampa 15

        int y = 5 % 2;
        System.out.println("Resto della divisione di 5 per 2: " + y); // Stampa 1

        int radius = 5;
        System.out.println("Operatori di confronto:");
        System.out.println(radius < 0); // Stampa false, perché 5 non è minore di 0
        System.out.println(radius <= 0); // Stampa false, perché 5 non è minore o uguale a 0
        System.out.println(radius > 0); // Stampa true, perché 5 è maggiore di 0
        System.out.println(radius >= 0); // Stampa true, perché 5 è maggiore o uguale a 0
        System.out.println(radius == 0); // Stampa false, perché 5 non è uguale a 0
        System.out.println(radius != 0); // Stampa true, perché 5 è diverso da 0

        System.out.println("Operatori logici:");
        System.out.println(radius < 5 && radius > 10); // Operatore AND logico
        System.out.println(radius < 5 || radius < 4); // Operatore OR logico
        System.out.println(!(radius < 5 && radius < 10)); // Negazione dell'espressione
    }
}
