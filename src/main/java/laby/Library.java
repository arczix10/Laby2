package laby;

import java.util.ArrayList;
import java.util.List;

/**
 * Główna klasa systemu zarządzająca danymi biblioteki.
 * Przechowuje dane w pamięci operacyjnej, bez zapisu na dysk[cite: 1].
 */
public class Library {

  /**
   * Lista unikalnych tytułów książek w katalogu.
   */
  private List<Book> books;

  /**
   * Lista wszystkich wprowadzonych czytelników.
   */
  private List<Reader> readers;

  /**
   * Lista wszystkich fizycznych egzemplarzy w systemie.
   */
  private List<BookCopy> allCopies;

  /**
   * Inicjuje nowy, pusty system biblioteczny.
   */
  public Library() {
    this.books = new ArrayList<>();
    this.readers = new ArrayList<>();
    this.allCopies = new ArrayList<>();
  }

  /**
   * Zwraca liste ksiazek.
   */
  public List<Book> getBooks() {
    return books;
  }

  /**
   * Zwraca czytelników.
   */
  public List<Reader> getReaders() {
    return readers;
  }

  /**
   * Zwraca liste egzeplarzy.
   */
  public List<BookCopy> getAllCopies() {
    return allCopies;
  }

  /**
   * Dodaje nowego czytelnika do systemu bibliotecznego.
   */
  public void addReader(String name) {
    Reader newReader = new Reader(name);
    readers.add(newReader);
    System.out.println("Dodano czytelnika: " + newReader.getName());
  }

  /**
   * Wyświetla wszystkich czytelników zarejestrowanych w systemie.
   * Jeśli lista jest pusta, wypisuje odpowiedni komunikat.
   */
  public void displayReaders() {
    System.out.println("--- Lista czytelników ---");
    if (readers.isEmpty()) {
      System.out.println("Brak czytelników.");
    } else {
      for (Reader reader : readers) {
        System.out.println(reader.toString());
      }
    }
    System.out.println("-------------------------");
  }

  /**
   * Dodaje nowy tytuł książki do katalogu systemu.
   *
   * @param title  Tytuł nowej książki.
   * @param author Autor nowej książki.
   */
  public void addBookTitle(String title, String author) {
    Book newBook = new Book(title, author);
    books.add(newBook);
    System.out.println("Dodano tytuł książki: " + newBook.getTitle() + " (" + newBook.getAuthor() + ")");
  }

  /**
   * Wyświetla wszystkie ogólne tytuły książek zarejestrowane w systemie.
   * Jeśli lista jest pusta, wypisuje odpowiedni komunikat.
   */
  public void displayBooks() {
    System.out.println("--- Lista tytułów książek ---");
    if (books.isEmpty()) {
      System.out.println("Brak książek.");
    } else {
      for (Book book : books) {
        System.out.println(book.toString());
      }
    }
    System.out.println("-----------------------------");
  }

  /**
   * Wyszukuje tytuł książki w systemie na podstawie jej tytułu.
   *
   * @return Obiekt książki, jeśli zostanie znaleziona, lub null w przeciwnym razie.
   */
  private Book findBookByTitle(String title) {
    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        return book;
      }
    }
    return null;
  }

  /**
   * Dodaje nowy egzemplarz dla podanego tytułu książki.
   * Jeśli tytułu nie ma w systemie, automatycznie go tworzy.
   */
  public void addBookCopy(String title, String author) {
    Book book = findBookByTitle(title);

    if (book == null) {
      System.out.println("Tytuł '" + title + "' nie istnieje.");
      book = new Book(title, author);
      books.add(book);
    }

    // Tworzymy fizyczny egzemplarz dla tej książki
    BookCopy newCopy = new BookCopy(book);
    allCopies.add(newCopy);
    System.out.println("Dodano egzemplarz: " + newCopy.toString());
  }

  /**
   * Wyświetla wszystkie egzemplarze książek znajdujące się w systemie.
   * Jeśli lista jest pusta, wypisuje komunikat.
   */
  public void displayAllCopies() {
    System.out.println("--- Lista wszystkich egzemplarzy ---");
    if (allCopies.isEmpty()) {
      System.out.println("Brak wprowadzonych egzemplarzy.");
    } else {
      for (BookCopy copy : allCopies) {
        System.out.println(copy.toString());
      }
    }
    System.out.println("------------------------------------");
  }

  /**
   * Wyszukuje czytelnika w systemie na podstawie jego identyfikatora.
   *
   * @param readerId Identyfikator szukanego czytelnika.
   * @return Obiekt czytelnika lub null, jeśli nie zostanie znaleziony.
   */
  private Reader findReaderById(int readerId) {
    for (Reader reader : readers) {
      if (reader.getReaderId() == readerId) {
        return reader;
      }
    }
    return null;
  }

  /**
   * Wyszukuje fizyczny egzemplarz w systemie na podstawie jego identyfikatora.
   *
   * @param copyId Identyfikator szukanego egzemplarza.
   * @return Obiekt egzemplarza lub null, jeśli nie zostanie znaleziony.
   */
  private BookCopy findCopyById(int copyId) {
    for (BookCopy copy : allCopies) {
      if (copy.getCopyId() == copyId) {
        return copy;
      }
    }
    return null;
  }

  /**
   * Przypisuje konkretny egzemplarz książki do wybranego czytelnika.
   * Zmienia status egzemplarza i dodaje go do listy wypożyczeń czytelnika.
   *
   * @param readerId Identyfikator czytelnika wypożyczającego książkę.
   * @param copyId   Identyfikator wypożyczanego egzemplarza.
   */
  public void borrowBookCopy(int readerId, int copyId) {
    Reader reader = findReaderById(readerId);
    BookCopy copy = findCopyById(copyId);

    if (reader == null) {
      System.out.println("Błąd: Nie znaleziono czytelnika");
      return;
    }

    if (copy == null) {
      System.out.println("Błąd: Nie znaleziono egzemplarza");
      return;
    }

    if (copy.isBorrowed()) {
      System.out.println("Błąd: Egzemplarz jest już wypożyczony przez kogoś innego.");
      return;
    }

    copy.setBorrowed(true);
    reader.borrowBook(copy);
    System.out.println("Sukces: Czytelnik " + reader.getName() + " wypożyczył książkę '" + copy.getBook().getTitle() + "'.");
  }

  /**
   * Wyświetla wszystkie egzemplarze aktualnie wypożyczone przez wybranego czytelnika.
   *
   * @param readerId Identyfikator czytelnika, którego wypożyczenia chcemy sprawdzić.
   */
  public void displayReaderBorrowedBooks(int readerId) {
    Reader reader = findReaderById(readerId);

    if (reader == null) {
      System.out.println("Błąd: Nie znaleziono czytelnika o ID " + readerId);
      return;
    }

    System.out.println("--- Wypożyczenia czytelnika: " + reader.getName() + " ---");

    // czy lista wypożyczonych jest pusta
    if (reader.getBorrowedBooks().isEmpty()) {
      System.out.println("Ten czytelnik nie ma obecnie wypożyczonych żadnych książek.");
    } else {
      //pętla przechodząca przez listę wypożyczeń
      for (BookCopy copy : reader.getBorrowedBooks()) {
        System.out.println(copy.toString());
      }
    }
    System.out.println("-------------------------------------------------");
  }

}