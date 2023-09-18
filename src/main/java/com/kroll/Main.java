package com.kroll;

import java.util.Scanner;

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
            scanner.nextLine();

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
