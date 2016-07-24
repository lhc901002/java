package org.michaelliu.demo.java.designpattern.behavior.visitor;

/**
 * Created by Michael on 7/4/16.
 */
public abstract class ComputerElement {

    protected String name;

    public String getName() {
        return name;
    }

    public abstract void accept(ComputerElementVisitor computerElementVisitor);

}
