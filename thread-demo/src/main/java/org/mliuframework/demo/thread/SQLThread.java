package org.mliuframework.demo.thread;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by root on 16-6-11.
 */
public class SQLThread implements Runnable {

    private BasicDataSource dataSource;

    public SQLThread(BasicDataSource dataSource) {
        this.dataSource= dataSource;
    }

    @Override
    public void run() {
        runSQL();
    }

    private void runSQL() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dataSource.getConnection();
            for (int i = 0; i < 10000; i++) {
                String sql = "insert into user(uname, create_time) values('" +
                        CharUtils.getRandomString(4) + "','" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "')";
                pstmt = connection.prepareStatement(sql);
                int rst = pstmt.executeUpdate();
                System.out.println(Thread.currentThread().getId() + "\t" + sql + "\t" + rst + "\t" +
                        dataSource.getNumActive());
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

}
