package kz.attractor.java;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Mains {

    public static void main(String[] args) {
        var cats = Cat.makeCats(10);
        Printer.print(cats);
        print("What do you want \n 1 -> sort by breed \n 2-> sort by name \n 3 -> sort by age \n 4 -> Remove by color \n 5-> Remove by more five letter :");
       try {
           int choice = new Scanner(System.in).nextInt();
           run(choice, cats);
       } catch (Exception e) {
           e.printStackTrace();
       }
        // А сюда добавьте код, который будет сортировать коллекцию котов
        // используйте лямбда-выражения и ссылки на методы
        //cats.sort(?);
        //Printer.print(cats);
    }

    public static void run(int choice, List<Cat> cats) {
        switch (choice) {
            case 1:
                Printer.print(Cat.sortByBreed(cats));
                break;
            case 2:
                Printer.print(Cat.sortByName(cats));
                break;
            case 3:
                Printer.print(Cat.sortByAge(cats));
                break;
            case 4:
                Printer.print(Cat.removeByColor(cats));
                break;
            case 5:
                Printer.print(Cat.removeByMoreFiveLetter(cats));
                break;
            default:
                print("You didn't enter correctly");
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
