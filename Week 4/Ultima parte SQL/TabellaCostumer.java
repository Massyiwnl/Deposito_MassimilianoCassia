package com.example; 

// Import delle classi necessarie per JDBC e utility
import java.sql.Connection; // Oggetto che rappresenta la connessione al database
import java.sql.DriverManager; // Classe che serve a ottenere la connessione
import java.sql.PreparedStatement; // Permette di eseguire query SQL parametrizzate
import java.sql.ResultSet; // Rappresenta il risultato di una query SQL
import java.sql.SQLException; // Gestisce eventuali errori SQL
import java.util.Scanner; // Per input da tastiera

import io.github.cdimascio.dotenv.Dotenv; // Libreria per leggere le variabili dal file .env

public class TabellaCostumer {

    // Metodo principale
    public static void main(String[] args) {
        // Caricamento delle variabili di ambiente dal file .env
        Dotenv dotenv = Dotenv.configure()
            .directory("C:\\Users\\massi\\Desktop\\ProgettoJDBC\\ProgettoJDBC") // Specifica dove trovare il file .env
            .load();

        // Recupero delle informazioni di connessione al DB dal file .env
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        // apre la connessione e lo scanner e li chiude automaticamente alla fine
        try (
            Connection conn = DriverManager.getConnection(url, user, password); // Connessione al database MySQL
            Scanner scanner = new Scanner(System.in) // Scanner per leggere da tastiera
        ) {
            // *** FASE 1: Registrazione utente (salvata in memoria, non in database) ***
            System.out.println("REGISTRAZIONE UTENTE");
            System.out.print("Scegli uno username: ");
            String username = scanner.nextLine();

            String passwordUtente;
            String confermaPassword;
            // Ciclo per confermare che la password inserita e la conferma siano uguali
            do {
                System.out.print("Scegli una password: ");
                passwordUtente = scanner.nextLine();
                System.out.print("Conferma la password: ");
                confermaPassword = scanner.nextLine();
                if (!passwordUtente.equals(confermaPassword)) {
                    System.out.println("Le password non corrispondono, riprova.");
                }
            } while (!passwordUtente.equals(confermaPassword)); // Ripeti finché le password non corrispondono

            System.out.println("Registrazione completata! Effettua il login.\n");

            // *** FASE 2: Login utente (verifica in memoria) ***
            boolean accessoConsentito = false; // Variabile di controllo per l'accesso
            for (int tentativi = 0; tentativi < 3; tentativi++) { // Consenti 3 tentativi di login
                System.out.print("Inserisci username: ");
                String usernameLogin = scanner.nextLine();
                System.out.print("Inserisci password: ");
                String passwordLogin = scanner.nextLine();

                // Confronta username e password con quelli salvati nella registrazione
                if (username.equals(usernameLogin) && passwordUtente.equals(passwordLogin)) {
                    accessoConsentito = true; // Accesso riuscito
                    break; // Esci dal ciclo
                } else {
                    System.out.println("Username o password errati. Tentativi rimasti: " + (2 - tentativi));
                }
            }

            // Se login non riuscito dopo 3 tentativi, esci dal programma
            if (!accessoConsentito) {
                System.out.println("Accesso negato. Programma terminato.");
                return;
            }
            System.out.println("Accesso effettuato! Benvenuto " + username + "\n");

            // *** FASE 3: Menu di gestione clienti ***
            int scelta;
            do {
                // Stampa le opzioni del menu
                System.out.println("MENU GESTIONE CLIENTI SAKILA");
                System.out.println("1. Mostra clienti con nome che inizia per 'A'");
                System.out.println("2. Mostra numero di clienti per città");
                System.out.println("3. Mostra i 5 clienti più recenti");
                System.out.println("4. Mostra tutti i clienti ordinati per data");
                System.out.println("0. Esci");
                System.out.print("Fai la tua scelta! ->  ");
                // Controlla che l'input sia un intero valido
                while (!scanner.hasNextInt()) {
                    System.out.print("Inserisci un numero valido: ");
                    scanner.next();
                }
                scelta = scanner.nextInt(); // Legge la scelta dell'utente
                scanner.nextLine(); // Consuma il carattere newline rimasto

                // Esegue l'opzione scelta dall'utente usando uno switch
                switch (scelta) {
                    case 1:
                        mostraClientiNomeA(conn); // Mostra clienti con nome che inizia per 'A'
                        break;
                    case 2:
                        mostraClientiPerCitta(conn); // Mostra numero di clienti per città
                        break;
                    case 3:
                        mostraClientiRecenti(conn); // Mostra i 5 clienti più recenti
                        break;
                    case 4:
                        mostraClientiOrdinati(conn); // Mostra tutti i clienti ordinati per data
                        break;
                    case 0:
                        System.out.println("Arrivederci!"); // Uscita dal programma
                        break;
                    default:
                        System.out.println("Scelta non valida."); // Gestione scelte non valide
                }
                System.out.println(); // Riga vuota per separare i menu
            } while (scelta != 0); // Ripeti finché l'utente non sceglie "0"

        } catch (SQLException e) {
            System.out.println("Errore JDBC: " + e.getMessage()); // Gestione errori JDBC
        }
    }

