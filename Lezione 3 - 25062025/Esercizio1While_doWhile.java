import java.util.Scanner;
public class Esercizio1While_doWhile {
    public static void main(String[] args) {
        int tentativi = 0; // Contatore dei tentativi
        final int MAX_TENTATIVI = 3; // Numero massimo di tentativi
        String password = "java123";
        Scanner input = new Scanner(System.in);

        while (tentativi < MAX_TENTATIVI) {
            System.out.println("Inserisci la password: ");
            String inputPassword = input.nextLine(); // Legge la password inserita dall'utente

            if (inputPassword.equals(password)) { // Confronto corretto tra stringhe
                System.out.println("Password corretta, accesso consentito!");
                String risposta;
                do { 
                    System.out.println("Vuoi accedere al sistema? (s/n)");
                    risposta = input.nextLine(); // Legge la risposta dell'utente
                } while (!risposta.equals("s") && !risposta.equals("n")); // Ciclo do-while per assicurarsi che la risposta sia valida
                
                if (risposta.equals("s")) { // Se l'utente risponde "s"
                    System.out.println("Accesso al sistema effettuato.");
                    break; // Esce dal ciclo se l'utente risponde "s"
                } else {
                    System.out.println("Accesso al sistema negato.");
                    break;
                }

            } else {
                System.out.println("Password errata");
                tentativi++;
                if (tentativi >= MAX_TENTATIVI) {
                    System.out.println("Numero massimo di tentativi raggiunto, accesso negato.");
                } else {
                    System.out.println("Hai ancora " + (MAX_TENTATIVI - tentativi) + " tentativi disponibili.");
                }
            }
        }
        
    }
}
