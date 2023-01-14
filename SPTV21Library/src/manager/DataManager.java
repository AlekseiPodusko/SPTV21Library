package manager;


import entity.Book;
import entity.Reader;

import java.io.*;

public class DataManager {
    private final String BOOK_FILE = "files/MyBooks";
    private final String READER_FILE = "files/MyReaders";

    public DataManager(){
        File file = new File("files");
        file.mkdirs();
    }

    public void saveBooks(Book[] books) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(BOOK_FILE );
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        }
    }
    public Book[] loadBooks() {
        Book[] books = new Book[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(BOOK_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            books = (Book[]) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс");
        }
        return books;
    }

    public void saveReader(Reader[] readers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(READER_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(readers);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла MyReader");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        }
    }
    public Reader[] loadReaders() {
        Reader[] readers = new Reader[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(READER_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            readers = (Reader[]) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла MyReader");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс");
        }
        return readers;
    }




}