    //1 Clienti con nome che inizia per 'A' 
    public static void mostraClientiNomeA(Connection conn) {
        // Query SQL: seleziona nome e cognome dei clienti il cui nome inizia per 'A'
        String query = "SELECT first_name, last_name FROM customer WHERE first_name LIKE 'A%'";
        //try con risorse, creo automaticamente un oggetto Statement per mandare 
        //la query al database e un ResultSet (rs) che conterrà i risultati
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) { //rn.next  sposta il cursore al prossimo risultato (riga della query). 
                //mi devo ricordare che inizialmente il resultSet parte prima della prima riga.
            System.out.println("\nClienti con nome che inizia per 'A':");
            boolean trovato = false; // Flag per verificare se è stato trovato almeno un cliente
            while (rs.next()) { // Scorre tutte le righe del risultato (ResultSet)
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
                trovato = true;
            }
            if (!trovato) System.out.println("Nessun cliente trovato.");
        } catch (SQLException e) {
            System.out.println("Errore query: " + e.getMessage()); // Gestione errori SQL
        }
    }

    //2 Numero di clienti per città 
    public static void mostraClientiPerCitta(Connection conn) {
        // Query SQL: conta quanti clienti ci sono in ogni città
        String query = 
        "SELECT city.city, COUNT(*) AS num_clienti " + // Seleziona il nome della città e conta i clienti
        "FROM customer " + // Dalla tabella customer
        "JOIN address ON customer.address_id = address.address_id " + // Collega address tramite address_id
        "JOIN city ON address.city_id = city.city_id " + // Collega city tramite city_id
        "GROUP BY city.city " + // Raggruppa i risultati per città
        "ORDER BY num_clienti DESC"; // Ordina in base al numero di clienti (dal più al meno numeroso)

        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("\nNumero di clienti per città:");
            while (rs.next()) {
                // Stampa il nome della città e il numero di clienti
                System.out.println("" + rs.getString("city") + " " + rs.getInt("num_clienti"));
            }
        } catch (SQLException e) {
            System.out.println("Errore query: " + e.getMessage());
        }
    }

    // 3 5 clienti più recenti (per create_date)
    public static void mostraClientiRecenti(Connection conn) {
        // Query SQL: seleziona i 5 clienti più recenti in base alla data di creazione
        String query = "SELECT first_name, last_name, create_date FROM customer ORDER BY create_date DESC LIMIT 5";
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("\n5 clienti più recenti:");
            while (rs.next()) {
                // Stampa nome, cognome e data di creazione del cliente
                System.out.println(rs.getString("first_name") + " " +
                                   rs.getString("last_name") + " - " +
                                   rs.getTimestamp("create_date"));
            }
        } catch (SQLException e) {
            System.out.println("Errore query: " + e.getMessage());
        }
    }

    // 4 Tutti i clienti ordinati per data (dal più vecchio al più recente)
    public static void mostraClientiOrdinati(Connection conn) {
        // Query SQL: seleziona tutti i clienti ordinati per data crescente
        String query = "SELECT first_name, last_name, create_date FROM customer ORDER BY create_date ASC";
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("\nClienti ordinati per data (vecchio -> recente):");
            while (rs.next()) {
                // Stampa nome, cognome e data di creazione del cliente
                System.out.println(rs.getString("first_name") + " " +
                                   rs.getString("last_name") + " - " +
                                   rs.getTimestamp("create_date"));
            }
        } catch (SQLException e) {
            System.out.println("Errore query: " + e.getMessage());
        }
    }
}
