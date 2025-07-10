public class ProvaMath {
    public static void main(String[] args) {
        System.out.println(Math.max(5,10));

        System.out.println(Math.min(5, 10));
        
        System.out.println(Math.sqrt(64)); // Radice quadrata di 64

        System.out.println(Math.abs(-5)); // Valore assoluto di -5

        System.out.println(Math.random());  // Numero casuale tra 0.0 (incluso) e 1.0 (escluso)

        int randomNum = (int) (Math.random() * 101); // Numero casuale tra 0 e 100
        System.out.println("Numero casuale tra 0 e 100: " + randomNum);
        
    }
}
