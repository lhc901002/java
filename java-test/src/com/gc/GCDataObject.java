package com.gc;

/**
 * Created by Michael on 1/16/17.
 */
public class GCDataObject {
    byte[] bytes = null;
    public GCDataObject(int i){
        bytes = new byte[i *1024 * 1024];
    }
}
