package kz.attractor.java;

import java.util.List;
import java.util.Scanner;

public class Mains {

    public static void main(String[] args) {
        var cats = Cat.makeCats(10);
        Printer.print(cats);
        print("What do you want \n 1 -> sort by breed \n 2-> sort by name \n 3 -> sort by age \n 4 -> Remove by color \n 5-> Remove by more five letter :");
        int choice = new Scanner(System.in).nextInt();
        run(choice, cats);
        // А сюда добавьте код, который будет сортировать коллекцию котов
        // используйте лямбда-выражения и ссылки на методы
        //cats.sort(?);
        //Printer.print(cats);
    }

    public static void run(int choice, List<Cat> cats) {
        switch (choice) {
            case 1:
                Cat.sortByBreed(cats);
                break;
            case 2:
                Cat.sortByName(cats);
                break;
            case 3:
                Cat.sortByAge(cats);
                break;
            case 4:
                Cat.removeByColor(cats);
                break;
            case 5:
                Cat.removeByMoreFiveLetter(cats);
                break;
            default:
                print("You didn't enter correctly");
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
