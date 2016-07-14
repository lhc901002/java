package org.mliuframework.java.designpattern.behavior.visitor;

/**
 * Created by Michael on 7/4/16.
 */
public class Display extends ComputerElement {

    public Display() {
        name = "Display";
    }

    @Override
    public void accept(ComputerElementVisitor computerElementVisitor) {
        computerElementVisitor.visit(this);
    }

}
