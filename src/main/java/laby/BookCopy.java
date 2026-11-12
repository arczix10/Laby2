package laby;

/**
 * Reprezentuje konkretny, fizyczny egzemplarz przypisany do tytułu.
 */
public class BookCopy {

  /**
   * Licznik do generowania kolejnych ID.
   */
  private static int idCounter = 1;

  /**
   * Unikalne ID tego egzemplarza.
   */
  private int copyId;

  /**
   * Tytuł książki.
   */
  private Book book;

  private boolean isBorrowed;

  /**
   * Tworzy nowy, dostępny egzemplarz dla podanej książki.
   *
   * @param book Obiekt książki z katalogu.
   */
  public BookCopy(Book book) {
    this.copyId = idCounter++;
    this.book = book;
    this.isBorrowed = false;
  }

  /**
   * Zwraca ID książki.
   */
  public int getCopyId() {
    return copyId;
  }

  /**
   * Zwraca obiekt książki.
   */
  public Book getBook() {
    return book;
  }

  /**
   * Zwraca stan wypożyczenia książki, true jeśli jest wypożyczona, false jeśli nie jest.
   */
  public boolean isBorrowed() {
    return isBorrowed;
  }

  /**
   * Zmienia stan wypożyczenia.
   */
  public void setBorrowed(boolean borrowed) {
    this.isBorrowed = borrowed;
  }

  @Override
  public String toString() {
    String status = isBorrowed ? "wypożyczony" : "dostępny";
    return "[ID Egzemplarza: " + copyId + "] " + book.getTitle() + " - " + status;
  }
}