package Test;

import java.io.Serializable;

public class Singleton implements Serializable {
    private final static Singleton singleton = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return singleton;
    }

    private Object readResolve(){
        return singleton;
    }
}
