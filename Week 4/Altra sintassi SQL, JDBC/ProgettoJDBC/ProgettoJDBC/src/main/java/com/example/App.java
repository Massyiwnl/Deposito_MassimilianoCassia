package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sakila"; // <-- Usa 'sakila' come DB
        String user = "root";      // Cambia se usi un altro utente
        String password = "***";      // Metti la password giusta

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connessione riuscita!");
        } catch (SQLException e) {
            System.out.println("Errore nella connessione");
            e.printStackTrace();
        }
    }
}
