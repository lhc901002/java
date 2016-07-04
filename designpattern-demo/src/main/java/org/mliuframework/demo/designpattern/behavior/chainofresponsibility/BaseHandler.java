package org.mliuframework.demo.designpattern.behavior.chainofresponsibility;

/**
 * Created by Michael on 7/4/16.
 */
public abstract class BaseHandler {

    protected String type;

    protected BaseHandler successor;

    abstract protected int getAllowance();

    public void setSuccessor(BaseHandler successor) {
        this.successor = successor;
    }

    public String getType() {
        return type;
    }

    public void handleRequest(int numOfRequest) {
        if (numOfRequest <= this.getAllowance()) {
            System.out.println("This request is handled by " + type);
        } else {
            System.out.println("This request cannot handled by " + type);
            if (successor != null) {
                System.out.println("This request has been delivered to " +
                        successor.getType() + " for handling!");
                successor.handleRequest(numOfRequest);
            } else {
                System.out.println("This request cannot handled!");
            }
        }
    }

}
