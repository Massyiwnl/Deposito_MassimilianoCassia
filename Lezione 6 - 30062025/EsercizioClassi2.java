/*Definire una Classe BankAccount e
Implementare Deposito & Prelievo

Crea una classe BankAccount con:

String accountHolderName (Nome del titolare dell'account)
double balance (Saldo)

Metodo void deposit(double amount) per effettuare un deposito

Metodo void withdraw(double amount) per effettuare un prelievo

Metodo void displayBalance() per mostrare il saldo attuale

Assicurati che il prelievo non consenta un saldo negativo.

Extra: andare a creare un arraylist di account tra cui scegliere in
base alle credenziali
*/

import java.util.ArrayList;
import java.util.Scanner; 

class BankAccount{
    String accountHolderName; //Nome del titolare dell'account
    double balance; //Saldo dell'account
    String password; // Password per l'accesso

    // Costruttore della classe BankAccount
    BankAccount(String accountHolderName, String password, double balance) {
        this.accountHolderName = accountHolderName;
        this.password = password;
        this.balance = balance;
    }
    // Metodo per depositare un importo nell'account
    // Il metodo accetta un parametro amount che rappresenta l'importo da depositare
    void deposit (double amount){
        if (amount > 0) {
            balance += amount; // Aggiunge l'importo al saldo
            System.out.println("Deposito effettuato: " + amount);
        } else {
            System.out.println("Importo del deposito non valido.");
        }
    }
    // Metodo per prelevare un importo dall'account 
    // Il metodo accetta un parametro amount che rappresenta l'importo da prelevare
    void withdraw(double amount){
        if(amount > 0 && amount <= balance) {
            balance -= amount; // Sottrae l'importo dal saldo
            System.out.println("Prelievo effettuato: " + amount);
        } else if (amount > balance) {
            System.out.println("Saldo insufficiente per il prelievo.");
        } else {
            System.out.println("Importo del prelievo non valido.");
        }
    }
    // Metodo per visualizzare il saldo attuale dell'account
    // Questo metodo non accetta parametri e restituisce void
    void displayBalance() {
        System.out.println("Saldo attuale: " + balance); // Mostra il saldo attuale
    }
}


public class EsercizioClassi2 {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>(); // Crea una lista di oggetti BankAccount
        BankAccount account1 = new BankAccount("Mario", "1234", 100.0);
        BankAccount account2 = new BankAccount("Francesco", "ciao", 40000.0);
        BankAccount account3 = new BankAccount("Luigino", "evvai", 0.0);
        //account1.accountHolderName = "Mario";
        //account1.password = "1234";
        //account1.balance = 100.0;
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        Scanner scanner = new Scanner(System.in); // Crea un oggetto Scanner per leggere l'input dell'utente  
         // Login
        BankAccount loggato = null; //null perchè non è ancora stato effettuato il login
        while (loggato == null) {
            System.out.println("Inserisci il nome utente: ");
            String username = scanner.nextLine(); // Legge il nome utente
            System.out.println("Inserisci la password: ");
            String password = scanner.nextLine(); // Legge la password
            // Ciclo per cercare l'account corrispondente
            for (BankAccount acc : accounts) { // Scansiona/scorre attraverso la lista di account
                // Controlla se il nome utente e la password corrispondono
                if (acc.accountHolderName.equals(username) && acc.password.equals(password)) { 
                    loggato = acc; // Assegna l'account trovato a loggato
                    System.out.println("Login effettuato con successo!"); // Messaggio di successo
                    break;
                }
            }
            if (loggato == null) {
                System.out.println("Credenziali errate. Riprova.");
            }
        }
        System.out.println("Benvenuto, " + loggato.accountHolderName + "!"); // Messaggio di benvenuto
        
      /*   BankAccount accountLogin = new BankAccount(); // Crea un oggetto BankAccount
        
        System.out.println("Inserisci il nome del titolare dell'account: ");
        account1.accountHolderName = scanner.nextLine(); // Legge il nome del titolare dell'account
        account1.balance = 0.0; // Inizializza il saldo a 0
        account1.displayBalance(); // Mostra il saldo iniziale
        System.out.println("Benvenuto, " + account1.accountHolderName + "!"); // Messaggio di benvenuto
        */
        // Ciclo per gestire le operazioni di deposito e prelievo
        while (true) {
            System.out.println("Scegli un'operazione: 1) Deposito \n2) Prelievo \n3) Visualizza saldo \n4) Esci");
            int choice = scanner.nextInt(); // Legge la scelta dell'utente
            switch (choice) {
                case 1: // Deposito
                    System.out.print("Inserisci l'importo da depositare: ");
                    double depositAmount = scanner.nextDouble(); // Legge l'importo del deposito
                    account1.deposit(depositAmount); // Chiama il metodo di deposito
                    break;
                case 2: // Prelievo
                    System.out.print("Inserisci l'importo da prelevare: ");
                    double withdrawAmount = scanner.nextDouble(); // Legge l'importo del prelievo
                    account1.withdraw(withdrawAmount); // Chiama il metodo di prelievo
                    break;
                case 3: // Visualizza saldo
                    account1.displayBalance(); // Chiama il metodo per visualizzare il saldo
                    break;
                case 4: // Esci
                    System.out.println("Grazie per aver utilizzato il servizio!");
                    scanner.close(); // Chiude lo scanner
                    return; // Esce dal programma
                default:
                    System.out.println("Scelta non valida. Riprova."); // Messaggio di errore per scelta non valida
            }
        }
    }
}
