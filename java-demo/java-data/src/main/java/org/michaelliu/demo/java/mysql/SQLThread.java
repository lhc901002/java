package org.michaelliu.demo.java.mysql;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.java.lang.string.CharUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by root on 16-6-11.
 */
public class SQLThread implements Callable<Integer> {

    private static final Log log = LogFactory.getLog(SQLThread.class);

    private Connection connection;

    public SQLThread(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Integer call() throws Exception {
        PreparedStatement pstmt = null;
        Integer result = null;
        try {
            String sql = "insert into tb_student(s_name, s_age) values('"
                    + CharUtils.getRandomString(4) + "', " + new Random().nextInt(100) + ")";
            pstmt = connection.prepareStatement(sql);
            result = pstmt.executeUpdate();
            log.info("Thread " + Thread.currentThread().getId() + "\tTable lines get affected: " + result);
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                log.error(e);
            }
        }
        return result;
    }

}
