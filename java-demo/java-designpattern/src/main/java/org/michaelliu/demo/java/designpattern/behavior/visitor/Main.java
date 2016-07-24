package org.michaelliu.demo.java.designpattern.behavior.visitor;

/**
 * Created by Michael on 7/4/16.
 */
public class Main {

    public static void main(String[] args) {
        ComputerElement computer = new Computer();
        computer.accept(new ComputerVisitor());
    }

}
