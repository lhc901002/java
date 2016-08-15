package org.michaelliu.demo.java.lang;

/**
 * Created by Michael on 8/12/16.
 */
public class ParameterExample {

    public void function(Object ... args) {
        for (Object o : args) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        new ParameterExample().function("hello", 12);
    }

}
