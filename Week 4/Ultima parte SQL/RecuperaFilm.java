package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import io.github.cdimascio.dotenv.Dotenv;

public class RecuperaFilm {
    public static void main(String[] args) {
        
       Dotenv dotenv = Dotenv.configure()
        .directory("C:\\Users\\massi\\Desktop\\ProgettoJDBC\\ProgettoJDBC") // <-- directory dove si trova .env
        .load();

        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) { //Scanner dentro per la chiusura automatica alla fine del try-catch(molto comodo)
             
            //REGISTRAZIONE UTENTE (in memoria)
            System.out.println("REGISTRAZIONE UTENTE");
            System.out.print("Scegli uno username: ");
            String username = scanner.nextLine();

            String passwordUtente;
            String confermaPassword;
            do {
                System.out.print("Scegli una password: ");
                passwordUtente = scanner.nextLine();
                System.out.print("Conferma la password: ");
                confermaPassword = scanner.nextLine();
                if (!passwordUtente.equals(confermaPassword)) {
                    System.out.println("Le password non corrispondono, riprova.");
                }
            } while (!passwordUtente.equals(confermaPassword));

            System.out.println("Registrazione completata! Effettua il login.\n");

            //LOGIN
            boolean accessoConsentito = false;
            for (int tentativi = 0; tentativi < 3; tentativi++) {
                System.out.print("Inserisci username: ");
                String usernameLogin = scanner.nextLine();
                System.out.print("Inserisci password: ");
                String passwordLogin = scanner.nextLine();

                if (username.equals(usernameLogin) && passwordUtente.equals(passwordLogin)) {
                    accessoConsentito = true;
                    break;
                } else {
                    System.out.println("Username o password errati. Tentativi rimasti: " + (2 - tentativi));
                }
            }

            if (!accessoConsentito) {
                System.out.println("Accesso negato. Programma terminato.");
                return; // Esce dal programma
            }
            System.out.println("Accesso effettuato! Benvenuto " + username + "\n");

            int scelta;
            do {
                System.out.println("1. Mostra i 10 film più noleggiati");
                System.out.println("2. Mostra i 10 film meno noleggiati");
                System.out.println("0. Esci");
                System.out.print("Fai la tua scelta! ->  ");
                scelta = scanner.nextInt();
                scanner.nextLine(); // consuma newline

                switch (scelta) {
                    case 1:
                        mostraFilmNoleggiati(conn, "DESC");
                        break;
                    case 2:
                        mostraFilmNoleggiati(conn, "ASC");
                        break;
                    case 0:
                        System.out.println("Arrivederci!");
                        break;
                    default:
                        System.out.println("Scelta non valida.");
                }
            } while (scelta != 0);

        } catch (SQLException e) {
            System.out.println("Errore JDBC: " + e.getMessage());
        }
    }

    public static void mostraFilmNoleggiati(Connection conn, String ordine) {
        String query = "SELECT f.title, COUNT(r.rental_id) AS num_noleggi " + 
                       "FROM film f " +
                       "JOIN inventory i ON f.film_id = i.film_id " +
                       "JOIN rental r ON i.inventory_id = r.inventory_id " +
                       "GROUP BY f.title " +
                       "ORDER BY num_noleggi " + ordine + " " +
                       "LIMIT 10";
        //try con risorse, creo automaticamente un oggetto Statement (stmt) per mandare la query al database e un ResultSet (rs) che conterrà i risultati.
        try (Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) { //rn.next  sposta il cursore al prossimo risultato (riga della query). mi devo ricordare che inizialmente il resultSet parte prima della prima riga.
                String titolo = rs.getString("title"); //rs.getString("title") prende il titolo del film dalla colonna "title".
                int numNoleggi = rs.getInt("num_noleggi");//rs.getInt("num_noleggi") prende il numero di noleggi da quella colonna.
                System.out.println(titolo + " " + numNoleggi);
            }
        } catch (SQLException e) {
            System.out.println("Errore durante la query: " + e.getMessage());
        }
    }
}
