package org.mliuframework.java.designpattern.behavior.chainofresponsibility;

/**
 * Created by Michael on 7/4/16.
 */
public class SuperHandler extends BaseHandler {

    public SuperHandler() {
        this.type = "Super Handler";
    }

    @Override
    protected int getAllowance() {
        return 50000;
    }

}
