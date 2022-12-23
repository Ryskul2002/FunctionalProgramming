package kz.attractor.java;

import kz.attractor.java.interfaces.Jumpable;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // исправьте код так, что бы на экран выводилось что-то вроде.
        // Я Misty. Я прыгаю!
        // Я Tibbles. Я сплю!
        // Я Ginger. Я кушаю!
        // для решения примените лямбда-выражения, 
        
        // каждый кот должен уметь выполнять что-то своё
        var cats = new ArrayList<ActiveCat>();
        DoAction action = new DoAction();
        cats.add(new ActiveCat(action.eat()));
        cats.add(new ActiveCat(action.jump()));
        cats.add(new ActiveCat(action.sleep()));
        cats.add(new ActiveCat(action.run()));
        cats.add(new ActiveCat(action.walk()));
        // добавьте ещё два-три кота, с совершенно другими действиями

        cats.forEach(ActiveCat::doAction);
    }
}
