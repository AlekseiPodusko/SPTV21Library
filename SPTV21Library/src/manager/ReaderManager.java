package manager;

import entity.Author;
import entity.Reader;
import entity.History;
import java.util.Scanner;

public class ReaderManager {
    private Scanner scanner;



    public ReaderManager() {
        scanner = new Scanner(System.in);

    }
    public Reader createReader() {
        Reader reader = new Reader();
        System.out.print("Введите имя читателя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Введите телефон читателя: ");
        reader.setPhone(scanner.nextLine());

        return reader;
    }

    public void printListReaders(Reader[] readers) {
        for (int i = 0; i < readers.length; i++) {
            System.out.printf("%d. %s %s. Телефон: %s%n"
                    , i + 1
                    , readers[i].getFirstname()
                    , readers[i].getLastname()
                    , readers[i].getPhone()
            );
        }

    }
   public Reader[] changeReader(Reader[] readers) {
      System.out.println("Список  читателя: ");
      printListReaders(readers);
      System.out.print("Выберите номер читателя; ");
      int readerNumber=scanner.nextInt(); scanner.nextLine();
      System.out.println("Имя; "+readers[readerNumber-1].getFirstname());
      System.out.println("Хотите изменить имя(y/n)?");
      String yes= scanner.nextLine();
      if (yes.equals("y")){
          System.out.print("Введите новое имя: ");
          readers[readerNumber-1].setFirstname(scanner.nextLine());
      }
      System.out.println("Фамилия; "+readers[readerNumber-1].getLastname());
      System.out.println("Хотите изменить фамилию(y/n)?");
      String yes1= scanner.nextLine();
      if (yes1.equals("y")){
          System.out.print("Введите новое фамилию: ");
          readers[readerNumber-1].setLastname(scanner.nextLine());
      }
      System.out.println("Телефон; "+readers[readerNumber-1].getPhone());
      System.out.println("Хотите изменить телефон(y/n)?");
      String yes2= scanner.nextLine();
      if (yes2.equals("y")){
          System.out.print("Введите новое телефон: ");
          readers[readerNumber-1].setPhone(scanner.nextLine());
      }
      return readers;
    }
}
