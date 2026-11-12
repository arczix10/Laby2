package laby;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezentuje czytelnika w systemie.
 */
public class Reader {

  /**
   * Licznik do generowania kolejnych ID czytelnika.
   */
  private static int idCounter = 1;

  /**
   * Unikalne ID czytelnika.
   */
  private int readerId;


  private String name;

  /**
   * Lista wypożyczonych egzemplarzy przez tego czytelnika[cite: 1].
   */
  private List<BookCopy> borrowedBooks;

  /**
   * Tworzy nowego czytelnika.
   */
  public Reader(String name) {
    this.readerId = idCounter++;
    this.name = name;
    this.borrowedBooks = new ArrayList<>(); // Inicjujemy pustą listę
  }

  /**
   * Zwraca Id czytelnika.
   */
  public int getReaderId() {
    return readerId;
  }

  /**
   * Zwraca imie i nazwisko.
   */
  public String getName() {
    return name;
  }

  /**
   * Zwraca listę aktualnie wyporzyczonych egzemplarzy.
   */
  public List<BookCopy> getBorrowedBooks() {
    return borrowedBooks;
  }

  /**
   * Dodaje egzemplarz do listy wypożyczonych książek czytelnika.
   */
  public void borrowBook(BookCopy copy) {
    borrowedBooks.add(copy);
  }

  @Override
  public String toString() {
    return "[ID Czytelnika: " + readerId + "] " + name + " (Wypożyczone egzemplarze: " + borrowedBooks.size() + ")";
  }
}