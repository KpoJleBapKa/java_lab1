package com.kroll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Додати нову книгу в бібліотеку");
            System.out.println("2. Показати всі книги в бібліотеці");
            System.out.println("3. Шукати книгу за назвою");
            System.out.println("4. Видалити книгу за номером ISBN");
            System.out.println("5. Реєструвати читача");
            System.out.println("6. Видавати предмет читачеві");
            System.out.println("7. Повернути предмет в бібліотеку");
            System.out.println("8. Показувати список доступних книг");
            System.out.println("9. Показувати список взятих книг та їхніх читачів");
            System.out.println("10. Додати новий DVD");
            System.out.println("11. Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищення буфера

            switch (choice) {
                case 1:
                    System.out.println("Введіть назву книги:");
                    String bookTitle = scanner.nextLine();
                    System.out.println("Введіть автора книги:");
                    String bookAuthor = scanner.nextLine();
                    System.out.println("Введіть номер ISBN книги:");
                    String bookIsbn = scanner.nextLine();
                    System.out.println("Введіть рік видання книги:");
                    int bookYear = scanner.nextInt();
                    scanner.nextLine(); // Очищення буфера
                    Book book = new Book(bookTitle, bookAuthor, bookIsbn, bookYear);
                    library.addBook(book);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.println("Введіть назву книги для пошуку:");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.findBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Знайдена книга за назвою:");
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Книгу за заданою назвою не знайдено.");
                    }
                    break;

                case 4:
                    System.out.println("Введіть номер ISBN книги для видалення:");
                    String isbnToRemove = scanner.nextLine();
                    library.removeBookByIsbn(isbnToRemove);
                    break;

                case 5:
                    System.out.println("Введіть ім'я читача:");
                    String readerName = scanner.nextLine();
                    library.registerReader(readerName);
                    break;

                case 6:
                    System.out.println("Видача предмету читачеві. Оберіть опцію:");
                    System.out.println("1. Видача книги");
                    System.out.println("2. Видача DVD");
                    int issueChoice = scanner.nextInt();
                    scanner.nextLine(); // Очищення буфера
                    System.out.println("Введіть ідентифікатор предмету:");
                    String itemIdentifier = scanner.nextLine();
                    System.out.println("Введіть ім'я читача:");
                    String reader = scanner.nextLine();
                    if (issueChoice == 1) {
                        library.issueBookToReader(itemIdentifier, reader);
                    } else if (issueChoice == 2) {
                        library.issueDVDToReader(itemIdentifier, reader);
                    } else {
                        System.out.println("Невірний вибір.");
                    }
                    break;

                case 7:
                    System.out.println("Повернення предмету в бібліотеку. Оберіть опцію:");
                    System.out.println("1. Повернення книги");
                    System.out.println("2. Повернення DVD");
                    int returnChoice = scanner.nextInt();
                    scanner.nextLine(); // Очищення буфера
                    System.out.println("Введіть ідентифікатор предмету:");
                    String itemToReturn = scanner.nextLine();
                    if (returnChoice == 1) {
                        library.returnBookToLibrary(itemToReturn);
                    } else if (returnChoice == 2) {
                        library.returnDVDToLibrary(itemToReturn);
                    } else {
                        System.out.println("Невірний вибір.");
                    }
                    break;

                case 8:
                    library.displayAvailableBooks();
                    break;

                case 9:
                    library.displayBorrowedBooks();
                    break;

                case 10:
                    System.out.println("Введіть назву DVD:");
                    String dvdTitle = scanner.nextLine();
                    System.out.println("Введіть режисера DVD:");
                    String dvdDirector = scanner.nextLine();
                    System.out.println("Введіть рік випуску DVD:");
                    String dvdReleaseYear = scanner.nextLine();
                    System.out.println("Введіть ідентифікатор DVD:");
                    String dvdIdentifier = scanner.nextLine();
                    DVD dvd = new DVD(dvdTitle, dvdDirector, dvdReleaseYear);
                    dvd.setIdentifier(dvdIdentifier);
                    library.addDVD(dvd);
                    break;

                case 11:
                    System.out.println("Дякуємо, що скористалися нашою бібліотекою.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}

