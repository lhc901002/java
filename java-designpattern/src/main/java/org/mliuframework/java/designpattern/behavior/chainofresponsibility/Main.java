package org.mliuframework.java.designpattern.behavior.chainofresponsibility;

/**
 * Created by Michael on 7/4/16.
 */
public class Main {

    public static void main(String[] args) {
        BaseHandler normalHandler = new NormalHandler();
        BaseHandler superHandler = new SuperHandler();
        BaseHandler finalHandler = new FinalHandler();
        normalHandler.setSuccessor(superHandler);
        superHandler.setSuccessor(finalHandler);
        normalHandler.handleRequest(360000);
    }

}
