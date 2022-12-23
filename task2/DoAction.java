package kz.attractor.java;

import kz.attractor.java.interfaces.*;
import kz.attractor.java.interfaces.Runnable;

public class DoAction implements Eatable, Sleepable, Jumpable, Runnable, Walkable {

    @Override
    public String jump() {
        Jumpable jumpable = () -> "I am jumping";
        return jumpable.jump();
    }
    @Override
    public String sleep() {
        Sleepable sleepable = () -> "I am sleeping";
        return sleepable.sleep();
    }
    @Override
    public String eat() {
        Eatable eatable = () -> "I am eating";
        return eatable.eat();
    }

    @Override
    public String run() {
        Runnable runnable = () -> "I am running";
        return runnable.run();
    }

    @Override
    public String walk() {
        Walkable walkable = () -> "I am walking";
        return walkable.walk();
    }
}
