package org.mliuframework.java.designpattern.behavior.visitor;

/**
 * Created by Michael on 7/4/16.
 */
public class Keyboard extends ComputerElement {

    public Keyboard() {
        name = "Keyboard";
    }

    @Override
    public void accept(ComputerElementVisitor computerElementVisitor) {
        computerElementVisitor.visit(this);
    }

}
