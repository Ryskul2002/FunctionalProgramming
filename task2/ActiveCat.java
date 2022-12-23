package kz.attractor.java;

import kz.attractor.java.interfaces.Eatable;
import kz.attractor.java.interfaces.Jumpable;
import kz.attractor.java.interfaces.Sleepable;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

// код можно менять только в особо отмеченных местах этого файла.
    // то есть там, где написаны три знака вопроса "???"
    // так же возможно вам понадобится добавить что-то в 
    // блок import и поменять имя пакета
    // в остальных местах этого файла код менять не разрешается.

public final class ActiveCat implements Jumpable, Sleepable, Eatable {
    private static final Random r = new Random();
    private static final List<String> names = List.of("Peach", "Ginger", "Toby", "Seth", "Tibbles", "Tabby", "Poppy", "Millie", "Daisy", "Jasper", "Misty", "Minka");
    private final String name;
    private String action;


    public ActiveCat(String action) {
        name = names.get(r.nextInt(names.size()));
        this.action = action;
    }

    public final String getName() {
        return name;
    }
    
    public void doAction() {
        System.out.printf("Я %s. %s%n", name, action);
    }

    /*****/
    // Действия доступные для котов

    public String jump() {
        Jumpable jumpable = () -> "I am jumping";
        return jumpable.jump();
    }

    public String sleep() {
        Sleepable sleepable = () -> "I am speeping";
        return sleepable.toString();
    }

    public String eat() {
        Eatable eatable = () -> "I am eating";
        return eatable.eat();
    }
    /*****/
}
