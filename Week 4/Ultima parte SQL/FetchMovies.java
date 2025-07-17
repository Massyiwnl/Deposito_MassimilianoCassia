package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

public class FetchMovies {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
        .directory("C:\\Users\\massi\\Desktop\\ProgettoJDBC\\ProgettoJDBC") // <-- directory dove si trova .env
        .load();

        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");


        try (Connection conn = DriverManager.getConnection(url, user, password);

             Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery("SELECT title FROM film LIMIT 5")) {


            while (rs.next()) {

                System.out.println("Film: " + rs.getString("title"));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    
    }
}
