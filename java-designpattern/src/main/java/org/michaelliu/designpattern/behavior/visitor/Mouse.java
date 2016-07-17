package org.michaelliu.designpattern.behavior.visitor;

/**
 * Created by Michael on 7/4/16.
 */
public class Mouse extends ComputerElement {

    public Mouse() {
        name = "Mouse";
    }

    @Override
    public void accept(ComputerElementVisitor computerElementVisitor) {
        computerElementVisitor.visit(this);
    }

}
