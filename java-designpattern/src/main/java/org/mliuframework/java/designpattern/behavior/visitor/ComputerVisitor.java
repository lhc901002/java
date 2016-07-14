package org.mliuframework.java.designpattern.behavior.visitor;

/**
 * Created by Michael on 7/4/16.
 */
public class ComputerVisitor implements ComputerElementVisitor {

    public void visit(Mouse mouse) {
        System.out.println("Visit " + mouse.getName());
    }

    public void visit(Display display) {
        System.out.println("Visit " + display.getName());
    }

    public void visit(Keyboard keyboard) {
        System.out.println("Visit " + keyboard.getName());
    }

}
