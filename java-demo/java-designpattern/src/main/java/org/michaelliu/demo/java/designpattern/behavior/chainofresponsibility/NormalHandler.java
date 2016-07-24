package org.michaelliu.demo.java.designpattern.behavior.chainofresponsibility;

/**
 * Created by Michael on 7/4/16.
 */
public class NormalHandler extends BaseHandler {

    public NormalHandler() {
        this.type = "Normal Handler";
    }

    @Override
    protected int getAllowance() {
        return 5000;
    }

}
