

package sptv21library;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Arrays;
import java.util.Scanner;
import manager.BookManager;
import manager.DataManager;
import manager.HistoryManager;
import manager.ReaderManager;


public class App {
    private final Scanner scanner;
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    private final HistoryManager historyManager;
    private Book[] books;
    private Reader[] readers;
    private History[] histories;
    private final DataManager dataManager;

    public App() {
        scanner = new Scanner(System.in);
        dataManager = new DataManager();
        books = dataManager.loadBooks();
        readers = dataManager.loadReaders();
        histories = new History[0];
        bookManager = new BookManager();
        readerManager = new ReaderManager();
        historyManager = new HistoryManager();
        DataManager dataManager = new DataManager();
    }
    
    public void run(){
        boolean repeat = true;
        do{
            System.out.println("Задачи: ");
            System.out.println("0. Закончить программу");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Выдать книгу");
            System.out.println("4. Вернуть книгу");
            System.out.println("5. Список выданных книг");
            System.out.println("6. Список книг");
            System.out.println("7. Список читателей");
            System.out.println("8. Редактировать книгу");
            System.out.println("9. Редактировать читателя");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1. Добавить книгу");
                    addBook(bookManager.createBookWithAuthors());

                    dataManager.saveBooks(books);
                    break;
                case 2:
                    System.out.println("2. Добавить читателя");
                    addReader(readerManager.createReader());

                    dataManager.saveReader(readers);
                    break;
                case 3:
                    System.out.println("3. Выдать книгу");
                    addHistory(historyManager.takeOnBook(books, readers));
                    break;
                case 4: 
                    System.out.println("4. Вернуть книгу");
                    histories = historyManager.returnBook(histories);
                    break;
                case 5: 
                    System.out.println("5. Список выданных книг");
                    historyManager.printReadingBooks(histories);
                    break;
                case 6:
                    System.out.println("6. Список книг");
                    bookManager.printListBooks(books);
                    break;
                case 7:
                    System.out.println("7. Список читателей");
                    readerManager.printListReaders(readers);
                    break;
                case 8:
                    System.out.println("8. Редактирование книги");
                    this.books = bookManager.changeBook(books);
                    break;
                case 9:
                    System.out.println("8. Редактирование читателя");
                    this.readers = readerManager.changeReader(readers);
                    break;
                default:
                    System.out.println("Выберите задачу из списка!");;
            }
        }while(repeat);
        System.out.println("Закрытие программы, пока!");
    }

    private void addBook(Book book) {
        this.books = Arrays.copyOf(this.books, this.books.length+1);
        this.books[this.books.length - 1] = book;   
    }
    private void addReader(Reader reader) {
        this.readers = Arrays.copyOf(this.readers, this.readers.length+1);
        this.readers[this.readers.length - 1] = reader;   
    }
    private void addHistory(History histories) {
        this.histories = Arrays.copyOf(this.histories, this.histories.length+1);
        this.histories[this.histories.length - 1] = histories;   
    }
}