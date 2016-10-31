package org.michaelliu.demo.java;

import com.alibaba.fastjson.JSON;
import org.michaelliu.demo.java.beans.Account;
import org.michaelliu.demo.java.beans.RspVo;

/**
 * Created by Michael on 2016/10/31.
 */
public class TestJSONUtils {

    private void testToJSONString(Object object) {
        String rsp = JSON.toJSONString(object);
        System.out.println(rsp);
    }

    public static void main(String[] args) {
        RspVo rspVo = new RspVo();
        rspVo.setData(new Account(1l, "Michael Liu"));
        rspVo.setStatus(0);
        rspVo.setStatusInfo("OK");
        // print '{"data":{"id":1,"name":"Michael Liu"},"status":0,"statusInfo":"OK"}'
        new TestJSONUtils().testToJSONString(rspVo);
    }

}
