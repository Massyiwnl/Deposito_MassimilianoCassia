import java.util.Scanner;

public class ProvaScanner {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); //creiamo un oggetto Scanner per leggere l'input dell'utente
        System.out.println("Inserisci il tuo nome:");

        String userName = myObj.nextLine(); //legge una riga di input dall'utente, vedi appunti per vedere gli altri
        System.out.println("Il nome inserito è: " + userName);

    }
}
