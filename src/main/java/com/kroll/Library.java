package com.kroll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Library {
    private final List<Book> books;
    private final List<DVD> dvds;
    private final Map<String, String> bookReaders;
    private final Map<String, String> dvdReaders;

    public Library() {
        this.books = new ArrayList<>();
        this.dvds = new ArrayList<>();
        this.bookReaders = new HashMap<>();
        this.dvdReaders = new HashMap<>();
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

    public void registerReader(String readerName) {
        System.out.println("Читач " + readerName + " зареєстрований.");
    }

    public void issueItemToReader(String itemIdentifier, String reader, Map<String, String> itemReaders) {
        for (Book book : books) {
            if (book.getIsbn().equals(itemIdentifier)) {
                if (itemReaders.containsKey(itemIdentifier)) {
                    System.out.println("Цей предмет вже видано читачеві " + itemReaders.get(itemIdentifier));
                } else {
                    itemReaders.put(itemIdentifier, reader);
                    System.out.println("Предмет видано читачеві " + reader);
                }
                return;
            }
        }

        for (DVD dvd : dvds) {
            if (dvd.getIdentifier().equals(itemIdentifier)) {
                if (itemReaders.containsKey(itemIdentifier)) {
                    System.out.println("Цей DVD вже видано читачеві " + itemReaders.get(itemIdentifier));
                } else {
                    itemReaders.put(itemIdentifier, reader);
                    System.out.println("DVD видано читачеві " + reader);
                }
                return;
            }
        }

        System.out.println("Предмет з ідентифікатором " + itemIdentifier + " не знайдено в бібліотеці.");
    }

    public void returnItemToLibrary(String itemIdentifier, Map<String, String> itemReaders) {
        if (itemReaders.containsKey(itemIdentifier)) {
            itemReaders.remove(itemIdentifier);
            System.out.println("Предмет повернено в бібліотеку.");
        } else {
            System.out.println("Цей предмет не було видано читачеві.");
        }
    }

    public void issueBookToReader(String isbn, String reader) {
        issueItemToReader(isbn, reader, bookReaders);
    }

    public void returnBookToLibrary(String isbn) {
        returnItemToLibrary(isbn, bookReaders);
    }

    public void issueDVDToReader(String identifier, String reader) {
        issueItemToReader(identifier, reader, dvdReaders);
    }

    public void returnDVDToLibrary(String identifier) {
        returnItemToLibrary(identifier, dvdReaders);
    }

    public void displayAvailableBooks() {
        System.out.println("Доступні книги в бібліотеці:");
        for (Book book : books) {
            if (!bookReaders.containsKey(book.getIsbn())) {
                System.out.println(book);
            }
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Взяті книги та їхні читачі:");
        for (Map.Entry<String, String> entry : bookReaders.entrySet()) {
            String isbn = entry.getKey();
            String reader = entry.getValue();
            Book book = findBookByISBN(isbn);
            if (book != null) {
                System.out.println("Книга: " + book.getTitle() + " (ISBN: " + isbn + ") взята читачем " + reader);
            }
        }
    }

    public void displayBorrowedItems() {
        System.out.println("Взяті книги та DVD та їхні читачі:");
        for (Map.Entry<String, String> entry : bookReaders.entrySet()) {
            String isbn = entry.getKey();
            String reader = entry.getValue();
            Book book = findBookByISBN(isbn);
            System.out.println("Книга: " + book.getTitle() + " (ISBN: " + isbn + ") взята читачем " + reader);
        }

        for (Map.Entry<String, String> entry : dvdReaders.entrySet()) {
            String identifier = entry.getKey();
            String reader = entry.getValue();
            DVD dvd = findDVDByIdentifier(identifier);
            System.out.println("DVD: " + dvd.getTitle() + " (Ідентифікатор: " + identifier + ") взято читачем " + reader);
        }
    }

    // Доданий метод для пошуку DVD за ідентифікатором
    public DVD findDVDByIdentifier(String identifier) {
        for (DVD dvd : dvds) {
            if (dvd.getIdentifier().equals(identifier)) {
                return dvd;
            }
        }
        return null;
    }


    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void addDVD(DVD dvd) {
        dvds.add(dvd);
        System.out.println("DVD додано до бібліотеки.");
    }

    public void displayDVDs() {
        if (dvds.isEmpty()) {
            System.out.println("Бібліотека DVD порожня.");
        } else {
            System.out.println("DVD в бібліотеці:");
            for (DVD dvd : dvds) {
                System.out.println(dvd);
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}




