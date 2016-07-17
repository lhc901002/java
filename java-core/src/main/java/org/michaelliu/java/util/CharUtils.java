package org.michaelliu.java.util;

import java.util.Random;

/**
 * Created by root on 16-6-12.
 */
public class CharUtils {

    public static String getRandomString(int length) {
        String str="abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < length; ++i){
            int number = random.nextInt(26);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
