package kz.attractor.java;

public class Mains {

    public static void main(String[] args) {


        var cats = Cat.makeCats(10);
        Printer.print(cats);
        Cat.sortByBreed(cats);
        Cat.sortByName(cats);
        Cat.removeByColor(cats);
        run();
        // А сюда добавьте код, который будет сортировать коллекцию котов
        // используйте лямбда-выражения и ссылки на методы
        //cats.sort(?);
        //Printer.print(cats);
    }

    public static void run() {

    }


}
