package laby;

/**
 * Reprezentuje ogólny tytuł książki w systemie.
 */

public class Book {
  /**
   * Tytuł książki.
   */
  private String title;

  /**
   * Autor książki.
   */
  private String author;

  /**
   * Tworzy nową książkę.
   */
  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }


  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return "Książka: '" + title + "' (Autor: " + author + ")";
  }
}