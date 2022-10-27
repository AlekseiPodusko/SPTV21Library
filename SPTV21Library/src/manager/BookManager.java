package manager;

import entity.Author;
import entity.Book;

import java.util.Scanner;

public class BookManager {
    private Scanner scanner;

    public BookManager() {
        scanner = new Scanner(System.in);
    }

    public Book createBookWithAuthot() {
        System.out.print("Введите название книги: ");
        String bookName = scanner.nextLine();
        System.out.print("Введите год издания книги: ");
        String publishedYear = scanner.nextLine();
        System.out.print("Введите количество экземпляров книги: ");
        String quantity = scanner.nextLine();

        Book book = createBook(bookName, new Integer(quantity), Integer.parseInt(publishedYear));
        System.out.print("Введите количество авторов книги:");
        int countAuthorsInBook = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < countAuthorsInBook; i++) {
            System.out.print("Введите имя автора " + (i + 1) + ": ");
            String firstname = scanner.nextLine();
            System.out.print("Введите фамилию автора " + (i + 1) + ": ");
            String lastname = scanner.nextLine();
            System.out.print("Введите год рождения автора " + (i + 1) + ": ");
            String birthday = scanner.nextLine();
            book.addAuthor(createAuthor(firstname, lastname, new Integer(birthday)));
        }
        return book;
    }

    public void printListBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.print(i + 1 + ". " + books[i].getBookName() + ". ");
            for (int j = 0; j < books[i].getAuthors().length; j++) {
                System.out.printf("%s %s %d. ",
                        books[i].getAuthors()[j].getFirstname(),
                        books[i].getAuthors()[j].getLastname(),
                        books[i].getAuthors()[j].getBirthday());
            }
            System.out.println();
        }
    }

    public Book[] changeBook(Book[] books) {
      System.out.println("Список книг: ");
      printListBooks(books);
      System.out.print("Выберите номер книг ; ");
      int bookNumber=scanner.nextInt(); scanner.nextLine();
      System.out.println("Название; "+books[bookNumber-1].getBookName());
      System.out.println("Хотите изменить название книги (y/n)?");
      String tru= scanner.nextLine();
      if (tru.equals("y")){
          System.out.print("Введите новое имя: ");
          books[bookNumber-1].setBookName(scanner.nextLine());
      }
      System.out.println("Год публикации; "+books[bookNumber-1].getPublishedYear());
      System.out.println("Хотите изменить год публикации (y/n)?");
      String tru1= scanner.nextLine();
      if (tru1.equals("y")){
          System.out.print("Введите новой год: ");
          books[bookNumber-1]. setPublishedYear(scanner.nextInt()); scanner.nextLine();
      }
      System.out.println("Количество книг; "+books[bookNumber-1].getQuantity());
      System.out.println("Хотите изменить количество книг (y/n)?");
      String tru2= scanner.nextLine();
      if (tru2.equals("y")){
          System.out.print("Введите количество книг: ");
          books[bookNumber-1].setQuantity(scanner.nextInt()); scanner.nextLine();
      }
        return books;
    }
    public Book createBook(String bookName, int quantity, int publishedYear) {
        Book book = new Book();
        book.setBookName(bookName);
        book.setPublishedYear(publishedYear);
        book.setQuantity(quantity);
        return book;

    }

    public Author createAuthor(String firstname, String lastname, int birthday) {
        Author author = new Author();
        author.setBirthday(birthday);
        author.setFirstname(firstname);
        author.setLastname(lastname);
        return author;
    }


}
