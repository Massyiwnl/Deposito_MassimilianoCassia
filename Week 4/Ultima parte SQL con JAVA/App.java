package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class App {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
        .directory("C:\\Users\\massi\\Desktop\\ProgettoJDBC\\ProgettoJDBC") // <-- directory dove si trova .env
        .load();

        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");
        
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connessione riuscita!");
        } catch (SQLException e) {
            System.out.println("Errore nella connessione");
            e.printStackTrace();
        }
    }
}
