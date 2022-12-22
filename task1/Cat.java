package kz.attractor.java;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    // код можно менять только в особо отмеченном месте этого файла,
    // так же возможно вам понадобится добавить что-то в 
    // блок import и поменять имя пакета
    // в остальных местах этого файла код менять не разрешается.

final class Cat {
    private static final Random r = new Random();
    private static final List<String> names = List.of("Peach", "Ginger", "Toby", "Seth", "Tibbles", "Tabby", "Poppy", "Millie", "Daisy", "Jasper", "Misty", "Minka");
    private final String name;
    private final int age;
    private final Breed breed;
    private final Color color;

    private Cat() {
        name = names.get(r.nextInt(names.size()));
        age = r.nextInt(10) + 1;
        breed = Breed.values()[r.nextInt(Breed.values().length)];
        color = Color.values()[r.nextInt(Color.values().length)];
    }

    public static final List<Cat> makeCats(int amount) {
        // это называется конвейерная обработка.
        // будем проходить на одном из занятий
        return Stream.generate(Cat::new)
                .limit(amount)
                .collect(Collectors.toList());
    }

    public final Color getColor() {
        return color;
    }

    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    public final Breed getBreed() {
        return breed;
    }



    enum Color {
        TABBY, SILVER, GRAY, PEACH, GINGER, TORTIE
    }

    enum Breed {
        SPHINX, BRITAIN, SCOTTISH, VULGARIS, ORIENTAL
    }

    /*********/

    public static void sortByBreed(List<Cat> cat) {
        List<Cat> list = new ArrayList<>(cat);
        list.sort((s1, s2) -> s1.getBreed().name().compareTo(s2.getBreed().name()));
        System.out.println("------Sort by Breed-----");
        Printer.print(list);
    }

    public static void sortByName(List<Cat> cat) {
        List<Cat> list = new ArrayList<>(cat);
        list.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("------Sort by Name-----");
        Printer.print(list);
    }

    public static void removeByColor(List<Cat> cat) {
        List<Cat> list = new ArrayList<>(cat);
        System.out.println("------Remove by color-----");
        list.removeIf((s1) -> s1.getColor().name().equals("SILVER"));
        Printer.print(list);
    }

//    @Override
//    public int compareTo(Cat o) {
//        return this.getBreed().name().compareTo(o.getBreed().name());
//    }

    // Ваш код может находится здесь
    // остальную часть этого файла вы менять не можете

    /*********/
}
