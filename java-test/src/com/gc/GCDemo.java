package com.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 1/16/17.
 */
public class GCDemo {

    public static void main(String[] args) throws InterruptedException{
        List<GCDataObject> list = new ArrayList<GCDataObject>();
        for(int i = 0 ; i < 4 ; i++) {
            list.add(new GCDataObject(2));
        }

        //表示第二次fullGC，或者MinorGC可以把他回收！
        list = null;

        List<GCDataObject> list2 = new ArrayList<GCDataObject>();
        for(int i = 0 ; i < 3 ; i++){
            list2.add(new GCDataObject(2));
        }
        list2 = null;
    }
}
