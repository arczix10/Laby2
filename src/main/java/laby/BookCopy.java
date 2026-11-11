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
   * Powiązany tytuł książki.
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
   *
   * @return ID egzemplarza.
   */
  public int getCopyId() {
    return copyId;
  }

  /**
   * Zwraca obiekt książki.
   *
   * @return Obiekt przypisanej książki.
   */
  public Book getBook() {
    return book;
  }

  /**
   * Zwraca stan wypożyczenia książki.
   *
   * @return true jeśli wypożyczony, false jeśli leży na półce.
   */
  public boolean isBorrowed() {
    return isBorrowed;
  }

  /**
   * Zmienia stan wypożyczenia.
   *
   * @param borrowed Nowy status wypożyczenia (true/false).
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