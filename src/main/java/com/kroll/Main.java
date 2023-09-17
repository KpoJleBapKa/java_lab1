import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private final int year;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }


    public String getIsbn() {
        return isbn;
    }


    @Override
    public String toString() {
        return String.format("Назва: %s. Автор: %s. ISBN: %s. Рік: %d", title, author, isbn, year);
    }
}

class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Книгу додано до бібліотеки.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Бібліотека порожня.");
        } else {
            System.out.println("Книги в бібліотеці:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void removeBookByIsbn(String isbn) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                System.out.println("Книгу з ISBN " + isbn + " видалено.");
                return;
            }
        }
        System.out.println("Книгу з ISBN " + isbn + " не знайдено в бібліотеці.");
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вітаю!");

        while (true) {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Додати нову книгу в бібліотеку");
            System.out.println("2. Показати всі книги в бібліотеці");
            System.out.println("3. Шукати книгу за назвою");
            System.out.println("4. Видалити книгу за номером ISBN");
            System.out.println("5. Вийти");

            int option = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (option) {
                case 1:
                    System.out.print("Введіть назву книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Введіть автора книги: ");
                    String author = scanner.nextLine();
                    System.out.print("Введіть номер ISBN книги: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Введіть рік видання книги: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    library.addBook(new Book(title, author, isbn, year));
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Введіть назву книги для пошуку: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.findBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Знайдена книга за назвою \"" + searchTitle + "\":");
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Книга за назвою \"" + searchTitle + "\" не знайдена.");
                    }
                    break;
                case 4:
                    System.out.print("Введіть номер ISBN книги для видалення: ");
                    String isbnToRemove = scanner.nextLine();
                    library.removeBookByIsbn(isbnToRemove);
                    break;
                case 5:
                    System.out.println("Програма завершила роботу.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неправильний вибір опції. Спробуйте ще раз.");
            }
        }
    }
}
