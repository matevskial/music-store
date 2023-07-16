package com.matevskial.musicstore;

public class Main {

  public static void main(String[] args) {
    System.out.println("Music store");
    System.out.println("Artists");
    printArtists();
    System.out.println("Songs");
    printSongs();
  }

  private static void printSongs() {
    System.out.println("ID      Name");
    System.out.println("1 paradise");
    System.out.println("2 radiactive");
  }

  private static void printArtists() {
    System.out.println("ID      Name");
    System.out.println("1 coldplay");
    System.out.println("2 imagine dragon");
  }
}
