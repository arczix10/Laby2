/**
 * Reprezentuje ogólny tytuł książki w systemie.
 */
public class Book {
  /** Tytuł książki. */
  private String title;

  /** Autor książki. */
  private String author;

  /**
   * Tworzy nową książkę.
   *
   * @param title Tytuł.
   * @param author Autor.
   */
  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  /** @return Tytuł książki. */
  public String getTitle() {
    return title;
  }

  /** @return Autor książki. */
  public String getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return "Książka: '" + title + "' (Autor: " + author + ")";
  }
}