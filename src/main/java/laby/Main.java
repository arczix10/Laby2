package laby;

import java.util.Scanner;

/**
 * Główna klasa aplikacji zawierająca interfejs konsolowy dla użytkownika[cite: 1].
 */
public class Main {

  /**
   * Główna metoda uruchamiająca program i pętlę menu.
   *
   * @param args Argumenty wiersza poleceń (nieużywane w tym projekcie).
   */
  public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    System.out.println("Witaj w systemie bibliotecznym!");

    while (running) {
      System.out.println("\n--- MENU GŁÓWNE ---");
      System.out.println("1. Dodaj czytelnika");
      System.out.println("2. Wyświetl czytelników");
      System.out.println("3. Dodaj nowy egzemplarz książki");
      System.out.println("4. Wyświetl ogólne tytuły książek");
      System.out.println("5. Wyświetl wszystkie fizyczne egzemplarze");
      System.out.println("6. Wypożycz egzemplarz czytelnikowi");
      System.out.println("7. Sprawdź wypożyczenia czytelnika");
      System.out.println("0. Wyjście");
      System.out.print("Wybierz opcję: ");

      String choice = scanner.nextLine();

      try {
        switch (choice) {
          case "1":
            System.out.print("Podaj imię i nazwisko czytelnika: ");
            String name = scanner.nextLine();
            library.addReader(name);
            break;
          case "2":
            library.displayReaders();
            break;
          case "3":
            System.out.print("Podaj tytuł książki: ");
            String title = scanner.nextLine();
            System.out.print("Podaj autora książki: ");
            String author = scanner.nextLine();
            library.addBookCopy(title, author);
            break;
          case "4":
            library.displayBooks();
            break;
          case "5":
            library.displayAllCopies();
            break;
          case "6":
            System.out.print("Podaj ID czytelnika: ");
            int readerId = Integer.parseInt(scanner.nextLine());
            System.out.print("Podaj ID egzemplarza: ");
            int copyId = Integer.parseInt(scanner.nextLine());
            library.borrowBookCopy(readerId, copyId);
            break;
          case "7":
            System.out.print("Podaj ID czytelnika: ");
            int rId = Integer.parseInt(scanner.nextLine());
            library.displayReaderBorrowedBooks(rId);
            break;
          case "0":
            running = false;
            System.out.println("Zamykanie systemu.");
            break;
          default:
            System.out.println("Nieznana opcja. Wybierz numer od 0 do 7.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Błąd: podaj liczbę całkowitą (ID).");
      }
    }

    scanner.close();
  }
}