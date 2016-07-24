package org.michaelliu.demo.java.designpattern.creator.builder;

/**
 * Created by michael on 7/3/2016.
 */
public class Main {

    public static void main(String[] args) {
        User user = new User.Builder().setId(123L).setName("Michael").build();
        System.out.println(user);
    }
    
}
