package com.matevskial.musicstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

  private static Connection con;

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    initializeDatabaseConnection();

    System.out.println("Music store");
    System.out.println("Artists");
    printArtists();
    System.out.println("Songs");
    printSongs();

    deinitializeDatabaseConnection();
  }

  private static void deinitializeDatabaseConnection() throws SQLException {
    con.close();
  }

  private static void initializeDatabaseConnection() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/music-store", "root", "12345678");
  }

  private static void printSongs() {
    System.out.println("ID      Name");
    System.out.println("1 paradise");
    System.out.println("2 radiactive");
  }

  private static void printArtists() throws SQLException {
    // This syntax is actualyl try-with-resources
    // it means that in this case, after the code inside try finsihes
    // java will call statement.close()
    try(Statement statement = con.createStatement()) {
      String query = "select id, name from artists";
      System.out.println("ID      Name");
      ResultSet result = statement.executeQuery(query);
      while(result.next()) {
        System.out.println(result.getLong("id") + "    " + result.getString("name"));
      }
    }
  }
}
