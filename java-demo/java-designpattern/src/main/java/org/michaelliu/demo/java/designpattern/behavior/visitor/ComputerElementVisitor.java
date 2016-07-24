package org.michaelliu.demo.java.designpattern.behavior.visitor;

/**
 * Created by Michael on 7/4/16.
 */
public interface ComputerElementVisitor {

    void visit(Mouse mouse);

    void visit(Display display);

    void visit(Keyboard keyboard);

}
