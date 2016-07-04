package org.mliuframework.demo.designpattern.behavior.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michael on 7/4/16.
 */
public class Computer extends ComputerElement {

    private List<ComputerElement> computerElementList;

    public Computer() {
        computerElementList = new LinkedList<ComputerElement>();
        computerElementList.add(new Mouse());
        computerElementList.add(new Display());
        computerElementList.add(new Keyboard());
    }

    @Override
    public void accept(ComputerElementVisitor computerElementVisitor) {
        for (ComputerElement computerElement : computerElementList) {
            computerElement.accept(computerElementVisitor);
        }
    }

}
